package Furama.repositories;

import Furama.models.Booking;

import java.util.List;

public interface IBookingRepository {
    void add(Booking booking);

    List<Booking> getList();

}
