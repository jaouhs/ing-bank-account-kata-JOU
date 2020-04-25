package fr.ing.interview.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.ing.interview.Account;
import fr.ing.interview.AccountTransactions;
import fr.ing.interview.IllegalAmoutException;
import fr.ing.interview.IllegalBalanceException;
import fr.ing.interview.Transaction;
import fr.ing.interview.TransactionRule;

public class AccountTransactionsImpl implements AccountTransactions {
	
	List<Transaction> transcations = new ArrayList<Transaction>();

	public List<Transaction> getTranscations() {
		return transcations;
	}

	@Override
	public void depositMoneyAccount(Account account, Double amount, TransactionRule transactionRule) throws IllegalAmoutException {
		if(account == null || transactionRule == null) {
			throw new NullPointerException("Account or trasactionRule undefined");
		}
		
		if(!transactionRule.depositAllowed(amount)) {
			throw new IllegalAmoutException(amount);
		}
		account.addAmount(amount);
		transcations.add(new Transaction(account, new Date(), amount));
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
		transcations.add(new Transaction(account, new Date(), -amount));
	}
	

}
