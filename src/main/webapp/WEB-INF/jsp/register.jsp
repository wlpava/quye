<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
</head>

<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div>
			<form:form method="post" commandName="user" class="form-horizontal">
			   <form:hidden path="id"/>
			   <form:hidden path="salt"/>
			   <form:hidden path="status"/>
			   <form:hidden path="type"/>
			   <form:hidden path="roleIds"/>
			   <form:hidden path="userName"/>
			
				<c:if test="${not empty msg}"><div id="message" class="alert alert-danger fade in" style="margin-bottom: 5px; margin-top: 10px;"><button data-dismiss="alert" class="close" type="button">×</button><span>${msg}</span></div></c:if>
			
				<fieldset style="margin-top: 10px;">
					<legend>
						<small><span class="glyphicon glyphicon-user"></span> 用户注册</small>
					</legend>
			
			        <div class="form-group">
						<label class="col-sm-2 control-label">登录名</label>	 
						<div class="col-sm-5">
			            	<input type="text" id="loginName" name="loginName" value="${user.loginName}" class="form-control required" minlength="4" maxlength="20" placeholder="登录名，不能修改">
			            	 * 长度为4-20的字符
				        </div>
					</div>
			        
			        <div class="form-group">
						<label class="col-sm-2 control-label">登录密码</label>	 
						<div class="col-sm-5">
			            	<form:password path="password" minlength="4" maxlength="20" class="form-control required" placeholder="登录密码"/>
			            	 * 长度为4-20的字符
			            </div>
			        </div>
			
			        <div class="form-group">
						<label class="col-sm-2 control-label">联系电话</label>	 
						<div class="col-sm-5">
							<form:input path="phone" class="form-control number required" placeholder="如：13500000000"/>
			            </div>
			        </div>
			        
			        <div class="form-group">
						<label class="col-sm-2 control-label">电子邮件</label>	 
						<div class="col-sm-5">
							<form:input path="email" type="email" class="form-control" placeholder="如：example@domain.com"/>
			            </div>
			        </div>			        
			
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-3">
							<button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-plus-sign" style="top: 2px;"></span> 注册</button>
							<a class="btn btn-default" href="${ctx}/login"><span class="glyphicon glyphicon-circle-arrow-left" style="top: 2px;"></span> 返回</a>						
					    </div>				
					</div>			
				</fieldset>
			</form:form>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>			

</body>
</html>