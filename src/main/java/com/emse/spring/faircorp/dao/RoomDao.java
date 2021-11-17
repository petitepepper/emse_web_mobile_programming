package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoomDao extends JpaRepository<Room,Long>{

//    Optional<Room> findById(Long Id);
//
//    @Query("select r from Room r where r.name=:name")
//    Set<Room> findByName(String name);
//
//    @Query("select r from Room r where r.floor=:floor")
//    Set<Room> findByFloor(String floor);
//
//    @Query("select r from Room r where r.building.id=:buildingId")
//    Set<Room> findByBuilding(Building buildingId);

//    @Query("select r.windows from Room r")
//    Set<Window> findAllWindows();
//
//    @Query("select r.heaters from Room r")
//    Set<Heater> findAllHeaters();
}
