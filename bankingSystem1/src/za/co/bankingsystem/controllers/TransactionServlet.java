package za.co.bankingsystem.controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.bankingsystem.model.Account;


public class TransactionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("pages/idNum.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Printing ....");
		String jpaPersistenceName = "jpaPersistenceUnit";
		EntityManagerFactory emf =null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory(jpaPersistenceName);
			em = emf.createEntityManager();
		
			
			long accNo = Long.parseLong(req.getParameter("accountNumber"));
			
			
			Account acc = em.find(Account.class, accNo);
			
			req.setAttribute("actions", acc);
			req.getRequestDispatcher("pages/trans.jsp").forward(req, resp);

			if(acc != null) {
			
			
			}else {
				req.setAttribute("exception", "Account does not exist");
				req.getRequestDispatcher("pages/idNum.jsp").forward(req, resp);
				
			}

		} catch (Exception ex) {
			System.out.println(ex);
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
