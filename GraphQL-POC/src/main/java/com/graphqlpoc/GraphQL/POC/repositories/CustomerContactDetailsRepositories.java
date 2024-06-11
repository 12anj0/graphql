package com.graphqlpoc.GraphQL.POC.repositories;

import com.graphqlpoc.GraphQL.POC.entity.CustomerContactDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerContactDetailsRepositories extends MongoRepository<CustomerContactDetails , String> {
    CustomerContactDetails findByEmail(String email);
    CustomerContactDetails findByMobile(String mobile);
}
