package com.example.gaokao.entity.vo;

import lombok.Data;

/**
 * @Description
 * @Author yuys
 * @Since 2022/9/2
 */
@Data
public class SearchSchoolParam {

    /**
     * 页号
     */
    private int pageNo;

    /**
     * 学校名称
     */
    private String schName;
}
