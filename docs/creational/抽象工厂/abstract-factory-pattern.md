# 抽象工厂模式（Abstract Factory Pattern）

## 1. 模式概述

抽象工厂模式是一种创建型设计模式，它提供了一个接口，用于创建相关或依赖对象的家族，而不需要指定具体类。抽象工厂模式允许客户端使用抽象的接口来创建一组相关的产品，而不需要关心实际产出的具体产品是什么。

### 1.1 核心意图
- 提供一个接口，用于创建相关或依赖对象的家族
- 不需要指定具体类
- 允许客户端使用抽象的接口来创建一组相关的产品

### 1.2 解决的问题
当需要创建一组相关或依赖的对象，而不需要指定它们的具体类时，抽象工厂模式提供了一种有效的解决方案。它允许通过接口来创建产品家族，而无需关心实际的实现细节。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 抽象工厂（AbstractFactory） | 定义了创建产品家族的接口 | AbstractFactory接口 |
| 具体工厂（ConcreteFactory） | 实现了创建产品家族的方法 | ConcreteFactory1、ConcreteFactory2类 |
| 抽象产品（AbstractProduct） | 定义了产品的接口 | AbstractProductA、AbstractProductB接口 |
| 具体产品（ConcreteProduct） | 实现了抽象产品接口 | ConcreteProductA1、ConcreteProductA2、ConcreteProductB1、ConcreteProductB2类 |
| 客户端（Client） | 使用抽象工厂和抽象产品 | App类 |

### 2.2 结构示意图

```
┌─────────────────┐
│ AbstractFactory │
└─────────┬───────┘
          │
┌─────────▼───────┐     ┌─────────────────┐
│ ConcreteFactory1 │     │ ConcreteFactory2 │
└─────────┬───────┘     └─────────┬───────┘
          │                        │
┌─────────▼───────┐     ┌─────────▼───────┐
│ AbstractProductA │     │ AbstractProductA │
└─────────┬───────┘     └─────────┬───────┘
          │                        │
┌─────────▼───────┐     ┌─────────▼───────┐
│ ConcreteProductA1 │     │ ConcreteProductA2 │
└─────────────────┘     └─────────────────┘
          │                        │
┌─────────▼───────┐     ┌─────────▼───────┐
│ AbstractProductB │     │ AbstractProductB │
└─────────┬───────┘     └─────────┬───────┘
          │                        │
┌─────────▼───────┐     ┌─────────▼───────┐
│ ConcreteProductB1 │     │ ConcreteProductB2 │
└─────────────────┘     └─────────────────┘
```

## 3. 实现示例

### 3.1 抽象产品接口

```java
package com.kevin.demo.creational.工厂.抽象工厂;

/**
 * 抽象产品A接口
 */
public interface AbstractProductA {
   void operationA();
}
```

```java
package com.kevin.demo.creational.工厂.抽象工厂;

/**
 * 抽象产品B接口
 */
public interface AbstractProductB {
   void operationB();
}
```

### 3.2 具体产品类

```java
package com.kevin.demo.creational.工厂.抽象工厂;

/**
 * 具体产品A1
 */
public class ConcreteProductA1 implements AbstractProductA {
   @Override
   public void operationA() {
      System.out.println("ConcreteProductA1 operationA");
   }
}
```

```java
package com.kevin.demo.creational.工厂.抽象工厂;

/**
 * 具体产品A2
 */
public class ConcreteProductA2 implements AbstractProductA {
   @Override
   public void operationA() {
      System.out.println("ConcreteProductA2 operationA");
   }
}
```

```java
package com.kevin.demo.creational.工厂.抽象工厂;

/**
 * 具体产品B1
 */
public class ConcreteProductB1 implements AbstractProductB {
   @Override
   public void operationB() {
      System.out.println("ConcreteProductB1 operationB");
   }
}
```

```java
package com.kevin.demo.creational.工厂.抽象工厂;

/**
 * 具体产品B2
 */
public class ConcreteProductB2 implements AbstractProductB {
   @Override
   public void operationB() {
      System.out.println("ConcreteProductB2 operationB");
   }
}
```

### 3.3 抽象工厂接口

```java
package com.kevin.demo.creational.工厂.抽象工厂;

/**
 * 抽象工厂接口
 */
public interface AbstractFactory {
   AbstractProductA createProductA();

   AbstractProductB createProductB();
}
```

### 3.4 具体工厂类

```java
package com.kevin.demo.creational.工厂.抽象工厂;

/**
 * 具体工厂1
 */
public class ConcreteFactory1 implements AbstractFactory {
   @Override
   public AbstractProductA createProductA() {
      return new ConcreteProductA1();
   }

   @Override
   public AbstractProductB createProductB() {
      return new ConcreteProductB1();
   }
}
```

```java
package com.kevin.demo.creational.工厂.抽象工厂;

/**
 * 具体工厂2
 */
public class ConcreteFactory2 implements AbstractFactory {
   @Override
   public AbstractProductA createProductA() {
      return new ConcreteProductA2();
   }

   @Override
   public AbstractProductB createProductB() {
      return new ConcreteProductB2();
   }
}
```

### 3.5 客户端类

