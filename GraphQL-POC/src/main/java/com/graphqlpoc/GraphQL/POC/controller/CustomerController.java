package com.graphqlpoc.GraphQL.POC.controller;

import com.graphqlpoc.GraphQL.POC.entity.Customer;
import com.graphqlpoc.GraphQL.POC.entity.CustomerContactDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import com.graphqlpoc.GraphQL.POC.repositories.CustomerContactDetailsRepositories;
import com.graphqlpoc.GraphQL.POC.repositories.CustomerRepository;

import java.util.Optional;
import java.util.UUID;

@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerContactDetailsRepositories customerContactDetailsRepositories;

    @QueryMapping
    public Customer customerById(@Argument String id){
        Optional<Customer> customer = customerRepository.findById(id);
        System.out.println(customer);
        return customer.isPresent() ? customer.get() : null;
    }

    @MutationMapping
    public Customer addCustomer(@Argument String name ,@Argument int age , @Argument String role){
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setAge(age);
        customer.setName(name);
        customer.setRole(role);

        customerRepository.insert(customer);
        System.out.println(customer);

        return customer;
    }
}
