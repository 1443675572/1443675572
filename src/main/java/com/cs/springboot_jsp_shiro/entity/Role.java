package com.cs.springboot_jsp_shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author chen shi
 * @version V1.0
 * @description
 * @company 北京中科凡语科技有限公司
 * @copyright Beijing Fanyu Technology Co., Ltd ©2018
 * @date 2022/3/2 11:02
 */

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = 1989182190171390006L;

    private Long id;
    private String role;

    /**
     * 定义权限集合
     */
    private List<Perms> permsList;
}
