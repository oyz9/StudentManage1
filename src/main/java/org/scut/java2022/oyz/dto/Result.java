package org.scut.java2022.oyz.dto;

import lombok.Data;
import lombok.ToString;

@Data
/**
 * 加入Result检错
 */
public class Result {
    /**
     * 状态码
     * 1000: 成功
     * 1001: token过期, 1002: 非法token
     * 2001: 用户密码错误, 2002: 用户不存在, 2003: 用户参数缺失,2004:用户已存在
     * 3001: 信息不存在
     */
    private String code;
    private String msg;
    private Object data;
    private String token;

}
