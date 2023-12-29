package com.example.ROOMSERVICE.controller;

import com.example.ROOMSERVICE.entity.Room;
import com.example.ROOMSERVICE.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<List<Room>> getRooms() {
        List<Room> rooms;
        try {
            rooms = roomService.getAllRooms();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable Integer id) {
        Room room;
        try {
            room = roomService.getRoom(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(room);
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room){
        Room createdRoom;
        try{
            createdRoom = roomService.createRoom(room);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(createdRoom);
    }

    @PutMapping
    public ResponseEntity<Room> updateRoom(@RequestBody Room room){
        Room createdRoom;
        try{
            createdRoom = roomService.updateRoom(room);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(createdRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRoom(@PathVariable Integer id){
        try {
            roomService.deleteRoom(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("deleted successfully");
    }
}
