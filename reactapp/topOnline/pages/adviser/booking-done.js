define(function(require, exports, module) {
	
	var self = exports;
	self.data = {};
	//添加自定义事件监听
	window.addEventListener('params',function(event){
		//获得事件参数
		self.data = event.detail.id;
		//alert(JSON.stringify(self.data.flag));
	});
	
	var utils = require('../../libs/utils.js');
	var pageHepler = require('../../common/page-helper');
	self.computed = {
		title: function() {	
			if (self.data.flag == true)
				return "订单申请成功";
			else
				return "订单申请失败";
		},
		
		img: function(){
			if (self.data.flag == true)
				return "fa-check-circle-o";
			else
				return "fa-exclamation-circle";			
		},
		
		status: function() {	
			if (self.data.flag == false)
				return "系统后台错误";
			else{
				var tmp = self.data.data.status;
				if (tmp == 0)
					return "进入系统后台审批";
				else
					return "TODO";
			}
		},
		
		product: function() {	
			if (self.data.data.productId == 1)
				return "企业顾问订单";
			else{
				return "TODO";
			}
		},
		
		orderNo: function() {
			return self.data.data.orderNumber;
			
		}
	};
		//初始化页面辅助模块
	pageHepler.init({
		handler: self,
		mvvm: true
	});
});