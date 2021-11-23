package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.Set;
import java.util.stream.Collectors;

public class RoomDto {
    private Long id;
    private String name;
    private Integer floor;
    private Long buildingId;
    private String buildingName;
    private Double currentTemperature;
    private Double targetTemperature;
    private Set<HeaterDto> heaters;



    private Set<WindowDto> windows;


    public RoomDto() {}
    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.buildingId = room.getBuilding().getId();
        this.buildingName = room.getBuilding().getName();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
        this.heaters = (room.getHeaters() == null )?null:room.getHeaters().stream().map(HeaterDto::new).collect(Collectors.toSet());
        this.windows = (room.getWindows() == null)?null:room.getWindows().stream().map(WindowDto::new).collect(Collectors.toSet());

    }

    public Long getId() {
        return id;
    }

    public Integer getFloor() {
        return floor;
    }

    public String getName() {
        return name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setHeaters(Set<HeaterDto> heaters) {
        this.heaters = heaters;
    }

    public void setWindows(Set<WindowDto> windows) {
        this.windows = windows;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Set<HeaterDto> getHeaters() {
        return heaters;
    }

    public Set<WindowDto> getWindows() {
        return windows;
    }

    public Long getBuildingId() {return this.buildingId;}

    public void setBuildingId(Long buildingId) {this.buildingId = buildingId;}

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

}