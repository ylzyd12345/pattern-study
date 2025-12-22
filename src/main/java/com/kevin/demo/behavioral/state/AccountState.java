package com.kevin.demo.behavioral.state;

/**
 * 账户状态抽象类
 * <p>
 * 状态模式中的状态(State)角色，定义了一个接口来封装与Context的一个特定状态相关的行为
 * <p>
 * 所有具体状态类都必须实现这个接口
 * 
 * @author Kevin
 * @since 1.0.0
 */
public abstract class AccountState {
    
    /**
     * 对上下文(Account)的引用
     * <p>
     * 状态对象可以通过这个引用访问上下文，以便在状态转换时更新上下文的状态
     */
    protected Account account;
    
    /**
     * 存款操作
     * <p>
     * 不同状态下的存款行为可能不同
     * 
     * @param amount 存款金额
     */
    public abstract void deposit(double amount);
    
    /**
     * 取款操作
     * <p>
     * 不同状态下的取款行为可能不同
     * 
     * @param amount 取款金额
     */
    public abstract void withdraw(double amount);
    
    /**
     * 计算利息
     * <p>
     * 不同状态下的利息计算方式可能不同
     */
    public abstract void computeInterest();
    
    /**
     * 状态检查
     * <p>
     * 在每次操作后检查账户状态是否需要转换
     */
    public abstract void stateCheck();
}