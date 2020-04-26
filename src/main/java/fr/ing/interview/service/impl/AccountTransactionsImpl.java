package fr.ing.interview.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.ing.interview.dao.TransactionRepository;
import fr.ing.interview.exceptions.IllegalAmoutException;
import fr.ing.interview.exceptions.IllegalBalanceException;
import fr.ing.interview.model.Account;
import fr.ing.interview.model.Transaction;
import fr.ing.interview.service.AccountTransactions;
import fr.ing.interview.service.TransactionRule;

public class AccountTransactionsImpl implements AccountTransactions {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	//List<Transaction> transcations = new ArrayList<Transaction>();

	/*public List<Transaction> getTranscations() {
		return transcations;
	}*/

	@Override
	public void depositMoneyAccount(Account account, Double amount, TransactionRule transactionRule) throws IllegalAmoutException {
		if(account == null || transactionRule == null) {
			throw new NullPointerException("Account or trasactionRule undefined");
		}
		
		if(!transactionRule.depositAllowed(amount)) {
			throw new IllegalAmoutException(amount);
		}
		account.addAmount(amount);
		//transcations.add(new Transaction(null, account, new Date(), amount));
		transactionRepository.save(new Transaction(null, account, new Date(), amount) );
	}

	@Override
	public void withdrawMoneyFromCustomer(Account account, Double amount, TransactionRule transactionRule)
			throws IllegalBalanceException {
		
		if(account == null || transactionRule == null) {
			throw new NullPointerException("Account or trasactionRule undefined");
		}
		
		Double newBalance = account.getBalance() - amount;
		
		if(!transactionRule.withdrawAllowed(newBalance)) {
			throw new IllegalBalanceException(newBalance);
		}
		account.setBalance(newBalance);
		//transcations.add(new Transaction(null, account, new Date(), -amount));
		transactionRepository.save(new Transaction(null, account, new Date(), amount));
	}
	

}
