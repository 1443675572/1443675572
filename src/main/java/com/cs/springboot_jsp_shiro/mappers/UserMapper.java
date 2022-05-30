package com.cs.springboot_jsp_shiro.mappers;

import com.cs.springboot_jsp_shiro.entity.Perms;
import com.cs.springboot_jsp_shiro.entity.Role;
import com.cs.springboot_jsp_shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chen shi
 * @version V1.0
 * @description
 * @company 北京中科凡语科技有限公司
 * @copyright Beijing Fanyu Technology Co., Ltd ©2018
 * @date 2022/3/1 15:23
 */

@Mapper
public interface UserMapper {
    void save(User user);
    /**
     * 查询用户
     */
    User findByUserName(String userName);

    /**
     * 根绝用户名查询所有角色
     * @param userName
     * @return
     */
    User queryByRoleListUserName(String userName);

    List<Perms> queryPermsByRoleId(Long id);
}
