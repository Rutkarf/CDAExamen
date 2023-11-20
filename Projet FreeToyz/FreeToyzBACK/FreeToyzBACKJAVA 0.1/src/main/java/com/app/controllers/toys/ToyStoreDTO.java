package com.app.controllers.toys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//public record toyStoreDTO(String name, String genre) {
//
//}



// @ Value de springboot
//// si on recoit des valeurs de ce type
//////
//public record toyStoreDTO(String name, String genre, @Value("${url.genre}") String urlGenre) {
//}
@Data
@NoArgsConstructor
@AllArgsConstructor
public class toyStoreDTO {

    private String name;
    private String genre;
    private int quantite;
    private Float prix;
    private String picture;


}
