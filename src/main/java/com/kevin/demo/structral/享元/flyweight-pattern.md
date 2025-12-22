# 享元模式（Flyweight Pattern）

## 1. 模式概述
享元模式是一种结构型设计模式，它通过共享相同或相似的对象来减少内存使用和提高性能。这种模式特别适用于需要创建大量细粒度对象的场景。

### 1.1 核心意图
- 运用共享技术有效地支持大量细粒度对象的复用
- 减少对象的创建数量，降低内存占用，提高系统性能
- 区分内部状态和外部状态，实现对象的共享

### 1.2 典型应用场景
- 系统中存在大量相似对象，这些对象消耗大量内存
- 对象的大部分状态可以外部化，可以将这些外部状态传入对象中
- 需要缓冲池的场景

## 2. 模式结构

### 2.1 角色定义

| 角色 | 职责 | 实现类 |
|------|------|--------|
| **抽象享元角色(Flyweight)** | 定义享元对象的公共接口，包含非共享的外部状态参数 | Shape |
| **具体享元角色(ConcreteFlyweight)** | 实现抽象享元接口，包含内部状态，这些状态可以被共享 | CircleShape |
| **享元工厂角色(FlyweightFactory)** | 负责创建和管理享元对象，确保享元对象的合理共享 | ShapeFactory |
| **客户端角色(Client)** | 使用享元工厂获取享元对象，并为享元对象设置外部状态 | App |

### 2.2 结构示意图

```
┌──────────────────┐        ┌──────────────────┐
│  Flyweight       │        │  FlyweightFactory │
├──────────────────┤        ├──────────────────┤
│ +operation()     │        │ +getFlyweight()  │
└─────────────┬────┘        └─────────────┬────┘
              │                           │
┌─────────────┴────┐            ┌─────────┴─────────┐
│ ConcreteFlyweight│            │ FlyweightPool      │
├──────────────────┤            ├──────────────────┤
│ +operation()     │            │                   │
└──────────────────┘            └──────────────────┘
```

## 3. 实现示例

### 3.1 抽象享元角色
```java
public interface Shape {
    void drow();
}
```

### 3.2 具体享元角色
```java
public class CircleShape implements Shape {
    private String color; // 内部状态，可共享
    
    @Override
    public void drow() {
        System.out.println("drow a " + color + " circle");
    }
    
    // getter and setter for color
}
```

### 3.3 享元工厂角色
```java
public class ShapeFactory {
    private static Map<String, Shape> shapeMap = new HashMap<>();
    
    public static Shape getShape(String color) {
        if (null == shapeMap.get(color)) {
            CircleShape circleShape = new CircleShape();
            circleShape.setColor(color);
            shapeMap.put(color, circleShape);
        }
        return shapeMap.get(color);
    }
}
```

### 3.4 客户端代码
```java
public class App {
    public static void main(String[] args) {
        Shape redCircle = ShapeFactory.getShape("red");
        redCircle.drow();
        
        redCircle = ShapeFactory.getShape("red"); // 复用已有的红色圆形
        redCircle.drow();
        
        Shape yellowCircle = ShapeFactory.getShape("yellow");
        yellowCircle.drow();
    }
}
```

## 4. 优缺点分析

### 4.1 优点
- **减少内存占用**：通过共享对象减少了内存中对象的数量
- **提高性能**：减少了对象的创建时间，提高了系统性能
- **灵活扩展**：可以通过添加新的具体享元类来扩展系统
- **外部状态独立**：外部状态与内部状态分离，外部状态可以独立变化

### 4.2 缺点
- **增加了系统复杂度**：需要分离内部状态和外部状态，增加了设计难度
- **可能影响性能**：如果外部状态过多，可能会影响系统性能

## 5. 标准化规范

### 5.1 命名规范
- 抽象享元角色：通常以"Flyweight"或业务相关名称命名
- 具体享元角色：以具体实现的业务名称命名
- 享元工厂角色：通常以"Factory"结尾，如"FlyweightFactory"

