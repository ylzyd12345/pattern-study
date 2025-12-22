# 命令模式（Command Pattern）

## 1. 模式概述

命令模式是一种行为型设计模式，它将请求封装为一个对象，从而允许用户使用不同的请求参数化客户端，对请求排队或记录请求日志，并支持可撤销的操作。命令模式将发送者和接收者解耦，使得发送者不需要知道接收者的具体实现。

### 1.1 核心意图
- 将请求封装为一个对象
- 解耦发送者和接收者
- 支持请求的排队、记录和撤销

### 1.2 解决的问题
当需要将请求的发送者和接收者解耦，或者需要支持请求的排队、记录和撤销时，命令模式提供了一种有效的解决方案。它允许发送者在不知道接收者具体实现的情况下发送请求，同时支持请求的可撤销操作。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 命令（Command） | 定义了执行请求的接口 | Command接口 |
| 具体命令（ConcreteCommand） | 实现了执行请求的方法 | ConcreteCommand类 |
| 接收者（Receiver） | 执行请求的实际对象 | Receiver类 |
| 调用者（Invoker） | 触发命令执行的对象 | Invoker类 |
| 客户端（Client） | 创建命令对象并设置其接收者 | Client类 |

### 2.2 结构示意图

```
┌───────────┐      ┌───────────────┐      ┌───────────┐
│ Invoker   │      │ Command       │      │ Receiver  │
└─────┬─────┘      └────────┬──────┘      └───────────┘
      │                     │
      │                     │
      │                     │
┌─────▼─────┐      ┌────────▼──────┐
│ Client    │      │ ConcreteCommand │
└───────────┘      └────────────────┘
```

## 3. 实现示例

### 3.1 命令接口

```java
package com.kevin.demo.behavioral.命令;

/**
 * 命令接口
 */
public interface Command {
    /**
     * 执行命令
     */
    void execute();
}
```

### 3.2 接收者类

```java
package com.kevin.demo.behavioral.命令;

/**
 * 接收者类 - 电视机
 */
public class Televation {
    public void open() {
        System.out.println("电视机打开了");
    }

    public void close() {
        System.out.println("电视机关闭了");
    }
}
```

### 3.3 具体命令类

```java
package com.kevin.demo.behavioral.命令;

/**
 * 具体命令类 - 打开电视命令
 */
public class TVOpenCommand implements Command {
    private Televation televation;

    public TVOpenCommand(Televation televation) {
        this.televation = televation;
    }

    @Override
    public void execute() {
        televation.open();
    }
}
```

```java
package com.kevin.demo.behavioral.命令;

/**
 * 具体命令类 - 关闭电视命令
 */
public class TVCloseCommand implements Command {
    private Televation televation;

    public TVCloseCommand(Televation televation) {
        this.televation = televation;
    }

    @Override
    public void execute() {
        televation.close();
    }
}
```

### 3.4 调用者类

```java
package com.kevin.demo.behavioral.命令;

/**
 * 调用者类 - 电视遥控器
 */
public class TVControl {
    private Command openCommand;
    private Command closeCommand;

    public TVControl(Command openCommand, Command closeCommand) {
        this.openCommand = openCommand;
        this.closeCommand = closeCommand;
    }

    public void openTV() {
        openCommand.execute();
    }

    public void closeTV() {
        closeCommand.execute();
    }
}
```

### 3.5 客户端类

```java
package com.kevin.demo.behavioral.命令;

/**
 * 客户端类
 */
public class App {
    public static void main(String[] args) {
        // 创建接收者
        Televation televation = new Televation();

        // 创建命令
        Command openCommand = new TVOpenCommand(televation);
        Command closeCommand = new TVCloseCommand(televation);

        // 创建调用者
        TVControl tvControl = new TVControl(openCommand, closeCommand);

        // 执行命令
        tvControl.openTV();
        tvControl.closeTV();
    }
}
```

## 4. 优缺点分析

### 4.1 优点

- **解耦发送者和接收者**：发送者不需要知道接收者的具体实现
- **支持请求的排队、记录和撤销**：可以对命令进行排队、记录日志和撤销操作
- **扩展性好**：可以在不修改现有代码的情况下添加新的命令
- **符合开闭原则**：可以在不修改现有代码的情况下添加新的命令

### 4.2 缺点

