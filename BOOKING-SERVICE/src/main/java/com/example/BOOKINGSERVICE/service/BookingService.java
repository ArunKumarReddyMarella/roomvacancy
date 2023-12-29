package com.example.BOOKINGSERVICE.service;

import com.example.BOOKINGSERVICE.entity.Booking;

import java.util.List;

public interface BookingService {
    public List<Booking> getAllBookings();

    public Booking getBooking(Integer id);

    public Booking createBooking(Booking booking);

    public void deleteBooking(Integer id);
    public Booking updateBooking(Booking booking);
}
