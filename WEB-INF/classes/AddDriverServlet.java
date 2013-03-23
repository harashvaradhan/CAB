import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class AddDriverServlet extends HttpServlet {

  public void doPost (HttpServletRequest req,
                     HttpServletResponse res)
    throws ServletException, IOException
  {
  	//E_FNAME, E_LNAME, E_ID, EMAIL_ID, MOBILE, ADDRESS, LOCALITY, UNIT, GENDER

  	String fname = req.getParameter("d_fname");
  	String lname = req.getParameter("d_lname");
  	String did = req.getParameter("d_id");
	String addr = req.getParameter("address");
  	String mob = req.getParameter("mobile");

  	PrintWriter out = res.getWriter();

  	// out.print(fname+lname+eid+email+addr+mob+loc+unt+gen);
  	Connection connection=null;
  	Statement st=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
		st=connection.createStatement();
		// D_FNAME D_LNAME D_ID MOBILE C_ID ADDRESS DOJ STATUS
		 //Add the data into the database
		String sql ="INSERT INTO driver (D_FNAME,D_LNAME,D_ID,MOBILE,ADDRESS) VALUES('"+fname+"','"+lname+"','"+did+"','"+mob+"','"+addr+"')";
		// out.print(sql);
		int numRowsChanged = st.executeUpdate(sql);
		if (numRowsChanged>0) {
            String url = res.encodeRedirectURL("welcome_tadmin.jsp#viewdrv");
            res.sendRedirect(url);
		} else {
			String url = res.encodeRedirectURL("welcome_tadmin.jsp#viewdrv");
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