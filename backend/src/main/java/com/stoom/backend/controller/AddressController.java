package com.stoom.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.kafka.core.KafkaTemplate;

import com.stoom.backend.entity.Address;
import com.stoom.backend.request.AddressRequest;
import com.stoom.backend.service.AddressService;


@RestController
@RequestMapping({"/address"})
public class AddressController {

    @Autowired
    private AddressService addressService;
    
    @Autowired
    private KafkaTemplate<Object, Object> template;

    @PostMapping
    public Address create(@RequestBody AddressRequest addressRequest) throws Exception {
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
    	
    	//Kaftka producer
    	this.template.send("address-topic-create", address);
        
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
    public Address update(@RequestBody AddressRequest addressRequest) throws Exception {
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
    	
    	//Kaftka producer
    	this.template.send("address-topic-update", address);
    	
    	return addressService.create(address);
    }

    @DeleteMapping(path ={"/{id}"})
    public Address delete(@PathVariable("id") Integer id) {
    	
    	//Kaftka producer
    	this.template.send("address-topic-delete", id);
    	
        return addressService.delete(id);
    }
}