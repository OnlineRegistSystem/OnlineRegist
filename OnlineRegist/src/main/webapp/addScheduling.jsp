<%@ page language="java" contentType="text/html;  "
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/json.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/util.js"></script>


</head>
<body>
<h1>增加排班表</h1>
<table>
	<tr>
		<td>日期</td>
		<td><input  type="text" id="date"></td>
	</tr>
	<tr>
		<td>时间</td>
		<td><select id="time">
			<option value="9:00-10:00">9:00-10:00</option>
			<option value="10:00-11:00">10:00-11:00</option>
			<option value="11:00-12:00">11:00-12:00</option>
			<option value="14:00-15:00">14:00-15:00</option>
			<option value="15:00-16:00">5:00-16:00</option>
			<option value="16:00-17:00">16:00-17:00</option>
			<option value="9:00-10:00">9:00-10:00</option>
			<option value="9:00-10:00">9:00-10:00</option>
			<option value="9:00-10:00">9:00-10:00</option>
			<option value="9:00-10:00">9:00-10:00</option>
			<option value="9:00-10:00">9:00-10:00</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>可预约人数</td>
		<td><input type="text" id="number"></td>
	</tr>
	<tr>
		<td>状态</td>
		<td>
			<select id="state">
				<option value="1">可预约</option>
				<option value="0">停诊</option>
			</select>
		</td>
	</tr>
	<tr>
		<td><input type="text" onclick="addScheduling()" value="增加"></td>
		
	</tr>
	

</table>
<script type="text/javascript">
 
$(document).ready(function (){
	$('#date').datepicker({ dateFormat:'yy-mm-dd'});
});
function addScheduling(){
	var doctorId = getUrlValue()['doctorId'];
	var date = $('#date').val();
	var time = $('#time').val();
	var number = $('#number').val();
	var state = $('#state').val();
	if(null==date||date==""){
		alert('时间为空');
		return;
	}
	if(null==number||number==''){
		alert('数量为空');
		return;
	}
	$.ajax({
		type:'post',
		url:'manage/addScheduling',
		data:{'doctorId':doctorId,'date':date,'time':time,'number':number,'state':state},
		success:function(result){
			if(result.code==1){
				alert('添加成功');
				location.replace('doctor.jsp?doctorId='+doctorId);
			}else{
				alert(添加失败);
			}
		},
		error:function(){}
	});
}

</script>
</body>
</html>