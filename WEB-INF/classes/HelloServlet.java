import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class HelloServlet extends HttpServlet {

  public void doGet (HttpServletRequest req,
                     HttpServletResponse res)
    throws ServletException, IOException
  {
  	PrintWriter out = res.getWriter();
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
		Statement st=connection.createStatement();

		ResultSet rs=st.executeQuery("Select * from emp");
		out.println("<table border='1'>");
		while(rs.next()){
			String name=rs.getString("e_fname");
			String add=rs.getString("address");
			out.println("<tr><td>"+name+"</td><td>"+add+"</td></tr>");
		}
		out.println("</table>");
		rs.close();
		st.close();
		connection.close();
	}
	catch (Exception ex) {}
  }
}