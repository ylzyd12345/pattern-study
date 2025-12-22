# 原型模式（Prototype Pattern）

## 1. 模式概述

原型模式是一种创建型设计模式，它允许通过复制现有对象来创建新对象，而无需知道创建的具体细节。原型模式提供了一种比直接实例化更灵活的方式来创建对象。

### 1.1 核心意图
- 通过复制现有对象来创建新对象
- 避免创建对象时的复杂初始化过程
- 提供一种比直接实例化更灵活的方式

### 1.2 解决的问题
当创建对象的成本较高，或者需要避免构造函数的复杂性时，原型模式提供了一种有效的解决方案。它允许通过复制现有对象来创建新对象，而无需重新执行复杂的初始化过程。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 抽象原型（Prototype） | 定义了复制自身的接口 | Cloneable接口 |
| 具体原型（ConcretePrototype） | 实现了复制自身的方法 | Book类 |
| 客户端（Client） | 使用原型对象来创建新对象 | App类 |

### 2.2 结构示意图

```
┌─────────────────┐
│   Prototype     │
└─────────┬───────┘
          │
┌─────────▼───────┐
│ ConcretePrototype │
└─────────────────┘
        ▲
        │  clone()
        │
┌───────┴─────────┐
│    Client       │
└─────────────────┘
```

## 3. 实现示例

### 3.1 具体原型类

```java
package com.kevin.demo.creational.原;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体原型类 - 实现了Cloneable接口
 */
public class Book implements Cloneable {
    private String name;
    private String author;
    private double price;
    private List<String> contents;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.contents = new ArrayList<>();
        System.out.println("Book constructor called");
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }

    public void addContent(String content) {
        this.contents.add(content);
    }

    /**
     * 实现克隆方法
     */
    @Override
    protected Book clone() throws CloneNotSupportedException {
        Book clonedBook = (Book) super.clone();
        // 深拷贝contents列表
        clonedBook.contents = new ArrayList<>(this.contents);
        return clonedBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", contents=" + contents +
                '}';
    }
}
```

### 3.2 客户端类

```java
package com.kevin.demo.creational.原;

/**
 * 客户端类 - 使用原型模式创建对象
 */
public class App {
    public static void main(String[] args) {
        try {
            // 创建原始对象
            Book originalBook = new Book("Design Patterns", "GoF", 49.99);
            originalBook.addContent("Chapter 1: Introduction");
            originalBook.addContent("Chapter 2: Prototype Pattern");
            
            System.out.println("Original Book: " + originalBook);
            System.out.println("Original Book hashcode: " + originalBook.hashCode());
            System.out.println("Original Book contents hashcode: " + originalBook.getContents().hashCode());
            
            // 克隆对象
            Book clonedBook = originalBook.clone();
            System.out.println("Cloned Book: " + clonedBook);
            System.out.println("Cloned Book hashcode: " + clonedBook.hashCode());
            System.out.println("Cloned Book contents hashcode: " + clonedBook.getContents().hashCode());
            
            // 修改克隆对象
            clonedBook.setName("Design Patterns - Clone");
            clonedBook.setPrice(39.99);
            clonedBook.addContent("Chapter 3: Singleton Pattern");
            
            System.out.println("After modification:");
            System.out.println("Original Book: " + originalBook);
            System.out.println("Cloned Book: " + clonedBook);
            
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
```

## 4. 优缺点分析

### 4.1 优点

- **简化对象创建过程**：避免了复杂的构造函数调用
- **提高性能**：对于复杂对象，克隆比重新创建更高效
- **动态创建对象**：可以在运行时动态创建对象
- **保护原始对象**：克隆对象与原始对象相互独立

### 4.2 缺点

- **深拷贝实现复杂**：对于包含复杂引用类型的对象，深拷贝实现起来比较复杂
- **需要实现Cloneable接口**：Java中需要实现Cloneable接口并覆盖clone()方法
- **代码可读性差**：克隆过程隐藏在clone()方法中，可能导致代码可读性差

## 5. 适用场景

### 5.1 应用场景

- 当创建对象的成本较高时
- 当需要避免构造函数的复杂性时
- 当需要动态创建对象时
- 当需要保护原始对象时

