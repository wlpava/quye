<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script>
/**
 * checkbox 全选和取消
 */
$(document).on("click","th input:checkbox",function(){
	var checkedStatus = this.checked;
	var $checkbox = $(this).closest('table').find('tr input:checkbox');
	$checkbox.each(function() {
		//设置checkbox状态
		this.checked = checkedStatus;
		//uniform 的选中Class的处理
		$checker = $(this).closest('.checker > span');
		if (this.checked == checkedStatus) {
			$checker.removeClass('checked');
		}
		if (this.checked) {
			$checker.addClass('checked');
		}
	}); 
});

</script>
</head>
<body>

	<form class="form-inline well well-sm" action="${ctx}/dev/user/chooseUser" style="margin-bottom: 5px;">
		<div class="row">
			<div class="col-xs-4 col-md-4" style="margin-top: 6px; margin-right: -130px;">
				<label class="control-label">登录名</label>
			</div>
			<div class="col-xs-4 col-md-4">
				<input type="text" class="form-control" name="search_LIKE_loginName"  value="${param.search_LIKE_loginName}">
			</div>
		  	<div class="col-xs-4 col-md-4">
		  		<button class="btn btn-primary" title="按条件查询" type="submit"><i class="glyphicon glyphicon-search" style="top: 2px;"></i> 查询</button>
				<a class="btn btn-default" title="重置刷新" href="${ctx}/dev/user/chooseUser"><i class="glyphicon glyphicon-refresh" style="top: 2px;"></i> 刷新</a>
		  	</div>
		</div>	
	</form>

	
	<table class="table table-striped table-hover table-bordered table-condensed">
	    <thead>
	        <tr class="success">
	        	<th><input type="checkbox"></th>
	            <th>登录名</th>
	            <th>用户名</th>
	            <th>用户类型</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${page.content}" var="user">
	            <tr>
	            	<td><input type="radio" name="userRadio" value="${user.id}-${user.loginName}"></td>
	                <td>${user.loginName}</td>
	                <td>${user.userName}</td>
	                <td>${wlpava:intToString(userTypeMap, user.type)}</td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<div class="row" style="margin-top: -35px; margin-right: 0px; margin-left: 0px; height: 50px;">
		<div class="pull-right"><tags:pagination page="${page}" /></div>
	</div>

</body>
</html>