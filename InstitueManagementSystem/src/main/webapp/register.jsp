<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

<style type="text/css">
  body {
    background-color: #f8f9fa; /* Light background for the page */
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    margin: 0;
  }
  .register-container {
    background-color: #ffffff; /* White background for the form */
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 400px; /* Adjust maximum width for the form */
  }
  h1 {
    text-align: center;
    color: #333333;
    margin-bottom: 20px;
  }
  .form-label {
    font-weight: bold;
  }
  .form-control {
    margin-bottom: 15px; /* Add some space below each input field */
  }
	h4{
	color:red;
  text-align: center; /* Center the error message */
	}
</style>
</head>
<body>
<div class="register-container"> 
<form action="reg" method="post">
<h1>Register Page</h1>
	<div class="mb-3"> <%-- Use Bootstrap's margin-bottom utility class for spacing --%>
      <label for="NameInput" class="form-label">Name:</label>
      <input type="text" name="name" class="form-control" id="usernameInput" aria-describedby="usernameHelp"> <%-- Added unique ID and changed type to text --%>
    </div>
	
	<div class="mb-3"> <%-- Use Bootstrap's margin-bottom utility class for spacing --%>
      <label for="emailInput" class="form-label">Email:</label> <%-- Added 'for' attribute for accessibility --%>
      <input type="email" name="email" class="form-control" id="usernameInput" aria-describedby="usernameHelp"> <%-- Added unique ID and changed type to text --%>
    </div>

    <div class="mb-3">
      <label for="passwordInput" class="form-label">Password:</label> <%-- Changed label to Password and added 'for' attribute --%>
      <input type="password" name="password" class="form-control" id="passwordInput" aria-describedby="passwordHelp"> <%-- Changed type to password and added unique ID --%>
    </div>

<% if(request.getAttribute("message")!=null) {%>
	<h4><%=request.getAttribute("message")%></h4>
<%}%>
<div class="d-grid gap-2"> 
      <button type="submit" class="btn btn-primary" value="SUBMIT">SUBMIT</button> 
    </div>
    
    <div class="text-center mt-3"> <%-- Centered the signup link with margin-top --%>
      <a href="login.jsp">Already have an account? Login here.</a>
    </div>
</form>
</div>
</body>
</html>