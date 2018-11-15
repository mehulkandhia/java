

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class feel
 */
@WebServlet("/feel")
public class feel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public feel() {
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
		//try(PrintWriter out = response.getWriter())
		//{
		int id=2;
		String uname=request.getParameter("name");
		String sal=request.getParameter("salary");
		try
		{
			Class.forName("org.h2.Driver");
		Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","System","Namrata4#");
		PreparedStatement pst,pst1;
		pst=con.prepareStatement("select * from Employee");
		ResultSet r1 = pst.executeQuery();
		if(r1.next())
		{
		id=r1.getInt(1);
        id++;
		int rs;
		pst1=con.prepareStatement("insert into Employee values(?,?,?)");
		pst1.setInt(1, id);
		pst1.setString(2, uname);
		pst1.setString(3, sal);
		rs=pst1.executeUpdate();
		if(rs>0)
		{
			System.out.println("Row inserted Successfully");
		}
		else
		{
			System.out.println("Row insertion failed");
		}
		
		con.close();
	}
		}
	
		//catch(ClassNotFoundException sc)
        //{
          //  System.out.println("<h1>Error occurred in connection class</h1>"+sc);
        //}
	//}
	catch(Exception e)
	{
		System.out.println("Exception arised:" +e);
	}	
	}
	}
//}
