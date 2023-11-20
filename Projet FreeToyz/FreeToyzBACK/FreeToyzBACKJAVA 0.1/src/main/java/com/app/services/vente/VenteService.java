package com.app.services.vente;

import com.app.repositories.client.ClientRepository;
import com.app.repositories.client.ClientRepositoryModel;
import com.app.repositories.toys.ToyRepositoryModel;
import com.app.repositories.toys.ToyStoreRepository;
import com.app.repositories.vente.VenteRepository;
import com.app.repositories.vente.VenteRepositoryModel;
import com.app.services.client.ClientServiceModel;
import com.app.services.toys.ToyServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;


@Service
public class VenteService {

    @Autowired
    VenteRepository venteRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ToyStoreRepository toyStoreRepository;

    public boolean add(VenteServiceModel venteServiceModel) {

        Optional<ToyRepositoryModel> toyRepositoryModel = toyStoreRepository.findById(venteServiceModel.getToyServiceModel().getId().get() );
        Optional<ClientRepositoryModel> clientRepositoryModel = clientRepository.findById(venteServiceModel.getClientServiceModel().getId().get());

        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel( venteServiceModel.getDateDeVente(),toyRepositoryModel.get(), venteServiceModel.getQuantite(), clientRepositoryModel.get(), venteServiceModel.getQuantite()*toyRepositoryModel.get().getPrix() );

        VenteRepositoryModel venteRepositoryReturned = venteRepository.save(venteRepositoryModel);
        return venteRepositoryReturned != null ;
    }

    public ArrayList<VenteServiceModel> findAll(){
        ArrayList<VenteServiceModel> venteServiceModels = new ArrayList<>();
        ArrayList<VenteRepositoryModel> venteRepositoryModels = venteRepository.findAll();

        venteRepositoryModels.forEach( (item)->{
            ToyServiceModel toyServiceModel = new ToyServiceModel(Optional.ofNullable(item.gettoyRepositoryModel().getId()),item.gettoyRepositoryModel().getName(), item.gettoyRepositoryModel().getGenre(), item.gettoyRepositoryModel().getQuantite(),item.gettoyRepositoryModel().getPrix(), item.gettoyRepositoryModel().getPicture());

            ClientServiceModel clientServiceModel = new ClientServiceModel(Optional.ofNullable(item.getClientRepositoryModel().getId()),item.getClientRepositoryModel().getFirstname(), item.getClientRepositoryModel().getName(), item.getClientRepositoryModel().getEmail(), item.getClientRepositoryModel().getAdresse());

            venteServiceModels.add(new VenteServiceModel( Optional.ofNullable(item.getId()), item.getDateDeVente(), toyServiceModel, item.getQuantite(), clientServiceModel, item.getMontant()));
        });

        return venteServiceModels;
    }


//    public ArrayList<VenteServiceModel> findAllById(Long id) {
//        ArrayList<VenteServiceModel> venteServiceModels = new ArrayList<>();
//        ArrayList<VenteRepositoryModel> venteRepositoryModels = venteRepository.findAll();
//
//        for (VenteRepositoryModel item : venteRepositoryModels) {
//            if(Objects.equals(item.getClientRepositoryModel().getId(), id)){
//                toyServiceModel toyServiceModel = new toyServiceModel(Optional.ofNullable(item.gettoyRepositoryModel().getId()),item.gettoyRepositoryModel().getName(), item.gettoyRepositoryModel().getGenre(), item.gettoyRepositoryModel().getQuantite(), item.gettoyRepositoryModel().getPrix());
//
//                ClientServiceModel clientServiceModel = new ClientServiceModel(Optional.ofNullable(item.getClientRepositoryModel().getId()),item.getClientRepositoryModel().getFirstname(), item.getClientRepositoryModel().getName(), item.getClientRepositoryModel().getEmail(), item.getClientRepositoryModel().getAdresse());
//
//                venteServiceModels.add(new VenteServiceModel( Optional.ofNullable(item.getId()), item.getDateDeVente(), toyServiceModel, item.getQuantite(), clientServiceModel, item.getMontant()));
//
//            }
//        }
//        return venteServiceModels;
//    }

    public ArrayList<VenteServiceModel> findAllByClientId(Long id) {
        ArrayList<VenteServiceModel> venteServiceModels = new ArrayList<>();
        ArrayList<VenteRepositoryModel> venteRepositoryModels = venteRepository.findAllByClient(id);

        for (VenteRepositoryModel item : venteRepositoryModels) {
            ToyServiceModel toyServiceModel = new ToyServiceModel(Optional.ofNullable(item.gettoyRepositoryModel().getId()),item.gettoyRepositoryModel().getName(), item.gettoyRepositoryModel().getGenre(), item.gettoyRepositoryModel().getQuantite(), item.gettoyRepositoryModel().getPrix(), item.gettoyRepositoryModel().getPicture());

            ClientServiceModel clientServiceModel = new ClientServiceModel(Optional.ofNullable(item.getClientRepositoryModel().getId()),item.getClientRepositoryModel().getFirstname(), item.getClientRepositoryModel().getName(), item.getClientRepositoryModel().getEmail(), item.getClientRepositoryModel().getAdresse());

            venteServiceModels.add(new VenteServiceModel( Optional.ofNullable(item.getId()), item.getDateDeVente(), toyServiceModel, item.getQuantite(), clientServiceModel, item.getMontant()));

        }
        return venteServiceModels;
    }


    public ArrayList<VenteServiceModel> findAllSalesBytoyName(String name){
        ArrayList<VenteServiceModel> venteServiceModels = new ArrayList<>();
        ArrayList<VenteRepositoryModel> venteRepositoryModels = venteRepository.findAll();

        for (VenteRepositoryModel item : venteRepositoryModels) {
            System.out.println(item.gettoyRepositoryModel().getName());
            if(Objects.equals(item.gettoyRepositoryModel().getName(), name)){
                ToyServiceModel toyServiceModel = new ToyServiceModel(Optional.ofNullable(item.gettoyRepositoryModel().getId()),item.gettoyRepositoryModel().getName(), item.gettoyRepositoryModel().getGenre(), item.gettoyRepositoryModel().getQuantite(), item.gettoyRepositoryModel().getPrix(), item.gettoyRepositoryModel().getPicture());

                ClientServiceModel clientServiceModel = new ClientServiceModel(Optional.ofNullable(item.getClientRepositoryModel().getId()),item.getClientRepositoryModel().getFirstname(), item.getClientRepositoryModel().getName(), item.getClientRepositoryModel().getEmail(), item.getClientRepositoryModel().getAdresse());

                venteServiceModels.add(new VenteServiceModel( Optional.ofNullable(item.getId()), item.getDateDeVente(), toyServiceModel, item.getQuantite(), clientServiceModel, item.getMontant()));
                System.out.println(item.toString());
            }
        }

        return venteServiceModels;
    }

    Float getTotalPriceOfSales(){
        venteRepository.findAll();


        return 0.1f ;
    }

//     get all sales per toy name/id
//        for(Vente vente : ventes) {
//        if(vente.gettoy().getId() == 1){
//            System.out.println(vente);
//        }
//


} // **





