<template>
  <div class="content">
    <div class="content-title">排行榜</div>
    <el-table
      :data="tableData"
      style="width: 100%"
    >
      <el-table-column
        prop="softRank"
        label="排名"
      >
      </el-table-column>
      <el-table-column
        prop="schName"
        label="名称"
      >
      </el-table-column>
      <el-table-column
        prop="schAddress"
        label="地址"
      >
      </el-table-column>
      <el-table-column
        prop="schTags"
        width="400"
        label="标签">
      </el-table-column>

      <el-table-column
        prop="schTags"
        label="详细信息">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="primary">查看详细信息</el-button>
        </template>
      </el-table-column>
    </el-table>

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

</template>

<script>
import { getSchoolRanking } from '@/api/schoolInfo'

export default {
  name: 'index',
  data () {
    return {
      pageNo: 1,
      tableData: [],
      page: {
        total: 0,
        currentPage: 1
      }
    }
  },
  created () {
    this.getSchoolRanking()
  },

  methods: {
    async getSchoolRanking () {
      let params = {
        pageNo: this.page.currentPage
      }
      const { data } = await getSchoolRanking(params)
      this.tableData = data.list
      this.page.total = data.total
    },

    async currentChange (currentPage) {
      this.page.currentPage = currentPage
      this.getSchoolRanking()
    },

    handleClick (row) {
      this.$router.push({
        path: '/findSchoolToOne',
        query: { id: row.id }
      })
    }
  }
}
</script>

<style scoped lang="scss">
.content-title {
  text-align: center;
  font-weight: 200;
  font-size: 50px;
  margin: 20px 0;
}

.pagination {
  text-align: center;
}
</style>
