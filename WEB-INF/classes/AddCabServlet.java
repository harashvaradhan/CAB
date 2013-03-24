import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class AddCabServlet extends HttpServlet {

  public void doPost (HttpServletRequest req,
                     HttpServletResponse res)
    throws ServletException, IOException
  {
  	String cab_id = req.getParameter("cab_id");
  	String v_number = req.getParameter("v_number");
  	PrintWriter out = res.getWriter();

  	Connection connection=null;
  	Statement st=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
		st=connection.createStatement();

		 //Add the data into the database
		String sql ="INSERT INTO cab (C_ID, V_NUMBER) VALUES('"+cab_id+"','"+v_number+"')";
		out.print(sql);
		int numRowsChanged = st.executeUpdate(sql);
		if (numRowsChanged>0) {
            String url = res.encodeRedirectURL("welcome_tadmin.jsp#viewcab");
            res.sendRedirect(url);
		} else {
			String url = res.encodeRedirectURL("welcome_tadmin.jsp#viewcab");
            res.sendRedirect(url);
		}
		st.close();
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