package fr.ing.interview;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.ing.interview.dao.AccountRepository;
import fr.ing.interview.dao.CustomerRepository;
import fr.ing.interview.dao.TransactionRepository;
import fr.ing.interview.exceptions.IllegalAmoutException;
import fr.ing.interview.exceptions.IllegalBalanceException;
import fr.ing.interview.model.Account;
import fr.ing.interview.model.Customer;
import fr.ing.interview.service.AccountTransactions;
import fr.ing.interview.service.TransactionRule;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataMongoTest
class AccountTest {

	@Autowired(required = true)
	AccountTransactions accountTransactions;
	@Autowired(required = true)
	TransactionRule transactionRule;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	TransactionRepository transactionRepository;

	Customer customer;
	Account account;

	Double amount = 0.0d;

	@BeforeEach
	void setUp() throws Exception {
		customer = new Customer("cus Id", "Antony", "ID 987 8785 9887", new ArrayList<Account>());
		customerRepository.save(customer);
		account = new Account("acc Id", 1000.0d, customer, "ACC ID 125");
		customer.getAccounts().add(account);

		/*
		 * accountRepository.save(account).subscribe(acc -> { account = acc; });
		 * 
		 * customerRepository.save(customer).subscribe(cus -> { customer = cus; });;
		 */
		// accountTransactions = new AccountTransactionsImpl();
		// transactionRule = new TransactionRuleImpl();
	}

	/**
	 * Test with amount less and other greater than 0.01 euro
	 */
	@Test
	void testdDepositMoneyFromCustomer() {
		amount = 0.0d;

		/*
		 * assertThatThrownBy(() -> accountTransactions.depositMoneyAccount(account,
		 * amount, transactionRule)) .isInstanceOf(IllegalAmoutException.class).
		 * hasMessageContaining("Illegal amount:");
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
		 * assertThatThrownBy(() ->
		 * accountTransactions.withdrawMoneyFromCustomer(account, amount,
		 * transactionRule)) .isInstanceOf(IllegalBalanceException.class).
		 * hasMessageContaining("Illegal balance:");
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

		assertTrue(customer != null && customer.getAccounts().size() != 0
				&& customer.getAccounts().get(0).getBalance() == 1000.0d);

	}

	/**
	 * Account transactions history
	 */

	@Test
	void testDisplayHistory() throws IllegalBalanceException, IllegalAmoutException {

		amount = 100.0d;
		accountTransactions.depositMoneyAccount(account, amount, transactionRule).subscribe(null, t -> {
			assertTrue(t != null);
		});
		amount = 900.0d;
		accountTransactions.depositMoneyAccount(account, amount, transactionRule).subscribe(null, t -> {
			assertTrue(t != null);
		});
		;
		amount = 5000.0d;
		accountTransactions.depositMoneyAccount(account, amount, transactionRule).subscribe(null, t -> {
			assertTrue(t != null);
		});
		;

		amount = 120.0d;
		accountTransactions.withdrawMoneyFromCustomer(account, amount, transactionRule).subscribe(null, t -> {
			assertTrue(t != null);
		});
		;
		amount = 300.0d;
		accountTransactions.withdrawMoneyFromCustomer(account, amount, transactionRule).subscribe(null, t -> {
			assertTrue(t != null);
		});
		;
		amount = 1100.0d;
		accountTransactions.withdrawMoneyFromCustomer(account, amount, transactionRule).subscribe(null, t -> {
			assertTrue(t != null);
		});
		;

		transactionRepository.count().subscribe(count -> {
			assertTrue(count != 0);

		});

	}
}
