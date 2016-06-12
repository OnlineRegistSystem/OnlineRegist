<%@ page language="java" contentType="text/html; "
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/json.js"></script>
</head>
<body onload="showDoctors()">
	<table id="doctorTable" border="1">
		<tr>
		<th>医生头像</th>
		<th>名字</th>
		<th>等级</th>
		<th>描述</th>
		<th>操作</th>
		</tr>
		<tr>
		<td> <button onclick="addDoctor( )">增加医生</button></td>
		</tr>
	</table>
	<script type="text/javascript">
		function showDoctors(){
			var diseaseId = getUrlValue()['diseaseId'];
			$.ajax({
				type:'post',
				url:'order/getDocterOfDisease',
				data:{'diseaseId':diseaseId,'page':1,'pageSize':1000},
				success:function(result){
					if(result.code==1){
						alert('成功');
						var doctorList = result.data.doctors;
						for(var i=0;i<doctorList.length;i++){
							var html = '<td><img  src="'+doctorList[i].doctorImage+'"></td><td>'
							+doctorList[i].doctorName
							+'</td><td>'+doctorList[i].doctorClass+'</td><td>'
							+doctorList[i].doctorDesc+'</td><td><button onclick="intoDoctor('+doctorList[i].doctorId+')">查看排班信息</button></td>';
							var table = document.getElementById('doctorTable');
							var tr = document.createElement('tr');
							tr.innerHTML=html;
							table.appendChild(tr);
						}
					}else {
						alert("请求失败");
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
		function addDoctor( ){
			
		 var diseaseId = getUrlValue()['diseaseId'];
		 var url = 'addDoctor.jsp?diseaseId='+diseaseId;
		 location.assign(url);
			
		}
		function intoDoctor(doctorId){
			var url = 'doctor.jsp?doctorId='+doctorId;
			alert(url);
			location.assign(url);
		}
	</script>

</body>
</html>