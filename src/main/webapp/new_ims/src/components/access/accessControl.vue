<template>
  <div class="access-control">
    <div class="access-control-title">
      权限分配
    </div>
    <Tabs type="card" class="access-control-content">
      <TabPane label="角色权限">
        <div class="access-item">
          <div class="access-item-left">
            <p>角色列表
            </p>
            <ul>
              <li v-for="(item, index) in rolesList" v-bind:class="{active: index1 === index }" @click="chooseItem(item, index, 'role')">{{ item.name }}</li>
            </ul>
          </div>
          <div class="access-item-right">
            <div class="access-item-right-control">
              <p>角色权限</p>
              <Tree :data="formatedFeaturesList" show-checkbox multiple class="tree-format"></Tree>
            </div>
            <Button type="primary" @click="handleRoleFeature">保存角色权限</Button>
          </div>
        </div>
      </TabPane>
      <TabPane label="用户角色">
        <div class="access-item">
          <div class="access-item-left">
            <p>用户列表</p>
            <ul>
              <li v-for="(item, index) in usersList" v-bind:class="{active: index2 === index }" @click="chooseItem(item, index, 'user')">{{ item.userName }}</li>
            </ul>
          </div>
          <div class="access-item-right">
            <div class="access-item-right-control">
              <p>用户角色</p>
              <!-- <Select v-model="model10" multiple style="width:280px">
                <Option v-for="item in rolesList" :value="item.id" :key="item.id">{{ item.name }}</Option>
              </Select> -->
              <CheckboxGroup v-model="model10" class="role-checkbox">
                <Checkbox v-for="item in rolesList" :value="item.id" :key="item.id" :label="item.id">{{ item.name }}</Checkbox>
              </CheckboxGroup>
            </div>
            <Button type="primary" @click="handleUserRole" class="user-button">保存用户角色</Button>
            <!-- <Tree :data="data2" show-checkbox multiple></Tree> -->
          </div>
          <!-- <div class="access-user-feature">
            <div class="access-user-feature-control">
              <p>用户权限</p>
              <Button type="primary" @click="handleUserFeature">保存用户权限</Button>
            </div>
            <Tree :data="formatedFeaturesList" show-checkbox multiple></Tree>
          </div> -->
        </div>
      </TabPane>
      <TabPane label="用户权限">
        <div class="access-item">
          <div class="access-item-left">
            <p>用户列表</p>
            <ul>
              <li v-for="(item, index) in usersList" v-bind:class="{active: index2 === index }" @click="chooseItem(item, index, 'user')">{{ item.userName }}</li>
            </ul>
          </div>
          <div class="access-item-right">
            <div class="access-item-right-control">
              <p>用户权限</p>
              <Tree :data="formatedUserFeaturesList" show-checkbox multiple class="tree-format"></Tree>
            </div>
            <Button type="primary" @click="handleUserFeature">保存用户权限</Button>
          </div>
        </div>
      </TabPane>
      <!-- <TabPane label="角色管理">
        <div class="access-item">
          <role-control :roleList="rolesList"></role-control>
        </div>
      </TabPane>
      <TabPane label="权限管理">
        <div class="access-item">
          <feature-control :featuresList="featuresList"></feature-control>
        </div>
      </TabPane> -->
    </Tabs>

  </div>
</template>
<script>
import roleControl from './roleControl.vue';
import featureControl from './featureControl.vue';

