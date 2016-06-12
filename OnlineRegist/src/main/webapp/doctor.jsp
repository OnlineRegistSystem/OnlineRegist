<%@ page language="java" contentType="text/html;  "
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/json.js"></script>
</head>
<body onload="getScheduling()">
<h1>医生管理</h1>
<table id="table" border="1">
	<tr>
		<th>日期</th>
		<th>时间</th>
		<th>可预约人数</th>
		<th>当前状态</th>
		<th>操作</th>
	</tr>
	<tr>
		<td colspan="4"><button onclick="showAddScheduling()">增加排班表</button></td>
	</tr>
</table>
<script type="text/javascript">
function getScheduling(){
	var doctorId = getUrlValue()['doctorId'];
	$.ajax({
		type:'get',
		url:'manage/getScheduling',
		data:{'doctorId':doctorId},
		success:function (result){
			if(result.code==1){
				var list = result.data;
				for(var i=0;i<list.length;i++){
					var html ='<td>'+list[i].date+'</td>'
							+'<td>'+list[i].time+'</td>'
							+'<td>'+list[i].number+'</td>';
							 
					switch(list[i].state){
						case '1':{
							html += '<td>可预约</td>';
							break;
						}
						case '2':{
							html += '<td>人数已满</td>';
							break;
						}
						default:{
							html +='<td>停症</td>';	
						}
					}
					html +='<td>操作</td>';
					var tr = document.createElement('tr');
					tr.innerHTML = html;
					var table = document.getElementById('table');
					table.appendChild(tr);
					
				}
				 
			}else if(code==2){
				
			}else{
				alert('获取失败');
			}
		},
		error:function(){}
	});
}
function getUrlValue(){  //获取url中的参数值
	 
	var url = location.search;
	var arg = {};
	if(url.indexOf("?")!=-1){
		url = url.substr(1);
		strs= url.split("&");
		var i;
		for(i=0;i<strs.length;i++){
			var str = strs[i];
		  arg[str.split("=")[0]]=str.split("=")[1];
		}
	} 
	 
	return arg;
	}
	function showAddScheduling(){
		var doctorId = getUrlValue()['doctorId'];
		var url = 'addScheduling.jsp?doctorId='+doctorId;
		location.assign(url);
	}
	
</script>
</body>
</html>