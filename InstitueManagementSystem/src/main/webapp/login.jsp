<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title> <%-- Changed title to be more descriptive --%>

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
  .login-container {
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
<div class="login-container"> <%-- Wrap the form in a container for better styling and centering --%>
  <form action="login" method="post">
    <h1>Login Page</h1>
    
    <div class="mb-3"> <%-- Use Bootstrap's margin-bottom utility class for spacing --%>
      <label for="usernameInput" class="form-label">Username:</label> <%-- Added 'for' attribute for accessibility --%>
      <input type="text" name="username" class="form-control" id="usernameInput" aria-describedby="usernameHelp"> <%-- Added unique ID and changed type to text --%>
    </div>

    <div class="mb-3">
      <label for="passwordInput" class="form-label">Password:</label> <%-- Changed label to Password and added 'for' attribute --%>
      <input type="password" name="password" class="form-control" id="passwordInput" aria-describedby="passwordHelp"> <%-- Changed type to password and added unique ID --%>
    </div>

    <% if(request.getAttribute("message")!=null){ %>
      <h4><%= request.getAttribute("message") %></h4>
    <% } %>

    <div class="d-grid gap-2"> <%-- Use Bootstrap's d-grid and gap-2 for a block-level button with spacing --%>
      <button type="submit" class="btn btn-primary">Login</button> <%-- Added text to the button --%>
    </div>
    
    <div class="text-center mt-3"> <%-- Centered the signup link with margin-top --%>
      <a href="register.jsp">Sign Up</a>
    </div>

  </form>
</div>
</body>
</html>