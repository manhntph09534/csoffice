package com.example.cs_office.Controller;

import com.example.cs_office.Model.Customer;
import com.example.cs_office.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @PutMapping(path = "{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") int customerId,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String fisrtName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Date createDate,
            @RequestParam(required = false) boolean status
    ) {
        customerService.updateCustomer(customerId, phoneNumber, email, password, fisrtName, lastName, address, createDate, status);
    }
}
