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
	
	//设置技术要求条件
	self.test1= function() {
	var data = {
  "flag": true,
  "code": 0,
  "data": {
    "id": 33,
    "orderNumber": "07D9F9BC18184A95BE3FCE1C3CAB0591",
    "productId": 1,
    "type": 5,
    "status": 0,
    "paynumber": null,
    "paytype": null,
    "orderStep": 1,
    "earnings": null,
    "orderPeople": null,
    "processPeople": null,
    "createTime": 1461676995088,
    "updateTime": 1461676995088
  }
};
		pageTo(data,"booking-done.html");
	};
self.test2 = function() {
	var data = {
  "flag": false,
  "code": 0,
  "data": {
    "id": 33,
    "orderNumber": "07D9F9BC18184A95BE3FCE1C3CAB0591",
    "productId": 1,
    "type": 5,
    "status": 0,
    "paynumber": null,
    "paytype": null,
    "orderStep": 1,
    "earnings": null,
    "orderPeople": null,
    "processPeople": null,
    "createTime": 1461676995088,
    "updateTime": 1461676995088
  }
};
		pageTo(data,"booking-done.html");
	};
self.test3 = function() {
	initDb("test");
	var tmp= db("test");
	//update(tmp,'insert into t_order(id , code, status, type,create_time,update_time) values("1","xxxxx",0,5,110,110)');
	query(tmp, 'select * from t_order order by id desc', function(res){
		//alert(res.rows.length);
        for (i = 0; i < res.rows.length; i++) {  
            alert(res.rows.item(i).code);  
        }  
  
        //showList($ul);  
    });  

}
	
	//初始化页面辅助模块
	pageHepler.init({
		handler: self,
		mvvm: true
	});

});