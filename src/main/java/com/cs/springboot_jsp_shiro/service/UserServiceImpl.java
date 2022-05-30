package com.cs.springboot_jsp_shiro.service;

import com.cs.springboot_jsp_shiro.entity.Perms;
import com.cs.springboot_jsp_shiro.mappers.UserMapper;
import com.cs.springboot_jsp_shiro.entity.User;
import com.cs.springboot_jsp_shiro.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chen shi
 * @version V1.0
 * @description
 * @company 北京中科凡语科技有限公司
 * @copyright Beijing Fanyu Technology Co., Ltd ©2018
 * @date 2022/3/1 15:41
 */

/**
 * @Service("userServi---ce") 给该类的bean取名未userService
 */
@Service("userService")
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        //处理业务调用mapper
        //明文进行md5+salt+hash散列
        String salt = SaltUtils.getSalt(user.getPassWord().length());
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassWord(),user.getSalt(),1024);
        user.setPassWord(md5Hash.toHex());
        userMapper.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public User queryByRoleListUserName(String userName) {
        return userMapper.queryByRoleListUserName(userName);
    }

    @Override
    public List<Perms> queryPermsByRoleId(Long id) {
        return userMapper.queryPermsByRoleId(id);
    }
}
