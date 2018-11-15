

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register1
 */
@WebServlet("/Register1")
public class Register1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String fname1=request.getParameter("fname");
		String lname1=request.getParameter("lname");
		String pass1=request.getParameter("pass");
		String pass2=request.getParameter("confpass");
		String mobile=request.getParameter("mobno");
		String email1=request.getParameter("email");
		
		out.println("First Name:" +fname1 +"\n");
		out.println("Last Name:" +lname1 +"\n");
		out.println("Password" +pass1 +"\n");
		out.println("Confirm Password" +pass2 +"\n");
		out.println("Mobile Number" +mobile +"\n");
		out.println("Email id" +email1);
	}

}
