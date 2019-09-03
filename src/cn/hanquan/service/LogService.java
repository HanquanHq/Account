package cn.hanquan.service;

import java.io.IOException;
import java.util.List;

import cn.hanquan.pojo.Log;
import cn.hanquan.pojo.PageInfo;

public interface LogService {
	/**
	 * 分页显示
	 * 
	 * @param pageSize 一页显示的记录条数
	 * @param pageNum  当前第几页
	 * @return 此页中所有数据
	 * @throws IOException
	 */
	PageInfo showPage(int pageSize, int pageNum) throws IOException;

	/**
	 * 根据收款、付款账户，查找转账记录
	 * 
	 * @param accIn
	 * @param accOut
	 * @return 查到的转账记录list
	 * @throws IOException
	 */
	List<Log> search(String accIn, String accOut) throws IOException;

	/**
	 * 修改转账记录
	 * @param log 要修改的内容
	 * @throws IOException
	 */
	void modifyLog(Log log) throws IOException;
}
