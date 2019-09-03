package cn.hanquan.mapper;

import cn.hanquan.pojo.Account;

public interface AccountMapper {

	/**
	 * 根据账号密码查询账户信息
	 * @param accNo 账号
	 * @param pwd 密码
	 * @return
	 */
	Account selByAccnoPwd(String accNo,String pwd);
	
	/**
	 * 根据账号姓名查询账户信息
	 * @param accNo 账号
	 * @param name 姓名
	 * @return
	 */
	Account selByAccnoName(String accNo,String name);
	
	/**
	 * 根据accno修改账户余额 
	 * @param balance 转账金额（含正负）
	 * @param accNo 操作的账户
	 * @return
	 */
	void updateBalanceByAccount(double balance,String accNo);
}
