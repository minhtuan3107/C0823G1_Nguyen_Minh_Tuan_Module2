package Furama.repository.impl;

import Furama.model.Customer;
import Furama.repository.ICustomerRepo;
import Furama.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo {
    private final String FILE = "D:\\module2Again\\src\\Furama\\Utils\\DataCustomer.csv";
    private final String COMMA = ",";

    @Override
    public void edit(String id, Customer customer) {
        List<Customer> customerList = getList();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).equals(id)) {
                customerList.get(i).setId(customer.getId());
                customerList.get(i).setName(customer.getName());
                customerList.get(i).setBirthday(customer.getBirthday());
                customerList.get(i).setGender(customer.getGender());
                customerList.get(i).setIdNumber(customer.getIdNumber());
                customerList.get(i).setPhone(customer.getPhone());
                customerList.get(i).setEmail(customer.getEmail());
                customerList.get(i).setType(customer.getType());
                customerList.get(i).setAddress(customer.getAddress());
                ReadAndWrite.write(convertToString(customerList), FILE, false);
            }
        }
    }

    @Override
    public void delete(String id) {
        List<Customer> customerList = getList();
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                customerList.remove(customer);
            }
        }
        ReadAndWrite.write(convertToString(customerList), FILE, false);
    }

    @Override
    public List<Customer> search(String name) {
        List<Customer> customerList = getList();
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getName().contains(name)) {
                customers.add(customer);
            }
        }
        return customers;
    }

    @Override
    public void add(Customer customer) {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        ReadAndWrite.write(convertToString(customerList), FILE, true);
    }

    @Override
    public List<Customer> getList() {
        List<String> stringList = ReadAndWrite.read(FILE);
        List<Customer> customerList = convertToObj(stringList);
        return customerList;
    }

    public List<Customer> convertToObj(List<String> stringList) {
        List<Customer> customerList = new ArrayList<>();
        String[] line;
        for (String str : stringList) {
            line = str.split(COMMA);
            customerList.add(new Customer(line[0], line[1], line[2], line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]), line[6], line[7], line[8]));
        }
        return customerList;
    }

    public List<String> convertToString(List<Customer> customerList) {
        List<String> stringList = new ArrayList<>();
        for (Customer customer : customerList) {
            stringList.add(customer.getId() + COMMA +
                    customer.getName() + COMMA +
                    customer.getBirthday() + COMMA +
                    customer.getGender() + COMMA +
                    customer.getIdNumber() + COMMA +
                    customer.getPhone() + COMMA +
                    customer.getEmail() + COMMA +
                    customer.getType() + COMMA +
                    customer.getAddress());
        }
        return stringList;
    }
}
