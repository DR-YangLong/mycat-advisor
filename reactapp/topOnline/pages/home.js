define(function(require, exports, module) {
	var pageHepler = require('../common/page-helper');
	var self = exports;
	mui.init({  
                preloadPages: [{//预加载目标页面  
                    'url': 'adviser/company_service_order.html',  
                    'id': 'adviser/company_service_order.html'  
                    	   
                },{
			id:'booking-done.html',
			url:'adviser/booking-done.html'
		}]  
    });  
    
 

	self.test = function(event, x) {
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
	}


	pageHepler.init({
		handler: self
	});
});