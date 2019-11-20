package za.co.bankingsystem.exceptions;

public class AccountNotFoundException extends RuntimeException {
	private static final String MESSAGE = "Account not found!";

	public AccountNotFoundException() {

		super(MESSAGE);

	}

	public AccountNotFoundException(String message) {

		super(message);
	}
}
