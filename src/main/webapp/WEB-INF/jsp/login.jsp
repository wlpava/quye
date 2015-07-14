<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
</head>
<script>
	$(document).ready(function() {
		$("#loginForm").validate();
		
		if ('<shiro:principal/>') {
			window.location.href = "${ctx}/";
		}
	});
</script>

<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div>
			<form id="loginForm" action="${ctx}/login" method="post" class="form-horizontal" style="margin-top: 20px;">
			<%
			String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
			if(error != null){
			%>
				<div class="alert alert-danger">
					<button class="close" data-dismiss="alert">×</button>${error}					
				</div>
			<%
			}
			%>
			<c:if test="${not empty msg}"><div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${msg}</div></c:if>
			
				<div class="form-group">
					<label class="col-sm-2 control-label">登录名</label>
					<div class="col-sm-3">
						<input type="text" id="username" name="username" value="${username}" class="form-control required" placeholder="登录名">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">登录密码</label>
					<div class="col-sm-3">
						<input type="password" id="password" name="password" class="form-control required" placeholder="登录密码">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-3">
						<div class="checkbox">
					        <label><input type="checkbox" id="rememberMe" name="rememberMe"/> 记住我</label>
					      </div>					
					</div> 
				</div>
	
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-3">
						<button class="btn btn-primary" type="submit" style="width: 80px;"><span class="glyphicon glyphicon-log-in" style="top: 2px;"></span> 登录</button>
						<a class="btn btn-default" href="${ctx}/register" style="width: 80px;"><span class="glyphicon glyphicon-plus-sign" style="top: 2px;"></span> 注册</a>					
				    </div>				
				</div>
					
			</form>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>

</body>
</html>
