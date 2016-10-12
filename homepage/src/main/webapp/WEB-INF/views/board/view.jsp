<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="myForm" method="post">
	<table>
	
		<tr><td>제목</td><td>${dto.subject }</td></tr>
		<tr><td>작성일</td><td>${dto.date }</td></tr>
		<tr><td>내용</td><td>${dto.content }</td></tr>
		
	</table>
		<input type="hidden" name="boardnum" value="${dto.boardnum }">
		<input type="button" value="수정"  onclick="check('update')"> 
		<input type="button" value="삭제" onclick="check('delete')">
		<input type="button" value="집으로" onclick="check()">
	</form>
</body>


	<script type="text/javascript">
	
	function check(check){
		

		if(check=='delete'){
			document.myForm.action="delete";
			myForm.submit();
		}else if(check=='update'){
			document.myForm.action="/portfolio/board/update";
			myForm.submit();
		}else{
			location.href = "/portfolio/board/list";
		}
		
	}
	
	
	
	</script>

</html>