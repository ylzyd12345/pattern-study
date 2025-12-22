# 建造者模式（Builder Pattern）

## 1. 模式概述

建造者模式是一种创建型设计模式，它允许分步构建复杂对象。建造者模式将对象的构建过程与其表示分离，使得同样的构建过程可以创建不同的表示。

### 1.1 核心意图
- 将一个复杂对象的构建与其表示分离
- 使得同样的构建过程可以创建不同的表示
- 允许分步构建复杂对象

### 1.2 解决的问题
当需要创建一个包含多个部件的复杂对象时，建造者模式提供了一种有效的解决方案。它允许通过分步构建的方式创建复杂对象，同时隐藏了对象的内部结构和构建细节。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 产品（Product） | 表示被构建的复杂对象 | Product类 |
| 抽象建造者（Builder） | 定义了构建产品的接口 | Builder接口 |
| 具体建造者（ConcreteBuilder） | 实现了构建产品的方法 | ConcreteBuilder类 |
| 指挥者（Director） | 控制构建过程 | Director类 |

### 2.2 结构示意图

```
┌───────────┐      ┌───────────────┐
│ Director  │      │ Builder       │
└─────┬─────┘      └────────┬──────┘
      │                     │
      │                     │
      │                     │
┌─────▼─────┐      ┌────────▼──────┐
│ Product   │      │ ConcreteBuilder │
└───────────┘      └────────────────┘
```

## 3. 实现示例

### 3.1 产品类

```java
package com.kevin.demo.creational.建造者;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品类
 */
public class Product {
    private List<String> parts = new ArrayList<>();

    public void addPart(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println("产品部件：");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
```

### 3.2 抽象建造者接口

```java
package com.kevin.demo.creational.建造者;

/**
 * 抽象建造者接口
 */
public interface Builder {
    void buildPartA();
    void buildPartB();
    Product getResult();
}
```

### 3.3 具体建造者类

```java
package com.kevin.demo.creational.建造者;

/**
 * 具体建造者类
 */
public class ConcreteBuilder implements Builder {
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.addPart("部件A");
    }

    @Override
    public void buildPartB() {
        product.addPart("部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
```

### 3.4 指挥者类

```java
package com.kevin.demo.creational.建造者;

/**
 * 指挥者类
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPartA();
        builder.buildPartB();
    }
}
```

### 3.5 客户端类

```java
package com.kevin.demo.creational.建造者;

/**
 * 客户端类
 */
public class App {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.getResult();
        product.show();
    }
}
```

## 4. 优缺点分析

### 4.1 优点

- **封装性好**：隐藏了产品的内部结构和构建细节
- **可扩展性好**：可以通过添加新的具体建造者来创建不同的产品
- **分步构建**：允许分步构建复杂对象
- **产品多样性**：同样的构建过程可以创建不同的产品

### 4.2 缺点

- **增加了系统的复杂度**：需要多个类来实现建造者模式
- **产品必须有共同点**：建造者模式适用于产品具有共同的构建步骤
- **产品之间的差异不能太大**：如果产品之间的差异太大，建造者模式可能不适用

## 5. 适用场景

### 5.1 应用场景

- 当需要创建一个包含多个部件的复杂对象时
- 当需要分步构建复杂对象时
- 当需要创建不同表示的对象，但构建过程相同时

### 5.2 实际应用

- 文档生成器
- 配置文件生成器
- UI组件构建器
- 数据库查询构建器

## 6. 设计原则

建造者模式遵循以下设计原则：

- **单一职责原则**：每个建造者类只负责构建一个产品
- **开闭原则**：可以在不修改现有代码的情况下添加新的建造者
- **封装原则**：隐藏了产品的内部结构和构建细节

## 7. 与其他模式的比较

### 7.1 建造者模式 vs 工厂方法模式

- **建造者模式**：关注产品的构建过程
- **工厂方法模式**：关注产品的创建

### 7.2 建造者模式 vs 抽象工厂模式

- **建造者模式**：创建一个产品的多个部件
- **抽象工厂模式**：创建多个相关产品

### 7.3 建造者模式 vs 原型模式

- **建造者模式**：通过分步构建创建新对象
- **原型模式**：通过复制现有对象创建新对象

## 8. 权威开源框架中的使用场景

### 8.1 JDK中的建造者模式

1. **StringBuilder和StringBuffer**：
   - 使用建造者模式构建字符串
   - 示例：`new StringBuilder().append("Hello").append(" ").append("World").toString()`
   - 相关类：`java.lang.StringBuilder`、`java.lang.StringBuffer`类

2. **DocumentBuilder**：
   - 使用建造者模式构建XML文档
   - 示例：`DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile)`
   - 相关类：`javax.xml.parsers.DocumentBuilder`接口

3. **Calendar.Builder**：
   - 使用建造者模式构建Calendar实例
   - 示例：`new Calendar.Builder().setDate(2023, 1, 1).build()`
   - 相关类：`java.util.Calendar.Builder`类

### 8.2 Spring中的建造者模式

1. **RestTemplateBuilder**：
   - 使用建造者模式构建RestTemplate实例
   - 示例：`new RestTemplateBuilder().setConnectTimeout(Duration.ofSeconds(5)).build()`
   - 相关类：`org.springframework.boot.web.client.RestTemplateBuilder`类

2. **UriComponentsBuilder**：
   - 使用建造者模式构建URI组件
   - 示例：`UriComponentsBuilder.fromHttpUrl("http://example.com").path("/api").build()`
   - 相关类：`org.springframework.web.util.UriComponentsBuilder`类

3. **MockMvcBuilders**：
   - 使用建造者模式构建MockMvc实例
   - 示例：`MockMvcBuilders.webAppContextSetup(context).build()`
   - 相关类：`org.springframework.test.web.servlet.setup.MockMvcBuilders`类

### 8.3 Spring Boot中的建造者模式

1. **SpringApplicationBuilder**：
   - 使用建造者模式构建SpringApplication实例
   - 示例：`new SpringApplicationBuilder(App.class).bannerMode(Banner.Mode.OFF).build()`
   - 相关类：`org.springframework.boot.builder.SpringApplicationBuilder`类

2. **WebClient.Builder**：
   - 使用建造者模式构建WebClient实例
   - 示例：`WebClient.builder().baseUrl("http://example.com").build()`
   - 相关类：`org.springframework.web.reactive.function.client.WebClient.Builder`接口

3. **HttpClient.Builder**：
   - 使用建造者模式构建HttpClient实例
   - 示例：`HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()`
   - 相关类：`java.net.http.HttpClient.Builder`接口

## 9. 总结

建造者模式是一种创建型设计模式，它允许分步构建复杂对象。建造者模式将对象的构建过程与其表示分离，使得同样的构建过程可以创建不同的表示。

在权威开源框架中，建造者模式也有大量应用：

- **JDK**：`StringBuilder`、`StringBuffer`、`DocumentBuilder`、`Calendar.Builder`等
- **Spring**：`RestTemplateBuilder`、`UriComponentsBuilder`、`MockMvcBuilders`等
- **Spring Boot**：`SpringApplicationBuilder`、`WebClient.Builder`、`HttpClient.Builder`等

建造者模式适用于当需要创建一个包含多个部件的复杂对象，或者需要分步构建复杂对象时。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。