package za.co.bankingSystem.account;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import za.co.bankingSystem.account.card.Card;
import za.co.bankingSystem.account.transaction.Transaction;
import za.co.bankingSystem.exceptions.InvalidAmountException;

@Entity
@Table(name ="accounts")
public class Account {
	
	@Id
	@Column(name = "acccount_number")
	private long accountNumber;
	@Column(name = "acccount_type")
	private String accountType;
	@Column(columnDefinition = "DECIMAL(19.4)")
	private double balance;
	//@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	//private Card card;
	@OneToMany(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    List<Transaction>transactions = new ArrayList<>();
	
	
	
	
	public Account() {
		super();
		String generateAccountNumber = String.valueOf(new Random().nextLong()).substring(1,14);
		this.accountNumber = Long.parseLong(generateAccountNumber);
	}

	public Account(long accountNumber, String accountType, double balance, Card card, List<Transaction> transactions) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		//this.card = card;
		this.transactions = transactions;
		
		String generateAccountNumber = String.valueOf(new Random().nextLong()).substring(1,14);
		this.accountNumber = Long.parseLong(generateAccountNumber);
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/*public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}*/
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	public void makeDeposit(double amount)throws InvalidAmountException {
		//DatabaseManager.getEntitymanager().close();
		//DatabaseManager.getEntitymanager().getTransaction().begin();
		Transaction transaction = new Transaction();
		if(amount < 0 | amount == 0) {
			throw new InvalidAmountException();
		}else {
			this.balance += amount;
			transaction.setTransactionBalance(amount);
			transaction.setTransactionDateTime(LocalDateTime.now());
			transaction.setTransactionType("DEPOSIT");
			this.getTransactions().add(transaction);
		}
		
	}
	
	public void makeWithdrawal(double amount)throws InvalidAmountException {
		//DatabaseManager.getEntitymanager().close();
		//DatabaseManager.getEntitymanager().getTransaction().begin();
		Transaction transaction = new Transaction();
		if(amount > this.balance | amount < 0 | amount == 0) {
			throw new InvalidAmountException();
		}else {
			this.balance -= amount;
			transaction.setTransactionBalance(amount);
			transaction.setTransactionDateTime(LocalDateTime.now());
			transaction.setTransactionType("WITHDRAW");
			this.getTransactions().add(transaction);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (transactions == null) {
			if (other.transactions != null)
				return false;
		} else if (!transactions.equals(other.transactions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance=" + balance
				+ ", transactions=" + transactions + "]";
	}
	
	
}
