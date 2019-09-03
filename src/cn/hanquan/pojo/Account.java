package cn.hanquan.pojo;

public class Account {
	private int id;
	private String accNo;
	private String pwd;
	private double balance;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", accNo=" + accNo + ", pwd=" + pwd + ", balance=" + balance + ", name=" + name
				+ "]";
	}

}
