<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
<style>
	body{
        font-family: Arial, sans-serif; /* Sets a clear, readable font */
        background-color: #f4f4f4; /* Light gray background for the page */
        display: flex; /* Centers the content using flexbox */
        justify-content: center; /* Centers horizontally */
        align-items: center; /* Centers vertically */
        min-height: 100vh; /* Ensures the body takes at least the full viewport height */
        margin: 0; /* Removes default body margin */
 	   }
    .form-container {
        background-color: #ffffff; /* White background for the form */
        padding: 30px; /* Adds space around the form content */
        border-radius: 8px; /* Slightly rounded corners for the form */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow for depth */
        width: 100%; /* Makes the form container responsive */
        max-width: 500px; /* Limits the maximum width for better readability */
    }
    h2 {
        text-align: center; /* Centers the heading */
        color: #333333; /* Dark gray color for the heading */
        margin-bottom: 20px; /* Space below the heading */
    }

    label {
        display: block; /* Makes labels appear on their own line */
        margin-bottom: 8px; /* Space below each label */
        color: #555555; /* Medium gray color for labels */
        font-weight: bold; /* Makes labels bold */
    }

    input[type="text"],
    input[type="number"],
    input[type="email"],
    input[type="password"], /* Added for consistency if you add password fields */
    select,
    textarea {
        width: 100%; /* Makes input fields take the full width of their container */
        padding: 12px; /* Adds padding inside the input fields */
        margin-bottom: 20px; /* Space below each input field */
        border: 1px solid #cccccc; /* Light gray border */
        border-radius: 4px; /* Rounded corners for input fields */
        box-sizing: border-box; /* Includes padding and border in the element's total width and height */
        font-size: 16px; /* Sets a readable font size */
    }

    input[type="submit"] {
        background-color: #007bff; /* Blue background for the submit button */
        color: white; /* White text color */
        padding: 12px 20px; /* Adds padding to the button */
        border: none; /* Removes default button border */
        border-radius: 4px; /* Rounded corners for the button */
        cursor: pointer; /* Changes the cursor to a hand on hover */
        font-size: 18px; /* Larger font size for the button */
        width: 100%; /* Makes the button take full width */
        transition: background-color 0.3s ease; /* Smooth transition on hover */
    }

    input[type="submit"]:hover {
        background-color: #0056b3; /* Darker blue on hover */
    }

    .error-message {
        color: red; /* Red color for error messages */
        font-weight: bold; /* Bold text for emphasis */
        margin-top: 50px; /* Space above the error message */
        text-align: center; /* Centers the error message */
    }
</style>

</head>
<body>
	<div class="form-container">
		<h2>Student Registration Form</h2>
		<form action="savestudent" method="post">
 		<label for="name">Name:</label>
        <input type="text" id="name" name="name" required/><br/> 

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required pattern="[0-9]{2}"/><br/>

        <label for="mobile">Mobile:</label>
        <input type="number" id="mobile" name="mobile" required pattern="[6-9]{1}[0-9]{9}" /><br/>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required/><br/>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required pattern="[^\s@]+@[^\s@]+\.[^\s@]+" /><br/>

        <label for="course">Course:</label>
        <input type="text" id="course" name="course" required/><br/>

        <input type="submit" value="Save"/><br/>

        <% if(request.getAttribute("message")!=null){ %>
            <h4 class="error-message"><%= request.getAttribute("message") %></h4>
        <% } %>
    </form>
</div>


</body>
</html>