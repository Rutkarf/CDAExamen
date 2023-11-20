package com.app.controllers.toys;

import com.app.exceptions.ToyNotFoundException;
import com.app.services.toys.ToyServiceModel;
import com.app.services.toys.ToyStoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController // donnees json ou xml
@RequestMapping("toystore/toys")
public class toyStoreController {
    @Autowired
    ToyStoreService toyStoreService;

    @PostMapping     // insert
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> add(  @RequestParam("name") String name,
                      @RequestParam("genre") String genre,
                      @RequestParam("quantite") int quantite,
                      @RequestParam("prix") Float prix,
                      @RequestPart("file") Optional<MultipartFile> file
                      ){
        if(!file.isEmpty()){
            if(toyStoreService.uploadPicture(file.get())){
                toyStoreService.add(new ToyServiceModel(name, genre,quantite,prix,file.get().getOriginalFilename()));
            };
        }
        return new ResponseEntity<>("Le toy  " + name +" a été ajoutée", HttpStatus.OK) ;
    }

    @GetMapping         // getAll
    public ArrayList<ToyStoreGetDTO> findAll(){

        ArrayList<ToyStoreGetDTO> toyStoreDTOSs = new ArrayList<>();

        ArrayList<ToyServiceModel> toyServiceModels = toyStoreService.findAll() ;

//        toyServiceModels.forEach((item)->System.out.println(item.toString()));

        toyServiceModels.forEach((item)->toyStoreDTOSs.add(new ToyStoreGetDTO(item.getId().get(), item.getName(), item.getGenre(), item.getQuantite(), item.getPrix(), item.getPicture())) );

        return toyStoreDTOSs;
    }

    @GetMapping("/{id}")   // findById
    public ResponseEntity<ToyStoreGetDTO> findById(@PathVariable Long id){
        try{
                ToyServiceModel toyServiceModel =  toyStoreService.findById(id);
//                toyStoreDTO toyStoreDTO = new toyStoreDTO(toyServiceModel.getName(),toyServiceModel.getGenre(),toyServiceModel.getQuantite(),toyServiceModel.getPrix(),toyServiceModel.getPicture());
                return new ResponseEntity<>(new ToyStoreGetDTO( toyServiceModel.getId().get(), toyServiceModel.getName(),toyServiceModel.getGenre(),toyServiceModel.getQuantite(),toyServiceModel.getPrix(),toyServiceModel.getPicture()), HttpStatus.OK) ;

            }catch(toyNotFoundException ex){

            System.out.println(ex.getReason());
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, ex.getReason() );

            }
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestParam String name){
        System.out.println(id + " " + name);
    }
//    @PutMapping("/{id}")    // update
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public ResponseEntity<toyStoreGetDTO> updatetoy(
//            @PathVariable("id") Optional<Long> id,
//            @RequestParam("name") String name,
//            @RequestParam("genre") String genre,
//            @RequestParam("quantite") int quantite,
//            @RequestParam("prix") Float prix,
//            @RequestParam("picture") String picture,
//            @RequestPart("file") Optional<MultipartFile> file
//    ){
//        System.out.println(name);
//        if (toyStoreService.findById( id.get()) != null ){
//            toyServiceModel toyServiceModel = new toyServiceModel(id, name, genre, quantite, prix, picture);
//            if(!file.isEmpty()){
//                //  ***  TODO **** il faut effacer l'ancienne image  ****
//                toyStoreService.uploadPicture(file.get()); // charger l'image
//                toyServiceModel.setPicture(file.get().getOriginalFilename()); // mettre à jour le nom de picture
//            }
//            toyStoreService.update( toyServiceModel );
//
//            return new ResponseEntity<>( new toyStoreGetDTO(id.get(), name, genre, quantite,prix, picture),HttpStatus.OK) ;
//        }else{
//            throw new toyNotFoundException(HttpStatus.NOT_FOUND, "La ressource n'a pas été trouvé");
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        if(toyStoreService.findById(id) != null ){
            toyStoreService.delete(id);
            return new ResponseEntity<>("le toy id : " + id + " a été supprimé", HttpStatus.OK);
        }else{
         //  throw new NotFoundException(id);
            return new ResponseEntity<>("le toy id : " + id + " n'a pas été trouvé", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public String deleteAll(){
            return toyStoreService.deleteAll();
    }


}

//        if (toyStoreService.findById(id ) != null ){
//            toyServiceModel toyServiceModel =  toyStoreService.findById(id);
//            toyStoreDTO.setName(toyServiceModel.getName()) ;
//            toyStoreDTO.setGenre(toyServiceModel.getGenre());
//        return new ResponseEntity<>(toyStoreDTO, HttpStatus.OK) ;
//        }else{
//        throw new toyNotFoundException(id);
//        }
//    @PutMapping("/{id}")
//    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody toyStoreDTO toyStoreDTO) throws toyNotFoundException {
//
//        //        toyStoreDTO toyStoreDTO = new toyStoreDTO();
//
//        if (toyStoreService.findById(id ) != null ){
//            toyServiceModel toyServiceModel = new toyServiceModel(Optional.ofNullable(id), toyStoreDTO.getName(), toyStoreDTO.getGenre(), toyStoreDTO.getQuantite(), toyStoreDTO.getPrix(), toyStoreDTO.getPicture());
//            toyStoreService.update(id, toyServiceModel);
//
//            return new ResponseEntity<>("Le toy id : " + id +" a été modifié", HttpStatus.OK) ;
//        }else{
//            throw new toyNotFoundException(HttpStatus.NOT_FOUND, "La ressource n'a pas été trouvé");
//        }
//    }

//    @PostMapping  //
//    public boolean add(@RequestBody toyStoreFileDTO toyStoreFileDTO )
//    {
//        String fileName = toyStoreFileDTO.getPicture().getOriginalFilename();// nom fichier téléchargé
//
//        toyStoreService.uploadImage(toyStoreFileDTO.getPicture());
//
//        toyServiceModel toyServiceModel = new toyServiceModel(toyStoreFileDTO.getName(), toyStoreFileDTO.getGenre(), toyStoreFileDTO.getQuantite(), toyStoreFileDTO.getPrix(), fileName);
//
//        return toyStoreService.add(toyServiceModel);
//    }

