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
			<td>��ȣ</td><td>����</td><td>��¥</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.boardnum}</td>
				<td><a href="view/${dto.boardnum }">${dto.subject}</a></td>
				<td>${dto.date}</td>
			</tr>
		</c:forEach>
		
	
	</table>
	<div>
		<form method="post">
			<select name="searchTypeArr">
				<option value="subject" selected="selected">subject</option>
			</select>
			<input type="text" name="searchKeyword">
			<input type="submit">
		</form>
	</div>
	
	<div class="paging">
    <c:forEach var="i" begin="${paging.pageStart}" end="${paging.pageEnd}" step="1">
        <c:url var="pageLink" value="list">
        <c:param name="page" value="${i}" />
        </c:url>                        
            <a href="${pageLink}"><c:out value="${i}"/></a>
    </c:forEach>
</div>



</body>
</html>