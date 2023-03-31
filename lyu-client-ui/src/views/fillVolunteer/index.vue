<template>
  <div class="content">
    <div class="select-options">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="科目选择">
          <el-select v-model="form.selectSubjects" multiple placeholder="请选择科目" :multiple-limit="3" collapse-tags>
            <el-option
              v-for="item in subjects"
              :key="item.code"
              :label="item.name"
              :value="item.code">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="分数">
          <el-input v-model="form.score" type="number"></el-input>
        </el-form-item>
        <el-form-item label="排名">
          <el-input v-model="form.rank" type="number"></el-input>
        </el-form-item>
        <el-form-item label="优先层级">
          <el-radio v-model="form.radio" label="1">学校优先</el-radio>
          <el-radio v-model="form.radio" label="2">专业优先</el-radio>
        </el-form-item>
        <el-form-item label="省份">
          <v-distpicker :province="province" only-province></v-distpicker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="tableShow = true">模拟志愿填报</el-button>
        </el-form-item>

      </el-form>
    </div>

    <el-table
      v-if="tableShow"
      :data="tableData"
      stripe
      style="width: 100%">
      <el-table-column
        prop="probability"
        label="录取概率"
      >
      </el-table-column>
      <el-table-column
        prop="schoolName"
        label="学校名称"
      >
      </el-table-column>
      <el-table-column
        prop="schoolAddress"
        label="所在地区">
      </el-table-column>
      <el-table-column
        prop="schoolType"
        label="办学类型">
      </el-table-column>
      <el-table-column
        prop="institutionType"
        label="院校类型">
      </el-table-column>
      <el-table-column
        prop="lowScore"
        label="最低分">
      </el-table-column>
      <el-table-column
        prop="lowLevel"
        label="最低位次">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="200">
        <template slot-scope="scope">
          <el-select v-model="selectedVolunteer" placeholder="请选择">
            <el-option
              v-for="item in volunteerOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import VDistpicker from 'v-distpicker'
export default {
  name: 'index',
  components: { VDistpicker },
  data () {
    return {
      tableShow: false,
      province:'北京市',
      subjects: [
        {
          code: 1,
          name: '物理'
        }, {
          code: 2,
          name: '化学'
        }, {
          code: 3,
          name: '生物'
        }, {
          code: 4,
          name: '政治'
        },
        {
          code: 5,
          name: '历史'
        }, {
          code: 6,
          name: '地理'
        }
      ],
      selectedVolunteer: '1',
      volunteerOptions: [{
        label:'第一志愿',
        value:'1'
      },{
        label:'第二志愿',
        value:'2'
      },{
        label:'第三志愿',
        value:'3'
      }],
      form: {
        selectSubjects: [],
        score: '',
        rank: '',
        radio: '1'
      },
      tableData: [{
        probability:'8%',
        schoolName:'清华大学',
        schoolAddress:'北京市',
        schoolType:'普通类',
        institutionType:'综合类',
        lowScore:'690',
        lowLevel:'100'
      }]
    }
  }
}
</script>

<style scoped lang="scss">
.select-options {
  width: 300px;
  margin-top: 30px;
}

.content {
  height: 1000px;
}
</style>