```java
package com.kevin.demo.creational.工厂.抽象工厂;

/**
 * 客户端类
 */
public class App {
   public static void main(String[] args) {
      // 使用具体工厂1创建产品家族
      AbstractFactory factory1 = new ConcreteFactory1();
      AbstractProductA productA1 = factory1.createProductA();
      AbstractProductB productB1 = factory1.createProductB();
      productA1.operationA();
      productB1.operationB();

      // 使用具体工厂2创建产品家族
      AbstractFactory factory2 = new ConcreteFactory2();
      AbstractProductA productA2 = factory2.createProductA();
      AbstractProductB productB2 = factory2.createProductB();
      productA2.operationA();
      productB2.operationB();
   }
}
```

## 4. 优缺点分析

### 4.1 优点

- **隔离了具体类的生成**：客户端不需要知道具体产品的实现细节
- **保证产品家族的一致性**：一个工厂创建的产品一定属于同一个产品家族
- **符合开闭原则**：可以在不修改现有代码的情况下添加新的产品家族
- **提高了代码的可维护性**：将产品家族的创建逻辑集中在一起

### 4.2 缺点

- **增加了系统的抽象性和理解难度**：需要理解多个抽象层
- **增加了系统的复杂度**：每增加一个产品家族，就需要增加多个类
- **扩展新的产品困难**：需要修改抽象工厂接口和所有具体工厂类

## 5. 适用场景

### 5.1 应用场景

- 当需要创建一组相关或依赖的对象时
- 当需要提供一个产品类库，而只希望暴露接口而不是实现时
- 当需要强调一系列相关产品对象的设计以便进行联合使用时

### 5.2 实际应用

- GUI工具包
- 数据库访问框架
- 操作系统的文件系统
- 配置文件解析器

## 6. 设计原则

抽象工厂模式遵循以下设计原则：

- **单一职责原则**：每个工厂类只负责创建一个产品家族
- **开闭原则**：可以在不修改现有代码的情况下添加新的产品家族
- **依赖倒置原则**：客户端依赖于抽象工厂和抽象产品，而不是具体工厂和具体产品

## 7. 与其他模式的比较

### 7.1 抽象工厂模式 vs 工厂方法模式

- **抽象工厂模式**：创建产品家族
- **工厂方法模式**：创建单一产品

### 7.2 抽象工厂模式 vs 建造者模式

- **抽象工厂模式**：关注产品家族的创建
- **建造者模式**：关注产品的构建过程

### 7.3 抽象工厂模式 vs 原型模式

- **抽象工厂模式**：通过工厂创建新对象
- **原型模式**：通过复制现有对象创建新对象

## 8. 权威开源框架中的使用场景

### 8.1 JDK中的抽象工厂模式

1. **java.sql.DriverManager**：
   - 使用抽象工厂模式创建数据库连接
   - 根据不同的数据库驱动创建不同的Connection实例
   - 相关类：`java.sql.Driver`、`java.sql.Connection`接口

2. **java.util.Calendar**：
   - 使用抽象工厂模式创建Calendar实例
   - 根据不同的时区和语言环境创建不同的Calendar实例
   - 相关类：`java.util.Calendar`类

3. **java.text.NumberFormat**：
   - 使用抽象工厂模式创建NumberFormat实例
   - 根据不同的语言环境创建不同的NumberFormat实例
   - 相关类：`java.text.NumberFormat`类

### 8.2 Spring中的抽象工厂模式

1. **Spring的BeanFactory**：
   - 使用抽象工厂模式创建Bean实例
   - 示例：`ApplicationContext`接口是BeanFactory的子接口
   - 相关类：`org.springframework.beans.factory.BeanFactory`接口

2. **Spring的TransactionManager**：
   - 使用抽象工厂模式创建事务管理器
   - 根据不同的持久化框架创建不同的TransactionManager实例
   - 相关类：`org.springframework.transaction.PlatformTransactionManager`接口

3. **Spring的DataSource**：
   - 使用抽象工厂模式创建数据源
   - 根据不同的数据库连接池创建不同的DataSource实例
   - 相关类：`javax.sql.DataSource`接口

### 8.3 Spring Boot中的抽象工厂模式

1. **Spring Boot的AutoConfiguration**：
   - 使用抽象工厂模式创建自动配置类
   - 根据不同的配置创建不同的自动配置类实例
   - 相关类：`org.springframework.boot.autoconfigure.AutoConfiguration`类

2. **Spring Boot的DataSourceAutoConfiguration**：
   - 使用抽象工厂模式创建DataSource实例
   - 根据不同的配置创建不同的DataSource实例
   - 相关类：`org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration`类

3. **Spring Boot的WebServerFactory**：
   - 使用抽象工厂模式创建WebServer实例
   - 根据不同的配置创建不同的WebServer实例
   - 相关类：`org.springframework.boot.web.server.WebServerFactory`接口

## 9. 总结

抽象工厂模式是一种创建型设计模式，它提供了一个接口，用于创建相关或依赖对象的家族，而不需要指定具体类。抽象工厂模式允许客户端使用抽象的接口来创建一组相关的产品，而不需要关心实际产出的具体产品是什么。

在权威开源框架中，抽象工厂模式也有大量应用：

- **JDK**：`DriverManager`、`Calendar`、`NumberFormat`等
- **Spring**：`BeanFactory`、`TransactionManager`、`DataSource`等
- **Spring Boot**：`AutoConfiguration`、`DataSourceAutoConfiguration`、`WebServerFactory`等

抽象工厂模式适用于当需要创建一组相关或依赖的对象，而不需要指定它们的具体类时。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。