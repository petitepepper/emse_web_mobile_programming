package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomDao extends JpaRepository<Room,Long>{

    @Query("select r from Room r where r.id=:id")
    Room getById(Long id);

    @Query("select r from Room r where r.name=:name")
    List<Room> findByName(String name);

    @Query("select r from Room r where r.floor=:floor")
    List<Room> findByFloor(String floor);

}
