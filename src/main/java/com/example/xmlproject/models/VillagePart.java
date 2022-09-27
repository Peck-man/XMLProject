package com.example.xmlproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @NoArgsConstructor @Data
public class VillagePart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int code;
    private int villageCode;
    private String name;

    public VillagePart(int code, int villageCode, String name) {
        this.code = code;
        this.villageCode = villageCode;
        this.name = name;
    }
}
