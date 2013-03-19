import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        PrintWriter out = response.getWriter();
        // out.print("Records are\n");
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
            Statement st=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
            // out.println("Follows\n");
            String query = "SELECT * FROM tadmin WHERE t_id='"+name+"' AND password='"+pass+"'";
            // out.println(query);
            ResultSet rs = st.executeQuery(query);
            int rowCount = 0;
            while ( rs.next() )
            {
                // Process the row.
                rowCount++;
            }

            // out.println("There were " + rowCount + " records.");
            /*rs.last();
            out.println(rs.getRow());*/
            if(rowCount==1){
                rs.first();
                name=rs.getString("t_id");
                pass=rs.getString("password");
                // out.println("<tr><td>"+name+"</td><td>"+pass+"</td></tr>");
                out.println("Success\n");
            } else{
                out.println("Invalid Username/Passoword\n");
            }
            rs.close();
            st.close();
            connection.close();
        }
        catch (Exception ex) {
            out.println(ex);
        }
        out.close();
    }
}