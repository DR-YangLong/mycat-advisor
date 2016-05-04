define(function(require, exports, module) {
	//设置状态栏颜色(for ios)
	mui.init({
		"statusBarBackground": "#099FDE",
		preloadPages:[{
			id:'choose_service.html',
			url:'choose_service.html'
		},{
			id:'booking-done.html',
			url:'booking-done.html'
		}]
	});
	mui.plusReady(function() {
		plus.navigator.setStatusBarStyle("UIStatusBarStyleBlackOpaque");
		//添加newId自定义事件监听
		window.addEventListener('params',function(event){
		//获得可用服务页面返回值
		self.serviceStr = null;
		var data = event.detail.id;
		for(var i=0,l=data.length;i<l;i++){
			if (data[i].selected==1){
				//选中数据
				if (self.serviceStr == null)
					self.serviceStr = data[i].name;
				else
			   		self.serviceStr = self.serviceStr+","+data[i].name;			   	
				selectedService.push(data[i].id);
			}
		 }
	});
	});	
	var utils = require('../../libs/utils.js');
	var pageHepler = require('../../common/page-helper');
	
	var skillFilter = require('../../controls/skill-filter/main');

	var servicePage = null;		//可选服务页面
	var selectedService = [];	//已选择的服务列表
	//mui('.normal').addClass("mui-hidden");
	var self = exports;
	self.serviceStr = null;
	self.monthNum = 2;
	self.beginDate = utils.formatDate(new Date(), 'yyyy-MM');

	var calcEndDate = function() {
		var endDate = new Date(self.beginDate);
		endDate.setMonth(endDate.getMonth() + self.monthNum);
		self.endDate = utils.formatDate(endDate, 'yyyy-MM');
	};
	calcEndDate();


	self.activeNormal = function(event, x) {
		$('#normal_tab').addClass("active");
		$('#list_tab').removeClass("active");
		$('#normal').removeClass("mui-hidden");
		$('#list').addClass("mui-hidden");
	}
	
	self.activeSystem = function(event, x) {
		$('#normal_tab').removeClass("active");
		$('#list_tab').addClass("active");
		$('#normal').addClass("mui-hidden");
		$('#list').removeClass("mui-hidden");
	}

	//选择日期
	self.pickeDate = function(event, x) {
		var currentYear = (new Date()).getFullYear();
		self.dtPicker = self.dtPicker || new mui.DtPicker({
			"type": "month",
			"beginYear": currentYear,
			"endYear": currentYear + 1,
			"value": self.beginDate
		});
		self.dtPicker.show(function(rs) {
			self.beginDate = rs.value;
			calcEndDate();
		});
	};
	
	
	self.pickeEndDate = function(event, x) {
		var currentYear = (new Date()).getFullYear();
		self.dtPicker = self.dtPicker || new mui.DtPicker({
			"type": "month",
			"beginYear": currentYear,
			"endYear": currentYear + 1,
			"value": self.endDate
		});
		self.dtPicker.show(function(rs) {
			self.endDate = rs.value;
			//calcEndDate();
			self.monthNum = self.endDate-self.startDate;
		});
	};

	self.languageStr = "不限";
	self.languageRange = skillFilter.languageRange;
	self.platform = skillFilter.platform;
	self.db = skillFilter.db;
	self.other = skillFilter.other;
	self.computed = {
		priceAndStar: function() {
			if (self.star.value == 0 &&
				self.priceRange.value == 0) {
				return "价格/星级";
			} else {
				return self.priceRange.text + "," + self.star.text;
			}
		},
		
		skill: function() {
			if (self.languageRange.value == 0 &&
				self.platform.value == 0) {
				return "技术要求";
			} else {
				return self.languageStr +";" + self.platform.text+";"+self.db.text+";"+self.other.text;
			}
		},
		services: function() {
			if (self.serviceStr == null){
				return "可选服务";
			}else{
				return self.serviceStr;
			}
		},
		paymentStr: function() {
			if (self.payment == undefined) {
				return "付款方式";
			} else {
				return self.payment.text;
			}
		}
	};

	//设置价格过滤条件
	self.setPriceFilter = function() {
		hotelPriceFilter.show(function(rs) {
			self.priceRange = rs.priceRange;
			self.star = rs.star;
		});
	};

	//设置技术要求条件
	self.setSkillFilter = function() {
		skillFilter.show(function(rs) {
			self.languageRange = rs.languageRange;
			//self.language = rs.language;
			self.languageStr = rs.languageStr;
			self.platform = rs.platform;
			self.db = rs.db;
			self.other = rs.other;
		});
	};
	
	//设置可用服务条件
	self.setServiceFilter = function() {
		serviceFilter.show(function(rs) {
			//self.languageRange = rs.languageRange;
			//self.platform = rs.platform;
		});
	};



		
	//设置技术要求条件
	self.setPaymentMethod = function() {
		if (!self.payment) {
			self.payment = new mui.PopPicker();
					self.payment.setData([{
						value: '1',
						text: '每月支付'
					}, {
						value: '2',
						text: '每2月支付'
					}, {
						value: '3',
						text: '一次性支付'
					}, {
						value: '4',
						text: '分三次支付'
					}]);
		}
		self.payment.show(function() {});
		
		

	};
	self.setInvoice = function() {
		if (!self.iPicker) {
			self.iPicker = new mui.PopPicker();
			self.iPicker.setData([{
				text: "不需要"
			}, {
				text: "到店领取"
			}]);
		}
		self.iPicker.show(function() {});
	};

	self.setRequirement = function() {
		if (window.plus) {
			plus.nativeUI.prompt("请填写您的要求", function() {
				//TODO: 
			}, "特殊要求", "", ["确认", "取消"]);
		} else {
			var rs = prompt("请填写您的要求");
			//TODO:
		}
	};

	//设置技术要求条件
	self.sendNormalOrder = function() {
		if (self.beginDate >= self.endDate){
			alert("结束日期必须大于开始日期");
			return;
		}
		if (($('#sceneDay1').val()*1+$('#onlineDay1').val()*1)>30){
			alert("每月天数不能超过30天");
			return;
		}
		if (($('#sceneDay1').val()*1+$('#onlineDay1').val()*1)==0){
			alert("每月至少需要1天");
			return;
		}
		
		var data1 = {};
		data1.type = 0;			//普通订单
		data1.beginDate = self.beginDate;	//开始日期（到月）  例  2016-04
		data1.endDate = self.endDate;		//结束日期				
		data1.sceneDay = $('#sceneDay1').val()*1;	//每月现场到期天数
		data1.onlineDay = $('#onlineDay1').val()*1;  //每月在线到期天数
		data1.advisor1 = 1;		//顾问1 ID
		data1.advisor2 = 2;		//顾问2 ID
		data1.advisor3 = 3;		//顾问3 ID
		data1.memo = $('#memo1').val();		//特殊要求
		mui.ajax('http://120.27.122.84:8080/app/order/enterprise/advisor/subscribe',			
			{data:data1,
			dataType:'json',
			type:'post',
			timeout:5000,
			beforeSend: function() {
				plus.nativeUI.showWaiting("正在提交订单");					
			},
			complete: function() {
				//关闭Waiting
				plus.nativeUI.closeWaiting();	
			},
			success:function(result){
				//服务器返回响应，根据响应结果，分析是否登录成功；   
				//alert(JSON.stringify(result));				
				//var tmp = JSON.parse(result);				
				pageTo(result,'booking-done.html');
			},
			error:function(xhr,type,errorThrown){
				//异常处理；
				alert("系统出错，请稍后再试。"+xhr.status+":"+xhr.readyState+":"+type);
			}
		});
	};

	self.selectService = function() {
		pageTo(selectedService,'choose_service.html');

	};
	//设置技术要求条件
	self.sendSystemOrder = function() {
		if (self.beginDate >= self.endDate){
			alert("结束日期必须大于开始日期");
			return;
		}
		if (($('#sceneDay2').val()*1+$('#onlineDay2').val()*1)>30){
			alert("每月天数不能超过30天");
			return;
		}
		if (($('#sceneDay2').val()*1+$('#onlineDay2').val()*1)==0){
			alert("每月至少需要1天");
			return;
		}
		if (selectedService.length == 0){
			alert("请至少选择一项服务。");
			return;
		}
		
		var data1 = {};
		data1.type = 1;			//打包订单
		data1.beginDate = self.beginDate;	//开始日期（到月）  例  2016-04
		data1.endDate = self.endDate;		//结束日期				
		data1.sceneDay = $('#sceneDay2').val()*1;	//每月现场到期天数
		data1.onlineDay = $('#onlineDay2').val()*1;  //每月在线到期天数
		var tmp = self.languageRange.split(";");
		if (tmp.length>1)
			tmp.pop();
		data1.skill = {};			
		data1.skill.language = tmp;
		data1.skill.platform = [self.platform.value];
		data1.skill.db = [self.db.value];
		data1.skill.other = [self.other.value];
		data1.services = selectedService;
		data1.memo = $('#memo2').val();		//特殊要求	
		
		//alert(JSON.stringify(data1));
		mui.ajax('http://120.27.122.84:8080/app/order/enterprise/advisor/subscribe',					
			{data:data1,
			dataType:'json',
			type:'post',
			timeout:5000,
			beforeSend: function() {
				plus.nativeUI.showWaiting("正在提交订单");
			},
			complete: function() {
				plus.nativeUI.closeWaiting();
			},
			success:function(result){
			//服务器返回响应，根据响应结果，分析是否登录成功；   
				//alert(JSON.stringify(result));
				pageTo(result,'booking-done.html');
			},
			error:function(xhr,type,errorThrown){
				//异常处理；
				alert("系统出错，请稍后再试。"+xhr.status+":"+xhr.readyState+":"+type);
			}
		});
	};
	//初始化页面辅助模块
	pageHepler.init({
		handler: self,
		mvvm: true
	});

});