package com.example.cs_office.Controller;

import com.example.cs_office.Model.Customer;
import com.example.cs_office.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

    @PostMapping
    public void insertCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
    }

    @GetMapping(path = "{customerId}")
    public Optional<Customer> getById(
            @PathVariable("customerId") int customerId) {
        return customerService.getById(customerId);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(
            @PathVariable("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") int userId,
            @RequestParam(required = false) String fullname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String avatar,
            @RequestParam(required = false) String password) {
        customerService.updateCustomer(userId, fullname,email,avatar,password);
    }

}
