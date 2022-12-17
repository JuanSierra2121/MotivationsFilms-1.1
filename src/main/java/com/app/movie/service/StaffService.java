/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.service;

import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Staff;
import com.app.movie.interfaces.IStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class StaffService {

    @Autowired
    IStaffRepository repository;

    public Iterable<Staff> get() {
        Iterable<Staff> response = repository.findAll();
        return response;
    }

    public ResponseDto create(Staff request) {

        Staff newStaff = repository.save(request);

        ResponseDto responseDto = new ResponseDto();
        responseDto.status=true;
        responseDto.message=" El Staff  se ha creado correctamente";
        responseDto.id= newStaff.getId();
        return responseDto;

    }

    public Staff update(Staff staff) {
        Staff staffToUpdate = new Staff();
        if (repository.existsById(staff.getId())) {
            staffToUpdate = staff;
            repository.save(staffToUpdate);
        }
        return staffToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}
