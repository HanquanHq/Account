package cn.hanquan.pojo;

public class Log {
	/**
	 * 记录编号
	 */
	private int id;
	/**
	 * 付款账户
	 */
	private String accOut;
	/**
	 * 收款账户
	 */
	private String accIn;
	/**
	 * 转账金额
	 */
	private double money;
	/**
	 * 转账原因
	 */
	private String reason;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccOut() {
		return accOut;
	}
	public void setAccOut(String accOut) {
		this.accOut = accOut;
	}
	public String getAccIn() {
		return accIn;
	}
	public void setAccIn(String accIn) {
		this.accIn = accIn;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", accOut=" + accOut + ", accIn=" + accIn + ", money=" + money + ", reason=" + reason + "]";
	}
}
