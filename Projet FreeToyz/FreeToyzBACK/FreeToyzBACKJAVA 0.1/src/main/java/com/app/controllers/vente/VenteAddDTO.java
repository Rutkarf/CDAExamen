
package com.app.controllers.vente;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteAddDTO {
    private String dateDeVente;
    private Long toystore_id;
    private int quantite;
    private Long client_id;

}
