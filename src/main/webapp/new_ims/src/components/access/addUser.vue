<template>
  <div class="add-user">
    <Modal v-model="modalAddUser" width="480" class="modal-user" :mask-closable="false" :closable="false">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>添加用户</span>
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
          <FormItem label="状态" prop="isValid">
            <RadioGroup v-model="formValidate.isValid">
              <Radio label="1">启用</Radio>
              <Radio label="0">禁用</Radio>
            </RadioGroup>
          </FormItem>
          <!-- <FormItem label="用户角色" prop="roleIds">
            <Select v-model="formValidate.roleIds" multiple placeholder="请选择用户角色">
              <Option v-for="item in rolesList" :value="item.id" :key="item.id">{{ item.name }}</Option>
            </Select>
          </FormItem>
          <FormItem label="用户权限" prop="featureIds">
            <div style="border-bottom: 1px solid #e9e9e9;padding-bottom:6px;margin-bottom:6px;">
              <Checkbox :indeterminate="indeterminate" :value="checkAll" @click.prevent.native="handleCheckAll">全选</Checkbox>
            </div>
            <CheckboxGroup v-model="formValidate.featureIds" @on-change="checkAllGroupChange">
              <Checkbox v-for="item in featuresList" :value="item.id" :key="item.id" :label="item.id">{{ item.name }}</Checkbox>
            </CheckboxGroup>
          </FormItem> -->
          <!-- <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">提交</Button>
            <Button type="ghost" @click="handleReset('formValidate')" style="margin-left: 8px">重置</Button>
          </FormItem> -->
        </Form>
      </div>
      <div slot="footer">
        <Button type="primary" :loading="modal_loading" @click="handleSubmit('formValidate')">确定</Button>
        <Button type="default" @click="handleReset('formValidate')">取消</Button>
      </div>
    </Modal>
    <div class="add-user-title" v-if="openUser">
      添加用户
    </div>
    <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80" class="add-user-form" v-if="openUser">
      <FormItem label="姓名" prop="userName">
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
      <FormItem label="状态" prop="isValid">
        <RadioGroup v-model="formValidate.isValid">
          <Radio label="1">启用</Radio>
          <Radio label="0">禁用</Radio>
        </RadioGroup>
      </FormItem>
      <FormItem label="用户角色" prop="roleIds">
        <Select v-model="formValidate.roleIds" multiple placeholder="请选择用户角色">
          <Option v-for="item in rolesList" :value="item.id" :key="item.id">{{ item.name }}</Option>
        </Select>
      </FormItem>
      <FormItem label="用户权限" prop="featureIds">
        <div style="border-bottom: 1px solid #e9e9e9;padding-bottom:6px;margin-bottom:6px;">
          <Checkbox :indeterminate="indeterminate" :value="checkAll" @click.prevent.native="handleCheckAll">全选</Checkbox>
        </div>
        <CheckboxGroup v-model="formValidate.featureIds" @on-change="checkAllGroupChange">
          <Checkbox v-for="item in featuresList" :value="item.id" :key="item.id" :label="item.id">{{ item.name }}</Checkbox>
        </CheckboxGroup>
      </FormItem>
      <FormItem>
        <Button type="primary" @click="handleSubmit('formValidate')">提交</Button>
        <Button type="ghost" @click="handleReset('formValidate')" style="margin-left: 8px">重置</Button>
      </FormItem>
    </Form>
  </div>
</template>
<script>
export default {
  name: 'addUser',
  data() {
    return {
      rolesList: [],
      featuresList: [],
      checkAllGroup: [],
      indeterminate: false,
      checkAll: false,
      modal_loading: false,
      openUser: false,
      modalAddUser: true,
      formValidate: {
        userName: '',
        password: '',
        mobile: '',
        sex: '',
        isValid: '',
        roleIds: [],
        featureIds: [],
        
      },
      ruleValidate: {
        userName: [
          { required: true, message: '姓名不能为空', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' }
        ],
        mobile: [
          { required: true, message: '手机号码不能为空', trigger: 'blur' }
        ],
        sex: [
          { required: true, message: '请选择性别', trigger: 'change' }
        ],
        isValid: [
          { required: true, message: '请选择状态', trigger: 'change' }
        ],
      },
      // modelRole: []
    }
  },
  // props: {
  //   modalAddUser: Boolean
  // },
  methods: {
    handleSubmit(name) {
      this.$refs[name].validate((valid) => {
        if (valid) {
          // this.$Message.success('提交成功!');
          console.log("user name:", this.formValidate);
          this.modal_loading = true;
          setTimeout(() => {
            this.modal_loading = false;
            // this.modalAddUser = false;
            this.addUser(this.formValidate);
          }, 1500)
          // this.addUser(this.formValidate);
        } else {
          this.$Message.error('表单验证失败!');
        }
      })
    },
    handleReset(name) {
      this.$refs[name].resetFields();
      this.formValidate.featureIds = [];
      this.indeterminate = false;
      this.checkAll = false;
      this.$emit("transferUser", '');
    },
    handleCheckAll() {
      if (this.indeterminate) {
        this.checkAll = false;
      } else {
        this.checkAll = !this.checkAll;
      }
      this.indeterminate = false;

      if (this.checkAll) {
        // this.featureIds = this.featuresList;
        let temData = [];
        this.featuresList.map(item => {
          this.formValidate.featureIds.push(item.id);
        })

        console.log("chack all:", this.formValidate.featureIds, this.featuresList);
      } else {
        this.formValidate.featureIds = [];
      }
    },
    checkAllGroupChange(data) {
      if (data.length === this.featuresList.length) {
        this.indeterminate = false;
        this.checkAll = true;
      } else if (data.length > 0) {
        this.indeterminate = true;
        this.checkAll = false;
      } else {
        this.indeterminate = false;
        this.checkAll = false;
      }
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
    getAllFeaturesList() {
      this.$http.get('/ims/feature/getAllFeatures', { withCredentials: true }).then(res => {
        res.data.data.map(item => {
          this.featuresList.push(item);
        })
        console.log("user featuresList:", this.featuresList);
      }, err => {
        console.log(err.data);
      })
    },
    addUser(userInfo) {
      this.$http.post('/ims/user/addUser', userInfo, { emulateJSON: true }).then(res => {
        console.log(res.data);
        this.$Message.success('添加用户成功成功!');
        this.$emit("transferUser", userInfo);
      }, err => {
        console.log(err.data);
        this.$Message.success('添加用户失败!');
      })
    }
  },
  created() {
    this.getAllRolesList();
    this.getAllFeaturesList();
  }
}

</script>
<style scoped lang="less">
.add-user {
  .add-user-title {
    background: #ffffff;
    border: 1px solid #f0f0f0;
    padding: 5px;
    margin-bottom: 10px;
    font-size: 16px;
    line-height: 24px;
  }
  .add-user-form {}
}

</style>
