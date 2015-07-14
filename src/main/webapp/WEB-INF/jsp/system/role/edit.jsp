<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<style>
    ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:200px;overflow-y:scroll;overflow-x:auto;}
</style>
<script>
	$(document).ready(function() {
		$(window.parent.document).find("#nav_role").addClass("active").siblings().removeClass("active");
	});
</script>     
</head>
<body>

<ol class="breadcrumb">
  <li style="margin-left: -4px;"><a href="#"><span class="glyphicon glyphicon-home" style="top: 2px;"></span> </a></li>
  <li class="active">系统管理</li>
  <li class="active">角色管理</li>
  <li class="active">角色编辑</li>
</ol>

<form:form method="post" commandName="role" class="form-horizontal input-form">
   <form:hidden path="id"/>
   <form:hidden path="status"/>
   
	<fieldset>
		<legend>
			<small>${op}角色</small>
		</legend>   

        <div class="form-group">
			<label class="col-sm-2 control-label">* 角色名</label>	 
			<div class="col-sm-5">
            	<form:input path="name" class="form-control required"/>
            </div>
        </div>
        
        <div class="form-group">
			<label class="col-sm-2 control-label">* 拥有的资源列表</label>	 
			<div class="col-sm-5">
            	<form:hidden path="resourceIds"/>
            	<input type="text" id="resourceName" name="resourceName" value="${wlpava:resourceNames(role.resourceIds)}" class="form-control required" readonly>
            	<a id="menuBtn" href="#">选择</a>
            </div>
        </div>
        
        <div class="form-group">
			<label class="col-sm-2 control-label">角色描述</label>	 
			<div class="col-sm-5">
            	<form:input path="description" class="form-control"/>
            </div>
        </div>
        
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-3">
				<button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-ok-sign" style="top: 2px;"></span> ${op}</button>
				<a class="btn btn-default" href="${ctx}/dev/role/"><span class="glyphicon glyphicon-circle-arrow-left" style="top: 2px;"></span> 返回</a>
			</div>
		</div>	
		
	</fieldset>
	
</form:form>

    <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
        <ul id="tree" class="ztree" style="margin-top:0; width:470px;"></ul>
    </div>

    <script>
        $(function () {
            var setting = {
                check: {
                    enable: true ,
                    chkboxType: { "Y": "", "N": "" }
                },
                view: {
                    dblClickExpand: false
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                callback: {
                    onCheck: onCheck
                }
            };

            var zNodes =[
                <c:forEach items="${resourceList}" var="r">
                <c:if test="${not r.rootNode}">
                { id:${r.id}, pId:${r.parentId}, name:"${r.name}", checked:${wlpava:in(role.resourceIds, r.id)}},
                </c:if>
                </c:forEach>
            ];

            function onCheck(e, treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree"),
                        nodes = zTree.getCheckedNodes(true),
                        id = "",
                        name = "";
                nodes.sort(function compare(a,b){return a.id-b.id;});
                for (var i=0, l=nodes.length; i<l; i++) {
                    id += nodes[i].id + ",";
                    name += nodes[i].name + ",";
                }
                if (id.length > 0 ) id = id.substring(0, id.length-1);
                if (name.length > 0 ) name = name.substring(0, name.length-1);
                $("#resourceIds").val(id);
                $("#resourceName").val(name);
//                hideMenu();
            }

            function showMenu() {
                var cityObj = $("#resourceName");
                var cityOffset = $("#resourceName").offset();
                $("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

                $("body").bind("mousedown", onBodyDown);
            }
            function hideMenu() {
                $("#menuContent").fadeOut("fast");
                $("body").unbind("mousedown", onBodyDown);
            }
            function onBodyDown(event) {
                if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
                    hideMenu();
                }
            }

            $.fn.zTree.init($("#tree"), setting, zNodes);
            $("#menuBtn").click(showMenu);
        });
    </script>


</body>
</html>
