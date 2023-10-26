package Furama.service.impl;

import Furama.model.Customer;
import Furama.repository.ICustomerRepo;
import Furama.repository.impl.CustomerRepo;
import Furama.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final ICustomerRepo customerRepo = new CustomerRepo();

    @Override
    public void edit(String id, Customer customer) {
        customerRepo.edit(id, customer);
    }

    @Override
    public void delete(String id) {
        customerRepo.delete(id);
    }

    @Override
    public List<Customer> search(String name) {
        return customerRepo.search(name);
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
