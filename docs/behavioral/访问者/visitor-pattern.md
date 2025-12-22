# 访问者模式（Visitor Pattern）

## 1. 模式概述

访问者模式是一种行为型设计模式，它允许在不修改现有类的情况下，向一个类添加新的操作。访问者模式将算法与数据结构分离，使得算法可以独立于数据结构变化。访问者模式通常用于处理复杂的对象结构，如组合模式中的对象结构。

### 1.1 核心意图
- 允许在不修改现有类的情况下，向一个类添加新的操作
- 将算法与数据结构分离
- 使得算法可以独立于数据结构变化

### 1.2 解决的问题
当需要在不修改现有类的情况下，向一个类添加新的操作，或者需要处理复杂的对象结构时，访问者模式提供了一种有效的解决方案。它将算法与数据结构分离，使得算法可以独立于数据结构变化，提高了代码的可维护性和可扩展性。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 抽象访问者（Visitor） | 定义了一个访问操作，用于访问不同类型的元素 | Visitor接口 |
| 具体访问者（ConcreteVisitor） | 实现了抽象访问者的接口，提供了具体的访问操作 | ConcreteVisitor类 |
| 抽象元素（Element） | 定义了一个接受访问者的接口 | Element接口 |
| 具体元素（ConcreteElement） | 实现了抽象元素的接口，提供了具体的接受访问者的操作 | ConcreteElement类 |
| 对象结构（ObjectStructure） | 维护一组元素，并提供了一个遍历元素的接口 | ObjectStructure类 |
| 客户端（Client） | 创建访问者和对象结构，并调用访问者的访问操作 | Client类 |

### 2.2 结构示意图

```
┌─────────────┐      ┌─────────────┐
│ Visitor     │      │ Element     │
└─────┬───────┘      └────────┬────┘
      │                       │
      │                       │
      │                       │
┌─────▼───────┐      ┌────────▼────┐
│ ConcreteVisitor │      │ ConcreteElement │
└─────────────┘      └─────────────┘
            │
┌───────────▼───────────┐
│ ObjectStructure       │
└───────────────────────┘
```

## 3. 实现示例

### 3.1 抽象访问者接口

```java
package com.kevin.demo.behavioral.访问者;

/**
 * 抽象访问者接口
 */
public interface Visitor {
    /**
     * 访问商品元素
     */
    void visit(GoodsElement goods);
    
    /**
     * 访问服务元素
     */
    void visit(ServiceElement service);
}
```

### 3.2 具体访问者类

```java
package com.kevin.demo.behavioral.访问者;

/**
 * 具体访问者类 - 计算价格访问者
 */
public class PriceVisitor implements Visitor {
    private double totalPrice = 0;
    
    @Override
    public void visit(GoodsElement goods) {
        double price = goods.getPrice();
        System.out.println("商品: " + goods.getName() + "，价格: " + price);
        totalPrice += price;
    }
    
    @Override
    public void visit(ServiceElement service) {
        double price = service.getPrice();
        System.out.println("服务: " + service.getName() + "，价格: " + price);
        totalPrice += price;
    }
    
    /**
     * 获取总价格
     */
    public double getTotalPrice() {
        return totalPrice;
    }
}
```

```java
package com.kevin.demo.behavioral.访问者;

/**
 * 具体访问者类 - 计算折扣访问者
 */
public class DiscountVisitor implements Visitor {
    private double totalDiscount = 0;
    
    @Override
    public void visit(GoodsElement goods) {
        double discount = goods.getPrice() * 0.1;
        System.out.println("商品: " + goods.getName() + "，折扣: " + discount);
        totalDiscount += discount;
    }
    
    @Override
    public void visit(ServiceElement service) {
        double discount = service.getPrice() * 0.05;
        System.out.println("服务: " + service.getName() + "，折扣: " + discount);
        totalDiscount += discount;
    }
    
    /**
     * 获取总折扣
     */
    public double getTotalDiscount() {
        return totalDiscount;
    }
}
```

### 3.3 抽象元素接口

```java
package com.kevin.demo.behavioral.访问者;

/**
 * 抽象元素接口
 */
public interface Element {
    /**
     * 接受访问者
     */
    void accept(Visitor visitor);
}
```

### 3.4 具体元素类

```java
package com.kevin.demo.behavioral.访问者;

/**
 * 具体元素类 - 商品元素
 */
public class GoodsElement implements Element {
    private String name;
    private double price;
    
    public GoodsElement(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    /**
     * 获取商品名称
     */
    public String getName() {
        return name;
    }
    
    /**
     * 获取商品价格
     */
    public double getPrice() {
        return price;
    }
}
```

```java
package com.kevin.demo.behavioral.访问者;

/**
 * 具体元素类 - 服务元素
 */
public class ServiceElement implements Element {
    private String name;
    private double price;
    
    public ServiceElement(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    /**
     * 获取服务名称
     */
    public String getName() {
        return name;
    }
    
    /**
     * 获取服务价格
     */
    public double getPrice() {
        return price;
    }
}
```

### 3.5 对象结构类

```java
package com.kevin.demo.behavioral.访问者;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构类 - 订单
 */
public class Order {
    private List<Element> elements = new ArrayList<>();
    
    /**
     * 添加元素
     */
    public void addElement(Element element) {
        elements.add(element);
    }
    
    /**
     * 移除元素
     */
    public void removeElement(Element element) {
        elements.remove(element);
    }
    
    /**
     * 接受访问者
     */
    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
```

