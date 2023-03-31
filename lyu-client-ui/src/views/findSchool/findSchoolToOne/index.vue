<template>
  <div class="content">

    <el-card shadow="hover" class="card">
      <div class="school-info">
        <div class="school-img">
          <img :src="schoolInfo.schLogo">
        </div>

        <div class="school-content">
          <div class="school-title">{{ schoolInfo.schName }}</div>
          <div class="school-tags">
            <el-tag type="success" v-for="tag in schoolInfo.schTags">{{ tag }}</el-tag>
          </div>
          <div class="school-website">
            <a :href="schoolInfo.schWebUrl" target="_blank">进入官网 >></a>
          </div>
        </div>
      </div>

    </el-card>
    <el-collapse v-model="activeNames">
      <el-collapse-item title="学校介绍" name="1">
        <div class="text-context">
          {{ schoolInfo.schIntro }}
        </div>
      </el-collapse-item>

      <el-collapse-item title="学院介绍" name="2">
        <div class="text-context">
          {{ schoolInfo.schFacultyIntro }}
        </div>
      </el-collapse-item>

      <el-collapse-item title="其他信息" name="3">
        <el-descriptions class="margin-top" :column="2" border>
          <el-descriptions-item>
            <template slot="label">
              学校地址：
            </template>
            {{ schoolInfo.schAddress }}
          </el-descriptions-item>

          <el-descriptions-item>
            <template slot="label">
              英文名称：
            </template>
            {{ schoolInfo.schEnglishName }}
          </el-descriptions-item>

          <el-descriptions-item>
            <template slot="label">
              联系方式：
            </template>
            {{ schoolInfo.schTelNum }}
          </el-descriptions-item>

        </el-descriptions>
      </el-collapse-item>

    </el-collapse>
  </div>
</template>

<script>
import { getSchoolById } from '@/api/schoolInfo'

export default {
  name: 'index',
  data () {
    return {
      schoolInfo: {},
      activeNames: ['1', '2', '3', '4']
    }
  },
  created () {
    this.getSchoolInfo()

  },
  methods: {
    // 获取学校信息
    async getSchoolInfo () {
      const { data } = await getSchoolById({ id: this.$route.query.id })
      this.schoolInfo = data
      // 处理标签
      this.schoolInfo.schTags = this.schoolInfo.schTags.substring(1, this.schoolInfo.schTags.length - 1).split(',').map(item => item.trim())
    }
  }
}
</script>

<style scoped lang="scss">
.text-context {
  padding: 10px;
}

.el-card {
  margin: 10px 0;
  display: flex;
}

.school-info {
  display: flex;

  .school-img {
    width: 100px;
    height: 100px;

    img {
      width: 100%;
      height: 100%;
    }
  }

  .school-content {
    padding-left: 30px;

    .school-title {
      font-weight: bolder;
      font-size: 20px;
    }

    .school-tags {
      margin: 20px 0;
    }

    .school-website {
      font-size: 12px;
    }
  }

  .el-tag {
    margin-right: 10px;
  }
}
</style>
