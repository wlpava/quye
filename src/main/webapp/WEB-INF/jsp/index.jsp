<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<title>ICMS</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<link href="${ctx}/static/bootstrap/3.2.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/bootstrap/3.2.0/css/docs.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/css/default.css" type="text/css" rel="stylesheet" />

<script src="${ctx}/static/js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="${ctx}/static/js/jquery.layout-latest.js"></script>
<script src="${ctx}/static/bootstrap/3.2.0/js/bootstrap.min.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function() {
    	$("#activityUl").hide();
    	$("#menu_activity").click(function(){
    		$("#sysUl").hide();
    		$("#activityUl").show();
    		$("#menu_activity_a").css("background-color", "#e5e5e5");
    		$("#menu_sys_a").css("background-color", "#fff");
    		$("#addSub1").attr("src", "${ctx}/static/images/zk.png");
    		$("#addSub2").attr("src", "${ctx}/static/images/ss.png");
    		$("#activityUl li").each(function() {
    			$(this).removeClass("active");
    		});
    	});
    	$("#menu_sys").click(function(){
    		$("#activityUl").hide();
    		$("#sysUl").show();
    		$("#menu_activity_a").css("background-color", "#fff");
    		$("#menu_sys_a").css("background-color", "#e5e5e5");
    		$("#addSub1").attr("src", "${ctx}/static/images/ss.png");
    		$("#addSub2").attr("src", "${ctx}/static/images/zk.png");
    		$("#sysUl li").each(function() {
    			$(this).removeClass("active");
    		});
    	});
    	
    });
</script>
</head>
<body>

<div class="ui-layout-north">
	<div style="background:url(${ctx}/static/images/banner.png); background-size:cover; padding-top:5px; padding-right: 10px; height:74px; color:white">
		<div class="row" style="margin-right: 0px; margin-left: 0px;">
			<div class="col-md-5" align="left" style="margin-top: 5px;"><img src="${ctx}/static/images/logo.png"></div>
			<div class="col-md-6" align="right" style="margin-top: 20px;">
				欢迎您：<shiro:principal/>，
				<a href="${ctx}/user/${userId}/changePassword" style="color:white" target="content"><i class="glyphicon glyphicon-lock" style="margin-top: 4px;"></i>修改密码</a>&nbsp;
				<a href="${ctx}/logout" style="color:white"><i class="glyphicon glyphicon-share" style="margin-top: 4px;"></i>退出</a></div>			
		</div>
	</div>
</div>

<div class="ui-layout-west">
<div class="row" style="margin-right: 0px;">
	<div class="col-md-2" style="margin-left: 0px;">
	    <ul class="nav bs-docs-sidenav" style="width: 196px; margin-top: 0px;">
	    	<li><a href="${ctx}/"><img src="${ctx}/static/images/sy.png"> Home</a></li>
	    	<li id="menu_sys"><a href="#" id="menu_sys_a" style="background-color: #e5e5e5"><img id="addSub1" src="${ctx}/static/images/ss.png"> <b>系统管理</b></a>
		    	<ul id="sysUl" class="nav bs-docs-sidenav" style="width: 196px; margin-top: 0px;">
				    <c:forEach items="${menus}" var="m">
				    	<c:if test="${m.catagory=='sys'}">
					    	<li id="nav_${fn:substringBefore(m.permission, ':')}"><a href="${ctx}/${m.url}" target="content"><img src="${ctx}/static/images/${m.iconPath}" style="margin-left: 20px;"> ${m.name}</a></li>
					    </c:if>
				    </c:forEach>
			    </ul>
		    </li>
		    
	    	<li id="menu_activity"><a href="#" id="menu_activity_a"><img id="addSub2" src="${ctx}/static/images/zk.png"> <b>活动管理</b></a>
		    	<ul id="activityUl" class="nav bs-docs-sidenav" style="width: 196px; margin-top: 0px;">
				    <c:forEach items="${menus}" var="m">
				    	<c:if test="${m.catagory=='activity'}">
					    	<li id="nav_${fn:substringBefore(m.permission, ':')}"><a href="${ctx}/${m.url}" target="content"><img src="${ctx}/static/images/${m.iconPath}" style="margin-left: 20px;"> ${m.name}</a></li>
					    </c:if>		    	
				    </c:forEach>
			    </ul>
		    </li>
		    
	    	<li id="menu_stat"><a href="#" id="menu_stat_a"><img id="addSub2" src="${ctx}/static/images/zk.png"> <b>统计管理</b></a>
		    	<ul id="statUl" class="nav bs-docs-sidenav" style="width: 196px; margin-top: 0px;">
				    <c:forEach items="${menus}" var="m">
				    	<c:if test="${m.catagory=='stat'}">
					    	<li id="nav_${fn:substringBefore(m.permission, ':')}"><a href="${ctx}/${m.url}" target="content"><img src="${ctx}/static/images/${m.iconPath}" style="margin-left: 20px;"> ${m.name}</a></li>
					    </c:if>		    	
				    </c:forEach>
			    </ul>
		    </li>
	    </ul>
	 </div>
</div>	 
</div>

<shiro:hasPermission name="user:view">
    <iframe name="content" class="ui-layout-center" src="${ctx}/user" frameborder="0" scrolling="auto"></iframe>
</shiro:hasPermission>
<shiro:lacksPermission name="user:view">
    <iframe name="content" class="ui-layout-center" src="${ctx}/welcome" frameborder="0" scrolling="auto"></iframe>
</shiro:lacksPermission>

<div class="ui-layout-south" align="center">
    <a href="http://www.quye.com" target="_blank">www.quye.com</a> Copyright &copy; 2014
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