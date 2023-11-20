package com.app.repositories.client;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface ClientRepository extends CrudRepository<ClientRepositoryModel, Long> {

    ArrayList<ClientRepositoryModel> findAll();
    
}
