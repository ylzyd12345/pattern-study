package com.kevin.demo.behavioral.状态;

/**
 * 透支状态
 * @author Administrator
 *
 */
public class OverdraftState  extends AccountState {

	public OverdraftState(AccountState accountState) {
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
		System.out.println("透支状态，支付利息");
	}

	@Override
	public void stateCheck() {
		if (account.getBalance() > 0) {
			account.setState(new NormalState(this));
		}else if (account.getBalance() == -2000) {
			account.setState(new OverdraftState(this));
		}
		else if (account.getBalance() < -2000) {
			account.setState(new RestricteState(this));
			System.out.println("操作受限");
		}
	}

}
