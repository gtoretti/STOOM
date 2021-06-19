package com.stoom.backend.service.plugin;

import com.stoom.backend.entity.Address;


public interface Geocoder {

	public void validate(Address address) throws Exception;
}


