package bank_system;

public class TransferBean {
	private int Account_no;
	private String user_name;
	private int Target_Account;
	private String password;
	private long amount;
	public int getAccount_no() {
		return Account_no;
	}
	public void setAccount_no(int account_no) {
		Account_no = account_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getTarget_Account() {
		return Target_Account;
	}
	public void setTarget_Account(int target_Account) {
		Target_Account = target_Account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	
	

}
