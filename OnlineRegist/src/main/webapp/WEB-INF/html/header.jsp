<%@ page language = "java" pageEncoding = "utf-8" %>

<div id='header'>
	<div class='container'>
		<div class='platform'>
			<img id='platform-logo' src='../source/images/platform-logo.jpg'/>
			<h2>统一预约挂号系统</h2>
			<span class='text-logo'>智慧医疗，健康中国</span>
		</div>
		<div id='log-reg'>
			<span class='info'>您好，请</span>
			<ul class='log-reg'>
				<li><a href='javascript:void(0);' title='点击登录' id='login'>登录</a></li>
				<!--用户登录界面-->
				<div id="login-dialog" title="用户登录">
					<ul>
					</ul>
					<form id='login-form'>
						<div class='username-option'>
							<label for='username'>用户账号：</label>
							<input type='text' id='username' name='username' placeholder='请输入用户名' autocomplete='off'/>
							<em class='dot'>*</em>
						</div>
						<div class='password-option'>
							<label for='password'>用户密码：</label>
							<input type='password' id='password' name='password' placeholder='请输入密码'/>
							<em class='dot'>*</em>
						</div>
						<div class='btn-option'>
							<button type='button' id='submit-btn'>登录</button>
							<button id='return-reg-btn'>注册新用户</button>
						</div>
					</form>
					<a href='#'>忘记密码？</a>
				</div>
				<li><a href='javascript:void(0);' title='点击注册' id='reg'>注册</a></li>
				<!--注册界面-->
				<div id="reg-dialog" title="用户注册">
					<div class='reg-error'></div>
					<form id='reg-form'>
						<div class='reg-option'>
							<label for='reg-username'>用户名：</label>
							<input type='text' id='reg-username' name='username' placeholder='用户名字母或数字组成，长度在3-12位' autocomplete='off'/>
							<em class='dot'>*</em>
						</div>
						<div class='reg-option'>
							<label for='reg-password'>设置密码：</label>
							<input type='password' id='reg-password' name='password' placeholder='密码不能含有非法字符，长度在6-12之间'/>
							<em class='dot'>*</em>
						</div>
						<div class='reg-option'>
							<label for='re-pass'>确认密码：</label>
							<input type='password' id='re-pass' name= 're-pass' placeholder='请再输入密码确认'/>
							<em class='dot'>*</em>
						</div>
						<div class='reg-option'>
							<label for='email'>邮箱：</label>
							<input type='text' id='email' name='email' placeholder='请再输入邮箱'/>
							<em class='dot'>*</em>
						</div>
						<div class='reg-option'>
							<label for='phone'>手机号码：</label>
							<input type='phone' id='phone' name='phone' placeholder='请输入手机号码'/>
							<em class='dot'>*</em>
						</div>
						<div class='reg-option'>
							<label>性别：</label>
							<input type='radio' style='height:14px;width:20px;' name='sex' value="male" checked />男
							<input type='radio' name='sex' style='height:14px;width:20px;' value="female" />女
							<em class='dot'>*</em>
						</div>
						<div class='reg-option'>
							<label for='IDcard'>证件号：</label>
							<input type='text' id='IDcard' name='IDcard' placeholder="请输入你的身份证号">
							<em class='dot'>*</em>
						</div>
						<div>
							<button type='button' id='reg-btn'>注册</button>
						</div>
					</form>
					<a href='#' id='exited'>已有账号?</a>
				</div>
			</ul>
			<span class='complaint'>投诉电话：020-12320</span>
		</div>
		<div id='search'>
			<form id='head-search'>
				<div class='search-list'>
					<select id='list-options'>
						<option value='医院' data-type='1'>医院</option>
						<option value='科室' data-type='2'>科室</option>
						<option value='疾病' data-type='3'>疾病</option>
					</select>
				</div>
				<input type='text' class='search-text' placeholder="请输入科室/疾病/医院"  size='34'>
				<a href='javascript:void(0);' id='head-submit'>
				</a>
			</form>
		</div>
	</div>
	<div id='head-nav'>
		<ul class='nav'>
			<li><a href='#' class='selected'>首页</a></li>
			<li class='toggle-show'>
				<a href='#'>挂号服务</a>
				<ul class='toggle'>
					<li><a href='#'>按科室预约</a></li>
					<li><a href='#'>按疾病预约</a></li>
					<li><a href='#'>按医院预约</a></li>
				</ul>
			</li>
			<li class='toggle-show'>
				<a href='#'>预约指南</a>
				<ul class='toggle'>
					<li><a href='#'>预约流程详解</a></li>
					<li><a href='#'>预约挂号指南</a></li>
					<li><a href='#'>常见疾病对应科室</a></li>
					<li><a href='#'>常见问题</a></li>
				</ul>
			</li>
			<li><a href='#'>健康问答</a></li>
			<li><a href='#'>最新公告</a></li>
			<li><a href='#'>客户端下载</a></li>
		</ul>
		<div class='nav-bottom'></div>
	</div>
	<div class='search-box'>
		<div id='bottom-search'>
			<form id='bottom-middle-search'>
				<div class='hospital-part'>
					<label for='hospital'>医院:</label>
					<select id='hospital' name='hospital'>
						<option>请选择医院</option>
					</select>
				</div>
				<div class='room-part'>
					<label for='room'>科室:</label>
					<input type='text' id='room' name='room' placeholder='请输入科室名称'>
					<div class='room-lists'>
						<ul class='room-list-options middle-toggle'>
							<li><a href='#'>中医儿科</a></li>
							<li><a href='#'>中医妇科</a></li>
							<li><a href='#'>中医免疫专科</a></li>
							<li><a href='#'>中医眼科</a></li>
							<li><a href='#'>中医门诊</a></li>
						</ul>
					</div> 
				</div>
				<div class='name-part'>
					<label for='name'>医生姓名:</label>
					<input type='text' id='name' name='name' placeholder='请输入名字'>
					<div class='name-lists'>
						<ul class='name-list-options middle-toggle'>
							<li><a href='#'>丁华</a></li>
							<li><a href='#'>张阿山</a></li>
							<li><a href='#'>李思彤</a></li>
							<li><a href='#'>增顺</a></li>
							<li><a href='#'>王鹏</a></li>
						</ul>
					</div> 
				</div>
				<div class='time-part'>
					<label for='time'>出诊时间:</label>
					<select id='time' name='time'>
						<option>请选择就诊时间</option>
					</select>
				</div>
				<button type='submit' id='middle-submit'>搜索</button>
			</form>
		</div>
	</div>
	<div class='head-bottom-black'>统一预约挂号系统</div>
</div>
