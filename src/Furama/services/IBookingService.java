package Furama.services;

import Furama.models.Booking;

import java.util.List;

public interface IBookingService {
    void add(Booking booking);

    List<Booking> getList();

}
