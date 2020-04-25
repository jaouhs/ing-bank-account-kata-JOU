package fr.ing.interview;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ing.interview.exceptions.IllegalAmoutException;
import fr.ing.interview.exceptions.IllegalBalanceException;
import fr.ing.interview.model.Account;
import fr.ing.interview.model.Customer;
import fr.ing.interview.service.AccountTransactions;
import fr.ing.interview.service.TransactionRule;
import fr.ing.interview.service.impl.AccountTransactionsImpl;
import fr.ing.interview.service.impl.TransactionRuleImpl;

public class AccountTest {
	
	Customer customer;
	Account account;
	AccountTransactions accountTransactions;
	TransactionRule transactionRule;
	Double amount = 0.0d;

	@BeforeEach
	void setUp() throws Exception {
		customer = new Customer("Antony", "ID 987 8785 9887");
		account = new Account(customer, "ACC ID 125", 1000.0d);
		customer.getAccounts().add(account);
		accountTransactions = new AccountTransactionsImpl();
		transactionRule = new TransactionRuleImpl();
	}

	/**
	 * Test with amount less and other greater than 0.01 euro  
	 */
	@Test
	void testdDepositMoneyFromCustomer() {
		amount = 0.0d;

		/*
		assertThatThrownBy(() -> accountTransactions.depositMoneyAccount(account, amount, transactionRule))
		.isInstanceOf(IllegalAmoutException.class).hasMessageContaining("Illegal amount:");
		*/

		try {
			accountTransactions.depositMoneyAccount(account, amount, transactionRule);
			assertTrue(false);
		} catch (IllegalAmoutException e) {
			assertTrue(true);
		}

		amount = 1000.0d;
		try {
			accountTransactions.depositMoneyAccount(account, amount, transactionRule);
			assertTrue(true);
		} catch (IllegalAmoutException e) {
			assertTrue(false);
		}

	}
	
	/**
	 * Initial balance value is 1000.0 euro
	 */
	@Test
	void testWithdrawMoneyFromCustomer() { 
		amount = 2000.0d;
		
		/*
		assertThatThrownBy(() -> accountTransactions.withdrawMoneyFromCustomer(account, amount, transactionRule))
		.isInstanceOf(IllegalBalanceException.class).hasMessageContaining("Illegal balance:");
		*/
		try {
			
			accountTransactions.withdrawMoneyFromCustomer(account, amount, transactionRule);
			assertTrue(false);
		} catch (IllegalBalanceException e) {
			assertTrue(true);
		}

		amount = 500.0d;
		try {
			accountTransactions.withdrawMoneyFromCustomer(account, amount, transactionRule);
			assertTrue(true);
		} catch (IllegalBalanceException e) {
			assertTrue(false);
		}
	}
	/**
	 * Display customer with account balance
	 */
	@Test
	void testDisplaydisplayAccountBalance() { 
		
		assertTrue(customer != null  
				&& customer.getAccounts().size() != 0
				&& customer.getAccounts().get(0).getBalance() == 1000.0d);
		
	}
	
	/**
	 * Account transactions history
	 */
	
	@Test
	void testDisplayHistory() throws IllegalBalanceException, IllegalAmoutException{
		amount = 100.0d;
		accountTransactions.depositMoneyAccount(account, amount, transactionRule);
		amount = 900.0d;
		accountTransactions.depositMoneyAccount(account, amount, transactionRule);
		amount = 5000.0d;
		accountTransactions.depositMoneyAccount(account, amount, transactionRule);

		amount = 120.0d;
		accountTransactions.withdrawMoneyFromCustomer(account, amount, transactionRule);
		amount = 300.0d;
		accountTransactions.withdrawMoneyFromCustomer(account, amount, transactionRule);
		amount = 1100.0d;
		accountTransactions.withdrawMoneyFromCustomer(account, amount, transactionRule);
		
		assertTrue(accountTransactions.getTranscations().size() == 6);
	}
}
