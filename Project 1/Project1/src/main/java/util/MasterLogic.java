package util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ReimburseDAO;
import dao.ReimburseIMPL;
import dao.UserDAO;
import dao.UserIMPL;
import domain.Reimburse;
import domain.User;

public class MasterLogic {
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		int permissions = (int) session.getAttribute("permissions");
		UserDAO ud = new UserIMPL();
		ReimburseDAO rd = new ReimburseIMPL();
		
		switch (request.getParameter("stringParameter")) {
		//Get all reimbursements from database, handle separation via reimbursementRequest.js
		case "employeeAll": 
		case "employeePending":
		case "employeeRejected": 
		case "employeeResolved": {
			
			List<Reimburse> listReimburse = rd.getReimursementByUserAccount(username);
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String listString = om.writeValueAsString(listReimburse);
			response.getWriter().write(listString);
			System.out.println(request.getParameter("stringParameter"));
			break;
		}
		
		case "employeeInfo": {
			
			User currentUser = ud.getUserInfo(username);
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String listString = om.writeValueAsString(currentUser);
			response.getWriter().write(listString);
			break;
		}
		case "employeeUpdate": {
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String email = request.getParameter("new_email");
			ud.updateUserInfo(username, firstName, lastName, email);
			break;
		}
		
		case "managerViewAllEmployee": {

			List<User> listUsers = ud.getAllUsers();
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String listUString = om.writeValueAsString(listUsers);
			response.getWriter().write(listUString);
			break;
		}
		
		case "managerViewAllReimbursements": {

			List<Reimburse> listReimburse = rd.getAllReimbursements();
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String listRString = om.writeValueAsString(listReimburse);
			response.getWriter().write(listRString);
			break;
		}
		}
	}

}