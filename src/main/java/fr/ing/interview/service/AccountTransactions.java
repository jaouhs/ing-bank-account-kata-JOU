package fr.ing.interview.service;


import fr.ing.interview.exceptions.IllegalAmoutException;
import fr.ing.interview.exceptions.IllegalBalanceException;
import fr.ing.interview.model.Account;

public interface AccountTransactions {
	public void depositMoneyAccount(Account account, Double amount, TransactionRule transactionRule) throws IllegalAmoutException;
	public void withdrawMoneyFromCustomer(Account account, Double amount, TransactionRule transactionRule) throws IllegalBalanceException;
	//public List<Transaction> getTranscations();
}
