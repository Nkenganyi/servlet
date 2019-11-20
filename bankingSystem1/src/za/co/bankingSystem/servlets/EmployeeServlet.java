package za.co.bankingSystem.servlets;

import java.io.IOException;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.bankingSystem.person.employee.Employee;
import za.co.bankingSystem.person.user.User;
//import za.co.bankingSystem.registration.Registration;

@SuppressWarnings("serial")
public class EmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String jpaPersistenceName = "jpaPersistenceUnit";
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory(jpaPersistenceName);
		 EntityManager em = emf.createEntityManager();

		try {
			
		em.getTransaction().begin();
		Employee employee = new Employee();
		User user = new User();
		
		employee.setFirstName(req.getParameter("firstName"));
		employee.setLastName(req.getParameter("lastName"));
		long idNumber = Long.parseLong(req.getParameter("idNumber"));
		employee.setIdNumber(idNumber);
		String date = req.getParameter("dateOfBirth");
		employee.setDateOfBirth(date);
		long phone = Long.parseLong(req.getParameter("phoneNumber"));
		employee.setPhoneNumber(phone);
		employee.setEmail(req.getParameter("emailAddress"));
		employee.setAddress(req.getParameter("address"));
		employee.setNationality("nationality");
		employee.setCity(req.getParameter("city"));
		employee.setCountry(req.getParameter("country"));
		employee.setPosition(req.getParameter("position"));
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		
		employee.setUser(user);
		user.setEmployee(employee);
		
		em.persist(employee);
		em.persist(user);
		
		em.getTransaction().commit();
			
		}catch(Exception ex) {
		ex.printStackTrace();
		em.getTransaction().rollback();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
}
