package org.apache.mycat.advisor.service.backstage.um.userinfo;

import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.security.shiro.authentication.RealmService;
import org.apache.mycat.advisor.persistence.model.TabUserInfo;
import org.apache.mycat.advisor.service.backstage.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * package: org.apache.mycat.advisor.service.backstage.um.userinfo <br/>
 * functional describe:
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/4/26 19:53
 */
public interface RealmServiceWrapper extends RealmService,BaseService<TabUserInfo>{

}
