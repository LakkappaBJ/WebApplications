package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try (PrintWriter writer = resp.getWriter();) {
			resp.setContentType("text/html");
			System.out.println("Session before invalidate: " + req.getSession(false));
			req.getSession(false).invalidate();
			System.out.println("Session after invalidate: " + req.getSession(false));
			writer.println("Thank you! You are successfully logged out..");
//			writer.close();
		}

	}
}