- **增加了系统的复杂度**：需要多个类来实现命令模式
- **命令类过多**：每个请求都需要一个对应的命令类
- **可能导致类爆炸**：如果命令过多，可能会导致类的数量过多

## 5. 适用场景

### 5.1 应用场景

- 当需要将请求的发送者和接收者解耦时
- 当需要支持请求的排队、记录和撤销时
- 当需要将请求参数化时
- 当需要支持命令的组合时

### 5.2 实际应用

- GUI菜单系统
- 远程控制系统
- 事务处理系统
- 命令行工具

## 6. 设计原则

命令模式遵循以下设计原则：

- **单一职责原则**：每个命令类只负责执行一个请求
- **开闭原则**：可以在不修改现有代码的情况下添加新的命令
- **解耦原则**：解耦发送者和接收者

## 7. 与其他模式的比较

### 7.1 命令模式 vs 策略模式

- **命令模式**：封装请求，支持请求的排队、记录和撤销
- **策略模式**：封装算法，支持算法的切换

### 7.2 命令模式 vs 状态模式

- **命令模式**：关注请求的执行
- **状态模式**：关注对象的状态变化

### 7.3 命令模式 vs 责任链模式

- **命令模式**：直接执行命令
- **责任链模式**：将请求传递给多个处理者

## 8. 权威开源框架中的使用场景

### 8.1 JDK中的命令模式

1. **java.lang.Runnable**：
   - 使用命令模式封装可运行的任务
   - 示例：`new Thread(new Runnable() { ... }).start()`
   - 相关类：`java.lang.Runnable`接口

2. **java.util.concurrent.Callable**：
   - 使用命令模式封装可调用的任务
   - 示例：`ExecutorService.submit(new Callable() { ... })`
   - 相关类：`java.util.concurrent.Callable`接口

3. **javax.swing.Action**：
   - 使用命令模式封装GUI操作
   - 示例：`JButton button = new JButton(action)`
   - 相关类：`javax.swing.Action`接口

### 8.2 Spring中的命令模式

1. **Spring的JmsTemplate**：
   - 使用命令模式发送JMS消息
   - 示例：`jmsTemplate.send(new MessageCreator() { ... })`
   - 相关类：`org.springframework.jms.core.JmsTemplate`类

2. **Spring的TransactionTemplate**：
   - 使用命令模式执行事务操作
   - 示例：`transactionTemplate.execute(new TransactionCallback() { ... })`
   - 相关类：`org.springframework.transaction.support.TransactionTemplate`类

3. **Spring的TaskExecutor**：
   - 使用命令模式执行异步任务
   - 示例：`taskExecutor.execute(new Runnable() { ... })`
   - 相关类：`org.springframework.core.task.TaskExecutor`接口

### 8.3 Spring Boot中的命令模式

1. **Spring Boot的CommandLineRunner**：
   - 使用命令模式在应用启动后执行命令
   - 示例：`@Component public class MyCommandLineRunner implements CommandLineRunner { ... }`
   - 相关类：`org.springframework.boot.CommandLineRunner`接口

2. **Spring Boot的ApplicationRunner**：
   - 使用命令模式在应用启动后执行命令
   - 示例：`@Component public class MyApplicationRunner implements ApplicationRunner { ... }`
   - 相关类：`org.springframework.boot.ApplicationRunner`接口

3. **Spring Boot的TaskScheduler**：
   - 使用命令模式执行定时任务
   - 示例：`taskScheduler.schedule(new Runnable() { ... }, new CronTrigger("0 0 12 * * ?"))`
   - 相关类：`org.springframework.scheduling.TaskScheduler`接口

## 9. 总结

命令模式是一种行为型设计模式，它将请求封装为一个对象，从而允许用户使用不同的请求参数化客户端，对请求排队或记录请求日志，并支持可撤销的操作。命令模式将发送者和接收者解耦，使得发送者不需要知道接收者的具体实现。

在权威开源框架中，命令模式也有大量应用：

- **JDK**：`Runnable`、`Callable`、`Action`等
- **Spring**：`JmsTemplate`、`TransactionTemplate`、`TaskExecutor`等
- **Spring Boot**：`CommandLineRunner`、`ApplicationRunner`、`TaskScheduler`等

命令模式适用于当需要将请求的发送者和接收者解耦，或者需要支持请求的排队、记录和撤销时。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。