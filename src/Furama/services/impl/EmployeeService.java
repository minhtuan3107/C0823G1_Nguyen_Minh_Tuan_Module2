package Furama.services.impl;

import Furama.models.Employee;
import Furama.repositories.IEmployeeRepository;
import Furama.repositories.impl.EmployeeRepository;
import Furama.services.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepo = new EmployeeRepository();

    @Override
    public void edit(String id, Employee employee) {
        employeeRepo.edit(id, employee);
    }

    @Override
    public void delete(String id) {
        employeeRepo.delete(id);
    }

    @Override
    public List<Employee> search(String name) {
        return employeeRepo.search(name);
    }

    @Override
    public List<Employee> getList() {
        return employeeRepo.getList();
    }

    @Override
    public void add(Employee employee) {
        employeeRepo.add(employee);
    }
}
