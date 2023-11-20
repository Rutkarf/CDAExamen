package com.app.repositories.vente;

import com.app.repositories.client.ClientRepositoryModel;
import com.app.repositories.toys.toyRepositoryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vente")
public class VenteRepositoryModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

//    @CreationTimestamp
    @Column(name="date_de_vente")
    Long dateDeVente;

    @ManyToOne
    @JoinColumn(name = "toystore_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private toyRepositoryModel toyRepositoryModel;

    @Column(name="quantite")
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientRepositoryModel clientRepositoryModel;

    @JoinColumn(name="montant")
    Float montant;

    public VenteRepositoryModel(int quantite) {
        this.quantite = quantite;
    }

    public VenteRepositoryModel(Long date, toyRepositoryModel toyRepositoryModel, int quantite, ClientRepositoryModel clientRepositoryModel) {
        this.dateDeVente = date;
        this.toyRepositoryModel = toyRepositoryModel;
        this.quantite = quantite;
        this.clientRepositoryModel = clientRepositoryModel;
    }

    public VenteRepositoryModel(toyRepositoryModel toyRepositoryModel, int quantite, ClientRepositoryModel clientRepositoryModel) {
        this.toyRepositoryModel = toyRepositoryModel;
        this.quantite = quantite;
        this.clientRepositoryModel = clientRepositoryModel;
    }

    public VenteRepositoryModel(Long dateDeVente, toyRepositoryModel toyRepositoryModel, int quantite, ClientRepositoryModel clientRepositoryModel, Float montant) {
        this.dateDeVente = dateDeVente;
        this.toyRepositoryModel = toyRepositoryModel;
        this.quantite = quantite;
        this.clientRepositoryModel = clientRepositoryModel;
        this.montant = montant;
    }
}
