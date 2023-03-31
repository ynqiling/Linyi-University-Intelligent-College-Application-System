package com.example.gaokao.dao;

import com.example.gaokao.entity.Do.SchoolInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
  * @author tanxiangwen
  * @date  2022/7/31
  * @描述 学校信息dao
 */
@Mapper
public interface SchoolInfoDao {
    //获取所有学校信息按照软科排名
    public List<SchoolInfo> getSchoolInfo();
    //条件查询:根据学校名称,院校类型,院校类型标签,学历层次,办学性质,研究生点(前端需要传递研究生点这几个子),省份查询学校信息
    public List<SchoolInfo> getSchoolInfoByCondition(SchoolInfo schoolInfo);
    //根据学校id查询学校详细信息
    public SchoolInfo getSchoolInfoBYid(Long id);
    //院校排行榜1-100
    public List<SchoolInfo> orderSchool();
    public List<SchoolInfo> getSchoolByKey(String schName);


}