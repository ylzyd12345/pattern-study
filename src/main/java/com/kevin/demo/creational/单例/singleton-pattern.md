# 单例模式（Singleton Pattern）

## 1. 模式概述

单例模式是一种创建型设计模式，它确保一个类只有一个实例，并提供一个全局访问点来访问这个唯一实例。单例模式是最常用的设计模式之一，它在整个应用程序中只创建一个对象实例，避免了重复创建对象带来的资源浪费。

### 1.1 核心意图
- 确保一个类只有一个实例
- 提供一个全局访问点来访问这个唯一实例
- 控制实例的创建和访问

### 1.2 解决的问题
当需要确保一个类只有一个实例，并且需要在整个应用程序中共享这个实例时，单例模式提供了一种有效的解决方案。它避免了重复创建对象带来的资源浪费，同时保证了对象的一致性。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 单例类（Singleton） | 确保只有一个实例，并提供全局访问点 | Singleton类 |
| 客户端（Client） | 使用单例类的实例 | Client类 |

### 2.2 结构示意图

```
┌───────────┐
│ Singleton │
└─────┬─────┘
      │
      │ instance
      │
┌─────▼─────┐
│ Client    │
└───────────┘
```

## 3. 实现示例

### 3.1 懒汉式（线程不安全）

```java
package com.kevin.demo.creational.单例;

/**
 * 懒汉式单例（线程不安全）
 */
public class SingletonLazyUnsafe {
    private static SingletonLazyUnsafe instance;

    private SingletonLazyUnsafe() {}

    public static SingletonLazyUnsafe getInstance() {
        if (instance == null) {
            instance = new SingletonLazyUnsafe();
        }
        return instance;
    }
}
```

### 3.2 懒汉式（线程安全）

```java
package com.kevin.demo.creational.单例;

/**
 * 懒汉式单例（线程安全）
 */
public class SingletonLazySafe {
    private static SingletonLazySafe instance;

    private SingletonLazySafe() {}

    public static synchronized SingletonLazySafe getInstance() {
        if (instance == null) {
            instance = new SingletonLazySafe();
        }
        return instance;
    }
}
```

### 3.3 饿汉式

```java
package com.kevin.demo.creational.单例;

/**
 * 饿汉式单例
 */
public class SingletonEager {
    private static final SingletonEager instance = new SingletonEager();

    private SingletonEager() {}

    public static SingletonEager getInstance() {
        return instance;
    }
}
```

### 3.4 双重检查锁定

```java
package com.kevin.demo.creational.单例;

/**
 * 双重检查锁定单例
 */
public class SingletonDoubleCheck {
    private volatile static SingletonDoubleCheck instance;

    private SingletonDoubleCheck() {}

    public static SingletonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
```

### 3.5 静态内部类

```java
package com.kevin.demo.creational.单例;

/**
 * 静态内部类单例
 */
public class SingletonStaticInner {
    private SingletonStaticInner() {}

    private static class SingletonHolder {
        private static final SingletonStaticInner instance = new SingletonStaticInner();
    }

    public static SingletonStaticInner getInstance() {
        return SingletonHolder.instance;
    }
}
```

### 3.6 枚举单例

```java
package com.kevin.demo.creational.单例;

/**
 * 枚举单例
 */
public enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("枚举单例的方法");
    }
}
```

### 3.7 客户端类

```java
package com.kevin.demo.creational.单例;

/**
 * 客户端类
 */
public class App {
    public static void main(String[] args) {
        // 测试懒汉式单例
        SingletonLazyUnsafe singleton1 = SingletonLazyUnsafe.getInstance();
        SingletonLazyUnsafe singleton2 = SingletonLazyUnsafe.getInstance();
        System.out.println(singleton1 == singleton2);

        // 测试饿汉式单例
        SingletonEager singleton3 = SingletonEager.getInstance();
        SingletonEager singleton4 = SingletonEager.getInstance();
        System.out.println(singleton3 == singleton4);

        // 测试枚举单例
        SingletonEnum singleton5 = SingletonEnum.INSTANCE;
        SingletonEnum singleton6 = SingletonEnum.INSTANCE;
        System.out.println(singleton5 == singleton6);
        singleton5.doSomething();
    }
}
```

## 4. 优缺点分析

### 4.1 优点

