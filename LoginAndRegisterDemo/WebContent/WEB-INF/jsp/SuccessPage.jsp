<script type="text/javascript">
    
      function callLogin() {
        var accessToken = document.cookie["access_token"];
        alert(accessToken);
        
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
<p>Hello ${message} Welcome  to join AOl.</p>
<input  type='button' onclick="callLogin()">
</body>
</html>