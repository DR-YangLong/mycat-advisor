package org.apache.mycat.advisor.web.controller.backstage.product;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.ProductInfo;
import org.apache.mycat.advisor.persistence.model.ProductStepTpl;
import org.apache.mycat.advisor.service.backstage.product.productinfo.ProductInfoService;
import org.apache.mycat.advisor.service.backstage.product.productsteptpl.ProductStepTplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by cloudsher on 2016/4/28.
 */
@RestController
@RequestMapping("/product/steptpl/")
public class ProductStepTplController extends BaseController {


    @Autowired
    private ProductStepTplService productStepTplService;

    @Autowired
    private ProductInfoService productInfoService;

    @RequestMapping("list")
    public ResultMap list(@RequestParam Map<String,Object> param){
        Page<Map> mapPage = productStepTplService.pageList(param);
        return success(mapPage);
    }

    @RequestMapping("save")
    public ResultMap save(ProductStepTpl tpl){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if(tpl.getId()!=null){
            tpl.setUpdateTime(timestamp);
        }else{
            tpl.setInsertTime(timestamp);
            tpl.setUpdateTime(timestamp);
        }
        if(productStepTplService.saveOrUpdate(tpl)){
            return success();
        }else{
            return failure("保存产品流程失败");
        }
    }


    @RequestMapping("init")
    public ResultMap init(){
        return success(productInfoService.findAll());
    }


    @RequestMapping("get/{id}")
    public ResultMap get(@PathVariable long id){
        ProductStepTpl tpl = productStepTplService.get(id);
        Map result = object2map(tpl);
        List<ProductInfo> all = productInfoService.findAll();
        result.put("products",all);
        return success(result);
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id){
        return productStepTplService.delete(id)?success():failure("删除失败");
    }
}
