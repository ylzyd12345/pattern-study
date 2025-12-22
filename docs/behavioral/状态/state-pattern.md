# 状态模式（State Pattern）

## 1. 模式概述

状态模式是一种行为型设计模式，它允许一个对象在其内部状态改变时改变其行为。状态模式将对象的行为封装在不同的状态类中，使得对象的行为可以根据其状态动态改变。状态模式是基于状态机的设计模式，它将状态和状态转换逻辑分离，提高了代码的可维护性和可扩展性。

### 1.1 核心意图
- 允许对象在内部状态改变时改变其行为
- 将状态和状态转换逻辑分离
- 封装状态的行为

### 1.2 解决的问题
当需要根据对象的状态动态改变其行为时，状态模式提供了一种有效的解决方案。它将对象的行为封装在不同的状态类中，使得对象的行为可以根据其状态动态改变，同时将状态和状态转换逻辑分离，提高了代码的可维护性和可扩展性。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 环境类（Context） | 维护一个当前状态，并将请求委托给当前状态 | Context类 |
| 状态接口（State） | 定义了状态的行为接口 | State接口 |
| 具体状态类（ConcreteState） | 实现了状态的行为 | ConcreteState类 |
| 客户端（Client） | 使用环境类 | Client类 |

### 2.2 结构示意图

```
┌───────────┐      ┌───────────────┐
│ Context   │      │ State         │
└─────┬─────┘      └────────┬──────┘
      │                     │
      │                     │
      │                     │
┌─────▼─────┐      ┌────────▼──────┐
│ Client    │      │ ConcreteState │
└───────────┘      └────────────────┘
```

## 3. 实现示例

### 3.1 状态接口

```java
package com.kevin.demo.behavioral.状态;

/**
 * 状态接口 - 账户状态
 */
public interface AccountState {
    /**
     * 存款
     */
    void deposit(Account account, double amount);
    
    /**
     * 取款
     */
    void withdraw(Account account, double amount);
    
    /**
     * 计算利息
     */
    void computeInterest(Account account);
}
```

### 3.2 具体状态类

```java
package com.kevin.demo.behavioral.状态;

/**
 * 具体状态类 - 正常状态
 */
public class NormalState implements AccountState {
    @Override
    public void deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("存款成功，当前余额：" + account.getBalance());
        stateCheck(account);
    }
    
    @Override
    public void withdraw(Account account, double amount) {
        account.setBalance(account.getBalance() - amount);
        System.out.println("取款成功，当前余额：" + account.getBalance());
        stateCheck(account);
    }
    
    @Override
    public void computeInterest(Account account) {
        System.out.println("正常状态，不计算利息");
    }
    
    /**
     * 状态检查
     */
    private void stateCheck(Account account) {
        if (account.getBalance() < 0) {
            account.setState(new OverdraftState());
        } else if (account.getBalance() >= 0) {
            account.setState(new NormalState());
        }
    }
}
```

```java
package com.kevin.demo.behavioral.状态;

/**
 * 具体状态类 - 透支状态
 */
public class OverdraftState implements AccountState {
    @Override
    public void deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("存款成功，当前余额：" + account.getBalance());
        stateCheck(account);
    }
    
    @Override
    public void withdraw(Account account, double amount) {
        if (account.getBalance() - amount >= -1000) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("取款成功，当前余额：" + account.getBalance());
            stateCheck(account);
        } else {
            System.out.println("余额不足，无法取款");
        }
    }
    
    @Override
    public void computeInterest(Account account) {
        System.out.println("透支状态，计算利息");
        account.setBalance(account.getBalance() * 0.95);
        System.out.println("利息计算后余额：" + account.getBalance());
        stateCheck(account);
    }
    
    /**
     * 状态检查
     */
    private void stateCheck(Account account) {
        if (account.getBalance() >= 0) {
            account.setState(new NormalState());
        } else if (account.getBalance() < -1000) {
            account.setState(new RestricteState());
        }
    }
}
```

```java
package com.kevin.demo.behavioral.状态;

/**
 * 具体状态类 - 受限状态
 */
public class RestricteState implements AccountState {
    @Override
    public void deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("存款成功，当前余额：" + account.getBalance());
        stateCheck(account);
    }
    
    @Override
    public void withdraw(Account account, double amount) {
        System.out.println("账户受限，无法取款");
    }
    
    @Override
    public void computeInterest(Account account) {
        System.out.println("受限状态，计算高额利息");
        account.setBalance(account.getBalance() * 0.9);
        System.out.println("利息计算后余额：" + account.getBalance());
        stateCheck(account);
    }
    
    /**
     * 状态检查
     */
    private void stateCheck(Account account) {
        if (account.getBalance() >= 0) {
            account.setState(new NormalState());
        } else if (account.getBalance() >= -1000) {
            account.setState(new OverdraftState());
        }
    }
}
```

### 3.3 环境类

```java
package com.kevin.demo.behavioral.状态;

/**
 * 环境类 - 账户
 */
public class Account {
    private String owner;
    private double balance;
    private AccountState state;
    
    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.state = new NormalState();
    }
    
    public void deposit(double amount) {
        state.deposit(this, amount);
    }
    
    public void withdraw(double amount) {
        state.withdraw(this, amount);
    }
    
    public void computeInterest() {
        state.computeInterest(this);
    }
    
    // getter和setter方法
    public String getOwner() {
        return owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public AccountState getState() {
        return state;
    }
    
    public void setState(AccountState state) {
        this.state = state;
    }
}
```

