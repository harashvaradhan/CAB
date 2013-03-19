import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class AddUserServlet extends HttpServlet {

  public void doPost (HttpServletRequest req,
                     HttpServletResponse res)
    throws ServletException, IOException
  {
  	String fname = req.getParameter("fname");
  	String lname = req.getParameter("lname");
  	String username = req.getParameter("username");
    String pass = req.getParameter("password");
  	PrintWriter out = res.getWriter();
  	Connection connection=null;
  	Statement st=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
		st=connection.createStatement();

		 //Add the data into the database
		String sql ="INSERT INTO tadmin VALUES (?,?,?,?)";
		PreparedStatement pst =connection.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, fname);
		pst.setString(3, lname);
		pst.setString(4, pass);
		int numRowsChanged = pst.executeUpdate();
		if (numRowsChanged>0) {
            String url = res.encodeRedirectURL("welcome.jsp#view");
            res.sendRedirect(url);
		} /*else {
			String url = response.encodeRedirectURL("welcome.jsp#view");
            response.sendRedirect(url);
		}*/
		// ResultSet rs=st.executeQuery("INSERT INTO tadmin (fname,lname,t_id,password)VALUES('"+fname+"','"+lname+"','"+username+"','"+pass+"')");
		/*out.println("<table border='1'>");
		while(rs.next()){
			String id=rs.getString("t_id");
			String fname=rs.getString("t_fname");
			String lname=rs.getString("t_fname");
			out.println("<tr><td>"+id+"</td><td>"+fname+"</td><td>"+lname+"</td></tr>");
		}
		out.println("</table>");
		rs.close();*/
		st.close();
		// connection.close();
	}
	catch(ClassNotFoundException e){
		out.println("Couldn't load database driver: "+ e.getMessage());
  	}
  	catch(SQLException e){
  		out.println("SQLException caught: "+ e.getMessage());
  	}
	catch (Exception e){
		out.println(e);
	}
	finally {
		// Always close the database connection.
		try {
			if (connection != null)
					connection.close();
		}
		catch (SQLException ignored){
			out.println(ignored);
		}
  	}
  }
}