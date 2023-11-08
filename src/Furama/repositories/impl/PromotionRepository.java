package Furama.repositories.impl;

import Furama.controllers.BookingController;
import Furama.controllers.CustomerController;
import Furama.controllers.FacilityController;
import Furama.models.Booking;
import Furama.models.person.Customer;
import Furama.models.facility.Facility;
import Furama.models.Promotion;
import Furama.repositories.IPromotionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PromotionRepository implements IPromotionRepository {
    private final BookingController bookingController = new BookingController();
    private final FacilityController facilityController = new FacilityController();
    private final CustomerController customerController = new CustomerController();

    @Override
    public List<Customer> displayCustomerUserService() {
        List<Booking> bookingList = bookingController.getList();
        List<Customer> customerList = customerController.getList();
        List<Customer> customerList1 = new ArrayList<>();
        for (Customer customer : customerList) {
            for (Booking booking : bookingList) {
                if (booking.getIdCustomer().equals(customer.getId())) {
                    customerList1.add(customer);
                }
            }
        }
        return customerList1;
    }

    @Override
    public List<Customer> displayCustomerGetVoucher(Promotion promotion) {
        List<Booking> bookingList = bookingController.getList();
        Map<Facility, Integer> facilityIntegerMap = facilityController.getList();
        Stack<Booking> bookingList1 = new Stack<>();
        for (Booking booking : bookingList) {
            for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
                if (booking.getIdService().equals(map.getKey().getId())) {
                    if (map.getKey().getType().equals("thuê theo năm")) {
                        bookingList1.add(booking);
                    }
                }
            }
        }
        List<Booking> bookings = new ArrayList<>();
        int count = promotion.getCount();
        for (Booking booking : bookingList1) {
            if (count != 0) {
                bookings.add(booking);
                count--;
            }
        }
        List<Customer> customerList = customerController.getList();
        List<Customer> customerList1 = new ArrayList<>();
        for (Booking booking : bookings) {
            for (Customer customer : customerList) {
                if (booking.getIdCustomer().equals(customer.getId())) {
                    customerList1.add(customer);
                }
            }
        }
        return customerList1;
    }
}
