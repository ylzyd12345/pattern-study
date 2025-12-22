# 迭代器模式（Iterator Pattern）

## 1. 模式概述

迭代器模式是一种行为型设计模式，它提供了一种方法来访问一个容器对象中的各个元素，而不需要暴露该对象的内部表示。迭代器模式将遍历算法与容器对象分离，使得遍历算法可以独立于容器对象变化。迭代器模式通常用于处理集合类数据结构。

### 1.1 核心意图
- 提供一种方法来访问一个容器对象中的各个元素，而不需要暴露该对象的内部表示
- 将遍历算法与容器对象分离
- 使得遍历算法可以独立于容器对象变化

### 1.2 解决的问题
当需要访问一个容器对象中的各个元素，而不需要暴露该对象的内部表示时，迭代器模式提供了一种有效的解决方案。它将遍历算法与容器对象分离，使得遍历算法可以独立于容器对象变化，提高了代码的可维护性和可扩展性。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 抽象迭代器（Iterator） | 定义了遍历元素的接口 | Iterator接口 |
| 具体迭代器（ConcreteIterator） | 实现了抽象迭代器的接口，提供了具体的遍历元素的操作 | ConcreteIterator类 |
| 抽象容器（Aggregate） | 定义了创建迭代器的接口 | Aggregate接口 |
| 具体容器（ConcreteAggregate） | 实现了抽象容器的接口，提供了具体的创建迭代器的操作 | ConcreteAggregate类 |
| 客户端（Client） | 使用迭代器来遍历容器中的元素 | Client类 |

### 2.2 结构示意图

```
┌─────────────┐      ┌─────────────┐
│ Iterator    │      │ Aggregate   │
└─────┬───────┘      └────────┬────┘
      │                       │
      │                       │
      │                       │
┌─────▼───────┐      ┌────────▼────┐
│ ConcreteIterator │      │ ConcreteAggregate │
└─────────────┘      └─────────────┘
            │
┌───────────▼───────────┐
│ Client                │
└───────────────────────┘
```

## 3. 实现示例

### 3.1 抽象迭代器接口

```java
package com.kevin.demo.behavioral.迭代;

/**
 * 抽象迭代器接口
 */
public interface Iterator<T> {
    /**
     * 判断是否还有下一个元素
     */
    boolean hasNext();
    
    /**
     * 获取下一个元素
     */
    T next();
}
```

### 3.2 抽象容器接口

```java
package com.kevin.demo.behavioral.迭代;

/**
 * 抽象容器接口
 */
public interface Aggregate<T> {
    /**
     * 创建迭代器
     */
    Iterator<T> createIterator();
}
```

### 3.3 具体迭代器类

```java
package com.kevin.demo.behavioral.迭代;

/**
 * 具体迭代器类 - 数组迭代器
 */
public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int index;
    
    public ArrayIterator(T[] array) {
        this.array = array;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return index < array.length;
    }
    
    @Override
    public T next() {
        if (hasNext()) {
            return array[index++];
        }
        return null;
    }
}
```

### 3.4 具体容器类

```java
package com.kevin.demo.behavioral.迭代;

/**
 * 具体容器类 - 数组容器
 */
public class ArrayAggregate<T> implements Aggregate<T> {
    private T[] array;
    
    public ArrayAggregate(T[] array) {
        this.array = array;
    }
    
    @Override
    public Iterator<T> createIterator() {
        return new ArrayIterator<>(array);
    }
}
```

### 3.5 客户端类