export default {
  name: 'accessControl',
  components: {
    roleControl,
    featureControl
  },
  data() {
    return {
      featuresList: [],
      rolesList: [],
      usersList: [],
      index1: -1,
      index2: -1,
      data1: [],
      data2: [],
      data3: [],
      model10: [],
      selectedUserId: undefined,
      selectedFeatureId: undefined,
      formatedFeaturesList: [],
      formatedUserFeaturesList: [],
      originFeaturesList: [],
      modalOpen: false,
      roleName: ''
    }
  },
  methods: {
    getAllFeaturesList() {
      this.$http.get('/ims/feature/getAllFeatures', { withCredentials: true }).then(res => {
        res.data.data.map(item => {
          this.featuresList.push(item);
        })
        console.log("user featuresList:", this.featuresList);
        let subData = this.featuresList.filter(item => item.hasOwnProperty('pid') === false);
        console.log("sub features:", subData);
        let treeData = [];
        subData.map(item => {
          let parentData = Object.assign({}, { title: item.name }, { expand: false }, { selected: false }, { checked: false }, { children: [] }, { id: item.id });
          treeData.push(parentData);
        });
        console.log("tree data par:", treeData);
        treeData.map(item => {
          this.featuresList.map(res => {
            if (res.hasOwnProperty('pid') && res.pid == item.id) {
              let childData = Object.assign({}, { title: res.name }, { disabled: false }, { checked: false }, { pid: res.pid }, { id: res.id });
              item.children.push(childData);
            }
          })
        })
        console.log("tree data par-chil:", treeData);
        this.formatedFeaturesList = treeData;
        this.formatedUserFeaturesList = treeData;
        // 对象数组深拷贝
        this.originFeaturesList = [].concat(JSON.parse(JSON.stringify(treeData)));
      }, err => {
        console.log(err.data);
      })
    },
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
    getAllUsersList() {
      this.$http.get('/ims/user/getAllUsers', { withCredentials: true }).then(
        (res) => {
          // console.log("res.data:", res.data, res.data.data);
          res.data.data.map(item => {
            this.usersList.push(item);
          });
          console.log("userList data:", this.usersList);
        }, err => {
          console.log(err.data);
        });
    },
    chooseItem(item, index, type) {
      console.log("check info:", type, item, index);
      switch (type) {
        case 'role':
          this.index1 = index;
          this.selectedFeatureId = item.id;
          this.getRoleFeatures(item.id);
          break;
        case 'user':
          // this.isChecked = true;
          this.index2 = index;
          this.selectedUserId = item.id;
          this.getUserRole(item.id);
          this.getUserFeature(item.id);
          break;
      }

    },
    handleRoleFeature() {
      console.log("update roleFeatures:", this.formatedFeaturesList);
      let temData = [];
      this.formatedFeaturesList.map(item => {
        // if (item.selected == true) {
        //   temData.push(item.id);
        // }
        if (item.children.length > 0) {
          item.children.map(res => {
            if (res.checked == true) {
              temData.push(res.id);
            } else {
              // res.selected = false;
            }
          })
          let tem = item.children.filter(a => a.checked == true);
          if (tem.length>0) {
            temData.push(item.id);
          }
        } else {
          if (item.checked == true) {
            temData.push(item.id);
          }
        }
      })
      this.updateRoleFeatures(temData);
    },
    handleUserRole() {
      console.log("update userRole:", this.model10);
      this.updateUserRole();
    },
    handleUserFeature() {
      console.log("update roleFeatures:", this.formatedUserFeaturesList);
      let temData = [];
      this.formatedUserFeaturesList.map(item => {
        // if (item.selected == true) {
        //   temData.push(item.id);
        // }
        if (item.children.length > 0) {
          item.children.map(res => {
            if (res.checked == true) {
              temData.push(res.id);
            } else {
              // res.selected = false;
            }

          })
          let tem = item.children.filter(a => a.checked == true);
          if (tem.length>0) {
            temData.push(item.id);
          }
        } else {
          if (item.checked == true) {
            temData.push(item.id);
          }
        }
      })
      this.updateUserFeatures(temData);
    },
    addRole(roleName) {
      this.$http.post('/ims/role/addRole', { name: roleName }, { emulateJSON: true }).then(res => {
        console.log(res.data);
        this.$Message.success('添加角色成功!');
      }, err => {
        console.log(err.data);
        this.$Message.success('添加角色失败!');
      })
    },
    getUserRole(userId) {
      this.$http.get(`/ims/user/getUserRoles?userId=${userId}`, { withCredentials: true }, { emulateJSON: true }).then(res => {
        let arr = [];
        console.log("user-role:", res.data, this.model10);
        res.data.data.map(item => {
          arr.push(item.id);
        })
        this.model10 = arr;
        console.log("user-role:", this.model10);
      }, err => {
        console.log(err.data);
      })
    },
    updateUserRole() {
      let data = {
        userId: this.selectedUserId,
        roleIds: this.model10.toString()
      }
      this.$http.post('/ims/user/coverUserRoles', data, { emulateJSON: true }).then(res => {
        console.log(res.data);
        this.$Message.success('修改用户角色成功!');
      }, err => {
        console.log(err.data);
        this.$Message.success('修改用户角色失败!');
      })
    },
    getRoleFeatures(roleId) {
      console.log("origin role features:", this.formatedFeaturesList, this.originFeaturesList);
      let temData = [].concat(JSON.parse(JSON.stringify(this.originFeaturesList)));
      this.$http.get(`/ims/role/getRoleFeatures?roleId=${roleId}`, { withCredentials: true }, { emulateJSON: true }).then(res => {
        console.log("role features:", res.data, this.formatedFeaturesList);
        res.data.data.map(item => {
          temData.map(res => {
            // if (res.id == item.id) {
            //   res.selected = true;
            // }
            if (res.children.length > 0) {
              res.children.map(params => {
                if (params.pid == item.pid && params.id == item.id) {
                  params.checked = true;
                  // params.selected = true;
                }
              })
            } else {
              if (res.id == item.id) {
                res.checked = true;
                // res.selected = true;
              }
            }

          })
        })
        this.formatedFeaturesList = temData;
        console.log('changed role Features:', this.formatedFeaturesList);
      }, err => {
        console.log(err.data);
      })
    },
    updateRoleFeatures(temData) {
      let data = {
        roleId: this.selectedFeatureId,
        featureIds: temData.toString()
      }
      console.log("update role Features:", data);
      this.$http.post('/ims/role/coverRoleFeatures', data, { emulateJSON: true }).then(res => {
        console.log(res.data);
        this.$Message.success('修改角色权限成功!');
      }, err => {
        console.log(err.data);
        this.$Message.success('修改角色权限失败!');
      })
    },
    getUserFeature(userId) {
      let temData = [].concat(JSON.parse(JSON.stringify(this.originFeaturesList)));
      this.$http.get(`/ims/user/getUserFeatures?userId=${userId}`, { withCredentials: true }, { emulateJSON: true }).then(res => {
        console.log("user features:", res.data, this.formatedUserFeaturesList);
        res.data.data.map(item => {
          temData.map(res => {
            // if (res.id == item.id) {
            //   res.selected = true;
            // }
            if (res.children.length > 0) {
              res.children.map(params => {
                if (params.pid == item.pid && params.id == item.id) {
                  params.checked = true;
                  // params.selected = true;
                }
              })
            } else {
              if (res.id == item.id) {
                res.checked = true;
                // res.selected = true;
              }
            }

          })
        })
        this.formatedUserFeaturesList = temData;
        console.log('changed role Features:', this.formatedUserFeaturesList);
      }, err => {
        console.log(err.data);
      })
    },
    updateUserFeatures(temData) {
      let data = {
        userId: this.selectedUserId,
        featureIds: temData.toString()
      }
      console.log("update role Features:", data);
      this.$http.post('/ims/user/coverUserFeatures', data, { emulateJSON: true }).then(res => {
        console.log(res.data);
        this.$Message.success('修改角色权限成功!');
      }, err => {
        console.log(err.data);
        this.$Message.success('修改角色权限失败!');
      })
    },
    handleSubmit() {
      if (this.roleName) {
        this.addRole(this.roleName);
      } else {
        this.$Message.error('请重新输入角色名!');
      }
    },
    handleReset(name) {
      
    },
  },

  created() {
    this.getAllRolesList();
    this.getAllFeaturesList();
    this.getAllUsersList()
  }
}

