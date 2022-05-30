package com.cs.springboot_jsp_shiro.config;

import com.cs.springboot_jsp_shiro.shiro.realm.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen shi
 * @version V1.0
 * @description
 * @company 北京中科凡语科技有限公司
 * @copyright Beijing Fanyu Technology Co., Ltd ©2018
 * @date 2022/3/1 9:28
 */

/**
 * 用来整合shiro框架相关配置类
 * @author zkfy
 */
@Configuration
public class shiroConfig {
    /**
     * 1.创建shiroFilter 负责拦截所有请求
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultSecurityManager defaultSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultSecurityManager);
        //配置系统受限资源
        Map<String,String> map = new HashMap<String,String>(0);
        //authc 请求这个资源需要认证和请求
        //公共访问的资源应放到前面 并且应该全拼
        map.put("/register.jsp","anon");
        map.put("/user/register","anon");
        map.put("/user/login","anon");
//        map.put("/index.jsp","authc");
        map.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //默认认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");
        //配置系统公共资源
        return shiroFilterFactoryBean;
    }

    /**
     * 2.创建 安全管理器
     * @return DefaultSecurityManager
     */
    @Bean
    public DefaultSecurityManager getDefaultSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }
    /**
     *     3.创建自定义realm
     */
    @Bean
    public Realm getRealm(){
        CustomerRealm customerRealm = new CustomerRealm();
        //修改校验凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法为md5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置散列次数
        credentialsMatcher.setHashIterations(1024);
        customerRealm.setCredentialsMatcher(credentialsMatcher);
        //开启缓存管理
        customerRealm.setCacheManager(new EhCacheManager());
        //开启全局缓存
        customerRealm.setCachingEnabled(true);
        //认证缓存
        customerRealm.setAuthenticationCachingEnabled(true);
        //授权缓存
        customerRealm.setAuthorizationCachingEnabled(true);
        customerRealm.setAuthenticationCacheName("authenticationCache");
        customerRealm.setAuthorizationCacheName("authorizationCache");
        return customerRealm;
    }
}
