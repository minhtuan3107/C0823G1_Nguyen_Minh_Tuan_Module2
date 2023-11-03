package Furama.services.impl;

import Furama.models.Booking;
import Furama.repositories.IBookingRepository;
import Furama.repositories.impl.BookingRepository;
import Furama.services.IBookingService;

import java.util.List;

public class BookingService implements IBookingService {
    private final IBookingRepository bookingRepository = new BookingRepository();

    @Override
    public void add(Booking booking) {
        bookingRepository.add(booking);
    }

    @Override
    public List<Booking> getList() {
        return bookingRepository.getList();
    }

}
