package fr.ing.interview;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private String identifier;
	
	private List<Account> accounts = new ArrayList<Account>();
	
	public Customer() {
		super();
	}
	
	public Customer(String name, String identifier) {
		super();
		this.name = name;
		this.identifier = identifier;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
