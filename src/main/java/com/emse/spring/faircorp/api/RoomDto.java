package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Room;

import java.util.Set;
import java.util.stream.Collectors;

public class RoomDto {
    private Long id;
    private String name;
    private Long buildingId;
    private Integer floor;
    private Double currentTemperature;
    private Double targetTemperature;
    private Set<HeaterDto> heaters;
    private Set<WindowDto> windows;


    public RoomDto(){}
    public RoomDto(Room room){
        this.id = room.getId();
        this.name = room.getName();
        this.buildingId = room.getBuilding().getId();
        this.floor = room.getFloor();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
        this.heaters =  (room.getHeaters() == null )?null:room.getHeaters().stream().map(HeaterDto::new).collect(Collectors.toSet());
        this.windows = (room.getWindows() == null)?null:room.getWindows().stream().map(WindowDto::new).collect(Collectors.toSet());
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

    public Set<HeaterDto> getHeaters() {
        return heaters;
    }

    public void setHeaters(Set<HeaterDto> heaters) {
        this.heaters = heaters;
    }

    public Set<WindowDto> getWindows() {
        return windows;
    }

    public void setWindows(Set<WindowDto> windows) {
        this.windows = windows;
    }
}
