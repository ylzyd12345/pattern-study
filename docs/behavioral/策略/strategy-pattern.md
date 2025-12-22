# 策略模式（Strategy Pattern）

## 1. 模式概述

策略模式是一种行为型设计模式，它定义了一系列算法，并将每个算法封装起来，使它们可以相互替换。策略模式允许算法独立于使用它的客户而变化。策略模式是基于组合的设计模式，它将算法封装在策略类中，客户端可以根据需要选择不同的策略。

### 1.1 核心意图
- 定义一系列算法
- 将每个算法封装起来
- 使它们可以相互替换
- 允许算法独立于使用它的客户而变化

### 1.2 解决的问题
当需要在运行时根据不同的情况选择不同的算法时，策略模式提供了一种有效的解决方案。它将算法封装在不同的策略类中，客户端可以根据需要选择不同的策略，避免了使用大量的条件判断语句，提高了代码的可维护性和可扩展性。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 策略接口（Strategy） | 定义了算法的接口 | Strategy接口 |
| 具体策略类（ConcreteStrategy） | 实现了算法的接口 | ConcreteStrategy类 |
| 环境类（Context） | 使用策略对象 | Context类 |
| 客户端（Client） | 创建策略对象并传递给环境类 | Client类 |

### 2.2 结构示意图

```
┌───────────┐      ┌───────────────┐
│ Context   │      │ Strategy      │
└─────┬─────┘      └────────┬──────┘
      │                     │
      │                     │
      │                     │
┌─────▼─────┐      ┌────────▼──────┐
│ Client    │      │ ConcreteStrategy │
└───────────┘      └────────────────┘
```

## 3. 实现示例

### 3.1 策略接口

```java
package com.kevin.demo.behavioral.策略;

/**
 * 策略接口 - 积分计算策略
 */
public interface PointCalc {
    /**
     * 计算积分
     */
    int calculatePoints(double amount);
}
```

### 3.2 具体策略类

```java
package com.kevin.demo.behavioral.策略;

/**
 * 具体策略类 - 基础积分计算策略
 */
public class BasePointCalc implements PointCalc {
    @Override
    public int calculatePoints(double amount) {
        // 基础积分计算：每消费1元积1分
        return (int) amount;
    }
}
```

```java
package com.kevin.demo.behavioral.策略;

/**
 * 具体策略类 - 固定积分计算策略
 */
public class ConstantPointCalc implements PointCalc {
    @Override
    public int calculatePoints(double amount) {
        // 固定积分计算：每笔订单固定积50分
        return 50;
    }
}
```

```java
package com.kevin.demo.behavioral.策略;

/**
 * 具体策略类 - 满减积分计算策略
 */
public class FullGivePointCalc implements PointCalc {
    @Override
    public int calculatePoints(double amount) {
        // 满减积分计算：每消费100元积200分
        return (int) (amount / 100) * 200;
    }
}
```

### 3.3 环境类

```java
package com.kevin.demo.behavioral.策略;

/**
 * 环境类 - 积分赠送服务实现
 */
public class PointGiveServiceImpl implements PointGiveService {
    private PointCalc pointCalc;
    
    public PointGiveServiceImpl(PointCalc pointCalc) {
        this.pointCalc = pointCalc;
    }
    
    @Override
    public int givePoints(double amount) {
        // 使用策略对象计算积分
        return pointCalc.calculatePoints(amount);
    }
    
    /**
     * 设置积分计算策略
     */
    public void setPointCalc(PointCalc pointCalc) {
        this.pointCalc = pointCalc;
    }
}
```

### 3.4 客户端类

```java
package com.kevin.demo.behavioral.策略;

/**
 * 客户端类
 */
public class App {
    public static void main(String[] args) {
        // 创建积分计算策略
        PointCalc basePointCalc = new BasePointCalc();
        PointCalc constantPointCalc = new ConstantPointCalc();
        PointCalc fullGivePointCalc = new FullGivePointCalc();
        
        // 创建积分赠送服务
        PointGiveServiceImpl pointGiveService = new PointGiveServiceImpl(basePointCalc);
        
        // 使用基础积分计算策略
        int points1 = pointGiveService.givePoints(100);
        System.out.println("使用基础积分计算策略：消费100元，获得" + points1 + "积分");
        
        // 切换到固定积分计算策略
        pointGiveService.setPointCalc(constantPointCalc);
        int points2 = pointGiveService.givePoints(100);
        System.out.println("使用固定积分计算策略：消费100元，获得" + points2 + "积分");
        
        // 切换到满减积分计算策略
        pointGiveService.setPointCalc(fullGivePointCalc);
        int points3 = pointGiveService.givePoints(100);
        System.out.println("使用满减积分计算策略：消费100元，获得" + points3 + "积分");
    }
}
```

## 4. 优缺点分析

### 4.1 优点

