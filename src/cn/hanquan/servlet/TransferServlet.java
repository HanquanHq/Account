package cn.hanquan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hanquan.pojo.Account;
import cn.hanquan.service.AccountService;
import cn.hanquan.service.impl.AccountServiceImpl;

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AccountService accountService = new AccountServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 从页面中获取信息
		String accOutAccNo = req.getParameter("accOutAccNo");// 转账账户
		String pwd = req.getParameter("pwd");// 密码
		double money = Double.parseDouble(req.getParameter("money"));// 转账金额
		String accInAccNo = req.getParameter("accInAccNo");// 收款账号
		String accInName = req.getParameter("accInName");// 收款人姓名
		String reason = req.getParameter("reason");// 转账原因
		if (reason == null) {
			reason = "";
		}

		// 付款人
		Account accOut = new Account();
		accOut.setAccNo(accOutAccNo);
		accOut.setPwd(pwd);
		accOut.setBalance(money);
		System.out.println("Servlet接收的accOut：" + accOut);
		// 收款人
		Account accIn = new Account();
		accIn.setAccNo(accInAccNo);
		accIn.setName(accInName);
		accIn.setBalance(money);
		System.out.println("Servlet接收的accIn：" + accIn);
		// 转账结果
		String resultStr = "";
		int index = accountService.transfer(accIn, accOut, reason);
		if (index == AccountService.ACCOUNT_BALANCE_NOT_ENOUGH) {
			resultStr = "账户余额不足";
		} else if (index == AccountService.ACCOUNT_NAME_NOT_MATCH) {
			resultStr = "收款方账户姓名不匹配";
		} else if (index == AccountService.ACCOUNT_PWD_NOT_MATCH) {
			resultStr = "用户名或密码错误";
		} else if (index == AccountService.SUCCESS) {
			resultStr = "转账成功";
		} else {
			resultStr = "转账失败";
		}

		// 重定向 避免重复提交表单
		req.setAttribute("resultStr", resultStr);
		req.getRequestDispatcher("/ShowServlet").forward(req, resp);// ShowServlet又将请求转发给了result.jsp
	}
}
