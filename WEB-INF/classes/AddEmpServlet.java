import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class AddEmpServlet extends HttpServlet {

  public void doPost (HttpServletRequest req,
                     HttpServletResponse res)
    throws ServletException, IOException
  {
  	//E_FNAME, E_LNAME, E_ID, EMAIL_ID, MOBILE, ADDRESS, LOCALITY, UNIT, GENDER

  	String fname = req.getParameter("e_fname");
  	String lname = req.getParameter("e_lname");
  	String eid = req.getParameter("e_id");
    String email = req.getParameter("email_id");
	String addr = req.getParameter("address");
  	String mob = req.getParameter("mobile");
  	String loc = req.getParameter("locality");
    String unt = req.getParameter("unit");
    String gen = req.getParameter("gender");

  	PrintWriter out = res.getWriter();

  	// out.print(fname+lname+eid+email+addr+mob+loc+unt+gen);
  	Connection connection=null;
  	Statement st=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
		st=connection.createStatement();

		 //Add the data into the database
		String sql ="INSERT INTO emp VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst =connection.prepareStatement(sql);
		pst.setString(1, fname);
		pst.setString(2, lname);
		pst.setString(3, eid);
		pst.setString(4, email);
		pst.setString(5, addr);
		pst.setString(6, loc);
		pst.setString(7, unt);
		pst.setString(8, gen);
		pst.setString(9, mob);
		int numRowsChanged = pst.executeUpdate();
		if (numRowsChanged>0) {
            String url = res.encodeRedirectURL("welcome_tadmin.jsp#viewemp");
            res.sendRedirect(url);
		} else {
			String url = res.encodeRedirectURL("welcome_tadmin.jsp#viewemp");
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