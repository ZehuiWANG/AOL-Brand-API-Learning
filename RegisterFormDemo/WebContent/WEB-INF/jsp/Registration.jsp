<!DOCTYPE html>
<html>
    <head>
        <link href="style.css" rel="stylesheet" type="text/css">
        <script src="script.js"></script>
        <script src="/RegisterFormDemo/js/jquery.js"></script> 
	<script type="text/javascript">
	
	function AjaxCheckNameAvaliable() {
        // get the form values
		 
     var name = $('#reusername').val();
        $.ajax({
        type: "POST",
        url: "/RegisterFormDemo/AddUser.htm",
        data: "name=" + name,
        success: function(response){
        // we have the response
        $('#info').html(response);//this is html response
       // $('#name').val('');
        },
        error: function(e){
        alert('Error: ' + e);
        }
        });
        }  
	function AjaxSuggestDisplayName(){
    	var firstname = $('#refirstname').val();
    	var lastname = $('#relastname').val();
    	
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
	
	
	function AjaxValidatePassword(){
    	var password = $('#repassword').val();
    	var username = $('#reusername').val();
    	
    	 $.ajax({
    	        type: "POST",
    	        url: "/RegisterFormDemo/ValidatePassword.htm",
    	        data:{ "username" : username,
    	        		"password":password
    	        		},
    	        success: function(response){
    	        // we have the response
    	        
    	        if(response.status="SUCCESS"){
    	        	$('#info').html(response.result);
    	        	 $('#info').html(response);
    	    	        $('#password').val('');
    	    	        $('#username').val('');

    	        }else{
    	        	
    	        }
/*     	        $('#info').html(response);
    	        $('#firstname').val('');
    	        $('#lastname').val(''); */
    	        },
    	        error: function(e){
    	        //alert('Error: ' + e);
    	        }
    	        });
    	
    }
	 function AjaxValidateEmail(){
	    	var email = $('#reemail').val();

	    	 $.ajax({
	    	        type: "POST",
	    	        url: "/RegisterFormDemo/ValidateEmail.htm",
	    	        data: {"email":email},
	    	        success: function(response){
	        	        // we have the response
	        	        
	        	        if(response.status="SUCCESS"){
	        	        	$('#info').html(response.result);
	       	        		 $('#info').html(response);
	       	    	       	 $('#email').val('');


	        	        }else{
	        	        	
	        	        }
	    /*     	        $('#info').html(response);
	        	        $('#firstname').val('');
	        	        $('#lastname').val(''); */
	        	        },
	        	        error: function(e){
	        	        //alert('Error: ' + e);
	        	        }
	        	        });
	    	
	    }
	 
	 function AjaxCreateUser(){
	    	var email = $('#reemail').val();
	    	var password= $('#repassword').val();


	    	 $.ajax({
	    	        type: "POST",
	    	        url: "/RegisterFormDemo/CreateUser.htm",
	    	        data: {"email":email,
	    	        		"password":password	
	    	        },
	    	        success: function(response){
	        	        // we have the response
	        	        window.location.href="http://localhost:8080/RegisterFormDemo/SuccessPage.htm";
	        	        if(response.status="SUCCESS"){
	        	        	$('#info').html(response.result);
	        	        	 $('#info').html(response);
	        	    	        $('#reemail').val('');
	        	    	        $('#repassword').val();
	        	    	       
	        	        }else{
	        	        	
	        	        }
	    /*     	        $('#info').html(response);
	        	        $('#firstname').val('');
	        	        $('#lastname').val(''); */
	        	        },
	        	        error: function(e){
	        	        //alert('Error: ' + e);
	        	        }
	        	        });
	    	
	    }
	
	
	</script>
    </head>
    <body>
        <div align="center">
        <div id="mainform">
            <div class="innerdiv">
                <!-- Required Div Starts Here -->
                <h2>Welcome Join in AOL</h2>
                <form action='#' id="myForm" method='post' name="myForm">
                    <h3>Fill Your Information!</h3>
                    <table>
                   <!--  <tr>
                            <td>FirstName</td>
                            <td><input id='refirstname' onblur="validate('website', this.value)" type='text'></td>
                            <td>
                                
                            </td>
                        </tr>
                        <tr>
                            <td>LastName</td>
                            <td><input onblur="AjaxSuggestDisplayName()"  id='relastname' onblur="validate('website', this.value)" type='text'> <input onclick="AjaxSuggestDisplayName()" type='button' value='SuggestNameHere'></td>
                          
                         
                        </tr>  -->
                         <tr>
               
                        <tr>
                            <td>UserName</td>
                            <td><input id='reusername' onblur="AjaxCheckNameAvaliable()" type='text'></td>
                            <td>
                                
                            </td>
                        </tr>
                        <tr>
                            <td>PassWord</td>
                            <td><input id='repassword' onblur="AjaxValidatePassword()" type='password'></td>
                            <td>
                                
                            </td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><input id='reemail'  onblur="AjaxValidateEmail()" type='text'></td>
                            <td>
                                
                            </td>
                        </tr>
                       
                    </table>
                    <input onclick="AjaxCreateUser()" type='button' value='Register'>
                </form>
            </div>
        </div>
    </body>
</html>