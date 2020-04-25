package fr.ing.interview;


public class IllegalBalanceException extends IllegalAmoutException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 4454540725633550168L;

	public IllegalBalanceException(Double illegalBalance) {
        super(illegalBalance);
    }
    
    public String toString() {
        return "Illegal account balance: " + amount;
    }
}
