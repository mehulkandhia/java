

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("fname");
		String uname1=request.getParameter("lname");
		String password=request.getParameter("pass");
		String mobile=request.getParameter("mobno");
		String emailid=request.getParameter("email");
		
		out.println("First Name:" +uname);
		out.println("Last Name:" +uname1);
		out.println("Password:" +password);
		out.println("Mobile Number:" +mobile);
		out.println("email id:" +emailid);
	}

}
