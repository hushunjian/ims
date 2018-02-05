<template>
  <div>
    <iframe src="http://www.baidu.com" frameborder="0" title="调试页面"
    width="100%" height="100%" scrolling="no" marginheight="0" marginwidth="0"  id="myiframe"></iframe>
  </div>
</template>
<script>

export default {
  name: 'test2',
  data() {
    return {
    }
  },
  methods: {
    changeFrameHeight() {
      let ifm= document.getElementById("myiframe");
      ifm.height = document.documentElement.clientHeight - 133;
      console.log("iframe height:", ifm.height);
    },

  },
  mounted () {
    this.changeFrameHeight();
  }
}
</script>
<style scoped lang="less">
  #myiframe {
    // height: calc(85vh);
  }
</style>