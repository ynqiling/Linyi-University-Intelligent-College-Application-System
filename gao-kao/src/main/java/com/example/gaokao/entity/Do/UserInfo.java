package com.example.gaokao.entity.Do;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user_info:用户登录表
 *
 * @author
 */
@Data
public class UserInfo implements Serializable {
    private Integer id;
    private String userName;
    private String userPwd;
    private String userPhone;
    private String userEmail;
    private String authentication;
    private String realName;//真实姓名
    private String realIdCard;//身份证号
}