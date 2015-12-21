package com.kevin.demo.behavioral.状态;

/**
 * 受限状态
 * 
 * @author Administrator
 *
 */
public class RestricteState extends AccountState {

	public RestricteState(AccountState accountState) {
		this.account = accountState.account;
	}

	@Override
	public void deposit(double amount) {
		account.setBalance(account.getBalance() + amount);
		stateCheck();
	}

	@Override
	public void withdraw(double amount) {
		System.out.println("账户受限，取款失败");
	}

	@Override
	public void computeInterest() {
		System.out.println("计算利息");
	}

	@Override
	public void stateCheck() {
		if (-2000 < account.getBalance() && account.getBalance() <= 0) {
			account.setState(new OverdraftState(this));
		} else if (account.getBalance() > 0) {
			account.setState(new NormalState(this));
		}
	}

}
