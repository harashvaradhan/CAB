import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class ViewCabServlet extends HttpServlet {

  public void doGet (HttpServletRequest req,
                     HttpServletResponse res)
    throws ServletException, IOException
  {
  	PrintWriter out = res.getWriter();
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
		Statement st=connection.createStatement();
		//C_ID V_NUMBER STATUS
		ResultSet rs=st.executeQuery("SELECT * FROM cab");
		out.println("<table border='1' class='table'>");
		out.println("<th>ID</th><th>Vehicle Number</th><th>Status</th>");
		while(rs.next()){
			String id=rs.getString("C_ID");
			String v_number=rs.getString("V_NUMBER");
			String status=rs.getString("STATUS");
			out.println("<tr><td>"+id+"</td><td>"+v_number+"</td><td>"+status+"</td></tr>");
		}
		out.println("</table>");
		rs.close();
		st.close();
		connection.close();
	}
	catch (Exception ex) {}
  }
}