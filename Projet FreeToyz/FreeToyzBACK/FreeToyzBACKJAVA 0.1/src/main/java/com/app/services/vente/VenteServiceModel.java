package com.app.services.vente;

import com.app.services.client.ClientServiceModel;
import com.app.services.toys.ToyServiceModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteServiceModel {

    private Optional<Long> id;
    private Long dateDeVente;
    private ToyServiceModel dvdServiceModel;
    private int quantite;
    private ClientServiceModel clientServiceModel;
    private Float montant;

    public VenteServiceModel(int quantite) {
        this.quantite = quantite;
    }

    public VenteServiceModel(ToyServiceModel dvdServiceModel, int quantite, ClientServiceModel clientServiceModel) {
        this.dvdServiceModel = dvdServiceModel;
        this.quantite = quantite;
        this.clientServiceModel = clientServiceModel;
    }

    public VenteServiceModel(Long dateDeVente, ToyServiceModel dvdServiceModel, int quantite, ClientServiceModel clientServiceModel) {
        this.dateDeVente = dateDeVente;
        this.dvdServiceModel = dvdServiceModel;
        this.quantite = quantite;
        this.clientServiceModel = clientServiceModel;
    }

    public VenteServiceModel(Long dateDeVente, ToyServiceModel dvdServiceModel, int quantite, ClientServiceModel clientServiceModel, Float montant) {
        this.dateDeVente = dateDeVente;
        this.dvdServiceModel = dvdServiceModel;
        this.quantite = quantite;
        this.clientServiceModel = clientServiceModel;
        this.montant = montant;
    }
}
