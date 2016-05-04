define(function(require, exports, module) {
	var self = exports;
	var pageHepler = require('../../common/page-helper');
	require('./style.css');
	var $ = require('../../libs/jquery');
	var tp = require('../../libs/tp');

	var uiHtml = require('../../libs/ems-text!./ui.html');
	var ui = $(uiHtml)[0];
	document.body.appendChild(ui);

	ui.addEventListener('touchmove', function(event) {
		event.preventDefault();
	});
	self.computed = {
	test: function() {
			return true;	
}
	};
	var mask = mui.createMask();
	mask[0].addEventListener('tap', function() {
		self.hide();
	}, false);

	self.show = function(callback) {
		mask.show();
		self.callback = callback;
		ui.classList.add('active');
		//处理物理返回键
		self.__back = mui.back;
		mui.back = function() {
			self.hide();
		};
	};

	self.hide = function() {
		ui.classList.remove('active');
		mask.close();
		self.callback = null;
		//处理物理返回键
		mui.back = self.__back;
	};

	self.ok = function() {
		if (self.callback) {
			self.callback(self);
		}
		self.hide();
	};
	

	self.languageRanges = [{
		text: '不限',
		value: "L0"
	}, {
		text: 'Java',
		value: "L1"
	}, {
		text: 'C#',
		value: "L2"
	}, {
		text: 'Go',
		value: "L3"
	}, {
		text: '.Net',
		value: "L4"
	}, {
		text: 'Ruby',
		value: "L5"
	}, {
		text: 'Python',
		value: "L6"
	}];

	self.languageStr = self.languageRanges[0].text+";"
	self.languageRange = self.languageRanges[0].value+";";
	self.language = [];
	self.pickLanguage = function(index) {
		var tmp =self.languageRanges[index].value+";";
		var tmpStr =self.languageRanges[index].text+",";
		if (self.languageRange.indexOf(tmp)!=-1){
			self.languageRange = self.languageRange.replace(tmp, "");
			self.languageStr = self.languageStr.replace(tmpStr, "");
			self.language.push(self.languageRanges[index]);
		}else{
			self.languageRange = self.languageRange+tmp;
			self.languageStr = self.languageStr+tmpStr;
			self.language.splice(self.language.indexOf(self.languageRanges[index]),1);
		}
	};

	self.platforms = [{
		text: '不限',
		value: '0'
	}, {
		text: 'Windows',
		value: '1'
	}, {
		text: 'Linux',
		value: '2'
	}, {
		text: 'Unix',
		value: '3'
	}, {
		text: 'Mac',
		value: '4'
	}];

	self.platform = self.platforms[0];

	self.pickPlatform = function(index) {
		self.platform = self.platforms[index];
	};
	
	
	self.dbs = [{
		text: '不限',
		value: '0'
	}, {
		text: 'Mysql',
		value: '1'
	}, {
		text: 'Oracle',
		value: '2'
	}, {
		text: 'Sql Server',
		value: '3'
	}, {
		text: 'Mango',
		value: '4'
	}];

	self.db = self.dbs[0];

	self.pickDb = function(index) {
		self.db = self.dbs[index];
	};
	
	self.others = [{
		text: '不限',
		value: '0'
	}, {
		text: 'Memcache',
		value: '1'
	}, {
		text: 'Redis',
		value: '2'
	}, {
		text: 'ZooKeeper',
		value: '3'
	}, {
		text: '.......太多了',
		value: '4'
	}];

	self.other = self.others[0];

	self.pickOther = function(index) {
		self.other = self.others[index];
	};
	
	
	

	pageHepler.init({
		handler: self,
		holder: ui,
		mvvm: true
	});
});