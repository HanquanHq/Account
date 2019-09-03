package cn.hanquan.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	/**
	 * factory实例化耗费性能，因此保证只有一个factory
	 */
	private static SqlSessionFactory factory;

	/**
	 * 线程容器,给线程绑定一个Object内容,只要线程不变,可以随时取出
	 */
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

	/**
	 * 初始化一个factory
	 */
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取一个session对象
	 * @return session对象
	 */
	public static SqlSession getSession() {
		SqlSession session = threadLocal.get();
		if (session == null) {
			threadLocal.set(factory.openSession());
		}
		return threadLocal.get();
	}

	/**
	 * 关闭session，并且删除ThreadLocal线程容器中保留的session内容
	 */
	public static void closeSession() {
		SqlSession session = threadLocal.get();
		if (session != null) {
			session.close();
		}
		threadLocal.set(null);
	}
}
