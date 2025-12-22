# 模板模式（Template Pattern）

## 1. 模式概述

模板模式是一种行为型设计模式，它定义了一个算法的骨架，并允许子类为一个或多个步骤提供实现。模板模式使得子类可以在不改变算法结构的情况下，重新定义算法的某些步骤。模板模式是基于继承的设计模式，它在父类中定义了算法的骨架，在子类中实现具体的步骤。

### 1.1 核心意图
- 定义算法的骨架
- 允许子类为一个或多个步骤提供实现
- 不改变算法结构的情况下重新定义算法的某些步骤

### 1.2 解决的问题
当需要定义一个算法的骨架，并允许子类为一个或多个步骤提供实现时，模板模式提供了一种有效的解决方案。它使得子类可以在不改变算法结构的情况下，重新定义算法的某些步骤，提高了代码的复用性和可维护性。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 抽象类（AbstractClass） | 定义了算法的骨架 | AbstractClass类 |
| 具体类（ConcreteClass） | 实现了抽象类中的抽象方法 | ConcreteClass类 |
| 客户端（Client） | 使用抽象类和具体类 | Client类 |

### 2.2 结构示意图

```
┌───────────────┐
│ AbstractClass │
└────────┬──────┘
         │
         │
         │
┌────────▼──────┐
│ ConcreteClass │
└───────────────┘
```

## 3. 实现示例

### 3.1 抽象类

```java
package com.kevin.demo.behavioral.模板;

/**
 * 抽象类 - 积分赠送动作
 */
public abstract class AbstractPointGiveAction {
    /**
     * 模板方法 - 积分赠送算法的骨架
     */
    public final void givePoints() {
        // 步骤1：验证用户身份
        validateUser();
        
        // 步骤2：计算积分
        int points = calculatePoints();
        
        // 步骤3：保存积分记录
        savePointRecord(points);
        
        // 步骤4：发送积分通知
        sendPointNotification(points);
    }
    
    /**
     * 验证用户身份 - 具体实现
     */
    private void validateUser() {
        System.out.println("验证用户身份");
    }
    
    /**
     * 计算积分 - 抽象方法，由子类实现
     */
    protected abstract int calculatePoints();
    
    /**
     * 保存积分记录 - 具体实现
     */
    private void savePointRecord(int points) {
        System.out.println("保存积分记录：" + points);
    }
    
    /**
     * 发送积分通知 - 钩子方法，由子类选择性实现
     */
    protected void sendPointNotification(int points) {
        System.out.println("发送积分通知：获得" + points + "积分");
    }
}
```

### 3.2 具体类

```java
package com.kevin.demo.behavioral.模板;

/**
 * 具体类 - 基础积分赠送动作
 */
public class BasePointGiveAction extends AbstractPointGiveAction {
    @Override
    protected int calculatePoints() {
        System.out.println("使用基础积分计算公式");
        return 100;
    }
}
```

```java
package com.kevin.demo.behavioral.模板;

/**
 * 具体类 - 香港积分赠送动作
 */
public class HKPointGiveAction extends AbstractPointGiveAction {
    @Override
    protected int calculatePoints() {
        System.out.println("使用香港积分计算公式");
        return 200;
    }
    
    @Override
    protected void sendPointNotification(int points) {
        System.out.println("发送香港积分通知：获得" + points + "积分");
    }
}
```

### 3.3 客户端类

```java
package com.kevin.demo.behavioral.模板;

/**
 * 客户端类
 */
public class App {
    public static void main(String[] args) {
        // 使用基础积分赠送动作
        AbstractPointGiveAction baseAction = new BasePointGiveAction();
        baseAction.givePoints();
        
        System.out.println();
        
        // 使用香港积分赠送动作
        AbstractPointGiveAction hkAction = new HKPointGiveAction();
        hkAction.givePoints();
    }
}
```

## 4. 优缺点分析

### 4.1 优点

- **提高代码复用性**：将算法的骨架定义在父类中，子类只需要实现具体的步骤
- **提高代码可维护性**：算法的结构集中在父类中，修改算法结构只需要修改父类
- **强制算法结构**：确保子类遵循算法的结构
- **扩展性好**：可以通过添加新的具体类来扩展算法

### 4.2 缺点

