<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.util.ArrayList" %>
    <%@ page import ="java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> this is first jsp</h1>
	<%-- 지시어 include: 복사해서 붙여 넣기 효과
	in.jsp 내용이 자주 바뀌면 좋지 않다 --%>
	<%@ include file="in.jsp" %>
	<%@ include file="in.jsp" %>
	<%@ include file="in.jsp" %>
</body>
</html>