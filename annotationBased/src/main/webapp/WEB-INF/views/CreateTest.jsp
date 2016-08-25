<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<title>Shop List page</title>
</head>
<body>

<div  class = "container" >  
<h1>Create Test Page</h1>
	<div id = "formToCreateTest"></div>
	<form role="form" action='../admin/createTest' method="post">
		<div class="form-group col-lg-5">
			<p><label for="name">Name</label> <input type="text" name="name"class="form-control input-sm" /><button type="submit" class="btn btn-primary btn-sm">Submit</button>
		</p>
		</div>
	</form>



	<table class="table table-striped table-bordered">

		<thead>
			<tr>
				<th width="10px">ID</th>
				<th width="50px">Name</th>
				<th width="50px">Action</th>
				
			</tr>
		</thead>


		<tbody>
			<c:forEach var="tests" items="${tests}">




				<tr>
					<td>${tests.id}</a></td> 
					<td><a href="../admin/test/${tests.id}" >${tests.name}    </a></td>
					<td><a href="../admin/updateTest/${tests.id}" >Update-${tests.id}    </a>
					<a href="../admin/deleteTest/${tests.id}" >Delete-${tests.id}</a></td> 
					
					

				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>











<!-- 	<form role="form" action='../admin/createTestAndQuestion' method="post">
		<h1>Set Test page</h1>
		<div width="250px">
			<div class="form-group col-lg-7">




				<table class="table table-striped table-bordered">

					<thead>
						<tr>
							<th width="25px">ID</th>
							<th width="250px">Question</th>
							<th width="10px">Marks</th>
							<th width="50px">Set</th>
						</tr>
					</thead>


					<tbody>
						<c:forEach var="question" items="${questionList}">



							<tr>
								<td>${question.id}</td>
								<td>${question.name}</td>
								<td><div class="form-group col-lg-5">
										<input type="text" class="form-control input-sm" />
									</div></td>
								<td><input type="checkbox" id="id"
									name="listOfTestQuestion" value="${question.id}"></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="my-form">


					<p>
						<button type="submit" class="btn btn-primary btn-lg">Submit</button>
					</p>
	</form> -->
	
 
</body>
</html>