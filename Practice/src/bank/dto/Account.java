package bank.dto;

public class Account {
	private String id; // 계좌번호
	private String name; // 이름
	private long balance; // 잔액
	
	public Account() {}

	public Account(String id, String name, long balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "계좌 번호 : " + id + "\n성함 : " + name + "님\n잔액 : " + balance + "원";
	}
	
	
}
