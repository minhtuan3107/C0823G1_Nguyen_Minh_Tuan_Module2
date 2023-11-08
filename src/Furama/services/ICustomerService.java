package Furama.services;

import Furama.models.Customer;

import java.util.List;

public interface ICustomerService {
    void edit(String id, Customer customer);

    boolean delete(String id);

    List<Customer> search(String name);

    boolean add(Customer customer);

    List<Customer> getList();
}
