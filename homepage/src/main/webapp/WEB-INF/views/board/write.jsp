<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
.test {
	border-collapse: collapse;
	margin-top: 10px;
}

.test td {
	border: 1px solid black;
}

.btn-box {
	
	float: right;
	border-color : #3bc1c5;
	width: 50px;
	
}
.btn-submmit{
	margin-right : 10px;
	background-color: #46D2D2;
    border-color: #46D2D2;
    color: #fff;
}

#fileupload{
	display: none;
}

.buttombox{
	width: 120px;
	}
.header {
	width : 20%;
	height: 50px;
	font-weight: bolder;
	line-height: 25px;
	text-align: center;
}

.checks {position: relative;
}


.checks input[type="checkbox"] {  /* 실제 체크박스는 화면에서 숨김 */
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip:rect(0,0,0,0);
  border: 0
}
.checks input[type="checkbox"] + label {
  display: inline-block;
  position: relative;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
}
.checks input[type="checkbox"] + label:before {  /* 가짜 체크박스 */
  content: ' ';
  display: inline-block;
  width: 20px;  /* 체크박스의 너비를 지정 */
  height: 20px;  /* 체크박스의 높이를 지정 */
  line-height: 20px; /* 세로정렬을 위해 높이값과 일치 */
  margin: -4px 8px 0 0;
  text-align: center; 
  vertical-align: middle;
  background: #fafafa;
  border: 1px solid #cacece;
  border-radius : 3px;
  box-shadow: 0px 1px 2px rgba(0,0,0,0.05), inset 0px -15px 10px -12px rgba(0,0,0,0.05);
}
.checks input[type="checkbox"] + label:active:before,
.checks input[type="checkbox"]:checked + label:active:before {
  box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px 1px 3px rgba(0,0,0,0.1);
}

.checks input[type="checkbox"]:checked + label:before {  /* 체크박스를 체크했을때 */ 
  content: '\2714';  /* 체크표시 유니코드 사용 */
  color: #99a1a7;
  text-shadow: 1px 1px #fff;
  background: #e9ecee;
  border-color: #adb8c0;
  box-shadow: 0px 1px 2px rgba(0,0,0,0.05), inset 0px -15px 10px -12px rgba(0,0,0,0.05), inset 15px 10px -12px rgba(255,255,255,0.1);
}

.checks label {
	
	margin-top: 10px;
}
</style>
</head>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 


<link rel="stylesheet" href="/portfolio/resources/summernote/summernote.css">
<script src="/portfolio/resources/summernote/summernote.js"></script>
<script src="/portfolio/resources/summernote/summernote-ko-KR.js"></script>


<body>

<div style="width: 100%;">
	<div> <span style="font-size: 30px;">게시판목록</span> <span class="  btn btn-box">목록</span> </div>
	<div>
		<form action="create" method="post" enctype="multipart/form-data" name="myForm">
			<table class="test">
				<tr>
					<td class="header">제목</td>
					<td style="border: 1px solid;height :  50px; padding: 5px 20px 5px 10px; width: 80%"><input type="text" name="subject" style="width: 100% ; height: 40px; "><td>
				</tr>
				<tr>
					<td class="header">작성자</td>
				
					<td style="width: 80%; height: 50px;">블라블라브랄블라</td>
				
				</tr>
				
				<tr>
					<td colspan="2">
					<div id="summernote"></div>
					</td>
				</tr>
				<tr>
					
					<td class="header">첨부파일</td><td><input type="file" name=uploadlists multiple="" id="fileupload" />
						<span class="btn" id="uploadicon">업로드 </span>
					</td>
				</tr>
			</table>
			<div style="margin-top: 10px;">
							<span class="checks">
						  		<input type="checkbox" id="ex_chk"> 
						 		<label for="ex_chk">공지사항</label> 
							</span>
						 	<span class=" btn  buttombox btn-box">취소</span> <span class="btn-box buttombox btn-submmit btn">등록</span>
		 	 </div>
		</form>
	</div>
	
</div>	
	
  <script>
    $(document).ready(function() {
        $('#summernote').summernote({
        
        	lang:'ko-KR'
        	 
        });
        
        $('#uploadicon').click(function(){
        	
        	$('#fileupload').click();
        	
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