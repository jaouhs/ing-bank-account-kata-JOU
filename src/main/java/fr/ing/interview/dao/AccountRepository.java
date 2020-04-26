package fr.ing.interview.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import fr.ing.interview.model.Account;

public interface AccountRepository extends ReactiveMongoRepository<Account, String>{

}
