package com.example.gaokao.entity.Do;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tanxiangwen
 * @date 2022/9/1
 * @描述 意见
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Idea {
    int id;
    String userPhone;
    String name;
    String content;
}
