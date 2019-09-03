package cn.hanquan.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.hanquan.mapper.LogMapper;
import cn.hanquan.pojo.Log;
import cn.hanquan.pojo.PageInfo;
import cn.hanquan.service.LogService;

public class LogServiceImpl implements LogService {

	@Override
	public PageInfo showPage(int pageSize, int pageNum) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		LogMapper logMapper = session.getMapper(LogMapper.class);

		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNum(pageNum);
		pageInfo.setPageSize(pageSize);

		// 查询结果
		int pageStart = pageSize * (pageNum - 1);
		List<Log> list = logMapper.selByPage(pageStart, pageSize);
		pageInfo.setDataList(list);
		System.out.println("LogService中的list:" + list);

		// 总页数
		int count = logMapper.selCount();
		pageInfo.setTotal((count % pageSize == 0 ? count / pageSize : count / pageSize + 1));
		System.out.println("LogService中的count:" + count);
		
		session.close();
		return pageInfo;
	}

	@Override
	public List<Log> search(String accIn, String accOut) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();

		LogMapper logMapper = session.getMapper(LogMapper.class);
		List<Log> list = logMapper.selDynamic(accIn, accOut);
		System.out.println("LogService中的list:"+list);
		
		session.close();
		return list;
	}

	@Override
	public void modifyLog(Log log) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		//调用修改
		LogMapper logMapper = session.getMapper(LogMapper.class);
		logMapper.updReason(log);
		System.out.println("LogService中的log:"+log);
		
		session.commit();
		session.close();
	}
}
