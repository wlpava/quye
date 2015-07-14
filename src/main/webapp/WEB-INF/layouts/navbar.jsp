<%@ page language="java" pageEncoding="UTF-8" %>
<ol class="breadcrumb">
  <li style="margin-left: -4px;"><a href="#"><span class="glyphicon glyphicon-home" style="top: 2px;"></span> </a></li>
  <li class="active"><%
  		String nav1=request.getParameter("nav1");
  		if(nav1!=null) {
  			out.print(nav1);
  		} else {
  			out.print("系统");
  		}
  	%>管理
  </li>
  <li class="active"><%
  		String nav2=request.getParameter("nav2");
  		if(nav2!=null) {
  			out.print(nav2);
  		} 
  	%>管理
  </li>
  <li class="active"><%
  		String nav3=request.getParameter("nav3");
  		if(nav3!=null) {
  			out.print(nav3);
  		} 
  	%>
  </li>
</ol>

<!-- 
<jsp:include page="/WEB-INF/layouts/navbar.jsp" flush="true">     
     <jsp:param name="nav1" value="物业"/> 
     <jsp:param name="nav2" value="公告"/> 
     <jsp:param name="nav3" value="公告查询"/> 
</jsp:include> 
-->