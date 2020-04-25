package fr.ing.interview;

import fr.ing.interview.TransactionRule;

public interface AccountTransactions {
	public void depositMoneyAccount(Account account, Double amount, TransactionRule transactionRule) throws IllegalAmoutException;
	public void withdrawMoneyFromCustomer(Account account, Double amount, TransactionRule transactionRule) throws IllegalBalanceException;

}
