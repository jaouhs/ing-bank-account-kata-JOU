package fr.ing.interview;

public class Account {
	private Double balance = 0.0d;
	private Customer customer;
	private String identifier;

	public Account(Customer customer, String identifier) {
		super();
		this.customer = customer;
		this.identifier = identifier;
	}
	
	public Account(Customer customer, String identifier, Double balance) {
		super();
		this.balance = balance;
		this.identifier = identifier;
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
	
	
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * Add amount to balance
	 * @param amount
	 */
	public void addAmount(Double amount) {
		this.balance += amount;
		
	}

}
