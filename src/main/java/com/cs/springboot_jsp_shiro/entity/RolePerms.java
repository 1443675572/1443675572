package com.cs.springboot_jsp_shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author chen shi
 * @version V1.0
 * @description
 * @company 北京中科凡语科技有限公司
 * @copyright Beijing Fanyu Technology Co., Ltd ©2018
 * @date 2022/3/2 11:04
 */

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class RolePerms implements Serializable {
    private static final long serialVersionUID = -1801666810904408476L;
    private Long id;
    private Long permsId;
    private Long roleId;
}
