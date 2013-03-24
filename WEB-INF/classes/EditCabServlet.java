import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class EditCabServlet extends HttpServlet {

  public void doGet (HttpServletRequest req,
                     HttpServletResponse res)
    throws ServletException, IOException
  {
  		String cab_id = req.getParameter("cab_id");
  		String id = null;
		String v_number = null;
	  	String cab_status = null;
	  	String result = null;
		Connection connection=null;
		Statement st=null;
		PrintWriter out = res.getWriter();
		if(cab_id!=null){
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
				st=connection.createStatement();
				// C_ID V_NUMBER STATUS 
				ResultSet rs=st.executeQuery("SELECT * FROM cab WHERE c_id='"+cab_id+"'");
				// ResultSet rs=st.executeQuery("DELETE FROM cab WHERE cab_id= '"+cab_id+"' && status= '"+status+"'");
				while(rs.next()){
					id = rs.getString("C_ID");
					v_number = rs.getString("V_NUMBER");
					cab_status = rs.getString("STATUS");
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
		  	result = "{\"cab_id\":\""+id+"\",\"v_number\":\""+v_number+"\",\"cab_status\":\""+cab_status+"\"}";
		  	out.print(result);
  		}
	}
}