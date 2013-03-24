<%@ include file="header.jsp" %>
<%@ include file="./html/tadmin_navigation.html" %>
<!-- 	<% String cat=(String)request.getAttribute("message");
	if(cat!=null)
	{ %>
		<label><%=cat%> </label>
	<%
	}
	%> -->
	<%
	String strError = (String) session.getAttribute("error");
	out.print(strError);
/*	if (strExpired.equals("Expired")){
	out.print("alert('Password expired, please update your password..');");
	}*/
	%>
<%@ include file="footer.jsp" %>