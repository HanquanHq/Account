package cn.hanquan.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 用于测试的类
 * 
 * @author Buuug
 *
 */
public class Test {
	public static void main(String[] args) throws IOException {
		// 使用mybatis
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();

		session.close();
		System.out.println("执行结束");
	}
}
