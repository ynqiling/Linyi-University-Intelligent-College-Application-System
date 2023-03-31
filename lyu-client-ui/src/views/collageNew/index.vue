<template>
  <div class="content">
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
  </div>

</template>

<script>
export default {
  name: 'index',
}
</script>

<style scoped lang="scss">
.content {
  height: 600px;
}
.popular-content {
  margin-top: 30px;
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
