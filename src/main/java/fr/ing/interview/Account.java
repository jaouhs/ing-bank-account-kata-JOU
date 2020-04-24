package fr.ing.interview;

public class Account {
	private Double balance = 0.0d;
	private Customer customer;

	public Account(Customer customer) {
		super();
		this.customer = customer;
	}
	
	

	public Account(Customer customer, Double balance) {
		super();
		this.balance = balance;
		this.customer = customer;
	}



	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Add amount to balance
	 * @param amount
	 */
	public void addAmount(Double amount) {
		this.balance += amount;
		
	}

}
