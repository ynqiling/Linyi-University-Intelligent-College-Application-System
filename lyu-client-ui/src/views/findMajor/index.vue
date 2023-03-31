<template>
  <div class="content">
    <div class="major-content">
      <div class="level1" v-for="(item1, index) in majors" :key="index">
        <div class="level1-title">{{item1.level1}}</div>
        <div class="level2" v-for="(item2, index2) in item1.children" :key="index2">
          <div class="level2-title">{{ item2.level2 }}</div>
          <div class="level3" v-for="(item3, index3) in item2.children" :key="index3">
            <div class="level3-item">{{ item3 }}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'index',
  data () {
    return {
      majors: [
        {
          level1: '哲学',
          children: [
            {
              level2: '哲学类',
              children: [
                '哲学','逻辑学','宗教学','伦理学','哲学','逻辑学','宗教学','伦理学'
              ]
            }
          ]
        },
        {
          level1: '经济学',
          children: [
            {
              level2:'经济学类',
              children: ['经济学', '经济统计学', '国民经济管理', '资源与环境经济学', '商务经济学', '能源经济', '劳动经济学', '经济工程', '数字经济']
            },
            {
              level2:'财政学类',
              children: ['财政学', '税收学', '国际税收']
            },
            {
              level2:'金融学类',
              children: ['金融学','金融工程','保险学','投资学','金融数学','信用管理经济与金融精算学','互联网金融','金融科技']

            },
            {
              level2:'经济与贸易类',
              children: ['国际经济与贸易','贸易经济','国际经济发展合作']
            }



          ]
        }
      ]
    }
  }
}
</script>

<style scoped lang="scss">
.content {
  min-height: 600px;
}

.major-content {
  .level1 {
    .level1-title {
      margin-top: 20px;
      font-size: 20px;
      font-weight: 400;
    }

    .level2 {
      margin-top: 20px;
      display: flex;
      justify-content: start;
      font-size: 12px;
      font-weight: 300;

      .level2-title {
        margin-top: 10px;
        width: 200px;
      }

      .level3 {
        display: flex;
        flex-wrap: wrap;

        .level3-item {
          min-width: 50px;
          margin-right: 20px;
          margin-top: 10px;
          text-align: center;
        }
      }

    }
  }


}
</style>
