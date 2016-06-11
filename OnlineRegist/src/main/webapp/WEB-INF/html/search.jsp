
<%@ page language = "java" pageEncoding = "utf-8" %>
<!DOCTYPE>
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
		<script type = 'text/javascript' src='../source/js/jquery-1.12.3.js'></script>
		<script type = 'text/javascript' src='../source/js/jquery-ui.js'></script>
		<script type = 'text/javascript' src='../source/js/logreg.js'></script>
		<script type = 'text/javascript' src='../source/js/common.js'></script>
		<script type = 'text/javascript' src='../source/js/search.js'></script>
	</head>
	<body>
		<!--首部页面-->
		<jsp:include page='header.jsp'></jsp:include>
		<div class='search-result'>
			<h5>搜素结果</h5>
			<p class='important-word'>
				检索关键字:
				<span class='import-word' style='color: red;'>---</span>
			</p>
			<!--<div class='none-result' style='display: none;'>
				<p>
					没有找到与“
					<span class='import-word' style='color: #FF6752;'>---</span>
					”相关的
					<span>医院</span>
					，建议更改关键词试试。
				</p>
			</div>-->
			<!--<div>
				<ul class='result-list'>
					<li>
						<img src='../source/images/4.jpg' alt=''/>
						<p id='search-hospital-name'>长江医院</p>
						<p class='search-hospital-level'>三级甲等</p>
						<p class='search-hospital-room'>普通内科</p>
						<p class='search-hospital-phone'><span>电话：</span>123456</p>
						<p class='search-hospital-address'><span>医院地址：</span>长江大道长江路1456号</p>
						<div id='search-book'>
						
						</div>
					</li>
					<li>
						<img src='../source/images/4.jpg' alt=''/>
						<p id='search-hospital-name'>长江医院</p>
						<p class='search-hospital-level'>三级甲等</p>
						<p class='search-hospital-room'>普通内科</p>
						<p class='search-hospital-phone'><span>电话：</span>123456</p>
						<p class='search-hospital-address'><span>医院地址：</span>长江大道长江路1456号</p>
						<div id='search-book'>
						
						</div>
					</li>
					<li>
						<img src='../source/images/4.jpg' alt=''/>
						<p id='search-hospital-name'>长江医院</p>
						<p class='search-hospital-level'>三级甲等</p>
						<p class='search-hospital-room'>普通内科</p>
						<p class='search-hospital-phone'><span>电话：</span>123456</p>
						<p class='search-hospital-address'><span>医院地址：</span>长江大道长江路1456号</p>
						<div id='search-book'>
						
						</div>
					</li>
					<li>
						<img src='../source/images/4.jpg' alt=''/>
						<p id='search-hospital-name'>长江医院</p>
						<p class='search-hospital-level'>三级甲等</p>
						<p class='search-hospital-room'>普通内科</p>
						<p class='search-hospital-phone'><span>电话：</span>123456</p>
						<p class='search-hospital-address'><span>医院地址：</span>长江大道长江路1456号</p>
						<div id='search-book'></div>
					</li>
					<li>
						<img src='../source/images/4.jpg' alt=''/>
						<p id='search-hospital-name'>长江医院</p>
						<p class='search-hospital-level'>三级甲等</p>
						<p class='search-hospital-room'>普通内科</p>
						<p class='search-hospital-phone'><span>电话：</span>123456</p>
						<p class='search-hospital-address'><span>医院地址：</span>长江大道长江路1456号</p>
						<div id='search-book'>
						
						</div>
					</li>
					<li>
						<img src='../source/images/4.jpg' alt=''/>
						<p id='search-hospital-name'>长江医院</p>
						<p class='search-hospital-level'>三级甲等</p>
						<p class='search-hospital-room'>普通内科</p>
						<p class='search-hospital-phone'><span>电话：</span>123456</p>
						<p class='search-hospital-address'><span>医院地址：</span>长江大道长江路1456号</p>
						<div id='search-book'>
						
						</div>
					</li>
				</ul>
			</div>-->
		</div>
		<div class='book-hospital'>
			
		</div>
		<jsp:include page='footer.jsp'></jsp:include>
	</body>
</html>
