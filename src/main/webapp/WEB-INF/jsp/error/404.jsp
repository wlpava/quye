<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%response.setStatus(200);%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<title>404 - 页面不存在</title>
	<link href="${ctx}/static/css/default.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<h2>404 - 页面不存在</h2>
	<!-- <p><a href="<c:url value="/"/>">返回首页</a></p> -->
</body>
</html>