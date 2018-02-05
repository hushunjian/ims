<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/meta.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8" />

<title>ZX_IMS 2.0 - 组织管理</title>

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
			<jsp:param name="s" value="16_1" />
		</jsp:include>
		<!--sidebar end-->

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<form id="form1" action="${ctx}/organization/organizationMgr" method="post">
					<div class="row">
						<div class="col-lg-12">
							<section class="panel">
								<header class="panel-heading">执行操作</header>
								<div class="panel-body">
									<div class="form-inline" role="form">
									认证组织名
									<input type="text" id="organizationameName" name="organizationName" value="${dataObj.organizationName }" class="form-control">&nbsp;&nbsp;
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
								| 认证组织列表 
								<span class="tools pull-right">
									<a href="javascript:addNewOrganization();" class="fa fa-plus add_link" title="添加认证组织" ></a>
									<a href="javascript:;" class="fa fa-chevron-down"></a>
								</span>
							</header>
							<div class="panel-body">
								<div class="adv-table">
									<table class="display table table-bordered table-striped" id="dynamic-table">
										<thead>
											<tr>
												<th>认证组织号</th>
												<th>认证组织名</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${dataObj.result}" var="item">
												<tr class="gradeX">
													<td>${item.id }</td>
													<td>${item.organizationName }</td>
													<td><a href="javascript:edit(${item.id },'${item.organizationName }')">编辑|</a>
														<a href="javascript:remove(${item.id })" >删除</a>
													</td>
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
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
			<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">添加新认证组织</h4>
			</div>
			<div class="modal-body">
			<div class="form-group">
				<label for="NewTopicKingUid">新组织名</label>
                   <input type="text" id="organizationName" name="organizationName" class="form-control" />
                   <input type="hidden" id="id" name="id" value="0"/>
			</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true" onclick="saveOrganization();">保存</button>
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
	<script type="text/javascript">
	function addNewOrganization(){
		$('#modal').modal('show');
	}
	
	function saveOrganization(){
		var param = {id:$("#id").val(),organizationName:$("#organizationName").val()};
		$.post("./saveOrganization",param,function(data){
			if(data=='1'){
				alert("操作成功！！");
				location.reload();
				$('#modal').modal('hide');
			}else if(data=='0'){
				alert("该认证组织已存在！");
			}else{
				alert("操作失败！！");
			}
		})
	}
	
	function edit(id,organizationName){
		$('#modal').modal('show');
		$('#organizationName').val(organizationName);
		$('#id').val(id);
	}
	
	function remove(id){
		if(confirm("确定要删除该认证组织么？？")){
			var param = {id:id};
			$.post("./remove",param,function(data){
				if(data=='1'){
					alert("删除认证组织成功！！");
					location.reload();
				}else{
					alert("删除证组织失败！！");
				}
			})
		}
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
	</script>
</body>
</html>