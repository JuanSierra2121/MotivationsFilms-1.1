/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.movie.interfaces;

import com.app.movie.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Andres
 */
public interface IClientRepository extends MongoRepository<Client, String> {

    @Query(value= "{nameClient : ?0}") // SQL Equivalent : SELECT * FROM Movie select * from Movie where name=?
    List<Client> getClientByNameClient(String nameClient);

    @Query(value= "{lastName : ?0}") // SQL Equivalent : SELECT * FROM Movie select * from Movie where name=?
    List<Client> getClientByLastName(String lastName);

    @Query(value= "{email : ?0}") // SQL Equivalent : SELECT * FROM Movie select * from Movie where name=?
    List<Client> getClientByEmail(String email);

    @Query(value= "{email : ?0}")
    Optional<Client> findByEmail(String email);


}
