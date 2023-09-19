package acc.abc.filacc.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import acc.abc.filacc.model.Account;
import acc.abc.filacc.model.Policy;

public class AccMain {
	public static void main(String[] args) {
		Map<Integer, Account> accountMap = new HashMap<>();
		
		Policy p1 = new Policy(200, 12345, 20000,"Bajaj");
		Policy p2 = new Policy(300, 24635, 30000,"ICICI");
		Policy p3 = new Policy(250, 62875, 25000, "NewInsurance");
		Policy p4 = new Policy(500, 26765, 40000, "star");
		
		List<Policy> allPolicies = new ArrayList<>();
		allPolicies.add(p1);
		allPolicies.add(p2);
		allPolicies.add(p3);
		allPolicies.add(p4);
		
		List<Policy> policyA1 = new ArrayList<>();
		policyA1.add(p1);
		
		List<Policy> policyA2 = new ArrayList<>();
		policyA2.add(p2);
		
		List<Policy> policyA3 = new ArrayList<>();
		policyA3.add(p3);
		
		List<Policy> policyA4 = new ArrayList<>();
		
		List<Policy> policyA5 = new ArrayList<>();
		policyA5.add(p4);
		
		Account a1 = new Account(123, "vinay", 20000, "bangalore", policyA1);
		Account a2 = new Account(124, "ihwui", 10000, "chennai", policyA2);
		Account a3 = new Account(125, "kjag", 15000, "bangalore", policyA3);
		Account a4 = new Account(126, "uhsiu", 80000, "mumbai", policyA4);
		Account a5 = new Account(127, "cwjij", 56000, "bangalore", policyA5);
		Account a6 = new Account(128, "cwjiusu", 26000, "mumbai", policyA1);
		
		accountMap.put(a1.getAccountId(), a1);
		accountMap.put(a2.getAccountId(), a2);
		accountMap.put(a3.getAccountId(), a3);
		accountMap.put(a4.getAccountId(), a4);
		accountMap.put(a5.getAccountId(), a5);
		accountMap.put(a6.getAccountId(), a6);
		
		
		AccMain ac = new AccMain();
		Map<String, List<Account>> locMap = new HashMap<>();
		Map<String, List<Account>> policyMap = new HashMap<>();
		Map<Integer[],List<Account>> balRangeMap = new LinkedHashMap<>();
		
		Iterator<Entry<Integer,Account>> iterate = accountMap.entrySet().iterator();
		
		while(iterate.hasNext()) {
			Account acc = iterate.next().getValue();
			String location = acc.getLocation();
			locMap.put(location, ac.filterAccounts(accountMap, location));
		}
		
		int j = 0;
		for(int i = 10000; i < 100000; i+=10000) {
			Integer arr[] = {i,j};
			balRangeMap.put(arr, ac.filterAccountsOnBalance(accountMap, j, i));
			j += 10000;
		}
		
//		List<Account> arr = ac.filterAccounts(accountMap,"bangalore");
		
		for(Map.Entry<String,List<Account>> entry : locMap.entrySet()) {
//			System.out.println(entry.getKey());
			Iterator<Account> iter = entry.getValue().iterator();
			System.out.println(entry.getKey()+"----------------");
			while(iter.hasNext()) {
				Account a = iter.next();
				System.out.println(" Account Id: "+a.getAccountId()+" AccountHolderName: "+a.getAccountHolderName()+" BankBalance: "+ a.getBankBalance()+" Location: "+a.getLocation());
			}
			
		}
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(" ");
		for(Map.Entry<Integer[],List<Account>> entry : balRangeMap.entrySet()) {
//			System.out.println(entry.getKey());
			Iterator<Account> iter = entry.getValue().iterator();
			System.out.println("Balance Range: "+entry.getKey()[1]+" to "+entry.getKey()[0]+"----------------");
			while(iter.hasNext()) {
				Account a = iter.next();
				System.out.println(" Account Id: "+a.getAccountId()+" AccountHolderName: "+a.getAccountHolderName()+" BankBalance: "+ a.getBankBalance()+" Location: "+a.getLocation());
			}
			
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("All details using account id------------------------------------------------------");
		ac.getAccountDetailsByAccNo(accountMap, 123);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("All accounts using policy name------------------------------------------------------");
		ac.getAccountDetailsByPolicyName(accountMap, "Bajaj");
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("All accounts using policy number------------------------------------------------------");
		ac.getAccountDetailsByPolicyNumber(accountMap, 24635);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("All accounts which have no policy------------------------------------------------------");
		ac.getAccountDetailsByNoPolicy(accountMap);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Enter the minimum sum assured: ");
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		System.out.println("accounts with more than minimum sum assured policies are --------------------------");
		System.out.println(" ");
		ac.getBySumAssured(accountMap, amount);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Enter the maximum premium value: ");
		Scanner s = new Scanner(System.in);
		int premium = s.nextInt();
		System.out.println("accounts with less than the maximum premium policies are --------------------------");
		System.out.println(" ");
		ac.getByLowPremium(accountMap, premium);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Enter the location: ");
		Scanner scan = new Scanner(System.in);
		String policyLoc = scan.nextLine();
		System.out.println("accounts with policies in "+ policyLoc +" are --------------------------");
		System.out.println(" ");
		ac.filterAccountsOnLocAndPolicy(accountMap, policyLoc);
		System.out.println(" ");
		System.out.println(" ");
		
		for(Policy p: allPolicies){
			policyMap.put(p.getPolicyName(), ac.filterAccountsByPolicyName(accountMap, p.getPolicyName()));
		}
		
		for(Map.Entry<String,List<Account>> entry : policyMap.entrySet()) {
//			System.out.println(entry.getKey());
			Iterator<Account> iter = entry.getValue().iterator();
			System.out.println("Policy name: "+entry.getKey()+"-------------------");
			System.out.println(" ");
			while(iter.hasNext()) {
				Account a = iter.next();
				System.out.println(" Account Id: "+a.getAccountId()+" AccountHolderName: "+a.getAccountHolderName()+" BankBalance: "+ a.getBankBalance()+" Location: "+a.getLocation());
			}
			System.out.println(" ");
		}
		
	}
	public List<Account> filterAccounts(Map<Integer,Account> accountMap, String loc) {
		Iterator<Entry<Integer, Account>> itr = accountMap.entrySet().iterator();
		ArrayList<Account> sameLocAccounts = new ArrayList<>();
//		for(Map.Entry<Integer, Account> entry : accountMap.entrySet()) {
//			if(entry.getValue().getLocation().equals(loc)) {
//				System.out.println("accID "+ entry.getKey()+" acc holder name "+ entry.getValue().getAccountHolderName()+" location "+entry.getValue().getLocation());
//			}
//		}
		while(itr.hasNext()) {
			Account a = itr.next().getValue();
			String location = a.getLocation();
			if(location.equals(loc)) {
				sameLocAccounts.add(a);
//				System.out.println(location);
			}
		}
		return sameLocAccounts;
	}
	
	public List<Account> filterAccountsOnBalance(Map<Integer,Account> accountMap, int min, int max) {
		Iterator<Entry<Integer, Account>> itr = accountMap.entrySet().iterator();
		ArrayList<Account> sameBalanceRangeAccounts = new ArrayList<>();
//		for(Map.Entry<Integer, Account> entry : accountMap.entrySet()) {
//			if(entry.getValue().getLocation().equals(loc)) {
//				System.out.println("accID "+ entry.getKey()+" acc holder name "+ entry.getValue().getAccountHolderName()+" location "+entry.getValue().getLocation());
//			}
//		}
		while(itr.hasNext()) {
			Account a = itr.next().getValue();
			int balance = a.getBankBalance();
			if(balance > min && balance <= max ) {
				sameBalanceRangeAccounts.add(a);
//				System.out.println(location);
			}
		}
		return sameBalanceRangeAccounts;
	}
	
	public void getAccountDetailsByAccNo(Map<Integer,Account> accountMap,int accNum) {
		for(Entry e: accountMap.entrySet()) {
			if((int)e.getKey()==accNum) {
				if(e.getValue() instanceof Account) {
					Account ac = (Account)e.getValue();
					System.out.println(ac);
					if(ac.getPolicies().size()!=0) {
					for(Policy p: ac.getPolicies()) {
						System.out.println("Premium: "+ p.getPremium() + " PolicyID: "+p.getPolicyNumber()+" PolicyName: "+p.getPolicyName()+" PolicySum: "+p.getSumAssuredAmount());
					}
					}
					else {
						System.out.println("No policies attached");
					}
				}
			}
		}
	}
	
	public void getAccountDetailsByPolicyName(Map<Integer,Account> accountMap,String policyName) {
		for(Entry e: accountMap.entrySet()) {
			if(e.getValue() instanceof Account) {
				Account ac = (Account)e.getValue();
				for(Policy p: ac.getPolicies()) {
					if(p.getPolicyName()==policyName) {
						System.out.println(ac);
						System.out.println("Premium: "+ p.getPremium() + " PolicyID: "+p.getPolicyNumber()+" PolicyName: "+p.getPolicyName()+" PolicySum: "+p.getSumAssuredAmount());
					}
				}
			}
		}
	}
	
	public void getAccountDetailsByPolicyNumber(Map<Integer,Account> accountMap,int policyNumber) {
		for(Entry e: accountMap.entrySet()) {
			if(e.getValue() instanceof Account) {
				Account ac = (Account)e.getValue();
				for(Policy p: ac.getPolicies()) {
					if(p.getPolicyNumber()==policyNumber) {
						System.out.println(ac);
						System.out.println("Premium: "+ p.getPremium() + " PolicyID: "+p.getPolicyNumber()+" PolicyName: "+p.getPolicyName()+" PolicySum: "+p.getSumAssuredAmount());
					}
				}
			}
		}
	}
	
	public void getAccountDetailsByNoPolicy(Map<Integer,Account> accountMap) {
		for(Entry e: accountMap.entrySet()) {
			if(e.getValue() instanceof Account) {
				Account ac = (Account)e.getValue();
				if(ac.getPolicies().size()==0) {
					System.out.println(ac);		
					System.out.println("No Policy Attached");}
				}
		}
	}
	
	public void getBySumAssured(Map<Integer,Account> accountMap,int amount) {
		for(Entry e: accountMap.entrySet()) {
			if(e.getValue() instanceof Account) {
				Account acc = (Account)e.getValue();
				for(Policy p: acc.getPolicies()) {
					if(p.getSumAssuredAmount()>amount) {
						System.out.println(acc);
						System.out.println("Premium: "+ p.getPremium() + " PolicyID: "+p.getPolicyNumber()+" PolicyName: "+p.getPolicyName()+" PolicySum: "+p.getSumAssuredAmount());
					}
				}
			}
		}
	}
	
	public void getByLowPremium(Map<Integer,Account> accountMap,int amount) {
		for(Entry e: accountMap.entrySet()) {
			if(e.getValue() instanceof Account) {
				Account acc = (Account)e.getValue();
				for(Policy p: acc.getPolicies()) {
					if(p.getPremium()<amount) {
						System.out.println(acc);
						System.out.println("Premium: "+ p.getPremium() + " PolicyID: "+p.getPolicyNumber()+" PolicyName: "+p.getPolicyName()+" PolicySum: "+p.getSumAssuredAmount());
					}
				}
			}
		}
	}
	
	public void filterAccountsOnLocAndPolicy(Map<Integer,Account> accountMap, String loc) {
		Iterator<Entry<Integer, Account>> itr = accountMap.entrySet().iterator();
		ArrayList<Account> sameLocAccounts = new ArrayList<>();
		while(itr.hasNext()) {
			Account a = itr.next().getValue();
			String location = a.getLocation();
			if(location.equals(loc)&& a.getPolicies().size()!=0) {
				System.out.println(a);
			}
		}
	}
	
	public List<Account> filterAccountsByPolicyName(Map<Integer,Account> accountMap, String policyName) {
		Iterator<Entry<Integer, Account>> itr = accountMap.entrySet().iterator();
		ArrayList<Account> samePolicyNameAccounts = new ArrayList<>();
		while(itr.hasNext()) {
			Account a = itr.next().getValue();
			if(a.getPolicies().size()!=0) {
				for(Policy p: a.getPolicies()) {
					if(p.getPolicyName().equals(policyName)) {
					samePolicyNameAccounts.add(a);
					}
				}
			}
		}
		return samePolicyNameAccounts;
	}
}
