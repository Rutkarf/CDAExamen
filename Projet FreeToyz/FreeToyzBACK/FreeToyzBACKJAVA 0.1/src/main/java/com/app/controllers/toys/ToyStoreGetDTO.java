package com.app.controllers.toys;

public record ToyStoreGetDTO(Long id, String name, String genre, int quantite, Float prix, String picture) {
}
