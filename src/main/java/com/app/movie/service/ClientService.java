/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.service;

import com.app.movie.dto.ReportClientDto;
import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Client;

import com.app.movie.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class ClientService {

    private final String CLIENT_REGISTERED="El Cliente ya se encuentra registrado";
    private final String CLIENT_SUCCESS="El Cliente  se registró correctamente";
    @Autowired
    ClientRepository repository;

    public Iterable<Client> get() {
        Iterable<Client> response = repository.getAll();
        return response;
    }

    public ReportClientDto getReport() {
        Optional<Client> idClient = repository.findById("6380442df71ad74770fc57e1");
        ReportClientDto reportClientDto= new ReportClientDto();
        reportClientDto.birthDate=idClient.get().getBirthDate();
        reportClientDto.email=idClient.get().getEmail();
        reportClientDto.idClient=idClient.get().getIdClient();
        return reportClientDto;
    }

    public ResponseDto create(Client request) {

        ResponseDto response = new ResponseDto();
        List<Client> clients = repository.getByEmail(request.getEmail());
        if(clients.size()>0){
            response.status=false;
            response.message=CLIENT_REGISTERED;
        }else{
            repository.save(request);
            response.status=true;
            response.message=CLIENT_SUCCESS;
            response.id= request.getIdClient();
        }
        return response;





    }

    //Revisar de aqui en adelante  cambio de id por IdClieny y client por nameClient

    public Client update(Client client) {
        Client clientToUpdate = new Client();

        Optional<Client> currentClient = repository.findById(client.getIdClient());
        if (!currentClient.isEmpty()) {
            clientToUpdate = client;
            clientToUpdate=repository.save(clientToUpdate);
        }
        return clientToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}
