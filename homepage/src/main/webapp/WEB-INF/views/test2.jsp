<!doctype html>
<html lang="en">
 <head>
  <meta charset="EUC-KR">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Document</title>
  <style>
	#main{
		background:yellow;
		position:absolute;
		width:320pt;
		top:10pt;
		left:300pt;
	}
	#inputName{
		background:#66ff66;
		position:absolute;
		width:320pt;
		top:150pt;
		left:300pt;
		visibility:hidden;
	}
	#result{
		background:#9966ff;
		position:absolute;
		width:320pt;
		top:150pt;
		left:300pt;
		visibility:hidden;
	}
	
  </style>
  <script>
	var idNum = 0;
	var arra=[];
	var view = ["","ㅡ"];
	var num=0;
	window.onload=function(){
		var ok=document.getElementById("ok");
		
		var start=document.getElementById("start");
		var moneys=[];
		
 
		ok.onclick=function(){
			inputName.style.visibility="visible";
			num=document.getElementById("num").value;
			var show="<table border id='input'>";
			show+="<tr><th>no</th><th>이름</th><th>항목</th></tr>"
			for(var i=0; i<num; i++){
				show+="<tr><td>"+(i+1)+"</td><td><input type='text' name='name'></td><td><input type='text' name='item'></td></tr>";
			}
			show+="</table>";
			document.getElementById("show").innerHTML=show;			
		}
 
		start.onclick=function(){
			inputName.style.visibility="hidden";
			result.style.visibility="visible";
			var name=document.getElementsByName("name");
			var item=document.getElementsByName("item");
			var show1="<h3>결과</h3><br>"
			show1+="<table width='50' height='500' id='output' >";
			show1+="<tr>";
			for(var i=0; i<num; i++){
				show1+="<td><input id = "+idNum+" type='button' name='b_name' value="+name[i].value+"></td>";
				idNum++;
				if(i!=num-1){
					show1+="<td> </td>";
					idNum++;
				}
			}
			show1+="</tr>";
			for(var i=0; i<10; i++){
				show1+="<tr>";
				for(var j=0; j<num; j++){
					//show1+="<td >"+parseInt(Math.random()*2)+"</td>";
					arra[j]=parseInt(Math.random()*2);
					show1+="<td>|</td>";
					idNum++;
					if(j!=num-1){
						if(j!=0&&(arra[j-1]==1)){
							arra[j]=0;
						}
						show1+="<td>"+view[arra[j]]+"</td>"; // 0 1 2
					}
				}
				show1+="</tr>";
			}
			show1+="<tr>";
			for(var i=0; i<num; i++){
				show1+="<td>"+item[i].value+"</td>";
				if(i!=num-1){
					show1+="<td></td>";
				}
			}
			show1+="</tr>";
			show1+="</table>";
			document.getElementById("shResult").innerHTML=show1;
			var b_name = document.getElementsByName("b_name");
			for(var i = 0; i <b_name.length; i++ ){
				b_name[i].onclick=chResult;
			}
		}
	}
	 
	function chResult(){
		var tr = document.getElementsByTagName("tr");
		var i = parseInt(num)+2;
		var j = parseInt(this.id);
		var inter = null;
		var finish=tr[i].childNodes[j].innerHTML;
	
		tr[i].childNodes[j].innerHTML=3;
		inter=setInterval(function(){
		
			
					
					if(tr[i].childNodes[j-1]&&tr[i].childNodes[j-1].innerHTML=="ㅡ"){
						j=j-2;
					}
					else if(tr[i].childNodes[j+1]&&tr[i].childNodes[j+1].innerHTML=="ㅡ"){
						j=j+2;
				
					}
				
						
				finish=tr[++i].childNodes[j].innerHTML;
				tr[i].childNodes[j].innerHTML=3;
			
			if(finish!="|" && finish!="ㅡ"){
				alert(finish);
				clearInterval(inter);
			}
		},100);
	}
  </script>
 </head>
 <body>
	<div id="main">	
		<center>
		<h3>사다리 게임</h3>
		참가할 인원: <input type="text" id="num"/><br>
		<input type="button" id="ok" value="확인"/>
	</div>	
	<div id="inputName">	
		<p id="show"></p>
		<input type="button" id="start" value="사다리타기"/>
	</div>
	<div id="result">	
		<p id="shResult"></p>
	</div>



	
 </body>
</html>