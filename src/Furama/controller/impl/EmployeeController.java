package Furama.controller.impl;

import Furama.controller.IEmployeeController;
import Furama.model.Employee;
import Furama.service.IEmployeeService;
import Furama.service.impl.EmployeeService;

import java.util.List;

public class EmployeeController implements IEmployeeController {
    private final IEmployeeService employeeService = new EmployeeService();

    @Override
    public void edit(String id, Employee employee) {
        employeeService.edit(id, employee);
    }

    @Override
    public void delete(String id) {
        employeeService.delete(id);
    }

    @Override
    public void search(String name) {
        employeeService.search(name);
    }

    @Override
    public List<Employee> getList() {
        return employeeService.getList();
    }

    @Override
    public void add(Employee employee) {
        employeeService.add(employee);
    }
}
