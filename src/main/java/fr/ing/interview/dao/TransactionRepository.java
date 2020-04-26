package fr.ing.interview.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import fr.ing.interview.model.Transaction;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String>{

}
