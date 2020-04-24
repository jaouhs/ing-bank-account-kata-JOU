package fr.ing.interview;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ing.interview.impl.AccountTransactionsImpl;
import fr.ing.interview.impl.TransactionRuleImpl;

public class AccountTest {
	
	Customer customer;
	Account account;
	AccountTransactions accountTransactions;
	TransactionRule transactionRule;
	Double amount = 0.0d;

	@BeforeEach
	void setUp() throws Exception {
		customer = new Customer();
		account = new Account(customer, 1000.0d);
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
	
	
}
