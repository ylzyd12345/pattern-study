package com.kevin.demo.behavioral.state;

/**
 * 正常状态类
 * <p>
 * 状态模式中的具体状态(ConcreteState)角色，代表账户的正常状态
 * <p>
 * 当账户余额大于0时处于此状态，允许正常的存款和取款操作，无需支付利息
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class NormalState extends AccountState {

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
        account.setBalance(account.getBalance() - amount);
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
        } else if (account.getBalance() == -2000) {
            account.setState(new RestricteState(this));
        } else if (account.getBalance() < -2000) {
            account.setState(new RestricteState(this));
            System.out.println("操作受限");
        }
    }

}
