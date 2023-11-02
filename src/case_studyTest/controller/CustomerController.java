package case_studyTest.controller;

import case_studyTest.model.person.Customer;
import case_studyTest.service.IPersonService;
import case_studyTest.service.impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private final IPersonService<Customer> customerService = new CustomerServiceImpl();

    public void add(Customer customer) {
        customerService.add(customer);
    }

    public void delete(String id) {
        customerService.delete(id);
    }

    public List<Customer> display() {
        return customerService.display();
    }

    public void edit(Customer customer) {
        customerService.edit(customer);
    }

    public List<Customer> searchByName(String name) {
        return customerService.searchByName(name);
    }
}
