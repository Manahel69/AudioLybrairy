package com.MyAudioLibrairy.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Artist {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ArtistId;
    private String name;


    public Long getId() {
        return ArtistId;
    }

    public void setId(Long id) {
        this.ArtistId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
