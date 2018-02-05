<template>
  <Menu ref="left_menu" :theme="theme2" width="auto" active-name="currentPage" :open-names="openedSubmenuArr" accordion @on-select="changeMenu">
    <template v-for="item in menuList">
      <div v-if="item.permission">
        <MenuItem v-if="item.children.length<1" :name="item.name" :key="item.path">
        <Icon :type="item.icon" :size="iconSize" :key="item.path"></Icon>
        <span class="layout-text" :key="item.path">{{ item.title }}</span>
        </MenuItem>
        <Submenu v-if="item.children.length>=1" :name="item.name" :key="item.path">
          <template slot="title">
            <Icon :type="item.icon" :size="iconSize"></Icon>
            <span class="layout-text">{{ item.title }}</span>
          </template>
          <template v-for="child in item.children">
            <MenuItem :name="child.name" :key="child.name" v-if="child.permission" class="left-menu-item">
            <Icon :type="child.icon" :size="12" :key="child.name"></Icon>
            <span class="layout-text-child" :key="child.name">{{ child.title }}</span>
            </MenuItem>
          </template>
        </Submenu>
      </div>
    </template>
  </Menu>
</template>
<script>
export default {
  name: 'sidebarMenu',
  data() {
    return {
      theme2: 'dark',
      currentPage: this.$router.name,
      openedSubmenuArr: [],
      isActive: false
    }
  },
  props: {
    iconSize: Number,
    menuList: Array
  },
  methods: {
    changeMenu(active) {
      console.log("Menu active:", active, this.$router);
      // console.log(this.menuList);
      this.$router.push({
        name: active
      })
    },
  },
  watch: {
    '$route' (to) {
      this.currentPage = to.name;
      let parPage = to.matched[0].name;
      this.openedSubmenuArr = [].concat(parPage);
      // console.log('change route:', to, this.currentPage, this.openedSubmenuArr);
    },
  },
  created() {
    // 路由跳转/刷新网页时导航菜单自动展开
    console.log("router detect:", this.$route);
    this.currentPage = this.$route.name;
    if (this.$route.fullPath.match(/^\/(.*)\//)) {
      let path = this.$route.fullPath.match(/^\/(.*)\//)[1];
      this.openedSubmenuArr = [].concat(path);
    }
    this.$nextTick(() => {
      this.$refs.left_menu.updateOpened();
      this.$refs.left_menu.updateActiveName();
    });
  }
}

</script>
<style scoped lang="less">
.layout-text-child {
  font-size: 12px;
}

.left-menu-item {
  padding-left: 30px !important;
}

.left-menu-item-selected {
  border-right: none;
  color: #fff;
  background: #2d8cf0 !important;
}

</style>
