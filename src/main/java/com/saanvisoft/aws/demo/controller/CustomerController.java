package com.saanvisoft.aws.demo.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saanvisoft.aws.demo.ResourceNotFoundException;
import com.saanvisoft.aws.demo.service.Customer;
import com.saanvisoft.aws.demo.service.CustomerRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository kitchenCustomerRepository;

    @PostMapping("/saveCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return kitchenCustomerRepository.save(customer);
    }


    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {

        return ResponseEntity.ok(kitchenCustomerRepository.findAll());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Integer CustomerId)
            throws ResourceNotFoundException {
        Customer Customer = kitchenCustomerRepository.findById(CustomerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerId));
        return ResponseEntity.ok().body(Customer);
    }

    @PutMapping("/Customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Integer CustomerId,
                                                   @RequestBody Customer CustomerDetails) throws ResourceNotFoundException {
        Customer Customer = kitchenCustomerRepository.findById(CustomerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerId));

        Customer.setCustFirstName(CustomerDetails.getCustFirstName());
        Customer.setBillingAddress(CustomerDetails.getBillingAddress());
        Customer.setCustPhone(CustomerDetails.getCustPhone());
        Customer.setCustZipCode(CustomerDetails.getCustZipCode());

        final Customer updatedCustomer = kitchenCustomerRepository.save(Customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/customers/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Integer CustomerId)
            throws ResourceNotFoundException {
        Customer Customer = kitchenCustomerRepository.findById(CustomerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerId));

        kitchenCustomerRepository.delete(Customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

