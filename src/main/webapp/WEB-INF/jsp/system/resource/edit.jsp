<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script>
	$(document).ready(function() {
		$(window.parent.document).find("#nav_resource").addClass("active").siblings().removeClass("active");
	});
</script>   
</head>
<body>

<ol class="breadcrumb">
  <li style="margin-left: -4px;"><a href="#"><span class="glyphicon glyphicon-home" style="top: 2px;"></span> </a></li>
  <li class="active">系统管理</li>
  <li class="active">资源管理</li>
  <li class="active">资源编辑</li>
</ol>

<form:form method="post" commandName="resource" class="form-horizontal">
    <form:hidden path="id"/>
    <form:hidden path="status"/>
    <form:hidden path="parentId"/>
    <form:hidden path="parentIds"/>
   
	<fieldset>
		<legend>
			<small>${op}资源</small>
		</legend>      

        <c:if test="${not empty parent}">
	        <div class="form-group">
				<label class="col-sm-2 control-label">父节点名称</label>	 
				<div class="col-sm-5">
	            	<input type="text" value="${parent.name}" class="form-control" readonly="readonly">
	            </div>
	        </div>        
        </c:if>

        <div class="form-group">
			<label class="col-sm-2 control-label">* 名称</label>	 
			<div class="col-sm-5">
            	<form:input path="name" class="form-control required"/>
            </div>
        </div>  
        <div class="form-group">
			<label class="col-sm-2 control-label">* 类型</label>	 
			<div class="col-sm-5">
            	<form:select path="type" items="${types}" itemLabel="info" class="form-control"/>
            </div>
        </div>  
        <div class="form-group">
			<label class="col-sm-2 control-label">* 权限字符串</label>	 
			<div class="col-sm-5">
            	<form:input path="permission" class="form-control required" placeholder="对象:操作，如：user:create"/>
            </div>
        </div>        
        <div class="form-group">
			<label class="col-sm-2 control-label">URL路径</label>	 
			<div class="col-sm-5">
            	<form:input path="url" class="form-control"/>
            </div>
        </div>  
        
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-3">
				<button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-ok-sign" style="top: 2px;"></span> ${op}</button>
				<a class="btn btn-default" href="${ctx}/dev/resource/"><span class="glyphicon glyphicon-circle-arrow-left" style="top: 2px;"></span> 返回</a>
			</div>
		</div>	
		
	</fieldset>
	
</form:form>

</body>
</html>