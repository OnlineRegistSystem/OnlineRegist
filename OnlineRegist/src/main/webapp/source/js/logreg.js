$(function(){
	var flag = 1, 
		dataString,
		logDialogObj = {
				autoOpen: true,
				draggable: false,
				modal: true,
				width: 500,
				height: 300, 
				/*dialog的默认值是100*/
				zIndex: 999,
				position: {
					my: 'center top+100',
					at: 'center top',
					of: window
				},
				close: function(){
					resetDialog($(this));
				},
				open: function(){
					$(this).dialog( "open" );
				}
			},
			regDialogObj = {
				autoOpen: true,
				draggable: false,
				modal: true,
				width: 500,
				height: 550,
				zIndex: 999,
				position: {
					my: 'center top+50',
					at: 'center top',
					of: window
				},
				close: function(){
					resetDialog($(this));
				},
				open: function(){
					$(this).dialog( "open" );
				}
			};

	/*click事件委托*/
	EventUtil.addHandler(document, 'click', docClickFun);
	/*登录，注册keydown事件委托*/
	EventUtil.addHandler(document, 'keydown', docKeydownFun);

	function docClickFun(event){
		var event = EventUtil.getEvent(event),
			target = EventUtil.getTarget(event),
			$parentNode = $(target).parents('#login-form'),
			$regParNode = $(target).parents('#reg-form'),
			$selectHospitalRoom = $('#select-hospital-room'),
			$hosBtn = $selectHospitalRoom.find('#hos-btn'),
			$roomBtn = $selectHospitalRoom.find('#room-btn');
		switch(target.id){
			case 'exited': {
				$('#reg-dialog').dialog('close');
				$('#login-dialog').dialog(logDialogObj);
				break;
			}
			case 'login': {
				$('#login-dialog').dialog(logDialogObj);
				break;
			}
			case 'reg': {
				$('#reg-dialog').dialog(regDialogObj);
				break;
			}
			case 'submit-btn': {
				dataString = checkLoginData($parentNode);
				if(dataString){
					target.firstChild.nodeValue = '登录中…';
					submitData('post', '../user/login', dataString, loginCallBack);
				}
				break;
			}
			case 'reg-btn': {
				dataString = checkRegisterData($regParNode);
				alert(dataString);
				if(dataString){
					
				}
			}
			case 'logoff': {
				getOff();
				break;
			}
			case 'return-reg-btn': {
				$('#login-dialog').dialog('close');
				$('#reg-dialog').dialog(regDialogObj);
				break;
			}
			case 'hos-btn': {
				$roomBtn.removeClass('btn-selected');
				$hosBtn.addClass('btn-selected');
				$selectHospitalRoom.find('.place').show()
										  .next('#hosptital-lists').show()
				.parent('#select-hospital-room')
										  .find('.rooms').hide()
										  .next('#room-lists').hide();
				break;
			}
			case 'room-btn': {
				$hosBtn.removeClass('btn-selected');
				$roomBtn.addClass('btn-selected');
				$selectHospitalRoom.find('.place').hide()
										  .next('#hosptital-lists').hide()
				.parent('#select-hospital-room')
										  .find('.rooms').show()
										  .next('#room-lists').show();
				break;
			}

		}
	}

	function docKeydownFun(event){
		var event = EventUtil.getEvent(event),
			target = EventUtil.getTarget(event);
		switch(target.id){
			case 'username': {
				removeTip(target.id);
				break;
			}
			case 'password': {
				removeTip(target.id);
				break;
			}
		}
	}

	/*点击关闭或者登录按钮，清除dialog所有的数据*/
	function resetDialog(dialog){
		dialog.find('form')[0].reset();
		dialog.find('ul').html('');
		dialog.find('input').css('border', '1px solid #999');
	}
	/*输入数据为空时，重新输入数据清除提示*/
	function removeTip(node){
		var inputNode = '#' + node,
			liNode = '.' + node,
			$inputNode = $(inputNode),
			$li = $inputNode
			.parents('#login-form')
			.prev('ul')
				.children('.error'),
			$liNode = $inputNode
			.parents('#login-form')
			.prev('ul')
				.children(liNode);
		if($inputNode.val() != ''){
			$inputNode.css('border', '1px solid #999');
			$liNode.css('display', 'none');
			$li.css('display', 'none');
		}
	}

	/*验证登录的数据*/
	function checkLoginData(node){
		var $userElement = node.find('input'),
			$ulElement = node.prev('ul'),
			result = true,
			dataForm = [],
			userData = [],
			inputName = '';
		for(var i = 0; i < $userElement.length; i++){
			userData = $userElement[i].name;
			switch(userData){
				case 'username': {
					if($userElement[i].value.trim() == ''){
						$ulElement.html('<li class=' + userData + '>用户名不能为空</li>');
						addFocus($userElement[i]);
						return false;
					}else{
						inputName = 'username';
					}
					break;
				}
				case 'password': {
					if($userElement[i].value.trim() == ''){
						//$ulElement.html($ulElement.html() + '<li class=' + userData + '>密码不能为空</li>');
						/*判断class为password的li是否存在*/
						$ulElement.html('<li class=' + userData + '>密码不能为空</li>');
						addFocus($userElement[i]);
						return false;
					}else{
						inputName = 'password';	
					}
					break;
				}
				
			}
			dataForm[i] = inputName + '=' + $userElement[i].value; 	
		}
		result = dataForm.join('&');
		return result;
	}
	/*验证注册时的数据是否有效*/
	function checkRegisterData(node){
		var $regElement = node.find('input'),
			$errorElement = node.prev('.reg-error'),
			result = true,
			dataForm = [],
			userData = [];
			
		for(var i = 0; i < $regElement.length; i++){
			userData = $regElement[i].name;
			var regExp = null,
			passVal,
			inputName,
			inputVal = $regElement[i].value;
			switch(userData){
				case 'username': {
					regExp = /[a-zA-Z0-9]{3,12}/;
					if(!regExp.test(inputVal)){
						$errorElement.html('请输入正确的用户名');
						addFocus($regElement[i]);
						return false;
					}else{
						inputName = 'username';
					}
					break;
				}
				case 'password': {
					regExp = /[a-zA-Z0-9]{6,12}/;
					passVal = inputVal;
					if(!regExp.test(inputVal)){
						$errorElement.html('密码不能含有非法字符，长度在6-12之间');
						addFocus($regElement[i]);
						return false;
					}else{
						inputName = 'password';	
					}
					break;
				}
				case 're-pass': {
					if(inputVal != passVal){
						$errorElement.html('两次密码输入不一致');
						addFocus($regElement[i]);
						return false;
					}
					break;
				}
				case 'email': {
					regExp = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}/;
					if(!regExp.test(inputVal)){
						$errorElement.html('邮箱格式不正确，请重新输入');
						addFocus($regElement[i]);
						return false;
					}else{
						inputName = 'email';
					}
					break;
				}
				case 'phone': {
					regExp = /^1\d{10}$/;
					if(!regExp.test(inputVal)){
						$errorElement.html('手机号码不正确，请重新输入');
						addFocus($regElement[i]);
						return false;
					}else{
						inputName = 'phone';
					}
					break;
				}
				case 'sex': {
					inputName = 'sex';
					break;
				}
				case 'IDcard': {
					regExp = /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
					if(!regExp.test(inputVal)){
						$errorElement.html('身份证号码不正确，请重新输入');
						addFocus($regElement[i]);
						return false;
					}else{
						inputName = 'IDcard';
					}
					break
				}
			}
			if($regElement[i].getAttribute('name') != 'sex' || $($regElement[i]).attr('checked') == 'checked'){
				dataForm[i] = inputName + '=' + $regElement[i].value; 	
			}
			
		}
		result = dataForm.join('&');
		return result;

	}
	/*鼠标焦点的归属*/
	function addFocus(node){
		$firstNode = $(node).parent().parent().find('input').eq(0);
		if(node.id == 'password' && $firstNode.val() == ''){
			$firstNode.focus();
			return;
		}else if(node.id == 'IDcard' && $firstNode.val() == ''){
			$firstNode.focus();
			return;
		}
		node.style.border = '1px solid red';
		$(node).focus();
	}

	

	/*ajax返回数据处理函数*/
	function loginCallBack(result){
		var code = result.code;
		$('#login-form')
			.find('#submit-btn')[0].firstChild.nodeValue = '登录';
		switch(code){
			case 0: {
				$('#login-form').prev('ul').html('<li class='+ 'error' + '>用户名或者密码错误，请重新输入</li>');
				break;
			}
			case 1: {
				/*close函数已经在dialog定义*/
				$('#login-dialog').dialog( "close" );
				CookieUtil.set('username', getStringValue(dataString, 'username'), 7, '/', null, null);
				getOn();
				break;
			}
			case 500: {
				$('#submit-btn')[0].firstChild.nodeValue = '登录';
				break;
			}
		}
	}
	/*获取字符串的值*/
	function getStringValue(string, name){
		var name = name + '=',
			nameStart = string.indexOf(name),
			nameLength = name.length,
			nameEnd = null,
			nameValue = null;
		nameEnd = string.indexOf('&', nameStart);
		nameValue = string.substring(nameStart + nameLength, nameEnd);
		return nameValue;
	}
	/*登陆后页面变化*/
	function getOn(){
		var $logReg = $('#log-reg'),
			$logRegNode = $logReg.children('.log-reg');
		$logReg.children('.info').html('您好');
		$logRegNode
				.children('li')
				.eq(0).html('<a href="javascript:void(0);" id="person-info">' + CookieUtil.get('username') + '</a>');
		$logRegNode
				.children('li')
				.eq(1).html('<a href="javascript:void(0);" id="logoff">' + '退出' + '</a>');
		$logRegNode
				.children('#login-dialog').hide();
	}

	/*点击“退出”按钮，删除cookie*/
	function getOff(){
		CookieUtil.unset('username', '/', null, null);
		var $logReg = $('#log-reg'),
			$logRegNode = $logReg.children('.log-reg');
		$logReg.children('.info').html('您好，请');
		$logRegNode
				.children('li')
				.eq(0).html('<a href="javascript:void(0);" id="login">' + '登录'+ '</a>');
		$logRegNode
				.children('li')
				.eq(1).html('<a href="javascript:void(0);" id="reg">' + '注册' + '</a>');
	}

	/*下次刷新或者在cookie在有效期内，保存用户登录的状态*/
	function checkUserCookie(name){
		var username = CookieUtil.get(name);
		if(username != null && username != ''){
			getOn();
		}
	}
	checkUserCookie('username');
});