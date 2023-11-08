package Furama.repositories;

import Furama.models.Employee;

import java.util.List;

public interface IEmployeeRepository {
    void edit(String id, Employee employee);

    boolean delete(String id);

    List<Employee> search(String name);

    List<Employee> getList();

    boolean add(Employee employee);
}