- **避免条件判断**：避免了使用大量的条件判断语句
- **提高可维护性**：将算法封装在不同的策略类中，易于维护
- **提高可扩展性**：可以通过添加新的策略类来扩展算法
- **符合开闭原则**：可以在不修改现有代码的情况下添加新的策略
- **提高代码复用性**：策略类可以在不同的环境中复用

### 4.2 缺点

- **增加了系统的复杂度**：需要多个类来实现策略模式
- **客户端需要了解所有策略**：客户端需要知道所有的策略类
- **策略类过多**：如果策略过多，可能会导致类的数量过多

## 5. 适用场景

### 5.1 应用场景

- 当需要在运行时根据不同的情况选择不同的算法时
- 当需要避免使用大量的条件判断语句时
- 当需要提高代码的可维护性和可扩展性时

### 5.2 实际应用

- 排序算法
- 搜索算法
- 支付方式
- 优惠策略
- 日志级别

## 6. 设计原则

策略模式遵循以下设计原则：

- **单一职责原则**：每个策略类只负责一个算法
- **开闭原则**：可以在不修改现有代码的情况下添加新的策略
- **依赖倒置原则**：客户端依赖于策略接口，而不是具体的策略类

## 7. 与其他模式的比较

### 7.1 策略模式 vs 状态模式

- **策略模式**：策略是客户端主动选择的，策略之间是平等的
- **状态模式**：状态是对象内部的，状态转换由对象内部触发

### 7.2 策略模式 vs 模板模式

- **策略模式**：基于组合，算法的实现是独立的
- **模板模式**：基于继承，算法的骨架在父类中定义

### 7.3 策略模式 vs 工厂方法模式

- **策略模式**：关注算法的选择和使用
- **工厂方法模式**：关注对象的创建

## 8. 权威开源框架中的使用场景

### 8.1 JDK中的策略模式

1. **java.util.Comparator**：
   - 使用策略模式定义排序算法
   - 示例：`Collections.sort(list, new Comparator() { ... })`
   - 相关类：`java.util.Comparator`接口

2. **java.util.concurrent.Executor**：
   - 使用策略模式定义任务执行策略
   - 示例：`ExecutorService executor = Executors.newFixedThreadPool(10);`
   - 相关类：`java.util.concurrent.Executor`接口

3. **java.nio.charset.Charset**：
   - 使用策略模式定义字符集编码策略
   - 示例：`Charset charset = Charset.forName("UTF-8");`
   - 相关类：`java.nio.charset.Charset`类

### 8.2 Spring中的策略模式

1. **Spring的ResourceLoader**：
   - 使用策略模式定义资源加载策略
   - 示例：`ResourceLoader resourceLoader = new DefaultResourceLoader();`
   - 相关类：`org.springframework.core.io.ResourceLoader`接口

2. **Spring的ConversionService**：
   - 使用策略模式定义类型转换策略
   - 示例：`ConversionService conversionService = new DefaultConversionService();`
   - 相关类：`org.springframework.core.convert.ConversionService`接口

3. **Spring的TaskScheduler**：
   - 使用策略模式定义任务调度策略
   - 示例：`TaskScheduler taskScheduler = new ThreadPoolTaskScheduler();`
   - 相关类：`org.springframework.scheduling.TaskScheduler`接口

### 8.3 Spring Boot中的策略模式

1. **Spring Boot的PropertySourceLoader**：
   - 使用策略模式定义属性源加载策略
   - 示例：`PropertySourceLoader propertySourceLoader = new PropertiesPropertySourceLoader();`
   - 相关类：`org.springframework.boot.env.PropertySourceLoader`接口

2. **Spring Boot的ApplicationListener**：
   - 使用策略模式定义应用程序事件监听策略
   - 示例：`@EventListener public void handleContextRefreshedEvent(ContextRefreshedEvent event) { ... }`
   - 相关类：`org.springframework.context.ApplicationListener`接口

3. **Spring Boot的HealthIndicator**：
   - 使用策略模式定义健康检查策略
   - 示例：`@Bean public HealthIndicator dbHealthIndicator() { ... }`
   - 相关类：`org.springframework.boot.actuate.health.HealthIndicator`接口

## 9. 总结

策略模式是一种行为型设计模式，它定义了一系列算法，并将每个算法封装起来，使它们可以相互替换。策略模式允许算法独立于使用它的客户而变化。策略模式是基于组合的设计模式，它将算法封装在策略类中，客户端可以根据需要选择不同的策略。

在权威开源框架中，策略模式也有大量应用：

- **JDK**：`Comparator`, `Executor`, `Charset`等
- **Spring**：`ResourceLoader`, `ConversionService`, `TaskScheduler`等
- **Spring Boot**：`PropertySourceLoader`, `ApplicationListener`, `HealthIndicator`等

策略模式适用于当需要在运行时根据不同的情况选择不同的算法时。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。