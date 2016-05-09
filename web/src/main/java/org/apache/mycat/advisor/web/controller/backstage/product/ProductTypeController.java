package org.apache.mycat.advisor.web.controller.backstage.product;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.ProductType;
import org.apache.mycat.advisor.service.backstage.product.producttype.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by cloudsher on 2016/4/27.
 */
@RestController
@RequestMapping("/product/type/")
public class ProductTypeController extends BaseController {


    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping("list")
    public ResultMap list(@RequestParam Map<String, Object> param) {
        Page page = productTypeService.pageList(param);
        return sucess(page);
    }

    @RequestMapping("save")
    public ResultMap save(ProductType type){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if(type.getId()!=null){
            type.setUpdateTime(timestamp);
        }else{
            type.setInsertTime(timestamp);
            type.setUpdateTime(timestamp);
        }
        if(productTypeService.saveOrUpdate(type)){
            return success();
        }else{
            return failure("保存产品类型失败");
        }
    }


    @RequestMapping("init")
    public ResultMap init(){
        return success();
    }


    @RequestMapping("get/{id}")
    public ResultMap get(@PathVariable long id){
        return success(productTypeService.get(id));
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id){
        return productTypeService.delete(id)?success():failure("删除失败");
    }
}
