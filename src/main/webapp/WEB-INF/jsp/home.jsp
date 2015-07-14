<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<link href="${ctx}/static/bootstrap/2.3.2/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/bootstrap/2.3.2/css/docs.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/css/default.css" type="text/css" rel="stylesheet" />

<script src="${ctx}/static/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="${ctx}/static/js/jquery.layout-latest.js"></script>
<script src="${ctx}/static/bootstrap/2.3.2/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>

<div class="ui-layout-north"><div align="right" style="background:url(${ctx}/static/images/header.png); background-size:cover; padding-top:5px; padding-right: 10px; height:30px; color:white">欢迎您：<shiro:principal/>，<a href="${ctx}/logout" style="color:white"><i class="icon-share icon-white" style="margin-top: 4px;"></i>退出</a></div></div>

<div class="ui-layout-west">
	<div class="span2 bs-docs-sidebar" style="margin-left: 0px;">
	    <ul class="nav nav-list bs-docs-sidenav" style="width: 196px; margin-top: 0px;">
	    	<li><a href="#"><i class="icon-home" style="margin-top: 3px;"></i> Home</a></li>
	    	<li><a href="#"><i class="icon-leaf" style="margin-top: 3px;"></i> <b>内容浏览</b></a></li>
		    <c:forEach items="${menus}" var="m"> 
		    	<c:if test="${fn:startsWith(m.permission, 'article')}">
				    <li id="nav_article"><a href="${ctx}/${m.url}" target="content"><i class="icon-book" style="margin-top: 3px; margin-left: 20px;"></i><i class="icon-chevron-right"></i> ${fn:substringBefore(m.name, '管理')}</a></li>
		    	</c:if>
		    	<c:if test="${fn:startsWith(m.permission, 'picture')}">
				    <li id="nav_picture"><a href="${ctx}/${m.url}" target="content"><i class="icon-picture" style="margin-top: 3px; margin-left: 20px;"></i><i class="icon-chevron-right"></i> ${fn:substringBefore(m.name, '管理')}</a></li>
		    	</c:if>
		    	<c:if test="${fn:startsWith(m.permission, 'audio')}">
				    <li id="nav_audio"><a href="${ctx}/${m.url}" target="content"><i class="icon-bell" style="margin-top: 3px; margin-left: 20px;"></i><i class="icon-chevron-right"></i> ${fn:substringBefore(m.name, '管理')}</a></li>
		    	</c:if>
		    	<c:if test="${fn:startsWith(m.permission, 'video')}">
				    <li id="nav_video"><a href="${ctx}/${m.url}" target="content"><i class="icon-facetime-video" style="margin-top: 3px; margin-left: 20px;"></i><i class="icon-chevron-right"></i> ${fn:substringBefore(m.name, '管理')}</a></li>
		    	</c:if>
		    	<c:if test="${fn:startsWith(m.permission, 'push')}">
				    <li id="nav_push"><a href="${ctx}/${m.url}" target="content"><i class="icon-facetime-video" style="margin-top: 3px; margin-left: 20px;"></i><i class="icon-chevron-right"></i> ${fn:substringBefore(m.name, '管理')}</a></li>
		    	</c:if>
		    </c:forEach>
	    </ul>
	 </div>
</div>

<shiro:hasPermission name="user:view">
    <iframe name="content" class="ui-layout-center" src="${ctx}/user" frameborder="0" scrolling="auto"></iframe>
</shiro:hasPermission>
<shiro:lacksPermission name="user:view">
    <iframe name="content" class="ui-layout-center" src="${ctx}/welcome" frameborder="0" scrolling="auto"></iframe>
</shiro:lacksPermission>

<div class="ui-layout-south" align="center">
    <a href="http://www.quye.com" target="_blank">www.http://www.quye.com.com</a> Copyright &copy; 2014
</div>

<script>
    $(function () {
        $(document).ready(function () {
            $('body').layout({ applyDemoStyles: true });
        });
    });
</script>
</body>
</html>