<template>
  <div class="ad-info-control">
    <div class="ad-info-table-title">
      广告信息列表
      <Button type="primary" class="add-ad-icon" icon="plus-round" @click="addAction">添加</Button>
    </div>
    <Table refs="table2" border :columns="columns" :data="adInfoList"></Table>
    <Modal v-model="modalDelAdInfo" width="360">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>删除确认</span>
      </p>
      <div style="text-align:center">
        <p>是否确认删除此条广告信息？</p>
        <p>{{ selectedAdInfoName }}</p>
      </div>
      <div slot="footer">
        <Button type="error" size="large" long :loading="modal_loading" @click="handleDel">删除</Button>
      </div>
    </Modal>
    <Modal v-model="modalAddAdInfo" width="480">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>{{ adInfoTitle }}</span>
      </p>
      <div style="text-align:center;">
        <div class="ad-info-item">
          <label for="ad-name">广告名称</label>
          <Input v-model="adInfoName" placeholder="请输入广告名称" class="ad-info-item-model" id="ad-name"></Input>
        </div>
        <div class="ad-info-item">
          <label for="">广告位</label>
          <Select v-model="adInfoLocation" style="width:65%;text-align:left;vertical-align:middle;" class="ad-info-item-model">
            <Option v-for="item in adInfoLocationsType" :value="item.id" :key="item.id">{{ item.type }}</Option>
          </Select>
        </div>
        <div class="ad-info-item">
          <label for="" style="vertical-align: top">广告封面图片</label>
          <div class="ad-info-img ad-info-item-model">
            <div class="ad-info-img-pre">
              <img :src="previewImg" alt="" id="ad-pic">
            </div>
            <!-- <Upload :before-upload="handleUpload" action="" style="text-align: left">
              <Button type="ghost" icon="ios-cloud-upload-outline">选择上传图片</Button>
            </Upload> -->
            <input type="file" accept="image/*" @change="handleChange" id="fileinput1" class="fileinput" />
            <label class="filelabel" for="fileinput1">
              <Icon type="image"></Icon>&nbsp;选择上传图片</label>
            </label>
          </div>
        </div>
        <div class="ad-info-item">
          <label for="ad-width">广告封面宽度</label>
          <Input v-model="adInfoWidth" type="text" placeholder="请输入广告封面宽度(请输入数字)" class="ad-info-item-model" id="ad-width"></Input>
        </div>
        <div class="ad-info-item">
          <label for="ad-height">广告封面高度</label>
          <Input v-model="adInfoHeight" placeholder="请输入广告封面高度(请输入数字)" class="ad-info-item-model" id="ad-height"></Input>
        </div>
        <div class="ad-info-item">
          <label>有效时间</label>
          <DatePicker v-model="adInfoTime" type="datetime" placeholder="Select date and time" style="width: 65%;margin-left: 10px;"></DatePicker>
        </div>
        <div class="ad-info-item">
          <label>显示概率(0-100整数)</label>
          <InputNumber :max="100" :min="0" v-model="adInfoProbability" class="ad-info-item-model"></InputNumber>
        </div>
        <div class="ad-info-item">
          <label for="">广告类型</label>
          <Select v-model="adInfoType" style="width:65%;text-align:left;vertical-align:middle;" class="ad-info-item-model">
            <Option v-for="item in adInfosType" :value="item.id" :key="item.id">{{ item.type }}</Option>
          </Select>
        </div>
        <div class="ad-info-item">
          <label for="ad-kingId">王国ID</label>
          <Input v-model="adInfoKingId" placeholder="请输入王国ID" class="ad-info-item-model" id="ad-kingId"></Input>
        </div>
        <div class="ad-info-item">
          <label for="ad-link">链接</label>
          <Input v-model="adInfoLink" placeholder="请输入链接" class="ad-info-item-model" id="ad-link"></Input>
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
  name: 'adInfo',
  data() {
    return {
      columns: [{
        title: '序号',
        type: 'index',
        width: 65,
        align: 'center'
      }, {
        title: '广告名称',
        key: 'adTitle',
      }, {
        title: '广告封面',
        width: 130,
        key: 'adCover',
      }, {
        title: '所属广告位',
        key: 'adLocation'
      }, {
        title: '显示概率',
        key: 'adProbability'
      }, {
        title: '广告封面高度',
        key: 'adCoverWidth'
      }, {
        title: '广告封面宽度',
        key: 'adCoverHeight'
      }, {
        title: '有效时间',
        key: 'adValidTime'
      }, {
        title: '类型',
        key: 'adType'
      }, {
        title: '王国ID',
        key: 'adId'
      }, {
        title: '广告URL',
        width: 130,
        key: 'adUrl'
      }, {
        title: '创建时间',
        key: 'adCreateTime'
      }, {
        title: '操作',
        key: 'action',
        width: 130,
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
                  this.modifyAction(params.index)
                }
              }
            }, '编辑'),
            h('Button', {
              props: {
                type: 'error',
                size: 'small'
              },
              on: {
                click: () => {
                  this.removeAction(params.index)
                }
              }
            }, '删除')
          ]);
        }
      }],
      modalDelAdInfo: false,
      modalAddAdInfo: false,
      modal_loading: false,
      adInfoId: undefined,
      adInfoName: '',
      adInfoLocation: '',
      adInfoHeight: undefined,
      adInfoWidth: undefined,
      adInfoTime: undefined,
      adInfoProbability: undefined,
      adInfoType: undefined,
      adInfoKingId: undefined,
      adInfoLink: '',
      modifyOrAddAdInfo: '',
      adInfoList: [],
      selectedIndex: undefined,
      selectedAdInfoName: '',
      previewImg: ''
    }
  },
  methods: {
    getAllAdInfoList() {
      this.$http.get('/ims/feature/getAllFeatures', { withCredentials: true }).then(
        res => {
          res.data.data.map(item => {
            this.adInfoList.push(item);
          })
          console.log("user adInfoList:", this.adInfoList);
        }, err => {
          console.log(err.data);
        })
    },
    modifyAction(index) {
      this.modalAddAdInfo = true;
      this.adInfoId = this.adInfoList[index].id;
      this.adInfoName = this.adInfoList[index].adTitle;
      this.adInfoLocation = this.adInfoList[index].adLocation;
      this.adInfoHeight = this.adInfoList[index].adCoverHeight;
      this.adInfoWidth = this.adInfoList[index].adCoverWidth;
      this.adInfoLocation = this.adInfoList[index].adInfoLocation;
      console.log('modify adInfoId:', this.adInfoId);
      this.selectedIndex = index;
      this.modifyOrAddAdInfo = 'modifyAdBanner';
    },
    removeAction(index) {
      this.modalDelAdInfo = true;
      this.adInfoId = this.adInfoList[index].id;
      console.log('del adInfoId:', this.adInfoId);
      this.selectedIndex = index;
      this.selectedAdInfoName = this.adInfoList[index].adTitle;
    },
    openTag(index) {
      console.log("tag index:", index);
      this.$router.push({ name: 'ad-tag' });
    },
    addAction() {
      this.modalAddAdInfo = true;
      this.modifyOrAddAdInfo = 'addAdBanner';
      this.adInfoName = '';
      this.adInfoLocation = '';
      this.adInfoHeight = '';
      this.adInfoWidth = '';
      this.adInfoLocation = undefined;
    },
    handleDel() {
      this.modal_loading = true;
      setTimeout(() => {
        this.modal_loading = false;
        this.modalDelAdInfo = false;
        this.deleteAdBanner(this.adInfoId);
      }, 1500);
    },
    deleteAdBanner(adInfoId) {
      this.$http.post('/ims/feature/deleteAdBanner', { adInfoId: adInfoId }, { emulateJSON: true })
        .then(
          res => {
            console.log('delete feature info:', res.data);
            this.$Message.success('删除成功');
            this.adInfoList.splice(this.selectedIndex, 1);
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
            this.adInfoList.push(temData);
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
          this.adInfoList.map(item => {
            if (item.id == adBannerData.id) {
              console.log("modify adBanner test:", item, adBannerData);
              item.adTitle = adBannerData.adTitle;
              item.adLocation = adBannerData.adLocation;
              item.adCoverWidth = adBannerData.adCoverWidth;
              item.adInfoHeight = adBannerData.adInfoHeight;
              item.adInfoLocation = adBannerData.adInfoLocation;
            }
          })
          console.log("modified feature list:", this.adInfoList);
        }, err => {
          console.log(err.data);
        })
    },
    handleSubmit() {
      if (!this.adInfoName || !this.adInfoLocation || !this.adInfoHeight || !this.adInfoWidth || !this.adInfoType || !this.previewImg || !this.adInfoTime) {
        this.$Message.error('请完善信息后提交!');
      } else {
        this.modal_loading = true;
        setTimeout(() => {
          this.modal_loading = false;
          this.modalAddAdInfo = false;
          switch (this.modifyOrAddAdInfo) {
            case 'modifyAdBanner':
              let data = {
                id: this.adInfoId,
                adTitle: this.adInfoName,
                bannerId: this.adInfoLocation,
                adCoverWidth: this.adInfoWidth,
                adCoverHeight: this.adInfoHeight,
                effectiveTime: this.adInfoTime,
                displayProbability: this.adInfoProbability,
                type: this.adInfoType,
                topicId: this.adInfoKingId,
                adUrl: this.adInfoLink,
              }
              this.modifyAdBanner(data);
              break;
            case 'addAdBanner':
              let data2 = {
                adTitle: this.adInfoName,
                adLocation: this.adInfoLocation,
                adCoverWidth: this.adInfoWidth,
                adCoverHeight: this.adInfoHeight,
                adInfoLocation: this.adInfoLocationsType
              }
              this.addAdBanner(data2);
              break;
          }
        }, 1500)

      }
    },
    handleDismiss() {
      this.modal_loading = false;
      this.modalAddAdInfo = false;
    },
    handleChange(e) {
      let file = e.target.files[0];
      const sizeLimit = 1024 * 1024 * 10 //图片大小<10MB
      console.log("file info:", file);
      if (file && file['size'] > sizeLimit) {
        this.$Message.success('上传图片大小不能超过10MB');
        return;
      }
      let reader = new FileReader();
      let img = document.getElementById("ad-pic");
      reader.onload = (function(aImg) {
        return function(e) {
          aImg.src = e.target.result;
          this.previewImg = e.target.result;
        }
      })(img);
      reader.readAsDataURL(file);

      let formData = new FormData();
      formData.append("file", file);
      // formData.append("previewImg", this.previewImg);
      // console.log("form data:", file, formData,this.previewImg);
      // this.previewImg = window.URL.createObjectURL(file);
    }
  },
  computed: {
    adInfoTitle: function() {
      console.log("feature Title:", this.modifyOrAddAdInfo);
      if (this.modifyOrAddAdInfo === 'modifyAdBanner') {
        return "修改广告位";
      } else if (this.modifyOrAddAdInfo === 'addAdBanner') {
        return "添加广告位";
      }
    },
    adInfoLocationsType: function() {
      let data = [{ id: 1, type: '测试广告位1' }, { id: 2, type: '测试广告位2' }, { id: 3, type: '测试广告位3' }];
      return data;
    },
    adInfosType: function() {
      let data = [{ id: 1, type: '链接' }, { id: 2, type: '王国' }];
      return data;
    }
  },
  created() {
    this.getAllAdInfoList();
  }
}

