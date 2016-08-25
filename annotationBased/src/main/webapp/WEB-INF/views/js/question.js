/**
 * 
 */

$(document).ready(function() {
    	alert('testing');
      
       // Save Person AJAX Form Submit
      $('#questionForm').submit(function(e) {
        // will pass the form data using the jQuery serialize function
        $.post('${pageContext.request.contextPath}/admin/setQuestion', $(this).serialize(), function(response) {
          alert("helloooo");
        	
        	/*$('#qm').text(response);*/
        });
         
        e.preventDefault(); // prevent actual form submit and page reload
      });
       
    });
     