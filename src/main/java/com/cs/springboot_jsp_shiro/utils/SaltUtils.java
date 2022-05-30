package com.cs.springboot_jsp_shiro.utils;

import java.util.Random;

/**
 * @author chen shi
 * @version V1.0
 * @description
 * @company 北京中科凡语科技有限公司
 * @copyright Beijing Fanyu Technology Co., Ltd ©2018
 * @date 2022/3/1 15:54
 */
public class SaltUtils {
    /**
     * 生成盐的静态方法
     */
    public static String getSalt(int n){
        char[] chars = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890!@#$%^&*()_+".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <n ; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}
