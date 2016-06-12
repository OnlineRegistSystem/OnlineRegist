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
