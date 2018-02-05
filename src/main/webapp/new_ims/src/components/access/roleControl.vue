<template>
  <div class="role-control">
    <div class="role-table-title">
      角色列表
      <Button type="primary" class="add-role-icon" icon="plus-round" @click="add">添加</Button>
      <!-- <Button type="text" class="add-role-icon" icon="plus-round" @click="add" title="添加角色">
      </Button> -->
    </div>
    <Table refs="table1" border :columns="columns" :data="rolesList"></Table>
    <Modal v-model="modalDelRole" width="360">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>删除确认</span>
      </p>
      <div style="text-align:center">
        <p>是否确认删除此角色？</p>
        <p>{{ deleteRoleName }}</p>
      </div>
      <div slot="footer">
        <Button type="error" size="large" long :loading="modal_loading" @click="del">删除</Button>
      </div>
    </Modal>
    <Modal v-model="modalAddRole" width="360">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>{{ roleTitle }}</span>
      </p>
      <div style="text-align:center">
        <div class="role-item">
          <label for="role-name">角色名</label>
          <Input v-model="roleName" type="text" placeholder="请输入角色名" class="role-item-model" id="role-name"></Input>
        </div>
      </div>
      <div slot="footer">
        <Button type="primary" :loading="modal_loading" @click="handleSubmit">确定</Button>
        <Button type="default" @click="handleDismiss">取消</Button>
      </div>
    </Modal>
  </div>
</template>
<script>
export default {
  name: 'roleControl',
  data() {
    return {
      columns: [{
          title: '角色',
          key: 'name',
        },
        {
          title: '操作',
          key: 'action',
          // width: 150,
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
                on: {
                  click: () => {
                    this.remove(params.index)
                  }
                }
              }, '删除')
            ]);
          }
        }
      ],
      modalDelRole: false,
      modalAddRole: false,
      modal_loading: false,
      roleId: undefined,
      deleteUserIndex: undefined,
      modifyRoleIndex: undefined,
      deleteRoleName: '',
      roleName: '',
      modifyOrAddRole: '',
      rolesList: []
    }
  },
  methods: {
    getAllRolesList() {
      this.$http.get('/ims/role/getAllRoles', { withCredentials: true }).then(res => {
        res.data.data.map(item => {
          this.rolesList.push(item);
        })
        console.log("user rolesList:", this.rolesList);
      }, err => {
        console.log(err.data);
      })
    },
    modify(index) {
      console.log('user index:', index);
      this.modalAddRole = true;
      this.roleId = this.rolesList[index].id;
      this.roleName = this.rolesList[index].name;
      console.log('modify roleId:', this.roleId);
      this.modifyRoleIndex = index;
      this.modifyOrAddRole = 'modifyRole';
    },
    remove(index) {
      console.log('user index:', index);
      this.modalDelRole = true;
      this.roleId = this.rolesList[index].id;
      console.log('del roleId:', this.roleId);
      this.deleteUserIndex = index;
      this.deleteRoleName = this.rolesList[index].name;
    },
    add() {
      this.modalAddRole = true;
      this.modifyOrAddRole = 'addRole';
      this.roleName = '';
    },
    del() {
      this.modal_loading = true;
      setTimeout(() => {
        this.modal_loading = false;
        this.modalDelRole = false;
        this.deleteRole(this.roleId);
        this.$Message.success('删除成功');
        this.rolesList.splice(this.deleteUserIndex, 1);
      }, 1500);
    },
    deleteRole(roleId) {
      this.$http.post('/ims/role/deleteRole', { roleId: roleId }, { emulateJSON: true })
        .then(
          res => {
            console.log('delete role info:', res.data)
          }, err => {
            console.log(err.data)
          })
    },
    addRole(roleName) {
      this.$http.post('/ims/role/addRole', { name: roleName }, { emulateJSON: true })
        .then(
          res => {
            console.log('add role info:', res.data);
            this.$Message.success('添加成功');
            let data = {id:'', name: roleName};
            this.rolesList.push(data);
          }, err => {
            console.log(err.data)
          })
    },
    modifyRole(roleData) {
      console.log("modify role item:", roleData);
      this.$http.post('/ims/role/updateRole', roleData, { emulateJSON: true })
        .then(
          res => {
            console.log('add role info:', res.data);

            this.$Message.success('修改成功');
            this.rolesList.map(item => {
              if (item.id == roleData.id) {
                item.name = roleData.name
              }
            })
            console.log("modified role list:", this.rolesList);
          }, err => {
            console.log(err.data)
          })
    },
    handleSubmit() {
      if (!this.roleName) {
        this.$Message.error('请输入角色名!');
      } else {
        this.modal_loading = true;
        setTimeout(() => {
          this.modal_loading = false;
          this.modalAddRole = false;
          switch (this.modifyOrAddRole) {
            case 'modifyRole':
              let data = {
                id: this.roleId,
                name: this.roleName
              }
              this.modifyRole(data);
              break;
            case 'addRole':
              this.addRole(this.roleName);
              break;
          }
        }, 1500)

      }
    },
    handleDismiss() {
      this.modal_loading = false;
          this.modalAddRole = false;
    }
  },
  created() {
    this.getAllRolesList();
  },
  computed: {
    roleTitle: function() {
      console.log("role Title:", this.modifyOrAddRole);
      if (this.modifyOrAddRole === 'modifyRole') {
        return "修改角色";
      } else if (this.modifyOrAddRole === 'addRole') {
        return "添加角色";
      }
    }
  }
}

</script>
<style scoped lang="less">
.role-control {
  .role-table-title {
    background: #ffffff;
    border: 1px solid #f0f0f0;
    padding: 5px;
    margin-bottom: 10px;
    font-size: 16px;
    line-height: 24px;
    .add-role-icon {
      float: right;
      margin-right: 10px;
      padding: 0;
      width: 60px;
      // font-size: 16px;
      line-height: 24px;
    }
  }
}
.role-item {
  label {
    width: 50px;
    display: inline-block;
    text-align: right;
    verticle-align: middle;
  }
  .role-item-model {
    width: 80%;
    vertical-align: baseline;
    margin-left: 10px;
  }
}

</style>
