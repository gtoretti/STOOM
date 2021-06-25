package com.stoom.backend.request;

import lombok.Getter;
import lombok.Setter;

public class AddressRequest {
	
	@Getter @Setter private Integer id;
	@Getter @Setter private String streetName;
	@Getter @Setter private String number;
	@Getter @Setter private String complement;
	@Getter @Setter private String neighbourhood;
	@Getter @Setter private String city;
	@Getter @Setter private String state;
	@Getter @Setter private String country;
	@Getter @Setter private String zipcode;
	@Getter @Setter private String latitude;
	@Getter @Setter private String longitude;

}
