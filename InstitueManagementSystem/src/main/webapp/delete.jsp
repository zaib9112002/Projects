
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Student</title>

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
  .delete-container { /* Renamed for clarity on delete page */
    background-color: #ffffff; /* White background for the form */
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 400px; /* Adjust maximum width for the form */
  }
  h1 {
    text-align: center;
    color: #dc3545; /* Changed heading color to indicate a delete action */
    margin-bottom: 20px;
  }
  h2 { /* Styling for the message */
    text-align: center;
    color: #28a745; /* Green for success or appropriate color for message */
    margin-top: 20px;
    margin-bottom: 20px;
  }
  .form-label {
    font-weight: bold;
  }
  .form-control {
    margin-bottom: 15px; /* Add some space below each input field */
  }
  .btn-danger { /* Style for the delete button */
    background-color: #dc3545;
    border-color: #dc3545;
  }
  .btn-danger:hover {
    background-color: #c82333;
    border-color: #bd2130;
  }
  .home-link {
    display: block; /* Make the link a block element for centering */
    text-align: center;
    margin-top: 20px;
  }
</style>

</head>
<body>
<div class="delete-container">
	<h2>Delete User</h2>
    <form action="Deletestudent" method="post">
        <div class="mb-3">
            <label for="userId" class="form-label">User ID:</label>
            <input type="number" id="userId" name="id" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-danger w-100">Delete</button> <%-- Red button for delete action and full width --%>
    </form>

    <%-- The message will be displayed here --%>
    <h1>${message}</h1>

    <a href="home.jsp" class="home-link btn btn-link">Back to Home</a> <%-- Styled as a link button and centered --%>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+Y7J/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous"></script>


</body>
</html>