$(function(){
	/*用户选择医院/科室/疾病选项*/
	var searchType,
		searchText;
		
	/*将window.name传递到search页面，解析查询字符串*/
	/*第一次跳转到search页面时，模拟用户点击*/
	if(window.name){
		$('#head-submit').one('click', function(event, a){
			var r = getQueryStringArgs(window.name);
			/*attr('selected', true);写成attr('select', 'selected');是错误的*/
			$('select option[data-type=' + r.type + ']').attr('selected', 'selected');
			$('#head-search input').val(r.key);
			searchType = parseInt(r.type);
			searchText = r.key;
			submitData('post', '../order/searchByType', window.name, searchCallBack);
			window.name = '';
		}).triggerHandler('click', window.name);
	}
	

	EventUtil.addHandler(document, 'click', docClickFun);

	function docClickFun(event){
		var event = EventUtil.getEvent(event),
			target = EventUtil.getTarget(event);
		switch(target.id){
			case 'head-submit': {
				var searchDataString = searchString();
				if(searchDataString){
					submitData('post', '../order/searchByType', searchDataString, searchCallBack);
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
			listOptions = $listOptions.val(),
			searchString = '';
			searchType = $listOptions.children('option:selected').data('type');
		if(searchText){
			searchString = 'type=' + searchType + '&key=' + searchText
							+ '&positionId=' + searchType + '&page=0';
		}
		return searchString;
	}
	/*搜索回掉函数*/
	function searchCallBack(result){
		var divEle = document.createElement('div'),
			ulEle = document.createElement('ul'),
			code = result.code,
			data = result.data.datas,
			number = result.data.number,
			searchText = $('#head-search').find('input').val(),
			isSearchPage = location.href + '',
			newImg = new Image(); //缓存图片
			$('.search-result').find('.import-word').html(searchText);
			$(ulEle).addClass('result-list');
		switch(code){
			/*查找成功*/
			case 1: {
				if( number<=6 ){
					switch(searchType){
						case 1: {
							for(var i = 0; i < number; i++){
								$(ulEle).html(function(){
									return $(ulEle).html()
										 + '<li><img src='
										 + data[i].image 
										 + ' alt=""/><p class="search-hospital-name">'
										 + data[i].name
										 + '</p><p class="search-hospital-level">'
										 + data[i].hospitalClass
										 + '</p><p class="search-hospital-phone"><span>电话：</span>'
										 + data[i].hospitalPhone
										 + '</p><p class="search-hospital-address"><span>医院地址：</span>'
										 + data[i].hospitalAddress
										 + '</p><a id="search-book" href="forward?pageName=hospital&hospitalId='
										 + data[i].id
										 + '&name='
										 + data[i].name
										 + '&image='
										 + data[i].image
										 + '&adress='
										 + data[i].hospitalAddress
										 + '&phone='
										 + data[i].hospitalPhone
										 + '"></a></li>'
								});
							}
							break;
						}
						case 2: 
						case 3: {
							break;
						}
					}
				}
				

				$(divEle).append($(ulEle));
				$('.search-result').find('.none-result').remove();
				$('.search-result').append($(divEle));
				break;
			}
			/*查找失败*/
			case 2: {
				if(!$('.none-result')[0]){
					$(divEle).addClass('none-result').html(function(){
						return '<p>没有找到与“'
							  +'<span class="import-word" '
							  +'style="color: #FF6752;">'
							  + searchText
							  +'</span>”相关的<span>医院/科室</span>，建议修改关键词试试。</p>'
						});
					}
				$('.search-result').find('.result-list').remove();
				$('.search-result').append($(divEle));
				break;
			}
			
		}
	}

	/*保持页面生成的页面结果刷新不变化*/
	/*function containPage(){
		switch(location.search){
			case '?pageName=search': {
				var key = CookieUtil.get('key'),
					type = CookieUtil.get('type'),
					refreshData = 'key='+ key + '&type=' + type + '&page=0&positionId=0';
				$('select option[value=' + type + ']').attr('selected', 'selected');
				$('#head-search input').val(key);
				$('#head-submit').one('click', function(event, refreshData){
					submitData('post', '../order/searchByType', refreshData, searchCallBack);
				}).triggerHandler('click', refreshData);
			}
		}
	}
	containPage();*/


});