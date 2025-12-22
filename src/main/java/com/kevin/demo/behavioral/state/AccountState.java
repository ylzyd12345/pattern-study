package com.kevin.demo.behavioral.state;

/**
 * AccountState抽象类 - 状态模式中的抽象状态角色
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public abstract class AccountState {
    protected Account account;
    
    public abstract void deposit(double amount);
    
    public abstract void withdraw(double amount);
    
    public abstract void computeInterest();
    
    public abstract void stateCheck();
}