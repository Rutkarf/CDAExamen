package com.app.controllers.vente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteDTO {
    private Long dateDeVente;
    private Long toystore_id;
    private int quantite;
    private Long client_id;
    private Float montant;
    public VenteDTO(int quantite) {
        this.quantite = quantite;
    }

    public VenteDTO(Long toystore_id, int quantite, Long client_id) {
        this.toystore_id = toystore_id;
        this.quantite = quantite;
        this.client_id = client_id;
    }
}
