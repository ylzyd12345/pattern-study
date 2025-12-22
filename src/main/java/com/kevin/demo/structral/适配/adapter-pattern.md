# 适配器模式（Adapter Pattern）

## 1. 模式概述
适配器模式是一种结构型设计模式，它将一个类的接口转换成客户希望的另一个接口。适配器模式让那些接口不兼容的类可以一起工作。

### 1.1 核心意图
- 将一个类的接口转换成客户期望的另一个接口
- 解决接口不兼容问题，使原本因接口不匹配而无法一起工作的类能够协同工作
- 实现客户端和被适配者之间的解耦

### 1.2 典型应用场景
- 系统需要使用现有的类，但这些类的接口不符合系统的需要
- 希望建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的类一起工作
- 需要一个统一的输出接口，而输入端的类型不可预知

## 2. 模式结构

### 2.1 角色定义

| 角色 | 职责 | 实现类 |
|------|------|--------|
| **目标接口(Target)** | 定义客户端期望的接口 | ComputerPower |
| **被适配者(Adaptee)** | 定义一个已存在的接口，这个接口需要被适配 | CommonPower |
| **适配器(Adapter)** | 实现目标接口，并持有被适配者的引用，将被适配者的接口转换为目标接口 | ThinkPadPower |
| **客户端(Client)** | 使用目标接口与适配器进行交互 | App |

### 2.2 结构示意图

```
┌──────────────────┐        ┌──────────────────┐
│  Target          │        │  Adapter         │
├──────────────────┤        ├──────────────────┤
│ +request()       │        │ +request()       │
└─────────────┬────┘        └─────────────┬────┘
              │                           │
┌─────────────┴────┐            ┌─────────┴─────────┐
│ Client           │            │ Adaptee           │
├──────────────────┤            ├──────────────────┤
│ +useTarget()     │            │ +specificRequest()│
└──────────────────┘            └──────────────────┘
```

## 3. 实现示例

### 3.1 目标接口
```java
public interface ComputerPower {
    int getPower();
}
```

### 3.2 被适配者
```java
public class CommonPower {
    public int getPower() {
        return 220;
    }
}
```

### 3.3 适配器
```java
public class ThinkPadPower implements ComputerPower {
    private CommonPower commonPower;
    
    public ThinkPadPower(CommonPower commonPower) {
        this.commonPower = commonPower;
    }
    
    @Override
    public int getPower() {
        return (commonPower.getPower() / Integer.valueOf(100));
    }
}
```

### 3.4 客户端代码
```java
public class App {
    public static void main(String[] args) {
        CommonPower commonPower = new CommonPower();
        ComputerPower computerPower = new ThinkPadPower(commonPower);
        System.out.println("电脑获得的电压：" + computerPower.getPower() + "V");
    }
}
```

## 4. 优缺点分析

### 4.1 优点
- **兼容性**：可以让原本不兼容的接口协同工作
- **复用性**：可以复用现有的类，无需修改其源代码
- **灵活性**：可以在不修改现有代码的情况下扩展系统功能
- **解耦性**：客户端与被适配者解耦，提高了代码的可维护性

### 4.2 缺点
- **增加了系统的复杂性**：需要额外的适配器类
- **降低了代码的可读性**：过多的适配器可能会导致代码结构混乱

## 5. 标准化规范

### 5.1 命名规范
- 目标接口：通常以接口功能命名
- 被适配者：以现有实现类的名称命名
- 适配器：通常以"Adapter"结尾，或包含被适配者和目标接口的名称

### 5.2 代码规范
- 适配器应实现目标接口
- 适配器应持有被适配者的引用
- 适配器应将目标接口的方法转换为被适配者的方法调用
- 客户端应只与目标接口交互

### 5.3 最佳实践
- 当需要使用现有的类，但接口不符合需求时使用适配器模式
- 优先使用对象适配器（组合方式）而不是类适配器（继承方式）
- 适配器应保持简单，只负责接口转换

## 6. 与其他模式的比较

### 6.1 适配器模式 vs 外观模式
- 适配器模式：将一个接口转换为另一个接口，使不兼容的类可以一起工作
- 外观模式：为子系统提供一个统一的接口，简化客户端的使用

### 6.2 适配器模式 vs 桥接模式
- 适配器模式：用于连接已经存在的接口
- 桥接模式：用于分离抽象和实现，使它们可以独立变化

