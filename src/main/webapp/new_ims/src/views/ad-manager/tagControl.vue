<template>
  <div class="tag-control">
    <div class="tag-table-title">
      关联标签列表
      <div class="tag-button">
        <Button type="primary" icon="plus-round" @click="add" class="tag-button-item">添加</Button>
        <Button type="default" icon="arrow-return-left" @click="backTo" class="tag-button-item">返回</Button>
      </div>
    </div>
    <Table refs="table" border :columns="columns" :data="tagList"></Table>
    <Modal v-model="modalDelTag" width="360">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>删除确认</span>
      </p>
      <div style="text-align:center">
        <p>是否确认删除此条标签？</p>
        <p>{{ selectedTag }}</p>
      </div>
      <div slot="footer">
        <Button type="error" size="large" long :loading="modal_loading" @click="del">删除</Button>
      </div>
    </Modal>
    <Modal v-model="modalAddTag" width="400">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>{{ tagTitle }}</span>
      </p>
      <div style="text-align:center;">
        <div class="tag-item">
          <label for="tag-name">标签名称</label>
          <Input v-model="tagName" placeholder="请输入标签名称" class="tag-item-model" id="tag-name"></Input>
        </div>
        <div class="tag-item">
          <label for="tag-location">位置</label>
          <Input v-model="tagLocation" placeholder="请输入位置" class="tag-item-model" id="tag-location"></Input>
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
  name: 'tagControl',
  data() {
    return {
      columns: [{
        title: '标签名',
        key: 'tagName'
      }, {
        title: '位置',
        key: 'tagLocation'
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
              on: {
                click: () => {
                  this.remove(params.index)
                }
              }
            }, '删除')
          ])
        }
      }],
      tagList: [],
      modal_loading: false,
      modalDelTag: false,
      modalAddTag: false,
      selectedTag: '',
      selectedTagIndex: undefined,
      tagId: undefined,
      tagName: '',
      tagLocation: '',
      modifyOrAddTag: ''
    }
  },
  methods: {
    add() {
      this.modalAddTag = true;
      this.modifyOrAddTag = 'addTag';
      this.tagName = '';
      this.tagLocation = '';
    },
    backTo() {
      this.$router.go(-1);
    },
    modify(index) {
      this.modalAddTag = true;
      this.modifyOrAddTag = 'modifyTag';
      this.tagId = this.tagList[index].id;
      this.tagName = this.tagList[index].tagName;
      this.tagLocation = this.tagList[index].tagLocation;
      this.selectedTagIndex = index;
    },
    remove(index) {
      this.modalDelTag = true;
      this.tagId = this.tagList[index].id;
      this.selectedTagIndex = index;
      this.selectedTag = this.tagList[index].tagName;
    },
    del() {
      this.modal_loading = true;
      setTimeout(() => {
        this.modal_loading = false;
        this.modalDelTag = false;
        this.deleteTag(this.tagId);
      }, 1500);
    },
    deleteTag(tagId) {
      this.$http.post('/ims/feature/deleteAdBanner', { tagId: tagId }, { emulateJSON: true })
        .then(
          res => {
            console.log('delete tag info:', res.data);
            this.$Message.success('删除成功');
            this.tagList.splice(this.selectedTagIndex, 1);
          }, err => {
            console.log(err.data);
            this.$Message.success('删除失败');
          })
    },
    addTag(tagData) {
      console.log("add tag item:", tagData);
      this.$http.post('/ims/feature/deleteAdBanner', tagData, { emulateJSON: true })
        .then(
          res => {
            console.log('add tag info:', res.data);
            this.$Message.success('添加标签成功');
            let temData = Object.assign({}, {id: ''}, tagData);
            this.tagList.push(temData);
          }, err => {
            console.log(err.data);
            this.$Message.success('添加标签失败');
          })
    },
    modifyTag(tagData) {
      console.log("modify tag item:", tagData);
      this.$http.post('/ims/feature/deleteAdBanner', tagData, { emulateJSON: true })
        .then(
          res => {
            console.log('modify tag info:', res.data);
            this.$Message.success('修改标签成功');
            this.tagList.map(item => {
              if (item.id == tagData.id) {
                item.tagName = tagData.tagName,
                item.tagLocation = tagData.tagLocation
              }
            })
            console.log('modified tag list:', this.tagList);
          }, err => {
            console.log(err.data);
            this.$Message.success('修改标签失败');
          })
    },
    handleSubmit() {
      if (!this.tagName && !this.tagLocation) {
        this.$Message.error("请重新输入");
      } else {
        this.modal_loading = true;
        setTimeout(() => {
          this.modal_loading = false;
          this.modalAddTag = false;
          switch(this.modifyOrAddTag) {
            case 'modifyTag':
              let modifyData = {
                id: this.tagId,
                tagName: this.tagName,
                tagLocation: this.tagLocation
              }
              this.modifyTag(modifyData);
              break;
            case 'addTag':
              let addData = {
                tagName: this.tagName,
                tagLocation: this.tagLocation
              };
              this.addTag(addData);
              break;  
          }
        }, 1500);
      }
    },
    handleDismiss() {
      this.modal_loading = false;
      this.modalAddTag = false;
    }
  },
  computed: {
    tagTitle: function() {
      if (this.modifyOrAddTag === 'modifyTag') {
        return "修改标签";
      } else if(this.modifyOrAddTag === 'addTag') {
        return "添加标签"
      }
    }
  },
  created() {
    this.tagList = [{tagName: '测试标签', tagLocation: 1}, {tagName: '测试标签2', tagLocation: 2}, {tagName: '测试标签3', tagLocation: 3}];
  }
}

</script>
<style scoped lang="less">
.tag-control {
  .tag-table-title {
    background: #ffffff;
    border: 1px solid #f0f0f0;
    padding: 5px;
    margin-bottom: 10px;
    font-size: 16px;
    line-height: 24px;
    .tag-button {
      float: right;
      margin-right: 10px;
      padding: 0;
      .tag-button-item {
        width: 60px;
        padding: 3px;
        margin-right: 10px;
      }
    }
  }
}

.tag-item {
  label {
    width: 70px;
    display: inline-block;
    vertical-align: middle;
    text-align: left;
  }
  .tag-item-model {
    width: 65%;
    vertical-align: baseline;
    margin-left: 10px;
  }
}
.tag-item + .tag-item {
  margin-top: 10px;
}

</style>
