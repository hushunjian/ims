<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="../common/meta.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta charset="utf-8" />
    <title>ZX_IMS 2.0 - 添加用户认证信息</title>

    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/bootstrap-reset.css" rel="stylesheet">
    <link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-fileupload/bootstrap-fileupload.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-wysihtml5/bootstrap-wysihtml5.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-datepicker/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-timepicker/compiled/timepicker.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-colorpicker/css/colorpicker.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-daterangepicker/daterangepicker-bs3.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-datetimepicker/css/datetimepicker.css" />
    <link href="${ctx}/css/slidebars.css" rel="stylesheet">
    <link href="${ctx}/css/style.css" rel="stylesheet">
    <link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
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
    			<jsp:param name="t" value="16"/>
    			<jsp:param name="s" value="16_2"/>
    		</jsp:include>
            <!--sidebar end-->

            <!--main content start-->
            <section id="main-content">
            	<input type="hidden" name="id" value="${item.id}"/>
                <section class="wrapper">
                    <!-- page start-->
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
								| 用户认证信息列表
								<span class="tools pull-right">
									<a href="javascript:;" class="fa fa-chevron-down"></a>
								</span>
							</header>
							<div class="panel-body">
								<div>
									<a class="btn btn-primary dialog" href="${ctx }/organization/listUsers">
										<i  class=" fa fa-plus "></i>
										查询米汤用户信息
									</a>
								</div>
							</div>
                            </section>
                        </div>
                    </div>
	        <form id="userOragnizationForm" name="userOragnizationForm" action="${ctx }/organization/saveOragnizaionInfo"  enctype="multipart/form-data" method="post">
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
		              <input type="text" id="organizationNumber" readonly  name="organizationNumber" class="form-control" />
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
		              <input type="text" id="birthday" name="birthday" class="form-control" onclick="timeShow()"/>
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
			   <div class="form-group">
					  <input type="button" id="btnSave" value="提交" class="btn btn-danger"  onclick="check()"/>
					  <input type="button" id="getNumber" value="获取认证号" class="btn btn-danger"  onclick="number()"/>
	                  <span class="btn btn-default"><a href="javascript:history.back(-1)">返回</a></span>
			   </div>
				</div>
				</div>
				</div>
				</div>
				</form>
                </section>
                <!-- page end-->
            </section>

            <!--main content end-->

            <!-- Right Slidebar start -->
            <%@include file="../common/rightSlidebar.jsp"%>
            <!-- Right Slidebar end -->

            <!--footer start-->
            <%@include file="../common/footer.jsp"%>
            <!--footer end-->
        </section>


        <script src="${ctx}/js/jquery.js"></script>
        <script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
        <script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="${ctx}/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="${ctx}/js/jquery.scrollTo.min.js"></script>
        <script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="${ctx}/js/respond.min.js"></script>
		<script src="${ctx}/js/jquery.json-2.4.min.js"></script>
		<link rel="stylesheet" href="${ctx}/js/DataTables-1.10.11/media/css/jquery.dataTables.min.css" />
		<script type="text/javascript" src="${ctx}/js/DataTables-1.10.11/media/js/jquery.dataTables.min.js"></script>
        <!--this page plugins-->

        <script type="text/javascript" src="${ctx}/assets/fuelux/js/spinner.min.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-fileupload/bootstrap-fileupload.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-daterangepicker/moment.min.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
        <script type="text/javascript" src="${ctx}/assets/jquery-multi-select/js/jquery.multi-select.js"></script>
        <script type="text/javascript" src="${ctx}/assets/jquery-multi-select/js/jquery.quicksearch.js"></script>
		<script type="text/javascript" src="${ctx}/assets/my97datepicker/WdatePicker.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
        
        <script type="text/javascript" src="${ctx}/js/bootbox.min.js"></script>
        <!--right slidebar-->
        <script src="${ctx}/js/slidebars.min.js"></script>

        <!--custom switch-->
        <script src="${ctx}/js/bootstrap-switch.js"></script>
        <!--custom tagsinput-->
        <script src="${ctx}/js/jquery.tagsinput.js"></script>
        <!--common script for all pages-->
        <script src="${ctx}/js/common-scripts.js"></script>

        <script src="${ctx}/js/xheditor-1.2.2.min.js"></script>
        <script src="${ctx}/js/xheditor_lang/zh-cn.js"></script>
        <script src="${ctx}/js/xheditSelf.js"></script>
        <script src="${ctx}/js/messager/js/messenger.min.js"></script>
		<script src="${ctx}/js/messager/js/messenger-theme-flat.js"></script>
		<link rel="stylesheet" href="${ctx}/js/messager/css/messenger.css" />
		<link rel="stylesheet" href="${ctx}/js/messager/css/messenger-theme-flat.css" />

    <script>
    $("a.dialog").click(function(){
		var url =$(this).attr("href");
		bootbox.dialog({ 
			size:"large",
			message: "<iframe src='"+url+"' style='width:100%;min-height:750px;border:0px;'></iframe>" 
		})
		return false;
	})
	
	
	//子窗口添加数据
	function onAdd(data){
		$("input[name='uid']").val(data.uid);
		$("input[name='meCode']").val(data.meCode);
		$("input[name='nickName']").val(data.nickName);
		bootbox.hideAll();
	}
    
	$(document).ready(function(){
	  	$.ajax({
	        cache: true,
	        type: "POST",
	        dataType :"json",
	        url:ctx+"/organization/ajaxAllOrganizationList",
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
	
	function check(){
		console.info($("#uid1").val());
		if($("#uid1").val()==''){
    		alert("请选择米汤用户！！");
    		return false;
    	}
		if($("#organizationId").val()=='0'){
    		alert("请选择认证组织！");
    		return false;
    	}
		if($("#organizationNumber").val()==''){
    		alert("请选择认证号！");
    		return false;
    	}
		if($("#userName1").val()==''){
    		alert("请填写用户名！");
    		return false;
    	}
		$.ajax({
            cache: true,
            type: "POST",
            dataType :"json",
            url:ctx+"/organization/existsOrganizationInfoByUidAndOrganizationId",
            data:$('#userOragnizationForm').serialize(),
            async: true,
            error: function(request) {
                alert('服务器出错'); 
            },
            success: function(data) {
            	  if(data=='0'){
                  	$("#userOragnizationForm").submit();
                      }else{
                    	alert("该用户已认证过该组织！");
                        }
            }
        });
		}

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
