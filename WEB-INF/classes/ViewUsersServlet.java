import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class ViewUsersServlet extends HttpServlet {

  public void doGet (HttpServletRequest req,
                     HttpServletResponse res)
    throws ServletException, IOException
  {
  	PrintWriter out = res.getWriter();
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
		Statement st=connection.createStatement();

		ResultSet rs=st.executeQuery("SELECT * FROM tadmin");
		out.println("<table border='1' class='table'>");
		out.println("<th>ID</th><th>First Name</th><th>Last Name</th>");
		while(rs.next()){
			String id=rs.getString("t_id");
			String fname=rs.getString("t_fname");
			String lname=rs.getString("t_lname");
			out.println("<tr><td>"+id+"</td><td>"+fname+"</td><td>"+lname+"</td></tr>");
		}
		out.println("</table>");
		rs.close();
		st.close();
		connection.close();
	}
	catch (Exception ex) {}
  }
}