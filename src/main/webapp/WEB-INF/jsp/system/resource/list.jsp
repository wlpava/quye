<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<head>
<style>
    #table th, #table td {
        font-size: 14px;
        padding : 4px;
    }
</style>
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
</ol>

<c:if test="${not empty msg}"><div id="message" class="alert alert-success fade in" style="margin-bottom: 5px;"><button data-dismiss="alert" class="close" type="button">×</button><span>${msg}</span></div></c:if>

<table id="table" class="table table-striped table-hover table-bordered table-condensed">
    <thead>
        <tr>
            <th>名称</th>
            <th>类型</th>
            <th>URL路径</th>
            <th>权限字符串</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${resourceList}" var="resource">
            <tr data-tt-id='${resource.id}' <c:if test="${not resource.rootNode}">data-tt-parent-id='${resource.parentId}'</c:if>>
                <td>${resource.name}</td>
                <td>${resource.type}</td>
                <td>${resource.url}</td>
                <td>${resource.permission}</td>
                <td>
                    <shiro:hasPermission name="resource:create">
                        <c:if test="${resource.type ne 'button'}">
                        <a href="${ctx}/dev/resource/${resource.id}/appendChild">新增子节点</a>
                        </c:if>
                    </shiro:hasPermission>

					<c:if test="${not resource.rootNode}">
	                    <shiro:hasPermission name="resource:update">
	                        <a href="${ctx}/dev/resource/${resource.id}/update">修改</a>
	                    </shiro:hasPermission>
	                    
	                    <shiro:hasPermission name="resource:delete">
	                        <a class="deleteBtn" href="#" data-id="${resource.id}">删除</a>
	                    </shiro:hasPermission>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<script>
    $(function() {
        $("#table").treetable({ expandable: true }).treetable("expandNode", 1);
        $(".deleteBtn").click(function() {
            if(confirm("确认删除吗?")) {
                location.href = "${ctx}/dev/resource/"+$(this).data("id")+"/delete";
            }
        });
    });
</script>
</body>
</html>