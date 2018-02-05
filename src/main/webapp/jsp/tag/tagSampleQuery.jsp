<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/meta.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8" />

<title>ZX_IMS 2.0 - 标签管理</title>

<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/css/bootstrap-reset.css" rel="stylesheet" />
<link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/assets/data-tables/DT_bootstrap.css" />
<link href="${ctx}/css/slidebars.css" rel="stylesheet" />
<link href="${ctx}/css/style.css" rel="stylesheet" />
<link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
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
			<jsp:param name="t" value="12" />
			<jsp:param name="s" value="12_13" />
		</jsp:include>
		<!--sidebar end-->

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
					<div class="row">
						<div class="col-lg-12">
							<section class="panel">
								<header class="panel-heading">执行操作</header>
								<div class="panel-body">
									<form id="search_form" method="get"  class="form-inline">
										<div class="form-group">
											<label>标签名</label>
											<input type="text" id="tagName" name="tagName" value="${tagName}" class="form-control">
										</div>
										
										<div class="form-group">
											<input type="submit" id="btnSearch" name="btnSearch" value="搜索" class="btn btn-info" />
											<a class="btn btn-danger" href="#" onclick="addAdBannerShow()">新建标签样本</a>
											<a class="btn btn-danger" href="#" id="refreshTagSample">同步APP后台服务</a>
										</div>
									</form>
								</div>
							</section>
						</div>
					</div>
				<!-- page start-->
				<div class="row">
					<div class="col-sm-12">
						<section class="panel">
							<header class="panel-heading">
								| 样本列表
								<span class="tools pull-right">
									<a href="javascript:;" class="fa fa-chevron-down"></a>
								</span>
							</header>
							<div class="panel-body">
								<div class="adv-table">
									<table class="display table table-bordered table-striped" id="table" width="100%">
										
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
		<div class="modal inmodal fade" id="modal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title">添加/修改标签样本</h4>
							</div>
							<div class="modal-body">
							<input type="hidden" id="id" name="id" value="0">
								<div class="form-group">
									<label for="adBannerName">标签名称</label>
			                        <input type="text" id="tag" name="tag" class="form-control" />
								</div>
								<div class="form-group">
									<label for="exampleInput">关键词</label>
			                        <textarea type="text" id="keywords" name="keywords" class="form-control" style="width:100%;height:300px"></textarea>
								</div>
							</div>
							<div class="modal-footer">
								<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true" onclick="addAdBanner();">保存</button>
								<button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
							</div>
						</div>
					</div>
				</div>
			</div>
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
	<link rel="stylesheet" href="${ctx}/js/DataTables-1.10.11/media/css/jquery.dataTables.min.css" />
	<script type="text/javascript" src="${ctx}/js/DataTables-1.10.11/media/js/jquery.dataTables.min.js"></script>
	<script src="${ctx}/js/respond.min.js"></script>
	<script src="${ctx}/js/slidebars.min.js"></script>
	<script src="${ctx}/js/bootstrap-switch.js"></script>
	<script src="${ctx}/js/jquery.tagsinput.js"></script>
	<script src="${ctx}/js/common-scripts.js"></script>
	<script type="text/javascript" src="${ctx}/assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript">
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
	$('#startTime,#endTime').datetimepicker({
		format: 'yyyy-mm-dd',
		language: 'zh',
		startView: 2,
		autoclose:true,
		weekStart:1,
		todayBtn:  1,
		minView:2
		});
	Date.prototype.Format = function(fmt)   
	{ //author: meizz   
	  var o = {   
	    "M+" : this.getMonth()+1,                 //月份   
	    "d+" : this.getDate(),                    //日   
	    "h+" : this.getHours(),                   //小时   
	    "m+" : this.getMinutes(),                 //分   
	    "s+" : this.getSeconds(),                 //秒   
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
	    "S"  : this.getMilliseconds()             //毫秒   
	  };   
	  if(/(y+)/.test(fmt))   
	    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
	  for(var k in o)   
	    if(new RegExp("("+ k +")").test(fmt))   
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	  return fmt;   
	}  
	$.fn.dataTable.ext.errMode="console";
	$.extend( $.fn.dataTable.defaults, {
		pageLength: 10,
		searching: false,
        dom: 'tp',
	    processing: true,
	    serverSide: true,
    	language: {
    		processing:     "加载中...",
    	    search:         "搜索中&nbsp;:",
    	    "lengthMenu":     "每页显示 _MENU_ 条",
    	    "info":           "当前 _START_ 到 _END_ 条，共 _TOTAL_ 条",
    	    "infoEmpty":      "当前第0条",
    	    "infoFiltered":   "(filtered from _MAX_ total entries)",
    	    infoPostFix:    "",
    	    loadingRecords: "加载数据中",
    	    zeroRecords:    "没有数据",
    	    emptyTable:     "没有数据",
    	    paginate: {
    	        first:      "第一页",
    	        previous:   "上一页",
    	        next:       "下一页",
    	        last:       "最后一页"
    	    },
    	    aria: {
    	        sortAscending:  "升序",
    	        sortDescending: "降序"
    	    },
    	    decimal: ","
        }
	} );
	
	
	var sourceTable=$('#table').DataTable( {
	    "ajax": "ajaxLoadTagSample",
	    processing:true,
	    "columns": [
	        {data: "tag",orderable:false,title: "标签名",width:200},
	        {data: "keywords",orderable:false,title: "大类标签",render:function(data){
	        	if(data.length>50){
	        		return data.substring(0,50)+"...";
	        	}else{
	        		return data;
	        	}
	        }},	       
	        {title:"操作",orderable:false,width:150,render:function(data, type, row, meta){
	        	var txt= '<a href="#" onclick="editAdBanner('+row.id+')">编辑</a> | ';
	        	txt+= '<a href="#" onclick="del('+row.id+')">删除</a>';
	        	return txt;
	        }}
	     ]
	});
	$("#search_form").on("submit",function(){
		var data= $(this).serialize();
		var url ="./ajaxLoadTagSample?"+data;
		sourceTable.ajax.url(url).load();
		return false;
	})
	function del(id){
		 var msg = "您真的确定要删除吗？"; 
		
		 if (confirm(msg)){ 
			$.post("./deleteTagSample",{id:id},function(d){
				alert("删除成功");
				sourceTable.ajax.reload( null, false ); // 刷新表格数据，分页信息不会重置
			})
		 }
    }
	function addAdBannerShow(){
		$('#modal').modal('show');
		$("#id").val("")
		$("#tag").val("")
		$("#keywords").val("");
	}
	function addAdBanner(){
		var param = {id:$("#id").val(),tag:$("#tag").val(),keywords:$("#keywords").val()};
	  	$.post("./saveTagSample",param,function(){
	  		sourceTable.ajax.reload( null, false ); // 刷新表格数据，分页信息不会重置
	  	})
	  }
	  function editAdBanner(id){
		$.getJSON("./getTagSample",{id:id},function(r){
			$('#modal').modal('show');
			$("#id").val(r.data.id)
			$("#tag").val(r.data.tag)
			$("#keywords").val(r.data.keywords);
		})
		return false;
	  }	   "rt.bat"
	  $("#refreshTagSample").click(function(){
		  if(confirm("确定同步吗？")){
			  $.post("./refreshTagSample",{r:Math.random()},function(r){
				  alert("刷新成功,后台需要重启才能生效，请联系技术手动重启search组件。")
			  })
		  }
	  })
	</script>
</body>
</html>