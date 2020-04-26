package fr.ing.interview.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import fr.ing.interview.model.Customer;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
	
}
