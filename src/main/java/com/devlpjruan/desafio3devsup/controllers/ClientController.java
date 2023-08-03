package com.devlpjruan.desafio3devsup.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devlpjruan.desafio3devsup.Service.ServiceClient;
import com.devlpjruan.desafio3devsup.dto.ClientDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired 
	private ServiceClient service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDto> findIdClient(@PathVariable Long id){
		ClientDto dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<Page<ClientDto>> findAll(Pageable pageable){
		Page<ClientDto> dto = service.findAll(pageable);
		return ResponseEntity.ok(dto);
		}
	@PostMapping
	public ResponseEntity<ClientDto> insertClient(@Valid @RequestBody ClientDto dto){
		dto = service.insert(dto);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	                .buildAndExpand(dto.getId()).toUri();
	        return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @Valid @RequestBody ClientDto dto){
		 dto = service.updateClient(id, dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable Long id){
		service.deleteClient(id);
		return ResponseEntity.noContent().build();
	}
}
