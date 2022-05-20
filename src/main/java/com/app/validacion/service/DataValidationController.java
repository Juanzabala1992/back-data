package com.app.validacion.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.validacion.DTO.DataInfo;
import com.fasterxml.jackson.annotation.JsonProperty;


@RestController
public class DataValidationController {	
	

	@PostMapping("/valid")
	@CrossOrigin(origins = "http://localhost:4200")
	@JsonProperty("data")
	public String[] validElement(@RequestBody DataInfo info) throws JSONException {	
		
		
		StringBuilder sb = new StringBuilder(info.getData().toString());
		sb.deleteCharAt(sb.length() - 1);
		sb.deleteCharAt(0);

			int count = 0;			
			String value = sb.toString();
			double numberFinal=0, suma=0;
			String[] lista = value.split("\\b\\-");
			String[] num = new String[lista.length];
			String [] negative = new String [1];
			for(int i=0;i<lista.length;i++) {				
			  int validate = lista[i].indexOf(",");			  
				if(validate>=0) {					 
					num[count] =  lista[i];					
					count++;
				}if(validate<0){
					numberFinal = Double.parseDouble(lista[i]);					
					if (numberFinal<1) {						
						negative[0] = "Numero negativo";
						return negative;
					}else {
						suma = numberFinal+suma;
					}					
				}					
			}
			double raiz = Math.sqrt(suma);
			if(raiz>0 && count==0) {
				String raizResult =Double.toString(raiz);
				String[] result = new String  [1];
				result[0]= raizResult;				
				return result;
			}else {
				//String[] result = Stream.of(num, negative).flatMap(Stream::of).toArray(String[]::new);
				return num;
			}

	}
}
