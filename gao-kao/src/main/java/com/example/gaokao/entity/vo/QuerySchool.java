package com.example.gaokao.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author t
 * @date 2022/8/1
 * @描述 院校查询
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuerySchool {
    private String schName;
    /**
     * 院校类型[工科,理科,综合,等]
     */
    private String schTypeDesc;
    /**
     * 院校层次[985,211,双一流]
     */
    private String schTypeTagDesc;
    /**
     * 学历层次[本科,专等]
     */
    private String diplomaDesc;
    /**
     * 办学性质 [公立,私立]
     */
    private String schTags;
    /**
     * 研究生点
     */
    private String gradDesc;
    /**
     * 省份
     */
    private String province;
    /**
     * 页码
     */
    private int pageNo;
}
