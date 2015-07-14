<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="page" type="org.springframework.data.domain.Page" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
int paginationSize = 5;
int current =  page.getNumber() + 1;
int begin = Math.max(1, current - paginationSize/2);
int end = Math.min(begin + (paginationSize - 1), page.getTotalPages());

request.setAttribute("current", current);
request.setAttribute("begin", begin);
request.setAttribute("end", end);
%>

<c:choose>

	<c:when test="${not empty page.content }">
			<ul class="pagination">
			
				 <% if (page.hasPrevious()){%>
		               	<li><a href="?page=1&${searchParams}">&lt;&lt;</a></li>
		                <li><a href="?page=${current-1}&${searchParams}">&lt;</a></li>
		         <%}else{%>
		                <li class="disabled"><a href="#">&lt;&lt;</a></li>
		                <li class="disabled"><a href="#">&lt;</a></li>
		         <%} %>
		 
				<c:forEach var="i" begin="${begin}" end="${end}">
		            <c:choose>
		                <c:when test="${i == current}">
		                    <li class="active"><a href="?page=${i}&${searchParams}">${i}</a></li>
		                </c:when>
		                <c:otherwise>
		                    <li><a href="?page=${i}&${searchParams}">${i}</a></li>
		                </c:otherwise>
		            </c:choose>
		        </c:forEach>
			  
			  	 <% if (page.hasNext()){%>
		               	<li><a href="?page=${current+1}&${searchParams}">&gt;</a></li>
		                <li><a href="?page=${page.totalPages}&${searchParams}">&gt;&gt;</a></li>
		         <%}else{%>
		                <li class="disabled"><a href="#">&gt;</a></li>
		                <li class="disabled"><a href="#">&gt;&gt;</a></li>
		         <%} %>
		         
				<li class="disabled"><a href='#'>共${page.totalElements}条 ${current}/${page.totalPages}页</a></li>
				
			</ul>
	</c:when>
	
	<c:otherwise>
		<ul class="pagination" style="margin-bottom: 0px;">
			<li class="disabled"><a href="#">&lt;&lt;</a></li>
	        <li class="disabled"><a href="#">&lt;</a></li>
	        <li class="disabled"><a href="#">&gt;</a></li>
	        <li class="disabled"><a href="#">&gt;&gt;</a></li>
			<li class="disabled"><a href='#'>共0条 0页</a></li>
		</ul>
	</c:otherwise>
	
</c:choose>