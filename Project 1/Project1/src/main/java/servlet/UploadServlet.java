package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReimburseDAO;
import dao.ReimburseIMPL;
import dao.UserDAO;
import dao.UserIMPL;


public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		String username = (String) session.getAttribute("username");
		double registered_expenses = Double.parseDouble(request.getParameter("expenses"));
		ReimburseDAO rd = new ReimburseIMPL();
		rd.insertNewReimbursement(username, registered_expenses);
		response.sendRedirect("employee");
	}

}
