package com.rhm.demo.models;


import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    @NotNull
    @Size(min = 2, max = 20)
    private String creator;
    @NotNull
    private Double currentVersion;


    public Language() {
    }

    public Language(Long id,  String name,  String creator, Double currentVersion) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.currentVersion = currentVersion;
    }


    public Language(String name,  String creator, Double currentVersion) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.currentVersion = currentVersion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Double getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(Double currentVersion) {
        this.currentVersion = currentVersion;
    }
}
