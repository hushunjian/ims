<template>
  <div class="user-list">
    <div class="user-table-title">
      用户列表
      <Button type="primary" class="add-user-icon" icon="plus-round" @click="add">添加</Button>
    </div>
    <Table refs="table1" border :columns="columns" :data="list"></Table>
    <Modal v-model="modal2" width="360">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>删除确认</span>
      </p>
      <div style="text-align:center">
        <p>是否确认删除此用户的信息？</p>
        <p>{{ deleteUserName }}</p>
      </div>
      <div slot="footer">
        <Button type="error" size="large" long :loading="modal_loading" @click="del">删除</Button>
      </div>
    </Modal>
    <Modal v-model="modalPassword" width="360">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>修改密码</span>
      </p>
      <div style="text-align:center">
        <div class="user-item">
          <label for="">原密码</label>
          <Input v-model="originPassword" placeholder="请输入原密码" class="user-item-model"></Input>
        </div>
        <div class="user-item">
          <label for="">新密码</label>
          <Input v-model="newPassword" placeholder="请输入新密码" class="user-item-model"></Input>
        </div>
      </div>
      <div slot="footer">
        <Button type="error" size="large" long :loading="modal_loading" @click="modifyPassword">提交</Button>
      </div>
    </Modal>
    <add-user v-if="modalAddUser" @transferUser="getUserInfo"></add-user>
    <modifyUser v-if="modalModifyUser" :userInfo="selectedUserInfo" @transferUser="setUserInfo"></modifyUser>
    <!-- <Modal v-model="modalAddUser" width="800" class="modal-user">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>{{ userTitle }}</span>
      </p>
      <div style="margin:0 10px;">
        <add-user @transferUser="getUserInfo"></add-user>
      </div>
      <div slot="footer">
        <Button type="primary" :loading="modal_loading" @click="handleSubmit">确定</Button>
        <Button type="default" :loading="modal_loading" @click="handleDismiss">取消</Button>
      </div>
    </Modal> -->
  </div>
</template>
<script>
import addUser from './addUser.vue';
import modifyUser from './modifyUser.vue';

