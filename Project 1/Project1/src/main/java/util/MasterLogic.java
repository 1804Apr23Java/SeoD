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
		// Get all reimbursements from database, handle separation via
		// reimbursementRequest.js
		case "employeeAll":
		case "employeePending":
		case "employeeRejected":
		case "employeeResolved": {

			List<Reimburse> listReimburse = rd.getReimbursementByUserAccount(username);
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
			String newPassword = request.getParameter("new_password");
			String email = request.getParameter("new_email");
			ud.updateUserInfo(username, firstName, lastName, email);
			ud.changePassword(username, newPassword);
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

		case "managerViewReimbursementsViaUser": {
			// System.out.println("Name: " + request.getParameter("requestingUser"));
			String employeeSearch = request.getParameter("requestingUser");
			List<Reimburse> listReimburse = rd.getReimbursementByUserAccount(employeeSearch);
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String listRString = om.writeValueAsString(listReimburse);
			response.getWriter().write(listRString);
			break;

		}

		case "singleReimbursementById": {
			int reId = Integer.parseInt(request.getParameter("requestingReimburse"));
			Reimburse re = rd.getReimburseById(reId);
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String listRString = om.writeValueAsString(re);
			response.getWriter().write(listRString);
			break;
		}

		case "Reject": {
			rd.changePendingState(Integer.parseInt(request.getParameter("requestingReimburse")), username, 1);
			Reimburse re = rd.getReimburseById(Integer.parseInt(request.getParameter("requestingReimburse")));
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String listRString = om.writeValueAsString(re);
			response.getWriter().write(listRString);
			break;
		}

		case "Resolve": {
			rd.changePendingState(Integer.parseInt(request.getParameter("requestingReimburse")), username, 2);
			Reimburse re = rd.getReimburseById(Integer.parseInt(request.getParameter("requestingReimburse")));
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String listRString = om.writeValueAsString(re);
			response.getWriter().write(listRString);
			break;
		}
		}
	}

}