### 3.6 客户端类

```java
package com.kevin.demo.behavioral.访问者;

/**
 * 客户端类
 */
public class App {
    public static void main(String[] args) {
        // 创建订单
        Order order = new Order();
        
        // 添加元素
        order.addElement(new GoodsElement("手机", 5000));
        order.addElement(new GoodsElement("电脑", 10000));
        order.addElement(new ServiceElement("维修", 100));
        order.addElement(new ServiceElement("安装", 50));
        
        // 创建计算价格访问者
        PriceVisitor priceVisitor = new PriceVisitor();
        order.accept(priceVisitor);
        System.out.println("总价格: " + priceVisitor.getTotalPrice());
        
        System.out.println();
        
        // 创建计算折扣访问者
        DiscountVisitor discountVisitor = new DiscountVisitor();
        order.accept(discountVisitor);
        System.out.println("总折扣: " + discountVisitor.getTotalDiscount());
    }
}
```

## 4. 优缺点分析

### 4.1 优点

- **易于扩展**：可以通过添加新的访问者类来扩展功能
- **将算法与数据结构分离**：使得算法可以独立于数据结构变化
- **集中管理相关操作**：将相关的操作集中在一个访问者类中

### 4.2 缺点

- **违反开闭原则**：当添加新的元素类型时，需要修改所有访问者类
- **破坏封装**：访问者可以访问元素的内部状态，破坏了元素的封装性
- **增加复杂性**：访问者模式增加了代码的复杂性

## 5. 适用场景

### 5.1 应用场景

- 当需要在不修改现有类的情况下，向一个类添加新的操作时
- 当需要处理复杂的对象结构时
- 当需要集中管理相关操作时

### 5.2 实际应用

- 编译器的语法树遍历
- 图形界面中的事件处理
- XML文档解析
- 数据库查询优化

## 6. 设计原则

访问者模式遵循以下设计原则：

- **单一职责原则**：每个访问者类只负责一个功能
- **开闭原则**：可以在不修改现有元素类的情况下添加新的访问者类
- **依赖倒置原则**：访问者依赖于元素接口，而不是具体的元素类

## 7. 与其他模式的比较

### 7.1 访问者模式 vs 迭代器模式

- **访问者模式**：用于访问元素的内部状态并执行操作
- **迭代器模式**：用于遍历元素，不访问元素的内部状态

### 7.2 访问者模式 vs 策略模式

- **访问者模式**：用于访问元素的内部状态并执行操作
- **策略模式**：用于定义算法族

### 7.3 访问者模式 vs 模板方法模式

- **访问者模式**：用于访问元素的内部状态并执行操作
- **模板方法模式**：用于定义算法的骨架

## 8. 权威开源框架中的使用场景

### 8.1 JDK中的访问者模式

1. **java.nio.file.FileVisitor**：
   - 使用访问者模式遍历文件系统
   - 示例：`Files.walkFileTree(path, new MyFileVisitor())`
   - 相关类：`java.nio.file.FileVisitor`接口

2. **javax.lang.model.element.ElementVisitor**：
   - 使用访问者模式遍历Java源代码元素
   - 示例：`element.accept(myElementVisitor, null)`
   - 相关类：`javax.lang.model.element.ElementVisitor`接口

### 8.2 Spring中的访问者模式

1. **Spring的BeanDefinitionVisitor**：
   - 使用访问者模式访问Bean定义
   - 示例：`new BeanDefinitionVisitor(propertyResolver).visitBeanDefinition(beanDefinition)`
   - 相关类：`org.springframework.beans.factory.config.BeanDefinitionVisitor`类

2. **Spring的PropertyPlaceholderHelper**：
   - 使用访问者模式处理属性占位符
   - 示例：`propertyPlaceholderHelper.replacePlaceholders(value, properties)`
   - 相关类：`org.springframework.util.PropertyPlaceholderHelper`类

### 8.3 Spring Boot中的访问者模式

1. **Spring Boot的ConditionEvaluator**：
   - 使用访问者模式评估条件
   - 示例：`conditionEvaluator.shouldSkip(metadata, phase)`
   - 相关类：`org.springframework.boot.autoconfigure.condition.ConditionEvaluator`类

2. **Spring Boot的ConfigurationClassParser**：
   - 使用访问者模式解析配置类
   - 示例：`configurationClassParser.parse(metadataReader)`
   - 相关类：`org.springframework.boot.context.annotation.ConfigurationClassParser`类

## 9. 总结

访问者模式是一种行为型设计模式，它允许在不修改现有类的情况下，向一个类添加新的操作。访问者模式将算法与数据结构分离，使得算法可以独立于数据结构变化。访问者模式通常用于处理复杂的对象结构，如组合模式中的对象结构。

在权威开源框架中，访问者模式也有大量应用：

- **JDK**：`FileVisitor`, `ElementVisitor`等
- **Spring**：`BeanDefinitionVisitor`, `PropertyPlaceholderHelper`等
- **Spring Boot**：`ConditionEvaluator`, `ConfigurationClassParser`等

访问者模式适用于当需要在不修改现有类的情况下，向一个类添加新的操作，或者需要处理复杂的对象结构时。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。