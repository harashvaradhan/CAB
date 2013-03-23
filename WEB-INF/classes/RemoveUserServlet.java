import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
/**
 * Servlet implementation class ActionServlet
 */

public class RemoveUserServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String username = req.getParameter("username");
	String result = null;
	String id=null;
	String fname=null;
	String lname=null;
	Connection connection=null;
	Statement st=null;
	PrintWriter out = res.getWriter();
	if(username!=null){
		//result= "<h2>Hello World RemoveUserServlet</h2>";

	try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
			st=connection.createStatement();

			ResultSet rs=st.executeQuery("SELECT * FROM tadmin WHERE t_id= '"+username+"'");
			while(rs.next()){
				id=rs.getString("t_id");
				fname=rs.getString("t_fname");
				lname=rs.getString("t_lname");
			}
			rs.close();
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
			try {
				if (connection != null)
						connection.close();
			}
			catch (SQLException ignored){
				out.println(ignored);
			}
	  	}
	  	if (id!=null && fname!=null && lname!=null) {
		  	result = "{\"username\":\""+id+"\",\"fname\":\""+fname+"\",\"lname\":\""+lname+"\"}";
	  		out.print(result);
	  	} else{
	  		out.print(false);
	  	}
/*		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
			st=connection.createStatement();

			 //Add the data into the database
			String sql ="SELECT * FROM tadmin WHERE t_id='"+username+"'";
			PreparedStatement pst =connection.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, fname);
			pst.setString(3, lname);
			pst.setString(4, pass);
			int numRowsChanged = pst.executeUpdate();
			if (numRowsChanged>0) {
	            String url = res.encodeRedirectURL("welcome.jsp#view");
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
	  	}*/
/*	  	res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(result);*/
		// out.println("result");
	}

	}
}