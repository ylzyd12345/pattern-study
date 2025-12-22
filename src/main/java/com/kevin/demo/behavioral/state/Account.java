package com.kevin.demo.behavioral.状态;

/**
 * 账户类
 * <p>
 * 状态模式中的上下文(Context)角色，维护一个对AccountState对象的引用
 * <p>
 * 账户的行为会根据其当前状态而变化，通过委托给当前状态对象来实现不同状态下的行为
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class Account {
    
    /**
     * 账户当前状态
     */
    private AccountState state;
    
    /**
     * 账户所有者
     */
    private String owner;
    
    /**
     * 账户余额
     */
    private double balance = 0;
    
    /**
     * 构造方法
     * 
     * @param owner 账户所有者
     * @param balance 初始余额
     */
    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        // 初始状态为正常状态
        this.state = new NormalState(this);
        System.out.println(this.owner + "开户，金额:" + this.balance);
        System.out.println("-----------------------------------");
    }
    
    /**
     * 获取账户余额
     * 
     * @return 当前余额
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * 设置账户余额
     * 
     * @param balance 新的余额
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    /**
     * 设置账户状态
     * 
     * @param state 新的账户状态
     */
    public void setState(AccountState state) {
        this.state = state;
    }
    
    /**
     * 存款操作
     * <p>
     * 委托给当前状态对象处理
     * 
     * @param amount 存款金额
     */
    public void deposit(double amount) {
        System.out.println(this.owner + "存款:" + amount);
        this.state.deposit(amount);
        System.out.println("余额:" + this.balance);
        System.out.println("账户状态:" + this.state.getClass().getName());
        System.out.println("-----------------------------------");
    }
    
    /**
     * 取款操作
     * <p>
     * 委托给当前状态对象处理
     * 
     * @param amount 取款金额
     */
    public void withdraw(double amount) {
        System.out.println(this.owner + "取款:" + amount);
        this.state.withdraw(amount);
        System.out.println("余额:" + this.balance);
        System.out.println("账户状态:" + this.state.getClass().getName());
        System.out.println("-----------------------------------");
    }
    
    /**
     * 计算利息
     * <p>
     * 委托给当前状态对象处理
     */
    public void computeInterest() {
        this.state.computeInterest();
    }
}