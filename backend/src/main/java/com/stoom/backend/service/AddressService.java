package com.stoom.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.stoom.backend.entity.Address;
import com.stoom.backend.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;
 
    public Address create(Address address) {
        return repository.save(address);
    }
 
    public Address delete(Integer id) {
    	Address address = findById(id);
        if(address != null){
            repository.delete(address);
        }
        return address;
    }
 
    public List<Address> findAll() {
        return repository.findAll();
    }
 
    public Address findById(Integer id) {
        return repository.findById(id);
    }
 
    public Address update(Address address) {
    	return repository.save(address);
    }
}
