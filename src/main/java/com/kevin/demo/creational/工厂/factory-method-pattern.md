# 工厂方法模式（Factory Method Pattern）

## 1. 模式概述

工厂方法模式是一种创建型设计模式，它定义了一个创建对象的接口，但让子类决定实例化哪一个类。工厂方法模式让类的实例化推迟到子类中进行。

### 1.1 核心意图
- 定义创建对象的接口，让子类决定实例化哪一个类
- 让类的实例化推迟到子类中进行
- 提供一种比直接实例化更灵活的方式

### 1.2 解决的问题
当一个类不知道它所必须创建的对象的类，或者一个类希望由其子类来指定它所创建的对象时，工厂方法模式提供了一种有效的解决方案。它允许通过接口来创建对象，而无需指定具体的实现类。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 抽象产品（Product） | 定义了产品的接口 | Product接口 |
| 具体产品（ConcreteProduct） | 实现了抽象产品接口 | ConcreteProductA、ConcreteProductB类 |
| 抽象工厂（Creator） | 定义了创建产品的接口 | Creator抽象类 |
| 具体工厂（ConcreteCreator） | 实现了创建产品的方法 | ConcreteCreatorA、ConcreteCreatorB类 |
| 客户端（Client） | 使用工厂方法创建产品 | App类 |

### 2.2 结构示意图

```
┌─────────────────┐     ┌─────────────────┐
│   Product       │     │    Creator      │
└─────────┬───────┘     └─────────┬───────┘
          │                        │
┌─────────▼───────┐     ┌─────────▼───────┐
│ ConcreteProductA │◄─────┤ ConcreteCreatorA │
└─────────────────┘     └─────────────────┘
          │                        │
┌─────────▼───────┐     ┌─────────▼───────┐
│ ConcreteProductB │◄─────┤ ConcreteCreatorB │
└─────────────────┘     └─────────────────┘
```

## 3. 实现示例

### 3.1 抽象产品类

```java
package com.kevin.demo.creational.工and抽.工厂方法;

/**
 * 抽象产品接口
 */
public interface Product {
    void operation();
}
```

### 3.2 具体产品类

```java
package com.kevin.demo.creational.工and抽.工厂方法;

/**
 * 具体产品A
 */
public class ConcreteProductA implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductA operation");
    }
}
```

```java
package com.kevin.demo.creational.工and抽.工厂方法;

/**
 * 具体产品B
 */
public class ConcreteProductB implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductB operation");
    }
}
```

### 3.3 抽象工厂类

```java
package com.kevin.demo.creational.工and抽.工厂方法;

/**
 * 抽象工厂类
 */
public abstract class Creator {
    /**
     * 工厂方法
     */
    public abstract Product factoryMethod();
    
    /**
     * 使用产品的方法
     */
    public void useProduct() {
        Product product = factoryMethod();
        product.operation();
    }
}
```

### 3.4 具体工厂类

```java
package com.kevin.demo.creational.工and抽.工厂方法;

/**
 * 具体工厂A
 */
public class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}
```

```java
package com.kevin.demo.creational.工and抽.工厂方法;

/**
 * 具体工厂B
 */
public class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}
```

### 3.5 客户端类

```java
package com.kevin.demo.creational.工and抽.工厂方法;

/**
 * 客户端类
 */
public class App {
    public static void main(String[] args) {
        // 创建具体工厂A
        Creator creatorA = new ConcreteCreatorA();
        creatorA.useProduct();
        
        // 创建具体工厂B
        Creator creatorB = new ConcreteCreatorB();
        creatorB.useProduct();
    }
}
```

## 4. 优缺点分析

### 4.1 优点

- **灵活性高**：客户端可以通过更换具体工厂来使用不同的产品
- **符合开闭原则**：可以在不修改现有代码的情况下添加新的产品和工厂
- **解耦**：客户端不需要知道产品的具体实现细节
- **提高代码复用性**：工厂方法封装了产品的创建逻辑

### 4.2 缺点

- **类数量增加**：每增加一个产品，就需要增加一个具体产品类和一个具体工厂类
- **复杂度增加**：增加了系统的抽象性和理解难度
- **可能导致工厂类层次结构过于复杂**：当产品种类较多时，工厂类的层次结构会变得复杂

## 5. 适用场景

### 5.1 应用场景

- 当一个类不知道它所必须创建的对象的类时
- 当一个类希望由其子类来指定它所创建的对象时
- 当类将创建对象的职责委托给多个帮助子类中的某一个时