- **灵活性差**：父类定义了算法的骨架，子类只能修改具体的步骤，不能修改算法的结构
- **增加了系统的复杂度**：需要理解父类和子类的关系
- **可能导致类的数量增加**：每个具体的算法都需要一个对应的具体类

## 5. 适用场景

### 5.1 应用场景

- 当需要定义一个算法的骨架，并允许子类为一个或多个步骤提供实现时
- 当需要确保子类遵循算法的结构时
- 当需要提高代码的复用性和可维护性时

### 5.2 实际应用

- 数据库访问框架
- Web框架的请求处理流程
- 报表生成系统
- 工作流引擎

## 6. 设计原则

模板模式遵循以下设计原则：

- **单一职责原则**：每个类只负责一个功能
- **开闭原则**：可以在不修改现有代码的情况下添加新的具体类
- **里氏替换原则**：子类可以替换父类

## 7. 与其他模式的比较

### 7.1 模板模式 vs 策略模式

- **模板模式**：基于继承，算法的骨架在父类中定义
- **策略模式**：基于组合，算法在策略类中定义

### 7.2 模板模式 vs 工厂方法模式

- **模板模式**：定义算法的骨架
- **工厂方法模式**：创建对象

### 7.3 模板模式 vs 抽象工厂模式

- **模板模式**：定义算法的骨架
- **抽象工厂模式**：创建产品家族

## 8. 权威开源框架中的使用场景

### 8.1 JDK中的模板模式

1. **java.io.InputStream**：
   - 使用模板模式定义了输入流的算法骨架
   - 示例：`read()`, `skip()`, `available()`等方法
   - 相关类：`java.io.InputStream`类

2. **java.io.OutputStream**：
   - 使用模板模式定义了输出流的算法骨架
   - 示例：`write()`, `flush()`, `close()`等方法
   - 相关类：`java.io.OutputStream`类

3. **java.util.AbstractList**：
   - 使用模板模式定义了列表的算法骨架
   - 示例：`get()`, `add()`, `remove()`等方法
   - 相关类：`java.util.AbstractList`类

### 8.2 Spring中的模板模式

1. **Spring的JdbcTemplate**：
   - 使用模板模式定义了JDBC操作的算法骨架
   - 示例：`query()`, `update()`, `execute()`等方法
   - 相关类：`org.springframework.jdbc.core.JdbcTemplate`类

2. **Spring的HibernateTemplate**：
   - 使用模板模式定义了Hibernate操作的算法骨架
   - 示例：`save()`, `update()`, `delete()`等方法
   - 相关类：`org.springframework.orm.hibernate5.HibernateTemplate`类

3. **Spring的RestTemplate**：
   - 使用模板模式定义了REST操作的算法骨架
   - 示例：`getForObject()`, `postForObject()`, `put()`等方法
   - 相关类：`org.springframework.web.client.RestTemplate`类

### 8.3 Spring Boot中的模板模式

1. **Spring Boot的DataSourceInitializer**：
   - 使用模板模式定义了数据源初始化的算法骨架
   - 示例：`runScripts()`, `executeSqlScript()`等方法
   - 相关类：`org.springframework.boot.jdbc.DataSourceInitializer`类

2. **Spring Boot的CommandLineRunner**：
   - 使用模板模式定义了命令行运行的算法骨架
   - 示例：`run()`方法
   - 相关类：`org.springframework.boot.CommandLineRunner`接口

3. **Spring Boot的ApplicationRunner**：
   - 使用模板模式定义了应用程序运行的算法骨架
   - 示例：`run()`方法
   - 相关类：`org.springframework.boot.ApplicationRunner`接口

## 9. 总结

模板模式是一种行为型设计模式，它定义了一个算法的骨架，并允许子类为一个或多个步骤提供实现。模板模式使得子类可以在不改变算法结构的情况下，重新定义算法的某些步骤。模板模式是基于继承的设计模式，它在父类中定义了算法的骨架，在子类中实现具体的步骤。

在权威开源框架中，模板模式也有大量应用：

- **JDK**：`InputStream`, `OutputStream`, `AbstractList`等
- **Spring**：`JdbcTemplate`, `HibernateTemplate`, `RestTemplate`等
- **Spring Boot**：`DataSourceInitializer`, `CommandLineRunner`, `ApplicationRunner`等

模板模式适用于当需要定义一个算法的骨架，并允许子类为一个或多个步骤提供实现时。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。