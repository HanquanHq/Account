package cn.hanquan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hanquan.pojo.Log;
import cn.hanquan.service.LogService;
import cn.hanquan.service.impl.LogServiceImpl;

@WebServlet("/ModifyLogServlet")
public class ModifyLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String accIn = req.getParameter("accIn");
		String accOut = req.getParameter("accOut");
		String money = req.getParameter("money");
		String reason = req.getParameter("reason");

		// 封装成log对象
		Log log = new Log();
		log.setId(id);
		log.setAccIn(accIn);
		log.setAccOut(accOut);
		if (money != null && !money.isEmpty()) {
			log.setMoney(Double.parseDouble(money));
		}
		log.setReason(reason);

		System.out.println("SearchServlet中的log=" + log);
		LogService logService = new LogServiceImpl();

		logService.modifyLog(log);
		req.setAttribute("modifyResultStr", "修改成功");
		req.getRequestDispatcher("search.jsp").forward(req, resp);
	}
}
