package Furama.repository.impl;

import Furama.utils.ReadAndWrite;
import Furama.model.Employee;
import Furama.repository.IEmployeeRepo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepo {
    private final String COMA = ",";
    private final String FILE = "D:\\module2Again\\src\\Furama\\Utils\\DataEmployee";

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
                ReadAndWrite.write(convertToString(employeeList), FILE,false);
            }
        }
    }


    @Override
    public void delete(String id) {
        List<Employee> employees = getList();
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employees.remove(employee);
                ReadAndWrite.write(convertToString(employees), FILE,false);
                break;
            }
        }
    }

    @Override
    public void search(String name) {
        List<Employee> employeeList = getList();
        for (Employee employee : employeeList) {
            if (employee.getName().contains(name)) {
                System.out.println(employee);
            }
        }
    }

    @Override
    public List<Employee> getList() {
        List<String> stringList = ReadAndWrite.read(FILE);
        List<Employee> employeeList = convertToObj(stringList);
        return employeeList;
    }

    @Override
    public void add(Employee employee) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        ReadAndWrite.write(convertToString(employeeList), FILE,true);
    }

    public List<String> convertToString(List<Employee> employeeList) {
        List<String> stringList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringList.add(employee.getId() + COMA +
                    employee.getName() + COMA +
                    employee.getBirthday() + COMA +
                    employee.getGender() + COMA +
                    employee.getIdNumber() + COMA +
                    employee.getPhone() + COMA +
                    employee.getEmail() + COMA +
                    employee.getLevel() + COMA +
                    employee.getLocation() + COMA +
                    employee.getWage() + COMA);
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
