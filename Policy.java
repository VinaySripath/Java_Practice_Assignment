package acc.abc.filacc.model;

public class Policy {
	private int premium;
	private int policyNumber;
	private int sumAssuredAmount;
	private String policyName;
	
	public Policy() {
		
	}

	public Policy(int premium, int policyNumber, int sumAssuredAmount, String policyName) {
		super();
		this.premium = premium;
		this.policyNumber = policyNumber;
		this.sumAssuredAmount = sumAssuredAmount;
		this.policyName = policyName;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public int getSumAssuredAmount() {
		return sumAssuredAmount;
	}

	public void setSumAssuredAmount(int sumAssuredAmount) {
		this.sumAssuredAmount = sumAssuredAmount;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int)(Math.random()*100000);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Policy) {
			Policy p = (Policy)obj;
			boolean b1 = this.policyName.equals(p.policyName);
			boolean b2 = this.premium == p.premium;
			boolean b3 = this.sumAssuredAmount==p.sumAssuredAmount;
			boolean b4 = this.policyNumber==p.policyNumber;
			
			return b1 && b2 && b3 && b4;
		}
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