</script>
<style scoped lang="less">
.ad-info-control {
  .ad-info-table-title {
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
      width: 60px; // font-size: 16px;
      line-height: 24px;
    }
  }
}

.ad-info-item {
  label {
    width: 120px;
    display: inline-block;
    vertical-align: middle;
    text-align: left;
  }
  .ad-info-item-model {
    width: 65%;
    vertical-align: middle;
    margin-left: 10px;
  }
}

.ad-info-item+.ad-info-item {
  margin-top: 10px;
}

.ad-info-img {
  display: inline-block;
  text-align: left;
  .ad-info-img-pre {
    width: 200px;
    min-height: 120px;
    max-height: 200px;
    overflow: hidden;
    border: 1px solid #dddee1;
    border-radius: 4px;
    padding: 5px;
    margin-bottom: 10px;
    img {
      width: 100%;
    }
  }
}

.fileinput {
  display: none;
}

.filelabel {
  display: inline-block;
  width: auto !important;
  padding: 6px 10px;
  background: #2d8cf0;
  border: 1px solid #2d8cf0;
  border-radius: 4px;
  cursor: pointer;
  color: white;
  font-size: 12px;
  text-align: center;
  transition: all .2s;
  &:hover {
    background: #5cadff;
    border: 1px solid #5cadff;
    transition: all .2s;
  }
}

</style>
