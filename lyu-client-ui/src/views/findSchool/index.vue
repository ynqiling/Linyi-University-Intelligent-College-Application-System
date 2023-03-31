<template>
  <div class="content">

    <el-card class="box-card" style="margin-top: 10px">

      <div class="choose-title">地区 :</div>
      <el-radio-group v-model="city" @change="getSchoolInfoByCondition">
        <el-radio v-for="city in cities" :label="city" :key="city">{{ city }}</el-radio>
      </el-radio-group>

      <div class="choose-title">院校类型 :</div>
      <el-checkbox-group v-model="chooseCollegeTypes" @change="getSchoolInfoByCondition">
        <el-checkbox v-for="type in collegeTypes" :label="type" :key="type">{{ type }}</el-checkbox>
      </el-checkbox-group>

      <div class="choose-title">学历层次 :</div>
      <el-checkbox-group v-model="chooseAcademicLevels" @change="getSchoolInfoByCondition">
        <el-checkbox v-for="level in academicLevels" :label="level" :key="level">{{ level }}</el-checkbox>
      </el-checkbox-group>

      <div class="choose-title">院校层次 :</div>
      <el-checkbox-group v-model="chooseCollegeLevels" @change="getSchoolInfoByCondition">
        <el-checkbox v-for="level in collegeLevels" :label="level" :key="level">{{ level }}</el-checkbox>
      </el-checkbox-group>

      <div class="choose-title">办学性质 :</div>
      <el-checkbox-group v-model="chooseSchoolNatures" @change="getSchoolInfoByCondition">
        <el-checkbox v-for="nature in schoolNatures" :label="nature" :key="nature">{{ nature }}</el-checkbox>
      </el-checkbox-group>
    </el-card>

    <div class="school-content">
      <div class="school-item" v-for="item in schoolInfos">
        <div class="left">
          <div class="img">
            <img :src="item.schLogo">
          </div>
          <div class="middle">
            <div class="school-name">
              {{ item.schName }}
              <span class="school-city">{{ item.province }}市</span>
            </div>
            <div class="school-babel" style="width: 100%">
              <el-tag type="warning" v-for="tag in item.schTags">{{ tag }}</el-tag>
            </div>
          </div>
        </div>

        <div class="right">
          <div class="school-info">
            <el-button type="primary" @click="querySchoolInfo(item.id)">学校详细信息</el-button>
          </div>
        </div>

      </div>

      <div class="pagination">
        <el-pagination
          background
          layout="prev, pager, next"
          :current-page="page.currentPage"
          :page-size="10"
          :total="page.total"
          @current-change="currentChange"
        >
        </el-pagination>
      </div>

    </div>

  </div>
</template>

<script>
import { academicLevels, cities, collegeLevels, collegeTypes, schoolNatures } from '@/common/data'
import { getSchoolById, getSchoolInfoByCondition } from '@/api/schoolInfo'

export default {
  name: 'index',
  data () {
    return {
      schoolInfos: [],
      // 所选地区
      city: '北京',
      // 所有城市
      cities,
      collegeTypes,
      // 学历层次
      academicLevels,
      // 院校层次
      collegeLevels,
      // 办学性质
      schoolNatures,
      chooseCollegeTypes: ['工科'],
      chooseAcademicLevels: ['本科'],
      chooseCollegeLevels: ['双一流'],
      chooseSchoolNatures: ['公立大学'],
      page: {
        total: 0,
        currentPage: 1
      }
    }
  },
  created () {
    this.getSchoolInfoByCondition()
  },
  methods: {
    async getSchoolInfoByCondition () {
      let params = {
        schTypeDesc: this.chooseCollegeTypes.join(','),
        schTypeTagDesc: this.chooseCollegeLevels.join(','),
        diplomaDesc: this.chooseAcademicLevels.join(','),
        schTags: this.chooseSchoolNatures.join(','),
        province: this.city,
        pageNo: this.page.currentPage
      }
      const {
        ok,
        data
      } = await getSchoolInfoByCondition(params)
      this.schoolInfos = data.list

      // 处理标签
      this.schoolInfos.forEach(item => {
        item.schTags = item.schTags.substring(1, item.schTags.length - 1).split(',').map(item => item.trim())
      })
      this.page.total = data.total
    },
    async currentChange (currentPage) {
      this.page.currentPage = currentPage
      this.getSchoolInfoByCondition()
    },

    async querySchoolInfo (schoolId) {
      this.$router.push({
        path: '/findSchoolToOne',
        query: { id: schoolId }
      })
    }
  }
}
</script>

<style scoped lang="scss">
.choose-title {
  font-size: 14px;
  margin: 15px 0;
  font-weight: 100;
}

.school-content {
  padding-left: 20px;

  .school-item {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-top: 20px;

    .left {
      display: flex;

      .img {
        width: 100px;
        height: 100px;

        img {
          width: 100px;
          height: 100px;
        }
      }

      .middle {
        padding-left: 100px;
        padding-right: 50px;

        .school-name {
          margin-top: 10px;
          font-size: 20px;

          .school-city {
            font-size: 10px;
          }
        }

        .school-babel {
          margin-top: 20px;

          .el-tag {
            margin-left: 20px;
          }
        }
      }
    }
  }

  .pagination {
    text-align: center;
  }

}
</style>
