package org.apache.mycat.advisor.web.controller.app.pay;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.TabOrder;
import org.apache.mycat.advisor.service.app.order.ApiOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by cjl on 2016/4/20.
 */
@RestController
@RequestMapping("/app/pay")
public class ApiPayController extends BaseController{


	ApiOrderService apiOrderService;


	@RequestMapping("index")
	public ResultMap index() {
		return success();
	}

	/**
	 * 下单
	 * @param order
	 * @param param
	 * @return
	 */
	@RequestMapping("subscribe")
	public ResultMap subscribe(TabOrder order, @RequestParam Map<String, String> param) {

		/*boolean flag = apiOrderService.newOrder(param,1L);
		if (flag) {
			return success();
		}*/
		return failure();
	}

	/**
	 * 订单确认
	 * @param order
	 * @param param
	 * @return
	 */
	@RequestMapping("affirm")
	public ResultMap affirm(TabOrder order,@RequestParam Map<String, Object> param) {
		return success();
	}
}
