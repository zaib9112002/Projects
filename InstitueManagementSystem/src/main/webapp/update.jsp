<%@page import="com.institute.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

<style>
  .my-div input {
    width: 300px; /* Sets the width of all descendant input fields */
  }
  .form-label {
  	align:center;
    font-weight: bold;
  }
</style>

</head>
<body>
<form action="showStudentdatatoupdate" method="post">
 <div class="mb-3" align="center">
    <label for="exampleInputEmail1" class="form-label">Enter mobile Number</label>
    <input type="number" style="width:300px;" name="mobile" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required/>
	<button type="submit" class="btn btn-primary" value="Show data">Show data</button>
</div>
</form>
<%
if(request.getAttribute("student data")!=null){
	if(request.getAttribute("student data").equals("Invalid Mobile number")){%>
	<label class="form-label"style="color:red;"><%=request.getAttribute("student data") %></label>
<% }
	else
	{
	Student s = (Student) request.getAttribute("student data");
 %>
 <form action="updatestudentdata" method="post">
<div class="my-div" align="center">
   <label class="form-label">Name</label>
    <input type="text" style="width:300px;" name="name" value="<%=s.getName() %>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>

<div class="my-div" align="center">
   <label for="exampleInputEmail1" class="form-label">Age</label>
    <input type="number"  name="age" value="<%=s.getAge() %>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>

<div class="my-div" align="center">
   <label for="exampleInputEmail1" class="form-label">Mobile</label>
    <input type="number" name="mobile" value="<%=s.getMobile() %>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>

<div class="my-div" align="center">
   <label for="exampleInputEmail1" class="form-label">Address</label>
    <input type="text" name="address" value="<%=s.getAddress()%>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>

<div class="my-div" align="center">
   <label for="exampleInputEmail1" class="form-label">Email</label>
    <input type="email" name="email" value="<%=s.getEmail()%>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>


<div class="my-div" align="center">
   <label for="exampleInputEmail1" class="form-label">Course</label>
    <input type="text" name="course" value="<%=s.getCourse() %>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="my-div" align="center">
	<button type="submit" class="btn btn-primary" value="updatestudentdata">Update</button>
</div>
</form>
<% }
	}%>

<%if(request.getAttribute("message")!=null) {%>
<label class="form-label" style="color:green" ><%= request.getAttribute("message") %></label>
<% } %></body>
</html>