<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/meta.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8" />

<title>ZX_IMS 2.0 - 用户认证信息</title>

<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/css/bootstrap-reset.css" rel="stylesheet" />
<link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="${ctx}/css/slidebars.css" rel="stylesheet" />
<link href="${ctx}/css/style.css" rel="stylesheet" />
<link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-datetimepicker/css/datetimepicker.css" />

<script src="${ctx}/js/jquery.js"></script>
<script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
</head>
<body>
	<section id="container" class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form form-inline" method="post"  >
					<p>
						<div class="form-group">
							用户名
							<input type="text" id="nickName" name="nickName" value="${dataObj.nickName }" class="form-control"/>
						</div>
						<div class="form-group">
							Me号
							<input type="text" id="meCode"  name="meCode" value="${dataObje.meCode }" class="form-control date"/>
						</div>
						<a class="btn btn-primary" href="javascript:search();">搜索</a>
				</form>
			</div>
		</div>
		<div class="adv-table">
			<table class="display table table-bordered table-striped" id="mytable" width="100%">
			</table>
		</div>
	</section>
	
<!-- 	<div class="modal inmodal fade" id="modal" tabindex="-1" role="dialog" aria-hidden="true">
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
	              <input type="text" id="organizationNumber" name="organizationNumber" class="form-control" />
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
	              <input type="text" id="birthday" name="birthday" class="form-control" />
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
			<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true" onclick="saveUserOrganization();">保存</button>
			<button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
		</div>
	</div>
			</div>
		</div>
	</div> -->
	<!-- js placed at the end of the document so the pages load faster -->
	<script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="${ctx}/js/jquery.scrollTo.min.js"></script>
	<script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="${ctx}/js/respond.min.js"></script>
	<script src="${ctx}/js/jquery.json-2.4.min.js"></script>
	<link rel="stylesheet" href="${ctx}/js/DataTables-1.10.11/media/css/jquery.dataTables.min.css" />
	<script type="text/javascript" src="${ctx}/js/DataTables-1.10.11/media/js/jquery.dataTables.min.js"></script>
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
	$('.date').datetimepicker({
		format: 'yyyy-mm-dd',
		language: 'zh',
		startView: 2,
		maxView:3,
		language:"zh",
		minView:2,
		autoclose:true,
		weekStart:1,
		todayBtn:  1
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
	
	
	var sourceTable=$('#mytable').DataTable( {
	    "ajax":{
	    	"url": ctx+"/organization/ajaxLoadUsers",
            "type": "POST",
            "data": function (d) {
                d.nickName = $("#nickName").val();
                d.meCode = $("#meCode").val();
            }
        },
        processing:true,
	    "columns": [
	        {data: "uid",title: "用户UID",style:"num"},
	        {data: "nickName",title: "用户名",style:"num"},
	        {data: "meCode",title: "Me号",style:"num"},
	        {title:"操作",width:60,render:function(data, type, row, meta){
	        	var txt= "<a href='#stop' title='uid:"+row.uid+"' class='btn btn-danger btn-xs btnAdd'>认证该用户</a> ";
	        	return txt;
	        }}
	     ]
	});
	$("#search_form").on("submit",function(){
		var data= $(this).serialize();
		var url = "./ajaxLoadUsers?"+data;
		sourceTable.ajax.url(url).load(); 
		return false;
	})
	function search(){
	 sourceTable.draw(true);
	}
	
	$(document).on("click",".btnAdd",function(){		// 父窗口添加选中用户。
		var tr = $(this).closest("tr");
		var data =sourceTable.row(tr).data();
		
		parent.onAdd(data);
	})
	
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
	</script>
</body>
</html>