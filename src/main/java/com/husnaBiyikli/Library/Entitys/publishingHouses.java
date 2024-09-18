package com.husnaBiyikli.Library.Entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PublishingHouses")
public class publishingHouses {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PublishingHouse")
    @NotNull(message = "Yayın evi adı boş bırakılamaz")
    private String publishingHouses;

    @Column(name = "Description")
    private String description;

    public publishingHouses() {
    }

    public publishingHouses(Long id, String publishingHouses, String description) {
        this.id = id;
        this.publishingHouses = publishingHouses;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublishingHouses() {
        return publishingHouses;
    }

    public void setPublishingHouses(String publishingHouses) {
        this.publishingHouses = publishingHouses;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
