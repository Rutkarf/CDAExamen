package com.simplon.dvdstore.repositories.dvds;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Table(name="dvdstore")
public class DvdRepositoryModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="genre")
    private String genre;
    @Column(name="quantite")
    private int quantite;
    @Column(name="prix")
    private Float prix;
    @Column(name = "picture")
    private String picture;

    public DvdRepositoryModel(){};


    public DvdRepositoryModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public DvdRepositoryModel(Long id, String name, String genre) {
    }

    public DvdRepositoryModel(String name, String genre, int quantite) {
        this.name = name;
        this.genre = genre;
        this.quantite = quantite;
    }

    public DvdRepositoryModel(String name, String genre, int quantite, Float prix, String picture) {
        this.name = name;
        this.genre = genre;
        this.quantite = quantite;
        this.prix = prix;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "DvdRepositoryModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
