$(function(){
	/*防止重复提交*/
	var searchCallBackData = null;    /*检测返回的搜索数据是否为空*/
		
	/*click事件委托*/
	EventUtil.addHandler(document, 'click', docClickFun);
	/*登录，注册keydown事件委托*/
	//EventUtil.addHandler(document, 'keydown', docKeydownFun);
	
	function docClickFun(event){
		var event = EventUtil.getEvent(event),
			target = EventUtil.getTarget(event);
		switch(target.id){
			case 'head-submit': {
				var searchDataString = searchString();
				if(searchDataString){
					/*由于某些原因，location使用会使后面的代码无法执行，alert除外*/
					window.name=searchDataString;
					/*submitData('post', '../order/searchByType', searchDataString, searchCallBack);*/
					location.href='forward?pageName=search';
				}
				break;
			}
		}
	}

	/*获取搜索的数据*/
	function searchString(){
		var $headForm = $('#head-search'),
			$searchText = $headForm
							.children('.search-text'),
			$listOptions = $headForm
							.children('.search-list')
								.children('#list-options'),
			searchText = $searchText.val(),
			searchValue = $listOptions.children('option:selected').val(),
			searchType = $listOptions.children('option:selected').data('type'),
			searchString = '';
		if(searchText){
			searchString = 'type=' + searchType + '&key=' + searchText
							+ '&positionId=' + searchValue + '&page=0';
		}
		return searchString;
	}
	

	
	/*图片轮播*/
	(function(){
		var count ,t = 0,n = 0;
		count = $('.banner-list a').length;
		$('.banner-list a:not(:first-child)').hide();
		$('.banner-info').html($('.banner-list a:first-child').find('img').attr('alt'));
		$('.banner-info').click(function(){
			window.open($('.banner-list a:first-child').attr('href'),'_blank');
		});
		$('#banner li').click(function(){
			var i = $(this).text() - 1;
			n = i;
			if(n > count){
				return;
			}
			$('.banner-info').html($('.banner-list a').eq(i).find('img').attr('alt'));
			$('.banner-info').unbind().click(function(){
				window.open($('.banner-list a').eq(i).attr('href'),'_blank');
			});
			$('.banner-list a').filter(':visible').fadeOut(500).parent().children().eq(i).fadeIn(1000);
			document.getElementById('banner').style.background = '';
			$(this).toggleClass('on');
			$(this).siblings().removeAttr('class');
		});
		t = setInterval(showAuto, 4000);
		$('#banner').hover(function(){
			clearInterval(t);
		},function(){
			t = setInterval(showAuto, 4000);
		});
		function showAuto(){
			n = n>=(count - 1) ? 0 : ++n;
			$('#banner li').eq(n).trigger('click');
		}
	})();
	
	/*登录页面，弹出弹出框*/
	/*(function(){
		var $login = $('.login'), $submitBtn = $('submit-btn');
		$login.click(function(){
			$('#login-dialog').dialog({
				autoOpen: true,
				draggable: false,
				modal: true,
				width: 500,
				height: 300,
				position: {
					my: 'center top+200',
					at: 'center top',
					of: window
				}
			});
			$('#login-dialog').dialog( "open" );
		});
		
		$submitBtn.click(function(){
			$.ajax({
				type: 'POST',
				url: '/login.jsp',
				data: {
					username: $('#username').val(),
					password: $('#password').val()
				},
				success: function(response,status,xhr){

				},
				error:function(){
					window.alert('网络延迟，请稍后重试');
				}
			});
		});
	})();
	/*医院，科室的选择*//*
	var roomVisited = false;
	(function(){
		$('.hospital-room-btn').click(function(){
			$(this).addClass('btn-selected')
			.siblings('span').removeClass('btn-selected');
			$.ajax({
				type: 'GET',
				url: '/getRoomList.jsp',
				dataType: 'json',
				data: {
					isDepartment: true
				},
				success: function(response,status,xhr){
					
				},
				error: function(){
					window.alert('网络延迟，请稍后重试');
				}
			});
		});
	})();*/

});
	
	

