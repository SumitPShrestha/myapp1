<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	$(document).ready(function() {
		$("#registerHere").click(function() {
			$("#signUp").slideDown("slow");
			$("#securedLogin").slideUp("slow");
			
		});
		
		$("#alreadylogin").click(function() {
			$("#signUp").slideUp("slow");
			$("#signUp").hide();
			$("#securedLogin").slideDown("slow");
			
		});
		
	});
</script>
<title>Insert title here</title>
</head>
<body>


	<nav role="navigation" class="navbar navbar-inverse"
		style="background-color: #246BB2;"> <!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" data-target="#navbarCollapse"
			data-toggle="collapse" class="navbar-toggle">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a href="#" class="navbar-brand" style="color: white;">Brand</a>
	</div>
	<!-- Collection of nav links, forms, and other content for toggling -->
	<div id="navbarCollapse" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active" style="background-color: #246BB2;"><a
				href="/annotationBased/admin/createTestAndQuestion"
				class="remove-box" style="color: white;">Create Test</a></li>
			</li>
			<li><a href="/annotationBased/admin/viewQuestions"
				class="remove-box" style="color: white;">View Questions</a></li>
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#" style="color: white;">Messages
					<b class="caret"></b>
			</a>
				<ul role="menu" class="dropdown-menu">
					<li></li>
					<li></li>
					<li><a href="#">Sent Items</a></li>
					<li class="divider"></li>
					<li><a href="#">Trash</a></li>
				</ul></li>
		</ul>
		<form role="search" class="navbar-form navbar-left">
			<div class="form-group">
				<input type="text" placeholder="Search" class="form-control">
			</div>
		</form>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#">Login</a></li>
		</ul>
	</div>
	</nav>
	<!-- ----------------------------------==========nav bar above===============--------------------------------------------------------- -->





	<div class="row">
		<div class="col-xs-40 col-sm-8"></div>
		<div class="col-xs-4 col-sm-4">
			<div class="panel panel-primary" id="securedLogin">
				<div class="panel-heading">

					<h2 class="panel-title">Login</h2>
				</div>
				<div class="panel-body">

					<div id="login-error">${error}</div>

					<form action="/annotationBased/j_spring_security_check"
						method="post">

						<div class="input-group input-group  panel-body">
							<span class="input-group-addon"> <label for="j_username">Username</label>
							</span><input id="j_username" class="form-control" name="j_username"
								type="text" />

						</div>


						<div class="input-group input-group  panel-body">
							<span class="input-group-addon"> <label for="j_password">Password</label></span><input
								id="j_password" class="form-control" name="j_password"
								type="password" />
						</div>

						<input type="submit" class="btn btn-primary btn-sm" value="Login" />


					</form>



					<a id=registerHere href="#">Not a user yet !!!!! register here</a>
				</div>


			</div>
		</div>


		<!-- =========================================================================================================== -->



		<div class="col-xs-40 col-sm-8 aa"></div>
		<div class="col-xs-4 col-sm-4 " id="signUp" style="display: none">
			<div class="panel panel-primary ">
				<div class="panel-heading " id="signUp">
					<h2 class="panel-title" style="color: white;">Register Account</h2>
				</div>

				<div class="panel-body aa">
					<form action="../nonSecured/create" method="post">
						<div class="input-group input-group  panel-body">
							<span class="input-group-addon">First Name</span> <input
								type="text" id="question" value="Type question here"
								class="form-control" size="75" name='firstName' /><br>

						</div>
						<div class="input-group input-group  panel-body">
							<span class="input-group-addon">Last Name</span> <input
								type="text" id="question" class="form-control" size="75"
								name='lastName' /><br>

						</div>
						<div class="input-group input-group  panel-body">
							<span class="input-group-addon">E-mail
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <input type="text" id="email"
								class="form-control" size="75" name='email' /><br>

						</div>
						<div class="input-group input-group  panel-body">
							<span class="input-group-addon">Username</span> <input
								type="text" id="question" class="form-control" size="75"
								name='username' /><br>

						</div>
						<div class="input-group input-group  panel-body">
							<span class="input-group-addon">Password</span> <input
								type="text" id="question" class="form-control" size="75"
								name='password' /><br>

						</div>
						<div class="radio">
							<label><input type="radio" value="m" name="gender">Male</label> <label>
							<input type="radio" value="f" name="gender">Female</label>
						</div>

						<input type="submit" class="btn btn-primary btn-sm"
							value="Register" />
					</form>
					<a href="#" id="alreadylogin">Login</a>
				</div>
			</div>

		</div>
	</div>





</body>


</html>
