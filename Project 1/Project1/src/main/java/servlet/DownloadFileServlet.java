package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import dao.ReimburseImageDAO;
import dao.ReimburseImageIMPL;
import domain.Image;

/**
 * Servlet implementation class DownloadFileServlet
 */
public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reId = Integer.parseInt(request.getParameter("downloadingImage"));
		ReimburseImageDAO rid = new ReimburseImageIMPL();
		Image pic = rid.getOneImage(reId);
		System.out.println("getting blob");
		Blob blobPic = pic.getImageFile();
		System.out.println("got blob");
		try {
			InputStream in = blobPic.getBinaryStream();
			response.setContentType("image/png");
			OutputStream out = response.getOutputStream();
			IOUtils.copy(in,out);
			in.close();
			out.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
