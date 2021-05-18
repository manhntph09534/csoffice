package com.example.cs_office.Repository;

import com.example.cs_office.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select s from Customer s where s.id = ?1")
    Optional<Customer> findCustomerById(Integer integer);

}
