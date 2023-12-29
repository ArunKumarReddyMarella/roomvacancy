package com.example.ROOMSERVICE.service.impl;

import com.example.ROOMSERVICE.entity.Room;
import com.example.ROOMSERVICE.repository.RoomRepository;
import com.example.ROOMSERVICE.service.RoomService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        log.info(rooms.toString());
        return rooms;
    }

    @Override
    public Room getRoom(Integer id) {
        Optional<Room> room = roomRepository.findById(id);
        if(room.isEmpty())
            throw new RuntimeException("room not found");
        log.info(room.get().toString());
        return room.get();
    }

    @Override
    public Room createRoom(Room room) {
        Room createdRoom = roomRepository.saveAndFlush(room);
        log.info(createdRoom.toString());
        return createdRoom;
    }

    @Override
    public Room updateRoom(Room room) {
        Room updatedRoom = roomRepository.saveAndFlush(room);
        log.info(updatedRoom.toString());
        return updatedRoom;
    }

    @Override
    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }
}
