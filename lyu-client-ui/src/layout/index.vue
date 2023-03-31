<template>
  <div class="layout">
    <!--  header  -->
    <div class="header">
      <div class="content">
        <div class="menu">
          <a class="item" @click="drawer = true">意见反馈</a>
          <a class="item">志愿填报咨询群</a>
          <a class="item">微信群</a>
          <a class="item" v-if="!isLogin" @click="$router.push({path:'/loginAndRegister'})">登录/注册</a>
          <a class="item" v-if="isLogin">我的</a>
          <a class="item" v-if="isLogin" @click="logout">退出登录</a>
        </div>
      </div>
    </div>
    <!--  main  -->
    <div class="main">
      <!--   logo   -->
      <div class="main-menu content">
        <div><img src="@/assets/img/logo.png"></div>
        <div class="input">
          <el-input placeholder="查询我想读的大学" class="input-with-select">
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </div>
      </div>
      <!--   menu   -->
      <div class="content">
        <el-menu class="el-menu-demo" mode="horizontal" router>
          <el-menu-item index="1" route="/">首页</el-menu-item>
          <el-menu-item index="2" route="/fillVolunteer">填志愿</el-menu-item>
          <el-menu-item index="3" route="/findSchool">找学校</el-menu-item>
          <el-menu-item index="4" route="/findMajor">找专业</el-menu-item>
          <el-menu-item index="5" route="/ranking">排行榜</el-menu-item>
          <el-menu-item index="7" route="/collageNew">高考资讯</el-menu-item>
        </el-menu>
      </div>
      <router-view/>
    </div>
    <div class="footer"></div>

    <!-- 意见弹框 -->
    <el-drawer
      ref="drawer"
      title="反馈意见"
      :visible.sync="drawer"
      :direction="'btt'"
      :before-close="beforeClose">

      <el-form ref="form" :model="form" label-width="150px">
        <el-form-item label="意见人联系方式：">
          <el-input v-model="form.phone"></el-input>
        </el-form-item>
        <el-form-item label="意见：">
          <el-input type="textarea" v-model="form.options" :rows="3"></el-input>
        </el-form-item>
        <div class="drawer-footer" style="text-align: center">
          <el-button type="primary" @click="submission" :loading="loading">
            {{ loading ? '提交中 ...' : '提交意见' }}
          </el-button>
        </div>
      </el-form>

    </el-drawer>
  </div>
</template>

<script>
import { getToken, removeToken } from '@/util/storage_token'
import { Message } from 'element-ui'

export default {
  name: 'index',
  data () {
    return {
      loading: false,
      isLogin: getToken(),
      drawer: false,
      form: {
        // 联系方式
        phone: '',
        // 意见
        options: ''
      }
    }
  },
  methods: {
    logout () {
      removeToken()
      this.isLogin = false
      // 退出提醒
      Message({
        message: '您已成功退出',
        type: 'success'
      })
    },
    // 提出意见
    expressViews () {

    },
    // 关闭之前
    beforeClose () {
      this.drawer = false
    },
    submission () {
      if (this.form.options === '' || this.form.phone === '') {
        Message({
          message: '意见或手机号不能为空！',
          type: 'warning'
        })
      } else {
        this.$refs.drawer.closeDrawer()
      }
    }
  }
}
</script>

<style scoped lang="scss">
a:hover {
  color: #f05557;
}

.layout {
  width: 100%;
  background-color: #ffffff;
}

.header {
  height: 50px;
  background-color: #333333;

  .menu {
    display: flex;
    align-content: center;
    justify-content: right;
    height: 60px;
    line-height: 50px;
    color: #d6d6d6;

    .item {
      margin-left: 20px;
    }
  }
}

.main {
  background-color: #f6f7fb;

  .main-menu {
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-content: center;
    height: 100px;

    div {
      padding-top: 15px;
    }

    .input {
      width: 350px;
    }
  }
}

.footer {
  height: 100px;
  background-color: #333333;
}
</style>
