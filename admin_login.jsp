<%@ include file="header.jsp" %>


<form class='form-login' action='admin_login' method='POST'>
	<ul>
		<li><h2>CMS Admin Login</h2></li>
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
	</ul>
</form>

<%@ include file="footer.jsp" %>