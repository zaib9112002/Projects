<%@page import="java.util.ArrayList"%>
<%@page import="com.institute.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
</head>
<body>
<table class="table table-striped">
<thead>
<tr>
<th>Sid</th>
<th>Name</th>
<th>Age</th>
<th>Mobile</th>
<th>Address</th>
<th>Email</th>
<th>Course</th>
</tr>
</thead>

<tbody>
<%
ArrayList<Student> studentList=(ArrayList<Student>)request.getAttribute("Student List"); 
//Crucial: Handle the case where the list might be null or empty
if (studentList != null && !studentList.isEmpty()) {
for(Student s : studentList) {%>
<tr>
	<td><%= s.getId() %></td>
	<td><%= s.getName() %></td>
	<td><%= s.getAge() %></td>
	<td><%= s.getMobile() %></td>
	<td><%= s.getAddress() %></td>
	<td><%= s.getEmail() %></td>
	<td><%= s.getCourse() %></td>
</tr>
<% } 
}
else { %>
<tr>
        <td colspan="7">No students found.</td> <%-- Message when list is empty --%>
    </tr>
<% } %>

</tbody>

</table>

</body>
</html>