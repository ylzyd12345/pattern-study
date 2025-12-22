package com.kevin.demo.behavioral.状态;

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

    /**
     * 构造方法
     * 
     * @param account 账户对象
     */
    public NormalState(Account account) {
        this.account = account;
    }

    /**
     * 构造方法
     * 
     * @param accountState 现有账户状态
     */
    public NormalState(AccountState accountState) {
        this.account = accountState.account;
    }

    /**
     * 存款操作
     * <p>
     * 在正常状态下，存款会直接增加账户余额，然后检查是否需要转换状态
     * 
     * @param amount 存款金额
     */
    @Override
    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        stateCheck();
    }

    /**
     * 取款操作
     * <p>
     * 在正常状态下，取款会直接减少账户余额，然后检查是否需要转换状态
     * 
     * @param amount 取款金额
     */
    @Override
    public void withdraw(double amount) {
        account.setBalance(account.getBalance() - amount);
        stateCheck();
    }

    /**
     * 计算利息
     * <p>
     * 在正常状态下，无需支付利息
     */
    @Override
    public void computeInterest() {
        System.out.println("正常状态，无需支付利息");
    }

    /**
     * 状态检查
     * <p>
     * 根据当前账户余额检查是否需要转换到其他状态：
     * <ul>
     * <li>余额在-2000到0之间：转换为透支状态</li>
     * <li>余额等于-2000：转换为受限状态</li>
     * <li>余额小于-2000：转换为受限状态并提示操作受限</li>
     * </ul>
     */
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