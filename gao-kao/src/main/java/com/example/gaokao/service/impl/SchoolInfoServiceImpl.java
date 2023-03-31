package com.example.gaokao.service.impl;

import com.example.gaokao.dao.SchoolInfoDao;
import com.example.gaokao.entity.Do.SchoolInfo;
import com.example.gaokao.service.SchoolInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanxiangwen
 * @date 2022/7/31
 * @描述 学校信息实现类
 */
@Service
public class SchoolInfoServiceImpl implements SchoolInfoService {
    @Autowired
    SchoolInfoDao schoolInfoDao;
    @Override
    public List<SchoolInfo> getSchoolInfo() {
        return schoolInfoDao.getSchoolInfo() ;
    }

    @Override
    public List<SchoolInfo> getSchoolInfoByCondition(SchoolInfo schoolInfo) {
        return schoolInfoDao.getSchoolInfoByCondition(schoolInfo);
    }

    @Override
    public SchoolInfo getSchoolInfoBYid(Long id) {
        return schoolInfoDao.getSchoolInfoBYid(id);
    }

    @Override
    public List<SchoolInfo> orderSchool() {
        return schoolInfoDao.orderSchool();
    }

    @Override
    public List<SchoolInfo> getSchoolByKey(String schName) {
        return schoolInfoDao.getSchoolByKey(schName);
    }

}
