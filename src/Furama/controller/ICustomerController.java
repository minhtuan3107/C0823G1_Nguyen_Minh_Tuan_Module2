package Furama.controller;

import Furama.model.Customer;
import Furama.model.Employee;

import java.util.List;

public interface ICustomerController {
    void edit(String id, Customer customer);

    void delete(String id);

    void search(String name);

    void add(Customer customer);

    List<Customer> getList();
}
