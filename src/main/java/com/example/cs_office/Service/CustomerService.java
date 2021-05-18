package com.example.cs_office.Service;

import com.example.cs_office.Model.Customer;
import com.example.cs_office.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomer() {

        return customerRepository.findAll();
    }

    public Optional<Customer> getById(int userId) {
        Optional<Customer> customer = customerRepository.findById(userId);
        return customer;
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional =
                customerRepository.findCustomerById(customer.getId());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException("Id taken");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(int customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if (!exists) {
            throw new IllegalStateException("customer with id " + customerId + " does not exists");
        }
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(int customerId, String fullname, String email, String password, String fisrtName, String lastName, String address, Date create_Date, boolean status) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new IllegalStateException("user with id" + customerId + "does not exists"));
//        if(fullname != null && fullname.length() > 0 && !Objects.equals(user.getFullname(),fullname)){
//            customer.setFullname(fullname);
//        }
    }
}
