package com.kevin.demo.behavioral.state;

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
    
    private AccountState state;
    
    private String owner;
    
    private double balance = 0;
    
    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        // 初始状态为正常状态
        this.state = new NormalState(this);
        System.out.println(this.owner + "开户，金额:" + this.balance);
        System.out.println("-----------------------------------");
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void setState(AccountState state) {
        this.state = state;
    }
    
    public void deposit(double amount) {
        System.out.println(this.owner + "存款:" + amount);
        this.state.deposit(amount);
        System.out.println("余额:" + this.balance);
        System.out.println("账户状态:" + this.state.getClass().getName());
        System.out.println("-----------------------------------");
    }
    
    public void withdraw(double amount) {
        System.out.println(this.owner + "取款:" + amount);
        this.state.withdraw(amount);
        System.out.println("余额:" + this.balance);
        System.out.println("账户状态:" + this.state.getClass().getName());
        System.out.println("-----------------------------------");
    }
    
    public void computeInterest() {
        this.state.computeInterest();
    }
}
