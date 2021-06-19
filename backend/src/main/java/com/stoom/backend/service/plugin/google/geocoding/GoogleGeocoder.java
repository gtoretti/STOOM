package com.stoom.backend.service.plugin.google.geodecoding;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import com.stoom.backend.entity.Address;
import com.stoom.backend.service.plugin.Geocoder;

@Service
public class GoogleGeocoder implements Geocoder {

	private final RestTemplate restTemplate;
	
	@Value("${plugin.google.geodecoding.endpoint}")
	private String endpoint; 

	@Value("${plugin.google.geodecoding.authorizationkey}")
	private String apiKey; 
	
    public GoogleGeocoder(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
	public Map fetch(Address address) throws Exception {
		endpoint = endpoint.replace("{number}",address.getNumber());
		endpoint = endpoint.replace("{streetName}",address.getStreetName());
		endpoint = endpoint.replace("{city}",address.getCity());
		endpoint = endpoint.replace("{state}",address.getState());
		endpoint = endpoint.replace("{auth.key}",apiKey);
	    return this.restTemplate.getForObject(endpoint, Map.class);	
	}
	
	public void validate(Address address) throws Exception {
		if (address.getLatitude() == null || address.getLatitude().isEmpty() || address.getLongitude() == null || address.getLongitude().isEmpty()) {
			Map addressMap = fetch(address);
			if (addressMap.get("status").equals("OK")) {
				List results = (List)addressMap.get("results");
				if (results.size()>0) {
					Map result = (Map)results.get(0);
					Map geometry = (Map)result.get("geometry");
					Map location = (Map)geometry.get("location");
					address.setLatitude(location.get("lat").toString());
					address.setLongitude(location.get("lng").toString());
				}
			}else
				throw new Exception("Error on Google Geodecoding service:" + addressMap.get("status"));
		}
	}
}


