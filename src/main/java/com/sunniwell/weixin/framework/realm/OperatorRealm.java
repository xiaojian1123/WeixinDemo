package com.sunniwell.weixin.framework.realm;

import com.sunniwell.weixin.bean.operator.OperatorBean;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by xiaojian on 2018/2/2.
 */
public class OperatorRealm extends AuthorizingRealm {

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String operatorId = (String) authenticationToken.getPrincipal();
        String operatorPassword =(String) authenticationToken.getCredentials();
        //查询用户信息
        OperatorBean operator = null;

        return null;
    }
}
