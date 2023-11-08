package Furama.repositories.impl;

import Furama.models.person.Employee;
import Furama.repositories.IEmployeeRepository;
import Furama.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final String COMMA = ",";
    private final String FILE = "D:\\Module2.1\\src\\Furama\\Utils\\DataEmployee.csv";

    @Override
    public void edit(String id, Employee employee) {
        List<Employee> employeeList = getList();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                employeeList.get(i).setName(employee.getName());
                employeeList.get(i).setBirthday(employee.getBirthday());
                employeeList.get(i).setGender(employee.getGender());
                employeeList.get(i).setIdNumber(employee.getIdNumber());
                employeeList.get(i).setPhone(employee.getPhone());
                employeeList.get(i).setEmail(employee.getEmail());
                employeeList.get(i).setLevel(employee.getLevel());
                employeeList.get(i).setLocation(employee.getLocation());
                employeeList.get(i).setWage(employee.getWage());
                ReadAndWrite.write(convertToString(employeeList), FILE, false);
            }
        }
    }


    @Override
    public boolean delete(String id) {
        List<Employee> employees = getList();
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employees.remove(employee);
                ReadAndWrite.write(convertToString(employees), FILE, false);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Employee> search(String name) {
        List<Employee> employeeList = getList();
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getName().contains(name)) {
                employees.add(employee);
            }
        }
        return employees;
    }

    @Override
    public List<Employee> getList() {
        List<String> stringList = ReadAndWrite.read(FILE);
        List<Employee> employeeList = convertToObj(stringList);
        return employeeList;
    }

    @Override
    public boolean add(Employee employee) {
        List<Employee> employeeList = getList();
        List<Employee> employeeList1 = new ArrayList<>();
        for (Employee employee1 : employeeList) {
            if (employee1.getId().equals(employee.getId())) {
                return false;
            }
        }
        employeeList1.add(employee);
        ReadAndWrite.write(convertToString(employeeList1), FILE, true);
        return true;
    }

    public List<String> convertToString(List<Employee> employeeList) {
        List<String> stringList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringList.add(employee.getId() + COMMA +
                    employee.getName() + COMMA +
                    employee.getBirthday() + COMMA +
                    employee.getGender() + COMMA +
                    employee.getIdNumber() + COMMA +
                    employee.getPhone() + COMMA +
                    employee.getEmail() + COMMA +
                    employee.getLevel() + COMMA +
                    employee.getLocation() + COMMA +
                    employee.getWage() + COMMA);
        }
        return stringList;
    }

    public List<Employee> convertToObj(List<String> stringList) {
        List<Employee> employeeList = new ArrayList<>();
        String[] line;
        for (String str : stringList) {
            line = str.split(",");
            employeeList.add(new Employee(line[0], line[1], line[2], line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]), line[6], line[7], line[8], Integer.parseInt(line[9])));
        }
        return employeeList;
    }
}
