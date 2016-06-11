
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
		<script type = 'text/javascript' src='../source/js/index.js'></script>
	</head>
	<body>
		<!--首部页面-->
		<jsp:include page='header.jsp'></jsp:include>
			<div class='container-two'>
				<div id='banner'>
					<div class='banner-bg'></div>
					<div class='banner-info'></div>
					<ul>
						<li class='on'>1</li>
						<li>2</li>
						<li>3</li>
						<li>4</li>
					</ul>
					<div class='banner-list'>
						<a href='#'><img src='../source/images/banner-one.jpg' alt='健康问题，免费咨询' title='健康问题，免费咨询'></a>
						<a href='#'><img src='../source/images/banner-two.jpg' alt='颜值担当，开始投票' title='颜值担当，开始投票'></a>
						<a href='#'><img src='../source/images/banner-three.jpg' alt='在线义诊，关爱胃健康' title='在线义诊，关爱胃健康'></a>
						<a href='#'><img src='../source/images/banner-four.jpg' alt='癌全保，100%报销' title='癌全保，100%报销'></a>
					</div>
				</div>
				<div id='inform'>
					<div class='inform-bar'>
						<span>公告通知</span>
						<a href='#'>更多</a>
					</div>
					<ul class='inform-list'>
						<li class='inform-list-options'><a href='#'>2016劳动节各大医院门诊安排</a></li>
						<li class='inform-list-options'><a href='#'>2016春节各大医院门诊安排</a></li>
						<li class='inform-list-options'><a href='#'>2016清明节各大医院门诊安排</a></li>
						<li class='inform-list-options'><a href='#'>部分医院停止预约</a></li>
						<li class='inform-list-options'><a href='#'>抗战胜利70周年大医院放假安排</a></li>
						<li class='inform-list-options'><a href='#'>部分医院预约费用变更通知</a></li>
						<li class='inform-list-options'><a href='#'>首次预约挂号可以使用哪些证件</a></li>
						<li class='inform-list-options'><a href='#'>如何进行预约</a></li>
						<li class='inform-list-options'><a href='#'>预约成功后，怎么取号,点击获取详情</a></li>
						<li class='inform-list-options'><a href='#'>如何支付挂号费</a></li>
					</ul>
				</div>
				<div id='select-hospital-room'>
					<div class='hospital-room-bar'>
						<span id='hos-btn' class='hospital-room-btn btn-selected'>医院</span>
						<span id='room-btn' class='hospital-room-btn'>科室</span>
					</div>
					<div class='place'>
						<ul class='place-list'>
							<li><a href='#' class='place-selected'>全部</a></li>
							<li><a href='#'>东城区</a></li>
							<li><a href='#'>西城区</a></li>
							<li><a href='#'>朝阳区</a></li>
							<li><a href='#'>天河区</a></li>
							<li><a href='#'>番禺区</a></li>
							<li><a href='#'>海珠区</a></li>
							<li><a href='#'>龙门</a></li>
							<li><a href='#'>黄埔</a></li>
							<li><a href='#'>其他</a></li>
						</ul>
					</div>
					<!--医院选择列表-->
					<div id='hosptital-lists'>
						<ul class='hospital-show'>
							<li class='hospital-show-option'>
								<img src='../source/images/3.jpg' title='煤炭总医院'/>
								<a href='#'>煤炭总医院</a>
								<p class='level'>【二级甲等】</p>
								<p class='tel'>电话：010-222457</p>
								<p class='address'>地址：朝阳区西坝河南路188号</p>
							</li>
							<li class='hospital-show-option'>
								<img src='../source/images/4.jpg' title='航天总医院'/>
								<a href='#'>航天总医院</a>
								<p class='level'>【二级甲等】</p>
								<p class='tel'>电话：010-22784117转457</p>
								<p class='address'>地址：丰台区丰台镇西安街1号</p>
							</li>
							<li class='hospital-show-option'>
								<img src='../source/images/5.jpg' title='第一军医院'/>
								<a href='#'>第一军医院</a>
								<p class='level'>【三级综合医院】</p>
								<p class='tel'>电话：020-45217823</p>
								<p class='address'>地址：丰台区丰台南路99号</p>
							</li>
							<li class='hospital-show-option'>
								<img src='../source/images/7.jpg' title='人民中心医院'/>
								<a href='#'>人民中心医院</a>
								<p class='level'>【三级合格】</p>
								<p class='tel'>电话：020-2226666</p>
								<p class='address'>地址：番禺区桥南街7854号</p>
							</li>
							<li class='hospital-show-option'>
								<img src='../source/images/4.jpg' title='八一医院'/>
								<a href='#'>八一医院</a>
								<p class='level'>【三级甲等】</p>
								<p class='tel'>电话：010-666888转789</p>
								<p class='address'>地址：天河区珠江新城黄华路45号</p>
							</li>
							<li class='hospital-show-option'>
								<img src='../source/images/9.jpg' title='妇幼医院'/>
								<a href='#'>妇幼医院</a>
								<p class='level'>【一级专科】</p>
								<p class='tel'>电话：010-222785527</p>
								<p class='address'>地址：黄浦区外滩九里街生产路1号</p>
							</li>
						</ul>
						<div class='load-more'><a href='#'>加载更多</a></div>
					</div>
					<!--科室列表-->
					<div class='rooms' style='display:none;'>
						<ul class='rooms-type'>
							<li><a href='#' class='rooms-selected'>内科</a></li>
							<li><a href='#'>外科</a></li>
							<li><a href='#'>妇产科</a></li>
							<li><a href='#'>生殖中心</a></li>
							<li><a href='#'>儿科</a></li>
							<li><a href='#'>骨外科</a></li>
							<li><a href='#'>眼科</a></li>
							<li><a href='#'>口腔科</a></li>
							<li><a href='#'>二鼻咽喉头颈科</a></li>
							<li><a href='#'>肿瘤科</a></li>
							<li><a href='#'>其他</a></li>
						</ul>
					</div>
					<div id='room-lists' style='display:none;'>
						<ul class='room-show'>
							<li class='room-show-option'>
								<img src='../source/images/131.jpg' title='煤炭总医院'/>
								<a href='#'>第一中医院</a>
								<p class='level'>【二级甲等】</p>
								<p class='room-name'>科室：内科</p>
								<p class='address'>地址：海珠区西坝河南路188号</p>
							</li>
							<li class='room-show-option'>
								<img src='../source/images/132.jpg' title='航天总医院'/>
								<a href='#'>中山大学附属第一医院</a>
								<p class='level'>【二级甲等】</p>
								<p class='room-name'>科室：儿科</p>
								<p class='address'>地址：番禺区小谷围岛1号</p>
							</li>
							<li class='room-show-option'>
								<img src='../source/images/133.jpg' title='第一军医院'/>
								<a href='#'>人民中心医院</a>
								<p class='level'>【三级综合医院】</p>
								<p class='room-name'>科室：内分泌科</p>
								<p class='address'>地址：丰台区丰台南路99号</p>
							</li>
							<li class='room-show-option'>
								<img src='../source/images/212.jpg' title='人民中心医院'/>
								<a href='#'>人民中心医院</a>
								<p class='level'>【三级合格】</p>
								<p class='room-name'>科室：妇科</p>
								<p class='address'>地址：番禺区桥南街7854号</p>
							</li>
							<li class='room-show-option'>
								<img src='../source/images/213.jpg' title='八一医院'/>
								<a href='#'>协和医院</a>
								<p class='level'>【三级甲等】</p>
								<p class='room-name'>科室：NAMZ-内分泌科</p>
								<p class='address'>地址：北京区珠江新城黄华路45号</p>
							</li>
							<li class='room-show-option'>
								<img src='../source/images/214.jpg' title='妇幼医院'/>
								<a href='#'>妇幼医院</a>
								<p class='level'>【一级专科】</p>
								<p class='room-name'>科室：眼科</p>
								<p class='address'>地址：天河区外滩九里街生产路1号</p>
							</li>
						</ul>
						<div class='load-more'><a href='#'>加载更多</a></div>
					</div>
				</div>
				<div id='hot-hospital'>
					ss
				</div>
			</div>
			<div class='return-top'>
				<a href='#' id='a-return-top'></a>
			</div>
		</div>
		<jsp:include page='footer.jsp'></jsp:include>
	</body>
</html>