<template>
  <div class="main" :class="{'main-hide-text': hideMenuText}">
    <div :span="spanLeft" class="main-menu-left scroll-wrap" :style="{width: hideMenuText?'60px':'220px', overflow: hideMenuText ? 'visible' : 'auto'}">
      <div class="main-logo-left">
        <span v-show="!hideMenuText">拙心网络CMS</span>
        <!-- <span v-show="hideMenuText" :class="{'shrink-text': hideMenuText}">ZX</span> -->
        <img v-show="hideMenuText" src="../assets/images/logo.png" key="min-logo" />
      </div>
      <sidebar-menu v-if="!hideMenuText" :menuList="menuList" :iconSize="14" />
      <sidebar-menu-shrink :icon-color="menuIconColor" v-else :menuList="menuList"></sidebar-menu-shrink>
    </div>
    <div :span="spanRight" class="main-body">
      <div class="main-header" :style="{left: hideMenuText?'60px':'220px'}">
        <div class="main-header-icon">
          <Button type="text" @click="toggleClick">
            <Icon type="navicon" size="32"></Icon>
          </Button>
        </div>
        <div class="main-header-middle">
          <div class="main-breadcrumb">
            <!-- <Breadcrumb>
              <BreadcrumbItem href="#">首页</BreadcrumbItem>
              <BreadcrumbItem href="#">应用中心</BreadcrumbItem>
              <BreadcrumbItem :currentPath="currentPath">权限管理</BreadcrumbItem>
              <BreadcrumbItem :currentPath="currentPath"></BreadcrumbItem>
            </Breadcrumb> -->
          </div>
        </div>
        <div class="main-header-user">
          <Dropdown style="margin-left: 20px; height: 40px; vertical-align: middle;" @on-click="handleUserDrop">
            <a href="javascript:void(0)">
            {{ userName }}
            <Icon type="arrow-down-b"></Icon>
            </a>
            <DropdownMenu slot="list">
              <DropdownItem name="userCenter">个人中心</DropdownItem>
              <DropdownItem name="loginOut">退出</DropdownItem>
            </DropdownMenu>
          </Dropdown>
          <Avatar class="user-avatar" src="https://i.loli.net/2017/08/21/599a521472424.jpg" />
          <!-- <Modal v-model="modalOpen" width="480" class="modal-user">
            <p slot="header" style="color:#f60;text-align:center">
              <Icon type="information-circled"></Icon>
              <span>个人中心</span>
            </p>
            <div style="margin:0 10px;">
              <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80" class="add-user-form">
                <FormItem label="姓名" prop="userName" class="form-item-format">
                  <Input v-model="formValidate.userName" placeholder="请输入姓名"></Input>
                </FormItem>
                <FormItem label="密码" prop="password">
                  <Input v-model="formValidate.password" placeholder="请输入密码"></Input>
                </FormItem>
                <FormItem label="手机" prop="mobile">
                  <Input v-model="formValidate.mobile" placeholder="请输入手机号码"></Input>
                </FormItem>
                <FormItem label="性别" prop="sex">
                  <RadioGroup v-model="formValidate.sex">
                    <Radio label="0">男</Radio>
                    <Radio label="1">女</Radio>
                  </RadioGroup>
                </FormItem>
              </Form>
            </div>
            <div slot="footer">
              <Button type="primary" :loading="modal_loading" @click="handleSubmit('formValidate')">确定</Button>
              <Button type="default" @click="handleReset('formValidate')">取消</Button>
            </div>
          </Modal> -->
        </div>
      </div>
      <div class="main-content" :style="{left: hideMenuText?'60px':'220px'}">
        <div class="main-content-main">
          <!-- 内容区域 -->
          <router-view></router-view>
        </div>
        <div class="main-copy">
          2014-2016 © 拙心（上海）网络科技有限公司
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import sidebarMenu from './sidebarMenu.vue';
import sidebarMenuShrink from './sidebarMenuShrink.vue';
import appRouter from '../router';

// const menu = {
//   menuList: appRouter
// };
// console.log("menu info:", menu.menuList);

export default {
  name: 'home',
  components: {
    sidebarMenu,
    sidebarMenuShrink
  },
  data() {
    return {
      spanLeft: 5,
      spanRight: 19,
      hideMenuText: false,
      theme2: 'dark',
      modalOpen: false
      // menuList: appRouter,
    }
  },
  computed: {
    menuList() {
      console.log("test data:", this.$router.options.routes);
      let temRoute = this.$router.options.routes.filter(item => item.hasOwnProperty('sn'));
      console.log('menulist detect:',temRoute);
      let menuList = [].concat(JSON.parse(JSON.stringify(temRoute)));
      let permissions = JSON.parse(localStorage.getItem('permissions'));
      menuList.map(item => {
        permissions.map(res => {
          if (res == item.sn) {
            item.permission = true;
          }
          if (item.hasOwnProperty('children')) {
            item.children.map(tem => {
              if (tem.sn == res) {
                tem.permission = true;
              }
            })
          }
        })
      })
      console.log("user permissions:", permissions, menuList);
      return menuList;
    },
    currentPath() {
      console.log("currentRouter name:", this.$router, this.$router.currentRoute);
      return this.$router.currentRoute.name;
    },
    userName() {
      let user = JSON.parse(localStorage.getItem('userName'));
      return user;
    },
    menuIconColor() {
      return 'white';
    },
  },
  methods: {
    toggleClick() {
      this.hideMenuText = !this.hideMenuText;
    },
    handleUserDrop(name) {
      console.log("user logout");
      if (name === "loginOut") {
        localStorage.clear();
        this.$router.push({ name: 'login' });
      }
    }
  },

}

</script>
<style scoped lang="less">
@import "../main.less";

</style>
