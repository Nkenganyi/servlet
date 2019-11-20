package za.co.bankingsystem.exceptions;

public class InsufficientFundException extends RuntimeException{
	private static final String MESSAGE = "Your balance is lower than withdrawal amount";

	public InsufficientFundException() {

		super(MESSAGE);
	}

	public InsufficientFundException(String message) {
		super(message);
	}
}
