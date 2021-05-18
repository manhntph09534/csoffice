package com.example.cs_office.Service;

import com.example.cs_office.Model.Customer;
import com.example.cs_office.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public void updateCustomer(int userId, String fullname, String email, String avatar, String password) {
        Customer customer = customerRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user with id" + userId + "does not exists"));

//        if(fullname != null && fullname.length() > 0 && !Objects.equals(user.getFullname(),fullname)){
//            customer.setFullname(fullname);
//        }
//        if(email != null && email.length() > 0 && !Objects.equals(user.getEmail(),email)){
//            user.setEmail(email);
//        }
//        if(avatar != null && avatar.length() > 0 && !Objects.equals(user.getAvatar(),avatar)){
//            user.setAvatar(avatar);
//        }
//        if(password != null && password.length() > 0 && !Objects.equals(user.getPassword(),password)){
//            user.setPassword(password);
    }
}
