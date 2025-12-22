package com.kevin.demo.behavioral.状态;

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

    /**
     * 构造方法
     * 
     * @param accountState 现有账户状态
     */
    public RestricteState(AccountState accountState) {
        this.account = accountState.account;
    }

    /**
     * 存款操作
     * <p>
     * 在受限状态下，存款会直接增加账户余额，然后检查是否需要转换状态
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
     * 在受限状态下，不允许取款操作
     * 
     * @param amount 取款金额
     */
    @Override
    public void withdraw(double amount) {
        System.out.println("账户受限，取款失败");
    }

    /**
     * 计算利息
     * <p>
     * 在受限状态下，需要计算并支付利息
     */
    @Override
    public void computeInterest() {
        System.out.println("计算利息");
    }

    /**
     * 状态检查
     * <p>
     * 根据当前账户余额检查是否需要转换到其他状态：
     * <ul>
     * <li>余额在-2000到0之间：转换为透支状态</li>
     * <li>余额大于0：转换为正常状态</li>
     * </ul>
     */
    @Override
    public void stateCheck() {
        if (-2000 < account.getBalance() && account.getBalance() <= 0) {
            account.setState(new OverdraftState(this));
        } else if (account.getBalance() > 0) {
            account.setState(new NormalState(this));
        }
    }

}