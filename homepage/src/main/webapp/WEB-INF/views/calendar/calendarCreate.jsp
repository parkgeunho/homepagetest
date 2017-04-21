<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  <link rel="stylesheet" href="/portfolio/resources/summernote/summernote.css">
<script src="/portfolio/resources/summernote/summernote.js"></script>
<script src="/portfolio/resources/summernote/summernote-ko-KR.js"></script>
</head>

<script type="text/javascript">


	function setTime() {
		var f = document.myForm;
		
		var sth = f.stH;
		var endh = f.endH;
		
		var stM = f.stM;
		var endM = f.endM;
		
		for (i=0; i < 24; i++){
			
			if(i<10){
				sth[i] = new Option("0"+i);
				endh[i] = new Option("0"+i);
			}
			else{
				sth[i] = new Option(i);
				endh[i] = new Option(i);
			}
		}
		
		for (i = 0; i < 60 ; i ++){
			if(i<10){
				stM[i] = new Option("0"+i);
				endM[i] = new Option("0"+i);
			}
			else{
				stM[i] = new Option(i);
				endM[i] = new Option(i);
			}
			
		}
		
	}
</script>

<script type="text/javascript">

$(function(){
	
	$.datepicker.setDefaults(
		$.datepicker.regional['ko'] = {
										closeText: '닫기',
										prevText: '이전달',
										nextText: '다음달',
										currentText: '오늘',
										monthNames: ['1월(JAN)','2월(FEB)','3월(MAR)','4월(APR)','5월(MAY)','6월(JUN)',
										'7월(JUL)','8월(AUG)','9월(SEP)','10월(OCT)','11월(NOV)','12월(DEC)'],
										monthNamesShort: ['1월','2월','3월','4월','5월','6월',
										'7월','8월','9월','10월','11월','12월'],
										dayNames: ['일','월','화','수','목','금','토'],
										dayNamesShort: ['일','월','화','수','목','금','토'],
										dayNamesMin: ['일','월','화','수','목','금','토'],
										weekHeader: 'Wk',
										dateFormat: 'yy-m-d',
										firstDay: 0,
										isRTL: false,
										showMonthAfterYear: true,
										yearSuffix: ''},
									{dateFormat:'yy-m-d'});

	$('[id^="calendar"]').datepicker({
		
		showOn: 'button',
		buttonImageOnly: true,
		buttonImage:'/portfolio/resources/cal.png',
		showButtonPanel: true,
		showAnim: 'fold',
		dateFormat: 'yy-m-d'
	});
});
</script>
<body>
<form name="myForm">
<div>
	<div style="height: 70px;">일정 관리</div>
	<div style="height: 50px;background-color: yellow; ">
		<div style="float: left; width: 15% ;height: 50px;">제목</div>
		<div style="float: left; width: 85%;height: 50px;"><input> </div>
	</div>
	
	<div style="height: 50px;background-color: yellow; ">
		<div style="float: left; width: 15%;height: 50px;">날짜</div>
		<div style="float: left; width: 85%;height: 50px;"><input style="text-align: center;" size="8" type="text" id="calendarSt" name="calendarSt"/>&nbsp;~
			<input style="text-align: center;" size="8" type="text" id="calendarEnd" name="calendarEnd"/></div>
	</div>
	
	<div style="height: 50px;background-color: yellow; ">
	<div style="float: left; width: 15%;height: 50px;">시간</div>
		<div style="float: left; width: 85%;height: 50px;">
		<select id="stH" name="stH" ></select>&nbsp;:
			<select id="stM" name="stM" >
			</select>&nbsp;~
			<select id="endH" name="endH" ></select>&nbsp;:
			<select id="endM" name="endM" ></select>
			 </div>
	</div>
	
	<div>
		<div id="summernote"></div>
	</div>
	

</div>
</form>
</body>
<script>
    $(document).ready(function() {
    	
    	setTime();
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
</html>