package bank_system;

public class DepositBean {
	private long Account_no;
	private String user_name;
	private String password;
	private int amount;
	public long getAccount_no() {
		return Account_no;
	}
	public void setAccount_no(long account_no) {
		Account_no = account_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	

}
