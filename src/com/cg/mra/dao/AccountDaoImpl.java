package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;

public class AccountDaoImpl implements AccountDao{

	Map<String,Account> accountEntry;
	public AccountDaoImpl() {
		accountEntry= new HashMap<>();
		accountEntry.put("9010210131", new Account("Prepaid", "Vaishali", 200));
		accountEntry.put("9823920123", new Account("Prepaid", "Megha", 453));
		accountEntry.put("9932012345", new Account("Prepaid", "Vikas", 631));
		accountEntry.put("9010210131", new Account("Prepaid", "Anju", 521));
		accountEntry.put("9010210131", new Account("Prepaid", "Tushar", 632));
	}
	
	
	public Account getAccountDetails(String mobileNo) {
		int count=0;
		Account account=null;
		for(Map.Entry m: accountEntry.entrySet()) {
			if(m.getKey().equals(mobileNo)) {
				account= (Account) m.getValue();
				count++;
				break;
			}
		}
			if(count==0) {
				return null;
			}
			else {
				return account;
			}
		}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		Account account=null;
		int balance=0;
		int count=0;
		for(Map.Entry m: accountEntry.entrySet()) {
			if(m.getKey().equals(mobileNo)) {
				account= (Account) m.getValue();
				count++;
				double a=account.getAccountBalance();
				balance=(int) (a+rechargeAmount);
				break;
			}
		}
			if(count==0) {
				return 0;
			}
			else {
				return balance;
			}
	}

}
