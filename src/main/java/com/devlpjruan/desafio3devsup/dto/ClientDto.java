package com.devlpjruan.desafio3devsup.dto;

import java.time.LocalDate;

import com.devlpjruan.desafio3devsup.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class ClientDto {

	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String cpf;
	
	private Double income;
	@PastOrPresent
	private LocalDate birthDate;
	private Integer children;
	
	public ClientDto() {
	}

	public ClientDto(Client entity) {
		id= entity.getId();
		name= entity.getName();
		cpf= entity.getCpf();
		income= entity.getIncome();
		birthDate= entity.getBirthDate();
		children = entity.getChildren();
	}
	
	

	public ClientDto(Long id, String name, String cpf, Double income, LocalDate bithDate, Integer children) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = bithDate;
		this.children = children;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}
	
	
}
