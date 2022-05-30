package com.cs.springboot_jsp_shiro.Controller;

import com.cs.springboot_jsp_shiro.entity.User;
import com.cs.springboot_jsp_shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chen shi
 * @version V1.0
 * @description
 * @company 北京中科凡语科技有限公司
 * @copyright Beijing Fanyu Technology Co., Ltd ©2018
 * @date 2022/3/1 10:28
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用来处理身份认证
     * @param userName
     * @return
     */
    @RequestMapping("login")
    public String login(String userName,String passWord){
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(userName,passWord));
            return "redirect:/index.jsp";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }
        return "redirect:/login.jsp";
    }

    /**
     * 退出登录
     */
    @RequestMapping("loginOut")
    public String loginOut(){
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        //退出登录
        subject.logout();
        return "redirect:/login.jsp";
    }

    /**
     * 用户认证
     */
    @RequestMapping("register")
    public String register(User user){
        try {
            userService.register(user);
            return "redirect:/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/register.jsp";
        }
    }
}
