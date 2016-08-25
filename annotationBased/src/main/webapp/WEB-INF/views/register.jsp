<html>
<head>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.4.2.js"></script>
<!-- <script type="text/javascript" src="./javascript/oauth.js"></script> -->
	<title>Create Account Page</title>
</head>

<body onload='document.f.email.focus();InitCreateAccount();'>
	<h3>Create Account</h3>

	<%   
	    if ( null != request.getParameter("err_msg") ) {
	%>	
	<div style="margin-top:  25px ;position: relative; color: red; font:15px">
		<span style="font-weight:bold"><%= request.getParameter("err_msg") %></span>
	</div>
	<%   } %> 
	
	<form name='f' 
		action='../nonSecured/create'
		method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='email' value='username'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value='Create Account' /></td>
			</tr>
		</table>
	</form>
</body>
</html>