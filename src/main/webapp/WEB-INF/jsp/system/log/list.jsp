<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>日志管理</title>
<script>
	$(document).ready(function() {
		$(window.parent.document).find("#nav_log").addClass("active").siblings().removeClass("active");
	});
</script>
</head>
<body>

<ol class="breadcrumb">
  <li style="margin-left: -4px;"><a href="#"><span class="glyphicon glyphicon-home" style="top: 2px;"></span> </a></li>
  <li class="active">系统管理</li>
  <li class="active">日志管理</li>
  <li class="active">日志查询</li>
</ol>

	<form class="form-inline well well-sm" style="margin-bottom: 5px;">
		<div class="row">
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-4" style="padding-right: 0px;">
						<label class="control-label">操作人</label>
						<input type="text" class="form-control" name="search_LIKE_operator"  value="${param.search_LIKE_operator}">			
					</div>
				</div>
			</div>		
			<div class="col-md-2" style="padding-left: 5px">
				<button class="btn btn-primary" title="按条件查询" type="submit"><i class="glyphicon glyphicon-search" style="top: 2px;"></i> 查询</button>
				<a class="btn btn-default" title="重置刷新" href="${ctx}/dev/log/"><i class="glyphicon glyphicon-refresh" style="top: 2px;"></i> 刷新</a>
			</div>
		</div>
	</form>
	
	<table class="table table-striped table-hover table-bordered table-condensed">
		<thead>
			<tr class="success">
				<th class="th-head">操作人</th>
				<th class="th-head">操作</th>
				<th class="th-head" style="width:500px">操作描述</th>
				<th class="th-head">操作时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="item">
				<tr>
					<td>${item.operator}</td>
					<td>${item.operate}</td>
					<td>${item.description}</td>
					<td><fmt:formatDate value="${item.operateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
