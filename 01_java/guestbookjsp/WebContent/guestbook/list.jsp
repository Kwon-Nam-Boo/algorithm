<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*, com.ssafy.guestbook.GuestBookDto"%>
    
<%
	List<GuestBookDto> list = new ArrayList<GuestBookDto>();
%>    
<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>SSAFY - 글목록</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
		<script type="text/javascript">
		function movewrite() {
			location.href="/guestbookjsp/guestbook/write.jsp";
		}
		</script>
	</head>
	<body>	
	<div class="container" align="center">
	  <div class="col-lg-8" align="center">
	  <h2>글목록</h2>
	  <p>좋은글 많이 올려 주세요!!!!!</p>  
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right"><button type="button" class="btn btn-link" onclick="javascript:movewrite();">글쓰기</button></td>
	  	</tr>
	  </table>
	  <%
	  	for(GuestBookDto dto : list){
	  %>
	  <table class="table table-active">
	    <tbody>
	      <tr class="table-info">
	        <td>작성자 : <%= dto.getName() %></td>
	        <td align="right">작성일 : <%= dto.getRegtime() %></td>
	      </tr>
	      <tr>
	        <td colspan="2" class="table-danger"><strong><%= dto.getArticleno() %></strong></td>
	      </tr>
	      <tr>
	        <td colspan="2">즐거운 하루 되세요!!</td>
	      </tr>
	    </tbody>
	  </table>
	  <%
	  	}
	  %>
	  
	  </div>
	</div>
	</body>
</html>