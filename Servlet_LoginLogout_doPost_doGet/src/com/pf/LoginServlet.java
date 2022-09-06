package com.pf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("invoked doPost()");
		
		// Set the content type of response to "text/html"
		response.setContentType("text/html");
		// Get the print writer object to write into the response
		PrintWriter writer_ui = response.getWriter();
		// Get the session object
		HttpSession session = request.getSession();

		
		// Get User entered details from the request using request parameter.
		String username = request.getParameter("username");
		String password = request.getParameter("pass");

		
		 // Validate the password - If password is correct, 
        // set the user in this session
        // and redirect to welcome page
		if (password.equals("Lucky123")) {
			System.out.println("Password is correct");
			session.setAttribute("username", username);
			response.sendRedirect("welcome.jsp?name=" + username);
			
			// If the password is wrong, display the error message on the login page.
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			writer_ui.println("<font color=red>Password is wrong...</font>");
			requestDispatcher.include(request, response);

		}
		 // Close the print writer object.
		writer_ui.close();

	}

}
