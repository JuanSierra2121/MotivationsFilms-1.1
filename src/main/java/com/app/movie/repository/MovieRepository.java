/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.repository;

import com.app.movie.entities.Client;
import com.app.movie.entities.Movie;
import com.app.movie.interfaces.IClientRepository;
import com.app.movie.interfaces.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Andres
 */
@Repository
public class MovieRepository {
    
    @Autowired
    IMovieRepository repository;
    
    public Iterable<Movie> getAll(){
        return repository.findAll();
    }

    public List<Movie> getByName(String nameMovie){
        return repository.getMoviesByName(nameMovie);
    }
    
    public Optional<Movie> findById(String idMovie){
        Optional<Movie> response= repository.findById(idMovie);
        return response;
    }
    
    public Boolean existsById(String idMovie){
        return repository.existsById(idMovie);
    }
    
    public void deleteById(String idMovie){
        repository.deleteById(idMovie);
    }
    
    public Movie save(Movie movie){
        return repository.save(movie);
    }
    
}
