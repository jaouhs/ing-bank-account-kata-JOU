package fr.ing.interview.model;

import java.util.Date;

public class Transaction {
	private Account account;
	private Date date;
	private Double amount;
	
	public Transaction(Account account, Date date, Double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}	
}
