package com.kevin.demo.behavioral.状态;

/**
 * 正常状态
 * @author Administrator
 *
 */
public class NormalState  extends AccountState {

	public NormalState(Account account) {
		this.account = account;
	}

	public NormalState(AccountState accountState) {
		this.account = accountState.account;
	}

	@Override
	public void deposit(double amount) {
		account.setBalance(account.getBalance() + amount);
		stateCheck();
	}

	@Override
	public void withdraw(double amount) {
		account.setBalance(account.getBalance()-amount);
		stateCheck();
	}

	@Override
	public void computeInterest() {
		System.out.println("正常状态，无需支付利息");
	}

	@Override
	public void stateCheck() {
		if (-2000 < account.getBalance() && account.getBalance() <= 0) {
			account.setState(new OverdraftState(this));
		}else if (account.getBalance() == -2000) {
			account.setState(new RestricteState(this));
		}else if (account.getBalance() < -2000) {
			account.setState(new RestricteState(this));
			System.out.println("操作受限");
		}
	}

}
