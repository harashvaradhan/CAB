import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
        String username = req.getParameter("username");
        String pass = req.getParameter("password");
        String message = null;
        PrintWriter out = res.getWriter();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
            Statement st=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM tadmin WHERE t_id='"+username+"' AND password='"+pass+"'";
            ResultSet rs = st.executeQuery(query);
            int rowCount = 0;
            while ( rs.next() )
            {
               rowCount++;
            }
            if(rowCount==1){
                rs.first();
                String t_id=rs.getString("t_id");
                String fname=rs.getString("t_fname");
                String lname=rs.getString("t_lname");
                String password=rs.getString("password");
                message = "Welcome "+fname+" "+lname+" thanks for login...";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/welcome_tadmin.jsp#viewemp").forward(req, res);
              // String url = res.encodeRedirectURL("welcome_tadmin.jsp#viewemp");
                //res.sendRedirect(url);
                } else {
                    message = "You are not the valid user...";
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/login.jsp").forward(req, res);
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