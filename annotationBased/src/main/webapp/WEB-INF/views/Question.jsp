<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">


<head>
<title>SET QUESTIONS</title>
<script type="text/javascript" src="//code.jquery.com/jquery-latest.js"></script>
<!-- <script type="text/javascript" src="jquery-1.5.1.min.js"></script> -->
<style type="text/css">
<!--
#main {
	max-width: 800px;
	margin: 0 auto;
}
-->
</style>
</head>
<body>
	<div class="contianer">
	<nav role="navigation" class="navbar navbar-inverse">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="#" class="navbar-brand">Brand</a>
    </div>
    <!-- Collection of nav links, forms, and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse">
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
	
	
	
	
	
	
		<div id="main">
		
			<h1>Online Test Application</h1>
			<div class="row" >
				<div class="col-xs-6 col-sm-12">
					<div class="panel panel-default">
						<div class="panel-heading">

							<h3 class="panel-title">Insert Question Here</h3>
						</div>
						<div class="panel-body questionForm">
							<div class="my-form">
								<form  role="form"  method="post"><!-- action='../admin/setQuestion' -->
								

									<br>
									<div class="input-group input-group  panel-body">
										<span class="input-group-addon">Question</span> 
										<input
											type="text" id="question" value="Type question here"
											class="form-control" size="75" name='name' /><br>

									</div>
									<div class="col-xs-6 col-sm-10">
									<div class="list-group">
									
									<div class="option-box list-group-item">
										<div class="row">
									<div class="col-xs-1 col-sm-3">
											
										<label for="box1" >Option: <span class="box-number ">1</span></label>
									
										
										<input type="checkbox" name="listOfAnswers"
											id="inlineCheckbox3" value="1">
											 </div>
											<div class="col-xs-6 col-sm-6">
											
											<input type="text"
											name="listOfOptions" class=" form-control input-sm" value="listofoptions"
											id="optionbox1 " size="20" />
											 </div>
											 <div class="col-xs-6 col-sm-2">
											 <a class="add-box" href="#">Add More</a>
									</div>		
											 </div>
									</div>
									</div>
									</div>
									</div>
									<p>
										<input type="submit" class="btn btn-primary btn-lg"
											value="Submit" />
									</p>
																	</form>
							
							</div>
							
								<div id="qm" class="green"></div>
						</div>
						<div class="createTestBox">
							<a href="/annotationBased/admin/createTestAndQuestion"
								class="remove-box">Create Test</a>
						</div>
						<div class="createTestBox">
							<a href="/annotationBased/admin/viewQuestions" class="remove-box">View
								Questions</a>
						</div>



					</div>
				</div>

			</div></div>
			</div>
	 <div class="row">
          <div class="col-xs-6">
            <div class="input-group">
              <span class="input-group-addon">
                <input type="checkbox">
              </span>
              <input type="text" class="form-control">
            </div>
            
          </div>
<script type="text/javascript" src="js/question.js"></script>
		<script type="text/javascript">
jQuery(document).ready(function($){
    $('.my-form .add-box').click(function(){
        var n = $('.option-box').length + 1;
        if( 8 < n ) {
            alert('Stop it! you cannot give more then 8 option for a question');
            return false;
        }
        var box_html = $('<div class="option-box list-group-item my-form ss'+n+'"  > <div class="row"><div class="col-xs-3 col-sm-3"><label for="optionbox' + n + '">Option: <span class="box-number">'
        		+ n + '</span></label><input type="checkbox" name="listOfAnswers" value="'+n+'">'
        		+'</div>  <div class="col-xs-6 col-sm-7">  <input type="text" name="listOfOptions" class="form-control input-sm	"value="" id="optionbox'
        		+ n + '" /> </div> <div class="col-xs-6 col-sm-2"><a href="#" class="remove-box">Remove</a></div></div></div>');
        box_html.hide();
        $('.my-form div.option-box:last').after(box_html);
        box_html.fadeIn('slow');
        return false;
    });
    $('.list-group').on('click', '.remove-box', function(){
        $(this).parent().parent().css( 'background-color', '#FF6C6C' );
        $(this).parent().fadeOut("slow", function() {
            $(this).parent().parent().remove();
            $('.box-number').each(function(index){
                $(this).text( index + 1 );
            });
        });
        return false;
    });
});
</script><!--  -->
		
	
</body>
</html>



































<!-- <html>
<head>
    <title>SET Questions</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js"></script>
	
	<style>body {font:13px verdana;font-weight:normal}</style>
</head>
<body>
<form action='../admin/setQuestion'method='POST'>
		
<h4> Question</h4><br>
    	<input type="test" id="question" value="Type question here" class="q" size="55"  /><br>
    	<h4> options</h4><br>
    <div id="main">
   
       option1 <input type="test" id="txtAdd" value="option1" class="bt" /><br>
       <input type="button" id="txtAdd" value="submit" class="bt" />
    </div>
    </form>
</body>
<script>
    $(document).ready(function() {
        var iCnt = 1;
        
        
        $('#txtAdd').click(function() {
            if (iCnt <= 19) {
                iCnt = iCnt + 1;
                // ADD TEXTBOX.
                $('#main').append('option ' + iCnt + '<input type=text class="input" id=tb' + iCnt + ' ' +
                            ' />');

               if (iCnt == 1) {        // SHOW SUBMIT BUTTON IF ATLEAST "1" ELEMENT HAS BEEN CREATED.
                    var divSubmit = $(document.createElement('div'));
                    $(divSubmit).append('<input type=button class="bt" onclick="GetTextValue()" id=btSubmit value=Submit />');
                    
                   
                   
               }
               
                $('#main').after(container, divSubmit);   // ADD BOTH THE DIV ELEMENTS TO THE "main" CONTAINER.
            }
            	
            else {      // AFTER REACHING THE SPECIFIED LIMIT, DISABLE THE "ADD" BUTTON. (20 IS THE LIMIT WE HAVE SET)
                $(container).append('<label>Reached the limit</label>'); 
                
            }
        });
      
       
    });

   
</script>
</html> -->