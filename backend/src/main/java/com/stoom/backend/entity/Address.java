package com.stoom.backend.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "ADDRESS") 
public class Address {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @Column(name="STREET_NAME", nullable = false)
    @Getter @Setter private String streetName;

    @Column(name="NUMBER", nullable = false)
    @Getter @Setter private String number;

    @Column(name="COMPLEMENT")
    @Getter @Setter private String complement;

    @Column(name="NEIGHBOURHOOD", nullable = false)
    @Getter @Setter private String neighbourhood;

    @Column(name="CITY", nullable = false)
    @Getter @Setter private String city;

    @Column(name="STATE", nullable = false)
    @Getter @Setter private String state;

    @Column(name="COUNTRY", nullable = false)
    @Getter @Setter private String country;

    @Column(name="ZIPCODE", nullable = false)
    @Getter @Setter private String zipcode;

    @Column(name="LATITUDE", nullable = true)
    @Getter @Setter private String latitude;

    @Column(name="LONGITUDE", nullable = true)
    @Getter @Setter private String longitude;

}
