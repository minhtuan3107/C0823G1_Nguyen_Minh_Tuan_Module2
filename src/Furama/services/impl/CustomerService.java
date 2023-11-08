package Furama.services.impl;

import Furama.models.Customer;
import Furama.repositories.ICustomerRepository;
import Furama.repositories.impl.CustomerRepository;
import Furama.services.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepo = new CustomerRepository();

    @Override
    public void edit(String id, Customer customer) {
        customerRepo.edit(id, customer);
    }

    @Override
    public boolean delete(String id) {
        return customerRepo.delete(id);
    }

    @Override
    public List<Customer> search(String name) {
        return customerRepo.search(name);
    }

    @Override
    public boolean add(Customer customer) {
        return customerRepo.add(customer);
    }

    @Override
    public List<Customer> getList() {
        return customerRepo.getList();
    }
}
