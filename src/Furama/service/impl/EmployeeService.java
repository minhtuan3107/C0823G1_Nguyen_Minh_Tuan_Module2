package Furama.service.impl;

import Furama.model.Employee;
import Furama.repository.IEmployeeRepo;
import Furama.repository.impl.EmployeeRepo;
import Furama.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepo employeeRepo = new EmployeeRepo();

    @Override
    public void edit(String id, Employee employee) {
        employeeRepo.edit(id, employee);
    }

    @Override
    public void delete(String id) {
        employeeRepo.delete(id);
    }

    @Override
    public void search(String name) {
        employeeRepo.search(name);
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
