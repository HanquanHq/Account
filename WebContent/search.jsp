<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>查询转账记录</h3>
	<form action="SearchServlet" method="post">
		转账账号：<input type="text" name="accIn"><br>
		收款账号：<input type="text" name="accOut"><br>
		<input type="submit" value="查询"><br>
	</form>
	
	
	<hr>
	<h3>查询结果</h3>
	<table border="1">
		<tr>
			<th>交易编号</th>
			<th>转账账号</th>
			<th>收款账号</th>
			<th>转账金额</th>
			<th>转账原因</th>
		</tr>
		<c:forEach items="${dataList}" var="log">
			<tr>
				<td>${log.id}</td>
				<td>${log.accIn}</td>
				<td>${log.accOut}</td>
				<td>${log.money}</td>
				<td>${log.reason}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br><hr><br>
	<h3>修改账面信息(交易编号必填)</h3>
	<form action="ModifyLogServlet" method="post">
		<p><font size="4" color="blue">${modifyResultStr}</font></p>
		交易编号：<input type="text" name="id"><br>
		转账账号：<input type="text" name="accIn"><br>
		收款账号：<input type="text" name="accOut"><br>
		转账金额：<input type="text" name="money"><br>
		转账原因：<input type="text" name="reason"><br>
		<input type="submit" value="修改"><br>
	</form>
	<br><hr><br>
	<a href="/Account/index.jsp">返回主页</a>
</body>
</html>