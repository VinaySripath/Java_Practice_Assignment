package acc.abc.filacc.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private int accountId;
	private String accountHolderName;
	private int bankBalance;
	private String location;
	private List<Policy> policies = new ArrayList<>();
	
	public Account() {
		
	}

	public Account(int accountId, String accountHolderName, int bankBalance, String location, List<Policy> policies) {
		super();
		this.accountId = accountId;
		this.accountHolderName = accountHolderName;
		this.bankBalance = bankBalance;
		this.location = location;
		this.policies = policies;
	}

	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(int bankBalance) {
		this.bankBalance = bankBalance;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int)(Math.random()*10000000);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Account) {
			Account acc = (Account)obj;
			boolean b1 = this.accountHolderName.equals(acc.accountHolderName);
//			boolean b2 = this.accountId == acc.accountId;
			boolean b3 = this.bankBalance == acc.bankBalance;
			boolean b4 = this.location.equals(acc.location);
			return b1 && b3 && b4;
		}
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "account ID: "+this.accountId+" account holder name: "+this.accountHolderName+" location:"+this.location+" balance:"+this.bankBalance;
	}
	
}
