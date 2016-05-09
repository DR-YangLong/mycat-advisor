package org.apache.mycat.advisor.web.controller.backstage.product;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.ProductInfo;
import org.apache.mycat.advisor.persistence.model.ProductType;
import org.apache.mycat.advisor.service.backstage.product.productinfo.ProductInfoService;
import org.apache.mycat.advisor.service.backstage.product.producttype.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cloudsher on 2016/4/28.
 */
@RestController
@RequestMapping("/product/info")
public class ProductInfoController extends BaseController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductTypeService productTypeService;


    @RequestMapping("list")
    public ResultMap list(@RequestParam Map<String, Object> param){
        Page<Map> mapPage = productInfoService.pageList(param);
        return success(mapPage);
    }


    @RequestMapping("save")
    public ResultMap save(ProductInfo productInfo){
        if(productInfoService.saveOrUpdate(productInfo)){
            return success();
        }else {
            return failure("保存产品信息失败");
        }
    }

    @RequestMapping("init")
    public ResultMap init(){
        return success(productTypeService.findAll());
    }


    @RequestMapping("get/{id}")
    public ResultMap get(@PathVariable long id){
        Map<String,Object> param = new HashMap<>(1);
        param.put("id",id);
        List<Map<String, Object>> result = productInfoService.getResult(param);
        List<ProductType> all = productTypeService.findAll();
        param.put("types",all);
        Map<String,Object> mp = result.get(0);
        mp.putAll(param);
        return success(mp);
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id){
        return productInfoService.delete(id)?success():failure("删除失败");
    }
}
