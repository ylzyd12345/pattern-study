package com.kevin.demo.behavioral.state;

/**
 * 透支状态类
 * <p>
 * 状态模式中的具体状态(ConcreteState)角色，代表账户的透支状态
 * <p>
 * 当账户余额在-2000到0之间时处于此状态，允许存款和取款操作，但需要支付利息
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class OverdraftState extends AccountState {

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
        account.setBalance(account.getBalance() - amount);
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
        } else if (account.getBalance() == -2000) {
            // 保持当前状态
        } else if (account.getBalance() < -2000) {
            account.setState(new RestricteState(this));
            System.out.println("操作受限");
        }
    }

}
