package Furama.repositories.impl;

import Furama.models.Booking;
import Furama.repositories.IBookingRepository;
import Furama.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements IBookingRepository {
    private final String COMA = ",";
    private final String FILE_BOOKING = "D:\\module2Again\\src\\Furama\\utils\\DataBooking.csv";

    @Override
    public void add(Booking booking) {
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);
        ReadAndWrite.write(convertToString(bookings), FILE_BOOKING, true);
    }

    @Override
    public List<Booking> getList() {
        List<String> stringList = ReadAndWrite.read(FILE_BOOKING);
        List<Booking> bookings = convertToObject(stringList);
        return bookings;
    }

    public List<String> convertToString(List<Booking> bookings) {
        List<String> stringList = new ArrayList<>();
        for (Booking booking : bookings) {
            stringList.add(booking.getId() + COMA +
                    booking.getDateBooking() + COMA +
                    booking.getDayStart() + COMA +
                    booking.getDayEnd() + COMA +
                    booking.getIdCustomer() + COMA +
                    booking.getIdService());
        }
        return stringList;
    }

    public List<Booking> convertToObject(List<String> stringList) {
        List<Booking> bookings = new ArrayList<>();
        String[] line;
        for (String str : stringList) {
            line = str.split(COMA);
            bookings.add(new Booking(line[0], line[1], line[2], line[3], line[4], line[5]));
        }
        return bookings;
    }
}
