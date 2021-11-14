package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.Set;

public class RoomDto {
    private Long id;
    private String name;
    private Long buildingId;
    private String buildingName;
    private Integer floor;
    private Double currentTemperature;
    private Double targetTemperature;
    private Set<Heater> heaters;
    private Set<Window> windows;



    public RoomDto(){}
    public RoomDto(Room room){
        this.id = room.getId();
        this.name = room.getName();
        this.buildingId = room.getBuilding().getId();
        this.buildingName = room.getBuilding().getName();
        this.floor = room.getFloor();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
        this.heaters = room.getHeaters();
        this.windows = room.getWindows();
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

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Set<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(Set<Heater> heaters) {
        this.heaters = heaters;
    }

    public Set<Window> getWindows() {
        return windows;
    }

    public void setWindows(Set<Window> windows) {
        this.windows = windows;
    }
}
