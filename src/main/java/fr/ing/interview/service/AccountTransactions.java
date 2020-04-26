package fr.ing.interview.service;


import fr.ing.interview.exceptions.IllegalAmoutException;
import fr.ing.interview.exceptions.IllegalBalanceException;
import fr.ing.interview.model.Account;
import fr.ing.interview.model.Transaction;
import reactor.core.publisher.Mono;

public interface AccountTransactions {
	public Mono<Transaction> depositMoneyAccount(Account account, Double amount, TransactionRule transactionRule) throws IllegalAmoutException;
	public Mono<Transaction> withdrawMoneyFromCustomer(Account account, Double amount, TransactionRule transactionRule) throws IllegalBalanceException;
	//public List<Transaction> getTranscations();
}
