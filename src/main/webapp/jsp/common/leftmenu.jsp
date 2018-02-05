<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String tab = request.getParameter("t");
String sub = request.getParameter("s");
%>
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
            <li>
                <a href="${ctx}/dashboard" <%if("1".equals(tab)){ %>class="active"<%} %>>
                    <i class="fa fa-dashboard"></i>
                    <span>Dashboard</span>
                </a>
            </li>
           
          <c:if test="${admin_user_permission.contains('APP_ARTICLE_MGR')}">
	            <li class="sub-menu">
	                <a href="javascript:;" <%if("2".equals(tab)){ %>class="active"<%} %>>
	                    <i class="fa fa-book"></i>
	                    <span>APP文章管理</span>
	                </a>
	                <ul class="sub">
	                    <c:if test="${admin_user_permission.contains('APP_ARTICLE_MGR_1')}"><li <%if("2_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/activity/query">活动信息管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('APP_ARTICLE_MGR_2')}"><li <%if("2_2".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/pgc/query">PGC文章管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('APP_ARTICLE_MGR_3')}"><li <%if("2_3".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/ugc/query">UGC文章管理</a></li></c:if>
	                </ul>
	            </li>
          </c:if>
          <c:if test="${admin_user_permission.contains('REPORT_MGR') }">
	            <li class="sub-menu">
	                <a href="javascript:;" <%if("3".equals(tab)){ %>class="active"<%} %>>
	                    <i class="fa fa-bar-chart-o"></i>
	                    <span>运营统计管理</span>
	                </a>
	                <ul class="sub">
	                    <c:if test="${admin_user_permission.contains('REPORT_MGR_1')}"><li <%if("3_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/stat/dailyActive/query">日活统计管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('REPORT_MGR_2')}"><li <%if("3_2".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/stat/promoter/query">推广统计管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('REPORT_MGR_3')}"><li <%if("3_3".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/stat/king/query">国王统计管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('REPORT_MGR_4')}"><li <%if("3_4".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appchannel/query">渠道管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('REPORT_MGR_5')}"><li <%if("3_5".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/stat/channelRegister/query">渠道注册统计</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('REPORT_MGR_6')}"><li <%if("3_6".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/stat/king/day/query">王国[按天]统计</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('REPORT_MGR_7')}"><li <%if("3_7".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/stat/userRegister/detail/query">注册用户明细统计</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('REPORT_MGR_8')}"><li <%if("3_8".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/stat/kingdomCreate/detail/query">新建王国明细统计</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('REPORT_MGR_9')}"><li <%if("3_9".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/stat/userRegister/query">用户注册统计</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('REPORT_MGR_10')}"><li <%if("3_10".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/stat/iosWapx/query">IOS推广激活统计</a></li></c:if>
	                </ul>
	            </li>
           </c:if>
           <c:if test="${admin_user_permission.contains('APP_USER_MGR') }">
	            <li class="sub-menu">
	                <a href="javascript:;" <%if("5".equals(tab)){ %>class="active"<%} %>>
	                    <i class="fa fa-users"></i>
	                    <span>APP用户管理</span>
	                </a>
	                <ul class="sub">
	                    <c:if test="${admin_user_permission.contains('APP_USER_MGR_1')}"><li <%if("5_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appuser/query">用户管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('APP_USER_MGR_2')}"><li <%if("5_2".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appuser/gaguser/query">禁言用户管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('APP_USER_MGR_3')}"><li <%if("5_3".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appuser/msgsender">用户短信发送</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('APP_USER_MGR_4')}"><li <%if("5_4".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appuser/invitation/list">用户邀请查询</a></li></c:if>
	                </ul>
	            </li>
           </c:if>
           <c:if test="${admin_user_permission.contains('SYSTEM_MGR') }">
				<li class="sub-menu">
	                <a href="javascript:;" <%if("6".equals(tab)){ %>class="active"<%} %>>
	                    <i class="fa fa-sitemap"></i>
	                    <span>系统管理</span>
	                </a>
	                <ul class="sub">
	                    <c:if test="${admin_user_permission.contains('SYSTEM_MGR_1')}"><li <%if("6_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/system/log/query">系统日志查询</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('SYSTEM_MGR_2')}"><li <%if("6_2".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/system/user/query">系统用户查询</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('SYSTEM_MGR_3')}"><li <%if("6_3".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/globalTask/index">全局任务</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('SYSTEM_MGR_4')}"><li <%if("6_4".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/rongcloud/rongcloudSet">融云用户信息同步</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('SYSTEM_MGR_5')}"><li <%if("6_5".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/jsp/permission/assign.jsp">权限分配</a></li></c:if>
	                </ul>
	            </li>
            </c:if>
            <c:if test="${admin_user_permission.contains('APP_CONFIG') }">
	            <li class="sub-menu">
	                <a href="javascript:;" <%if("7".equals(tab)){ %>class="active"<%} %>>
	                    <i class="fa fa-mobile"></i>
	                    <span>APP配置管理</span>
	                </a>
	                <ul class="sub">
	                	<c:if test="${admin_user_permission.contains('APP_CONFIG_1')}"><li <%if("7_0".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appconfig/version/query">APP版本管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('APP_CONFIG_2')}"><li <%if("7_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appconfig/version/channel/query">APP版本渠道下载管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('APP_CONFIG_3')}"><li <%if("7_2".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appconfig/cache/query">缓存配置管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('APP_CONFIG_4')}"><li <%if("7_3".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appconfig/dbconfig/query">数据库配置管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('APP_CONFIG_5')}"><li <%if("7_4".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appconfig/ui/query">APP主题管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('APP_CONFIG_6')}"><li <%if("7_5".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appconfig/lightbox/query">APP灯箱页管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('APP_CONFIG_7')}"><li <%if("7_6".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/topicFragmentTemplate/query">足迹语言模板管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('APP_CONFIG_8')}"><li <%if("7_7".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/topicFragmentTemplate/dropAroundKingdomMgr">可串门王国管理</a></li></c:if>
	                    <c:if test="${admin_user_permission.contains('APP_CONFIG_9')}"><li <%if("7_8".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appconfig/allConfig">新APP系统配置管理</a></li></c:if>
	                </ul>
	            </li>
            </c:if>
            <c:if test="${admin_user_permission.contains('ZMJX_MGR') }">
            <li class="sub-menu">
                <a href="javascript:;" <%if("zmjx".equals(tab)){ %>class="active"<%} %>>
                    <i class="fa fa-bar-chart-o"></i>
                    <span>最美家乡活动</span>
                </a>
                <ul class="sub">
                	<c:if test="${admin_user_permission.contains('ZMJX_MGR_1')}"><li <%if("zmjx_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/zmjx/config/kingdomQuery">活动王国管理</a></li></c:if>
                	<c:if test="${admin_user_permission.contains('ZMJX_MGR_2')}"><li <%if("zmjx_2".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/zmjx/config/query">配置管理</a></li></c:if>
                </ul>
            </li>
            </c:if>
            <c:if test="${admin_user_permission.contains('LISTING_MGR') }">
	            <li class="sub-menu">
	                <a href="javascript:;" <%if("10".equals(tab)){ %>class="active"<%} %>>
	                    <i class="fa fa-bar-chart-o"></i>
	                    <span>榜单管理</span>
	                </a>
	                <ul class="sub">
	                	<c:if test="${admin_user_permission.contains('LISTING_MGR_1')}"><li <%if("10_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/ranking/list_ranking">榜单列表</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('LISTING_MGR_2')}"><li <%if("10_2".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/ranking/list_online_ranking?type=1">上线榜单管理</a></li></c:if>
	                </ul>
	            </li>
            </c:if>
            <c:if test="${admin_user_permission.contains('SEARCH_MGR') }">
	            <li class="sub-menu">
	                <a href="javascript:;" <%if("11".equals(tab)){ %>class="active"<%} %>>
	                    <i class="fa fa-bar-chart-o"></i>
	                    <span>搜索管理</span>
	                </a>
	                <ul class="sub">
	                	<c:if test="${admin_user_permission.contains('SEARCH_MGR_1')}"><li <%if("11_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/search/console">控制台</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('SEARCH_MGR_2')}"><li <%if("11_2".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/search/hotkeywordList">热词管理</a></li></c:if>
	                </ul>
	            </li>
            </c:if>
            <c:if test="${admin_user_permission.contains('MATERIAL_MGR') }">
	            <li class="sub-menu">
	                <a href="javascript:;" <%if("12".equals(tab)){ %>class="active"<%} %>>
	                    <i class="fa fa-bar-chart-o"></i>
	                    <span>素材管理</span>
	                </a>
	                <ul class="sub">
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_1')}"><li <%if("12_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/tag/query">标签管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_2')}"><li <%if("12_2".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/emotion/list_pack">表情包管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_3')}"><li <%if("12_3".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/tease/list_tease">逗一逗管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_4')}"><li <%if("12_4".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/mbtiMapping/query">MBTI王国映射管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_5')}"><li <%if("12_5".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/emotionInfo/list_emotion">情绪管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_6')}"><li <%if("12_6".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/topicCover/list">王国默认封面管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_7')}"><li <%if("12_7".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/quotation/robotList">机器人管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_8')}"><li <%if("12_8".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/quotation/quotationList">语录管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_9')}"><li <%if("12_9".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appuser/avatarFrame/list">头像框管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_10')}"><li <%if("12_10".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/gift/list_gift">礼物管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_11')}"><li <%if("12_11".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/topicCategory/listCategory">王国分类维护</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_12')}"><li <%if("12_12".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/appLottery/list">王国抽奖列表</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('MATERIAL_MGR_13')}"><li <%if("12_13".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/tag/tagSampleQuery">标签样本管理</a></li></c:if>
	                </ul>
	            </li>
           </c:if>
           <c:if test="${admin_user_permission.contains('KINGDOM_PRICE_MGR') }">
	            <li class="sub-menu">
	                <a href="javascript:;" <%if("13".equals(tab)){ %>class="active"<%} %>>
	                    <i class="fa fa-bar-chart-o"></i>
	                    <span>王国价值管理</span>
	                </a>
	                <ul class="sub">
	               		<c:if test="${admin_user_permission.contains('KINGDOM_PRICE_MGR_1')}"><li <%if("13_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/price/kingdomQuery">王国价值属性查询</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('KINGDOM_PRICE_MGR_2')}"><li <%if("13_3".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/price/taskConsole">任务控制台</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('KINGDOM_PRICE_MGR_3')}"><li <%if("13_4".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/price/listTopicPriceSubsidyConfig">补贴配置</a></li></c:if>
	                </ul>
	            </li>
            </c:if>
            <c:if test="${admin_user_permission.contains('LISTING_KINGDOM_MGR') }">
	            <li class="sub-menu">
	                <a href="javascript:;" <%if("14".equals(tab)){ %>class="active"<%} %>>
	                    <i class="fa fa-bar-chart-o"></i>
	                    <span>上市王国管理</span>
	                </a>
	                <ul class="sub">
	                	<c:if test="${admin_user_permission.contains('LISTING_KINGDOM_MGR_1')}"><li <%if("14_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/topicListed/topicListed">已上市</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('LISTING_KINGDOM_MGR_2')}"><li <%if("14_2".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/topicListed/topicListedPending">待成交</a></li></c:if>
	                </ul>
	            </li>
            </c:if>
            <c:if test="${admin_user_permission.contains('AD_MGR') }">
	            <li class="sub-menu">
	                <a href="javascript:;" <%if("15".equals(tab)){ %>class="active"<%} %>>
	                    <i class="fa fa-bar-chart-o"></i>
	                    <span>广告管理</span>
	                </a>
	                <ul class="sub">
	                	<c:if test="${admin_user_permission.contains('AD_MGR_1')}"><li <%if("15_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/ad/adBanner">广告位管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('AD_MGR_2')}"><li <%if("15_2".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/ad/adInfo">广告信息管理</a></li></c:if>
	                </ul>
	            </li>
	        </c:if>
	        <c:if test="${admin_user_permission.contains('USER_ORGANIZATION_MGR') }">
	            <li class="sub-menu">
	                <a href="javascript:;" <%if("16".equals(tab)){ %>class="active"<%} %>>
	                    <i class="fa fa-bar-chart-o"></i>
	                    <span>组织认证管理</span>
	                </a>
	                <ul class="sub">
	                	<c:if test="${admin_user_permission.contains('USER_ORGANIZATION_MGR_1')}"><li <%if("16_1".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/organization/organizationMgr">组织管理</a></li></c:if>
	                	<c:if test="${admin_user_permission.contains('USER_ORGANIZATION_MGR_2')}"><li <%if("16_2".equals(sub)){ %>class="active"<%} %>><a href="${ctx}/organization/userOrganizationMgr">用户认证</a></li></c:if>
	                </ul>
	            </li>
	        </c:if>
	        
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>

