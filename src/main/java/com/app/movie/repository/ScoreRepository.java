/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.repository;

import com.app.movie.entities.Movie;
import com.app.movie.entities.Score;
import com.app.movie.interfaces.IMovieRepository;
import com.app.movie.interfaces.IScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author Andres
 */
@Repository
public class ScoreRepository {
    
    @Autowired
    IScoreRepository repository;
    
    public Iterable<Score> getAll(){
        return repository.findAll();
    }
    
    public Optional<Score> findById(String idScore){
        Optional<Score> response= repository.findById(idScore);
        return response;
    }
    
    public Boolean existsById(String idScore){
        return repository.existsById(idScore);
    }
    
    public void deleteById(String idScore){
        repository.deleteById(idScore);
    }
    
    public Score save(Score score){
        return repository.save(score);
    }
    
}
