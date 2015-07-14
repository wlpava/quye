<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script>
	$(document).ready(function() {
		$(window.parent.document).find("#nav_user").addClass("active").siblings().removeClass("active");
	});
</script>
</head>
<body>

<ol class="breadcrumb">
  <li style="margin-left: -4px;"><a href="#"><span class="glyphicon glyphicon-home" style="top: 2px;"></span> </a></li>
  <li class="active">系统管理</li>
  <li class="active">用户管理</li>
  <li class="active">修改密码</li>
</ol>

	<form method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${user.id}">
		<input type="hidden" name="status" value="${user.status}">
		<fieldset>
			<legend>
				<small>${op}密码</small>
			</legend>
			
						
			<div class="form-group">
				<label class="col-sm-2 control-label">* 新密码</label>
				<div class="col-sm-3">
					<input type="text" id="newPassword" name="newPassword" class="form-control required"/>
				</div>
			</div>			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-3">
					<button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-ok-sign" style="top: 2px;"></span> ${op}</button>
				</div>
			</div>				
			
		</fieldset>
		
	</form>

</body>
</html>