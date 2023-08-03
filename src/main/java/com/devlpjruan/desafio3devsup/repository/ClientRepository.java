package com.devlpjruan.desafio3devsup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devlpjruan.desafio3devsup.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
