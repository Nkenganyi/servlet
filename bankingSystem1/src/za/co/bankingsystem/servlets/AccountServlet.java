package za.co.bankingsystem.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.bankingsystem.entities.Customer;
import za.co.bankingsystem.entities.Account;
import za.co.bankingsystem.entities.Card;

public class AccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("pages/account.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Started saving....");
		String jpaPersistenceName = "jpaPersistenceUnit";
		EntityManagerFactory emf =null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory(jpaPersistenceName);
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			Customer customer = new Customer();
			Account account = new Account();
			Card card = new Card();

			customer.setFirstName(req.getParameter("firstName"));
			customer.setLastName(req.getParameter("lastName"));
			long idNumber = Long.parseLong(req.getParameter("idNumber"));
			customer.setIdNumber(idNumber);
			String date = req.getParameter("dateOfBirth");
			customer.setDateOfBirth(date);
			long phone = Long.parseLong(req.getParameter("phoneNumber"));
			customer.setPhoneNumber(phone);
			customer.setEmail(req.getParameter("emailAddress"));
			customer.setAddress(req.getParameter("address"));
			customer.setNationality(req.getParameter("nationality"));
			customer.setCity(req.getParameter("city"));
			customer.setCountry(req.getParameter("country"));
			account.setAccountType(req.getParameter("username"));
			String pp = req.getParameter("pin");
			int pin = Integer.valueOf(pp);
			card.setPin(pin);
			card.setCardType(req.getParameter("cardType"));
			
			customer.getAccounts().add(account);
			card.setAccount(account);
			
			em.persist(customer);
			em.persist(account);
			em.persist(card);

			em.getTransaction().commit();
			//req.getRequestDispatcher("pages/employeeDashboard.jsp").forward(req, resp);

		} catch (Exception ex) {
			ex.printStackTrace();
			if(em!=null)
			em.getTransaction().rollback();
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
