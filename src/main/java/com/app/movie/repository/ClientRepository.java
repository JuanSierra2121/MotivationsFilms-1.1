/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.repository;

import com.app.movie.entities.Client;
import com.app.movie.interfaces.IClientRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andres
 */
@Repository
public class ClientRepository {

    @Autowired
    IClientRepository repository;

    public Iterable<Client> getAll() {
        return repository.findAll();
    }

    public Optional<Client> findById(String idClient) {
        Optional<Client> response = repository.findById(idClient);
        return response;
    }

    public Boolean existsById(String idClient) {
        return repository.existsById(idClient);
    }

    public void deleteById(String idClient) {
        repository.deleteById(idClient);
    }

    public Client save(Client nameClient) {
        return repository.save(nameClient);
    }

    public Optional<Client> findByEmail(String email) {
        Optional<Client> response = repository.findByEmail(email);
        return response;
    }

    public List<Client> getByEmail(String email) {
        return repository.getClientByEmail(email);
    }
}
