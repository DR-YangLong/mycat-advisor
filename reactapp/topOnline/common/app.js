function pageTo(data,htmlId){
	var page = plus.webview.getWebviewById(htmlId);
	mui.fire(page,'params',{
		id:data
	});
	//打开详情页面
	mui.openWindow({id: htmlId});
}



// web sql
function db(name) {
	var db_name = 'db_top_'+name;
	var db_size = 2;
	
	return openDatabase(db_name, '1.0', 'db_top_online', db_size * 1024 * 1024);
};


// 初始化数据库
function initDb(name){
	var tmp = db(name);
	update(tmp, 'create table if not exists t_order (id unique, code, status, type,create_time,update_time)');
	//update(db, 'create table if not exists t_plan_day_done (id unique, plan_title, plan_content)');
}


function update(db, sql){
	if(db &&sql) db.transaction(function(tx){tx.executeSql(sql);});

}

function query(db, sql, func){
	if(db && sql){
		db.transaction(function(tx){
			tx.executeSql(sql, [], function(tx, results) {
				func(results);
			}, null);
		});
	}
}
