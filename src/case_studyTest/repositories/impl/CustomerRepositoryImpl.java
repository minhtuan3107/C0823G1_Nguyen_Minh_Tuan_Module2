package case_studyTest.repositories.impl;

import case_studyTest.model.person.Customer;
import case_studyTest.repositories.IConvert;
import case_studyTest.repositories.IPersonRepository;
import case_studyTest.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements IPersonRepository<Customer>, IConvert<Customer> {
    private final String CUSTOMER_PATH = "/Users/macbook/Documents/GitHub/C0723G1-PhamThanhHuu/module_2/untitled/src/case_study/data/customer_data.csv";

    @Override
    public List<Customer> convertToObject(List<String> strings) {
        List<Customer> customers = new ArrayList<>();
        for (String s : strings) {
            String[] data = s.split(COMMA);
            customers.add(new Customer(data[0],
                    data[1],
                    data[2],
                    data[3],
                    data[4],
                    data[5],
                    data[6],
                    data[7],
                    data[8]));
        }
        return customers;
    }

    @Override
    public List<String> convertToString(List<Customer> customers) {
        List<String> customerData = new ArrayList<>();
        for (Customer customer : customers) {
            customerData.add(customer.getName()
                    + COMMA + customer.getDateOfBirth()
                    + COMMA + customer.getGender()
                    + COMMA + customer.getIdCard()
                    + COMMA + customer.getPhoneNumber()
                    + COMMA + customer.getEmail()
                    + COMMA + customer.getIdCustomer()
                    + COMMA + customer.getTypeOfCustomer()
                    + COMMA + customer.getAddress());
        }
        return customerData;
    }

    @Override
    public void edit(Customer customer) {
        List<Customer> customers = display();
        for (Customer customer1 : customers) {
            if (customer1.getIdCustomer().equals(customer.getIdCustomer())) {
                customer1.setName(customer.getName());
                customer1.setDateOfBirth(customer.getDateOfBirth());
                customer1.setGender(customer.getGender());
                customer1.setIdCard(customer.getIdCard());
                customer1.setPhoneNumber(customer.getPhoneNumber());
                customer1.setEmail(customer.getEmail());
                customer1.setTypeOfCustomer(customer.getTypeOfCustomer());
                customer1.setAddress(customer.getAddress());
            }
        }
        FileUtil.writeFile(CUSTOMER_PATH, this.convertToString(customers),false);
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customers = display();
        List<Customer> newCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                newCustomers.add(customer);
            }
        }
        return newCustomers;
    }

    @Override
    public void add(Customer customer) {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        FileUtil.writeFile(CUSTOMER_PATH, this.convertToString(customers),true);
    }

    @Override
    public void delete(String id) {
        List<Customer> customers = display();
        for (Customer customer : customers) {
            if (customer.getIdCustomer().equals(id)) {
                customers.remove(customer);
                break;
            }
        }
        FileUtil.writeFile(CUSTOMER_PATH, this.convertToString(customers),false);
    }

    @Override
    public List<Customer> display() {
        return convertToObject(FileUtil.readFile(CUSTOMER_PATH));
    }
}
