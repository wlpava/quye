<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<script>
$(document).ready(function() {
	$(window.parent.document).find("#nav_index").addClass("active").siblings().removeClass("active");
	
	$("#promptSpan").hide();
   	// 检查AppId是否存在，并给出提示
    $("#smsA").click(function(){
    	var phone = $("#phone").val();
    	if (phone=="") {
    		alert("请输入手机号码");
    		$("#phone").focus();
    		return;
    	}
    	var password = $("#password").val();
    	if (password=="") {
    		alert("请输入密码");
    		$("#password").focus();
    		return;
    	}
    	
   		$.ajax({
   			type:"GET",
   			url:"${ctx}/api/smsCode", 
   			data:{"phone":phone},
   			//dataType:"json",
   			success:function(data){
   				if (data.returnCode=="200") {
   			    	$("#smsA").hide();
   			    	$("#promptSpan").show();
   			    	$("#counter").html(60);
   			    	countDown();
   				}
   			}
   		});
    });
});

function countDown() { 
	var timer = setTimeout("countDown()",1000);
	var value=Number($("#counter").html()); 
	if (value>1) {
		$("#counter").html(value-1);
	} else { 
		$("#smsA").show();
		$("#smsA").removeAttr("style");
		$("#promptSpan").hide();
		clearTimeout(timer);
	} 
	
} 

</script>
</head>

<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div>
			<form:form method="post" commandName="user" class="form-horizontal" action="${ctx}/api/user/register">
			
				<c:if test="${not empty msg}"><div id="message" class="alert alert-danger fade in" style="margin-bottom: 5px; margin-top: 10px;"><button data-dismiss="alert" class="close" type="button">×</button><span>${msg}</span></div></c:if>
			
				<fieldset style="margin-top: 10px;">
					<legend>
						<small><span class="glyphicon glyphicon-user"></span> 用户注册</small>
					</legend>
			
			        <div class="form-group">
						<label class="col-sm-2 control-label">联系电话</label>	 
						<div class="col-sm-5">
							<form:input path="phone" class="form-control number required" placeholder="如：13500000000"/>
			            </div>
			        </div>
			
			        <div class="form-group">
						<label class="col-sm-2 control-label">登录密码</label>	 
						<div class="col-sm-5">
			            	<form:password path="password" minlength="4" maxlength="20" class="form-control required" placeholder="登录密码"/>
			            	 * 长度为4-20的字符
			            </div>
			        </div>
			        
			        <div class="form-group">
						<label class="col-sm-2 control-label">短信验证码</label>	 
						<div class="col-sm-5">
			            	<input type="text" name="smsCode" class="form-control required" placeholder="短信验证码"> <a id="smsA" href="#">获取短信验证码</a><span id="promptSpan">剩余（<label id="counter"></label>）秒</span>
				        </div>
					</div>
			        
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-3">
							<button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-plus-sign" style="top: 2px;"></span> 注册</button>
							<a class="btn btn-default" href="${ctx}/login"><span class="glyphicon glyphicon-circle-arrow-left" style="top: 2px;"></span> 返回</a>						
					    </div>				
					</div>			
				</fieldset>
			</form:form>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>			

</body>
</html>