<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>转账页面</title>
</head>
<body>
	<form action="TransferServlet" method="post">
		转账账户：<input type="text" name="accOutAccNo"><br>
		密码：<input type="text" name="pwd"><br>
		金额：<input type="text" name="money"><br>
		收款账号：<input type="text" name="accInAccNo"><br>
		收款人姓名：<input type="text" name="accInName"><br>
		转账原因：<input type="text" name="reason"><br>
		<input type="submit" value="转账"><br>
	</form>
	
	<br><br>
	<a href="/Account/search.jsp">查询转账记录</a>
</body>
</html>