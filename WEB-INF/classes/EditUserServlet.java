import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class EditUserServlet extends HttpServlet {
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
			// result= "<h2>Hello World</h2>";

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
		  	result = "{\"username\":\""+id+"\",\"fname\":\""+fname+"\",\"lname\":\""+lname+"\"}";
		  	out.print(result);
		}
	}
}