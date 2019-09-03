package cn.hanquan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hanquan.pojo.Log;
import cn.hanquan.service.LogService;
import cn.hanquan.service.impl.LogServiceImpl;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accIn = req.getParameter("accIn");
		String accOut = req.getParameter("accOut");
		if (accIn == null) {
			accIn = "";
		}
		if (accOut == null) {
			accOut = "";
		}
		System.out.println("SearchServlet中的accIn=" + accIn + "accOut=" + accOut);

		LogService logService = new LogServiceImpl();
		List<Log> log = logService.search(accIn, accOut);
		
		req.setAttribute("dataList", log);
		req.getRequestDispatcher("search.jsp").forward(req, resp);
	}
}
