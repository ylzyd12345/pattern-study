# 备忘录模式（Memento Pattern）

## 1. 模式概述

备忘录模式是一种行为型设计模式，它允许在不破坏封装性的前提下，捕获和恢复对象的内部状态。备忘录模式提供了一种将对象恢复到之前状态的机制，它在不暴露对象实现细节的情况下保存和恢复对象的状态。

### 1.1 核心意图
- 捕获对象的内部状态，以便在需要时恢复
- 不破坏对象的封装性
- 支持对象状态的撤销操作

### 1.2 解决的问题
当需要保存和恢复对象的内部状态，而又不希望暴露对象的实现细节时，备忘录模式提供了一种有效的解决方案。它允许在不破坏封装性的前提下，捕获和恢复对象的内部状态，支持对象状态的撤销操作。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 发起人（Originator） | 创建备忘录并使用备忘录恢复状态 | Originator类 |
| 备忘录（Memento） | 存储发起人的内部状态 | Memento类 |
| 管理者（Caretaker） | 负责保存备忘录 | Caretaker类 |
| 客户端（Client） | 使用发起人和管理者 | Client类 |

### 2.2 结构示意图

```
┌───────────┐      ┌───────────────┐      ┌───────────┐
│ Originator│      │ Memento       │      │ Caretaker │
└─────┬─────┘      └────────────────┘      └─────┬─────┘
      │                                          │
      │                                          │
      │                                          │
┌─────▼─────┐                               ┌─────▼─────┐
│ Client    │                               │ Client    │
└───────────┘                               └───────────┘
```

## 3. 实现示例

### 3.1 备忘录类

```java
package com.kevin.demo.behavioral.备忘录;

/**
 * 备忘录类
 */
public class Memento {
    private String name;
    private int level;
    private int blood;

    public Memento(String name, int level, int blood) {
        this.name = name;
        this.level = level;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getBlood() {
        return blood;
    }
}
```

### 3.2 发起人类

```java
package com.kevin.demo.behavioral.备忘录;

/**
 * 发起人类 - 游戏角色
 */
public class Role {
    private String name;
    private int level;
    private int blood;

    public Role(String name, int level, int blood) {
        this.name = name;
        this.level = level;
        this.blood = blood;
    }

    public void fight() {
        System.out.println("角色" + name + "开始战斗");
        blood -= 10;
        System.out.println("战斗结束，角色" + name + "的血量变为" + blood);
    }

    public void show() {
        System.out.println("角色：" + name + "，等级：" + level + "，血量：" + blood);
    }

    /**
     * 创建备忘录
     */
    public Memento createMemento() {
        return new Memento(name, level, blood);
    }

    /**
     * 恢复状态
     */
    public void restoreMemento(Memento memento) {
        this.name = memento.getName();
        this.level = memento.getLevel();
        this.blood = memento.getBlood();
    }
}
```

### 3.3 管理者类

```java
package com.kevin.demo.behavioral.备忘录;

/**
 * 管理者类
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
```

### 3.4 客户端类

```java
package com.kevin.demo.behavioral.备忘录;

/**
 * 客户端类
 */
public class App {
    public static void main(String[] args) {
        // 创建游戏角色
        Role role = new Role("战士", 10, 100);
        role.show();

        // 创建管理者
        Caretaker caretaker = new Caretaker();
        // 保存游戏角色状态
        caretaker.setMemento(role.createMemento());

        // 角色战斗
        role.fight();
        role.show();

        // 恢复游戏角色状态
        role.restoreMemento(caretaker.getMemento());
        role.show();
    }
}
```

## 4. 优缺点分析

### 4.1 优点

- **不破坏封装性**：备忘录模式在不暴露对象实现细节的情况下保存和恢复对象的状态
- **支持撤销操作**：可以恢复对象到之前的状态
- **保持对象一致性**：确保对象的状态在保存和恢复过程中保持一致
- **简单易用**：实现方式简单，易于理解和使用

### 4.2 缺点

- **内存消耗大**：如果需要保存多个状态，可能会消耗大量内存
- **实现复杂**：如果对象的状态比较复杂，备忘录的实现可能会比较复杂
- **状态变更频繁时性能影响**：如果对象的状态变更频繁，备忘录的创建和保存可能会影响性能

