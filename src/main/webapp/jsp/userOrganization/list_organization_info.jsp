<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/meta.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8" />

<title>ZX_IMS 2.0 - 用户认证</title>

<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/css/bootstrap-reset.css" rel="stylesheet" />
<link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="${ctx}/assets/advanced-datatable/media/css/demo_page.css" rel="stylesheet" />
<link href="${ctx}/assets/advanced-datatable/media/css/demo_table.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/assets/data-tables/DT_bootstrap.css" />
<link href="${ctx}/css/slidebars.css" rel="stylesheet" />
<link href="${ctx}/css/style.css" rel="stylesheet" />
<link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-datetimepicker/css/datetimepicker.css" />

<script src="${ctx}/js/jquery.js"></script>
<script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<section id="container" class="">
		<!--header start-->
		<%@include file="../common/header.jsp"%>
		<!--header end-->

		<!--sidebar start-->
		<jsp:include page="../common/leftmenu.jsp" flush="false">
			<jsp:param name="t" value="16" />
			<jsp:param name="s" value="16_2" />
		</jsp:include>
		<!--sidebar end-->

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<form id="form1" action="${ctx}/organization/userOrganizationMgr" method="post" >
					<div class="row">
						<div class="col-lg-12">
							<section class="panel">
								<header class="panel-heading">执行操作</header>
								<div class="panel-body">
									<div class="form-inline" role="form">
										用户uid
										<input type="text" id="uid" name="uid" value="${dataObj.uid==0?'':dataObj.uid }" class="form-control">&nbsp;&nbsp;
										昵称
										<input type="text" id="nickName" name="nickName" value="${dataObj.nickName }" class="form-control">&nbsp;&nbsp;
										ME号
										<input type="text" id="meCode" name="meCode" value="${dataObj.meCode }" class="form-control">
										用户姓名
										<input type="text" id="userName" name="userName" value="${dataObj.userName }" class="form-control">
										手机号
										<input type="text" id="mobile" name="mobile" value="${dataObj.mobile }" class="form-control">&nbsp;&nbsp;
										<input type="submit" id="btnSearch" name="btnSearch" value="搜索" class="btn btn-info" />
									</div>
									<br/>
								</div>
							</section>
						</div>
					</div>
				</form>
				<!-- page start-->
				<div class="row">
					<div class="col-sm-12">
						<section class="panel">
							<header class="panel-heading">
								| 用户认证信息列表 
								<span class="tools pull-right">
									<a href="./addOrganizationInfo" class="fa fa-plus add_link" title="添加新认证信息" ></a>
									<a href="javascript:;" class="fa fa-chevron-down"></a>
								</span>
							</header>
							<div class="panel-body">
								<div class="adv-table">
									<table class="display table table-bordered table-striped" id="dynamic-table">
										<thead>
											<tr>
												<th>ME号</th>
												<th>米汤用户名</th>
												<th>认证组织</th>
												<th>认证号</th>
												<th>用户姓名</th>
												<th>性别</th>
												<th>微信名</th>
												<th>用户微信号</th>
												<th>手机号1</th>
												<th>出生年月日</th>
												<th>备注1</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${dataObj.result}" var="userItem">
												<tr class="gradeX" key="${userItem.id }">
													<th>${userItem.meCode }</th>
													<th>${userItem.nickName }</th>
													<th>${userItem.organizationName }</th>
													<th>${userItem.organizationNumber }</th>
													<th>${userItem.userName }</th>
													<th>
													<c:choose>
                                                		<c:when test="${userItem.gender == '1'}">
                                                			男
                                                		</c:when>
                                                		<c:otherwise>
                                                			女
                                                		</c:otherwise>
                                                	</c:choose>
													</th>
													<th>${userItem.wechatName }</th>
													<th>${userItem.wechatNumber }</th>
													<th>${userItem.mobile1 }</th>
													<th>${userItem.birthday }</th>
													<th>${userItem.remark1 }</th>
													<th><a href="javascript:edit(${userItem.id })">编辑|</a>
														<a href="javascript:remove(${userItem.id })">取消认证</a>
													</th>
												</tr>
											</c:forEach>
										</tbody>
										
									</table>
								</div>
							</div>
						</section>
					</div>
				</div>
				<!-- page end-->
			</section>
		</section>
		<!--main content end-->

		<!-- Right Slidebar start -->
		<%@include file="../common/rightSlidebar.jsp"%>
		<!-- Right Slidebar end -->

		<!--footer start-->
		<%@include file="../common/footer.jsp"%>
		<!--footer end-->
	</section>
	
	<!-- modal VIEW -->
		<div class="modal inmodal fade" id="modal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg">
		<div class="modal-content">
		<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">用户认证信息</h4>
		</div>
		<div class="modal-body">
		
		<form id="userOragnizationForm" name="userOragnizationForm"  enctype="multipart/form-data" method="post">
		<input type="hidden" id="id1" name="id" value="0">
		   <div class="row">
           <div class="col-lg-12">
		   <div role="row">
           <div class="col-lg-6">
		   <div class="form-group">
			<label>用户UID</label>
	              <input type="text" id="uid1" name="uid" readonly class="form-control" />
		   </div>
		   <div class="form-group">
		   <label>Me号</label>
	              <input type="text" id="meCode1" name="meCode" readonly class="form-control" />
		   </div>
		   <div class="form-group">
			<label>米汤用户名</label>
	              <input type="text" id="nickName1" name="nickName" readonly class="form-control" />
		   </div>
		   <div class="form-group">
			<label>认证组织</label>
	              <select name="organizationId" id="organizationId" class="form-control">
                      	<option value="0">未选择</option>
				  </select>
		   </div>
		   <div class="form-group">
			<label>认证号</label>
	              <input type="text" id="organizationNumber" readonly name="organizationNumber" class="form-control" />
		   </div>	
		   <div class="form-group">
			<label>用户姓名</label>
	              <input type="text" id="userName1" name="userName" class="form-control" />
		   </div>
		   <div class="form-group">
			<label>性别</label>
              <select name="gender" id="gender" class="form-control">
					<option value="0">女</option>
					<option value="1">男</option>
			  </select>
		   </div>
		   <div class="form-group">
			<label>微信名</label>
	              <input type="text" id="wechatName" name="wechatName" class="form-control" />
		   </div>
		   <div class="form-group">
			<label>用户微信号</label>
	              <input type="text" id="wechatNumber" name="wechatNumber" class="form-control" />
		   </div>
		   <div class="form-group">
			<label>手机号1</label>
	              <input type="text" id="mobile1" name="mobile1" class="form-control" />
		   </div> 		
			</div>
			<div class="col-lg-6">
			<div class="form-group">
			<label>手机号2</label>
	              <input type="text" id="mobile2" name="mobile2" class="form-control" />
		   </div>
		   <div class="form-group">
			<label>用户生日</label>
	              <input type="text" id="birthday" name="birthday" class="form-control" onclick="timeShow()" />
		   </div>
		   <div class="form-group">
			<label>年龄</label>
	              <input type="text" id="age" name="age" class="form-control" />
		   </div>
		   <div class="form-group">
			<label>地址</label>
	              <input type="text" id="address" name="address" class="form-control" />
		   </div>
		   <div class="form-group">
			<label>备注1</label>
	              <input type="text" id="remark1" name="remark1" class="form-control" />
		   </div>
		   <div class="form-group">
			<label>备注2</label>
	              <input type="text" id="remark2" name="remark2" class="form-control" />
		   </div>
		   <div class="form-group">
			<label>备注3</label>
	              <input type="text" id="remark3" name="remark3" class="form-control" />
		   </div>
		   <div class="form-group">
			<label>备注4</label>
	              <input type="text" id="remark4" name="remark4" class="form-control" />
		   </div>
		   <div class="form-group">
			<label>输出备注1</label>
	              <input type="text" id="outRemark1" name="outRemark1" class="form-control" />
		   </div>
			</div>
			</div>
			</div>
			</div>
			</form>
			</div>
		<div class="modal-footer">
			<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true" onclick="saveUserOrganization()">保存</button>
			<input type="button" id="getNumber" value="获取认证号" class="btn btn-danger"  onclick="number()"/>
			<button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
		</div>
	</div>
			</div>
		</div>
	</div>

	
	<!-- js placed at the end of the document so the pages load faster -->
	<script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="${ctx}/js/jquery.scrollTo.min.js"></script>
	<script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/assets/advanced-datatable/media/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="${ctx}/assets/data-tables/DT_bootstrap.js"></script>
	<script src="${ctx}/js/respond.min.js"></script>
	<script src="${ctx}/js/slidebars.min.js"></script>
	<script src="${ctx}/js/dynamic_table_init.js"></script>
	<script src="${ctx}/js/bootstrap-switch.js"></script>
	<script src="${ctx}/js/jquery.tagsinput.js"></script>
	<script src="${ctx}/js/form-component.js"></script>
	<script src="${ctx}/js/common-scripts.js"></script>
	<script src="${ctx}/js/advanced-form-components.js"></script>
	<script type="text/javascript" src="${ctx}/assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="${ctx}/assets/my97datepicker/WdatePicker.js"></script>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
	  	$.ajax({
	        cache: true,
	        type: "POST",
	        dataType :"json",
	        url:"./ajaxAllOrganizationList",
	        async: true,
	        error: function(request) {
	            alert('服务器出错'); 
	        },
	        success: function(data) {
        	  if(data!=null && data!=''){
        		  for(var i in data){  
        	            $("#organizationId").append("<option value='"+data[i].id+"'>"+data[i].organizationName+"</option>");
        	        }
        	  }else{
                 }
	        }
	    });
   });
	  
	function remove(id){
		if(confirm("确定要取消对该用户的认证么？？？")){
			var param = {id:id};
			$.post("./removeOrganizationInfo",param,function(data){
				if(data=='1'){
					alert("取消认证成功！！");
					location.reload();
				}else{
					alert("操作失败！！");
				}
			})
		}
	}
	
	function edit(id){
		var param = {id:id};
		$.post("./edit",param,function(data){
			$('#modal').modal('show');
			$('#id1').val(data.id);
			$('#uid1').val(data.uid);
			$('#meCode1').val(data.meCode);
			$('#nickName1').val(data.nickName);
			$('#organizationId').val(data.organizationId);
			$('#organizationNumber').val(data.organizationNumber);
			$('#userName1').val(data.userName);
			$('#gender').val(data.gender);
			$('#wechatName').val(data.wechatName);
			$('#wechatNumber').val(data.wechatNumber);
			$('#mobile1').val(data.mobile1);
			$('#mobile2').val(data.mobile2);
			$('#birthday').val(data.birthday);
			$('#age').val(data.age);
			$('#address').val(data.address);
			$('#remark1').val(data.remark1);
			$('#remark2').val(data.remark2);
			$('#remark3').val(data.remark3);
			$('#remark4').val(data.remark4);
			$('#outRemark1').val(data.outRemark1);
			
		})
	}
	
	function saveUserOrganization(){
	 var formData = new FormData($( "#userOragnizationForm" )[0]); 
	  	$.ajax({
	            type: "POST",
	            url:"./saveOragnizaionInfo",
	            async: false,  
	            cache: false,  
	            contentType: false,  
	            processData: false,  
	            data:formData,
	            error: function(request) {
	                alert(request.status); 
	            },
	            success: function(data) {
            	  if(data!=null){
            		  alert('操作成功');
            		  location.reload();
            		  $('#modal').modal('hide');
            	  }else{
                    	alert("操作失败");
                    }
	            }
	        }); 
	}
	$.fn.datetimepicker.dates['zh'] = {  
            days:       ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六","星期日"],  
            daysShort:  ["日", "一", "二", "三", "四", "五", "六","日"],  
            daysMin:    ["日", "一", "二", "三", "四", "五", "六","日"],  
            months:     ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月","十二月"],  
            monthsShort:  ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],  
            meridiem:    ["上午", "下午"],  
            //suffix:      ["st", "nd", "rd", "th"],  
            today:       "今天"  
    };
	$('#startTime').datetimepicker({
		format: 'yyyy-mm-dd hh:ii:ss',
		language: 'zh',
		startView: 4,
		autoclose:true,
		weekStart:1,
		todayBtn:  1
		});
	$('#endTime').datetimepicker({
		format: 'yyyy-mm-dd hh:ii:ss',
		language: 'zh',
		startView: 4,
		autoclose:true,
		weekStart:1,
		todayBtn:  1
		});
	
	function timeShow(){
		WdatePicker({
			dateFmt:'yyyy-MM-dd',
			//minDate:today,
			maxDate:birthday
			});
	}
	function number(){
		$.ajax({
            cache: true,
            type: "get",
            url:ctx+"/organization/MD5",
            async: true,
            error: function(request) {
                alert('服务器出错'); 
            },
            success: function(data) {
				  $('#organizationNumber').val(data);
            }
        });
	}
	
	</script>
</body>
</html>