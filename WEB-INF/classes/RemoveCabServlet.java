import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class RemoveCabServlet extends HttpServlet {

  public void doPost (HttpServletRequest req,
                     HttpServletResponse res)
    throws ServletException, IOException
  {
  	String cab_id = req.getParameter("cab_id");
  	String message = null;
  	PrintWriter out = res.getWriter();

  	Connection connection=null;
  	Statement st=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
		st=connection.createStatement();

		String sql ="DELETE FROM cab WHERE c_id= '"+cab_id+"'  and  status <> 'Allotted'";
		out.print(sql);
		int numRowsChanged = st.executeUpdate(sql);
		if (numRowsChanged>0) {
            String url = res.encodeRedirectURL("welcome_tadmin.jsp#viewcab");
            res.sendRedirect(url);
		} else {
			message = "Cannot remove Allotted Cab.";
            req.setAttribute("message", message);
            req.getRequestDispatcher("error_tadmin.jsp").forward(req, res);
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