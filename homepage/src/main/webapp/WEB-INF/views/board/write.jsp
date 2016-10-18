<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="create" method="post" enctype="multipart/form-data">
		<table>
			<tr><td>제목<td><td><input type="text" name="subject"><td></tr>
			<tr><td>내용</td><td><textarea rows="5" cols="10" name="content"></textarea></td></tr>
			<tr><td><input type="file" name=uploadlists multiple="" /></td></tr>
			<tr><td><input type="submit" value="저장"><td><td><input type="button" value="취소"><td></tr>
		</table>
	</form>
</body>
</html>