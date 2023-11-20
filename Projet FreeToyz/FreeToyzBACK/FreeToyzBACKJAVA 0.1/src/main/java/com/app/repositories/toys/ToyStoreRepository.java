package com.app.repositories.toys;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ToyStoreRepository extends CrudRepository<ToyRepositoryModel,Long>{

//   ToyRepositoryModel save(ToyRepositoryModel ToyRepositoryModel);
    ArrayList<ToyRepositoryModel> findAll();




}
