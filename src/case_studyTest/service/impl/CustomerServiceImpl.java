package case_studyTest.service.impl;

import case_studyTest.model.person.Customer;
import case_studyTest.repositories.IPersonRepository;
import case_studyTest.repositories.impl.CustomerRepositoryImpl;
import case_studyTest.service.IPersonService;

import java.util.List;

public class CustomerServiceImpl implements IPersonService<Customer> {
    private final IPersonRepository<Customer> customerRepository = new CustomerRepositoryImpl();

    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    @Override
    public void delete(String id) {
        customerRepository.delete(id);
    }

    @Override
    public List<Customer> display() {
        return customerRepository.display();
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.edit(customer);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return customerRepository.searchByName(name);
    }
}