```java
package com.kevin.demo.behavioral.迭代;

/**
 * 客户端类
 */
public class App {
    public static void main(String[] args) {
        // 创建数组容器
        String[] names = {"张三", "李四", "王五", "赵六"};
        Aggregate<String> aggregate = new ArrayAggregate<>(names);
        
        // 创建迭代器
        Iterator<String> iterator = aggregate.createIterator();
        
        // 遍历容器
        System.out.println("遍历数组容器：");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

## 4. 优缺点分析

### 4.1 优点

- **解耦遍历算法与容器对象**：遍历算法可以独立于容器对象变化
- **统一遍历接口**：提供了统一的遍历接口，使得客户端可以使用相同的方式遍历不同的容器对象
- **易于扩展**：可以通过添加新的迭代器类来扩展遍历算法

### 4.2 缺点

- **增加代码复杂性**：迭代器模式增加了代码的复杂性
- **可能导致性能问题**：对于简单的容器对象，使用迭代器模式可能导致性能问题

## 5. 适用场景

### 5.1 应用场景

- 当需要访问一个容器对象中的各个元素，而不需要暴露该对象的内部表示时
- 当需要将遍历算法与容器对象分离时
- 当需要提供统一的遍历接口，使得客户端可以使用相同的方式遍历不同的容器对象时

### 5.2 实际应用

- Java集合框架中的Iterator接口
- C#集合框架中的IEnumerator接口
- Python中的迭代器协议
- JavaScript中的迭代器协议

## 6. 设计原则

迭代器模式遵循以下设计原则：

- **单一职责原则**：每个类只负责一个功能
- **开闭原则**：可以通过添加新的迭代器类来扩展遍历算法
- **依赖倒置原则**：迭代器依赖于容器接口，而不是具体的容器类

## 7. 与其他模式的比较

### 7.1 迭代器模式 vs 访问者模式

- **迭代器模式**：用于遍历容器中的元素，不访问元素的内部状态
- **访问者模式**：用于访问元素的内部状态并执行操作

### 7.2 迭代器模式 vs 组合模式

- **迭代器模式**：用于遍历容器中的元素
- **组合模式**：用于表示部分-整体层次结构

### 7.3 迭代器模式 vs 命令模式

- **迭代器模式**：用于遍历容器中的元素
- **命令模式**：将请求封装为一个对象

## 8. 权威开源框架中的使用场景

### 8.1 JDK中的迭代器模式

1. **java.util.Iterator**：
   - 使用迭代器模式遍历集合类数据结构
   - 示例：`Iterator<String> iterator = list.iterator()`
   - 相关类：`java.util.Iterator`接口

2. **java.util.ListIterator**：
   - 使用迭代器模式遍历List集合类数据结构，支持双向遍历
   - 示例：`ListIterator<String> listIterator = list.listIterator()`
   - 相关类：`java.util.ListIterator`接口

3. **java.util.Enumeration**：
   - 使用迭代器模式遍历枚举类数据结构
   - 示例：`Enumeration<String> enumeration = vector.elements()`
   - 相关类：`java.util.Enumeration`接口

### 8.2 Spring中的迭代器模式

1. **Spring的BeanDefinitionRegistry**：
   - 使用迭代器模式遍历Bean定义
   - 示例：`Iterator<String> iterator = beanDefinitionRegistry.getBeanDefinitionNames().iterator()`
   - 相关类：`org.springframework.beans.factory.support.BeanDefinitionRegistry`接口

2. **Spring的ResourcePatternResolver**：
   - 使用迭代器模式遍历资源
   - 示例：`Resource[] resources = resourcePatternResolver.getResources("classpath:*.xml")`
   - 相关类：`org.springframework.core.io.support.ResourcePatternResolver`接口

### 8.3 Spring Boot中的迭代器模式

1. **Spring Boot的ApplicationContext**：
   - 使用迭代器模式遍历Bean定义
   - 示例：`Iterator<String> iterator = applicationContext.getBeanDefinitionNames().iterator()`
   - 相关类：`org.springframework.context.ApplicationContext`接口

2. **Spring Boot的Environment**：
   - 使用迭代器模式遍历属性源
   - 示例：`Iterator<PropertySource<?>> iterator = environment.getPropertySources().iterator()`
   - 相关类：`org.springframework.core.env.Environment`接口

## 9. 总结

迭代器模式是一种行为型设计模式，它提供了一种方法来访问一个容器对象中的各个元素，而不需要暴露该对象的内部表示。迭代器模式将遍历算法与容器对象分离，使得遍历算法可以独立于容器对象变化。迭代器模式通常用于处理集合类数据结构。

在权威开源框架中，迭代器模式也有大量应用：

- **JDK**：`Iterator`, `ListIterator`, `Enumeration`等
- **Spring**：`BeanDefinitionRegistry`, `ResourcePatternResolver`等
- **Spring Boot**：`ApplicationContext`, `Environment`等

迭代器模式适用于当需要访问一个容器对象中的各个元素，而不需要暴露该对象的内部表示时。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。