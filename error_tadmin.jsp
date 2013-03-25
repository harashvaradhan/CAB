<%@ include file="header.jsp" %>
<div class='menu'><ul><li><a>Error Page</a></li></ul></div>
 	<% String cat=(String)request.getAttribute("message");
	if(cat!=null)
	{ %>
		<label><%=cat%> </label>
	<%
	}
	%>
	<button onCLick="history.back()">Back</button>
<%@ include file="footer.jsp" %>