<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="wlpava" uri="http://www.wlpava.com/tags/functions" %>

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
<link href="${ctx}/static/bootstrap/3.2.0/css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/css/default.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-ztree/css/zTreeStyle/zTreeStyle.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-treetable/stylesheets/jquery.treetable.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-treetable/stylesheets/jquery.treetable.theme.default.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-ui/css/jquery-ui-1.10.1.custom.min.css" type="text/css" rel="stylesheet" />

<script src="${ctx}/static/js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="${ctx}/static/bootstrap-modal-master/js/bootstrap-modal.js"></script> 
<script src="${ctx}/static/bootstrap-modal-master/js/bootstrap-modalmanager.js"></script> 
<script src="${ctx}/static/bootstrap/3.2.0/js/bootstrap.js" type="text/javascript"></script>
<script src="${ctx}/static/js/jquery.layout-latest.js" type="text/javascript"></script>
<script src="${ctx}/static/js/bootstrap.file-input.js" type="text/javascript"></script>
<script src="${ctx}/static/js/custom.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-ztree/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-treetable/javascripts/src/jquery.treetable.js"></script>
<script src="${ctx}/static/jquery-form/jquery.form.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/messages_zh.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-ui/js/jquery-ui-1.10.1.custom.min.js"></script>
<script src="${ctx}/static/jquery-ui/js/jquery.ui.datepicker-zh-CN.js"></script>
<script src="${ctx}/static/jquery-fileupload/ajaxfileupload.js" type="text/javascript"></script>

</head>
<body style="padding:10px">
</body>
</html>