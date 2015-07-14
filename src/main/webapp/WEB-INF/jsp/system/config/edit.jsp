<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script>
	$(document).ready(function() {
		$(window.parent.document).find("#nav_config").addClass("active").siblings().removeClass("active");
		
		$("#inputForm").validate({
			rules: {
				name: {
					remote: "${ctx}/dev/config/checkConfigName?oldName=${config.name}"
				},
				code: {
					remote: "${ctx}/dev/config/checkConfigCode?oldCode=${config.code}"
				}
			},
			messages: {
				name: {
					remote: "此名称已存在"
				},
				code: {
					remote: "此代码已存在"
				}
			}
		});		
	});
</script>     
</head>
<body>

<ol class="breadcrumb">
  <li style="margin-left: -4px;"><a href="#"><span class="glyphicon glyphicon-home" style="top: 2px;"></span> </a></li>
  <li class="active">系统管理</li>
  <li class="active">配置管理</li>
  <li class="active">配置编辑</li>
</ol>

<form:form  id="inputForm" method="post" commandName="config" class="form-horizontal">
   <form:hidden path="id"/>
   
	<fieldset>
		<legend>
			<small>${op}参数</small>
		</legend>   

        <div class="form-group">
			<label class="col-sm-2 control-label">* 参数名称</label>	 
			<div class="col-sm-5">
            	<form:input path="name" class="form-control required" placeholder="参数中文名称"/>
            </div>
        </div>
        
        <div class="form-group">
			<label class="col-sm-2 control-label">* 参数代码</label>	 
			<div class="col-sm-5">
            	<form:input path="code" class="form-control required" placeholder="参数英文key"/>
            </div>
        </div>
        
        <div class="form-group">
			<label class="col-sm-2 control-label">* 参数值</label>	 
			<div class="col-sm-5">
            	<form:input path="value" class="form-control required" placeholder="参数value"/>
            </div>
        </div>
        
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-3">
				<button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-ok-sign" style="top: 2px;"></span> ${op}</button>
				<a class="btn btn-default" href="${ctx}/dev/config/"><span class="glyphicon glyphicon-circle-arrow-left" style="top: 2px;"></span> 返回</a>
			</div>
		</div>
		
	</fieldset>
	
</form:form>

</body>
</html>
