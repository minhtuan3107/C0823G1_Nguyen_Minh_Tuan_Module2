package Furama.controller;

import Furama.model.Employee;
import Furama.service.IEmployeeService;
import Furama.service.impl.EmployeeService;

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
