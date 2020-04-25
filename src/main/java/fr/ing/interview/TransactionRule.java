package fr.ing.interview;

public interface TransactionRule {
	
	public boolean depositAllowed(Double amount);
	
	public boolean withdrawAllowed(Double amount);

}