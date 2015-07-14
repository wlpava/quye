<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script>
	$(document).ready(function() {
		$(window.parent.document).find("#nav_role").addClass("active").siblings().removeClass("active");
	});
</script>
</head>
<body>

<ol class="breadcrumb">
  <li style="margin-left: -4px;"><a href="#"><span class="glyphicon glyphicon-home" style="top: 2px;"></span> </a></li>
  <li class="active">系统管理</li>
  <li class="active">角色管理</li>
  <li class="active">角色查询</li>
</ol>

<c:if test="${not empty msg}"><div id="message" class="alert alert-success fade in" style="margin-bottom: 5px;"><button data-dismiss="alert" class="close" type="button">×</button><span>${msg}</span></div></c:if>

<shiro:hasPermission name="role:create">
    <a class="btn btn-primary" href="${ctx}/dev/role/create" style="margin-bottom:5px"><span class="glyphicon glyphicon-plus-sign" style="top: 2px;"></span> 新增角色</a><br/>
</shiro:hasPermission>

	<form class="form-inline well well-sm" style="margin-bottom: 5px;">
		<div class="row">
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-4" style="padding-right: 0px;">
						<label class="control-label">角色名</label>
						<input type="text" class="form-control" name="search_LIKE_name"  value="${param.search_LIKE_name}">			
					</div>
				</div>
			</div>		
			<div class="col-md-2" style="padding-left: 5px">
				<button class="btn btn-primary" title="按条件查询" type="submit"><i class="glyphicon glyphicon-search" style="top: 2px;"></i> 查询</button>
				<a class="btn btn-default" title="重置刷新" href="${ctx}/dev/role/"><i class="glyphicon glyphicon-refresh" style="top: 2px;"></i> 刷新</a>
			</div>
		</div>
	</form>	
	
	<table class="table table-striped table-hover table-bordered table-condensed">
	    <thead>
	        <tr class="success">
	            <th style="width: 100px;">角色名称</th>
	            <th style="width: 100px;">角色描述</th>
	            <th>拥有的资源</th>
	            <th style="width: 80px;">操作</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${page.content}" var="role">
	            <tr>
	                <td>${role.name}</td>
	                <td>${role.description}</td>
	                <td>${wlpava:resourceNames(role.resourceIds)}</td>
	                <td>
	                    <shiro:hasPermission name="role:update">
	                        <a href="${pageContext.request.contextPath}/dev/role/${role.id}/update">修改</a>
	                    </shiro:hasPermission>
	
	                    <shiro:hasPermission name="role:delete">
	                        <a href="${pageContext.request.contextPath}/dev/role/${role.id}/delete">删除</a>
	                    </shiro:hasPermission>
	                </td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>	
	
	<div class="row" style="margin-top: -35px; margin-right: 0px; margin-left: 0px; height: 50px;">
		<!-- <div class="span4"><a class="btn" href="save/">导出</a></div> -->
		<div class="pull-right"><tags:pagination page="${page}" /></div>
	</div>

</body>
</html>