<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function test(){
		alert("??");
	}

</script>
<body>

	<table>
		
		<tr>
			<td>번호</td><td>제목</td><td>날짜</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.boardnum}</td>
				<td><a href="view/${dto.boardnum }">${dto.subject}</a></td>
				<td>${dto.date}</td>
			</tr>
		</c:forEach>
		
	
	</table>



</body>
</html>