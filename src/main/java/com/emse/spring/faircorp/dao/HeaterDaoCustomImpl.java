package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HeaterDaoCustomImpl implements  HeaterDaoCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Heater> findRoomOpenHeaters(Long id) {
        String jpql = "select h from Heater h where h.room.id = :id and h.heaterStatus= :status";
        return em.createQuery(jpql, Heater.class)
                .setParameter("id", id)
                .setParameter("status", HeaterStatus.ON)
                .getResultList();
    }

    @Override
    @Transactional
    @Modifying
    public List<Heater> deleteAllHeatersInRoom(Long id) {
        String jpql1 = "delete from Heater h where h.room.id = :id";
        em.createQuery(jpql1).setParameter("id", id).executeUpdate();
        String jpql2 = " select h from Heater h where h.room.id = :id";
        return em.createQuery(jpql2, Heater.class)
                .setParameter("id", id)
                .getResultList();
    }
}
