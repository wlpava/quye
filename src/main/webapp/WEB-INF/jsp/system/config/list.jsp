<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script>
	$(document).ready(function() {
		$(window.parent.document).find("#nav_config").addClass("active").siblings().removeClass("active");
	});
</script>
</head>
<body>

<ol class="breadcrumb">
  <li style="margin-left: -4px;"><a href="#"><span class="glyphicon glyphicon-home" style="top: 2px;"></span> </a></li>
  <li class="active">系统管理</li>
  <li class="active">配置管理</li>
  <li class="active">配置查询</li>
</ol>

<c:if test="${not empty msg}"><div id="message" class="alert alert-success fade in" style="margin-bottom: 5px;"><button data-dismiss="alert" class="close" type="button">×</button><span>${msg}</span></div></c:if>

<shiro:hasPermission name="config:create">
    <a class="btn btn-primary" href="${ctx}/dev/config/create" style="margin-bottom:5px"><span class="glyphicon glyphicon-plus-sign" style="top: 2px;"></span> 新增参数</a><br/>
</shiro:hasPermission>

	<form class="form-inline well well-sm" style="margin-bottom: 5px;">
		<div class="row">
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-4" style="padding-right: 0px;">
						<label class="control-label">参数名称</label>
						<input type="text" class="form-control" name="search_LIKE_name"  value="${param.search_LIKE_name}">			
					</div>
				</div>
			</div>		
			<div class="col-md-2" style="padding-left: 5px">
				<button class="btn btn-primary" title="按条件查询" type="submit"><i class="glyphicon glyphicon-search" style="top: 2px;"></i> 查询</button>
				<a class="btn btn-default" title="重置刷新" href="${ctx}/dev/config/"><i class="glyphicon glyphicon-refresh" style="top: 2px;"></i> 刷新</a>
			</div>
		</div>
	</form>
	
	<table class="table table-striped table-hover table-bordered table-condensed">
	    <thead>
	        <tr class="success">
	            <th>参数名称</th>
	            <th>参数代码</th>
	            <th>参数值</th>
	            <th>操作</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${page.content}" var="config">
	            <tr>
	                <td>${config.name}</td>
	                <td>${config.code}</td>
	                <td>${config.value}</td>
	                <td>
	                    <shiro:hasPermission name="config:update">
	                        <a href="${ctx}/dev/config/${config.id}/update">修改</a>
	                    </shiro:hasPermission>
	
	                    <shiro:hasPermission name="config:delete">
	                        <a href="${ctx}/dev/config/${config.id}/delete">删除</a>
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