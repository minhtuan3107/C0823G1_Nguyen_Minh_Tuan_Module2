package Furama.repositories.impl;

import Furama.models.Customer;
import Furama.repositories.ICustomerRepository;
import Furama.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String FILE = "D:\\module2Again\\src\\Furama\\Utils\\DataCustomer.csv";
    private final String COMMA = ",";

    @Override
    public void edit(String id, Customer customer) {
        List<Customer> customerList = getList();
        for (Customer customer1 : customerList) {
            if (customer1.getId().equals(id)) {
                customer1.setId(customer.getId());
                customer1.setName(customer.getName());
                customer1.setBirthday(customer.getBirthday());
                customer1.setGender(customer.getGender());
                customer1.setIdNumber(customer.getIdNumber());
                customer1.setPhone(customer.getPhone());
                customer1.setEmail(customer.getEmail());
                customer1.setType(customer.getType());
                customer1.setAddress(customer.getAddress());
                ReadAndWrite.write(convertToString(customerList), FILE, false);
                break;
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
            customerList.add(new Customer(line[0],
                    line[1], line[2], line[3],
                    Integer.parseInt(line[4]),
                    Integer.parseInt(line[5]),
                    line[6], line[7], line[8]));
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
