<%@ page language="java" contentType="text/html;v"
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

<body onload="loadData()">
<h1 align="center">医院管理</h1>

<form  id="addHospital" action="" method="post">
	医院名称<input type="text" name="name"><br/>
	地          区<select id="positionSelect"></select><br>
	图	    片 <img alt="" width="200" height="200" id="img" src=""> <br>
	上传图片<input type="file"  id="fileName" name="file" value="选择要上传的图片"><input type="button" value="提交" onclick="upload()" >
	描	    述<input type="text" name="desc"><br>
	医院等级<select id="classSelect"></select><br>
	电	    话<input type="text" name="phone"><br>
	地	    址<input type="text" name="address"><br>
	<input type="button" value="提交" onclick="addHospital()">
<script language="javascript" type="text/javascript">
	function addHospital(){
		
		$.ajax({
            cache: true,
            type: "POST",
            url:"manage/addHospital",
            data:$('#addTest').serialize(),// 你的formid
            async: false,
            error: function(request) {
                alert("Connection error");
            },
            success: function(data) {
            	var result = JSON.parse(data);
                alert("添加医院成功！"+result.code);
            } 
        });
	
} 
	 function upload(){
		 alert("haha");
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
	 function  loadData(){
		 alert("加载数据");
		 $.ajax({
			 type:"post",
			 url:""
		 });
		 
	 }

	</script>
				

</form>
</body>
</html>