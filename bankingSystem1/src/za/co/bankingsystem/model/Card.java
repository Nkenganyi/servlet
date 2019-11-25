package za.co.bankingsystem.model;

import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import za.co.bankingsystem.model.Account;
@Entity
@Table(name = "card")
public class Card {
	
	    @Id
	    
		@Column(name = "card_number")
		private long cardNumber;
		@Column(name = "pin")
		private int pin;
		@Column(name = "card_type")
		private String cardType;
		@OneToOne(cascade = CascadeType.ALL)
		private Account account;
		
		
		public Account getAccount() {
			return account;
		}

		public void setAccount(Account account) {
			this.account = account;
		}

		public Card() {
			super();
			String generateCardNumber = String.valueOf(new Random().nextLong()).substring(1,14);
			this.cardNumber = Long.parseLong(generateCardNumber);
		}
		
		public Card(long cardNumber, int pin, String cardType) {
			super();
			this.cardNumber = cardNumber;
			this.pin = pin;
			this.cardType = cardType;
		}
		
		public long getCardNumber() {
			return cardNumber;
		}
		public void setCardNumber(long cardNumber) {
			this.cardNumber = cardNumber;
		}
		public int getPin() {
			return pin;
		}
		public void setPin(int pin) {
			this.pin = pin;
		}
		public String getCardType() {
			return cardType;
		}
		public void setCardType(String cardType) {
			this.cardType = cardType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((account == null) ? 0 : account.hashCode());
			result = prime * result + (int) (cardNumber ^ (cardNumber >>> 32));
			result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
			result = prime * result + pin;
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
			Card other = (Card) obj;
			if (account == null) {
				if (other.account != null)
					return false;
			} else if (!account.equals(other.account))
				return false;
			if (cardNumber != other.cardNumber)
				return false;
			if (cardType == null) {
				if (other.cardType != null)
					return false;
			} else if (!cardType.equals(other.cardType))
				return false;
			if (pin != other.pin)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Card [cardNumber=" + cardNumber + ", pin=" + pin + ", cardType=" + cardType + ", account=" + account
					+ "]";
		}
		
}
