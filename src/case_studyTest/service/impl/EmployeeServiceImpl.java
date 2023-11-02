package case_studyTest.service.impl;

import case_studyTest.model.person.Employee;
import case_studyTest.repositories.IPersonRepository;
import case_studyTest.repositories.impl.EmployeeRepositoryImpl;
import case_studyTest.service.IPersonService;

import java.util.List;

public class EmployeeServiceImpl implements IPersonService<Employee> {
    private final IPersonRepository<Employee> employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public void add(Employee employee) {
        employeeRepository.add(employee);
    }

    @Override
    public void delete(String id) {
        employeeRepository.delete(id);
    }

    @Override
    public List<Employee> display() {
        return employeeRepository.display();
    }

    @Override
    public void edit(Employee employee) {
        employeeRepository.edit(employee);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepository.searchByName(name);
    }
}
