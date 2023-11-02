package case_studyTest.repositories.impl;

import case_studyTest.model.person.Employee;
import case_studyTest.repositories.IConvert;
import case_studyTest.repositories.IPersonRepository;
import case_studyTest.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IPersonRepository<Employee>, IConvert<Employee> {
    private final String EMPLOYEE_PATH = "/Users/macbook/Documents/GitHub/C0723G1-PhamThanhHuu/module_2/untitled/src/case_study/data/employee_data.csv";

    @Override
    public void add(Employee employee) {
        List<Employee> employees = new ArrayList<>();
//                convertToObject(FileUtil.readFile(EMPLOYEE_PATH));
        employees.add(employee);
        FileUtil.writeFile(EMPLOYEE_PATH, this.convertToString(employees),true);
    }

    @Override
    public void delete(String id) {
        List<Employee> employees = display();
        for (Employee employee : employees) {
            if (employee.getIdEmployee().equals(id)) {
                employees.remove(employee);
                break;
            }
        }
        FileUtil.writeFile(EMPLOYEE_PATH, this.convertToString(employees),false);
    }

    @Override
    public List<Employee> display() {
        return convertToObject(FileUtil.readFile(EMPLOYEE_PATH));
    }

    @Override
    public List<Employee> convertToObject(List<String> strings) {
        List<Employee> employees = new ArrayList<>();
        for (String s : strings) {
            String[] data = s.split(COMMA);
            employees.add(new Employee(data[0],
                    data[1],
                    data[2],
                    data[3],
                    data[4],
                    data[5],
                    data[6],
                    data[7],
                    data[8],
                    data[9]));
        }
        return employees;
    }

    @Override
    public List<String> convertToString(List<Employee> employees) {
        List<String> employeeData = new ArrayList<>();
        for (Employee employee : employees) {
            employeeData.add(
                    employee.getName()
                            + COMMA + employee.getDateOfBirth()
                            + COMMA + employee.getGender()
                            + COMMA + employee.getIdCard()
                            + COMMA + employee.getPhoneNumber()
                            + COMMA + employee.getEmail()
                            + COMMA + employee.getIdEmployee()
                            + COMMA + employee.getAcademicLevel()
                            + COMMA + employee.getJobPosition()
                            + COMMA + employee.getSalary());
        }
        return employeeData;
    }

    @Override
    public void edit(Employee employee) {
        List<Employee> employees = display();
        for (Employee employee1 : employees) {
            if (employee1.getIdEmployee().equals(employee.getIdEmployee())) {
                employee1.setName(employee.getName());
                employee1.setDateOfBirth(employee.getDateOfBirth());
                employee1.setGender(employee.getGender());
                employee1.setIdCard(employee.getIdCard());
                employee1.setPhoneNumber(employee.getPhoneNumber());
                employee1.setEmail(employee.getEmail());
                employee1.setAcademicLevel(employee.getAcademicLevel());
                employee1.setJobPosition(employee.getJobPosition());
                employee1.setSalary(employee.getSalary());
            }
        }
        FileUtil.writeFile(EMPLOYEE_PATH, this.convertToString(employees),false);
    }

    @Override
    public List<Employee> searchByName(String name) {
        List<Employee> employees = display();
        List<Employee> newEmployee = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getName().contains(name)){
                newEmployee.add(employee);
            }
        }
        return newEmployee;
    }
}
