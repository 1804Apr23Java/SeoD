package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
import org.apache.tomcat.util.http.fileupload.MultipartStream;

import javax.servlet.annotation.WebServlet;


import dao.ReimburseImageDAO;
import dao.ReimburseImageIMPL;
*/

/**
 * Servlet implementation class UploadFileServlet
 */
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * BufferedReader reader = new BufferedReader(new
		 * InputStreamReader(request.getInputStream())); for (String line; (line =
		 * reader.readLine()) != null;) { System.out.println(line); }
		 */
		
		/*

		MultipartStream savedFile;
		savedFile = itemView.getImgFile();// file from model attribute
		Blob blob = Hibernate.createBlob(savedFile.getInputStream());
*/
	}

}
