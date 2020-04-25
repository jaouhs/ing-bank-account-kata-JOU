package fr.ing.interview.impl;

import fr.ing.interview.Account;
import fr.ing.interview.AccountTransactions;
import fr.ing.interview.IllegalAmoutException;
import fr.ing.interview.IllegalBalanceException;
import fr.ing.interview.TransactionRule;

public class AccountTransactionsImpl implements AccountTransactions {

	@Override
	public void depositMoneyAccount(Account account, Double amount, TransactionRule transactionRule) throws IllegalAmoutException {
		if(account == null || transactionRule == null) {
			throw new NullPointerException("Account or trasactionRule undefined");
		}
		
		if(!transactionRule.depositAllowed(amount)) {
			throw new IllegalAmoutException(amount);
		}
		account.addAmount(amount);
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
	}

}
