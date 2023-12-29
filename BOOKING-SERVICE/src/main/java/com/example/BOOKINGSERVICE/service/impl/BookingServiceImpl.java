package com.example.BOOKINGSERVICE.service.impl;

import com.example.BOOKINGSERVICE.entity.Booking;
import com.example.BOOKINGSERVICE.repository.BookingRepository;
import com.example.BOOKINGSERVICE.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Booking> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        log.info(bookings.toString());
        return bookings;
    }

    @Override
    public Booking getBooking(Integer id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isEmpty())
            throw new RuntimeException("booking not found");
        log.info(booking.get().toString());
        return booking.get();
    }

    @Override
    public Booking createBooking(Booking booking) {
        Booking createdBooking = bookingRepository.saveAndFlush(booking);
        log.info(createdBooking.toString());
        return createdBooking;
    }

    @Override
    public void deleteBooking(Integer id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        Booking updatedBooking = bookingRepository.saveAndFlush(booking);
        log.info(updatedBooking.toString());
        return updatedBooking;
    }
}
