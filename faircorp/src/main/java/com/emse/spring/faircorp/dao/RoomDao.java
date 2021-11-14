package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoomDao extends JpaRepository<Room,Long>{

    Optional<Room> findById(Long Id);

    @Query("select r from Room r where r.name=:name")
    List<Room> findByName(String name);

    @Query("select r from Room r where r.floor=:floor")
    List<Room> findByFloor(String floor);

}
