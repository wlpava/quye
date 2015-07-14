<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script>
	$(document).ready(function() {
		$(window.parent.document).find("#nav_bulletin").addClass("active").siblings().removeClass("active");
	});
</script>
</head>
<body>

<ol class="breadcrumb">
  <li style="margin-left: -4px;"><a href="#"><span class="glyphicon glyphicon-home" style="top: 2px;"></span> </a></li>
  <li class="active">系统管理</li>
  <li class="active">公告管理</li>
  <li class="active">公告查询</li>
</ol>

<c:if test="${not empty msg}"><div id="message" class="alert alert-success fade in" style="margin-bottom: 5px;"><button data-dismiss="alert" class="close" type="button">×</button><span>${msg}</span></div></c:if>

<shiro:hasPermission name="bulletin:create">
    <a class="btn btn-primary" href="${ctx}/dev/bulletin/create" style="margin-bottom:5px"><span class="glyphicon glyphicon-plus-sign" style="top: 2px;"></span> 新增公告</a><br/>
</shiro:hasPermission>

	<form class="form-inline well well-sm" style="margin-bottom: 5px;">
		<div class="row">
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-4" style="padding-right: 0px;">
						<label class="control-label">状态</label>
						<input type="text" class="form-control" name="search_EQ_status"  value="${param.search_EQ_status}">			
					</div>
				</div>
			</div>		
			<div class="col-md-2" style="padding-left: 5px">
				<button class="btn btn-primary" title="按条件查询" type="submit"><i class="glyphicon glyphicon-search" style="top: 2px;"></i> 查询</button>
				<a class="btn btn-default" title="重置刷新" href="${ctx}/dev/bulletin/"><i class="glyphicon glyphicon-refresh" style="top: 2px;"></i> 刷新</a>
			</div>
		</div>
	</form>
	
	<table class="table table-striped table-hover table-bordered table-condensed">
	    <thead>
	        <tr class="success">
	            <th>公告内容</th>
	            <th>创建者</th>
	            <th>创建时间</th>
	            <th>状态</th>
	            <th>操作</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${page.content}" var="bulletin">
	            <tr>
	                <td>${bulletin.content}</td>
	                <td>${bulletin.creator}</td>
	                <td>${wlpava:dateTime(bulletin.createTime)}</td>
	                <td>${wlpava:intToString(bulletinStatusMap, bulletin.status)}</td>
	                <td>
	                    <shiro:hasPermission name="bulletin:update">
	                        <a href="${ctx}/dev/bulletin/${bulletin.id}/update">修改</a>
	                    </shiro:hasPermission>
	
	                    <shiro:hasPermission name="bulletin:delete">
	                        <a href="${ctx}/dev/bulletin/${bulletin.id}/delete">删除</a>
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