package Furama.service.impl;

import Furama.model.Customer;
import Furama.model.Employee;
import Furama.repository.ICustomerRepo;
import Furama.repository.impl.CustomerRepo;
import Furama.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepo customerRepo = new CustomerRepo();

    @Override
    public void edit(String id, Customer customer) {
        customerRepo.edit(id, customer);
    }

    @Override
    public void delete(String id) {
        customerRepo.delete(id);
    }

    @Override
    public void search(String name) {
        customerRepo.search(name);
    }

    @Override
    public void add(Customer customer) {
        customerRepo.add(customer);
    }

    @Override
    public List<Customer> getList() {
        return customerRepo.getList();
    }
}
