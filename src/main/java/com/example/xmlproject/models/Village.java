package com.example.xmlproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor
public class Village {
    @Id
    @SequenceGenerator(name = "villageGenerator", sequenceName = "VILLAGE_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "villageGenerator")
    private Integer id;
    private String name;

    private int code;

    public Village(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