### 3.4 客户端类

```java
package com.kevin.demo.behavioral.状态;

/**
 * 客户端类
 */
public class App {
    public static void main(String[] args) {
        // 创建账户
        Account account = new Account("张三", 1000);
        
        // 存款
        account.deposit(500);
        
        // 取款
        account.withdraw(2000);
        
        // 计算利息
        account.computeInterest();
        
        // 存款
        account.deposit(1500);
        
        // 取款
        account.withdraw(500);
        
        // 计算利息
        account.computeInterest();
    }
}
```

## 4. 优缺点分析

### 4.1 优点

- **封装状态的行为**：将对象的行为封装在不同的状态类中
- **状态转换清晰**：状态转换逻辑明确，易于理解和维护
- **提高可扩展性**：可以通过添加新的状态类来扩展对象的行为
- **符合开闭原则**：可以在不修改现有代码的情况下添加新的状态

### 4.2 缺点

- **增加了系统的复杂度**：需要多个类来实现状态模式
- **状态类过多**：如果状态过多，可能会导致类的数量过多
- **状态转换逻辑分散**：状态转换逻辑分散在不同的状态类中

## 5. 适用场景

### 5.1 应用场景

- 当需要根据对象的状态动态改变其行为时
- 当对象的行为受其状态影响较大时
- 当需要将状态和状态转换逻辑分离时

### 5.2 实际应用

- 订单状态管理
- 工作流引擎
- 游戏角色状态管理
- 账户状态管理

## 6. 设计原则

状态模式遵循以下设计原则：

- **单一职责原则**：每个状态类只负责一个状态的行为
- **开闭原则**：可以在不修改现有代码的情况下添加新的状态
- **封装原则**：隐藏了状态的实现细节

## 7. 与其他模式的比较

### 7.1 状态模式 vs 策略模式

- **状态模式**：状态是对象的内部属性，状态转换由对象内部触发
- **策略模式**：策略是对象的外部属性，策略切换由客户端触发

### 7.2 状态模式 vs 模板模式

- **状态模式**：关注对象状态的变化
- **模板模式**：关注算法的骨架

### 7.3 状态模式 vs 命令模式

- **状态模式**：对象的行为根据其状态动态改变
- **命令模式**：封装请求，支持请求的排队、记录和撤销

## 8. 权威开源框架中的使用场景

### 8.1 JDK中的状态模式

1. **java.util.Iterator**：
   - 使用状态模式管理迭代器的状态
   - 示例：`hasNext()`, `next()`方法
   - 相关类：`java.util.Iterator`接口

2. **java.util.Enumeration**：
   - 使用状态模式管理枚举的状态
   - 示例：`hasMoreElements()`, `nextElement()`方法
   - 相关类：`java.util.Enumeration`接口

3. **java.lang.Thread.State**：
   - 使用状态模式管理线程的状态
   - 示例：`NEW`, `RUNNABLE`, `BLOCKED`, `WAITING`, `TIMED_WAITING`, `TERMINATED`
   - 相关类：`java.lang.Thread.State`枚举

### 8.2 Spring中的状态模式

1. **Spring的StateMachine**：
   - 使用状态模式实现状态机
   - 示例：`StateMachineBuilder`构建状态机
   - 相关类：`org.springframework.statemachine.StateMachine`接口

2. **Spring的TransactionStatus**：
   - 使用状态模式管理事务的状态
   - 示例：`isNewTransaction()`, `isRollbackOnly()`方法
   - 相关类：`org.springframework.transaction.TransactionStatus`接口

3. **Spring的MessageHeaders**：
   - 使用状态模式管理消息头的状态
   - 相关类：`org.springframework.messaging.MessageHeaders`类

### 8.3 Spring Boot中的状态模式

1. **Spring Boot的ApplicationState**：
   - 使用状态模式管理应用程序的状态
   - 示例：`STARTING`, `RUNNING`, `FAILED`, `STOPPING`, `STOPPED`
   - 相关类：`org.springframework.boot.ApplicationState`枚举

2. **Spring Boot的HealthIndicator**：
   - 使用状态模式管理应用程序的健康状态
   - 示例：`Health.up()`, `Health.down()`方法
   - 相关类：`org.springframework.boot.actuate.health.HealthIndicator`接口

3. **Spring Boot的InfoContributor**：
   - 使用状态模式管理应用程序的信息状态
   - 相关类：`org.springframework.boot.actuate.info.InfoContributor`接口

## 9. 总结

状态模式是一种行为型设计模式，它允许一个对象在其内部状态改变时改变其行为。状态模式将对象的行为封装在不同的状态类中，使得对象的行为可以根据其状态动态改变。状态模式是基于状态机的设计模式，它将状态和状态转换逻辑分离，提高了代码的可维护性和可扩展性。

在权威开源框架中，状态模式也有大量应用：

- **JDK**：`Iterator`, `Enumeration`, `Thread.State`等
- **Spring**：`StateMachine`, `TransactionStatus`, `MessageHeaders`等
- **Spring Boot**：`ApplicationState`, `HealthIndicator`, `InfoContributor`等

状态模式适用于当需要根据对象的状态动态改变其行为时。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。