package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface HeaterDaoCustom {
    List<Heater> findRoomOpenHeaters(Long id);
    List<Heater> deleteAllHeatersInRoom(Long id);
}
