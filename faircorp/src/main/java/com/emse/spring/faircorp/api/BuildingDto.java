package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;

import java.util.Set;

public class BuildingDto {
    private Long id;
    private String name;
    private Double outsideTemperature;
    private Set<Room> rooms;

    public BuildingDto(){}

    public BuildingDto(Building building){
        this.id = building.getId();
        this.name = building.getName();
        this.outsideTemperature = building.getOutsideTemperature();
        this.rooms = (Set<Room>) building.getRooms();
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

    public Double getOutsideTemperature() {
        return outsideTemperature;
    }

    public void setOutsideTemperature(Double outsideTemperature) {
        this.outsideTemperature = outsideTemperature;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
