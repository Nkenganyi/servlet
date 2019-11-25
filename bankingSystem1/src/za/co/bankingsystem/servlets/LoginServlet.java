package za.co.bankingsystem.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.bankingsystem.entities.Employee;

@WebServlet("/login.jsp")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// System.out.println("....");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		String jpaPersistenceName = "jpaPersistenceUnit";
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory(jpaPersistenceName);
			em = emf.createEntityManager();
			em.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Employee> employees = em.createQuery("SELECT e FROM Employee e").getResultList();

			for (int i = 0; i < employees.size(); i++) {

				if (username.equals(employees.get(i).getUser().getUsername())
						&& password.equals(employees.get(i).getUser().getPassword())
						&& employees.get(i).getPosition().equalsIgnoreCase("TELLER")) {
					req.setAttribute("message", "login successful");

					req.getRequestDispatcher("pages/employeeDashboard.jsp").forward(req, resp);
					
				} else if (username.equals(employees.get(i).getUser().getUsername())
						&& password.equals(employees.get(i).getUser().getPassword())
						&& employees.get(i).getPosition().equalsIgnoreCase("MANAGER")) {

					
					req.getRequestDispatcher("pages/managerDashboard.jsp").forward(req, resp);

				}
					

			}
			if (username.equals("Nkenganyi") && password.equals("nkeng54")) {
				
				req.setAttribute("message", "Login successful");
				req.getRequestDispatcher("pages/managerDashboard.jsp").forward(req, resp);
			} else {
				req.setAttribute("message", "Invalid login credentials");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("pages/managerDashboard.jsp").forward(req, resp);
		req.getRequestDispatcher("pages/employeeDashboard.jsp").forward(req, resp);
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