## 5. 适用场景

### 5.1 应用场景

- 当需要保存和恢复对象的内部状态时
- 当需要支持对象状态的撤销操作时
- 当不希望暴露对象的实现细节时

### 5.2 实际应用

- 文本编辑器的撤销功能
- 游戏的存档和读档功能
- 数据库事务的回滚功能
- 配置文件的版本管理

## 6. 设计原则

备忘录模式遵循以下设计原则：

- **封装原则**：隐藏了对象的内部状态和实现细节
- **单一职责原则**：每个类只负责一个功能
- **开闭原则**：可以在不修改现有代码的情况下添加新的备忘录

## 7. 与其他模式的比较

### 7.1 备忘录模式 vs 原型模式

- **备忘录模式**：保存对象的内部状态，支持状态恢复
- **原型模式**：复制对象，创建新的对象实例

### 7.2 备忘录模式 vs 状态模式

- **备忘录模式**：关注对象状态的保存和恢复
- **状态模式**：关注对象状态的变化

### 7.3 备忘录模式 vs 命令模式

- **备忘录模式**：保存和恢复对象状态
- **命令模式**：封装请求，支持请求的排队、记录和撤销

## 8. 权威开源框架中的使用场景

### 8.1 JDK中的备忘录模式

1. **java.util.Date**：
   - 使用备忘录模式保存日期的内部状态
   - 示例：`Date date = new Date(); long time = date.getTime(); Date newDate = new Date(time);`
   - 相关类：`java.util.Date`类

2. **java.lang.StringBuilder**：
   - 使用备忘录模式保存字符串的内部状态
   - 示例：`StringBuilder sb = new StringBuilder("Hello"); sb.append(" World"); sb.setLength(5);`
   - 相关类：`java.lang.StringBuilder`类

3. **java.util.Stack**：
   - 使用备忘录模式保存栈的内部状态
   - 示例：`Stack<String> stack = new Stack<>(); stack.push("a"); stack.push("b"); stack.pop();`
   - 相关类：`java.util.Stack`类

### 8.2 Spring中的备忘录模式

1. **Spring的TransactionSynchronizationManager**：
   - 使用备忘录模式保存事务的同步状态
   - 相关类：`org.springframework.transaction.support.TransactionSynchronizationManager`类

2. **Spring的SessionScope**：
   - 使用备忘录模式保存会话的状态
   - 相关类：`org.springframework.web.context.request.SessionScope`类

3. **Spring的FlashMap**：
   - 使用备忘录模式保存重定向时的临时数据
   - 相关类：`org.springframework.web.servlet.FlashMap`类

### 8.3 Spring Boot中的备忘录模式

1. **Spring Boot的ApplicationArguments**：
   - 使用备忘录模式保存应用程序的启动参数
   - 示例：`@Autowired private ApplicationArguments args;`
   - 相关类：`org.springframework.boot.ApplicationArguments`类

2. **Spring Boot的Environment**：
   - 使用备忘录模式保存应用程序的环境配置
   - 示例：`@Autowired private Environment env;`
   - 相关类：`org.springframework.core.env.Environment`接口

3. **Spring Boot的ConfigurableApplicationContext**：
   - 使用备忘录模式保存应用程序上下文的状态
   - 示例：`ConfigurableApplicationContext context = SpringApplication.run(App.class, args);`
   - 相关类：`org.springframework.context.ConfigurableApplicationContext`接口

## 9. 总结

备忘录模式是一种行为型设计模式，它允许在不破坏封装性的前提下，捕获和恢复对象的内部状态。备忘录模式提供了一种将对象恢复到之前状态的机制，它在不暴露对象实现细节的情况下保存和恢复对象的状态。

在权威开源框架中，备忘录模式也有大量应用：

- **JDK**：`Date`、`StringBuilder`、`Stack`等
- **Spring**：`TransactionSynchronizationManager`、`SessionScope`、`FlashMap`等
- **Spring Boot**：`ApplicationArguments`、`Environment`、`ConfigurableApplicationContext`等

备忘录模式适用于当需要保存和恢复对象的内部状态，而又不希望暴露对象的实现细节时。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。