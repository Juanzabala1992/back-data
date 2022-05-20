package com.app.validacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AppVaidacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppVaidacionApplication.class, args);
	}

}
