import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class EditDriverServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String d_id = req.getParameter("d_id");
		String result = null;
	  	String fname = null;
	  	String lname = null;
	  	String did = null;
		String addr = null;
	  	String mob = null;
		Connection connection=null;
		Statement st=null;
		PrintWriter out = res.getWriter();
		if(d_id!=null){
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
				st=connection.createStatement();
				// D_FNAME D_LNAME D_ID MOBILE C_ID ADDRESS DOJ STATUS 
				ResultSet rs=st.executeQuery("SELECT * FROM driver WHERE d_id= '"+d_id+"'");
				while(rs.next()){
					fname = rs.getString("D_FNAME");
					lname = rs.getString("D_LNAME");
					did = rs.getString("D_ID");
					addr = rs.getString("ADDRESS");
					mob = rs.getString("MOBILE");
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
		  	result = "{\"did\":\""+did+"\",\"fname\":\""+fname+"\",\"lname\":\""+lname+"\",\"addr\":\""+addr+"\",\"mob\":\""+mob+"\"}";
		  	out.print(result);
		}
	}
}