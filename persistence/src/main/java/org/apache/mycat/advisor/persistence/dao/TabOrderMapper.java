package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabOrder;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface TabOrderMapper extends MyMapper<TabOrder> {
	
	 public List<TabOrder> listByType(TabOrder tabOrder);

	public TabOrder getOrderInfoById(long id);

	List<Map<String,Object>> pageOrderByStatus(int status);
}