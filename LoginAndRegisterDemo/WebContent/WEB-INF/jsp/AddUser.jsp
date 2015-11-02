<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Users using ajax</title>
<script src="/RegisterFormDemo/js/jquery.js"></script> 
<script type="text/javascript">
   
   function doAjaxPost() {
        // get the form values
        var name = $('#username').val();
        $.ajax({
        type: "POST",
        url: "/RegisterFormDemo/AddUser.htm",
        data: "name=" + name,
        success: function(response){
        // we have the response
        $('#info').html(response);//this is html response
       // $('#username').val('');
        },
        error: function(e){
      /*   alert('Error: ' + e); */
        }
        });
        } 
    function doAjaxPost2(){
    	var firstname = $('#firstname').val();
    	var lastname = $('#lastname').val();
    	
    	 $.ajax({
    	        type: "POST",
    	        url: "/RegisterFormDemo/SuggestUser.htm",
    	        data:{ "firstname" : firstname,
    	        		"lastname":lastname
    	        		},
    	        success: function(response){
    	        // we have the response
    	        
    	        if(response.status="SUCCESS"){
    	        	$('#info').html(response.result);

    	        }else{
    	        	
    	        }
/*     	        $('#info').html(response);
    	        $('#firstname').val('');
    	        $('#lastname').val(''); */
    	        },
    	        error: function(e){
    	        alert('Error: ' + e);
    	        }
    	        });
    	
    }
    
    function validateEmail(){
    	var email = $('#email').val();

    	 $.ajax({
    	        type: "POST",
    	        url: "/RegisterFormDemo/ValidateEmail.htm",
    	        data: {"email":email},
    	        success: function(response){
    	        // we have the response
    	        $('#info').html(response);
    	        $('#email').val('');
    	        },
    	        error: function(e){
    	      /*   alert('Error: ' + e); */
    	        }
    	        });
    	
    }
    
    function validatepassword(){
    	var password = $('#password').val();
    	var username = $('#username').val();
    	var firstname = $('#firstname').val();
    	 $.ajax({
    	        type: "POST",
    	        url: "/RegisterFormDemo/ValidatePassword.htm",
    	        data: {"username":username,
    	        		"password":password,
    	        		"firstname":firstname
    	        		
    	        },
    	        success: function(response){
    	        // we have the response
    	        $('#info').html(response);
    	       
    	        },
    	        error: function(e){
    	      /*   alert('Error: ' + e); */
    	        }
    	        });
    	
    }
   
        </script>
</head>
<body>
<form action="onsubmit">
	<h1>Check Users ...........</h1>
	<table>
		<tr>
			<td>UserName :</td>
			<td><input type="text" id="username"><br /></td>
		</tr>
		<tr>
			<td>FirstName :</td>
			<td><input type="text" id="firstname"><br /></td>
		</tr>
		<form onSubmit="doAjaxPost2()">
		<tr>
			<td>LastName :</td>
			<td><input type="text" id="lastname" ><br /></td>
		</tr>
		</form>
		<tr>
			<td>Email :</td>
			<td><input type="text" id="email"><br /></td>
		</tr>
		<tr>
			<td>PassWord :</td>
			<td><input type="text" id="password"><br /></td>
		</tr> 
		<tr>
			<td colspan="2"><input type="button"
				value="Validate DisplayName" onclick="doAjaxPost()"><br /></td>
		</tr>


		<tr>

			<td colspan="2"><input type="button" value="Suggest DisplaNames"
				onclick="doAjaxPost2()"><br /></td>
		</tr>

		<tr>

			<td colspan="2"><input type="button"
				value="Validate EmailAddress" onclick="validateEmail()"><br /></td>
		</tr>

		<tr>

			<td colspan="2"><input type="button" value="Validate PassWord"
				onclick="validatepassword()"><br /></td>
		</tr>

		<!-- <tr>
			
			<td colspan="2"><input type="button" value="Create User"
				onclick="doAjaxPost2()"><br /></td>
		</tr> -->


		<tr>
			<td colspan="2"><div id="info" style="color: green;"></div></td>
		</tr>
	</table>
       	<a href="Registration.htm">Click Here to go to the Register Page</a>
       	</form>
</body>
</html>

