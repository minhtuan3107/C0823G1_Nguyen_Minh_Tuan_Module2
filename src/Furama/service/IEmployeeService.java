package Furama.service;

import Furama.model.Employee;

import java.util.List;

public interface IEmployeeService {
    void edit(String id, Employee employee);

    void delete(String id);

    List<Employee> search(String name);

    List<Employee> getList();

    void add(Employee employee);
}
