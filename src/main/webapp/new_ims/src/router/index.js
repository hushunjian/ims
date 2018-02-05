import home from '@/components/main'
import helloWorld from '@/components/helloWorld'
import login from '@/components/login'
import test1 from '@/components/test1'
import test2 from '@/components/test2'
import test3 from '@/components/test3'
import userList from '@/components/access/userList'
import addUser from '@/components/access/addUser'
import modifyUser from '@/components/access/modifyUser'
// import accessControl from '@/components/access/accessControl'
import featureControl from '@/components/access/featureControl'
import roleControl from '@/components/access/roleControl'


export const loginRouter = {
  path: '/login',
  name: 'login',
  meta: {
    title: 'Login - 登录'
  },
  component: login
};

export const page404 = {
    path: '/*',
    name: 'error_404',
    meta: {
        title: '404-页面不存在'
    },
    component: resolve => { require(['@/views/error_page/404.vue'], resolve); }
};

export const page401 = {
    path: '/401',
    name: 'error_401',
    meta: {
        title: '401-权限不足'
    },
    component: resolve => { require(['@/views/error_page/401.vue'], resolve); }
};

export const homeRouter = {
  path: '/',
  name: 'home',
  component: home,
};

export const appRouter = [{
    path: '/article',
    icon: 'ios-list-outline',
    component: home,
    name: 'article',
    title: 'APP文章管理',
    sn: 'APP_ARTICLE_MGR',
    children: [
      { path: 'activity', icon: 'ios-speedometer-outline', name: 'activity', title: '活动信息管理', component: helloWorld, sn: "APP_ARTICLE_MGR_1"},
      { path: 'pgc-article', icon: 'ios-glasses-outline', name: 'pgc-article', title: 'PGC文章管理', component: test1, sn: "APP_ARTICLE_MGR_2" },
      { path: 'ugc-article', icon: 'waterdrop', name: 'ugc-article', title: 'UGC文章管理', component: test2, sn: "APP_ARTICLE_MGR_3"}
    ]
  },
  {
    path: '/summary',
    icon: 'ios-speedometer-outline',
    component: home,
    name: 'summary',
    title: '运营统计管理',
    sn: 'REPORT_MGR',
    children: [
      { path: 'dailyActive', icon: 'ios-speedometer-outline', name: 'dailyActive', title: '日活统计管理', component: helloWorld, sn: "REPORT_MGR_1"},
      { path: 'promoter', icon: 'ios-glasses-outline', name: 'promoter', title: '推广统计管理', component: test1, sn: "REPORT_MGR_2" },
      { path: 'king', icon: 'waterdrop', name: 'king', title: '国王统计管理', component: test2, sn: "REPORT_MGR_3"},
      { path: 'appchannel', icon: 'waterdrop', name: 'appchannel', title: '渠道管理', component: test2, sn: "REPORT_MGR_4"},
      { path: 'channel-register', icon: 'waterdrop', name: 'channel-register', title: '渠道注册统计', component: test2, sn: "REPORT_MGR_5"},
      { path: 'king-perday', icon: 'waterdrop', name: 'king-perday', title: '王国[按天]统计', component: test2, sn: "REPORT_MGR_6"},
      { path: 'user-register-detail', icon: 'waterdrop', name: 'user-register-detail', title: '注册用户明细统计', component: test2, sn: "REPORT_MGR_7"},
      { path: 'new-kingdom', icon: 'waterdrop', name: 'new-kingdom', title: '新建王国明细统计', component: test2, sn: "REPORT_MGR_8"},
      { path: 'user-register', icon: 'waterdrop', name: 'user-register', title: '用户注册统计', component: test2, sn: "REPORT_MGR_9"},
      { path: 'ios-active', icon: 'waterdrop', name: 'ios-active', title: 'IOS推广激活统计', component: test2, sn: "REPORT_MGR_10"}
    ]
  },
  {
    path: '/appuser',
    icon: 'person-stalker',
    component: home,
    name: 'appUser',
    title: 'APP用户管理',
    sn: 'APP_USER_MGR',
    children: [
      { path: 'app-user-manager', icon: 'ios-speedometer-outline', name: 'app-user-manager', title: '用户管理', component: helloWorld, sn: "APP_USER_MGR_1"},
      { path: 'user-silent-manager', icon: 'ios-glasses-outline', name: 'user-silent-manager', title: '禁言用户管理', component: test1, sn: "APP_USER_MGR_2" },
      { path: 'user-sms', icon: 'waterdrop', name: 'user-sms', title: '用户短信发送', component: test2, sn: "APP_USER_MGR_3"},
      { path: 'user-invitation', icon: 'waterdrop', name: 'user-invitation', title: '用户邀请查询', component: test2, sn: "APP_USER_MGR_4"}
    ]
  },
  {
    path: '/system',
    icon: 'gear-b',
    component: home,
    name: 'system',
    title: '系统管理',
    sn: 'SYSTEM_MGR',
    children: [
      { path: 'system-log', icon: 'ios-speedometer-outline', name: 'system-log', title: '系统日志查询', component: helloWorld, sn: "SYSTEM_MGR_1"},
      { path: 'system-user', icon: 'ios-glasses-outline', name: 'system-user', title: '系统用户查询', component: test1, sn: "SYSTEM_MGR_2" },
      { path: 'global-task', icon: 'waterdrop', name: 'global-task', title: '全局任务', component: test2, sn: "SYSTEM_MGR_3"},
      { path: 'rong-cloud', icon: 'waterdrop', name: 'rong-cloud', title: '融云用户信息同步', component: test2, sn: "SYSTEM_MGR_4"},
      { path: 'permission-access', icon: 'waterdrop', name: 'permission-access', title: '权限分配', component: test2, sn: "SYSTEM_MGR_5"}
    ]
  },
  {
    path: '/appconfig',
    icon: 'ios-flower-outline',
    component: home,
    name: 'appconfig',
    title: 'APP配置管理',
    sn: 'APP_CONFIG',
    children: [
      { path: 'app-version', icon: 'ios-speedometer-outline', name: 'app-version', title: 'APP版本管理', component: helloWorld, sn: "APP_CONFIG_1"},
      { path: 'app-channel', icon: 'ios-glasses-outline', name: 'app-channel', title: 'APP版本渠道下载管理', component: test1, sn: "APP_CONFIG_2" },
      { path: 'app-cache', icon: 'waterdrop', name: 'app-cache', title: '缓存配置管理', component: test2, sn: "APP_CONFIG_3"},
      { path: 'app-db-config', icon: 'waterdrop', name: 'app-db-config', title: '数据库配置管理', component: test2, sn: "APP_CONFIG_4"},
      { path: 'app-ui', icon: 'waterdrop', name: 'app-ui', title: 'APP主题管理', component: test2, sn: "APP_CONFIG_5"},
      { path: 'app-lightbox', icon: 'waterdrop', name: 'app-lightbox', title: 'APP灯箱页管理', component: test2, sn: "APP_CONFIG_6"},
      { path: 'app-fragment-template', icon: 'waterdrop', name: 'app-fragment-template', title: '足迹语言模板管理', component: test2, sn: "APP_CONFIG_7"},
      { path: 'droparound-king-manager', icon: 'waterdrop', name: 'droparound-king-manager', title: '可串门王国管理', component: test2, sn: "APP_CONFIG_8"},
      { path: 'app-config', icon: 'waterdrop', name: 'app-config', title: '新APP系统配置管理', component: test2, sn: "APP_CONFIG_9"},
    ]
  },
  {
    path: '/zmjx',
    icon: 'social-windows-outline',
    component: home,
    name: 'zmjx',
    title: '最美家乡活动',
    sn: 'ZMJX_MGR',
    children: [
      { path: 'zmjx-activity-kingdom', icon: 'ios-speedometer-outline', name: 'zmjx-activity-kingdom', title: '活动王国管理', component: helloWorld, sn: "ZMJX_MGR_1"},
      { path: 'zmjx-config', icon: 'ios-glasses-outline', name: 'zmjx-config', title: '配置管理', component: test1, sn: "ZMJX_MGR_2" },
    ]
  },
  {
    path: '/list',
    icon: 'social-instagram',
    component: home,
    name: 'list',
    title: '榜单管理',
    sn: 'LISTING_MGR',
    children: [
      { path: 'list-rank', icon: 'ios-speedometer-outline', name: 'list-rank', title: '榜单列表', component: helloWorld, sn: "LISTING_MGR_1"},
      { path: 'list-online', icon: 'ios-glasses-outline', name: 'list-online', title: '上线榜单管理', component: test1, sn: "LISTING_MGR_2" },
    ]
  },
  {
    path: '/search',
    icon: 'search',
    component: home,
    name: 'search',
    title: '搜索管理',
    sn: 'SEARCH_MGR',
    children: [
      { path: 'search-console', icon: 'ios-speedometer-outline', name: 'search-console', title: '控制台', component: helloWorld, sn: "SEARCH_MGR_1"},
      { path: 'search-hot-keyword', icon: 'ios-glasses-outline', name: 'search-hot-keyword', title: '热词管理', component: test1, sn: "SEARCH_MGR_2" },
    ]
  },
  {
    path: '/material',
    icon: 'plus-round',
    component: home,
    name: 'material',
    title: '素材管理',
    sn: 'MATERIAL_MGR',
    children: [
      { path: 'tag-control', icon: 'ios-speedometer-outline', name: 'tag-control', title: '标签管理', component: helloWorld, sn: "MATERIAL_MGR_1"},
      { path: 'emotion-pack-control', icon: 'ios-glasses-outline', name: 'emotion-pack-control', title: '表情包管理', component: test1, sn: "MATERIAL_MGR_2" },
      { path: 'emotion-tease', icon: 'waterdrop', name: 'emotion-tease', title: '逗一逗管理', component: test2, sn: "MATERIAL_MGR_3"},
      { path: 'emotion-mbti', icon: 'waterdrop', name: 'emotion-mbti', title: 'MBTI王国映射管理', component: test2, sn: "MATERIAL_MGR_4"},
      { path: 'emotion-control', icon: 'waterdrop', name: 'emotion-control', title: '情绪管理', component: test2, sn: "MATERIAL_MGR_5"},
      { path: 'king-cover', icon: 'waterdrop', name: 'king-cover', title: '王国默认封面管理', component: test2, sn: "MATERIAL_MGR_6"},
      { path: 'robot-control', icon: 'waterdrop', name: 'robot-control', title: '机器人管理', component: test2, sn: "MATERIAL_MGR_7"},
      { path: 'records-control', icon: 'waterdrop', name: 'records-control', title: '语录管理', component: test2, sn: "MATERIAL_MGR_8"},
      { path: 'avatar-control', icon: 'waterdrop', name: 'avatar-control', title: '头像框管理', component: test2, sn: "MATERIAL_MGR_9"},
      { path: 'gift-control', icon: 'waterdrop', name: 'gift-control', title: '礼物管理', component: test2, sn: "MATERIAL_MGR_10"},
      { path: 'king-category', icon: 'waterdrop', name: 'king-category', title: '王国分类维护', component: test2, sn: "MATERIAL_MGR_11"},
      { path: 'king-lottery', icon: 'waterdrop', name: 'king-lottery', title: '王国抽奖列表', component: test2, sn: "MATERIAL_MGR_12"},
      { path: 'tag-sample', icon: 'waterdrop', name: 'tag-sample', title: '标签样本管理', component: test2, sn: "MATERIAL_MGR_13"}
    ]
  },
  {
    path: '/kingprice',
    icon: 'easel',
    component: home,
    name: 'kingprice',
    title: '王国价值管理',
    sn: 'KINGDOM_PRICE_MGR',
    children: [
      { path: 'king-price-property', icon: 'ios-speedometer-outline', name: 'king-price-property', title: '王国价值属性查询', component: helloWorld, sn: "KINGDOM_PRICE_MGR_1"},
      { path: 'king-task-control', icon: 'ios-glasses-outline', name: 'king-task-control', title: '任务控制台', component: test1, sn: "KINGDOM_PRICE_MGR_2" },
      { path: 'king-price-subsidy', icon: 'waterdrop', name: 'king-price-subsidy', title: '补贴配置', component: test2, sn: "KINGDOM_PRICE_MGR_3"},
    ]
  },
  {
    path: '/listking',
    icon: 'trophy',
    component: home,
    name: 'listking',
    title: '上市王国管理',
    sn: 'LISTING_KINGDOM_MGR',
    children: [
      { path: 'king-listed', icon: 'ios-speedometer-outline', name: 'king-listed', title: '已上市', component: helloWorld, sn: "LISTING_KINGDOM_MGR_1"},
      { path: 'king-pending', icon: 'ios-glasses-outline', name: 'king-pending', title: '待成交', component: test1, sn: "LISTING_KINGDOM_MGR_2" },
    ]
  },
  {
    path: '/admanager',
    icon: 'radio-waves',
    component: home,
    name: 'admanager',
    title: '广告管理',
    sn: 'AD_MGR',
    children: [
      { path: 'ad-banner', icon: 'ios-speedometer-outline', name: 'ad-banner', title: '广告位管理', component: resolve => { require(['@/views/ad-manager/adBanner.vue'], resolve);}, sn: "AD_MGR_1"},
      { path: 'ad-info', icon: 'ios-glasses-outline', name: 'ad-info', title: '广告信息管理', component: resolve => { require(['@/views/ad-manager/adInfo.vue'], resolve);}, sn: "AD_MGR_2" },
      { path: 'ad-tag', icon: 'ios-speedometer-outline', name: 'ad-tag', title: 'Tag管理', component: resolve => { require(['@/views/ad-manager/tagControl.vue'], resolve);}, sn: ""},
    ]
  },
  {
    path: '/user',
    icon: 'ios-people',
    name: 'user',
    title: 'CMS用户管理',
    component: home,
    sn: "CMS_USER_MGR",
    children: [
      { path: 'user-list', icon: 'ios-glasses-outline', name: 'user-list', title: '用户管理', component: userList, sn: "CMS_USER_MGR_1" },
      // { path: '/add-user', icon: 'waterdrop', name: 'add-user', title: '添加用户', component: addUser },
      // { path: '/modify-user', icon: 'waterdrop', name: 'modify-user', title: '修改用户', component: modifyUser},
      { path: 'role-control', icon: 'waterdrop', name: 'role-control', title: '角色管理', component: roleControl, sn: "CMS_ROLE_MGR"},
      { path: 'feature-control', icon: 'waterdrop', name: 'feature-control', title: '权限管理', component: featureControl, sn: "CMS_FEATURE"},
      { path: 'access-control', icon: 'waterdrop', name: 'access-control', title: '权限分配', component: resolve => { require(['@/components/access/accessControl.vue'], resolve);}, sn: "CMS_FEATURE_ACCESS" },
    ]
  },
  {
    path: '/test',
    icon: 'ios-list-outline',
    name: 'test',
    title: '测试权限',
    component: home,
    sn: "TEST_ACCESS",
    children: []
    // children:[
    //   { path: 'index', icon: 'waterdrop', name: 'index', title: '测试', component: test2, sn: "TEST_ACCESS"}
    // ]
    // children: [
    //   { path: 'user-list', icon: 'ios-glasses-outline', name: 'user-list', title: '用户管理', component: userList, sn: "CMS_USER_MGR_1" },
    //   // { path: '/add-user', icon: 'waterdrop', name: 'add-user', title: '添加用户', component: addUser },
    //   // { path: '/modify-user', icon: 'waterdrop', name: 'modify-user', title: '修改用户', component: modifyUser},
    //   { path: 'role-control', icon: 'waterdrop', name: 'role-control', title: '角色管理', component: roleControl, sn: "CMS_ROLE_MGR"},
    //   { path: 'feature-control', icon: 'waterdrop', name: 'feature-control', title: '权限管理', component: featureControl, sn: "CMS_FEATURE"},
    //   { path: 'access-control', icon: 'waterdrop', name: 'access-control', title: '权限分配', component: resolve => { require(['@/components/access/accessControl.vue'], resolve);}, sn: "CMS_FEATURE_ACCESS" },
    // ]
  }
];

export const routers = [
  loginRouter,
  homeRouter,
  ...appRouter,
  page404,
  page401
];
