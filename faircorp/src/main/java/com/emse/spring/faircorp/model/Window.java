package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name="RWINDOW")
public class Window {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Room room;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WindowStatus windowStatus;

    public Window() {

    }

     public Window(Long id, String name, WindowStatus windowStatus, Room room) {
        this.id = id;
        this.name = name;
        this.windowStatus = windowStatus;
        this.room = room;
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

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
