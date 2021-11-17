package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class WindowDaoCustomImpl implements WindowDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.id = :id and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }

    @Override
    @Transactional
    @Modifying
    public List<Window> deleteAllWindowsInRoom(Long id) {
        String jpql1 = "delete from Window w where w.room.id = :id";
        em.createQuery(jpql1).setParameter("id", id).executeUpdate();
        String jpql2 = " select w from Window w where w.room.id = :id";
        return em.createQuery(jpql2, Window.class)
                .setParameter("id", id)
                .getResultList();
    }


}