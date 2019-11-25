package za.co.bankingsystem.model;

import javax.persistence.CascadeType;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import za.co.bankingsystem.model.Employee;

@Entity
@Table(name = "user_details")
public class User {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "user_Id")
		private int userId;
		@Column(name = "username")
		private String username;
		@Column(name = "password")
		private String password;
		
		//@OneToOne(cascade = CascadeType.ALL)
		//private Employee employee;
		
		/*public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}*/

		public User() {
			super();
		}

		public User(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		
		
		
		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			//result = prime * result + ((employee == null) ? 0 : employee.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + userId;
			result = prime * result + ((username == null) ? 0 : username.hashCode());
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
			User other = (User) obj;
			
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (userId != other.userId)
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", employee="
					+  "]";
		}
		
		
}
