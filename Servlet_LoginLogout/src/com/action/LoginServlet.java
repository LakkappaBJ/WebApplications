package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static String username = null;

	public LoginServlet() {
		super();
		System.out.println(this.getClass().getSimpleName() + " invoked");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("invoked doPost()");
		PrintWriter writer = null;

		try {
			resp.setContentType("text/html");
			writer = resp.getWriter();
			HttpSession session = req.getSession();

			username = req.getParameter("username");
			String password = req.getParameter("pass");
			if (!username.isEmpty() && username != null && password != null && !password.isEmpty()) {
				if (password.equals("Lucky123")) {
					session.setAttribute("username", username);
					resp.sendRedirect("welcome.jsp?name=" + username);
				} else {
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
					writer.println("<font color=red>password is wrong...</font>");
					requestDispatcher.include(req, resp);
				}
			} else {
				System.out.println("invalid username password");
				writer.println("<font color=red>invalid username password...</font>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
}
