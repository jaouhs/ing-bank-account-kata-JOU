package fr.ing.interview.service;

public interface TransactionRule {
	
	public boolean depositAllowed(Double amount);
	
	public boolean withdrawAllowed(Double amount);

}
