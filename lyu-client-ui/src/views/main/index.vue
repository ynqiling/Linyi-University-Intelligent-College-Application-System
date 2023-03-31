<template>
  <div>
    <el-carousel indicator-position="outside" height="400px">
      <el-carousel-item v-for="item in 4" :key="item">
        <img src="@/assets/img/log.svg">
      </el-carousel-item>
    </el-carousel>

    <div class="content">
      <el-row>
        <el-card class="box-card" shadow="hover">
          <h1 class="title">学校推荐</h1>
          <div class="school-container">
            <div class="school-item" @click="gotoSchoolInfo(15724)">
              <div class="school-img">
                <img src="https://storage-oss.ipin.com/school-icon/52ac2e99747aec013fcf4e6f.jpg">
              </div>
              <div class="school-name">清华大学</div>
            </div>

            <div class="school-item" @click="gotoSchoolInfo(15726)">
              <div class="school-img">
                <img src="https://storage-oss.ipin.com/school-icon/52ac2e9a747aec013fcf5268.jpg">
              </div>
              <div class="school-name">浙江大学</div>
            </div>

            <div class="school-item" @click="gotoSchoolInfo(15741)">
              <div class="school-img">
                <img src="https://storage-oss.ipin.com/school-icon/52ac2e98747aec013fcf4b88.jpg">
              </div>
              <div class="school-name">山东大学</div>
            </div>

            <div class="school-item" @click="gotoSchoolInfo(15743)">
              <div class="school-img">
                <img src="https://storage-oss.ipin.com/school-icon/52ac2e98747aec013fcf4bff.jpg">
              </div>
              <div class="school-name">厦门大学</div>
            </div>

            <div class="school-item" @click="gotoSchoolInfo(15744)">
              <div class="school-img">
                <img src="https://storage-oss.ipin.com/school-icon/52ac2e98747aec013fcf4c1d.jpg">
              </div>
              <div class="school-name">同济大学</div>
            </div>

            <div class="school-item" @click="gotoSchoolInfo(15769)">
              <div class="school-img">
                <img src="https://storage-oss.ipin.com/school-icon/52ac2e9a747aec013fcf4fa9.jpg">
              </div>
              <div class="school-name">中国海洋大学</div>
            </div>
          </div>
        </el-card>
      </el-row>

      <el-row>
        <el-col :span="11">
          <el-card class="box-card" shadow="hover">
            <!-- 个人性格测试 :  https://www.16personalities.com/ch -->
            <!--职业兴趣测试： https://www.apesk.com/holland/index.html-->
            <div class="title">性格兴趣测评</div>
            <div class="evaluation">
              <img src="https://static.neris-assets.com/images/system/logo.svg">
              <el-button type="primary" @click="characterTest">个人性格测试</el-button>
            </div>
            <div class="evaluation">
              <img src="https://www.apesk.com/lee/img/logo_normal.gif">
              <el-button type="warning" @click="professionTest">职业兴趣测试
              </el-button>
            </div>
          </el-card>
        </el-col>

        <el-col :span="11" :offset="2">
          <el-card class="box-card" shadow="hover">
            <div class="title">测录取概率</div>
            <div class="input-item">
              <div class="name-item">
                院校名：
              </div>
              <el-input placeholder="输入院校名称" v-model="schoolName"></el-input>
            </div>
            <div class="input-item">
              <div class="name-item">
                专业名：
              </div>
              <el-input placeholder="输入专业名称" v-model="specializedName"></el-input>
            </div>
            <div class="operation">
              <el-button type="primary" @click="tipAdmission">测试录取概率</el-button>
            </div>

          </el-card>
        </el-col>
      </el-row>

      <el-row>
        <el-card class="box-card" shadow="hover">
          <div class="one-line">
            <h1 class="title">热门资讯</h1>
            <div class="more" @click="lookMore">查看更多>></div>
          </div>

          <div class="popular-content">

            <div class="popular-item">
              <div class="popular-item-img">
                <img src="https://storage-oss.ipin.com/oss-data/articleimage-20220621220052502202.png">
              </div>

              <div class="popular-item-title">
                热点问题，专家解答
              </div>
              <div class="popular-item-time">
                2022-09-9 00:00:00
              </div>
            </div>

            <div class="popular-item">
              <div class="popular-item-img">
                <img src="https://storage-oss.ipin.com/oss-data/articleimage-2022062211592064033.png">
              </div>

              <div class="popular-item-title">
                高考志愿填报需要注意的问题
              </div>

              <div class="popular-item-time">
                2022-09-9 00:00:00
              </div>
            </div>
            <div class="popular-item">
              <div class="popular-item-img">
                <img src="https://storage-oss.ipin.com/oss-data/articleimage-20220621110156141511.jpg">
              </div>

              <div class="popular-item-title">
                定向培养军士考生须知
              </div>

              <div class="popular-item-time">
                2022-09-9 00:00:00
              </div>
            </div>
          </div>
        </el-card>
      </el-row>
    </div>
  </div>

</template>

<script>
import { Message } from 'element-ui'

export default {
  name: 'index',
  data () {
    return {
      schoolName: '',
      specializedName: ''
    }
  },
  methods: {

    // 查看学校详细信息
    gotoSchoolInfo (schoolId) {
      this.$router.push({
        path: '/findSchoolToOne',
        query: { id: schoolId }
      })
    },

    //个人性格测试
    characterTest () {
      window.open('https://www.16personalities.com/ch')
    },

    // 职业测试
    professionTest () {
      window.open('https://www.apesk.com/holland/index.html')
    },

    tipAdmission () {
      Message({
        message: '哎呦，你被录取率',
        type: 'success'
      })

      // 清空数据
      this.schoolName = ''
      this.specializedName = ''
    },
    lookMore () {
      this.$router.push({
        path: '/collageNew',
      })
    }
  }
}
</script>

<style scoped lang="scss">
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.one-line {
  display: flex;
  justify-content: space-between;
  // 查看更多
  .more {
    font-size: 10px;
    font-weight: 600;
    padding-right: 20px;
  }
}

.title {
  font-weight: 800;
  margin-bottom: 10px;
}


.el-row {
  margin-top: 40px;
}

/*.el-card {
  height: 250px;
}*/

.school-container {
  display: flex;
  text-align: center;
  justify-content: space-around;

  .school-item {
    .school-img, img {
      width: 130px;
      height: 130px;
    }

    .school-name {
      margin-top: 10px;
      font-size: 20px;
    }
  }
}

.evaluation {
  display: flex;
  justify-content: space-around;
  align-items: center;

  img {
    height: 80px;
    width: 200px;
  }
}

.input-item {
  display: flex;
  margin: 10px 20px;
  align-items: center;
  text-align: center;

  .name-item {
    width: 100px;
  }

}

.operation {
  margin-left: 150px;
}

.popular-content {
  .popular-item {
    display: flex;
    justify-content: space-between;
    padding: 10px 20px;
    border-bottom: solid 1px #eae5e5;

    .popular-item-title {
      flex-grow: 1;
      padding-top: 20px;
      padding-left: 20px;
    }

    .popular-item-img {
      img {
        border-radius: 20px;
        width: 180px;
        height: 120px;
      }

    }
    .popular-item-time {
      padding-top: 20px;
      font-size: 10px;
      color: #99a9bf;
    }
  }
}
</style>
