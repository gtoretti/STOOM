package com.stoom.backend.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ADDRESS") 
public class Address {

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(name="STREET_NAME", nullable = false)
    private String streetName;

    @Column(name="NUMBER", nullable = false)
    private String number;

    @Column(name="COMPLEMENT", nullable = true)
    private String complement;

	@Column(name="NEIGHBOURHOOD", nullable = false)
	private String neighbourhood;

    @Column(name="CITY", nullable = false)
    private String city;

    @Column(name="STATE", nullable = false)
    private String state;

    @Column(name="COUNTRY", nullable = false)
    private String country;

    @Column(name="ZIPCODE", nullable = false)
    private String zipcode;

    @Column(name="LATITUDE", nullable = true)
    private String latitude;

    @Column(name="LONGITUDE", nullable = true)
    private String longitude;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
