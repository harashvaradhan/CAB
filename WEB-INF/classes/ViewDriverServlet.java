import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class ViewDriverServlet extends HttpServlet {

  public void doGet (HttpServletRequest req,
                     HttpServletResponse res)
    throws ServletException, IOException
  {
  	PrintWriter out = res.getWriter();
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
		Statement st=connection.createStatement();

		ResultSet rs=st.executeQuery("SELECT * FROM driver");
		out.println("<table border='1' class='table'>");
		out.println("<th>ID</th><th>First Name</th><th>Last Name</th><th>Mobile</th><th>Address</th><th>Status</th>");
			while(rs.next()){
				// D_FNAME D_LNAME D_ID MOBILE C_ID ADDRESS DOJ STATUS 
				String id=rs.getString("D_ID");
				String fname=rs.getString("D_FNAME");
				String lname=rs.getString("D_LNAME");
				String mobile=rs.getString("MOBILE");
				String address=rs.getString("ADDRESS");
				String status=rs.getString("STATUS");
				out.println("<tr><td>"+id+"</td><td>"+fname+"</td><td>"+lname+"</td><td>"+mobile+"</td><td>"+address+"</td><td>"+status+"</td></tr>");
		}
		out.println("</table>");
		rs.close();
		st.close();
		connection.close();
	}
	catch (Exception ex) {}
  }
}