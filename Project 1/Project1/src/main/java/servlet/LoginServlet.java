package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.UserDAO;
import dao.UserIMPL;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/login.html").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//authenticate user
		UserDAO ud = new UserIMPL();
		int userCheck = ud.checkLoginInfo(username, password);
		session.setAttribute("username", username);
		session.setAttribute("permissions", userCheck);

		if(userCheck == 1) 
		{
			session.setAttribute("problem", null);
			response.sendRedirect("employee");
		}
		else if (userCheck == 2)
		{
			
			session.setAttribute("problem", null);
			response.sendRedirect("manager");
		}
			
		else {
			session.setAttribute("problem", "incorrect password");
			response.sendRedirect("login");
		}
	}

}
