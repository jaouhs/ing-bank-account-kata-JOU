package fr.ing.interview;

public class IllegalAmoutException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3412917120277134411L;

	protected Double amount;
    
    public IllegalAmoutException(Double illegalAmount) {
    	amount = illegalAmount;
    }
    
    public String toString() {
        return "Illegal amount: " + amount;
    }
}
