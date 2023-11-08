package Furama.controllers;

import Furama.models.person.Employee;
import Furama.services.IEmployeeService;
import Furama.services.impl.EmployeeService;

import java.util.List;

public class EmployeeController {
    private final IEmployeeService employeeService = new EmployeeService();

    public void edit(String id, Employee employee) {
        employeeService.edit(id, employee);
    }

    public boolean delete(String id) {
        return employeeService.delete(id);
    }

    public List<Employee> search(String name) {
        return employeeService.search(name);
    }

    public List<Employee> getList() {
        return employeeService.getList();
    }

    public boolean add(Employee employee) {
        return employeeService.add(employee);
    }
}
