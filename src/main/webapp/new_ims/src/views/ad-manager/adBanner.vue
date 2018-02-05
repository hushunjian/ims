<template>
  <div class="ad-banner-control">
    <div class="ad-table-title">
      广告位列表
      <Button type="primary" class="add-ad-icon" icon="plus-round" @click="add">添加</Button>
    </div>
    <Table refs="table2" border :columns="columns" :data="adBannerList"></Table>
    <Modal v-model="modalDelAdBanner" width="360">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>删除确认</span>
      </p>
      <div style="text-align:center">
        <p>是否确认删除此条广告位？</p>
        <p>{{ selectedAdBannerName }}</p>
      </div>
      <div slot="footer">
        <Button type="error" size="large" long :loading="modal_loading" @click="del">删除</Button>
      </div>
    </Modal>
    <Modal v-model="modalAddAdBanner" width="480">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>{{ adBannerTitle }}</span>
      </p>
      <div style="text-align:center;">
        <div class="ad-banner-item">
          <label for="ad-name">广告位名称</label>
          <Input v-model="adBannerName" placeholder="请输入广告位名" class="ad-banner-item-model" id="ad-name"></Input>
        </div>
        <div class="ad-banner-item">
          <label for="ad-location">广告位随机位置</label>
          <Input v-model="adBannerLocation" placeholder="请输入广告位位置('-'隔开 例：3-5)" class="ad-banner-item-model" id="ad-location"></Input>
        </div>
        <div class="ad-banner-item">
          <label for="ad-height">广告位高度</label>
          <Input v-model="adBannerHeight" placeholder="请输入广告位高度(请输入数字)" class="ad-banner-item-model" id="ad-height"></Input>
        </div>
        <div class="ad-banner-item">
          <label for="ad-width">广告位宽度</label>
          <Input v-model="adBannerWidth" type="text" placeholder="请输入广告位宽度(请输入数字)" class="ad-banner-item-model" id="ad-width"></Input>
        </div>
        <div class="ad-banner-item">
          <label for="">类型</label>
          <Select v-model="adType" style="width:65%;text-align:left;vertical-align:middle;" class="ad-banner-item-model">
            <Option v-for="item in adBannerType" :value="item.id" :key="item.id">{{ item.type }}</Option>
          </Select>
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
  name: 'adBanner',
  data() {
    return {
      columns: [{
          title: '序号',
          type: 'index',
          width: 70,
          align: 'center'
        }, {
          title: '广告位名称',
          key: 'adTitle',
        }, {
          title: '广告位位置',
          key: 'adLocation'
        }, {
          title: '广告位高度',
          key: 'adCoverHeight'
        }, {
          title: '广告位宽度',
          key: 'adCoverWidth'
        }, {
          title: '创建时间',
          key: 'createTime'
        }, {
          title: '操作',
          key: 'action',
          width: 200,
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
                  type: 'primary',
                  size: 'small'
                },
                on: {
                  click: () => {
                    this.openTag(params.index)
                  }
                }
              }, '关联标签')
            ]);
          }
        }
      ],
      modalDelAdBanner: false,
      modalAddAdBanner: false,
      modal_loading: false,
      adBannerId: undefined,
      adBannerName: '',
      adBannerLocation: '',
      adBannerHeight: undefined,
      adBannerWidth: undefined,
      adType: undefined,
      modifyOrAddBanner: '',
      adBannerList: [],
      selectedIndex: undefined,
      selectedAdBannerName: ''
    }
  },
  methods: {
    getAlladBannerList() {
      this.$http.get('/ims/feature/getAllFeatures', { withCredentials: true }).then(
      res => {
        res.data.data.map(item => {
          this.adBannerList.push(item);
        })
        console.log("user adBannerList:", this.adBannerList);
      }, err => {
        console.log(err.data);
      })
    },
    modify(index) {
      this.modalAddAdBanner = true;
      this.adBannerId = this.adBannerList[index].id;
      this.adBannerName = this.adBannerList[index].adTitle;
      this.adBannerLocation = this.adBannerList[index].adLocation;
      this.adBannerHeight = this.adBannerList[index].adCoverHeight;
      this.adBannerWidth = this.adBannerList[index].adCoverWidth;
      this.adType = this.adBannerList[index].adType;
      console.log('modify adBannerId:', this.adBannerId);
      this.selectedIndex = index;
      this.modifyOrAddBanner = 'modifyAdBanner';
    },
    remove(index) {
      this.modalDelAdBanner = true;
      this.adBannerId = this.adBannerList[index].id;
      console.log('del adBannerId:', this.adBannerId);
      this.selectedIndex = index;
      this.selectedAdBannerName = this.adBannerList[index].adTitle;
    },
    openTag(index) {
      console.log("tag index:", index);
      this.$router.push({name: 'ad-tag'});
    },
    add() {
      this.modalAddAdBanner = true;
      this.modifyOrAddBanner = 'addAdBanner';
      this.adBannerName = '';
      this.adBannerLocation = '';
      this.adBannerHeight = '';
      this.adBannerWidth = '';
      this.adType = undefined;
    },
    del() {
      this.modal_loading = true;
      setTimeout(() => {
        this.modal_loading = false;
        this.modalDelAdBanner = false;
        this.deleteAdBanner(this.adBannerId);
      }, 1500);
    },
    deleteAdBanner(adBannerId) {
      this.$http.post('/ims/feature/deleteAdBanner', { adBannerId: adBannerId }, { emulateJSON: true })
        .then(
          res => {
            console.log('delete feature info:', res.data);
            this.$Message.success('删除成功');
            this.adBannerList.splice(this.selectedIndex, 1);
          }, err => {
            console.log(err.data)
          })
    },
    addAdBanner(adBannerData) {
      console.log('add adBanner item:', adBannerData)
      this.$http.post('/ims/feature/addAdBanner', adBannerData, { emulateJSON: true })
        .then(
          res => {
            console.log('add adBanner info:', res.data);
            this.$Message.success('添加成功');
            let temData = Object.assign({}, { id: '' }, adBannerData)
            this.adBannerList.push(temData);
          }, err => {
            console.log(err.data)
          })
    },
    modifyAdBanner(adBannerData) {
      console.log("modify adBanner item:", adBannerData);
      this.$http.post('/ims/feature/modifyAdBanner', adBannerData, { emulateJSON: true }).then(
          res => {
            console.log('add feature info:', res.data);
            this.$Message.success('修改成功');
            this.adBannerList.map(item => {
              if (item.id == adBannerData.id) {
                console.log("modify adBanner test:", item, adBannerData);
                item.adTitle = adBannerData.adTitle;
                item.adLocation = adBannerData.adLocation;
                item.adCoverWidth = adBannerData.adCoverWidth;
                item.adBannerHeight = adBannerData.adBannerHeight;
                item.adType = adBannerData.adType;
              }
            })
            console.log("modified feature list:", this.adBannerList);
          }, err => {
            console.log(err.data);
          })
    },
    handleSubmit() {
      if (!this.adBannerName) {
        this.$Message.error('请输入广告位名!');
      } else {
        this.modal_loading = true;
        setTimeout(() => {
          this.modal_loading = false;
          this.modalAddAdBanner = false;
          switch (this.modifyOrAddBanner) {
            case 'modifyAdBanner':
              let data = {
                id: this.adBannerId,
                adTitle: this.adBannerName,
                adLocation: this.adBannerLocation,
                adCoverWidth: this.adBannerWidth,
                adCoverHeight: this.adBannerHeight,
                adType:this.adBannerType
              }
              this.modifyAdBanner(data);
              break;
            case 'addAdBanner':
              let data2 = {
                adTitle: this.adBannerName,
                adLocation: this.adBannerLocation,
                adCoverWidth: this.adBannerWidth,
                adCoverHeight: this.adBannerHeight,
                adType:this.adBannerType
              }
              this.addAdBanner(data2);
              break;
          }
        }, 1500)

      }
    },
    handleDismiss() {
      this.modal_loading = false;
      this.modalAddAdBanner = false;
    }
  },
  computed: {
    adBannerTitle: function() {
      console.log("feature Title:", this.modifyOrAddBanner);
      if (this.modifyOrAddBanner === 'modifyAdBanner') {
        return "修改广告位";
      } else if (this.modifyOrAddBanner === 'addAdBanner') {
        return "添加广告位";
      }
    },
    adBannerType: function() {
      let data = [{id:1, type:'首页和标签'}, {id:2, type:'首页'}, {id:3, type:'标签'}];
      return data;
    }
  },
  created() {
    this.getAlladBannerList();
  }
}

</script>
<style scoped lang="less">
.ad-banner-control {
  .ad-table-title {
    background: #ffffff;
    border: 1px solid #f0f0f0;
    padding: 5px;
    margin-bottom: 10px;
    font-size: 16px;
    line-height: 24px;
    .add-ad-icon {
      float: right;
      margin-right: 10px;
      padding: 0;
      width: 60px;
      // font-size: 16px;
      line-height: 24px;
    }
  }
}

.ad-banner-item {
  label {
    width: 100px;
    display: inline-block;
    vertical-align: middle;
    text-align: left;
  }
  .ad-banner-item-model {
    width: 65%;
    vertical-align: baseline;
    margin-left: 10px;
  }
}

.ad-banner-item+.ad-banner-item {
  margin-top: 10px;
}

</style>
