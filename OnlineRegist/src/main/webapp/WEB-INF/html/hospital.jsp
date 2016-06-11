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
		<link rel = 'stylesheet' type='text/css' href='../source/css/index.css'/>
		<link rel = 'stylesheet' type='text/css' href='../source/css/common.css'/>
		<link rel = 'stylesheet' type='text/css' href='../source/css/hospital.css'/>
		<script type = 'text/javascript' src='../source/js/jquery-1.12.3.js'></script>
		<script type = 'text/javascript' src='../source/js/jquery-ui.js'></script>
		<script type = 'text/javascript' src='../source/js/logreg.js'></script>
		<script type = 'text/javascript' src='../source/js/common.js'></script>
		<script type = 'text/javascript' src='../source/js/index.js'></script>
		<script type = 'text/javascript' src='../source/js/result.js'></script>
	</head>
	<body>
	<body>
		<jsp:include page='header.jsp'></jsp:include>
		<div class="wrap">
			<div class="hospital-wrap">
				<strong>预约挂号</strong>
				<div class='content'>
					<p id='hospital-focused'>
						<span class='name'>--</span>
						<span class='focused'>已选医院</span>
					</p>
					<img src='../source/images/4.jpg' alt=''/>
					<p class='hospital-focused-address'>--</p>
					<p class='hospital-focused-phone'>--</p>
				</div>
			</div>
			<p class="room-decoration">开放预约科室</p>
			<div class='room-wrap'>
				<span class='room-id'>---</span>
				<ul>
					<li><a href="">---</a></li>
					<li><a href="">---</a></li>
					<li><a href="">---</a></li>
					<li><a href="">---</a></li>
					<li><a href="">---</a></li>
				</ul>
			</div>
		</div>
		<jsp:include page='footer.jsp'></jsp:include>
	</body>
</html>