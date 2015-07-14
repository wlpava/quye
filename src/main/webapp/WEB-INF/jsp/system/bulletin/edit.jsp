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
  <li class="active">公告编辑</li>
</ol>

<form:form  id="inputForm" method="post" commandName="bulletin" class="form-horizontal">
   <form:hidden path="id"/>
   <form:hidden path="creator"/>
   
	<fieldset>
		<legend>
			<small>${op}公告</small>
		</legend>   

        <div class="form-group">
			<label class="col-sm-2 control-label">* 公告内容</label>	 
			<div class="col-sm-5">
            	<textarea id="content" name="content" class="form-control required">${bulletin.content}</textarea>
            </div>
        </div>
        
        <div class="form-group">
			<label class="col-sm-2 control-label">* 公告状态</label>	 
			<div class="col-sm-5">
				<select id="status" name="status" class="form-control ">
					<c:forEach var="item" items="${bulletinStatusMap}">
						<option value="${item.key}"
							<c:if test="${bulletin.status==item.key}">
								selected="selected"
							</c:if>
						>
							${item.value}
						</option>
					</c:forEach>
				</select>
            </div>
        </div>
        
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-3">
				<button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-ok-sign" style="top: 2px;"></span> ${op}</button>
				<a class="btn btn-default" href="${ctx}/dev/bulletin/"><span class="glyphicon glyphicon-circle-arrow-left" style="top: 2px;"></span> 返回</a>
			</div>
		</div>
		
	</fieldset>
	
</form:form>

</body>
</html>
