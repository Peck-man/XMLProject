package com.example.xmlproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @NoArgsConstructor @Data
public class VillagePart {
    @Id
    @SequenceGenerator(name = "villagePartGenerator", sequenceName = "VILLAGEPART_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "villagePartGenerator")
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
