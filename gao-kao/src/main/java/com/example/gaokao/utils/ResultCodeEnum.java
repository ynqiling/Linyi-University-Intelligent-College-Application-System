package com.example.gaokao.utils;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    PARAM_ERROR( 202, "参数不正确"),
    SERVICE_ERROR(203, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    //请登录
    NOT_LOGIN(205, "请登录"),
    //实名认证成功
    REAL_NAME_SUCCESS(288, "实名认证成功"),
    //实名认证失败
    REAL_NAME_FAIL(299, "实名认证失败"),


    DATA_UPDATE_ERROR(206, "数据版本异常"),
    NONE_USER_MESSAGE(1116,"无用户数据,或用户名密码不正确"),
    FAIL_REGISTER_USER(113,"用户注册失败"),
    //电话号码不合法.
    PHONE_NUMBER_ILLEGAL(114,"电话号码不合法"),
    //手机号以及存在.
    PHONE_NUMBER_EXIST(115,"手机号码已经存在"),
    //邮件发送成功
    EMAIL_SEND_SUCCESS(116,"邮件发送成功"),
    //邮件格式不正确
    EMAIL_FORMAT_ERROR(117,"邮件格式不正确"),
    CODE_CHECK_SUCCESS(118,"会员注册成功"),
    CODE_CHECK_ERROR(119,"激活码不一致,请检查"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),

    CODE_ERROR(210, "验证码错误"),
//    LOGIN_MOBLE_ERROR(211, "账号不正确"),
    LOGIN_DISABLED_ERROR(212, "改用户已被禁用"),
    REGISTER_MOBLE_ERROR(213, "手机号已被使用"),
    LOGIN_AURH(214, "需要登录"),
    LOGIN_ACL(215, "没有权限"),

    URL_ENCODE_ERROR( 216, "URL编码失败"),
    ILLEGAL_CALLBACK_REQUEST_ERROR( 217, "非法回调请求"),
    FETCH_ACCESSTOKEN_FAILD( 218, "Token验证失败"),
    FETCH_USERINFO_ERROR( 219, "获取用户信息失败"),
    //LOGIN_ERROR( 23005, "登录失败"),
    SIGN_ERROR(300, "签名错误"),
    DATABASE_QUERT_NO_DATE(330, "查询无数据"),
    DATABASE_UPDATE_ERROR(331, "更新错误"),
    DATABASE_INSERT_ERROR(332, "插入错误"),
    DATABASE_DELETE_ERROR(333, "删除错误"), ID_CARD_ILLEGAL(848,"身份证位数不合法");
    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
