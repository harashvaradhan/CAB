import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class ViewEmpServlet extends HttpServlet {

  public void doGet (HttpServletRequest req,
                     HttpServletResponse res)
    throws ServletException, IOException
  {
  	PrintWriter out = res.getWriter();
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
		Statement st=connection.createStatement();

		ResultSet rs=st.executeQuery("SELECT * FROM emp");
		out.println("<table border='1' class='table'>");
		out.println("<th>ID</th><th>First Name</th><th>Last Name</th><th>Gender</th><th>Email ID</th><th>Address</th><th>Mobile</th>");
			while(rs.next()){
				String id=rs.getString("e_id");
				String fname=rs.getString("e_fname");
				String lname=rs.getString("e_lname");
				String gender=rs.getString("gender");
				String email_id=rs.getString("email_id");
				String address=rs.getString("address");
				String mob=rs.getString("mobile");
				out.println("<tr><td>"+id+"</td><td>"+fname+"</td><td>"+lname+"</td><td>"+gender+"</td><td>"+email_id+"</td><td>"+address+"</td><td>"+mob+"</td></tr>");
		}
		out.println("</table>");
		rs.close();
		st.close();
		connection.close();
	}
	catch (Exception ex) {}
  }
}