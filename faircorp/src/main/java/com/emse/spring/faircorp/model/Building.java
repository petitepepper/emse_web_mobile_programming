package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BUILDING")
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Double outsideTemperature;

    @OneToMany(mappedBy = "building")
    private List<Room> rooms;


    public Building() {}
    public Building(String name, Double outsideTemperature, List<Room> rooms) {
        this.name = name;
        this.outsideTemperature = outsideTemperature;
        this.rooms = rooms;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getOutsideTemperature() {
        return outsideTemperature;
    }

    public void setOutsideTemperature(Double outsideTemperature) {
        this.outsideTemperature = outsideTemperature;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
