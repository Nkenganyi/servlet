package za.co.bankingsystem.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.bankingsystem.entities.Account;
import za.co.bankingsystem.entities.Card;
import za.co.bankingsystem.entities.Customer;
//import za.co.jpa_bank.databaseManger.DatabaseManager;

@SuppressWarnings("unused")
public class DepositServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("pages/deposit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("Depositing....");
		String jpaPersistenceName = "jpaPersistenceUnit";
		EntityManagerFactory emf =null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory(jpaPersistenceName);
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			long accNo = Long.parseLong(req.getParameter("accountNumber"));
			double amount = Double.parseDouble(req.getParameter("amount"));
			
			Account account = em.find(Account.class, accNo);
			
			account.makeDeposit(amount);
		
			
			
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
