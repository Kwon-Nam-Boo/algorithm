<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name;
	public void init(){
		name = "부권남";
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div align = "center">
			Hello JSP!<br>
			안녕  <% out.println(name);%> <br>
			안녕 <%=name%>
		</div>
	</body>
</html>