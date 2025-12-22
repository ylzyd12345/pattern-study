package com.kevin.demo.behavioral.状态;

/**
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		Account account = new Account("张三", 100);
		account.deposit(1900);
		account.withdraw(2000);
		account.withdraw(100);
		account.deposit(2200);
		account.withdraw(2000);
		account.withdraw(2200);
		account.withdraw(200);
		account.withdraw(2100);
		account.computeInterest();
	}
}
