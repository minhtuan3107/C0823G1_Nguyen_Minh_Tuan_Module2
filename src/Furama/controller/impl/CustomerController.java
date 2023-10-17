package Furama.controller.impl;

import Furama.controller.ICustomerController;
import Furama.model.Customer;
import Furama.model.Employee;
import Furama.service.ICustomerService;
import Furama.service.impl.CustomerService;

import java.util.List;

public class CustomerController implements ICustomerController {
    private ICustomerService customerService = new CustomerService();
    @Override
    public void edit(String id, Customer customer) {
        customerService.edit(id,customer);
    }

    @Override
    public void delete(String id) {
        customerService.delete(id);
    }

    @Override
    public void search(String name) {
        customerService.search(name);
    }

    @Override
    public void add(Customer customer) {
        customerService.add(customer);
    }

    @Override
    public List<Customer> getList() {
        return customerService.getList();
    }
}
