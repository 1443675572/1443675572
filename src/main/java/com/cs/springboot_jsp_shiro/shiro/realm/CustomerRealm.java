package com.cs.springboot_jsp_shiro.shiro.realm;

import com.cs.springboot_jsp_shiro.entity.Perms;
import com.cs.springboot_jsp_shiro.entity.User;
import com.cs.springboot_jsp_shiro.service.UserService;
import com.cs.springboot_jsp_shiro.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author chen shi
 * @version V1.0
 * @description 自定义realm
 * @company 北京中科凡语科技有限公司
 * @copyright Beijing Fanyu Technology Co., Ltd ©2018
 * @date 2022/3/1 9:42
 */
public class CustomerRealm extends AuthorizingRealm {
    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取身份信息
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        //根据主身份信息获取角色和权限信息
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
        User user = userService.queryByRoleListUserName(primaryPrincipal);
        System.out.println(primaryPrincipal);
        //赋值授权角色
        if (!CollectionUtils.isEmpty(user.getRoleList())){
            SimpleAuthorizationInfo simpleAuthenticationInfo = new SimpleAuthorizationInfo();
            user.getRoleList().forEach(role -> {
                simpleAuthenticationInfo.addRole(role.getRole());
                //查询角色权限信息
                List<Perms> permsList = userService.queryPermsByRoleId(role.getId());
                if (!CollectionUtils.isEmpty(permsList)) {
                    permsList.forEach(perms -> {
                        simpleAuthenticationInfo.addStringPermission(perms.getName());
                    });
                }
            });
            return simpleAuthenticationInfo;
        }
        return null;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //根据身份信息
        String principal = (String) token.getPrincipal();
        //在工厂中获取Service对象
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
        User user = userService.findByUserName(principal);
        if (ObjectUtils.isEmpty(user)){
            return null;
        }
        return new SimpleAuthenticationInfo(user.getUserName(),user.getPassWord(), ByteSource.Util.bytes(user.getSalt()),this.getName());

    }
}
