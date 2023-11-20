package com.app.services.toys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToyServiceModel {

        public Optional<Long> id;
        private String name;
        private String genre;
        private int quantite;
        private Float prix;
        private String picture;


        public ToyServiceModel(String name, String genre) {
                this.name = name;
                this.genre = genre;
        }

        public ToyServiceModel(String name, String genre, int quantite) {
                this.name = name;
                this.genre = genre;
                this.quantite = quantite;
        }

        public ToyServiceModel(String name, String genre, int quantite, Float prix) {
                this.name = name;
                this.genre = genre;
                this.quantite = quantite;
                this.prix = prix;
        }

        public ToyServiceModel(String name, String genre, int quantite, Float prix, String picture) {
                this.name = name;
                this.genre = genre;
                this.quantite = quantite;
                this.prix = prix;
                this.picture = picture;
        }

        @Override
        public String toString() {
                return "ToyServiceModel{" +
                        "name='" + name + '\'' +
                        ", genre='" + genre + '\'' +
                        '}';
        }

}