export default {
  name: 'userList',
  components: {
    addUser,
    modifyUser
  },
  data() {
    return {
      columns: [{
          title: '时间',
          key: 'creationDate',
          sortable: true
        },

        {
          title: '姓名',
          key: 'userName'
        },

        {
          title: '状态',
          key: 'isValid',
          filters: [{
              label: '禁用',
              value: 0
            },
            {
              label: '启用',
              value: 1
            }
          ],
          filterMultiple: false,
          filterMethod(value, row) {
            if (value === 0) {
              return row.isValid === 0;
            } else if (value === 1) {
              return row.isValid === 1;
            }
          }
        },
        {
          title: '手机号',
          key: 'mobile'
        },
        {
          title: '操作',
          key: 'action',
          width: 170,
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'info',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    this.modify(params.index)
                  }
                }
              }, '修改'),
              h('Button', {
                props: {
                  type: 'error',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    this.remove(params.index)
                  }
                }
              }, '删除'),
              h('Button', {
                props: {
                  type: 'default',
                  size: 'small'
                },
                on: {
                  click: () => {
                    this.changePassword(params.index)
                  }
                }
              }, '改密'),
            ]);
          }
        }
      ],
      list: [],
      modal2: false,
      modal_loading: false,
      userId: undefined,
      deleteUserIndex: undefined,
      deleteUserName: '',
      modalAddUser: false,
      modalModifyUser: false,
      modifyOrAddUser: '',
      modalPassword: false,
      selectedUserInfo: {},
      originPassword: undefined,
      newPassword: undefined
    }
  },
  created() {
    this.getUserList()
  },
  methods: {
    getUserInfo(msg) {
      console.log('Get userInfo:', msg);
      this.modalAddUser = false;
      if (msg) {
        this.list.push(msg);
      }
    },
    setUserInfo(msg) {
      console.log('set userInfo:', msg);
      this.modalModifyUser = false;
      if (msg) {
        // this.list.push(msg);
      }
    },
    getUserList() {
      let userList = [];
      this.$http.get('/ims/user/getAllUsers', { withCredentials: true }).then(
        (res) => {
          // console.log("res.data:", res.data, res.data.data);
          if (res.data.code == 200) {
            res.data.data.map(item => {
              item.creationDate = this.formateDate(item.creationDate);
              userList.push(item);
            });
            this.list = userList;
            console.log("userList data:", this.list, userList);
          } else if (res.data.code == 5003) {
            this.$Message.error('没有权限访问!');
            this.$router.push({ name: 'error_401' });
          } else {
            this.$Message.error("未知错误");
          }
        }, err => {
          console.log(err.data);
        });
      console.log("user data1:", this.userList);
    },
    formateDate(data) {
      let date = new Date(data);
      let year = date.getFullYear();
      let month = date.getMonth() < 9 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1;
      let day = date.getDate() < 9 ? '0' + (date.getDate() + 1) : date.getDate() + 1;
      return `${year}-${month}-${day}`
    },
    modify(index) {
      this.$Modal.remove();
      console.log('user index:', index);
      let userId = this.list[index].id;
      this.modalModifyUser = true;
      this.selectedUserInfo = this.list[index];
      console.log("modify userInfo:", this.selectedUserInfo);
    },
    remove(index) {
      console.log('user index:', index);
      this.modal2 = true;
      this.userId = this.list[index].id;
      console.log('del userId:', this.userId, this.list[index]);
      this.deleteUserIndex = index;
      this.deleteUserName = this.list[index].userName;
    },
    changePassword(index) {
      console.log('user index:', index);
      this.modalPassword = true;
      this.userId = this.list[index].id;
      console.log('modify user Password:', this.userId, this.list[index]);
    },
    del() {
      this.modal_loading = true;
      setTimeout(() => {
        this.modal_loading = false;
        this.modal2 = false;
        this.deleteUser(this.userId);
        this.$Message.success('删除成功');
        this.list.splice(this.deleteUserIndex, 1);
      }, 1500);
    },
    modifyPassword() {
      if (!this.originPassword && !this.newPassword) {
        this.$Message.error('请重新输入!');
      } else {
        let data = {
          userId: this.userId,
          password: this.originPassword,
          newPassword: this.newPassword
        };
        this.$http.post('/ims/modifyPassword', data, { emulateJSON: true })
        .then(
          res => {
            console.log('delete info:', res.data);
            if (res.data.code == 200) {
              this.$Message.error('修改密码成功');
              this.modalPassword = false;
            } else {
              this.$Message.error(res.data.desc);
            }
          }, err => {
            console.log(err.data)
          })
      }
    },
    deleteUser(userId) {
      this.$http.post('/ims/user/deleteUser', { userId: userId }, { emulateJSON: true })
        .then(
          res => {
            console.log('delete info:', res.data)
          }, err => {
            console.log(err.data)
          })
    },
    add() {
      this.$Modal.remove();
      console.log("add user");
      this.modalAddUser = true;
      this.modifyOrAddUser = 'addUser';
    },
  },
  computed: {
  }
}

</script>
<style scoped lang="less">
.user-list {
  .user-table-title {
    background: #ffffff;
    border: 1px solid #f0f0f0;
    padding: 5px;
    margin-bottom: 10px;
    font-size: 16px;
    line-height: 24px;
    .add-user-icon {
      float: right;
      margin-right: 10px;
      padding: 0;
      width: 60px;
      line-height: 24px;
    }
  }
}
.modal-user {
  .ivu-modal {
    height: 80vh;
    overflow: hidden;
    overflow-y: auto;
  }
}

.user-item {
  margin-bottom: 20px;
  label {
        width: 80px;
    display: inline-block;
  }
  .user-item-model {
    width: 70%;
  }
}

</style>
