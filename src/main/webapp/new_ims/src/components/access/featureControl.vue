<template>
  <div class="feature-control">
    <div class="feature-table-title">
      权限列表
      <Button type="primary" class="add-feature-icon" icon="plus-round" @click="add">添加</Button>
      <!-- <Button type="text" class="add-feature-icon" icon="plus-round" @click="add" title="添加权限"> -->
      </Button>
    </div>
    <Table refs="table2" border :columns="columns" :data="featuresList"></Table>
    <Modal v-model="modalDelfeature" width="360">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>删除确认</span>
      </p>
      <div style="text-align:center">
        <p>是否确认删除此权限？</p>
        <p>{{ deletefeatureName }}</p>
      </div>
      <div slot="footer">
        <Button type="error" size="large" long :loading="modal_loading" @click="del">删除</Button>
      </div>
    </Modal>
    <Modal v-model="modalAddfeature" width="400">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>{{ featureTitle }}</span>
      </p>
      <div style="text-align:center;margin:0 10px;">
        <div class="feature-item">
          <label for="feature-name">权限名</label>
          <Input v-model="featureName" placeholder="请输入权限名" class="feature-item-model" id="feature-name"></Input>
        </div>
        <div class="feature-item">
          <label for="">父权限</label>
          <Select v-model="pid" style="width:80%;text-align:left;vertical-align:middle;" class="feature-item-model">
            <Option v-for="item in parentFeatureList" :value="item.id" :key="item.id">{{ item.name }}</Option>
          </Select>
        </div>
        <div class="feature-item">
          <label for="feature-sn">权限标识</label>
          <Input v-model="featureSn" type="text" placeholder="请输入权限标识(大写字母)" class="feature-item-model" id="feature-sn"></Input>
        </div>
        <div class="feature-item">
          <label for="feature-sn">权限排序</label>
          <Input v-model="featureOrderNumber" type="text" placeholder="请输入权限序号(数字)" class="feature-item-model" id="feature-sn"></Input>
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
  name: 'featureControl',
  data() {
    return {
      columns: [{
          title: '权限',
          key: 'name',
        }, {
          title: '父级Id',
          key: 'pid'
        }, {
          title: '权限标识',
          key: 'sn'
        }, {
          title: '排序',
          key: 'orderNumber'
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
      modalDelfeature: false,
      modalAddfeature: false,
      modal_loading: false,
      featureId: undefined,
      deleteFeatureIndex: undefined,
      modifyfeatureIndex: undefined,
      deletefeatureName: '',
      featureName: '',
      modifyOrAddfeature: '',
      featureSn: '',
      pid: '',
      featureOrderNumber: '',
      featuresList: []
    }
  },
  methods: {
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
    modify(index) {
      console.log('user index:', index);
      this.modalAddfeature = true;
      this.featureId = this.featuresList[index].id;
      this.featureName = this.featuresList[index].name;
      this.pid = this.featuresList[index].pid;
      this.featureSn = this.featuresList[index].sn;
      this.featureOrderNumber = this.featuresList[index].orderNumber;
      console.log('modify featureId:', this.featureId);
      this.modifyfeatureIndex = index;
      this.modifyOrAddfeature = 'modifyfeature';
    },
    remove(index) {
      console.log('user index:', index);
      this.modalDelfeature = true;
      this.featureId = this.featuresList[index].id;
      console.log('del featureId:', this.featureId);
      this.deleteFeatureIndex = index;
      this.deletefeatureName = this.featuresList[index].name;
    },
    add() {
      this.modalAddfeature = true;
      this.modifyOrAddfeature = 'addfeature';
      this.featureName = '';
      this.pid = '';
      this.featureSn = '';
      this.featureOrderNumber = '';
    },
    del() {
      this.modal_loading = true;
      setTimeout(() => {
        this.modal_loading = false;
        this.modalDelfeature = false;
        this.deletefeature(this.featureId);

      }, 1500);
    },
    deletefeature(featureId) {
      this.$http.post('/ims/feature/deleteFeature', { featureId: featureId }, { emulateJSON: true })
        .then(
          res => {
            console.log('delete feature info:', res.data);
            this.$Message.success('删除成功');
            this.featuresList.splice(this.deleteFeatureIndex, 1);
          }, err => {
            console.log(err.data)
          })
    },
    addfeature(featureData) {
      console.log('add feature item:', featureData)
      this.$http.post('/ims/feature/addFeature', featureData, { emulateJSON: true })
        .then(
          res => {
            console.log('add feature info:', res.data);
            this.$Message.success('添加成功');
            let temData = Object.assign({}, { id: '' }, featureData)
            this.featuresList.push(temData);
          }, err => {
            console.log(err.data)
          })
    },
    modifyfeature(featureData) {
      console.log("modify feature item:", featureData);
      this.$http.post('/ims/feature/modifyFeature', featureData, { emulateJSON: true })
        .then(
          res => {
            console.log('add feature info:', res.data);

            this.$Message.success('修改成功');
            this.featuresList.map(item => {
              if (item.id == featureData.id) {
                console.log("modify feature test:", item, featureData);
                // item.name = featureData.name
                // item = featureData;
                item.name = featureData.name;
                item.pid = featureData.pid;
                item.sn = featureData.sn;
                item.orderNumber = featureData.orderNumber;

              }
            })
            console.log("modified feature list:", this.featuresList);
          }, err => {
            console.log(err.data)
          })
    },
    handleSubmit() {
      if (!this.featureName) {
        this.$Message.error('请输入权限名!');
      } else {
        this.modal_loading = true;
        setTimeout(() => {
          this.modal_loading = false;
          this.modalAddfeature = false;
          switch (this.modifyOrAddfeature) {
            case 'modifyfeature':
              let data = {
                id: this.featureId,
                name: this.featureName,
                pid: this.pid?this.pid:'',
                sn: this.featureSn,
                orderNumber: this.featureOrderNumber
              }
              this.modifyfeature(data);
              break;
            case 'addfeature':
              let data2 = {
                name: this.featureName,
                pid: this.pid,
                sn: this.featureSn,
                orderNumber: this.featureOrderNumber
              }
              this.addfeature(data2);
              break;
          }
        }, 1500)

      }
    },
    handleDismiss() {
      this.modal_loading = false;
      this.modalAddfeature = false;
    }
  },
  computed: {
    parentFeatureList: function() {
      let temData = [];
      this.featuresList.map(item => {
        if (!item.hasOwnProperty('pid')) {
          temData.push(item);
        }
      })
      // this.parentFeatureList = temData;
      console.log("parentFeature data:", temData);
      return temData;
    },
    featureTitle: function() {
      console.log("feature Title:", this.modifyOrAddfeature);
      if (this.modifyOrAddfeature === 'modifyfeature') {
        return "修改权限";
      } else if (this.modifyOrAddfeature === 'addfeature') {
        return "添加权限";
      }
    }
  },
  created() {
    this.getAllFeaturesList();
  }
}

</script>
<style scoped lang="less">
.feature-control {
  .feature-table-title {
    background: #ffffff;
    border: 1px solid #f0f0f0;
    padding: 5px;
    margin-bottom: 10px;
    font-size: 16px;
    line-height: 24px;
    .add-feature-icon {
      float: right;
      margin-right: 10px;
      padding: 0;
      width: 60px;
      // font-size: 16px;
      line-height: 24px;
    }
  }
}

.feature-item {
  label {
    width: 50px;
    display: inline-block;
    text-align: right;
    verticle-align: middle;
  }
  .feature-item-model {
    width: 80%;
    vertical-align: baseline;
    margin-left: 10px;
  }
}

.feature-item+.feature-item {
  margin-top: 10px;
}

</style>
