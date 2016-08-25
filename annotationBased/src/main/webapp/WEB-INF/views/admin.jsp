<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

</head>
<body>

<div class="container">
<nav role="navigation" class="navbar navbar-inverse" style="color:AA96FA">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header" >
        <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="#" class="navbar-brand" style="color:#FBFBFD">Hello!! ${name}</a>
    </div>
    <!-- Collection of nav links, forms, and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse" style="color:AA96FA">
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Profile</a></li>
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">Messages <b class="caret"></b></a>
                <ul role="menu" class="dropdown-menu">
                    <li><a href="/annotationBased/admin/createTestAndQuestion"
								class="remove-box">Create Test</a></li>
                    <li><a href="/annotationBased/admin/viewQuestions" class="remove-box">View
								Questions</a></li>
                    <li><a href="#">Sent Items</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Trash</a></li>
                </ul>
            </li>
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

<div class="row">
  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4
  <div class="list-group">
  <a href="#" class="list-group-item active">
   actions
  </a>
  <a href="../admin/setQuestion" class="list-group-item">insert questions</a>
  <a href="../admin/createTestAndQuestion" class="list-group-item">create test</a>
  <a href="../student/viewTests" class="list-group-item">view tests</a>
  <a href="../nonSecured/register" class="list-group-item">Experiment</a>
</div>
  </div>
  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
</div>

</div>




</body>
</html>










<!-- <script>
<input type="text" id="question"  value="Type question here" class="q" size="75"  name='question'/><br>
<input type="text" id="option" onclick= "appendText()"  ondblclick = "doubleclick()" value="Type option here" class="q" size="35"  name="options"/><br>
var option = "<input type='text' id='option' onclick='appendText()'  ondblclick = 'doubleclick()'  value='Type question here' class='q' size='35'  name='question'/><br>";              // Create text with HTML

function appendText() {
    
    $("body").append(option);     // Append new elements
}
function doubleclick(){
	$("body").remove(option);
	
}



 
$('body').dblclick(function(){
	$('#option').fadeOut();
});
</script> -->