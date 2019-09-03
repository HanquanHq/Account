package cn.hanquan.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.hanquan.pojo.Log;

public interface LogMapper {

	/**
	 * 插入一条转账记录
	 * @param log 被插入的记录
	 * @return 成功影响的数据库行数
	 */
	int insLog(String accOut, String accIn, double money, String reason);

	/**
	 * 分页查询数据
	 * @param map 表示参数的键值对
	 * @return
	 */
	List<Log> selByPage(int pageStart, int pageSize);
	
	/**
	 * 查询总记录条数
	 * @return 总记录条数
	 */
	int selCount();
	
	/**
	 * 动态sql语句
	 * @param accIn 收款账号
	 * @param accOut 付款账号
	 * @return
	 */
	List<Log> selDynamic(@Param("accIn") String accIn, @Param("accOut") String accOut);
	
	/**
	 * 修改转账记录
	 * @param log
	 */
	void updReason(Log log);
}
