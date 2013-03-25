<%@ include file="header.jsp" %>

<form class='form-login' action='LoginServlet' method='POST'>
	<ul>
		<li><h2>Trasport Admin Login</h2></li>
		<li>
			<label>Username</label>
			<input type='text' name='username'>
		</li>
		<li>
			<label>Password&nbsp;</label>
			<input type='password' name='password'>
		</li>
		<li>
			<button  name='btnLogin' type='submit'>Login</button>
			<button name='btnReset' type='reset'>Reset</button>
		</li>
		<li>
			Login as Admin <blink><a href="admin_login.jsp">Click Here.</a></blink>
		</li>
		<li>
			<% String cat=(String)request.getAttribute("message");
			if(cat!=null)
			{ %>
				<label><%=cat%> </label>
			<%}
			%>
		</li>
	</ul>
</form>

<%@ include file="footer.jsp" %>