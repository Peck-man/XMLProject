package com.example.xmlproject.models;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
public class Village {
    @Id
    @SequenceGenerator(name = "villageGenerator", sequenceName = "VILLAGE_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "villageGenerator")
    private Integer id;
    private String name;

    private int code;
    public Village() {
    }

    public Village(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
