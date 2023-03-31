package com.example.gaokao.entity.Do;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @date 2022/9/1
 * @描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser {
    int id;
    String name;
    String idCard;
}