### 5.2 代码规范
- 内部状态应是可共享的，不随环境变化
- 外部状态应是不可共享的，随环境变化
- 享元工厂应提供获取享元对象的方法
- 客户端应通过享元工厂获取享元对象

### 5.3 最佳实践
- 当系统中存在大量相似对象时使用享元模式
- 合理划分内部状态和外部状态
- 使用工厂类管理享元对象的创建和共享

## 6. 与其他模式的比较

### 6.1 享元模式 vs 单例模式
- 享元模式：共享多个对象，每个对象可以有不同的内部状态
- 单例模式：只创建一个对象，全局共享

### 6.2 享元模式 vs 原型模式
- 享元模式：通过共享现有对象来减少创建新对象
- 原型模式：通过复制现有对象来创建新对象

### 6.3 享元模式 vs 池化技术
- 享元模式：关注对象的共享和复用
- 池化技术：关注对象的创建和销毁管理

## 7. 权威开源框架中的使用场景

### 7.1 JDK中的享元模式

1. **字符串常量池**：
   - 共享相同的字符串对象，减少内存占用
   - 示例：`String s1 = "hello"; String s2 = "hello";` 此时s1和s2引用同一个对象
   - 相关类：`java.lang.String`和字符串常量池实现

2. **包装类缓存**：
   - 对常用数值范围的包装类对象进行缓存
   - 示例：`Integer.valueOf(123)`会返回缓存的对象，而不是创建新对象
   - 相关类：`java.lang.Integer`, `java.lang.Boolean`, `java.lang.Character`等

3. **正则表达式**：
   - 缓存编译后的正则表达式模式
   - 示例：`java.util.regex.Pattern`的静态工厂方法

4. **Java集合框架**：
   - 内部使用享元模式优化性能
   - 示例：`java.util.EnumSet`和`java.util.BitSet`的实现

### 7.2 Spring中的享元模式

1. **Spring Bean容器**：
   - 对于单例作用域的Bean，容器会缓存并共享同一个实例
   - 示例：通过`@Bean`或`<bean>`定义的单例Bean
   - 相关类：`org.springframework.beans.factory.support.DefaultSingletonBeanRegistry`

2. **Spring MVC**：
   - 缓存视图对象以提高性能
   - 示例：`InternalResourceViewResolver`对视图的缓存
   - 相关类：`org.springframework.web.servlet.view.AbstractCachingViewResolver`

3. **Spring AOP**：
   - 缓存切面表达式和代理对象
   - 示例：`Pointcut`表达式的编译结果缓存
   - 相关类：`org.springframework.aop.aspectj.AspectJExpressionPointcut`

### 7.3 Spring Boot中的享元模式

1. **自动配置类缓存**：
   - 缓存已加载的自动配置类
   - 示例：`SpringApplication`对自动配置类的管理
   - 相关类：`org.springframework.boot.autoconfigure.AutoConfigurationImportSelector`

2. **条件评估缓存**：
   - 缓存条件注解的评估结果
   - 示例：`@Conditional`系列注解的实现
   - 相关类：`org.springframework.boot.autoconfigure.condition.ConditionEvaluator`

3. **日志配置**：
   - 共享日志配置对象
   - 示例：`SpringBootLoggingSystem`的实现

## 8. 总结

享元模式是一种高效的结构型设计模式，它通过共享相同或相似的对象来减少内存使用和提高性能。在系统中存在大量相似对象的场景下，享元模式是一个理想的选择。

使用享元模式时，需要正确划分内部状态和外部状态，并通过享元工厂来管理享元对象的创建和共享。遵循标准化的命名和代码规范，可以使享元模式的实现更加清晰和易于理解。

在权威开源框架如JDK、Spring和Spring Boot中，享元模式得到了广泛应用，体现了其在优化内存使用和提高系统性能方面的重要价值。