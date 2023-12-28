package com.example.ROOMSERVICE.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "room_type", nullable = false, length = 50)
    private String roomType;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "is_booked")
    private boolean isBooked;

    @Column(name = "room_amenities", columnDefinition = "TEXT")
    private String roomAmenities;
}
