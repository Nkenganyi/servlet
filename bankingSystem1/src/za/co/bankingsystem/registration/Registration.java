package za.co.bankingsystem.registration;


import za.co.bankingsystem.databaseManager.DatabaseManager;
import za.co.bankingsystem.model.Account;
import za.co.bankingsystem.model.Card;
import za.co.bankingsystem.model.Customer;
import za.co.bankingsystem.model.Employee;
import za.co.bankingsystem.model.User;

public class Registration {

	public static void employeeRegister(Employee employee, User user) {
		
		
		try {

			DatabaseManager.getEntitymanager().getTransaction().begin();
			employee.setUser(user);
			//user.setEmployee(employee);
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
