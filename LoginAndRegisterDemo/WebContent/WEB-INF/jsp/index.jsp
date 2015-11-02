
<!DOCTYPE html>
<html>
    <head>
    <script src="/RegisterFormDemo/js/jquery.js"></script> 
	<script type="text/javascript">
    
      function callLogin() {
        // get the form values
        var email = $('#lemail').val();
        var password = $('#lpassword').val();
        $.ajax({
        type: "POST",
        url: "/RegisterFormDemo/Login.htm",
        data:{ "email" : email,
    		"password":password
    		},
        success: function(response){
        	
        	console.log("hello");
        	document.cookie="access_token="+response;
        	console.log(document.cookie);
        	//response.addCookie(accessToken);
        	console.log("hello");
        	window.location.href="http://localhost:8080/RegisterFormDemo/LoginSuccess.htm";
     		 var result=response;
        },
        error: function(e){
      /*   alert('Error: ' + e); */
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
                <h2>Welcome to Aol. Inc</h2>
                <form action='#' id="myForm" method='post' name="myForm">
                    <h3>Please Login Here</h3>
                    <table>
                        <tr>
                            <td>Email</td>
                            <td><input id='lemail' name='lemail' onblur="validate('email', this.value)" type='text' value="aolbrandapitest@163.com"></td>
                            <td>
                                <div id='lemail'></div>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>Password</td>
                            <td><input id='lpassword' name='lpassword' onblur="validate('password', this.value)" type='password' value = "8810023"></td>
                            <td>
                                <div id='password'></div>
                            </td>
                        </tr>
                    </table>
                    <input  type='button' onclick="callLogin()" value='Login Here'> <input onclick="window.location.href='Registration.htm'" type='button' value='Register Here'>
                </form>
            </div>
        </div>
    </body>
</html> 