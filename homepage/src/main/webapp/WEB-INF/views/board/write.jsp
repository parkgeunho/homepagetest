<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 



<link rel="stylesheet" href="/portfolio/resources/summernote/summernote.css">
<script src="/portfolio/resources/summernote/summernote.js"></script>
<script src="/portfolio/resources/summernote/summernote-ko-KR.js"></script>



<body>
	<form action="create" method="post" enctype="multipart/form-data" name="myForm">
		<table>
			<tr><td>제목<td><td><input type="text" name="subject"><td></tr>
			<tr><td>내용</td>
			
			<td>
			
			<textarea rows="5" cols="10" name="content" style="display: none;"></textarea>
			<div id="summernote" style="margin-bottom: 0"></div>
			
			</td>
			
			
			</tr>
			<tr><td><input type="file" name=uploadlists multiple="" /></td></tr>
			<tr><td><input type="button" value="저장" onclick="#" id="sub"><td><td><input type="button" value="취소"><td></tr>
		</table>
	</form>
	
	
	
	
	
	
	
	  <script>
    $(document).ready(function() {
        $('#summernote').summernote({
        
        	lang:'ko-KR'
        	 
        });
        
        $('#sub').click(function(){
        	alert("?");
        	
        	var form = $('[name="myForm"]');
        	alert(form);
        	 	var text = $('#summernote').summernote('code');
        	 	alert(text);
        	 
        	$('[name=content]').val(text);
        	
        	form.submit();
        });
        
        
        
    });
  </script>
	
</body>
</html>