package com.app.validacion.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class DataInfo {
	
	@JsonProperty("data")
	private JsonNode  data;

	public JsonNode getData() {
		return data;
	}

	public void setData(JsonNode data) {
		this.data = data;
	}

	public DataInfo(JsonNode data) {
		super();
		this.data = data;
	}

	public DataInfo() {
		super();
	}

	

	
}
