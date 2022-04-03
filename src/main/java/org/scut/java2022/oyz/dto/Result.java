package org.scut.java2022.oyz.dto;

import lombok.Data;

@Data
public class Result {
    /**
     * 状态码
     * 200: 成功
     * 1001: token过期, 1002: 非法token
     * 2001: 用户密码错误, 2002: 用户不存在, 2003: 用户参数缺失
     * 3001: 信息不存在
     */
    private String code;
    private String msg;
    private Object data;

}
