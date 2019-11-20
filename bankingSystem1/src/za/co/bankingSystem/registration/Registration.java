package za.co.bankingSystem.registration;

import java.time.LocalDate;


import za.co.bankingSystem.account.Account;
import za.co.bankingSystem.account.card.Card;
import za.co.bankingSystem.databaseManager.DatabaseManager;
import za.co.bankingSystem.person.customer.Customer;
import za.co.bankingSystem.person.employee.Employee;
import za.co.bankingSystem.person.user.User;

public class Registration {

	public static void employeeRegister(Employee employee, User user) {
		
		
		try {

			DatabaseManager.getEntitymanager().getTransaction().begin();
			employee.setUser(user);
			user.setEmployee(employee);
			DatabaseManager.getEntitymanager().persist(employee);
			DatabaseManager.getEntitymanager().persist(user);
			DatabaseManager.getEntitymanager().getTransaction().commit();
			DatabaseManager.getEntitymanager().close();
		} catch (Exception ex) {

			DatabaseManager.getEntitymanager().getTransaction().rollback();
			ex.printStackTrace();
			DatabaseManager.getEntitymanager().close();
		}
	}

	public static void createAccount(Customer customer, Account account, Card card) {

		card.setAccount(account);
		customer.getAccounts().add(account);

		try {

			//DatabaseManager.getEntitymanager().getTransaction().begin();
			DatabaseManager.getEntitymanager().persist(customer);
			DatabaseManager.getEntitymanager().persist(account);
			DatabaseManager.getEntitymanager().persist(card);
			DatabaseManager.getEntitymanager().getTransaction().commit();
			DatabaseManager.getEntitymanager().close();

		} catch (Exception ex) {

			DatabaseManager.getEntitymanager().getTransaction().rollback();
			ex.printStackTrace();
			DatabaseManager.getEntitymanager().close();

		}

	}
}
