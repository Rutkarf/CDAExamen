package com.app.services.toys;

import com.app.repositories.toys.toyRepositoryModel;
import com.app.repositories.toys.toyStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ToyStoreService {

    @Autowired
    toyStoreRepository toyStoreRepository;

    public boolean add(ToyServiceModel toyServiceModel){

        toyRepositoryModel toyRepositoryModel = new toyRepositoryModel( toyServiceModel.getName(), toyServiceModel.getGenre(),toyServiceModel.getQuantite(), toyServiceModel.getPrix(), toyServiceModel.getPicture());
        toyRepositoryModel toyRepositoryModelReturn = toyStoreRepository.save( toyRepositoryModel);

        return toyRepositoryModelReturn != null ;

    }

    public ArrayList<ToyServiceModel> findAll() {

        ArrayList<ToyServiceModel> toyServiceModels = new ArrayList<>();

        ArrayList<toyRepositoryModel> toyRepositoryModels = toyStoreRepository.findAll();

        //toyRepositoryModels.forEach((item)->System.out.println(item.toString()));
        toyRepositoryModels.forEach( (item)->toyServiceModels.add(new ToyServiceModel( Optional.ofNullable(item.getId()), item.getName(), item.getGenre(), item.getQuantite(), item.getPrix(), item.getPicture())) );

        return toyServiceModels;
    }

    public ToyServiceModel findById(Long id) {

        Optional<toyRepositoryModel> toyRepositoryModel = toyStoreRepository.findById(id);

        if(toyRepositoryModel.isEmpty())
        {
            return null;
        } else {
            return new ToyServiceModel(Optional.ofNullable(toyRepositoryModel.get().getId()), toyRepositoryModel.get().getName(),toyRepositoryModel.get().getGenre(), toyRepositoryModel.get().getQuantite(), toyRepositoryModel.get().getPrix(), toyRepositoryModel.get().getPicture());
        }
    }

    public boolean update( ToyServiceModel toyServiceModel ) {

//        Optional<toyRepositoryModel> toyRepositoryModel = toyStoreRepository.findById(id);

        if(!toyStoreRepository.existsById(toyServiceModel.getId().get()))
        {
            return false;

        } else {
            toyRepositoryModel toyRepositoryModel = new toyRepositoryModel(toyServiceModel.getId().get(),toyServiceModel.getName(),toyServiceModel.getGenre(),toyServiceModel.getQuantite(),toyServiceModel.getPrix(), toyServiceModel.getPicture());

            toyRepositoryModel toyRepositoryModelReturned = toyStoreRepository.save( toyRepositoryModel);

            return toyRepositoryModelReturned != null ;
        }
    }

    public void delete(Long id) {
        toyStoreRepository.deleteById(id);
    }

    public String deleteAll() {
        toyStoreRepository.deleteAll();
        return "La bdd a été effacée.";
    }

    public String uploadImage( MultipartFile file){
        try {
            // Spécifiez le chemin où vous souhaitez enregistrer l'image téléchargée.
            String uploadDirectory = "chemin/vers/votre/dossier";

            // Obtenez le nom du fichier téléchargé.
            String fileName = file.getOriginalFilename();

            // Créez un objet File pour enregistrer l'image dans le dossier spécifié.
            File targetFile = new File(uploadDirectory, fileName);

            // Vérifiez si le dossier cible existe. Sinon, créez-le.
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }

            // Enregistrez l'image dans le dossier cible.
            file.transferTo(targetFile);
            return "L'image a été téléchargée avec succès.";

        } catch (IOException e) {
            e.printStackTrace();
            return "Erreur lors du téléchargement de l'image.";
        }
    }
    public boolean uploadPicture( MultipartFile file) {
        System.out.println(file);
        try {
            String uploadDirectory = "/public/upload"; // dossier de chargement
            String filename = file.getOriginalFilename(); // nom fichier chargé
            Path path = Paths.get(".", uploadDirectory).toAbsolutePath(); // absolute path
            File targetFile = new File(path.toString(), filename);
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            file.transferTo(targetFile);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

}

//        if ( toyStoreRepository.existsById(id) ){
//            toyRepositoryModel toyRepositoryModel = new toyRepositoryModel();
//            toyRepositoryModel = toyStoreRepository.findById(id).get();
//            toyServiceModel toyServiceModel = new toyServiceModel(Optional.ofNullable(toyRepositoryModel.getId()), toyRepositoryModel.getName(), toyRepositoryModel.getGenre());
//            return toyServiceModel;
//        }else{
//           toyServiceModel toyServiceModel = new toyServiceModel();
//           return toyServiceModel;
//}
