package com.example.BOOKINGSERVICE.controller;

import com.example.BOOKINGSERVICE.entity.Booking;
import com.example.BOOKINGSERVICE.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> bookings;
        try{
            bookings = bookingService.getAllBookings();
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Integer id) {
        Booking booking;
        try {
            booking = bookingService.getBooking(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(booking);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        Booking createdBooking;
        try{
            createdBooking = bookingService.createBooking(booking);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(createdBooking);
    }

    @PutMapping
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking){
        Booking createdBooking;
        try{
            createdBooking = bookingService.updateBooking(booking);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(createdBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBooking(@PathVariable Integer id){
        try {
            bookingService.deleteBooking(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("deleted successfully");
    }
}
