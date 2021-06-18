package com.stoom.backend.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.stoom.backend.entity.Address;

public interface AddressRepository extends Repository<Address, Integer> {

    void delete(Address address);

    List<Address> findAll();

    Address findById(Integer customerId);

    Address save(Address address);

}
