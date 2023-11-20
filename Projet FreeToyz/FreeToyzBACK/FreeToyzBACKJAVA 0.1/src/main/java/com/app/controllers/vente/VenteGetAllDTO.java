package com.app.controllers.vente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteGetAllDTO {
    private Long id;
    private Long dateDeVente;
    private Long toystore_id;
    private String toystore_name;
    private int quantite;
    private Long client_id;
    private String client_name;
    private Float montant;
}
