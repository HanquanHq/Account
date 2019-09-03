package cn.hanquan.service;

import java.io.IOException;

import cn.hanquan.pojo.Account;

public interface AccountService {

	/**
	 * 账户和密码不匹配
	 */
	public static final int ACCOUNT_PWD_NOT_MATCH = 1;

	/**
	 * 账户余额不足
	 */
	public static final int ACCOUNT_BALANCE_NOT_ENOUGH = 2;

	/**
	 * 账户姓名不匹配
	 */
	public static final int ACCOUNT_NAME_NOT_MATCH = 3;

	/**
	 * 转账失败
	 */
	public static final int ERROR = 4;

	/**
	 * 转账成功
	 */
	public static final int SUCCESS = 5;

	/**
	 * 转账业务
	 * 
	 * @param accIn  收款账号
	 * @param accOut 付款账号
	 * @return 转账结果状态码
	 * @throws IOException
	 */
	int transfer(Account accIn, Account accOut,String reason) throws IOException;
}
