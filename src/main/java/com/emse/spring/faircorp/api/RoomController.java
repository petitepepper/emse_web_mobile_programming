package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;
    private final HeaterDao heaterDao;
    private final WindowDao windowDao;
    private final BuildingDao buildingDao;

    public RoomController(RoomDao roomDao,HeaterDao heaterDao, WindowDao windowDao,BuildingDao buildingDao){
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
        this.buildingDao = buildingDao;
    }


    // Retrieve a list of all rooms
    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    // Retrieve a particular room
    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }


    //Create a room
    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        Building building = buildingDao.getById(dto.getBuildingId());
        Room room = roomDao.save(new Room(dto.getName(), dto.getFloor(),building));
        return new RoomDto(room);
    }

    // Delete a room
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteAllHeatersInRoom(id);
        windowDao.deleteAllWindowsInRoom(id);
        roomDao.deleteById(id);
    }

    // Switch the windows
    @PutMapping("/{id}/switchWindows")
    public void switchWindows(@PathVariable Long id ){
        Set<Window> windows = roomDao.findById(id).orElseThrow(IllegalArgumentException::new).getWindows();
        for (Window w: windows){
            w.setWindowStatus(w.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        }
    }

    // Switch the heaters
    @PutMapping("/{id}/switchHeaters")
    public void switchHeaters(@PathVariable Long id ){
        Set<Heater> heaters = roomDao.findById(id).orElseThrow(IllegalArgumentException::new).getHeaters();
        for (Heater h: heaters){
            h.setHeaterStatus(h.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        }
    }

}
