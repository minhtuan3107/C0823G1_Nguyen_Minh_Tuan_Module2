package Furama.controllers;

import Furama.models.Employee;
import Furama.services.IEmployeeService;
import Furama.services.impl.EmployeeService;

import java.util.List;

public class EmployeeController {
    private final IEmployeeService employeeService = new EmployeeService();

    public void edit(String id, Employee employee) {
        employeeService.edit(id, employee);
    }

    public void delete(String id) {
        employeeService.delete(id);
    }

    public List<Employee> search(String name) {
        return employeeService.search(name);
    }

    public List<Employee> getList() {
        return employeeService.getList();
    }

    public void add(Employee employee) {
        employeeService.add(employee);
    }
}
