package com.devlpjruan.desafio3devsup.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devlpjruan.desafio3devsup.Service.exceptions.DatabaseException;
import com.devlpjruan.desafio3devsup.Service.exceptions.ResourceNotFoundException;
import com.devlpjruan.desafio3devsup.dto.ClientDto;
import com.devlpjruan.desafio3devsup.entities.Client;
import com.devlpjruan.desafio3devsup.repository.ClientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServiceClient {

	@Autowired
	private ClientRepository repositoryClient;

	@Transactional
	public ClientDto findById(Long id) {
		Client client = repositoryClient.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new ClientDto(client);
	}

	@Transactional
	public Page<ClientDto> findAll(Pageable pageable) {
		Page<Client> client = repositoryClient.findAll(pageable);

		return client.map(x -> new ClientDto(x));
	}

	@Transactional
	public ClientDto insert(ClientDto dto) {
		try {
		Client client = new Client();
		DtoEntity(dto, client);
		client = repositoryClient.save(client);
		return new ClientDto(client);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
			
		}
	}
	
	@Transactional
	public ClientDto updateClient(Long id, ClientDto dto){
		try {
		Client client = repositoryClient.getReferenceById(id);
		DtoEntity(dto, client);
		client = repositoryClient.save(client);
		return new ClientDto(client);
	}catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException("Recurso não encontrado");
	}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void deleteClient(Long id) {
		try {
		repositoryClient.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
		catch (Exception e) {
			throw new DatabaseException("Falha na integridade referencial");
		}
	}
	
	
	public void DtoEntity(ClientDto dto, Client entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity.setIncome(dto.getIncome());
	}
}
