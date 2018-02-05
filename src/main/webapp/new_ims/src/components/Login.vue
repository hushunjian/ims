<template>
  <div>
    <Form ref="formCustom" :model="formCustom" :rules="ruleCustom" :label-width="60" class="login-wrap">
      <h3 class="title">拙心网络</h3>
      <FormItem label="账号" prop="userName">
        <Input type="text" v-model="formCustom.userName" size="large"></Input>
      </FormItem>
      <FormItem label="密码" prop="password">
        <Input type="password" v-model="formCustom.password" long></Input>
      </FormItem>
      <Button type="primary" @click="handleSubmit" :loading="modal_loading" style="width:100%">登录</Button>
      <!-- <FormItem>
        <Button type="primary" @click="handleSubmit('formCustom')" style="width:100%">登录</Button>
        <Button type="ghost" @click="handleReset('formCustom')" style="margin-left: 8px">重置</Button>
      </FormItem> -->
    </Form>
  </div>
</template>
<script>
export default {
  name: 'login',
  data() {
    return {
      formCustom: {
        userName: '',
        password: '',
      },
      ruleCustom: {
        userName: [
          { required: true, message: '账号不能为空', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' }
        ]
      },
      modal_loading: false
    }
  },
  methods: {
    handleSubmit() {
      this.$refs.formCustom.validate((valid) => {
        if (valid) {
          console.log("login information valid");
          let userInfo = {
            userName: this.formCustom.userName,
            password: this.formCustom.password
          }
          this.modal_loading = true;
          setTimeout(() => {
            this.$http.post('/ims/login', userInfo, { emulateJSON: true }).then(
              res => {
                console.log("login info:", res.data);
                if (res.data.code == 200) {
                  localStorage.setItem('permissions', JSON.stringify(res.data.data.permissions));
                  localStorage.setItem('userName', JSON.stringify(res.data.data.user.userName));
                  this.$Message.success('登录成功!');
                  this.modal_loading = false;
                  this.$router.push({ path: '/' });
                } else {
                  this.$Message.error('登录失败，请重新登录');
                  this.modal_loading = false;
                }
              }, err => {
                console.log("login err", err.data);
                this.$Message.error('登录失败!');
              });
          }, 500)
        } else {
          this.$Message.error('请重新输入!');
        }
      })
    },
    handleReset(name) {
      this.$refs[name].resetFields()
    }
  }
}

</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
.login-wrap {
  border-radius: 5px;
  -moz-border-radius: 5px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
  .title {
    margin: 0px auto 30px auto;
    font-size: 20px;
    font-weight: 600;
    text-align: center;
    color: #505458;
  }
  label {
    text-align: left !important;
    font-size: 16px !important;
  }
  .ivu-form .ivu-form-item-label {
    text-align: left;
    font-size: 16px;
  }
}

</style>
