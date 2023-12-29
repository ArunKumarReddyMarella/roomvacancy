package com.example.ROOMSERVICE.service;

import com.example.ROOMSERVICE.entity.Room;

import java.util.List;

public interface RoomService {
    public List<Room> getAllRooms();
    public Room getRoom(Integer id);
    public Room createRoom(Room room);
    public Room updateRoom(Room room);
    public void deleteRoom(Integer id);
}
