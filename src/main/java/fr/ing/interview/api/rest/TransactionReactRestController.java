package fr.ing.interview.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ing.interview.dao.TransactionRepository;
import fr.ing.interview.exceptions.IllegalAmoutException;
import fr.ing.interview.model.Transaction;
import fr.ing.interview.service.AccountTransactions;
import fr.ing.interview.service.TransactionRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TransactionReactRestController {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountTransactions accountTransactions;
	
	@Autowired
	private TransactionRule transactionRule;
	
	@GetMapping(value ="/transactions/{id}")
	public Mono<Transaction> getOne(@PathVariable String id){
		return transactionRepository.findById(id);
	}
	
	@PostMapping("/transactions/deposit")
	public Mono<Transaction> deposit(@RequestBody Transaction transaction) throws IllegalAmoutException{
		return accountTransactions.depositMoneyAccount(transaction.getAccount(), transaction.getAmount(), transactionRule);
	}
	
	@PostMapping("/transactions/withdraw")
	public Mono<Transaction> withdraw(@RequestBody Transaction transaction) throws IllegalAmoutException{
		return accountTransactions.withdrawMoneyFromCustomer(transaction.getAccount(), transaction.getAmount(), transactionRule);
	}
	
	@DeleteMapping("/transactions")
	public Mono<Void> delete(@PathVariable String id){
		return transactionRepository.deleteById(id);
	}
	
	@GetMapping(value ="/transactions")
	public Flux<Transaction> findAll(){
		return transactionRepository.findAll();
	}
}
