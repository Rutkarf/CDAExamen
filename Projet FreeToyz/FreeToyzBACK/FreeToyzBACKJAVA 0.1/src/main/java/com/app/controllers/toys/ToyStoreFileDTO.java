package com.app.controllers.toys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToyStoreFileDTO {
        private String name;
        private String genre;
        private int quantite;
        private Float prix;
        private MultipartFile picture;
}
