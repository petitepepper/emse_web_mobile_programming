package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HeaterDao extends JpaRepository<Heater,Long> {

    Optional<Heater> findById(Long Id);

    @Query("select h from Heater h where h.name=:name")
    List<Heater> findByName(String name);

    @Query("select h from Heater h where h.room=:room")
    List<Heater> findByRoom(Room room);

    @Query("select h from Heater h where h.heaterStatus=:heaterStatus")
    List<Heater> findStatus(HeaterStatus heaterStatus);

    @Modifying
    @Query("delete from Heater h where h.room.id = ?1")
    void deleteByRoom(long roomId); // delete all heaters in room
}
