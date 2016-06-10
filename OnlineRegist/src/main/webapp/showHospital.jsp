<%@ page language="java" contentType="text/html;  "
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel = 'stylesheet' type='text/css' href=' source/css/index.css'/>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/json.js"></script>
<script type="text/javascript" src="js/fileUpload.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<style type="text/css">
	#hospitalTable{
		margin: 0 auto ;
		width: 960px;
	}
	</style>
</head>

<body onload="showHospital()">

<h1 align="center">医院管理</h1>

<table id="hospitalTable" border="1">
	<tr>
	<th>医院</th>
	<th>操作</th>
	</tr>
	<tr>
		 <td colspan="4"><input type="button" value="增加医院"  onclick="addHospital()"></td>
	</tr>
	
</table>
<script type="text/javascript">
	function addHospital(){
		location.assign("addHospital.jsp");
	}
	function showHospital(){
		$.ajax({
			type:'get',
			url:'order/getHospitalByPage',
			data:{'page':0},
			success:function (result){
				if(result.code==1){
					var data = result.data.hospitals;
					
					for(var i=0;i<data.length;i++){
						var html  =	 '<td><li><img src='
						 + data[i].image 
						 + ' alt=""/><p class="search-hospital-name">'
						 + data[i].name
						 + '</p><p class="search-hospital-level">'
						 + data[i].hospitalClass
						 + '</p><p class="search-hospital-phone"><span>电话：</span>'
						 + data[i].hospitalPhone
						 + '</p><p class="search-hospital-address"><span>医院地址：</span>'
						 + data[i].hospitalAddress
						 + '</li></td>'
						 +'<td><button onclick="intoHospital('+data[i].id+ ')"    >进入医院</button></td>';
						var docTr = document.createElement('tr');
						docTr.innerHTML=html;
						 var table = document.getElementById("hospitalTable");
							table.appendChild(docTr);
					}
					
				}
				
			},
			error:function (){}
		});
	}
	function intoHospital(hospitalId){ 
		alert("heere");
		var url = "hospital.jsp?name= test&hospitalId="+hospitalId ;
		location.assign(url);
	}

</script>
</body>
</html>