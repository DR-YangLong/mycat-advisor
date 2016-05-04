package org.apache.mycat.advisor.service.backstage.om.info.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.dao.TabOrderMapper;
import org.apache.mycat.advisor.persistence.model.TabOrder;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.backstage.om.info.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderInfoServiceImpl extends BaseServiceImpl<TabOrder> implements
		OrderInfoService {

	@Autowired
	private TabOrderMapper orderMapper;
	
	@Override
	protected MyMapper<TabOrder> myMapper() {
		return orderMapper;
	}
	
	@Override
	public Page<TabOrder> page(Map<String, Object> param) {
		 int pageIndex = 0;
	        int pageCount = 8;
	        Object tmpIndex = param.get("pageIndex");
	        Object tmpCount = param.get("pageCount");
	        if (tmpIndex != null && StringUtils.isNotEmpty(tmpIndex.toString())) {
	            pageIndex = Integer.parseInt(tmpIndex.toString());
	        }
	        if (tmpCount != null && StringUtils.isNotEmpty(tmpCount.toString())) {
	            pageCount = Integer.parseInt(tmpCount.toString());
	        }
	        Object tmpstr = param.get("type");
	        Long type =null;
	        if (tmpstr != null && StringUtils.isNotEmpty(tmpstr.toString())) {
	            type =Long.valueOf((String) tmpstr);
	        }
	        TabOrder order = new TabOrder();
	        PageHelper.startPage(pageIndex + 1, pageCount);
	        PageInfo<TabOrder> pageInfo = new PageInfo<TabOrder>(orderMapper.listByType(order));
	        return twoPage(pageInfo);
	}
	
	@Override
	public TabOrder get(long id) {
		return orderMapper.getOrderInfoById(id);
	}


	@Override
	public Page pageUnapproved(Map<String, Object> param) {
		pageBegin(param);
		int status = 0;
		List<Map<String, Object>> list = orderMapper.pageOrderByStatus(status);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
		return twoPage(pageInfo);
	}

	@Override
	public Page pageMyApproved(Map<String, Object> param) {
		return null;
	}
}
