/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.repository;

import com.app.movie.entities.Category;
import com.app.movie.interfaces.ICategoryRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andres
 */
@Repository
public class CategoryRepository {
    
    @Autowired
    ICategoryRepository repository;
    
    public Iterable<Category> getAll(){
        return repository.findAll();
    }
    
    public Optional<Category> findById(String idCategory){
        Optional<Category> response= repository.findById(idCategory);
        return response;
    }
    
    public Boolean existsById(String idCategory){
        return repository.existsById(idCategory);
    }
    
    public void deleteById(String idCategory){
        repository.deleteById(idCategory);
    }
    
    public Category save(Category category){
        return repository.save(category);
    }
    
}
