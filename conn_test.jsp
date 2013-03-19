<%@ page import="java.sql.*"%>
<%

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cab", "cab");
		Statement st=connection.createStatement();

		ResultSet rs=st.executeQuery("Select * from emp");
		out.println("<table border='1'>");
		while(rs.next()){
			String name=rs.getString("e_fname");
			String add=rs.getString("address");
			out.println("<tr><td>"+name+"</td><td>"+add+"</td></tr>");
		}
		out.println("</table>");
		rs.close();
		st.close();
		connection.close();
	}
	catch (Exception ex) {}
/*	try
	{	
		out.println("nameadd");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String strURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String strUID = "system";
		String strPWD = "oracle";
		Connection con = DriverManager.getConnection(strURL, strUID, strPWD);

				out.println("nameadd");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from tab");

		while(rs.next()){
			String name=rs.getString("tname");
			String add=rs.getString("tabtype");
			out.println(name+" "+add);
		}
		rs.close();
		st.close();
		con.close();
	}
	catch (SQLException e)
	{
		System.out.println("SQLException - [dbConnect]: " + e.getMessage());
		while ((e = e.getNextException()) != null)
		System.out.println(e.getMessage());
	}
	catch (ClassNotFoundException e)
	{
		System.out.println("ClassNotFoundException: " + e.getMessage());
	}*/
%>