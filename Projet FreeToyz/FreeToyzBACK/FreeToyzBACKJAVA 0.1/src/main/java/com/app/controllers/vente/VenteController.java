package com.app.controllers.vente;

import com.app.controllers.client.ClientGetDTO;
import com.app.controllers.toys.toyStoreGetDTO;

import com.app.services.client.ClientService;
import com.app.services.toys.ToyServiceModel;
import com.app.services.toys.ToyStoreService;
import com.app.services.vente.VenteService;
import com.app.services.vente.VenteServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@CrossOrigin
@RestController
@RequestMapping("toystore/ventes")
public class VenteController {
    @Autowired
    VenteService venteService;
    @Autowired
    ToyStoreService toyStoreService;
    @Autowired
    ClientService clientService;

    @PostMapping
    public boolean add(@RequestBody VenteAddDTO venteAddDTO){

        String dateStr = venteAddDTO.getDateDeVente()+ " 00:00:00"; // Exemple de chaîne de caractères de date

        // Créez un objet SimpleDateFormat pour spécifier le format de la chaîne de caractères
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long milliseconds = 0L;
        try {
            // Utilisez la méthode parse pour convertir la chaîne de caractères en une date
            Date date = dateFormat.parse(dateStr);

            // Obtenez le temps en millisecondes
            milliseconds = date.getTime();

            System.out.println("Date en millisecondes : " + milliseconds);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ToyServiceModel toyServiceModel = toyStoreService.findById(venteAddDTO.gettoystore_id());

        VenteServiceModel venteServiceModel = new VenteServiceModel(milliseconds, toyServiceModel,
        venteAddDTO.getQuantite(), clientService.findById(venteAddDTO.getClient_id()));
        return venteService.add(venteServiceModel);
    }

    @GetMapping
    public ArrayList<VenteGetAllDTO> findAll(){
        ArrayList<VenteGetAllDTO> venteGetAllDTOS = new ArrayList<>();
        ArrayList<VenteServiceModel> venteServiceModels = venteService.findAll() ;

//        venteServiceModels.forEach((item)->{
        for ( VenteServiceModel item : venteServiceModels) {

            toyStoreGetDTO toyStoreGetDTO = new toyStoreGetDTO(item.gettoyServiceModel().getId().get(), item.gettoyServiceModel().getName(), item.gettoyServiceModel().getGenre(), item.gettoyServiceModel().getQuantite(), item.gettoyServiceModel().getPrix(), item.gettoyServiceModel().getPicture());

            ClientGetDTO clientGetDTO = new ClientGetDTO(item.getClientServiceModel().getId().get(), item.getClientServiceModel().getName(), item.getClientServiceModel().getFirstname(), item.getClientServiceModel().getEmail(), item.getClientServiceModel().getAdresse());

            venteGetAllDTOS.add(new VenteGetAllDTO(item.getId().get(), item.getDateDeVente(), toyStoreGetDTO.id(), toyStoreGetDTO.name(), item.getQuantite(), clientGetDTO.getId(), clientGetDTO.getName(), item.getMontant()));
           }
        return venteGetAllDTOS;
    }


    //get all sales per client by name/id
//    @GetMapping("/client/{id}")
//    public ArrayList<VenteGetDTO> findAllById(@PathVariable Long id){
//        ArrayList<VenteGetDTO> venteGetDTOS = new ArrayList<>();
//        ArrayList<VenteServiceModel> venteServiceModels = venteService.findAllById(id) ;
//        System.out.println("hello world");
//        for ( VenteServiceModel item : venteServiceModels) {
//            toyStoreGetDTO toyStoreGetDTO = new toyStoreGetDTO(item.gettoyServiceModel().getId().get(), item.gettoyServiceModel().getName(), item.gettoyServiceModel().getGenre(), item.gettoyServiceModel().getQuantite(), item.gettoyServiceModel().getPrix());
//
//            ClientGetDTO clientGetDTO = new ClientGetDTO(item.getClientServiceModel().getId().get(), item.getClientServiceModel().getName(), item.getClientServiceModel().getFirstname(), item.getClientServiceModel().getEmail(), item.getClientServiceModel().getAdresse());
//
//            venteGetDTOS.add(new VenteGetDTO(item.getId().get(), item.getDateDeVente(), toyStoreGetDTO, item.getQuantite(), clientGetDTO, item.getMontant()));
//        }
//        return venteGetDTOS;
//    }
    @GetMapping("/client/{id}")
    public ArrayList<VenteGetDTO> findAllByIdClient(@PathVariable("id") Long id){
        ArrayList<VenteGetDTO> venteGetDTOS = new ArrayList<>();
        ArrayList<VenteServiceModel> venteServiceModels = venteService.findAllByClientId(id) ;

        for ( VenteServiceModel item : venteServiceModels) {
            toyStoreGetDTO toyStoreGetDTO = new toyStoreGetDTO(item.gettoyServiceModel().getId().get(), item.gettoyServiceModel().getName(), item.gettoyServiceModel().getGenre(), item.gettoyServiceModel().getQuantite(), item.gettoyServiceModel().getPrix(), item.gettoyServiceModel().getPicture());

            ClientGetDTO clientGetDTO = new ClientGetDTO(item.getClientServiceModel().getId().get(), item.getClientServiceModel().getName(), item.getClientServiceModel().getFirstname(), item.getClientServiceModel().getEmail(), item.getClientServiceModel().getAdresse());

            venteGetDTOS.add(new VenteGetDTO(item.getId().get(), item.getDateDeVente(), toyStoreGetDTO, item.getQuantite(), clientGetDTO, item.getMontant()));
        }

        return venteGetDTOS;
    }

    // get all sales per toy name/id
    @GetMapping("/toy/{name}")
    public ArrayList<VenteGetDTO> findAllBytoyName(@PathVariable("name") String name){
        ArrayList<VenteGetDTO> venteGetDTOS = new ArrayList<>();
        ArrayList<VenteServiceModel> venteServiceModels = venteService.findAllSalesBytoyName(name);

        for ( VenteServiceModel item : venteServiceModels) {
            toyStoreGetDTO toyStoreGetDTO = new toyStoreGetDTO(item.gettoyServiceModel().getId().get(), item.gettoyServiceModel().getName(), item.gettoyServiceModel().getGenre(), item.gettoyServiceModel().getQuantite(), item.gettoyServiceModel().getPrix(), item.gettoyServiceModel().getPicture());

            ClientGetDTO clientGetDTO = new ClientGetDTO(item.getClientServiceModel().getId().get(), item.getClientServiceModel().getName(), item.getClientServiceModel().getFirstname(), item.getClientServiceModel().getEmail(), item.getClientServiceModel().getAdresse());

            venteGetDTOS.add(new VenteGetDTO(item.getId().get(), item.getDateDeVente(), toyStoreGetDTO, item.getQuantite(), clientGetDTO, item.getMontant()));
        }
        return venteGetDTOS;
    }




}
