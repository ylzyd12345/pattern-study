package com.kevin.demo.behavioral.state;

/**
 * 受限状态类
 * <p>
 * 状态模式中的具体状态(ConcreteState)角色，代表账户的受限状态
 * <p>
 * 当账户余额小于等于-2000时处于此状态，只允许存款操作，不允许取款操作
 * 
 * @author Kevin
 * @since 1.0.0
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
