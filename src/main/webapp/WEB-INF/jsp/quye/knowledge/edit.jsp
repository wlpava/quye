<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/WEB-INF/jsp/common.jsp"%><!DOCTYPE html><html><head><title></title><script>	$(document).ready(function() {		$(window.parent.document).find("#nav_knowledge").addClass("active").siblings().removeClass("active");	});</script>     </head><body><form:form  id="inputForm" method="post" commandName="knowledge" class="form-horizontal">   <form:hidden path="id"/>   	<fieldset>		<legend>			<small>${op}</small>		</legend>           <div class="form-group">			<label class="col-sm-2 control-label">* 名称（示例）</label>	 			<div class="col-sm-3">            	<form:input path="name" class="form-control required" placeholder="名称"/>            </div>        </div>        		<div class="form-group">			<div class="col-sm-offset-2 col-sm-3">				<button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-ok-sign" style="top: 2px;"></span> ${op}</button>				<a class="btn btn-default" href="${ctx}/knowledge/"><span class="glyphicon glyphicon-circle-arrow-left" style="top: 2px;"></span> 返回</a>			</div>		</div>						</fieldset>	</form:form></body></html>