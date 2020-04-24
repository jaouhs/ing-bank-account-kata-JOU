package fr.ing.interview;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {
	
	Customer customer;
	Account account;

	@BeforeEach
	void setUp() throws Exception {
		customer = new Customer();
		account = new Account();
	}

	@Test
	void testdDepositMoneyFromCustomer() {
		fail("Not yet implemented");
	}

}
