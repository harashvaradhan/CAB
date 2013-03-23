import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class EditEmpServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String emp_id = req.getParameter("emp_id");
		String result = null;
	  	String fname = null;
	  	String lname = null;
	  	String eid = null;
	    String email = null;
		String addr = null;
	  	String mob = null;
	  	String loc = null;
	    String unt = null;
	    String gen = null;
		Connection connection=null;
		Statement st=null;
		PrintWriter out = res.getWriter();
		if(emp_id!=null){
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
				st=connection.createStatement();

				ResultSet rs=st.executeQuery("SELECT * FROM emp WHERE e_id= '"+emp_id+"'");
				while(rs.next()){
					fname = rs.getString("e_fname");
					lname = rs.getString("e_lname");
					eid = rs.getString("e_id");
					email = rs.getString("email_id");
					addr = rs.getString("address");
					mob = rs.getString("mobile");
					loc = rs.getString("locality");
					unt = rs.getString("unit");
					gen = rs.getString("gender");
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
		  	result = "{\"eid\":\""+eid+"\",\"fname\":\""+fname+"\",\"lname\":\""+lname+"\",\"email\":\""+email+"\",\"addr\":\""+addr+"\",\"mob\":\""+mob+"\",\"unt\":\""+unt+"\",\"gen\":\""+gen+"\",\"loc\":\""+loc+"\"}";
		  	out.print(result);
		}
	}
}