package cn.hanquan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import cn.hanquan.util.MyBatisUtil;

@WebFilter("/*")
public class OpenSessionInView implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		SqlSession session = MyBatisUtil.getSession();
		System.out.println("过滤器：获取session");
		try {
			filterChain.doFilter(req, resp);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession();
			System.out.println("过滤器：关闭session");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
