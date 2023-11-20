package com.app.services;

import com.app.models.Toy;

import com.app.repositories.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToyService {

    private ToyRepository toyRepository = null;

    @Autowired
    public <ToyRepository> ToyService() {
    }

    public List<Toy> getAllToys() {
        return toyRepository.findAll();
    }

    public Optional<Toy> getToyById(Long id) {
        return toyRepository.findById(id);
    }

    public Toy createToy(Toy toy) {
        return toyRepository.save(toy);
    }

    public Toy updateToy(Long id, Toy updatedToy) {
        if (toyRepository.existsById(id)) {
            updatedToy.setId(id);
            return toyRepository.save(updatedToy);
        } else {
            throw new IllegalArgumentException("Toy with ID " + id + " not found.");
        }
    }

    public void deleteToy(Long id) {
        toyRepository.deleteById(id);
    }

    public List<Toy> searchToys(String searchTerm) {
        return null;
    }

    public Toy getToyByName(String testToy) {
        return null;
    }
}
