package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;


import dao.UserDAO;
import dao.UserIMPL;
import domain.User;
import util.MasterLogic;

/**
 * Servlet implementation class EmployeeInfo
 */
public class EmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		String username = (String) session.getAttribute("username");
		String changeFirstName = request.getParameter("first_name");
		String changeLastName = request.getParameter("last_name");
		String changeEmail = request.getParameter("new_email");
		UserDAO ud = new UserIMPL();
		ud.updateUserInfo(username, changeFirstName, changeLastName, changeEmail);
		response.sendRedirect("employee");
		/*
		MasterLogic.process(request, response);
		System.out.println("Master Logic");
		*/
	}

}
