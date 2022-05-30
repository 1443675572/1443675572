package com.cs.springboot_jsp_shiro.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chen shi
 * @version V1.0
 * @description
 * @company 北京中科凡语科技有限公司
 * @copyright Beijing Fanyu Technology Co., Ltd ©2018
 * @date 2022/3/2 9:56
 */
@Controller
@RequestMapping("oder")
public class OderController {

    @RequestMapping("save")
    @RequiresRoles("admin")//用来判断角色
    //@RequiresRoles(value = {"admin","user") 判断同时具有多个角色
    //@RequiresPermissions() 用来判断权限字符串的
    public String save(){
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("admin")) {
            System.out.println("保存订单");
        }else {
            System.out.println("无权访问");
        }
        //用代码的方式进行授权
       return "redirect:/index.jsp";
    }
}