### 5.2 实际应用

- 数据库连接工厂
- 日志记录器工厂
- 图形界面组件工厂
- 配置文件解析器工厂

## 6. 设计原则

工厂方法模式遵循以下设计原则：

- **单一职责原则**：每个工厂类只负责创建一种产品
- **开闭原则**：可以在不修改现有代码的情况下添加新的产品和工厂
- **依赖倒置原则**：客户端依赖于抽象工厂和抽象产品，而不是具体工厂和具体产品

## 7. 与其他模式的比较

### 7.1 工厂方法模式 vs 简单工厂模式

- **工厂方法模式**：通过子类来创建产品，符合开闭原则
- **简单工厂模式**：通过一个工厂类来创建所有产品，不符合开闭原则

### 7.2 工厂方法模式 vs 抽象工厂模式

- **工厂方法模式**：创建单一产品
- **抽象工厂模式**：创建产品家族

### 7.3 工厂方法模式 vs 建造者模式

- **工厂方法模式**：关注产品的创建
- **建造者模式**：关注产品的构建过程

## 8. 权威开源框架中的使用场景

### 8.1 JDK中的工厂方法模式

1. **java.util.Calendar.getInstance()**：
   - 使用工厂方法创建Calendar实例
   - 根据不同的时区和语言环境创建不同的Calendar实例
   - 相关类：`java.util.Calendar`类

2. **java.util.ResourceBundle.getBundle()**：
   - 使用工厂方法创建ResourceBundle实例
   - 根据不同的语言环境创建不同的ResourceBundle实例
   - 相关类：`java.util.ResourceBundle`类

3. **java.text.NumberFormat.getInstance()**：
   - 使用工厂方法创建NumberFormat实例
   - 根据不同的语言环境创建不同的NumberFormat实例
   - 相关类：`java.text.NumberFormat`类

4. **java.nio.charset.Charset.forName()**：
   - 使用工厂方法创建Charset实例
   - 根据不同的字符集名称创建不同的Charset实例
   - 相关类：`java.nio.charset.Charset`类

### 8.2 Spring中的工厂方法模式

1. **Spring的FactoryBean**：
   - 使用工厂方法创建Bean实例
   - 示例：`ProxyFactoryBean`、`JndiObjectFactoryBean`等
   - 相关类：`org.springframework.beans.factory.FactoryBean`接口

2. **Spring的BeanFactory**：
   - 使用工厂方法创建Bean实例
   - 示例：`ApplicationContext`接口是BeanFactory的子接口
   - 相关类：`org.springframework.beans.factory.BeanFactory`接口

3. **Spring的ApplicationListener**：
   - 使用工厂方法创建ApplicationListener实例
   - 示例：`ContextRefreshedEvent`、`ContextClosedEvent`等事件的监听器
   - 相关类：`org.springframework.context.ApplicationListener`接口

### 8.3 Spring Boot中的工厂方法模式

1. **Spring Boot的AutoConfiguration**：
   - 使用工厂方法创建自动配置类实例
   - 示例：`@EnableAutoConfiguration`注解加载的自动配置类
   - 相关类：`org.springframework.boot.autoconfigure.AutoConfiguration`类

2. **Spring Boot的DataSourceAutoConfiguration**：
   - 使用工厂方法创建DataSource实例
   - 根据不同的配置创建不同的DataSource实例
   - 相关类：`org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration`类

3. **Spring Boot的WebServerFactory**：
   - 使用工厂方法创建WebServer实例
   - 根据不同的配置创建不同的WebServer实例
   - 相关类：`org.springframework.boot.web.server.WebServerFactory`接口

## 9. 总结

工厂方法模式是一种创建型设计模式，它定义了一个创建对象的接口，但让子类决定实例化哪一个类。工厂方法模式让类的实例化推迟到子类中进行。

在权威开源框架中，工厂方法模式也有大量应用：

- **JDK**：`Calendar.getInstance()`、`ResourceBundle.getBundle()`、`NumberFormat.getInstance()`、`Charset.forName()`等
- **Spring**：`FactoryBean`、`BeanFactory`、`ApplicationListener`等
- **Spring Boot**：`AutoConfiguration`、`DataSourceAutoConfiguration`、`WebServerFactory`等

工厂方法模式适用于当一个类不知道它所必须创建的对象的类，或者一个类希望由其子类来指定它所创建的对象，或者类将创建对象的职责委托给多个帮助子类中的某一个时。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。