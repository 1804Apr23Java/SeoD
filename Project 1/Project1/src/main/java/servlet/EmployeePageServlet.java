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
import domain.Reimburse;
import util.MasterLogic;
import util.MasterRedirect;


public class EmployeePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmployeePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/employee.html").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MasterLogic.process(request, response);
		System.out.println("Master Logic");
	}

}
