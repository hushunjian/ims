<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="../common/meta.jsp"%>
    <meta charset="utf-8" />
    <title>ZX_IMS 2.0 </title>
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/css/bootstrap-reset.css" rel="stylesheet" />
<link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="${ctx}/assets/advanced-datatable/media/css/demo_page.css" rel="stylesheet" />
<link href="${ctx}/assets/advanced-datatable/media/css/demo_table.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/assets/data-tables/DT_bootstrap.css" />
<link href="${ctx}/css/slidebars.css" rel="stylesheet" />
<link href="${ctx}/css/style.css" rel="stylesheet" />
<link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
<link href="${ctx}/js/zTree_v3-3.5.29/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" />

<script src="${ctx}/js/jquery.js"></script>
<script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/zTree_v3-3.5.29/js/jquery.ztree.all.js"></script>
<style>
	select{height:300px;width:200px}
	#userGoupList label{padding:3px 5px;}
	.settingBlock{width:300px;float:left;border: 0px dashed #ddd;margin-right:5px;padding:10px;}
	.loading{display:block;position:fixed;z-index:2222;left:50%;top:30%;margin-left:-70px;background:#fff;padding:20px 100px;}
</style>


</head>

<body class="login-body">
	<div class="loading">
		<img src="${ctx }/img/input-spinner.gif" class=""/>loading...
	</div>
   <section id="container" class="">
		<!--header start-->
		<%@include file="../common/header.jsp"%>
		<!--header end-->

		<!--sidebar start-->
		<jsp:include page="../common/leftmenu.jsp" flush="false">
			<jsp:param name="t" value="6" />
			<jsp:param name="s" value="6_5" />
		</jsp:include>

		<section id="main-content">
			<section class="wrapper">
					<div class="settingBlock">
						<p>角色列表</p>
						<select id="roleList" multiple="multiple" class="selectbox" size="20">
						</select>
					</div>
					
					<div class="settingBlock">
						<span>角色权限</span>
						<ul id="ztree" class="ztree">
						</ul>
						<button class="btn btn-primary" id="saveRolePermission">保存角色权限更改</button>
					</div>
				   <div class="clearfix"></div>
				   <hr style="border:5px solid #999!important;"/>
					<div class="settingBlock">
							<p>用户列表</p>
							<select id="userList" multiple="multiple" size="20">
							</select>
					</div>
					<div class="settingBlock">
						<p>所属分组</p>
						<div id="userGoupList">
							
						</div>
						<button class="btn btn-primary" id="saveUserRole">保存用户角色更改</button>
					</div>
					<div class="settingBlock">
							<span>
								用户专项权限
							</span>
							<ul id="ztree2User" class="ztree">
							</ul>
							<button class="btn btn-primary" id="saveUserPermission">保存用户权限更改</button>
					</div>
				
			</section>
		</section>

		<%@include file="../common/footer.jsp"%>
	</section>
	<script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="${ctx}/js/jquery.scrollTo.min.js"></script>
	<script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="${ctx}/js/respond.min.js"></script>
	<script src="${ctx}/js/slidebars.min.js"></script>
	<script src="${ctx}/js/common-scripts.js"></script>
<script>
var $roleList =$("#roleList");
var $userRoles=$("#userGoupList")
var $userList =$("#userList");
var rolePermissionTree,userPermissionTree;
	$.ajaxSetup({
	  cache:false,
	  beforeSend:function(){$(".loading").show();},
	  complete:function(){$(".loading").hide();}
	});
	$.getJSON("${ctx}/ims/feature/getAllFeatures",function(data){
		rolePermissionTree=$.fn.zTree.init($("#ztree"), {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true,
					pIdKey:"pid",
				}
			}
		},data.data);
		userPermissionTree=$.fn.zTree.init($("#ztree2User"), {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true,
					pIdKey:"pid",
				}
			}
		},data.data);
		
	});
	
	$.getJSON("${ctx}/ims/role/getAllRoles",function(d){
		$.each(d.data,function(i,n){
			$roleList.append("<option value='"+n.id+"'>"+n.name+"</option>");
			$userRoles.append("<label><input type='checkbox' value='"+n.id+"'/>"+n.name+"</label>")
		})
	})
	$.getJSON("${ctx}/ims/user/getAllUsers",function(d){
		$.each(d.data,function(i,n){
			$userList.append("<option value='"+n.id+"'>"+n.userName+"</option>");
		})
	})
	
	$roleList.on("click","option",function(){
		var id=$(this).attr("value");
		rolePermissionTree.checkAllNodes(false);
		$.getJSON("${ctx}/ims/role/getRoleFeatures",{roleId:id},function(data){
			$.each(data.data,function(i,n){
				var node = rolePermissionTree.getNodeByParam("id",n.id, null);
				rolePermissionTree.checkNode(node, true, false);
			})
		})
	})
	$("#saveRolePermission").click(function(){
		var nodes = rolePermissionTree.getCheckedNodes(true);
		var roleId= $roleList.val()[0];
		var permissions =[];
		$.each(nodes,function(i,n){
			permissions.push(n.id);
		})
		var permissionIds = permissions.join(",");
		if(roleId!=null && roleId !="" && confirm("确认保存吗？")){
			$.post("${ctx}/ims/role/coverRoleFeatures",{roleId:roleId,featureIds:permissionIds},function(data){
				alert(data.desc);
			})
		}
	})
	$userList.on("click","option",function(){
		var id=$(this).attr("value");
		userPermissionTree.checkAllNodes(false);
		$userRoles.find("input").removeAttr("checked");
		$.getJSON("${ctx}/ims/user/getUserFeatures",{userId:id},function(data){
			$.each(data.data,function(i,n){
				var node = userPermissionTree.getNodeByParam("id",n.id, null);
				userPermissionTree.checkNode(node, true, false);
			})
		})
		
		$.getJSON("${ctx}/ims/user/getUserRoles",{userId:id},function(data){
			$.each(data.data,function(i,n){
				$userRoles.find("input[value='"+n.id+"']").attr("checked","checked")
			})
		})
	})
	$("#saveUserRole").click(function(){
		var userId= $userList.val()[0];
		var roles =[];
		$userRoles.find("input").each(function(i,n){
			if($(this).attr("checked")){
				roles.push($(this).attr("value"));
			}
		});
		var roleIds = roles.join(",");
		if(userId!=null && userId !="" && confirm("确认保存吗？")){
			$.post("${ctx}/ims/user/coverUserRoles",{userId:userId,roleIds:roleIds},function(data){
				alert(data.desc);
			})
		}
	})
	$("#saveUserPermission").click(function(){
		var nodes = userPermissionTree.getCheckedNodes(true);
		var userId= $userList.val()[0];
		var permissions =[];
		$.each(nodes,function(i,n){
			permissions.push(n.id);
		})
		var permissionIds = permissions.join(",");
		if(userId!=null && userId !="" && confirm("确认保存吗？")){
			$.post("${ctx}/ims/user/coverUserFeatures",{userId:userId,featureIds:permissionIds},function(data){
				alert(data.desc);
			})
		}
	})
</script>
</body>
</html>
