package Furama.repositories;

import Furama.models.person.Customer;

import java.util.List;

public interface ICustomerRepository {
    void edit(String id, Customer customer);

    boolean delete(String id);

    List<Customer> search(String name);

    boolean add(Customer customer);

    List<Customer> getList();
}
