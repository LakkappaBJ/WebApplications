package com.action;
// To save vaues from ui to json
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/EmployeeDetails")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeDetails() {
		super();
		System.out.println(this.getClass().getSimpleName() + " invoked");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("invoked doPost()" + this.getClass().getSimpleName());
		response.setContentType("application/json");
		JSONArray array = new JSONArray();
		PrintWriter writer = null;
		FileWriter data = null;
		try {
			writer = response.getWriter();
			// HttpSession session = request.getSession();
			String employee_Id ="PF"+request.getParameter("EmpId");
			String employee_Name = request.getParameter("EmpName");
			String employee_salary = request.getParameter("salary");
			System.out.println(employee_Id + " " + employee_Name + " " + employee_salary);
			try {
				JSONObject object = new JSONObject();
				object.put("EmployeeID", employee_Id);
				object.put("EmployeeName", employee_Name);
				object.put("salary", employee_salary);
				array.add(object);
			} catch (Exception e) {
				e.printStackTrace();
			}

//			File file = new File("emp.json");
//			System.out.println(file.createNewFile());

			data = new FileWriter("C:\\J2eeDev\\eclipse-2019\\emp.json");
			data.write(array.toJSONString());
			System.out.println("Data is saved successfully");
			response.sendRedirect("welcome.jsp?name="+LoginServlet.username);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			data.close();
			writer.close();
		}

	}
}
