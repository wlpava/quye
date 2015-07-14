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
  <li class="active">用户编辑</li>
</ol>

<form:form method="post" commandName="user" class="form-horizontal">
   <form:hidden path="id"/>
   <form:hidden path="salt"/>
   <form:hidden path="status"/>

	<fieldset>
		<legend>
			<small>${op}用户</small>
		</legend>

        <div class="form-group">
			<label class="col-sm-2 control-label">* 登录名</label>	 
			<div class="col-sm-5">
            	<input type="text" id="loginName" name="loginName" value="${user.loginName}" 
            		<c:if test="${op ne '新增'}"> readonly="readonly"</c:if> class="form-control required" minlength="4" maxlength="20" placeholder="登录名，长度为4-20的字符，不能修改">
	        </div>
		</div>

        <c:if test="${op eq '新增'}">
	        <div class="form-group">
				<label class="col-sm-2 control-label">* 登录密码</label>	 
				<div class="col-sm-5">
	            	<form:password path="password" class="form-control required" minlength="4" maxlength="20" placeholder="登录密码，长度为4-20的字符"/> 
	            </div>
	        </div>
        </c:if>
        <c:if test="${op ne '新增'}">
            <form:hidden path="password"/>
        </c:if> 
        
        <div class="form-group">
			<label class="col-sm-2 control-label">* 用户姓名</label>	 
			<div class="col-sm-5">
				<form:input path="userName" class="form-control required" placeholder="用户姓名"/>
            </div>
        </div>

        <div class="form-group">
			<label class="col-sm-2 control-label">* 用户类型</label>	 
			<div class="col-sm-5">
				<select id="type" name="type" class="form-control ">
					<c:forEach var="item" items="${userTypeMap}">
						<option value="${item.key }"
							<c:if test="${user.type==item.key}">
								selected="selected"
							</c:if>
						>
							${item.value}
						</option>
					</c:forEach>
				</select>
            </div>
        </div>

        <div class="form-group">
			<label class="col-sm-2 control-label">角色列表</label>	 
			<div class="col-sm-5">
				<form:select path="roleIds" items="${roleList}" itemLabel="name" itemValue="id" multiple="true" class="form-control "/>
            </div>
        </div>
        
        <div class="form-group">
			<label class="col-sm-2 control-label">联系电话</label>	 
			<div class="col-sm-5">
				<form:input path="phone" class="form-control number" placeholder="如：13500000000"/>
            </div>
        </div>

        <div class="form-group">
			<label class="col-sm-2 control-label">电子邮件</label>	 
			<div class="col-sm-5">
				<form:input path="email" type="email" class="form-control" placeholder="如：example@domain.com"/>
            </div>
        </div>
        
		<!--
        <c:if test="${op ne '新增'}">
	        <div class="control-group">
				<label class="control-label">登录IP</label>	 
				<div class="controls">
					<form:input path="loginIp" readonly="true"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="loginTime">最后登录时间：</form:label>
	            <form:input path="loginTime"/>
	        </div>
        </c:if>
        -->        
    
        
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-3">
				<button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-ok-sign" style="top: 2px;"></span> ${op}</button>
				<a class="btn btn-default" href="${ctx}/dev/user/"><span class="glyphicon glyphicon-circle-arrow-left" style="top: 2px;"></span> 返回</a>
			</div>
		</div>	    
		
	</fieldset>
	
</form:form>

</body>
</html>