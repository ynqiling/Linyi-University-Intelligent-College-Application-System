package com.example.gaokao.entity.Do;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
  * @author tanxiangwen
  * @date  2022/7/31
  * @描述  学校信息类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolInfo {
    private Long id;

    private String schId;

    private String schName;

    private String schEnglishName;

    private String schTelNum;

    private String schLogo;

    private String schTags;////办学层次

    private String schCompetentDesc;//隶属于

    private Integer schCreateTime;

    private Integer schRunType;

    private String schRunTypeDesc;

    private String diplomaDesc;//学历层次

    private String schTypeTagDesc;

    private String schTypeDesc;////院校类型

    private String gradDesc;//研究生点

    private String province;

    private String schIntro;

    private String schAddress;

    private String schWebUrl;

    private Double schAbroadRatio;

    private Double schMasterRatio;

    private String schScholarship;

    private String schFacultyIntro;

    private Integer softRank;
}