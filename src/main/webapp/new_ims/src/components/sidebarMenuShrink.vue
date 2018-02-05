<template>
  <div>
    <template v-for="(item, index) in menuList">
      <div style="text-align: center;" :key="index" v-if="item.permission">
        <Dropdown transfer v-if="item.children.length >= 1" placement="right-start" :key="index" @on-click="changeMenu">
          <Button style="width: 70px;margin-left: -5px;padding:10px 0;" type="text" :title="item.title">
            <Icon :size="20" :color="iconColor" :type="item.icon"></Icon>
          </Button>
          <DropdownMenu style="width: 200px;" slot="list">
            <template v-for="child in item.children">
              <DropdownItem :name="child.name" :key="child.title" v-if="child.permission">
                <Icon :type="child.icon"></Icon><span style="padding-left:10px;">{{ child.title }}</span></DropdownItem>
            </template>
          </DropdownMenu>
        </Dropdown>
        <Dropdown transfer v-else placement="right-start" :key="index" @on-click="changeMenu">
          <Button @click="changeMenu(item.name)" style="width: 70px;margin-left: -5px;padding:10px 0;" type="text" :title="item.title">
            <Icon :size="20" :color="iconColor" :type="item.icon"></Icon>
          </Button>
          <DropdownMenu style="width: 200px;" slot="list">
            <DropdownItem :name="item.name" :key="item.title">
              <Icon :type="item.icon"></Icon><span style="padding-left:10px;">{{ item.title }}</span></DropdownItem>
          </DropdownMenu>
        </Dropdown>
      </div>
    </template>
  </div>
</template>
<script>
export default {
  name: 'sidebarMenuShrink',
  data() {
    return {
      theme2: 'dark',
      currentPage: this.$router.name,
      openedSubmenuArr: []
    }
  },
  props: {
    iconColor: String,
    menuList: Array
  },
  methods: {
    changeMenu(active) {
      console.log("Menu active:", active, this.$router);
      // console.log(this.menuList);
      this.$router.push({
        name: active
      })
    }
  },
  watch: {
    '$route' (to) {
      this.currentPage = to.name;
      // let path = to.path.match(/^\/(.*)\/.*/)[1];
      // this.openedSubmenuArr = [...path];
      // // let openPath = this.$router.path.match(/^\/(.*)\/.*/)[1];
      // console.log("active route:", this.currentPage, path, this.$router,to)
    },
  },
}

</script>
<style scoped lang="less">
.layout-text-child {
  font-size: 12px;
}

.left-menu-item {
  padding-left: 30px !important;
}

</style>
