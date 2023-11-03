package Furama.controllers;

import Furama.models.Booking;
import Furama.services.IBookingService;
import Furama.services.impl.BookingService;

import java.util.List;

public class BookingController {
    private final IBookingService bookingService = new BookingService();

    public void add(Booking booking) {
        bookingService.add(booking);
    }

    public List<Booking> getList() {
        return bookingService.getList();
    }
}
