package com.app.controllers.client;

import com.app.exceptions.toyNotFoundException;
import com.app.services.client.ClientService;
import com.app.services.client.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("toystore/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public boolean add(@RequestBody ClientDTO clientDTO){
        ClientServiceModel clientServiceModel = new ClientServiceModel(clientDTO.getName(), clientDTO.getFirstname(), clientDTO.getEmail(), clientDTO.getAdresse());
        return clientService.add(clientServiceModel);

    }

    @GetMapping
    public ArrayList<ClientGetDTO> findAll(){

        ArrayList<ClientGetDTO> clientGetDTOS = new ArrayList<>();

        ArrayList<ClientServiceModel> clientServiceModels = clientService.findAll() ;

//        toyServiceModels.forEach((item)->System.out.println(item.toString()));

        clientServiceModels.forEach((item)->clientGetDTOS.add(new ClientGetDTO(item.getId().get(), item.getName(), item.getFirstname(), item.getEmail(), item.getAdresse())) );

        return clientGetDTOS;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientServiceModel> findById(@PathVariable Long id){
        try{
            ClientServiceModel clientServiceModel =  clientService.findById(id);
//            return new ResponseEntity<>(new ClientGetDTO(clientServiceModel.getId().get(), clientServiceModel.getName(),clientServiceModel.getFirstname(),clientServiceModel.getEmail(),clientServiceModel.getAdresse()), HttpStatus.OK) ; // *** mappage à revoir
            return new ResponseEntity<>(clientServiceModel, HttpStatus.OK) ;
        }catch(toyNotFoundException ex){

            System.out.println(ex.getReason());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getReason() );
        }
    }

    @PutMapping   // update
    public ResponseEntity<String> updatetoy(
            @RequestBody ClientGetDTO clientGetDTO
            ){
        if (clientService.findById( clientGetDTO.getId() ) != null ){
            ClientServiceModel clientServiceModel = new ClientServiceModel( Optional.ofNullable(clientGetDTO.getId()), clientGetDTO.getName(), clientGetDTO.getFirstname(), clientGetDTO.getEmail(), clientGetDTO.getAdresse() );

            clientService.update( clientServiceModel );

            return new ResponseEntity<>("Le toy id : " + Optional.ofNullable(clientGetDTO.getId()) +" a été modifié", HttpStatus.OK) ;
        }else{
            throw new toyNotFoundException(HttpStatus.NOT_FOUND, "La ressource n'a pas été trouvé");
        }

    }
}
