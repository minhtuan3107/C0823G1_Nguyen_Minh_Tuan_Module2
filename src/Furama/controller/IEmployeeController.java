package Furama.controller;

import Furama.model.Employee;

import java.util.List;

public interface IEmployeeController {
    void edit(String id, Employee employee);

    void delete(String id);

    void search(String name);

    List<Employee> getList();

    void add(Employee employee);
}
