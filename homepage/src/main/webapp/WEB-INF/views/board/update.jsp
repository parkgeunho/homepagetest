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
	<form action=create method="post">
			<table>
				<tr><td>제목<td><td><input type="text" name="subject" value="${dto.subject }"><td></tr>
				<tr><td>내용</td><td><textarea rows="5" cols="10" name="content">${dto.content }</textarea></td></tr>
				<tr><td><input type="submit" value="저장"><td><td><input type="button" value="취소"><td></tr>
			</table>
			
			<input type="hidden" name="boardnum"  value="${dto.boardnum }">
		</form>
</body>
</html>