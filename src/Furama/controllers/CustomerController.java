package Furama.controllers;

import Furama.models.person.Customer;
import Furama.services.ICustomerService;
import Furama.services.impl.CustomerService;

import java.util.List;

public class CustomerController {
    private final ICustomerService customerService = new CustomerService();

    public void edit(String id, Customer customer) {
        customerService.edit(id, customer);
    }

    public boolean delete(String id) {
        return customerService.delete(id);
    }

    public List<Customer> search(String name) {
        return customerService.search(name);
    }

    public boolean add(Customer customer) {
        return customerService.add(customer);
    }

    public List<Customer> getList() {
        return customerService.getList();
    }
}
