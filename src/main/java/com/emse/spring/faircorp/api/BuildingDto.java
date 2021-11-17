package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;

import java.util.Set;
import java.util.stream.Collectors;

public class BuildingDto {
    private Long id;
    private String name;
    private Double outsideTemperature;
    private Set<RoomDto> rooms;

    public BuildingDto(){}

    public BuildingDto(Building building){
        this.id = building.getId();
        this.name = building.getName();
        this.outsideTemperature = building.getOutsideTemperature();
        this.rooms = (building.getRooms() == null)?null:building.getRooms().stream().map(RoomDto::new).collect(Collectors.toSet());
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

    public Set<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(Set<RoomDto> rooms) {
        this.rooms = rooms;
    }
}
