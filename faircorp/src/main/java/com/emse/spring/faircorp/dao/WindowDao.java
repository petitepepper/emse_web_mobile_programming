package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WindowDao extends JpaRepository<Window,Long>,WindowDaoCustom {

    Optional<Window> findById(Long Id);

    @Query("select w from Window w where w.name=:name")
    List<Window> findByName(String name);

    @Query("select w from Window w where w.room=:room")
    List<Window> findByRoom(Room room);

    @Query("select w from Window w where w.windowStatus=:windowStatus")
    List<Window> findStatus(WindowStatus windowStatus);

    @Modifying
    @Query("delete from Window w where w.room.id = ?1")
    void deleteByRoom(long roomId);


}
