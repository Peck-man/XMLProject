package com.example.xmlproject.models;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
public class VillagePart {
    @Id
    @SequenceGenerator(name = "villagePartGenerator", sequenceName = "VILLAGEPART_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "villagePartGenerator")
    private Integer id;
    private int code;
    private int villageCode;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private Village village;

    public VillagePart(int code, int villageCode, String name, Village village) {
        this.code = code;
        this.villageCode = villageCode;
        this.name = name;
        this.village = village;
    }

    public VillagePart() {
    }
}
