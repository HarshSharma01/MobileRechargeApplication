package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountService{

	@Override
	public Account getAccountDetails(String mobileNo) {
		AccountDao accountDao=new AccountDaoImpl();
		Account account=accountDao.getAccountDetails(mobileNo);
		return account;
	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		AccountDao accountDao=new AccountDaoImpl();
		int amount=accountDao.rechargeAccount(mobileNo, rechargeAmount);
		return amount;
	}

}
