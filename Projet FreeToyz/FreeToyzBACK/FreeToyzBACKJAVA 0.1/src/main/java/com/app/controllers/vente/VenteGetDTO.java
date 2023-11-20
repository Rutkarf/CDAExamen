package com.app.controllers.vente;

import com.app.controllers.client.ClientGetDTO;
import com.app.controllers.toys.toyStoreGetDTO;


public record VenteGetDTO (Long id, Long dateDeVente, toyStoreGetDTO toyStoreGetDTO, int quantite, ClientGetDTO clientGetDTO, Float montant){}
