<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3><font color="blue">${resultStr}</font></h3>
	
	<table border="1">
		<tr>
			<th>记录编号</th>
			<th>付款账户</th>
			<th>收款账户</th>
			<th>转账金额</th>
		</tr>
		<c:forEach items="${PageInfo.dataList }" var="log">
			<tr>
				<td>${log.id}</td>
				<td>${log.accOut}</td>
				<td>${log.accIn}</td>
				<td>${log.money}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="ShowServlet?pageNum=${PageInfo.pageNum-1 }&pageSize=${PageInfo.pageSize}" <c:if test="${PageInfo.pageNum<=1 }">  onclick="javascript:return false;" </c:if> >上一页</a>
	<a href="ShowServlet?pageNum=${PageInfo.pageNum+1 }&pageSize=${PageInfo.pageSize}" <c:if test="${PageInfo.pageNum>=PageInfo.total }">  onclick="javascript:return false;" </c:if> >下一页</a>
	
	<br><br>
	<a href="/Account/index.jsp">返回主页</a>
	
	<br><br>
	<a href="/Account/search.jsp">查询转账记录</a>
</body>
</html>