<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/meta.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8" />

<title>标签列表</title>

<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/css/bootstrap-reset.css" rel="stylesheet" />
<link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="${ctx}/assets/advanced-datatable/media/css/demo_page.css" rel="stylesheet" />
<link href="${ctx}/assets/advanced-datatable/media/css/demo_table.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/assets/data-tables/DT_bootstrap.css" />
<link href="${ctx}/css/slidebars.css" rel="stylesheet" />
<link href="${ctx}/css/style.css" rel="stylesheet" />
<link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/js/DataTables-1.10.11/media/css/jquery.dataTables.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-datetimepicker/css/datetimepicker.css" />
<script src="${ctx}/js/jquery.js"></script>
<script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>

</head>
<body>
	<section id="container" class="">
		<!--header start-->
		<%@include file="../common/header.jsp"%>
		<!--header end-->

		<!--sidebar start-->
		<jsp:include page="../common/leftmenu.jsp" flush="false">
			<jsp:param name="t" value="15" />
			<jsp:param name="s" value="15_1" />
		</jsp:include>
		<!--sidebar end-->

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<!-- page start-->
				<div class="row">
					<div class="col-sm-12">
						<section class="panel">
							<div class="panel-body">
								<div>
									<a class="btn btn-primary" href="javascript:addAdBannerShow()">
										<i  class=" fa fa-plus "></i>
										添加标签
									</a>
									<a class="btn btn-primary" href="./adBanner">
										返回										
									</a>
								</div>
								<br>
								<div class="adv-table">
								<table class="display table table-bordered table-striped" id="mytable" width="100%">
									<tr>
										<th>标签名</th>
										<th>位置</th>
										<th>操作</th>
									</tr>
									<c:forEach var="tag" items="${adBannerTag}">
										<tr>
											<td>${tag.tag }</td>
											<td>${tag.position }</td>
											<td><a href="#" onclick="del(${tag.id})">删除</a></td>
										</tr>
									</c:forEach>
		                           	</table>
								</div>
							</div>
						</section>
					</div>
					
			<div class="modal inmodal fade" id="modal" tabindex="-1" role="dialog" aria-hidden="true">
					<div class="modal-dialog modal-md">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">添加修改关联</h4>
						</div>
						<div class="modal-body">
							<form id="frmTag">
								<input type="hidden" id="id" name="id" value="0">
								<input type="hidden" id="banner_id" name="banner_id" value="${adBanner.id}">
								
								<div class="form-group">
									<label for="exampleInput">标签</label>
			                        <input type="text" class="form-control" name="tag"/>
								</div>
								<div class="form-group">
									<label for="exampleInput">位置</label>
			                        <input type="text" id="position" name="position" class="form-control" />
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true" onclick="addAdBanner();">保存</button>
							<button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
						</div>
						</div>
				</div>
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
	
	<!-- js placed at the end of the document so the pages load faster -->
	<script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="${ctx}/js/jquery.scrollTo.min.js"></script>
	<script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/assets/advanced-datatable/media/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="${ctx}/assets/data-tables/DT_bootstrap.js"></script>
	<script src="${ctx}/js/respond.min.js"></script>
	<script src="${ctx}/js/slidebars.min.js"></script>
	<script src="${ctx}/js/dynamic_table_init_0_asc.js"></script>
	<script src="${ctx}/js/bootstrap-switch.js"></script>
	<script src="${ctx}/js/jquery.tagsinput.js"></script>
	<script src="${ctx}/js/form-component.js"></script>
	<script src="${ctx}/js/common-scripts.js"></script>
	<script src="${ctx}/js/advanced-form-components.js"></script>	
	<script type="text/javascript" src="${ctx}/js/DataTables-1.10.11/media/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${ctx}/assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
	
	<script type="text/javascript">
	
	function del(id){
		 var msg = "您真的确定要删除吗？"; 
		 if (confirm(msg)){ 
			 $.post("./delBannerTagMapping",{mapperId:id},function(){
				 location.reload();
			 })
		 }
    }
	function addAdBannerShow(){
		$('#modal').modal('show');
	}
   	function addAdBanner(){
		var data =$("#frmTag").serializeArray();
		
		$.post("./addBannerTagMapping",data,function(ret){
			if(ret.code==0){
				alert(ret.desc);
			}else{
				location.reload();
			}
		})
    }
	 	   
    $('#modal').on('hidden.bs.modal', function () {
		  $("#id").val(0);
		  $("#adBannerName").val('');
		  $("#bannerPosition").val('');
		  $("#type").val('');
   });
	
	
	</script>
</body>
</html>