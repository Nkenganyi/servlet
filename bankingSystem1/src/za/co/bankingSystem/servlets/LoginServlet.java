package za.co.bankingSystem.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			if (username .equals("Nkenganyi") && password.equals("nkeng54")) {
				Thread.sleep(2000);
				req.setAttribute("message", "Login successful");
				req.getRequestDispatcher("pages/managerDashboard.jsp").forward(req, resp);
			} else {
				req.setAttribute("message", "Invalid login credentials");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		} catch (ServletException | IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
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
