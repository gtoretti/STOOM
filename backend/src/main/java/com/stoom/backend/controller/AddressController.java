package com.stoom.backend.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stoom.backend.entity.Address;
import com.stoom.backend.request.AddressRequest;
import com.stoom.backend.service.AddressService;

import java.util.List;
 
@RestController
@RequestMapping({"/address"})
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address create(@RequestBody AddressRequest addressRequest){
    	Address address = new Address();
    	address.setStreetName(addressRequest.getStreetName());
    	address.setNumber(addressRequest.getNumber());
    	address.setComplement(addressRequest.getComplement());
    	address.setNeighbourhood(addressRequest.getNeighbourhood());
    	address.setCity(addressRequest.getCity());
    	address.setState(addressRequest.getState());
    	address.setCountry(addressRequest.getCountry());
    	address.setZipcode(addressRequest.getZipcode());
    	address.setLatitude(addressRequest.getLatitude());
    	address.setLongitude(addressRequest.getLongitude());
        return addressService.create(address);
    }

    @GetMapping(path = {"/{id}"})
    public Address findOne(@PathVariable("id") Integer id){
        return addressService.findById(id);
    }

    @GetMapping
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @PutMapping
    public Address update(@RequestBody AddressRequest addressRequest){
    	Address address = new Address();
    	address.setId(addressRequest.getId());
    	address.setStreetName(addressRequest.getStreetName());
    	address.setNumber(addressRequest.getNumber());
    	address.setComplement(addressRequest.getComplement());
    	address.setNeighbourhood(addressRequest.getNeighbourhood());
    	address.setCity(addressRequest.getCity());
    	address.setState(addressRequest.getState());
    	address.setCountry(addressRequest.getCountry());
    	address.setZipcode(addressRequest.getZipcode());
    	address.setLatitude(addressRequest.getLatitude());
    	address.setLongitude(addressRequest.getLongitude());
    	return addressService.create(address);
    }

    @DeleteMapping(path ={"/{id}"})
    public Address delete(@PathVariable("id") Integer id) {
        return addressService.delete(id);
    }
}