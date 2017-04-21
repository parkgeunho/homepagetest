<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<style type="text/css">

.btn-box {
	
	float: right;
	border-color : #3bc1c5;
	width: 50px;
	
}
.buttombox{
	width: 120px;
	}
.btn-submmit{
	
	background-color: #46D2D2;
    border-color: #46D2D2;
    color: #fff;
}
.search-icon{
	float:right;
	width: 34px;
	height: 34px;
	padding: 5px;
	background-color: #EAEAEA;
	border-left: 1px solid #D8D8D8;
}

.search-text{
	float:right;
	height: 34px;
	width: 150px;
	border: 0px;
	background-color: #EAEAEA;
	margin-left: 5px;
	
}

.selectbox {
	float:right;
  position: relative;
  width: 100px;
  border: 1px solid #999;
  z-index: 1; 
  margin-left: 10px;

}

.selectbox:before {
  content: "";
  position: absolute;
  top: 50%;
  right: 15px;
  width: 0;
  height: 0;
  margin-top: -1px;
  border-left: 5px solid transparent;
  border-right: 5px solid transparent;
  border-top: 5px solid #333;
}

.selectbox label {
  position: absolute;
  top : -3px;
  padding: .8em .5em;
  color: #999;
  z-index: -1;
}

.selectbox select {
  width: 100%;
  height: 33px;
  line-height: normal;
  font-family: inherit;
  padding: .8em .5em;
  border: 0;
  opacity: 0;
  filter:alpha(opacity=0);
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
}
table th{
	height: 30px;
}
table td{
	height: 50px;
}
</style>

<script type="text/javascript">
$(document).ready(function() {
	var selectTarget = $('.selectbox select'); 
 	selectTarget.change(function(){
  	var select_name = $(this).children('option:selected').text(); $(this).siblings('label').text(select_name);
   });
 });
</script>
</head>
<body>

	<div>
		<div>
			<span style="font-size: 30px;">게시판이름</span>
		</div>
		<div style="height: 50px;">
			<span class="search-icon"><img src="/portfolio/resources/icon/search.png"> </span>
			<input class="search-text">
			
				<span class="selectbox">
				    <label for="ex_select">내용+제목</label>
				    <select id="ex_select">
				        <option selected>내용+제목</option>
				        <option>제목</option>
				        <option>내용</option>
				        <option>작성자</option>
				    </select>
				</span>			
	
				 <span class="btn-box buttombox btn-submmit btn">작성하기</span>
		</div>
		<div>
			<table style="width: 100%">
				<Tr>
					<th style="width: 50px;background-color: red;"></th>
					<th style="width: 50px; background-color: yellow;"></th>
					 <th style="width: auto">제목</th> <th style="width: 25%">작성자</th> <th style="width: 25%">작성일</th> <th style="width: 25%; background-color: yellow;"></th>
				</Tr>
				<tr>
				
					<td style="background-color: aqua; width: 50px; height: 50px;"></td>
					<td style="background-color:appworkspace; width: 50px; height: 50px;"></td>
					<td style="background-color: black; width: auto; height: 50px;"></td>
					<td style="background-color: gray; width: 25%;height: 50px;"></td>
					<td style="background-color: maroon; width: 25%;height: 50px;"></td>
					<td style="background-color: silver; width: 25%;height: 50px;"></td>
				</tr>
				
			</table>
		</div>
	</div>

</body>
</html>