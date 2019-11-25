package za.co.bankingsystem.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import za.co.bankingsystem.model.User;
@Entity
@Table(name = "employees")
public class Employee {
	
		@Column(name = "first_name")
		private String firstName;
		@Column(name = "last_name")
		private String lastName;
		@Id
		@Column(name = "id_number")
		private long idNumber;
		@Column(name = "date_of_birth")
		private String dateOfBirth;
		@Column(name = "phone_number")
		private long phoneNumber;
		@Column(name = "email_address")
		private String email;
		@Column(name = "address")
		private String address;
		@Column(name = "nationality")
		private String nationality;
		@Column(name = "city")
		private String city;
		@Column(name = "country")
		private String country;
		@Column(name = "position")
		private String position;
		@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER )
		private User user;

		
		public Employee() {
			super();
		}

		public Employee(String firstName, String lastName, long idNumber, String dateOfBirth, long phoneNumber,
				String email, String address, String nationality, String city, String country, String position, User user) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.idNumber = idNumber;
			this.dateOfBirth = dateOfBirth;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.address = address;
			this.nationality = nationality;
			this.city = city;
			this.country = country;
			this.position = position;
			this.user = user;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public long getIdNumber() {
			return idNumber;
		}

		public void setIdNumber(long idNumber) {
			this.idNumber = idNumber;
		}

		public String getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public long getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getNationality() {
			return nationality;
		}

		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + ((country == null) ? 0 : country.hashCode());
			result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + (int) (idNumber ^ (idNumber >>> 32));
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
			result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
			result = prime * result + ((position == null) ? 0 : position.hashCode());
			result = prime * result + ((user == null) ? 0 : user.hashCode());
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
			Employee other = (Employee) obj;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (country == null) {
				if (other.country != null)
					return false;
			} else if (!country.equals(other.country))
				return false;
			if (dateOfBirth == null) {
				if (other.dateOfBirth != null)
					return false;
			} else if (!dateOfBirth.equals(other.dateOfBirth))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (idNumber != other.idNumber)
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (nationality == null) {
				if (other.nationality != null)
					return false;
			} else if (!nationality.equals(other.nationality))
				return false;
			if (phoneNumber != other.phoneNumber)
				return false;
			if (position == null) {
				if (other.position != null)
					return false;
			} else if (!position.equals(other.position))
				return false;
			if (user == null) {
				if (other.user != null)
					return false;
			} else if (!user.equals(other.user))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", idNumber=" + idNumber
					+ ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", email=" + email
					+ ", address=" + address + ", nationality=" + nationality + ", city=" + city + ", country="
					+ country + ", position=" + position + ", user=" + user + "]";
		}
			
}