### 6.3 适配器模式 vs 代理模式
- 适配器模式：改变接口的形式
- 代理模式：保留原始接口，增加额外的功能

## 7. 权威开源框架中的使用场景

### 7.1 JDK中的适配器模式

1. **字节流与字符流的适配**：
   - 将字节流转换为字符流，实现不同I/O流之间的适配
   - 示例：`java.io.InputStreamReader`和`java.io.OutputStreamWriter`
   - `InputStreamReader`将`InputStream`（字节流）适配为`Reader`（字符流）

2. **数组与集合的适配**：
   - 将数组转换为集合接口，使数组可以使用集合的方法
   - 示例：`java.util.Arrays.asList()`方法
   - 返回一个基于数组的`List`视图

3. **Enumeration与Iterator的适配**：
   - 将旧的`Enumeration`接口适配为新的`Iterator`接口
   - 示例：`java.util.Collections.list()`和`java.util.Collections.enumeration()`方法

4. **Swing组件适配**：
   - 为不同的Swing组件提供统一的接口
   - 示例：`javax.swing.table.TableModel`和`javax.swing.ListModel`的适配器

### 7.2 Spring中的适配器模式

1. **Spring MVC的HandlerAdapter**：
   - 适配不同类型的处理器（Controller），使它们可以统一处理请求
   - 示例：`SimpleControllerHandlerAdapter`、`RequestMappingHandlerAdapter`等
   - 相关类：`org.springframework.web.servlet.HandlerAdapter`接口

2. **Spring AOP的AdvisorAdapter**：
   - 适配不同类型的Advisor，使它们可以统一被AOP框架使用
   - 示例：`MethodBeforeAdviceAdapter`、`AfterReturningAdviceAdapter`等
   - 相关类：`org.springframework.aop.framework.adapter.AdvisorAdapter`接口

3. **Spring JPA的JpaVendorAdapter**：
   - 适配不同的JPA实现厂商（如Hibernate、EclipseLink）
   - 示例：`HibernateJpaVendorAdapter`、`EclipseLinkJpaVendorAdapter`等
   - 相关类：`org.springframework.orm.jpa.JpaVendorAdapter`接口

4. **Spring的WebMvcConfigurerAdapter**：
   - 为`WebMvcConfigurer`接口提供默认实现，方便用户扩展
   - 虽然在Spring 5中已被`@Configuration`和直接实现接口替代，但体现了适配器模式思想

### 7.3 Spring Boot中的适配器模式

1. **Spring Boot的PropertySourceLoader**：
   - 适配不同格式的配置文件（如properties、yaml）
   - 示例：`PropertiesPropertySourceLoader`、`YamlPropertySourceLoader`等
   - 相关类：`org.springframework.boot.env.PropertySourceLoader`接口

2. **Spring Boot的ApplicationRunner和CommandLineRunner**：
   - 适配不同类型的应用启动后执行逻辑
   - 示例：`ApplicationRunner`和`CommandLineRunner`接口的实现类
   - 相关类：`org.springframework.boot.ApplicationRunner`接口

3. **Spring Boot的WebServerFactoryCustomizer**：
   - 适配不同的Web服务器工厂（如Tomcat、Jetty）
   - 示例：`TomcatWebServerFactoryCustomizer`、`JettyWebServerFactoryCustomizer`等
   - 相关类：`org.springframework.boot.web.server.WebServerFactoryCustomizer`接口

4. **Spring Boot的DataSourceInitializer**：
   - 适配不同的数据源，执行初始化脚本
   - 示例：对不同数据库执行SQL脚本
   - 相关类：`org.springframework.boot.jdbc.DataSourceInitializer`类

## 8. 总结

适配器模式是一种强大的结构型设计模式，它可以解决接口不兼容的问题，使原本无法一起工作的类能够协同工作。在系统集成和代码复用场景中，适配器模式是一个理想的选择。

使用适配器模式时，需要明确目标接口、被适配者和适配器的关系，并根据实际情况选择合适的适配器实现方式。遵循标准化的命名和代码规范，可以使适配器模式的实现更加清晰和易于理解。

在权威开源框架如JDK、Spring和Spring Boot中，适配器模式得到了广泛应用，体现了其在解决接口兼容性问题和实现系统集成方面的重要价值。