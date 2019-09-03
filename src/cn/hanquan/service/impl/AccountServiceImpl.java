package cn.hanquan.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.hanquan.mapper.AccountMapper;
import cn.hanquan.mapper.LogMapper;
import cn.hanquan.pojo.Account;
import cn.hanquan.pojo.Log;
import cn.hanquan.service.AccountService;

public class AccountServiceImpl implements AccountService {

	@Override
	public int transfer(Account accIn, Account accOut,String reason) throws IOException {
		// 使用mybatis
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		// 接口为什么能实例化？使用了代理模式，实际上是给接口实现了一个类。 mapper.xml最后会被翻译成一个java类
		AccountMapper accountMapper = session.getMapper(AccountMapper.class);
		LogMapper logMapper = session.getMapper(LogMapper.class);

		// 检测付款账户密码正确
		Account accOutSelect = accountMapper.selByAccnoPwd(accOut.getAccNo(), accOut.getPwd());
		if (accOutSelect == null) {
			return ACCOUNT_PWD_NOT_MATCH;
		}

		// 检测付款账户余额充足
		if (accOutSelect.getBalance() <= accOut.getBalance()) {
			return ACCOUNT_BALANCE_NOT_ENOUGH;
		}

		// 检测收款账户姓名正确
		Account accInSelect = accountMapper.selByAccnoName(accIn.getAccNo(), accIn.getName());
		if (accInSelect == null) {
			return ACCOUNT_NAME_NOT_MATCH;
		}

		// 执行转账
		accIn.setBalance(accIn.getBalance());// 设置收款账户余额增加量
		accOut.setBalance(-accOut.getBalance());// 设置付款账户余额增加量
		System.out.println("AccountService中的accOut:" + accOut);
		System.out.println("AccountService中的accIn:" + accIn);
		accountMapper.updateBalanceByAccount(accOut.getBalance(), accOut.getAccNo());
		accountMapper.updateBalanceByAccount(accIn.getBalance(), accIn.getAccNo());

		// 记录log
		Log log = new Log();
		log.setAccIn(accInSelect.getAccNo());
		log.setAccOut(accOutSelect.getAccNo());
		log.setMoney(accIn.getBalance());
		System.out.println("AccountService中的log:" + log);
		logMapper.insLog(accOut.getAccNo(), accIn.getAccNo(), accIn.getBalance(),reason);
		session.commit();
		session.close();
		return SUCCESS;

//			session.rollback();
//			session.close();
//			return ERROR;
	}
}
