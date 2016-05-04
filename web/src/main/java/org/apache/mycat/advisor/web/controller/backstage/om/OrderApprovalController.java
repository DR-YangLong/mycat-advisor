package org.apache.mycat.advisor.web.controller.backstage.om;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.TabOrder;
import org.apache.mycat.advisor.service.backstage.om.info.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author cjl
 */

/**
 *
 * 订单审批
 */
@RestController
@RequestMapping("/om/approval/")
public class OrderApprovalController extends BaseController {
	
	@Autowired
	private OrderInfoService orderService;
	

	@RequestMapping("save")
	public ResultMap save(TabOrder order){
		if(orderService.saveOrUpdate(order)){
			return success();
		}else{
			return failure("保存订单失败");
		}
	}

	/**
	 * 个人审批
	 * @param param
	 * @return
	 */
	@RequestMapping("list/myApproved")
    public ResultMap list(@RequestParam Map<String, Object> param) {
		Page page = orderService.pageMyApproved(param);
        return sucess(page);
    }

	/**
	 * 未审批列表
	 * @param param
	 * @return
	 */
	@RequestMapping("list/unapproved")
	public ResultMap unapproved(@RequestParam Map<String, Object> param) {
		Page page = orderService.pageUnapproved(param);
		return success(page);
	}
	
	@RequestMapping("get/{id}")
    public ResultMap info(@PathVariable long id) {
		TabOrder order = orderService.get(id);
        return success(order);
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id) {
        if (orderService.delete(id)) {
            return success();
        } else {
            return failure("删除操作失败！");
        }
    }
}
