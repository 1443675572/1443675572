package com.cs.springboot_jsp_shiro.service;

import com.cs.springboot_jsp_shiro.entity.Perms;
import com.cs.springboot_jsp_shiro.entity.Role;
import com.cs.springboot_jsp_shiro.entity.User;

import java.util.List;

/**
 * @author chen shi
 * @version V1.0
 * @description
 * @company 北京中科凡语科技有限公司
 * @copyright Beijing Fanyu Technology Co., Ltd ©2018
 * @date 2022/3/1 15:40
 */
public interface UserService {
    /**
     * 注册用户
     */
    void register(User user);

    /**
     * 根据用户名查询业务的方法
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 根绝用户名查询所有角色
     * @param userName
     * @return
     */
    User queryByRoleListUserName(String userName);

    /**
     * 根据角色id查询权限信息
     */
    List<Perms> queryPermsByRoleId(Long id);
}
