<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
</head>
<body><form action="studenthome" method="post">
<nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
  <input type="submit" class="btn btn-Dark" name="action" value ="Add Student"/>
  <input type="submit" class="btn btn-Dark" name="action" value="Display"/>
  <input type="submit" class="btn btn-Dark" name="action" value="Update"/>
  <input type="submit" class="btn btn-Dark" name="action" value="Delete"/>
  
</nav>
</form>

</body>
</html>