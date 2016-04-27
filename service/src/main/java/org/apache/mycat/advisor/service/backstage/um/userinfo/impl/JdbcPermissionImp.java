package org.apache.mycat.advisor.service.backstage.um.userinfo.impl;

import org.apache.mycat.advisor.common.security.shiro.dynamic.JdbcPermissionDao;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * package: org.apache.mycat.advisor.service.backstage.um.userinfo <br/>
 * functional describe:查询URL链接对应的角色要求，资源权限要求<br/>
 * 注意Shiro的策略是匹配到第一个权限后就立即返回，不再往下匹配，所以资源角色配置<br/>
 * 需要注意顺序
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/4/25 19:51
 */
@Service
public class JdbcPermissionImp implements JdbcPermissionDao{

    @Override
    public LinkedHashMap<String, String> generateDefinitions() {
        return null;
    }

    @Override
    public Map<String, String> findDefinitionsMap() {
        return null;
    }
}
