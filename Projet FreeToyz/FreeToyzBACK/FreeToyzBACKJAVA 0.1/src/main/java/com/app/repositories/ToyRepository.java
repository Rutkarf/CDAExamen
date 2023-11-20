package com.app.repositories;

import com.app.models.Toy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyRepository extends JpaRepository<Toy, Long> {
    // Définissez les méthodes personnalisées si nécessaire
}