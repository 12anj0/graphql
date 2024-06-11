package com.graphqlpoc.GraphQL.POC.repositories;

import com.graphqlpoc.GraphQL.POC.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer , String> {
    List<Customer> findByName(String name);
    List<Customer> findByRole(String role);
}
