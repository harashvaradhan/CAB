import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class admin_login extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        PrintWriter out = response.getWriter();
        // out.println("'Hello'");
/*        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
            Statement st=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM tadmin WHERE t_id='"+name+"' AND password='"+pass+"'";
            ResultSet rs = st.executeQuery(query);
            int rowCount = 0;
            while ( rs.next() )
            {
                rowCount++;
            }
            if(rowCount==1){
                rs.first();
                name=rs.getString("t_id");
                pass=rs.getString("password");
                out.println("<tr><td>"+name+"</td><td>"+pass+"</td></tr>");
            } else{
                out.println("Invalid Username/Passoword\n");
            }
            rs.close();
            st.close();
            connection.close();
        }
        catch (Exception ex) {
            out.println(ex);
        }*/

        //if (username == cmsadmin && pass == cmsadmin)) {
        if ( username.equals("cmsadmin") && pass.equals("cmsadmin") ) {
           // HttpServletResponse.sendRedirect("welcome.jsp");
            // out.println("Hello, " +username);
            String url = response.encodeRedirectURL("welcome.jsp#view");
            response.sendRedirect(url);
        } else {
            out.println("Invalid Username/Passoword");
        }
        out.close();
    }
}