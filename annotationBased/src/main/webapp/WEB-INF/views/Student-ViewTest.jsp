<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<title>Student View Test page</title>
</head>
<body>

<div  class = "container" >  
<h1>Student Test Page</h1>
	
	


	<table class="table table-striped table-bordered">

		<thead>
			<tr>
				<th width="10px">ID</th>
				<th width="50px">Name</th>
				
				
			</tr>
		</thead>


		<tbody>
			<c:forEach var="tests" items="${testForStudent}">




				<tr>
					<td>${tests.id}</td> 
					<td><a href = "../student/takeTest/${tests.id}">${tests.name}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
 
</body>
</html>