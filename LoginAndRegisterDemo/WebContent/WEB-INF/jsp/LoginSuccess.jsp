<script src="/RegisterFormDemo/js/jquery.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">

      function callLogin() {
        var accessToken = getCookie("access_token");
        alert(accessToken);
 		var name=accessToken;
        $.ajax({
        type: "POST",
        url: "/RegisterFormDemo/GetUser.htm",
        data: { "accessToken" : accessToken,
        		"name": name	
        },
        //data: "access_token=" + accessToken,
        success: function(response){
        	
        	//document.write(accessToken);
        	//document.getElementById("demo").innerHTML = response;
        	
        	//document.getElementById("demo").innerHTML=json.status;
        	
        	//$('#info').html(response); //this is html response
        	document.getElementById("demo").innerHTML ="UserName is: "+ response.name;
        	document.getElementById("demo1").innerHTML ="LastName is: ";
        	document.getElementById("demo2").innerHTML ="FirstName is: ";
        	document.getElementById("demo3").innerHTML ="DataBirth is: ";
        	document.getElementById("demo5").innerHTML ="Email is: "+response.test;
        	document.getElementById("demo6").innerHTML ="Phone is: ";
        	
        	
        	
        	
        },
        error: function(e){
       		// alert('Error: ' + e);
        }
        });
      }
      
      function getCookie(name) {
    	  var value = "; " + document.cookie;
    	  var parts = value.split("; " + name + "=");
    	  if (parts.length == 2) return parts.pop().split(";").shift();
    	 }
      
      </script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<body>
	<div align="center">
        <div id="mainform">
            <div class="innerdiv">
<p>Welcome to Aol.Inc</p>

	<input value="Show Your Profile" type='button' onclick="callLogin()">
	<p id="demo"></p>
	<p id="demo1"></p>
	<p id="demo2"></p>
	<p id="demo3"></p>
	<p id="demo4"></p>
	<p id="demo5"></p>
	<p id="demo6"></p>
	<p id="demo7"></p>
	
		</div>
		</div>
	</div>
</body>

</body>


</html>