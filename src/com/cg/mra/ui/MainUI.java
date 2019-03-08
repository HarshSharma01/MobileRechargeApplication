package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;
import com.cg.mra.exceptions.*;
public class MainUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		AccountService account= new AccountServiceImpl();
		while(true) {
			System.out.println("1) Account Balance Enquiry \n 2) Recharge Account \n 3) Exit");
			int choice = scan.nextInt();
			switch(choice) {
			case 1 : System.out.println("Enter Mobile No");
			 		String mobileNo=scan.next();
			 			if(mobileNo.length()!=10) {
			 				try {
			 					throw new InvalidNumberException("given account id does not exist");
			 			}
			 			catch(Exception e) {
			 			//e.printStackTrace();
			 		}
			 			}
			 			Account acc=account.getAccountDetails(mobileNo);
			 			if(acc!=null) {
			 			System.out.println(acc.getAccountBalance());
			 			}
			 			else {
			 				System.out.println("number does not exist");
			 			}
			 			break;
			case 2 : System.out.println("Enter Mobile No");
						mobileNo=scan.next();
						acc=account.getAccountDetails(mobileNo);
						if(acc!=null) {
						System.out.println("enter recharge amount");
						double rechargeAmount=scan.nextDouble();
						double amount=account.rechargeAccount(mobileNo, rechargeAmount);
						System.out.println("Your Account Recharged Successfully");
						System.out.println("Hello "+acc.getCustomerName()+"\t Available Balance is "+amount);
						}
						else {
							System.err.println("ERROR:cannot recharge as given mobile id does not exist");
						}
						break;
				default : System.exit(0);
			}
		}
	}

}