- **减少资源消耗**：避免了重复创建对象带来的资源浪费
- **保证对象一致性**：确保整个应用程序使用同一个对象实例
- **全局访问点**：提供了一个全局访问点来访问唯一实例
- **控制实例数量**：可以控制类的实例数量

### 4.2 缺点

- **违反单一职责原则**：单例类既要负责创建实例，又要负责业务逻辑
- **测试困难**：单例类的依赖关系难以模拟
- **隐藏依赖关系**：客户端代码可能依赖于单例类，导致代码耦合度高
- **线程安全问题**：需要考虑线程安全问题

## 5. 适用场景

### 5.1 应用场景

- 当需要确保一个类只有一个实例时
- 当需要在整个应用程序中共享一个实例时
- 当需要控制实例数量时

### 5.2 实际应用

- 配置管理器
- 日志管理器
- 数据库连接池
- 线程池
- 缓存管理器

## 6. 设计原则

单例模式遵循以下设计原则：

- **单一职责原则**：单例类应该只负责创建实例和提供访问点
- **封装原则**：隐藏了实例的创建和访问细节
- **全局访问原则**：提供了一个全局访问点来访问唯一实例

## 7. 与其他模式的比较

### 7.1 单例模式 vs 工厂方法模式

- **单例模式**：确保一个类只有一个实例
- **工厂方法模式**：创建不同类型的实例

### 7.2 单例模式 vs 抽象工厂模式

- **单例模式**：创建一个类的唯一实例
- **抽象工厂模式**：创建多个相关产品

### 7.3 单例模式 vs 原型模式

- **单例模式**：创建一个类的唯一实例
- **原型模式**：通过复制现有对象创建新对象

## 8. 权威开源框架中的使用场景

### 8.1 JDK中的单例模式

1. **java.lang.Runtime**：
   - 使用单例模式确保只有一个Runtime实例
   - 示例：`Runtime.getRuntime()`
   - 相关类：`java.lang.Runtime`类

2. **java.awt.Toolkit**：
   - 使用单例模式确保只有一个Toolkit实例
   - 示例：`Toolkit.getDefaultToolkit()`
   - 相关类：`java.awt.Toolkit`类

3. **java.awt.Desktop**：
   - 使用单例模式确保只有一个Desktop实例
   - 示例：`Desktop.getDesktop()`
   - 相关类：`java.awt.Desktop`类

### 8.2 Spring中的单例模式

1. **Spring容器中的Bean**：
   - Spring容器默认使用单例模式管理Bean实例
   - 示例：`ApplicationContext.getBean("beanName")`
   - 相关类：`org.springframework.context.ApplicationContext`接口

2. **BeanFactory**：
   - BeanFactory是Spring容器的核心接口，它使用单例模式管理Bean实例
   - 相关类：`org.springframework.beans.factory.BeanFactory`接口

3. **ApplicationContext**：
   - ApplicationContext是BeanFactory的子接口，它也使用单例模式管理Bean实例
   - 相关类：`org.springframework.context.ApplicationContext`接口

### 8.3 Spring Boot中的单例模式

1. **SpringApplication**：
   - SpringApplication使用单例模式确保只有一个应用程序实例
   - 示例：`SpringApplication.run(App.class, args)`
   - 相关类：`org.springframework.boot.SpringApplication`类

2. **AutoConfiguration**：
   - 自动配置类在Spring Boot中使用单例模式管理
   - 相关类：`org.springframework.boot.autoconfigure.AutoConfiguration`类

3. **DataSource**：
   - 数据源在Spring Boot中默认使用单例模式管理
   - 相关类：`javax.sql.DataSource`接口

## 9. 总结

单例模式是一种创建型设计模式，它确保一个类只有一个实例，并提供一个全局访问点来访问这个唯一实例。单例模式是最常用的设计模式之一，它在整个应用程序中只创建一个对象实例，避免了重复创建对象带来的资源浪费。

单例模式有多种实现方式，包括懒汉式、饿汉式、双重检查锁定、静态内部类和枚举单例等。每种实现方式都有其优缺点，需要根据具体的需求选择合适的实现方式。

在权威开源框架中，单例模式也有大量应用：

- **JDK**：`Runtime`、`Toolkit`、`Desktop`等
- **Spring**：Spring容器中的Bean、`BeanFactory`、`ApplicationContext`等
- **Spring Boot**：`SpringApplication`、`AutoConfiguration`、`DataSource`等

单例模式适用于当需要确保一个类只有一个实例，并且需要在整个应用程序中共享这个实例时。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。