### 5.2 实际应用

- 数据库连接池
- 游戏中的角色对象
- 图形界面中的组件对象
- 配置对象的复制

## 6. 设计原则

原型模式遵循以下设计原则：

- **单一职责原则**：每个类只负责一种功能
- **开闭原则**：可以在不修改现有代码的情况下扩展系统
- **里氏替换原则**：任何基类可以出现的地方，子类一定可以出现

## 7. 与其他模式的比较

### 7.1 原型模式 vs 工厂方法模式

- **原型模式**：通过复制现有对象创建新对象
- **工厂方法模式**：通过工厂类创建新对象

### 7.2 原型模式 vs 抽象工厂模式

- **原型模式**：关注对象的复制
- **抽象工厂模式**：关注产品家族的创建

### 7.3 原型模式 vs 建造者模式

- **原型模式**：通过复制创建完整对象
- **建造者模式**：通过分步构建创建完整对象

## 8. 权威开源框架中的使用场景

### 8.1 JDK中的原型模式

1. **java.lang.Cloneable接口**：
   - 标记接口，用于指示对象可以被克隆
   - 示例：`java.util.ArrayList`、`java.util.HashMap`等集合类都实现了该接口
   - 相关类：`java.lang.Object.clone()`方法

2. **java.lang.Object.clone()方法**：
   - 提供了对象克隆的基本实现
   - 示例：`ArrayList.clone()`方法
   - 相关类：`java.lang.Object`类

3. **java.util.Collections**：
   - 提供了集合的复制方法
   - 示例：`Collections.copy()`方法
   - 相关类：`java.util.Collections`类

4. **java.io.Serializable接口**：
   - 通过序列化和反序列化实现深拷贝
   - 示例：使用`ObjectOutputStream`和`ObjectInputStream`实现对象克隆
   - 相关类：`java.io.ObjectOutputStream`、`java.io.ObjectInputStream`类

### 8.2 Spring中的原型模式

1. **Spring Bean的原型作用域**：
   - Spring容器支持原型作用域的Bean
   - 每次请求都会创建一个新的Bean实例
   - 示例：`@Scope("prototype")`注解
   - 相关类：`org.springframework.beans.factory.config.Scope`接口

2. **Spring的BeanUtils.copyProperties()方法**：
   - 提供了对象属性的复制功能
   - 示例：`BeanUtils.copyProperties(source, target)`方法
   - 相关类：`org.springframework.beans.BeanUtils`类

3. **Spring的SerializationUtils.clone()方法**：
   - 通过序列化和反序列化实现深拷贝
   - 示例：`SerializationUtils.clone(object)`方法
   - 相关类：`org.springframework.util.SerializationUtils`类

### 8.3 Spring Boot中的原型模式

1. **Spring Boot的自动配置类**：
   - 自动配置类可以被复制和定制
   - 示例：`@AutoConfigureBefore`、`@AutoConfigureAfter`等注解
   - 相关类：`org.springframework.boot.autoconfigure.AutoConfiguration`类

2. **Spring Boot的配置属性**：
   - 配置属性可以被复制和覆盖
   - 示例：`@ConfigurationProperties`注解
   - 相关类：`org.springframework.boot.context.properties.ConfigurationProperties`注解

3. **Spring Boot的健康检查指示器**：
   - 健康检查指示器可以被复制和扩展
   - 示例：`HealthIndicator`接口的实现类
   - 相关类：`org.springframework.boot.actuate.health.HealthIndicator`接口

## 9. 总结

原型模式是一种创建型设计模式，它允许通过复制现有对象来创建新对象，而无需知道创建的具体细节。原型模式提供了一种比直接实例化更灵活的方式来创建对象。

在权威开源框架中，原型模式也有大量应用：

- **JDK**：`Cloneable`接口、`Object.clone()`方法、`Collections.copy()`方法等
- **Spring**：原型作用域的Bean、`BeanUtils.copyProperties()`方法、`SerializationUtils.clone()`方法等
- **Spring Boot**：自动配置类、配置属性、健康检查指示器等

原型模式适用于创建对象成本较高、需要避免构造函数复杂性、需要动态创建对象或需要保护原始对象的场景。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。