</script>
<style scoped lang="less">
.access-control {
  width: 100%;
  height: 100%;
  .access-control-title {
    background: #ffffff;
    border: 1px solid #f0f0f0;
    padding: 5px;
    margin-bottom: 10px;
    font-size: 16px;
    line-height: 24px;
  }
  .access-control-content {
    display: flex;
    flex-flow: column;
    height: 100%;
    .access-item {
      flex: 1;
      display: flex;
      flex-flow: row;
      height: 50%; // border-bottom: 2px solid #464c5b63;
      .access-item-left {
        width: 200px;
        margin-right: 20px;
        margin-left: 5px;
      }
      .access-item-right {
        display: flex;
        flex-flow: row;
        align-items: start;
        .access-item-right-control {
          margin: 0 50px; // text-align: center;
        }
        .tree-format {
          background: white;
          overflow-y: auto;
          width: 240px;
          padding: 0 15px;
          ul li {
            margin: 2px 0 !important;
          }
        }
      }
    }
  }
  p {
    margin-bottom: 10px;
    font-size: 16px;
  }
  ul {
    height: 300px;
    overflow: hidden;
    background: #fff;
    border: 1px solid #aeb0b6;
    border-radius: 4px;
    overflow-y: auto;
    li {
      padding: 5px 10px;
      cursor: pointer;
    }
  }
  .role-checkbox {
    width: 240px;
    background: white;
    padding: 10px;
    label {
      width: 65%;
    }
  }
  .active {
    background: #f0f0f0;
  }
  .ivu-tree ul li {
    margin: 2px 0 !important;
  }
}

</style>
