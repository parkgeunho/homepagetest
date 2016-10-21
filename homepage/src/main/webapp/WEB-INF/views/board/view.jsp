<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table>
	
		<tr><td>제목</td><td>${dto.subject }</td></tr>
		<tr><td>작성일</td><td>${dto.date }</td></tr>
		<tr><td>내용</td><td>${dto.content }</td></tr>
		
		<c:forEach var="file" items="${list }">
			<Tr>
				<td colspan="2">
				<a href = <c:url value="/board/filedown/${file.filenum }"></c:url> >${file.originname }</a>
				</td>
			
			</Tr>
		
		</c:forEach>
		
		
	</table>
		<input type="button" value="수정"  onclick="check('update')"> 
		<input type="button" value="삭제" onclick="check('delete')">
		<input type="button" value="집으로" onclick="check()">
		
	<form name="myForm" action="/portfolio/board/replysave" method="post">
		 <input type="hidden" name="boardnum" value="${dto.boardnum }">
        작성자: <input type="text" name="rewriter" size="20" maxlength="20"> <br/>
        <textarea name="rememo" rows="3" cols="60" maxlength="500" placeholder="댓글을 달아주세요."></textarea>
       <input type="submit">
	
	</form>
</body>


	<script type="text/javascript">
	
	function check(check){
		

		if(check=='delete'){
			document.myForm.action="delete";
			myForm.submit();
		}else if(check=='update'){
			document.myForm.action="/portfolio/board/update/"+${dto.boardnum};
			myForm.submit();
		}else{
			location.href = "/portfolio/board/list";
		}
		
	}
	
	
	
	</script>

</html>