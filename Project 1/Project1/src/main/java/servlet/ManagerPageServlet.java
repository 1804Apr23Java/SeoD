package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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


public class ManagerPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ManagerPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/manager.html").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		String username = (String) session.getAttribute("username");
		int permissions = (int) session.getAttribute("permissions");
		UserDAO ud = new UserIMPL();
		//ReimburseDAO rd = new ReimburseIMPL();
		//List<Reimburse> listReimburse = rd.getReimursementByUserAccount("notadmin");
		List<User> listUsers = ud.getAllUsers();
		response.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		//String listRString = om.writeValueAsString(listReimburse);
		String listUString = om.writeValueAsString(listUsers);
		//response.getWriter().write(listRString);
		response.getWriter().write(listUString);
	}

}
