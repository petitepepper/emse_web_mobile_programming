package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuildingDao extends JpaRepository<Building,Long> {

    @Query("select b from Building b where b.id=:id")
    Building getById(Long id);

    @Query("select b from Building b where b.name=:name")
    Building findByName(String name);

}
