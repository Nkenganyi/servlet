package za.co.bankingsystem.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "transaction")
public class Transaction {		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "transaction_id")
		private int transaction_id;
		@Column(name = "transaction_type")
		private String transactionType;
		@Column(name = "transaction_balance")
		private double transactionBalance;
		@Column(name = "transaction_date_time")
		private LocalDateTime transactionDateTime;
		
			
		public Transaction() {
			super();
		}
		
			
		public Transaction(int transaction_id, String transactionType, double transactionBalance,
				LocalDateTime transactionDateTime) {
			super();
			this.transaction_id = transaction_id;
			this.transactionType = transactionType;
			this.transactionBalance = transactionBalance;
			this.transactionDateTime = transactionDateTime;
		}


		public int getTransaction_id() {
			return transaction_id;
		}


		public void setTransaction_id(int transaction_id) {
			this.transaction_id = transaction_id;
		}

		public String getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}
		public double getTransactionBalance() {
			return transactionBalance;
		}
		public void setTransactionBalance(double transactionBalance) {
			this.transactionBalance = transactionBalance;
		}
		public LocalDateTime getTransactionDateTime() {
			return transactionDateTime;
		}
		public void setTransactionDateTime(LocalDateTime transactionDateTime) {
			this.transactionDateTime = transactionDateTime;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(transactionBalance);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((transactionDateTime == null) ? 0 : transactionDateTime.hashCode());
			result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
			result = prime * result + transaction_id;
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
			Transaction other = (Transaction) obj;
			if (Double.doubleToLongBits(transactionBalance) != Double.doubleToLongBits(other.transactionBalance))
				return false;
			if (transactionDateTime == null) {
				if (other.transactionDateTime != null)
					return false;
			} else if (!transactionDateTime.equals(other.transactionDateTime))
				return false;
			if (transactionType == null) {
				if (other.transactionType != null)
					return false;
			} else if (!transactionType.equals(other.transactionType))
				return false;
			if (transaction_id != other.transaction_id)
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "Transaction [transaction_id=" + transaction_id + ", transactionType=" + transactionType
					+ ", transactionBalance=" + transactionBalance + ", transactionDateTime=" + transactionDateTime
					+ "]";
		}



}
