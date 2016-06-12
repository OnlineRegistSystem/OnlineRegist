<%@ page language="java" contentType="text/html; "
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/json.js"></script>
<script type="text/javascript" src="js/fileUpload.js"></script>
</head>
<body onload="addSelect()">
<h1>增加医生</h1>
<table>
	<tr>
		<td>名字</td>
		<td><input type="text" id="name"></td>
	</tr>
	<tr><td>等         级</td><td id="selectTd"> </td></tr>
	<tr><td>图	    片 </td><td><img alt="" width="200" height="200" id="img" name="image" src=""> </td></tr>
	<tr><td>上传图片</td><td><input type="file"  id="fileName" name="file" value="选择要上传的图片"><input type="button" value="提交" onclick="upload()" ></td></tr>
	<tr><td>描述</td><td><input type="text" id="desc"></td></tr>
	<tr><td><button onclick="addDoctor()">增加医生</button></td></tr>
</table>
<script type="text/javascript">
function addDoctor(){
	var diseaseId = getUrlValue()['diseaseId'];
	var name = $('#name').val();
	var img = $('#img').attr('src');
	var select = $('#select').val();
	var desc = $('#desc').val();
	alert(desc+img);
	if(null==name||name==''){
		alert('名字为空！');
		return;
	}
	$.ajax({
		type:'post',
		url:'manage/addDoctor',
		data:{'diseaseId':diseaseId,'name':name,'docterDesc':desc,'docterClass':select,'docterImage':img},
		success:function(result){
			if(result.code==1){
				alert('添加成功！');
				history.back(-1);
			}else{
				alert('添加失败');
			}
		},
		error:function(){}
	});
}
function addSelect(){
	$.ajax({
		url:'manage/getClassAndCost',
		success:function(result){
			if(result.code==1){
				var list = result.data;
				var html='';
				for(var i=0;i<list.length;i++){
					html += '<option value="'+list[i].id+'">'+list[i].name+'</option>';
				}
				var select = document.createElement('select');
				select.id='select';
				select.innerHTML=html;
				var td = document.getElementById('selectTd');
				td.appendChild(select);
			}
		},
		error:function(){}
	});
}
function upload(){
	 
	var files = document.getElementById('fileName').files;
	var fileName = document.getElementById('fileName').value;
	var fileExt = fileName.substring(fileName.lastIndexOf(".")+1);
	var formData = new FormData();
	formData.append('file',files[0]);
	formData.append('fileExt',fileExt);
	$.ajax({
		url:"file/upload2",
		type: 'POST',  
          data: formData,  
          async: false,  
          cache: false,  
          contentType: false,  
          processData: false,  
	 
		success:function(data){
			//var json = $.parseJSON(data);
			if(data.code==1){
				alert("上传成功");
				  alert(data.data);
	              $("#img").attr("src",data.data);
	            
			}else{
				alert(data.error);
			}
		},
		error:function(){
			alert("上传失败！");
		}
		
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
</script>
</body>
</html>