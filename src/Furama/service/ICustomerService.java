package Furama.service;

import Furama.model.Customer;

import java.util.List;

public interface ICustomerService {
    void edit(String id, Customer customer);

    void delete(String id);

    List<Customer> search(String name);

    void add(Customer customer);

    List<Customer> getList();
}
