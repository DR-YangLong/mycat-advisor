define(function(require, exports, module) {

	//设置状态栏颜色(for ios)
	mui.init({
		"statusBarBackground": "#099FDE"
	});

	mui.plusReady(function() {
		plus.navigator.setStatusBarStyle("UIStatusBarStyleBlackOpaque");
				
		mui.oldBack = mui.back;
		mui.back = function() {
			
			var orderPage = plus.webview.getWebviewById('adviser/company_service_order.html');
			//alert(orderPage);
			//触发详情页面的newsId事件
			mui.fire(orderPage,'params',{
				id:self.services
			});			
			mui.oldBack();
			return false;
		};
	});

	//添加newId自定义事件监听
	window.addEventListener('params',function(event){
		//获得事件参数
		var data = event.detail.id;
		//根据id向服务器请求新闻详情
		 for(var i=0,l=data.length;i<l;i++){
			self.services[i].selected=1;
		 }
	});
	
	var utils = require('../../libs/utils.js');
	var pageHepler = require('../../common/page-helper');
	
	var skillFilter = require('../../controls/skill-filter/main');


	//mui('.normal').addClass("mui-hidden");
	var self = exports;

	self.services = [{
		id:'01',
		name: '产品设计',
		detail:'产品设计说明。这里是详细说明。很多字哦。没力气写了。就这么点吧。差旅补贴另计。。。',
		price: "现场服务：0.5~3w/天   &nbsp;&nbsp;在线服务：1~3K/天  &nbsp;&nbsp;不包含差旅费",
		selected:0
	}, {
		id:'02',
		name: '软件架构设计',
		detail:'产品设计说明。这里是详细说明。很多字哦。没力气写了。就这么点吧。差旅补贴另计。。。',
		price: "现场服务：0.5~3w/天   &nbsp;&nbsp;在线服务：1~3K/天  &nbsp;&nbsp;不包含差旅费",
		selected:0
	}, {
		id:'03',
		name: '数据库',
		detail:'产品设计说明。这里是详细说明。很多字哦。没力气写了。就这么点吧。差旅补贴另计。。。',
		price: "现场服务：0.5~3w/天   &nbsp;&nbsp;在线服务：1~3K/天  &nbsp;&nbsp;不包含差旅费",
		selected:0
	}, {
		id:'04',
		name: '项目监管',
		detail:'产品设计说明。这里是详细说明。很多字哦。没力气写了。就这么点吧。差旅补贴另计。。。',
		price: "现场服务：0.5~3w/天   &nbsp;&nbsp;在线服务：1~3K/天  &nbsp;&nbsp;不包含差旅费",
		selected:0
	}, {		
		id:'05',
		name: '系统运维',
		detail:'产品设计说明。这里是详细说明。很多字哦。没力气写了。就这么点吧。差旅补贴另计。。。',
		price: "现场服务：0.5~3w/天   &nbsp;&nbsp;在线服务：1~3K/天  &nbsp;&nbsp;不包含差旅费",
		selected:0
	}, {		
		id:'06',
		name: '产品推广',
		detail:'产品设计说明。这里是详细说明。很多字哦。没力气写了。就这么点吧。差旅补贴另计。。。',
		price: "现场服务：0.5~3w/天   &nbsp;&nbsp;在线服务：1~3K/天  &nbsp;&nbsp;不包含差旅费",
		selected:0
	}];
	
	self.pickService = function(index) {
		var tmp = self.services[index];
		tmp.selected = tmp.selected == 0? 1:0;

	};

	//初始化页面辅助模块
	pageHepler.init({
		handler: self,
		mvvm: true
	});



});