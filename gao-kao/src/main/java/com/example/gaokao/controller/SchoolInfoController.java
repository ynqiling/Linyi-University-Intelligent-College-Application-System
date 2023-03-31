package com.example.gaokao.controller;

import com.example.gaokao.entity.Do.SchoolInfo;
import com.example.gaokao.entity.vo.QuerySchool;
import com.example.gaokao.entity.vo.QuerySchoolId;
import com.example.gaokao.entity.vo.SchoolOrderParam;
import com.example.gaokao.entity.vo.SearchSchoolParam;
import com.example.gaokao.service.SchoolInfoService;
import com.example.gaokao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tanxiangwen
 * @date 2022/8/1
 * @描述 学校
 */
@RestController
@RequestMapping("/school")
public class SchoolInfoController {
    @Autowired
    private SchoolInfoService schoolInfoService;

    /**
     * 获取所有学校信息并分页按照软科排名
     *
     * @param pageNo
     * @return
     */
    @PostMapping("/getSchoolInfo")
    public Result getSchoolInfo(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
        PageHelper.startPage(pageNo, 10);
        List<SchoolInfo> schoolInfo = schoolInfoService.getSchoolInfo();
        PageInfo<SchoolInfo> pageInfo = new PageInfo<>(schoolInfo);
        return Result.ok(pageInfo);
    }

    /**
     * 根据条件获取学校信息并分页按照软科排名
     */
    @PostMapping("/getSchoolInfoByCondition")
    public Result getSchoolInfoByCondition(@RequestBody QuerySchool querySchool) {
        SchoolInfo schoolInfo = new SchoolInfo();
        BeanUtils.copyProperties(querySchool, schoolInfo);
        // String provinces = schoolInfo.getProvince();
        //分割字符串
        // List<String> province = Arrays.asList(provinces.split(","));
        PageHelper.startPage(querySchool.getPageNo(), 10);
        List<SchoolInfo> schoolInfoList = schoolInfoService.getSchoolInfoByCondition(schoolInfo);
        System.out.println(schoolInfo);
        PageInfo<SchoolInfo> pageInfo = new PageInfo<>(schoolInfoList);
        return Result.ok(pageInfo);
    }

    /*
    根据学校id查询学校
    * */
    @PostMapping("/getSch")
    public Result getSchoolInfobyId(@RequestBody QuerySchoolId querySchoolId) {
        SchoolInfo schoolInfoBYid = schoolInfoService.getSchoolInfoBYid(querySchoolId.getId());
        return Result.ok(schoolInfoBYid);
    }


    /**
     * 排行
     * 学校排名参数
     *
     * @param schoolOrderParam
     * @return
     */
    @PostMapping("order")
    public Result getOrder(@RequestBody SchoolOrderParam schoolOrderParam) {
        PageHelper.startPage(schoolOrderParam.getPageNo(), 20);
        List<SchoolInfo> list = schoolInfoService.orderSchool();
        PageInfo<SchoolInfo> pageInfo = new PageInfo<>(list);
        return Result.ok(pageInfo);
    }

    /**
     * 我想去的学校:需要在地址中携带参数因为用了@requestParam
     *
     * @param searchSchoolParam
     * @return
     */
    @PostMapping("mySchool")
    public Result getMySchool(@RequestBody SearchSchoolParam searchSchoolParam) {
        PageHelper.startPage(searchSchoolParam.getPageNo(), 10);
        List<SchoolInfo> list = schoolInfoService.getSchoolByKey(searchSchoolParam.getSchName());
        PageInfo<SchoolInfo> pageInfo = new PageInfo<>(list);
        return Result.ok(pageInfo);
    }
}
