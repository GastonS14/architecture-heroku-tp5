package com.integrador4.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.integrador4.entity.Client;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema( name = "Client Request", description = "Client request for add/update a client")
public class ClientRequest {

	private final String name;
	private final String surname;

	public ClientRequest(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Client toClient(Integer id) {
		return new Client(id, this.getName(), this.getSurname());
	}

	public Client toClient() {
		return new Client(this.getName(), this.getSurname());
	}
}
