<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table>
		
		<tr>
			<td>��ȣ</td><td>����</td><td>��¥</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.boardnum}</td>
				<td>${dto.subject}</td>
				<td>${dto.date}</td>
			</tr>
		</c:forEach>
		
	
	</table>



</body>
</html>