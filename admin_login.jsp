<%@ include file="header.jsp" %>

<form class='form-login' action='admin_login' method='POST'>
	<ul>
		<li><h2>Admin Login Here,</h2></li>
		<li>
			<label>Username</label>
			<input type='text' name='username'>
		</li>
		<li>
			<label>Password</label>
			<input type='password' name='password'>
		</li>
		<li>
			<button  name='btnLogin' type='submit'>Login</button>
			<button name='btnReset' type='reset'>Reset</button>
		</li>
	</ul>
</form>

<%@ include file="footer.jsp" %>