package com.example.gaokao.entity.Do;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tanxiangwen
 * @date 2022/7/30
 * @描述 实名认证
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auth {
    String status;
    String msg;
    String idCard;
    String name;
    String sex;
    String area;
    String province;
    String city;
    String prefecture;
    String birthday;
    String addCode;
    String lastCode;
    String traceId;
}
