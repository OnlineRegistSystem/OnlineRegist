<%@ page language = "java" pageEncoding = "utf-8" %>
<html>
	<html lang='zh'>
	<head>
		<meta http-equiv = 'Content-Type' content = 'html/text;charset=utf-8'/>
		<meta http-equiv = 'X-UA-Compatiable' content = ='IE=edge'/>
		<meta http-equiv = 'Content-Language' content = 'zh-cn'/>
		<meta name = 'keywords' content = '挂号预约，网上挂号，自助挂号'/>
		<meta name = 'description' content = '网上挂号预约平台'/>
		<title>在线预约平台</title>
		<link rel = 'stylesheet' type='text/css' href='../source/css
		/jquery-ui.css'/>
		<link rel = 'stylesheet' type='text/css' href=' source/css/index.css'/>
		<link rel = 'stylesheet' type='text/css' href='source/css/common.css'/>
		<link rel = 'stylesheet' type='text/css' href=' source/css/hospital.css'/>
		<script type = 'text/javascript' src=' source/js/jquery-1.12.3.js'></script>
		<script type = 'text/javascript' src=' source/js/jquery-ui.js'></script>
		<script type = 'text/javascript' src=' source/js/logreg.js'></script>
		<script type = 'text/javascript' src=' js/common.js'></script>
		<script type = 'text/javascript' src=' source/js/index.js'></script>
		<script type = 'text/javascript' src=' js/result.js'></script>
	</head>
	 
	<body onload="showDisease()">
		 <table id="hospitalTable" border="1">
		 	<tr>
		 		<th>科室</th>
		 		<th>疾病</th>
		 		<th>操作</th>
		 	</tr>
		 	<tr>
		 		<td colspan="3"><button onclick="showAddDepartment()">增加科室</button>
		 	</tr>
		 	
		 	
		 </table>
		 
		<script type="text/javascript">
			var hospitalId=null;
			function showAddDepartment(){
				var html = '<tr><td>科室名称</td><td><input id="departmentName" type="text" ></td></tr>'
				+'<tr><td><input type="text" value="增加科室" onclick="addDepartment()"></td></tr>';
				var table  = document.getElementById("hospitalTable");
				table.innerHTML=html;
			}
			function addDepartment(){
				var departmentName = $('#departmentName').val();
				var hospitalId = getUrlValue()["hospitalId"];
				if(null==departmentName||departmentName==""){
					alert("科室名字为空！");
					return;
				}
				alert(hospitalId);
				$.ajax({
					type:'post',
					url:'manage/addDepartment',
					data:{'name':departmentName,'hospitalId':hospitalId},
					success:function(result){
						if(result.code==1){
							alert('增加科室成功');
							location.reload();
						}else{
							alert("增加失败！");
						}
					},
					error:function(){}
				});
				
			}
			function showDisease(){
				var hospitalId= getUrlValue()["hospitalId"];
			 
				$.ajax({
					type:'post',
					url:"order/getDiseaseOfHospital",
					data:{"hospitalId":hospitalId},
					success:function(result){
						if(result.code==1){
							var departmentList = result.data;
							for(var i=0;i<departmentList.length;i++){
								var diseaseList = departmentList[i].diseaseList;
								var html = '<td>'+departmentList[i].departmentName+'</td>';
								html +='<td>';
								for(var j=0;j<diseaseList.length;j++){
									html += '<span><a onclick="intoDisease('+diseaseList[j].id+')">'+diseaseList[j].name+'</a></span>';
									
								}
								html += '</td>';
								html += '<td><a onclick="showAddDisease('+departmentList[i].departmentId+')">增加疾病</a></td>';
								var tr = document.createElement('tr');
								tr.innerHTML=html;
								var table = document.getElementById('hospitalTable');
								table.appendChild(tr);
							}
						}
					},
					error:function(){}
				});
			}
			function getUrlValue(){
				 
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
			function showAddDisease(departmentId){ //展示增加疾病的页面
				var html = '<tr><td>疾病名称</td><td><input id="diseaseName" type="text" ><input type="hidden" id="departmentId" value="'+departmentId+'"></td></tr>'
				+'<tr><td><input type="text" value="增加疾病" onclick="addDisease()"></td></tr>';
				var table  = document.getElementById("hospitalTable");
				table.innerHTML=html;
				 
			}
			function addDisease( ){//增加疾病
				var departmentId = $('#departmentId').val();
				var diseaseName = $('#diseaseName').val();
				if(null==diseaseName||diseaseName==""){
					alert("疾病名称为空");
					return;
				}
				$.ajax({
					type:'post',
					url:'manage/addDisease',
					data:{'name':diseaseName,'departmentId':departmentId},
					success:function(result){
						if(result.code==1){
							alert("添加成功！");
							location.reload();
						}else{
							alert("添加失败！");
					
						}
					},
					error:function(){}
				});
			}
			function intoDisease(diseaseId){
				var url = 'disease.jsp?diseaseId='+diseaseId;
				location.assign(url);
			}
			
		</script>
		 
		 
	</body>
</html>