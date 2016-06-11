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
		 		<td colspan="3"><button onabort="addDepartment()">增加科室</button>
		 	</tr>
		 </table>
		 
		<script type="text/javascript">
			var hospitalId=null;
			function addDeapartment(){
				
			}
			function showDisease(){
				var hospitalId= getUrlValue()["hospitalId"];
				alert(hospitalId);
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
									html += '<span><a>'+diseaseList[j].name+'</a></span>';
									
								}
								html += '</td>';
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
				alert(location.search);
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
			
			function addDisease(departmentId){
				
			}
		</script>
		 
		 
	</body>
</html>