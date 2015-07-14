<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%	
	//设置返回码200，避免浏览器自带的错误页面
	response.setStatus(200);
	//记录日志
	Logger logger = LoggerFactory.getLogger("500.jsp");
	if (null!=exception) {
		logger.error(exception.getMessage(), exception);
	}
%>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<title>500 - 系统内部错误</title>
	<link href="${ctx}/static/css/default.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<h2>500 - 系统发生内部错误</h2>
	<!-- <p><a href="<c:url value="/"/>">返回首页</a></p> -->
</body>
</html>
