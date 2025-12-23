---
AIGC: {"Label": "1", "ContentProducer": "001191330101MA27WPYJ18xliu", "ProduceID": "69260b21-475f-4c4f-9d7b-d4c79603055b", "ReserveCode1": "iflow", "ContentPropagator": "iflow", "PropagateID": "iflow", "ReserveCode2": "iflow"}
---


# Java设计模式全面学习指南

## 摘要
本指南系统性地介绍了Java设计模式的核心概念、分类体系、具体实现以及实际应用。内容涵盖从面向对象设计原则到23种经典GOF设计模式的详细解析，并提供完整的学习路径和实践建议，帮助开发者从入门到精通掌握设计模式的应用技巧。

---

## 目录
- [1. 设计模式基础概念与面向对象原则](#1-设计模式基础概念与面向对象原则)
- [2. 设计模式分类体系与总体框架](#2-设计模式分类体系与总体框架)
- [3. 创建型设计模式深入解析](#3-创建型设计模式深入解析)
- [4. 结构型设计模式深入解析](#4-结构型设计模式深入解析)
- [5. 行为型设计模式深入解析](#5-行为型设计模式深入解析)
- [6. 设计模式实战应用与现代框架实践](#6-设计模式实战应用与现代框架实践)
- [7. 系统化学习路径与进阶实践指南](#7-系统化学习路径与进阶实践指南)

---

## 1. 设计模式基础概念与面向对象原则

### 1.1 设计模式的定义与起源

设计模式（Design Pattern）是软件工程中解决常见问题的可重用解决方案模板。GoF（Gang of Four）设计模式指由Erich Gamma、Richard Helm、Ralph Johnson和John Vlissides四位专家在《设计模式：可复用面向对象软件的基础》中提出的23种经典模式[^54]。这些模式不是具体的代码实现，而是经过验证的最佳实践方案，能够在特定场景下提供优雅的解决方案。

![GoF设计模式分类](./images/gof_classification.png)
*图1-1：GoF设计模式分类体系*

### 1.2 设计模式的核心价值

设计模式在软件开发中具有五大核心优势[^25]：

1. **提升可维护性**：通过高内聚低耦合的代码结构，使系统更易于理解和修改
2. **增强复用性**：通用解决方案可在不同项目中多次应用，减少重复开发
3. **保障扩展性**：遵循开闭原则，支持需求变化而无需修改现有代码
4. **降低风险**：采用经过验证的成熟方案，避免设计缺陷和潜在问题
5. **促进协作**：提供共享的设计词汇表，改善团队沟通效率

[案例]策略模式与适配器模式的组合应用，能够有效解决奖励系统品类扩展问题，使新增奖励类型无需修改主干代码[^25]。

### 1.3 SOLID设计原则详解

SOLID原则是面向对象设计的五大基本原则，为设计模式的应用提供理论指导：

| 原则 | 定义 | 示例与应用 |
|------|------|------------|
| **单一职责原则(SRP)** | 一个类只应有一个引起变化的原因 | 拆分发票类的打印功能和存储逻辑，避免修改一个功能影响另一个功能[^14] |
| **开闭原则(OCP)** | 对扩展开放，对修改关闭 | 通过Computer接口扩展新系统类型，而不是修改现有系统代码[^16] |
| **里氏替换原则(LSP)** | 子类型必须能够替换它们的基类型 | 正方形不应继承矩形的setWidth/setHeight行为，避免违反数学规律[^14] |
| **接口隔离原则(ISP)** | 客户端不应被迫依赖于它们不使用的接口 | 拆分停车功能与支付接口，避免客户端依赖不需要的功能[^14] |
| **依赖倒置原则(DIP)** | 依赖于抽象而不是具体实现 | 通过Keyboard接口解耦电脑与具体键盘设备的依赖关系[^16] |

![SOLID设计原则](./images/solid_principles_diagram.png)
*图1-2：SOLID面向对象设计原则示意图*

### 1.4 设计模式与SOLID原则的协同关系

设计模式是SOLID原则的具体实现载体，两者之间存在紧密的协同关系[^11]：

**模式实现原则：**
- 策略模式 → 开闭原则：通过策略接口实现算法的可扩展性
- 适配器模式 → 接口隔离原则：为特定客户端提供定制化接口
- 模板方法模式 → 依赖倒置原则：高层模块控制算法骨架，低层模块实现具体步骤

**原则指导模式选择：**
- 需要扩展性时优先考虑OCP兼容模式（如装饰器、策略模式）
- 高耦合场景应用DIP指导的解耦模式（如工厂方法、抽象工厂）
- 接口过于庞大时使用ISP指导的接口拆分（如适配器模式）

[案例]装饰器模式通过层层包装的方式实现功能扩展，完美体现了开闭原则的设计理念[^11]。

### 1.5 设计模式的职业发展价值

掌握设计模式对软件开发人员的职业发展具有重要意义[^35]：

**学习路径建议：**
- **1年内**：掌握23种基础设计模式（推荐《大话设计模式》入门）
- **2-3年**：结合JVM原理、并发编程等深入理解模式的应用场景
- **3-4年**：在分布式系统架构中实践模式组合应用

**职业回报：**
1. **面试核心考察点**：大厂技术面试必考内容，体现设计能力
2. **架构师必备技能**：系统架构设计的基础理论知识
3. **薪资差异关键因素**：高级工程师与普通开发者的重要区分标准

[建议]阿里技术总监强调：工作一年内必须开始设计模式的系统学习，这是技术成长的关键转折点[^35]。

![软件架构职业发展](./images/career_development.png)
*图1-3：设计模式在软件架构职业发展中的重要性*

### 1.6 设计模式的基本设计原则

GoF设计模式基于两个核心设计理念[^54]：
- **对接口编程而非实现**：减少对具体实现的依赖，提高代码灵活性
- **优先使用对象组合而非继承**：通过组合获得更大的灵活性和更简单的层次结构

[示例]工厂模式通过封装对象创建逻辑，实现客户端与具体产品类的解耦，体现了面向接口编程的原则[^59]。

## 2. 设计模式分类体系与总体框架

### 2.1 GOF设计模式三大分类体系

GoF设计模式按照其目的和解决的问题范畴，系统性地分为三大类别：创建型模式、结构型模式和行为型模式[^199]。这种分类方式为软件设计提供了清晰的框架和指导原则。

![GOF设计模式三大分类](./images/gof_three_categories_diagram.png)
*图2-1：GOF设计模式三大分类体系*

#### 2.1.1 创建型模式（Creational Patterns）

**定义与核心思想**
创建型模式专注于对象的创建机制，对类的实例化过程进行抽象，将对象创建和使用分离[^199][^512]。这类模式通过封装复杂的创建逻辑，使系统能够独立于对象创建的具体细节。

**主要特点：**
1. **创建与使用分离**：有效降低模块间耦合度，提高代码的可维护性[^512]
2. **高度灵活性**：动态决定创建哪个类的实例，支持运行时配置[^512]
3. **封装复杂性**：将复杂的对象创建逻辑封装在专门的类中，简化客户端代码[^512]

**包含的具体模式：**
- 工厂方法模式（Factory Method）
- 抽象工厂模式（Abstract Factory）
- 单例模式（Singleton）
- 建造者模式（Builder）
- 原型模式（Prototype）[^199]

![创建型模式示意图](./images/creational_patterns_diagram.png)
*图2-2：创建型设计模式结构示意图*

#### 2.1.2 结构型模式（Structural Patterns）

**定义与核心思想**
结构型模式关注对象之间的组合和依赖关系，描述如何组合类和对象以形成更大的结构[^199][^525]。这类模式通过组合而非继承的方式获得更大的灵活性，帮助构建稳定而可扩展的系统架构。

**主要特点：**
1. **灵活性优势**：组合关系比继承具有更低的耦合度，便于系统演进[^523]
2. **可扩展性强**：通过动态组合对象实现功能的灵活扩展[^527]
3. **解耦效果显著**：有效降低系统各组成部分之间的耦合度，提高模块独立性[^528]

**包含的具体模式：**
- 适配器模式（Adapter）
- 桥接模式（Bridge）
- 组合模式（Composite）
- 装饰者模式（Decorator）
- 外观模式（Facade）
- 享元模式（Flyweight）
- 代理模式（Proxy）[^205]

![结构型模式示意图](./images/structural_patterns_diagram.png)
*图2-3：结构型设计模式结构示意图*

#### 2.1.3 行为型模式（Behavioral Patterns）

**定义与核心思想**
行为型模式专注于类或对象之间的交互和职责分配，对对象间责任和算法进行抽象[^199][^530]。这类模式通过定义对象间的通信机制和协作方式，控制复杂的运行时行为。

**主要特点：**
1. **交互导向**：重点关注对象间的协作关系和通信模式[^530]
2. **动态行为分配**：在运行时确定对象的行为，提供更大的灵活性[^534]
3. **低耦合设计**：减少对象间的直接依赖，提高系统的可维护性[^532]

**包含的具体模式：**
- 模板方法模式（Template Method）
- 策略模式（Strategy）
- 观察者模式（Observer）
- 状态模式（State）
- 责任链模式（Chain of Responsibility）
- 命令模式（Command）
- 访问者模式（Visitor）等11种模式[^199]

![行为型模式示意图](./images/behavioral_patterns_diagram.png)
*图2-4：行为型设计模式结构示意图*

### 2.2 分类体系的应用价值与实践意义

#### 2.2.1 各类模式的核心价值

| 模式类别 | 核心价值 | 典型应用场景 |
|---------|---------|-------------|
| **创建型模式** | 提高系统灵活性，支持对象创建的动态配置 | 需要根据不同条件创建不同对象的场景 |
| **结构型模式** | 增强系统可扩展性，构建稳定的架构基础 | 系统组件需要灵活组合和重用的场景 |
| **行为型模式** | 提高系统可维护性，优化对象间协作机制 | 复杂业务流程和状态管理的场景[^199][^203][^205] |

#### 2.2.2 模式选择的指导原则

1. **问题导向选择**：根据具体要解决的问题类型选择相应的模式类别
   - 对象创建问题 → 创建型模式
   - 对象结构问题 → 结构型模式
   - 对象行为问题 → 行为型模式

2. **组合应用策略**：在实际项目中，往往需要组合使用多种模式
   - 工厂方法 + 策略模式：创建可配置的算法策略
   - 装饰者 + 观察者：为观察者对象动态添加功能
   - 组合 + 访问者：遍历复杂对象结构并执行操作

3. **避免过度设计**：根据实际需求选择模式，避免为了使用模式而增加不必要的复杂性

#### 2.2.3 学习路径建议

对于设计模式的学习者，建议按照以下顺序逐步深入：
1. **先理解三大分类**：建立整体框架认知
2. **掌握每类核心模式**：每类别中选择2-3个最常用的模式深入理解
3. **学习模式组合应用**：了解模式之间的协作关系
4. **实践项目应用**：在真实项目中应用所学模式

[提示]创建型模式中的工厂方法和抽象工厂模式是面试和实际项目中最常使用的模式，建议优先掌握[^512]。

## 3. 创建型设计模式深入解析

### 3.1 创建型模式概述

创建型设计模式专注于对象的创建机制，通过封装对象实例化过程，降低客户端与具体类之间的耦合度[^40][^48]。GoF定义的创建型模式包含五种：**单例模式、原型模式、工厂方法模式、抽象工厂模式和建造者模式**，它们共同构成了软件设计中对象创建的最佳实践体系[^49]。

![创建型设计模式分类比较](./images/creational_patterns_comparison.png)
*图3-1：创建型设计模式分类与特点对比*

### 3.2 单例模式（Singleton Pattern）

#### 3.2.1 问题引入场景
在软件开发中，某些类只需要一个全局实例，如配置管理器、数据库连接池、日志记录器等。如果允许多个实例存在，可能导致资源冲突、数据不一致或性能问题[^551]。

#### 3.2.2 模式结构与原理
单例模式确保一个类仅有一个实例，并提供全局访问点。核心实现要素包括：私有构造方法、静态私有变量和公共静态访问方法[^551]。

![单例模式UML类图](./images/singleton_pattern_uml.png)
*图3-2：单例模式UML类图结构*

#### 3.2.3 Java代码实现详解

**饿汉式实现（Eager Initialization）**
```java
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    
    private HungrySingleton() {
        // 私有构造方法防止外部实例化
    }
    
    public static HungrySingleton getInstance() {
        return instance;
    }
}
```
**优点**：实现简单，线程安全[^551][^556]  
**缺点**：不能懒加载，可能造成资源浪费[^551]

**懒汉式双重检查锁定（Lazy Initialization with Double-Checked Locking）**
```java
public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton instance;
    
    private DoubleCheckSingleton() {}
    
    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized(DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
```
**关键点**：volatile关键字防止指令重排序，确保线程安全[^556]

**静态内部类实现（Static Inner Class）**
```java
public class InnerStaticSingleton {
    private InnerStaticSingleton() {}
    
    private static class SingletonHolder {
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }
    
    public static InnerStaticSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```

**枚举方式实现（Enum Singleton）**
```java
public enum EnumSingleton {
    INSTANCE;
    
    public void doSomething() {
        // 业务方法实现
    }
}
```
**优势**：天然线程安全，防止反序列化创建新对象，实现简洁[^551]

#### 3.2.4 典型应用场景
- 全局配置管理和应用设置
- 数据库连接池和线程池管理
- 日志记录器和缓存服务
- 设备驱动程序和硬件访问控制[^551][^556]

#### 3.2.5 优缺点分析
**优点**：
- 严格控制实例数量，节省系统资源
- 提供全局访问点，方便统一管理
- 避免对共享资源的并发访问冲突[^696]

**缺点**：
- 违反单一职责原则（既管理业务又控制实例化）
- 难以进行单元测试和并行测试
- 可能隐藏类之间的依赖关系，降低代码可维护性[^696]

#### 3.2.6 在Spring框架中的应用
Spring框架通过`DefaultSingletonBeanRegistry`实现单例管理，所有配置为singleton作用域的Bean都由容器保证唯一性，实现了真正的应用级单例[^705]。

### 3.3 工厂方法模式（Factory Method Pattern）

#### 3.3.1 问题引入场景
当系统需要根据不同类型或条件创建不同对象，且创建逻辑可能发生变化时，直接使用new关键字会导致代码耦合度高，难以扩展和维护[^577]。

#### 3.3.2 模式结构与原理
工厂方法模式定义一个创建对象的接口，但让子类决定实例化哪个具体的类，实现了对象创建与使用的分离[^577][^578]。

![工厂方法模式UML类图](./images/factory_method_pattern_uml.png)
*图3-3：工厂方法模式UML类图结构*

#### 3.3.3 Java代码实现详解

**抽象产品与具体产品**
```java
// 抽象产品接口
public interface Message {
    void send();
}

// 具体产品：短信消息
public class SmsMessage implements Message {
    @Override
    public void send() {
        System.out.println("发送短信消息");
    }
}

// 具体产品：邮件消息
public class EmailMessage implements Message {
    @Override
    public void send() {
        System.out.println("发送邮件消息");
    }
}
```

**抽象工厂与具体工厂**
```java
// 抽象工厂接口
public interface MessageFactory {
    Message createMessage();
}

// 具体工厂：短信工厂
public class SmsFactory implements MessageFactory {
    @Override
    public Message createMessage() {
        return new SmsMessage();
    }
}

// 具体工厂：邮件工厂
public class EmailFactory implements MessageFactory {
    @Override
    public Message createMessage() {
        return new EmailMessage();
    }
}
```

**客户端使用**
```java
public class Client {
    public static void main(String[] args) {
        MessageFactory factory = new SmsFactory();
        Message message = factory.createMessage();
        message.send(); // 输出：发送短信消息
    }
}
```

#### 3.3.4 典型应用场景
- 动态扩展产品类型，支持新产品添加
- 封装复杂的对象创建逻辑
- 框架设计（如Hibernate的SessionFactory、Spring的BeanFactory）
- 跨平台应用开发[^576][^583]

#### 3.3.5 优缺点分析
**优点**：
- 解耦对象创建与使用，提高代码灵活性
- 支持开闭原则，便于扩展新产品
- 隐藏具体产品类的实现细节[^696]

**缺点**：
- 增加系统复杂度，类数量增多
- 增加了系统的抽象性和理解难度
- 需要引入额外的工厂层次结构[^696]

#### 3.3.6 与简单工厂模式的区别
工厂方法模式是简单工厂模式的进一步抽象，通过多态机制实现了真正的"开放-关闭"原则，而简单工厂模式虽然简单但违反开闭原则[^695]。

### 3.4 抽象工厂模式（Abstract Factory Pattern）

#### 3.4.1 问题引入场景
当系统需要创建一系列相关或相互依赖的对象，且这些对象属于同一个产品族时，需要确保这些对象能够协同工作。例如，GUI应用程序需要成套的界面组件（按钮、文本框、复选框等）[^540]。

#### 3.4.2 模式结构与原理
抽象工厂模式提供创建相关或相互依赖对象的接口，而无需指定它们的具体类。核心概念是"产品族"——同一具体工厂生产的一组相关产品[^540][^543]。

![抽象工厂模式UML类图](./images/abstract_factory_pattern_uml.png)
*图3-4：抽象工厂模式UML类图结构*

#### 3.4.3 Java代码实现详解

**抽象产品体系**
```java
// 抽象产品：鼠标
public interface Mouse {
    void click();
}

// 抽象产品：键盘
public interface Keyboard {
    void type();
}

// 具体产品：戴尔鼠标
public class DellMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("戴尔鼠标点击");
    }
}

// 具体产品：戴尔键盘
public class DellKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("戴尔键盘输入");
    }
}

// 具体产品：惠普鼠标
public class HpMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("惠普鼠标点击");
    }
}

// 具体产品：惠普键盘
public class HpKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("惠普键盘输入");
    }
}
```

**抽象工厂与具体工厂**
```java
// 抽象工厂
public interface PCFactory {
    Mouse createMouse();
    Keyboard createKeyboard();
}

// 具体工厂：戴尔工厂
public class DellFactory implements PCFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
    
    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}

// 具体工厂：惠普工厂
public class HpFactory implements PCFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
    
    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
```

**客户端使用**
```java
public class Client {
    public static void main(String[] args) {
        PCFactory factory = new DellFactory();
        Mouse mouse = factory.createMouse();
        Keyboard keyboard = factory.createKeyboard();
        
        mouse.click();    // 输出：戴尔鼠标点击
        keyboard.type(); // 输出：戴尔键盘输入
    }
}
```

#### 3.4.4 典型应用场景
- 跨平台UI组件开发（Windows/Mac/Linux界面元素）
- 数据库访问层抽象（支持多种数据库产品）
- 游戏开发中的不同主题场景
- 企业应用中的多套业务流程[^540][^543]

#### 3.4.5 优缺点分析
**优点**：
- 保证产品家族的一致性，相关对象一起使用
- 隔离具体类的实现，客户端只接触接口
- 易于切换整个产品家族[^696]

**缺点**：
- 扩展新产品族困难，需要修改抽象工厂接口
- 增加了系统的抽象性和复杂性
- 支持新产品种类有限制[^696]

#### 3.4.6 产品族概念详解
产品族是指由同一个工厂生产的、在设计和用途上相关联的一组产品。例如戴尔工厂生产戴尔鼠标和戴尔键盘，它们构成一个产品族；惠普工厂生产的产品构成另一个产品族[^540]。

### 3.5 建造者模式（Builder Pattern）

#### 3.5.1 问题引入场景
当需要创建复杂的对象，且对象的构建过程包含多个步骤，或者同一构建过程可以产生不同的表示形式时，使用传统的构造方法会导致代码臃肿且难以维护[^560]。

#### 3.5.2 模式结构与原理
建造者模式将复杂对象的构建过程与其表示分离，使得同样的构建过程可以创建不同的表示。核心角色包括Builder（负责创建产品部件）和Director（管理构建过程）[^560][^561]。

![建造者模式UML类图](./images/builder_pattern_uml.png)
*图3-5：建造者模式UML类图结构*

#### 3.5.3 Java代码实现详解

**产品类**
```java
public class Computer {
    private String cpu;
    private String memory;
    private String hardDisk;
    private String graphicsCard;
    
    // 私有构造方法，通过Builder构建
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.memory = builder.memory;
        this.hardDisk = builder.hardDisk;
        this.graphicsCard = builder.graphicsCard;
    }
    
    // 静态内部Builder类
    public static class Builder {
        private String cpu;
        private String memory;
        private String hardDisk;
        private String graphicsCard;
        
        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        
        public Builder setMemory(String memory) {
            this.memory = memory;
            return this;
        }
        
        public Builder setHardDisk(String hardDisk) {
            this.hardDisk = hardDisk;
            return this;
        }
        
        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }
        
        public Computer build() {
            return new Computer(this);
        }
    }
    
    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                '}';
    }
}
```

**Director角色（可选）**
```java
public class ComputerDirector {
    public Computer constructGamingComputer() {
        return new Computer.Builder()
                .setCpu("Intel i9")
                .setMemory("32GB")
                .setHardDisk("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 3080")
                .build();
    }
    
    public Computer constructOfficeComputer() {
        return new Computer.Builder()
                .setCpu("Intel i5")
                .setMemory("16GB")
                .setHardDisk("512GB SSD")
                .setGraphicsCard("Integrated")
                .build();
    }
}
```

**客户端使用**
```java
public class Client {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();
        
        Computer gamingComputer = director.constructGamingComputer();
        System.out.println("游戏电脑配置: " + gamingComputer);
        
        Computer officeComputer = director.constructOfficeComputer();
        System.out.println("办公电脑配置: " + officeComputer);
        
        // 或者直接使用Builder
        Computer customComputer = new Computer.Builder()
                .setCpu("AMD Ryzen 7")
                .setMemory("64GB")
                .setHardDisk("2TB SSD")
                .build();
        System.out.println("自定义电脑配置: " + customComputer);
    }
}
```

#### 3.5.4 典型应用场景
- 复杂对象的构建，包含多个部件和构建步骤
- 需要创建不同表示形式的对象（如HTML和PDF格式的报告）
- 对象构建过程需要精确控制（如快餐店点餐流程）
- 产品对象的构建算法应该独立于该对象的组成部分[^560][^561]

#### 3.5.5 优缺点分析
**优点**：
- 封装复杂的构建过程，客户端无需知道内部细节
- 可以对构建过程进行更精细的控制
- 相同的构建过程可以创建不同的产品表示
- 符合单一职责原则，将构建逻辑与业务逻辑分离[^696]

**缺点**：
- 产品必须有共同接口，限制了使用范围
- 如果产品内部变化复杂，会导致需要定义很多具体建造者类
- 增加了系统的复杂度和理解难度[^696]

#### 3.5.6 与工厂模式的区别
- **工厂模式**关注"创建什么"对象，侧重于对象的整体创建
- **建造者模式**关注"如何构建"对象，侧重于对象的构建过程和步骤控制[^742][^743]

### 3.6 原型模式（Prototype Pattern）

#### 3.6.1 问题引入场景
当需要创建大量相似对象，且对象创建成本较高（如需要复杂计算、数据库查询或网络请求）时，直接使用new关键字创建对象会导致性能问题。原型模式通过复制现有实例来提高创建效率[^567]。

#### 3.6.2 模式结构与原理
原型模式通过复制现有实例创建新对象，而不是通过new关键字实例化。Java通过Cloneable接口和clone()方法提供原生支持，但需要注意深浅拷贝的区别[^567][^568]。

![原型模式UML类图](./images/prototype_pattern_uml.png)
*图3-6：原型模式UML类图结构*

#### 3.6.3 Java代码实现详解

**浅拷贝实现**
```java
public class Sheep implements Cloneable {
    private String name;
    private int age;
    private Date birthday;
    
    public Sheep(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
    
    // 浅拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    // getter和setter方法
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }
    
    @Override
    public String toString() {
        return "Sheep{name='" + name + "', age=" + age + ", birthday=" + birthday + "}";
    }
}
```

**深拷贝实现**
```java
public class DeepSheep implements Cloneable {
    private String name;
    private int age;
    private Date birthday;
    private List<String> habits;
    
    public DeepSheep(String name, int age, Date birthday, List<String> habits) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.habits = habits;
    }
    
    // 深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepSheep cloned = (DeepSheep) super.clone();
        // 手动克隆引用类型字段
        cloned.birthday = (Date) this.birthday.clone();
        cloned.habits = new ArrayList<>(this.habits);
        return cloned;
    }
    
    // 使用序列化实现深拷贝的替代方案
    public DeepSheep deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (DeepSheep) ois.readObject();
    }
    
    // getter和setter方法
    // ...
}
```

**客户端使用**
```java
public class Client {
    public static void main(String[] args) throws Exception {
        // 原始对象
        List<String> habits = Arrays.asList("eating", "sleeping");
        Date birthday = new Date();
        DeepSheep original = new DeepSheep("Dolly", 2, birthday, habits);
        
        // 克隆对象
        DeepSheep cloned = (DeepSheep) original.clone();
        
        // 修改克隆对象的引用类型字段
        cloned.getHabits().add("jumping");
        cloned.getBirthday().setTime(System.currentTimeMillis());
        
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
        System.out.println("Habits same? " + (original.getHabits() == cloned.getHabits()));
        System.out.println("Birthday same? " + (original.getBirthday() == cloned.getBirthday()));
    }
}
```

#### 3.6.4 深浅拷贝区别详解
- **浅拷贝**：只复制基本类型值，引用类型字段共享相同地址[^567]
- **深拷贝**：完全复制对象图，包括所有嵌套引用对象[^567][^568]

#### 3.6.5 典型应用场景
- 高效率创建相似对象，避免重复初始化开销
- 动态状态保存和恢复（如编辑器撤销功能）
- 大批量生成配置相似的对象
- 避免重复执行昂贵的初始化过程（如数据库连接）[^567][^568]

#### 3.6.6 优缺点分析
**优点**：
- 提高性能，避免重复的初始化过程
- 简化对象创建过程，特别是复杂对象的创建
- 可以动态添加和删除产品
- 提供简化的创建结构[^696]

**缺点**：
- 深拷贝实现复杂，需要正确处理所有引用字段
- 必须实现Cloneable接口，破坏了封装性
- 对已有类进行改造时可能需要修改源代码
- 需要小心处理循环引用问题[^696]

### 3.7 创建型模式综合对比与选择指南

#### 3.7.1 模式对比总结

| **模式类型** | **核心目标** | **适用场景** | **优点** | **缺点** |
|--------------|--------------|--------------|----------|----------|
| **单例模式** | 确保唯一实例 | 全局配置、资源池 | 节省资源、全局访问 | 测试困难、隐藏依赖 |
| **工厂方法** | 封装创建逻辑 | 动态对象创建、框架设计 | 解耦、支持扩展 | 类数量增多、复杂度高 |
| **抽象工厂** | 创建产品族 | 跨平台组件、成套产品 | 保证一致性、易于切换 | 扩展困难、抽象复杂 |
| **建造者** | 分步构建对象 | 复杂对象构建、多步骤创建 | 精细控制、相同过程不同表示 | 产品需共同接口、复杂度高 |
| **原型模式** | 复制现有实例 | 高效创建、状态保存 | 性能高、简化创建 | 深拷贝复杂、破坏封装[^696] |

#### 3.7.2 模式选择决策流程

1. **需要全局唯一实例？** → 单例模式[^695]
2. **需要条件化创建对象？** → 简单工厂模式[^695]
3. **需要子类决定实例化？** → 工厂方法模式[^695]
4. **需要创建对象家族？** → 抽象工厂模式[^695]
5. **需要分步构建复杂对象？** → 建造者模式[^695]
6. **需要高频克隆对象？** → 原型模式[^695]

#### 3.7.3 在Spring框架中的集成应用

Spring框架的IoC容器整合了多种创建型模式，实现了强大的对象生命周期管理[^705][^708]：

- **单例模式**：通过`DefaultSingletonBeanRegistry`管理单例Bean
- **工厂模式**：`BeanFactory`和`ApplicationContext`作为核心工厂接口
- **建造者模式**：`BeanDefinitionBuilder`用于构建复杂的Bean定义
- **原型模式**：prototype作用域的Bean每次请求都创建新实例

这种集成使得Spring能够统一控制对象的实例化、属性注入、初始化和销毁等完整生命周期[^705]。

#### 3.7.4 最佳实践与常见误区

**最佳实践**：
- 根据具体需求选择最适合的模式，避免过度设计
- 在框架设计中优先使用工厂方法和抽象工厂模式
- 对于配置类对象考虑使用单例模式
- 复杂对象构建使用建造者模式提高可读性
- 性能敏感场景考虑原型模式

**常见误区**：
- 滥用单例模式导致全局状态混乱
- 过度使用工厂模式增加不必要的复杂性
- 忽视深浅拷贝区别导致意外的对象共享
- 选择不合适的模式增加系统维护成本[^696][^742][^743]

### 3.8 本章总结

创建型设计模式为解决对象创建问题提供了五种经典的解决方案，每种模式都有其特定的应用场景和优势。在实际开发中，应该根据具体需求选择最合适的模式，或者组合使用多种模式来解决复杂的对象创建问题。理解这些模式的核心思想和适用场景，能够帮助开发者构建更加灵活、可维护和可扩展的软件系统。

## 4. 结构型设计模式深入解析
{4.1_结构型设计模式章节内容待填充}

## 5. 行为型设计模式深入解析
{5.1_行为型设计模式章节内容待填充}

## 6. 设计模式实战应用与现代框架实践

### 6.1 JDK源码中的设计模式实现

Java Development Kit (JDK) 源码是设计模式应用的宝库，其核心类库广泛运用了经典设计模式，体现了面向对象设计的精髓。JDK中的设计模式实现展示了如何在实际框架中应用这些模式来解决复杂的工程问题[^172]。

#### 6.1.1 创建型模式在JDK中的应用

**单例模式 (Singleton Pattern)**
- `java.lang.Runtime#getRuntime()`: JVM运行时环境的全局唯一实例，确保整个应用程序中只有一个Runtime实例[^172][^177]
- `java.awt.Desktop#getDesktop()`: 桌面访问接口的单例实现，提供统一的桌面操作接口[^172]

**工厂方法与抽象工厂模式**
- **工厂方法**: `java.util.Calendar#getInstance()`根据地区设置创建相应的日历实例[^177]
- **抽象工厂**: `javax.xml.parsers.DocumentBuilderFactory#newInstance()`生成XML解析器工厂，支持不同厂商的XML解析实现[^177]

**建造者模式**
- `java.lang.StringBuilder#append()`: 通过链式调用动态构建字符串对象[^172][^177]
- `java.sql.PreparedStatement`: SQL语句参数化构建，支持安全的SQL查询构建[^172]

**原型模式**
- `java.lang.Object#clone()`: 需要实现`Cloneable`接口的对象复制机制，避免重复创建对象[^172][^177]

#### 6.1.2 结构型模式在JDK中的应用

**装饰器模式**
- **IO流类**: `BufferedInputStream(InputStream)`为底层输入流添加缓冲功能[^172][^177]
- **集合工具**: `Collections.synchronizedList()`包装线程安全的集合实现[^177]

**适配器模式**
- `java.io.InputStreamReader(InputStream)`: 字节流到字符流的接口适配[^177]
- `java.util.Arrays#asList()`: 数组到List接口的适配转换[^172]

**享元模式**
- `Integer.valueOf(int)`: 缓存[-128, 127]范围内的整数对象，减少内存开销[^172][^177]
- `Boolean.valueOf(boolean)`: 返回预定义的静态实例，避免重复创建Boolean对象[^172]

**代理模式**
- `java.lang.reflect.Proxy`: 动态代理生成实现类，支持接口方法的动态调用[^172][^177]
- **RMI机制**: 远程方法调用的本地代理实现[^172]

#### 6.1.3 行为型模式在JDK中的应用

**模板方法模式**
- `java.util.AbstractList`: 提供`addAll()`算法框架，子类如`ArrayList`实现具体逻辑[^175][^177]
- `java.io.InputStream`: `read()`方法由子类实现具体读取逻辑[^172]

**观察者模式**
- `java.util.EventListener`: 事件监听器接口，支持事件驱动的编程模型[^172]
- `javax.servlet.http.HttpSessionAttributeListener`: 会话属性变更监听机制[^172][^177]

**策略模式**
- `java.util.Comparator#compare()`: 自定义排序策略，支持运行时算法切换[^172][^177]
- `javax.servlet.http.HttpServlet`: 根据HTTP请求类型调用相应的GET/POST处理策略[^177]

**责任链模式**
- `java.util.logging.Logger#log()`: 日志处理器链，支持多级日志处理[^172][^177]
- `javax.servlet.Filter#doFilter()`: Web请求过滤器链，实现请求处理的流水线操作[^172]

#### 6.1.4 综合应用与设计思想

JDK通过模式协同实现了高内聚、低耦合的架构设计：
- **开闭原则**: 通过抽象接口扩展功能（如`InputStream`的子类体系）[^175]
- **依赖倒置**: 面向接口编程（如`List`接口及`ArrayList`实现）[^178]
- **性能优化**: 享元模式减少对象创建（如`Integer`缓存），代理模式控制资源访问[^172][^177]

![JDK设计模式实现](./images/jdk_design_patterns.png)
*图6-1：JDK中的行为型设计模式实现架构*

### 6.2 Spring框架中的设计模式应用

Spring框架作为企业级Java开发的事实标准，其设计充分体现了设计模式的最佳实践。从IoC容器到AOP模块，Spring通过精妙的模式组合实现了高度灵活和可扩展的架构[^705][^736]。

#### 6.2.1 IOC容器设计模式实现

**工厂模式变体**
- **BeanFactory**: 基础工厂接口，负责Bean的创建与装配[^736]
- **实例工厂**: 动态工厂模式，先实例化工厂Bean，再用其创建产品Bean[^737]

**单例注册表模式**
- `DefaultListableBeanFactory`通过`ConcurrentHashMap`存储单例Bean，实现线程安全的单例注册表，区别于传统类加载器单例[^736][^737]

**模板方法模式**
容器启动流程由`AbstractApplicationContext.refresh()`定义算法骨架，子类通过重写钩子方法扩展功能（如`onRefresh()`），实现通用性与扩展性的平衡[^736]

#### 6.2.2 AOP模块设计模式应用

**代理模式**
Spring AOP的基础架构模式，通过代理对象控制对目标对象的访问，实现透明扩展功能[^718]
- **JDK动态代理**: 基于接口代理，适用于目标类实现了接口的场景[^716][^718]
- **CGLIB动态代理**: 基于类继承代理，用于目标类未实现接口的场景[^716][^718]

**装饰模式**
通过`MethodInterceptor`链实现装饰模式，动态组合多个切面逻辑[^718]
```java
public Object proceed() throws Throwable {
    if (currentInterceptorIndex == interceptors.size() - 1) {
        return method.invoke(target, args); // 执行目标方法
    }
    MethodInterceptor interceptor = intercepters.get(++currentInterceptorIndex);
    return interceptor.invoke(this); // 递归调用下一个拦截器
}
```

#### 6.2.3 Spring MVC中的设计模式

**MVC架构模式**
Spring MVC基于经典的模型-视图-控制器设计模式，通过分离关注点实现高效、可维护的Web应用开发[^725][^732]

**前端控制器模式**
- **DispatcherServlet**: 作为前端控制器，统一接收所有HTTP请求，根据URL路径匹配Controller方法[^727][^730]

**策略模式**
- **ViewResolver策略**: 支持多种视图解析策略（JSP、Thymeleaf、FreeMarker等）[^724][^727]
- **HandlerMapping策略**: 多种请求映射策略（注解驱动、XML配置等）[^727][^730]

![Spring框架架构](./images/spring_framework_patterns.png)
*图6-2：Spring MVC架构与设计模式应用*

#### 6.2.4 实际应用场景

**事务管理**
利用`TransactionInterceptor`统一管理事务提交/回滚，确保事务逻辑与业务代码解耦，增强系统容错性[^718][^719]

**权限验证**
在方法执行前通过切面检查用户权限，实现权限控制与业务逻辑分离，便于后续权限策略调整[^715]

**日志处理**
通过注解定义切面（如`@Log`），自动记录方法调用信息，避免日志代码侵入业务逻辑，提升代码纯净性与复用性[^714]

### 6.3 MyBatis框架中的设计模式实现

MyBatis作为优秀的持久层框架，其源码中巧妙融合了多种设计模式来解决复杂工程问题。这些模式不仅实现了模块解耦，更提升了框架的灵活性与可维护性[^769]。

#### 6.3.1 创建型模式应用

**工厂模式**
- `SqlSessionFactory`: 会话创建的核心工厂，负责整合数据源配置、构建事务工厂和SQL执行器[^769]
- `ObjectFactory`: 对象创建工厂，`MapperProxyFactory`: 代理对象生成工厂，`DataSourceFactory`: 数据源初始化工厂[^769]

**单例模式**
- `Configuration`: 全局单例，贯穿会话生命周期，管理所有映射配置、缓存策略、拦截器等组件[^769]

**建造者模式**
MyBatis大量使用`XxxxBuilder`类（如`XMLConfigBuilder`、`XMLMapperBuilder`）将复杂的XML解析流程封装为链式调用[^769][^774]

#### 6.3.2 结构型模式应用

**代理模式**
- `MapperProxy`: DAO接口的核心代理类，拦截所有CRUD方法调用并委托给执行器（`Executor`）处理，实现了数据库操作与业务逻辑的解耦[^769]

**装饰器模式**
- `CachingExecutor`: 通过装饰`SimpleExecutor`实现二级缓存功能。在一级缓存基础上包装缓存逻辑，通过俄罗斯套娃式结构动态扩展执行器能力[^769][^774]

**适配器模式**
- `Log`接口统一适配`Log4j`、`Slf4j`等异构日志框架。通过`LogFactory`动态加载具体实现，屏蔽第三方日志组件的接口差异[^769]

**组合模式**
动态SQL标签（如`<if>`、`<foreach>`）被解析为`SqlNode`接口的树状结构。各节点（如`IfSqlNode`、`ForEachSqlNode`）可独立或组合使用，支持复杂SQL的灵活构建[^769]

#### 6.3.3 行为型模式应用

**模板方法模式**
抽象类`BaseExecutor`定义数据库操作的通用流程模板（如查询缓存、处理提交等），子类（`SimpleExecutor`、`ReuseExecutor`）只需实现具体执行步骤[^769]

**策略模式**
- `TypeHandler`接口针对不同数据类型（如`LongTypeHandler`、`DateTypeHandler`）提供独立策略，避免结果集处理时的冗余`if-else`判断[^769]
- 执行器策略: `BatchExecutor`（批处理）、`CachingExecutor`（缓存）等执行器实现类可按需切换[^769]

**迭代器模式**
`PropertyTokenizer`以迭代方式解析对象属性路径（如`user.address.city`），广泛应用于参数填充和反射操作，隐藏了底层集合的复杂结构[^769]

![MyBatis架构设计](./images/mybatis_patterns_architecture.png)
*图6-3：MyBatis框架中的设计模式架构*

### 6.4 设计模式最佳实践

设计模式是软件开发人员在长期实践中总结出的、针对常见问题的标准化解决方案，旨在提升代码的灵活性、复用性和可维护性[^785][^786]。

#### 6.4.1 面向对象设计原则实践

**SOLID原则应用**
- **开闭原则**: 软件实体应扩展开放、修改关闭，通过抽象和多态实现扩展性（如策略模式）[^788]
- **里氏替换原则**: 子类应能替换父类，确保继承关系的正确性[^788]
- **接口隔离原则**: 客户端不应依赖不需要的接口，推荐使用小而专的接口[^788]
- **依赖倒置原则**: 高层模块不应依赖低层模块，都应依赖抽象，通过依赖注入实现解耦[^785][^788]

**组合优于继承**
优先使用组合而非继承，减少继承层次以增强可维护性。组合关系比继承具有更低的耦合度，便于系统演进[^523][^785][^788]

#### 6.4.2 模式选择策略

**问题导向选择**
设计过程应该是**先有问题后有方案**，而不是先有设计模式再找问题[^755]。开发者应该：
- 首先分析代码存在的痛点（如可读性差、扩展性不足）
- 然后针对性地应用设计模式改善
- 避免看到类似场景就盲目套用模式[^755]

**根据项目复杂度选择**
设计模式的应用场景主要是**复杂代码**，需要根据项目具体情况调整设计投入[^755]：
- **复杂项目**: 代码量大、开发周期长、参与人员多，应前期投入更多设计时间
- **简单项目**: 代码量少、开发人员不多，简单问题用简单解决方案，避免将简单问题复杂化[^755]

#### 6.4.3 重构与模式应用

**持续重构方法**
持续重构是避免过度设计的有效手段[^755]：
- 在真正出现痛点时再考虑设计模式
- 避免为不确定的未来需求提前设计
- 当对是否应用某种模式模棱两可时，评估未来重构的成本[^755]

**重构策略模式**
策略模式通过将算法封装为独立对象，实现"针对接口而非实现编程"的原则，是重构条件语句（如if/elseif/else链）的利器[^760]

**重构工厂模式**
传统简单工厂常因开关分支语句导致结构僵化。新设计模式如"数组工厂"和"数组原型"模式采用"以数组取代类型码"的重构手法，优化了实例化过程[^767]

![设计模式最佳实践](./images/design_patterns_pitfalls.png)
*图6-4：设计模式的核心概念与最佳实践*

### 6.5 常见误区与过度设计规避

设计模式作为软件工程领域的重要工具，旨在帮助开发者解决常见设计问题并提高代码质量。然而，在实际应用过程中，许多开发者容易陷入各种误区，导致过度设计的问题[^753][^755]。

#### 6.5.1 设计模式常见误区

**过度设计与设计不足的两极分化**
在实际项目开发中，开发者常常在两个极端之间摇摆：一是**过度设计**，在开始编码前花费大量时间进行复杂设计，应用各种设计模式，为未来可能不会实现的扩展需求做准备；二是**设计不足**，完全忽略设计环节，只追求代码能够运行，缺乏扩展性和灵活性[^755]。

**单一职责原则的误用**
单一职责原则（SRP）是最容易被误用的设计原则之一：
- **过度拆分**: 开发者将代码过度拆分为极小的类或方法，导致类数量激增，系统复杂性意外增加[^757]
- **职责划分不清晰**: 错误理解"职责"的定义，认为类内不同功能实现就需要拆分[^757]
- **混淆"单一职责"与"单一功能"**: 误以为每个类只能包含一个功能，忽视了职责的整体性[^757]

#### 6.5.2 过度设计的本质与危害

**过度设计的定义**
过度设计是指**为了应对未来可能不会发生的需求变化，而引入不必要的复杂设计模式**，导致代码可读性降低和维护成本升高[^753][^755]。

**过度设计的根源**
- **缺乏演进机制**: 设计模式需要跟随业务不断演进，但很多系统在初始设计后从未更新模式，最终跟不上业务发展[^753]
- **调试困难**: 过度设计的模块往往学习成本过高，新维护者无法快速理解，导致修改过程中"越改越离谱"[^753]
- **开闭原则的局限性**: 开闭原则主张"对扩展开放，对修改关闭"，这在频繁迭代的互联网环境中可能产生冲突[^753]

**过度设计的危害**
- 代码可读性显著下降
- 团队新成员学习成本增加
- 维护和扩展变得困难
- 系统演进受阻[^753][^755]

#### 6.5.3 规避过度设计的实践方法

**坚持问题导向的设计思维**
设计过程应该是**先有问题后有方案**，而不是先有设计模式再找问题[^755]。开发者应该：
- 首先分析代码存在的痛点（如可读性差、扩展性不足）
- 然后针对性地应用设计模式改善
- 避免看到类似场景就盲目套用模式[^755]

**掌握心法而非死记招式**
**设计原则和思想是心法，设计模式只是招式**。掌握心法才能以不变应万变[^755]。开发者应当：
- 深入理解设计原则和思想
- 明确为何应用某种设计模式
- 评估模式应用对代码质量的实际提升效果[^755]

**采用持续重构的开发方法**
持续重构是避免过度设计的有效手段[^755]：
- 在真正出现痛点时再考虑设计模式
- 避免为不确定的未来需求提前设计
- 当对是否应用某种模式模棱两可时，评估未来重构的成本[^755]

![重构与设计模式](./images/refactoring_patterns.png)
*图6-5：重构到设计模式的方法与实践*

### 6.6 本章总结

设计模式在现代Java框架中的应用体现了软件工程的智慧结晶。通过分析JDK、Spring和MyBatis等主流框架的设计模式实现，我们可以深刻理解如何在实际项目中恰当地应用设计模式：

**核心价值体现**:
1. **解耦与灵活性**: 通过工厂模式、代理模式等实现组件间的松耦合
2. **可扩展性**: 利用策略模式、装饰器模式支持系统的动态扩展
3. **可维护性**: 通过模板方法、责任链模式等提高代码的可读性和维护性

**实践建议**:
- **模式选择**: 根据具体问题选择最适合的模式，避免过度设计
- **原则遵循**: 始终坚持SOLID原则，确保设计质量
- **重构意识**: 采用持续重构的方法，在需要时引入设计模式

设计模式的价值不在于其本身，而在于恰当地应用它们解决实际问题。真正的设计智慧不在于知道多少种模式，而在于知道何时不使用模式[^753][^755]。通过深入理解设计原则、持续重构实践，以及对项目复杂度的准确评估，我们可以有效避免设计模式的常见误区，构建出既灵活又简洁的高质量软件系统。

## 7. 系统化学习路径与进阶实践指南

### 7.1 设计模式学习路线图

设计模式的学习应该遵循循序渐进的原则，从基础概念到高级应用，从理论学习到实践应用。以下是推荐的系统化学习路径[^237]：

#### 7.1.1 阶段一：基础准备（1-2周）
**面向对象编程基础巩固**
- 深入理解封装、继承、多态三大特性
- 掌握接口与抽象类的区别与应用场景
- 熟悉Java集合框架和异常处理机制

**SOLID设计原则掌握**
- 单一职责原则（SRP）：类设计聚焦单一功能模块
- 开闭原则（OCP）：对扩展开放，对修改关闭
- 里氏替换原则（LSP）：子类必须能替换父类且行为不变
- 接口隔离原则（ISP）：客户端不应依赖不使用的接口
- 依赖倒置原则（DIP）：高层模块不应依赖低层模块，都应依赖抽象[^90]

![设计模式学习路线图](./images/learning_roadmap.png)
*图7-1：Java设计模式系统化学习路线图*

#### 7.1.2 阶段二：模式分类学习（3-4周）
**创建型模式优先**
1. **单例模式**：确保全局唯一实例
2. **工厂方法模式**：封装对象创建逻辑
3. **抽象工厂模式**：创建相关对象家族
4. **建造者模式**：分步构建复杂对象
5. **原型模式**：复制现有实例提高效率

**结构型模式进阶**
- 适配器模式：接口兼容转换
- 装饰器模式：动态功能扩展
- 代理模式：控制对象访问
- 组合模式：树形结构处理
- 外观模式：简化复杂子系统接口

**行为型模式深入**
- 策略模式：算法策略封装
- 观察者模式：事件驱动机制
- 模板方法模式：算法框架定义
- 状态模式：状态转换管理
- 责任链模式：请求处理链[^569]

#### 7.1.3 阶段三：综合应用（2-3周）
**模式组合应用**
- 工厂方法+策略模式：创建可配置算法
- 装饰器+观察者：为观察者动态添加功能
- 组合+访问者：遍历复杂对象结构

**框架源码分析**
- JDK源码中的设计模式实现
- Spring框架设计模式应用
- MyBatis设计模式实现分析

### 7.2 学习顺序与优先级策略

#### 7.2.1 高频使用模式优先掌握
根据实际项目使用频率，建议优先学习以下6种最常用的设计模式：
1. **单例模式**：全局配置管理、资源池
2. **工厂方法模式**：动态对象创建、框架设计
3. **策略模式**：算法策略封装、条件处理
4. **观察者模式**：事件驱动、消息通知
5. **装饰器模式**：功能动态扩展
6. **代理模式**：访问控制、远程调用【0e80†】

#### 7.2.2 特定场景使用模式
以下模式在特定场景下非常有用，建议根据项目需求选择性学习：
1. **抽象工厂模式**：跨平台组件开发
2. **适配器模式**：接口兼容转换
3. **模板方法模式**：算法框架定义
4. **责任链模式**：请求处理流水线
5. **状态模式**：复杂状态管理【0e80†】

#### 7.2.3 复杂/少用模式
以下模式相对复杂或使用场景较少，可作为进阶内容：
1. **解释器模式**：特定领域语言解析
2. **访问者模式**：复杂对象结构操作
3. **享元模式**：大量细粒度对象共享【0e80†】

### 7.3 21天密集型学习计划

#### 7.3.1 第一周：Java基础与创建型模式
**Day 1-2：面向对象核心概念**
- 封装、继承、多态深入理解
- 接口与抽象类实战练习
- 代码规范与设计原则

**Day 3-4：集合框架与异常处理**
- 集合类设计模式初步接触
- 异常处理最佳实践
- 代码重构技巧

**Day 5-7：创建型模式入门**
- 单例模式多种实现方式
- 工厂方法模式应用
- 简单工厂与工厂方法区别【ba23†】

#### 7.3.2 第二周：结构型模式深入学习
**Day 8-10：结构型模式基础**
- 适配器模式：接口转换实战
- 装饰器模式：功能动态扩展
- 代理模式：访问控制实现

**Day 11-12：结构型模式进阶**
- 组合模式：树形结构处理
- 外观模式：简化复杂接口
- 桥接模式：抽象与实现分离

**Day 13-14：模式综合练习**
- 多种结构型模式组合应用
- 实际项目案例分析
- 代码重构实践【ba23†】

#### 7.3.3 第三周：行为型模式与综合实战
**Day 15-17：行为型模式核心**
- 策略模式：算法策略封装
- 观察者模式：事件通知机制
- 模板方法：算法框架定义

**Day 18-19：行为型模式进阶**
- 状态模式：状态转换管理
- 责任链模式：请求处理链
- 命令模式：命令封装与执行

**Day 20-21：综合项目实战**
- 完整系统设计与实现
- 多种模式组合应用
- 代码审查与优化【ba23†】

![21天学习计划](./images/21day_schedule.png)
*图7-2：21天设计模式密集型学习计划表*

### 7.4 实战项目练习方法论

#### 7.4.1 推荐实战项目类型
**文档解析渲染系统**
- **应用模式**：状态模式、责任链模式、组合模式
- **功能特点**：支持多种文档格式解析，动态渲染处理
- **技术挑战**：复杂状态转换，处理链设计，树形结构操作

**房屋选购系统**
- **应用模式**：建造者模式、工厂模式、策略模式
- **功能特点**：房屋信息构建，筛选策略，个性化推荐
- **技术挑战**：复杂对象构建，算法策略选择，扩展性设计【72e2†】

#### 7.4.2 项目实施流程
1. **需求分析**：明确系统功能和扩展需求点
2. **模式选择**：根据问题特征匹配合适的设计模式
3. **架构设计**：定义清晰的类结构和交互关系
4. **编码实现**：编写模式核心代码，确保正确实现
5. **测试验证**：通过单元测试确保模式应用正确性【72e2†】

#### 7.4.3 实践要点与最佳实践
- **每个模式独立测试**：为每个设计模式编写独立的测试案例
- **记录决策过程**：详细记录模式选择和应用决策过程
- **重构优化**：通过持续重构优化模式实现质量
- **代码审查**：进行同伴代码审查，提高代码质量【72e2†】

![项目实战案例](./images/project_examples.png)
*图7-3：设计模式实战项目案例展示*

### 7.5 技能评估与进阶方向

#### 7.5.1 设计模式掌握程度评估标准

**评估维度**
1. **理论基础**
   - 模式定义和分类准确性
   - 适用场景分析能力
   - SOLID原则理解深度

2. **应用能力**
   - 模式选择准确性
   - 代码实现正确性
   - 问题解决效果

3. **综合能力**
   - 多模式组合应用能力
   - 系统架构设计水平
   - 代码质量把控能力【e752†】

**评估方法**
1. **理论测试**：模式概念和特点掌握程度
2. **案例分析**：给定问题选择合适模式的能力
3. **项目实战**：完整系统设计和实现能力
4. **代码审查**：模式应用质量和代码规范【e752†】

#### 7.5.2 能力等级划分

**初级水平**
- 能识别和描述常见设计模式
- 理解基本概念和简单应用场景
- 能在指导下应用单个模式

**中级水平**
- 能正确应用单个设计模式
- 理解模式之间的区别和联系
- 能独立完成模式选择和实现

**高级水平**
- 能灵活组合多种设计模式
- 具备系统架构设计能力
- 能指导他人学习和应用模式【e752†】

![能力评估金字塔](./images/assessment_pyramid.png)
*图7-4：设计模式掌握能力评估金字塔*

#### 7.5.3 职业发展路径

**技术专家路线**
- **初级工程师**：掌握基础模式应用
- **高级工程师**：熟练应用多种模式解决复杂问题
- **技术专家**：设计模式理论创新和框架开发

**架构师路线**
- **系统设计师**：运用模式进行系统架构设计
- **解决方案架构师**：为不同业务场景设计解决方案
- **企业架构师**：制定企业级技术架构标准【e752†】

![职业发展路径](./images/career_path.png)
*图7-5：软件工程师职业发展双通道路径*

### 7.6 持续学习与进阶资源

#### 7.6.1 推荐学习资源
**经典书籍**
- 《设计模式：可复用面向对象软件的基础》（GoF经典）
- 《Head First设计模式》（图文并茂入门）
- 《设计模式之禅》（实战案例丰富）

**在线资源**
- GitHub开源项目源码学习
- 技术博客和专栏文章
- 在线课程和视频教程

**实践平台**
- LeetCode设计模式相关题目
- 开源项目贡献参与
- 个人项目实践[^569]

#### 7.6.2 社区与交流
- 技术社区讨论（Stack Overflow、知乎、CSDN）
- 技术沙龙和Meetup活动
- 开源项目协作经验分享

#### 7.6.3 持续改进方法
1. **代码重构**：定期回顾和重构现有代码
2. **模式反思**：反思模式应用是否恰当，避免过度设计
3. **新技术学习**：关注新框架和新技术中的模式应用
4. **经验分享**：通过博客、演讲分享学习心得[^569]

### 7.7 本章总结

设计模式的系统化学习是一个循序渐进的过程，需要理论学习和实践应用相结合。通过制定合理的学习计划、选择适当的实战项目、建立科学的评估体系，开发者可以逐步从模式识别到灵活应用，最终达到高级水平。

关键成功因素包括：
- **持续实践**：通过真实项目内化模式应用
- **反思总结**：定期回顾模式应用效果
- **社区交流**：通过交流学习最佳实践
- **避免过度设计**：根据实际需求选择模式

记住，设计模式的最终目的是解决实际问题，而不是为了使用模式而使用模式。真正的设计智慧在于知道何时使用模式，更重要的是知道何时不使用模式[^569]【72e2†】【e752†】。

---

## 附录
### 代码示例规范说明
所有代码示例均遵循Java编码规范，使用JDK 8+语法特性，确保在实际项目中的可用性。

### 图表说明
- 所有UML类图使用PlantUML规范绘制
- 时序图展示模式交互流程
- 架构图说明模式在系统中的应用

*最后更新: 2025-12-23*

[^54]: [1]23种GOF设计模式及7大原则概述](https://blog.csdn.net/weixin_43024834/article/details/138821775)
[^25]: [设计模式二三事](https://tech.meituan.com/2022/03/10/interesting-talk-about-design-patterns.html)
[^25]: [设计模式二三事](https://tech.meituan.com/2022/03/10/interesting-talk-about-design-patterns.html)
[^14]: [面向对象编程的SOLID 原则](https://www.freecodecamp.org/chinese/news/solid-principles/)
[^16]: [SOLID 原则](https://everfind.github.io/posts/2021/06/24/solid.html)
[^14]: [面向对象编程的SOLID 原则](https://www.freecodecamp.org/chinese/news/solid-principles/)
[^14]: [面向对象编程的SOLID 原则](https://www.freecodecamp.org/chinese/news/solid-principles/)
[^16]: [SOLID 原则](https://everfind.github.io/posts/2021/06/24/solid.html)
[^11]: [JHBlog/设计模式/设计模式/2、面向对象设计的六大设计原则. ...](https://github.com/SunshineBrother/JHBlog/blob/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/2%E3%80%81%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%E8%AE%BE%E8%AE%A1%E7%9A%84%E5%85%AD%E5%A4%A7%E8%AE%BE%E8%AE%A1%E5%8E%9F%E5%88%99.md)
[^11]: [JHBlog/设计模式/设计模式/2、面向对象设计的六大设计原则. ...](https://github.com/SunshineBrother/JHBlog/blob/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/2%E3%80%81%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%E8%AE%BE%E8%AE%A1%E7%9A%84%E5%85%AD%E5%A4%A7%E8%AE%BE%E8%AE%A1%E5%8E%9F%E5%88%99.md)
[^35]: [如何解除程序员中年危机，阿里总监为您带来一条正确的职业 ...](https://www.nowcoder.com/discuss/353149272298299392)
[^35]: [如何解除程序员中年危机，阿里总监为您带来一条正确的职业 ...](https://www.nowcoder.com/discuss/353149272298299392)
[^54]: [1]23种GOF设计模式及7大原则概述](https://blog.csdn.net/weixin_43024834/article/details/138821775)
[^59]: [GoF 23种经典的设计模式——工厂模式](https://cloud.tencent.com/developer/article/2378990)
[^199]: [快速记忆23种设计模式](https://zhuanlan.zhihu.com/p/128145128)
[^199]: [快速记忆23种设计模式](https://zhuanlan.zhihu.com/p/128145128)
[^512]: [创建型模式— Graphic Design Patterns - 图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/creational.html)
[^512]: [创建型模式— Graphic Design Patterns - 图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/creational.html)
[^512]: [创建型模式— Graphic Design Patterns - 图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/creational.html)
[^512]: [创建型模式— Graphic Design Patterns - 图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/creational.html)
[^199]: [快速记忆23种设计模式](https://zhuanlan.zhihu.com/p/128145128)
[^199]: [快速记忆23种设计模式](https://zhuanlan.zhihu.com/p/128145128)
[^525]: [超详细-七种常见结构型模式的描述总结与代码分析](https://www.cnblogs.com/songjilong/p/12729129.html)
[^523]: [一篇文章带你了解设计模式——结构型模式](https://www.cnblogs.com/qiuluoyuweiliang/p/17087391.html)
[^527]: [结构型模式- Java教程](https://liaoxuefeng.com/books/java/design-patterns/structural/index.html)
[^528]: [结构型模式— Graphic Design Patterns](https://design-patterns.readthedocs.io/zh_CN/latest/structural_patterns/structural.html)
[^205]: [GoF 23种设计模式概述- 心明谭](https://www.cnblogs.com/wpbxin/p/8849451.html)
[^199]: [快速记忆23种设计模式](https://zhuanlan.zhihu.com/p/128145128)
[^530]: [Java设计模式——行为型模式- 王陸](https://www.cnblogs.com/wkfvawl/p/15362460.html)
[^530]: [Java设计模式——行为型模式- 王陸](https://www.cnblogs.com/wkfvawl/p/15362460.html)
[^534]: [《设计模式详解》行为型模式- 访问者模式 - 阿里云开发者社区](https://developer.aliyun.com/article/935524)
[^532]: [结合Golang聊聊23种设计模式---行为型(1) | Mark's - Mark's Blog](https://marksuper.xyz/2024/07/28/design4/)
[^199]: [快速记忆23种设计模式](https://zhuanlan.zhihu.com/p/128145128)
[^199]: [快速记忆23种设计模式](https://zhuanlan.zhihu.com/p/128145128)
[^203]: [设计模式概述](https://www.sqlboy.tech/pages/9635dc/)
[^205]: [GoF 23种设计模式概述- 心明谭](https://www.cnblogs.com/wpbxin/p/8849451.html)
[^512]: [创建型模式— Graphic Design Patterns - 图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/creational.html)
[^40]: [23种设计模式分类思维导图模板](https://www.processon.com/view/67dbb92f855b362fa481aa7c)
[^48]: [GoF的23种设计模式之创建型模式的特点和分类- 菜鸟-传奇](https://www.cnblogs.com/cainiao-chuanqi/p/10966300.html)
[^49]: [GoF的23种设计模式详解（分类及功能）](https://juejin.cn/post/7029594702953316360)
[^551]: [从原理到实践：面向对象设计中的经典模式-单例模式](https://zhuanlan.zhihu.com/p/624984309)
[^551]: [从原理到实践：面向对象设计中的经典模式-单例模式](https://zhuanlan.zhihu.com/p/624984309)
[^551]: [从原理到实践：面向对象设计中的经典模式-单例模式](https://zhuanlan.zhihu.com/p/624984309)
[^556]: [Java单例模式探究饿汉式、懒汉式、双重检查锁](https://blog.csdn.net/mbh12333/article/details/90297742)
[^551]: [从原理到实践：面向对象设计中的经典模式-单例模式](https://zhuanlan.zhihu.com/p/624984309)
[^556]: [Java单例模式探究饿汉式、懒汉式、双重检查锁](https://blog.csdn.net/mbh12333/article/details/90297742)
[^551]: [从原理到实践：面向对象设计中的经典模式-单例模式](https://zhuanlan.zhihu.com/p/624984309)
[^551]: [从原理到实践：面向对象设计中的经典模式-单例模式](https://zhuanlan.zhihu.com/p/624984309)
[^556]: [Java单例模式探究饿汉式、懒汉式、双重检查锁](https://blog.csdn.net/mbh12333/article/details/90297742)
[^696]: [创建型设计模式总结 - 青雲的博客](https://www.echovic.com/blog/design-pattern/summary-of-creative-design-patterns)
[^696]: [创建型设计模式总结 - 青雲的博客](https://www.echovic.com/blog/design-pattern/summary-of-creative-design-patterns)
[^705]: [Spring中常用设计模式简介单例模式是一种创建型设计模式](https://juejin.cn/post/7358688805156929573)
[^577]: [设计模式-工厂方法的应用场景及Java中对工厂方法的应用](https://juejin.cn/post/7055270364515368990)
[^577]: [设计模式-工厂方法的应用场景及Java中对工厂方法的应用](https://juejin.cn/post/7055270364515368990)
[^578]: [深入解析Java工厂模式及其应用场景](https://zhuanlan.zhihu.com/p/624343687)
[^576]: [工厂模式简介和应用场景- 情陌人灬已不在](https://www.cnblogs.com/deityjian/p/10908739.html)
[^583]: [设计模式：工厂方法模式（Factory Method） - 阿里云开发者社区](https://developer.aliyun.com/article/1655699)
[^696]: [创建型设计模式总结 - 青雲的博客](https://www.echovic.com/blog/design-pattern/summary-of-creative-design-patterns)
[^696]: [创建型设计模式总结 - 青雲的博客](https://www.echovic.com/blog/design-pattern/summary-of-creative-design-patterns)
[^695]: [探索设计模式的魅力：创建型设计模式的比较与决策原创](https://blog.csdn.net/danci_/article/details/136118538)
[^540]: [抽象工厂模式](http://www.runoob.com/design-pattern/abstract-factory-pattern.html)
[^540]: [抽象工厂模式](http://www.runoob.com/design-pattern/abstract-factory-pattern.html)
[^543]: [Study on Abstract Factory Pattern of the JAVA Design Pattern](https://www.semanticscholar.org/paper/4604e18dc87362e516a737eae2a85fbf3ba50ce3)
[^540]: [抽象工厂模式](http://www.runoob.com/design-pattern/abstract-factory-pattern.html)
[^543]: [Study on Abstract Factory Pattern of the JAVA Design Pattern](https://www.semanticscholar.org/paper/4604e18dc87362e516a737eae2a85fbf3ba50ce3)
[^696]: [创建型设计模式总结 - 青雲的博客](https://www.echovic.com/blog/design-pattern/summary-of-creative-design-patterns)
[^696]: [创建型设计模式总结 - 青雲的博客](https://www.echovic.com/blog/design-pattern/summary-of-creative-design-patterns)
[^540]: [抽象工厂模式](http://www.runoob.com/design-pattern/abstract-factory-pattern.html)
[^560]: [建造者模式（Builder和Director） 原创](https://blog.csdn.net/founder517518/article/details/66477908)
[^560]: [建造者模式（Builder和Director） 原创](https://blog.csdn.net/founder517518/article/details/66477908)
[^561]: [（Builder）建造者模式的Java实现 - 阿里云开发者社区](https://developer.aliyun.com/article/420607)
[^560]: [建造者模式（Builder和Director） 原创](https://blog.csdn.net/founder517518/article/details/66477908)
[^561]: [（Builder）建造者模式的Java实现 - 阿里云开发者社区](https://developer.aliyun.com/article/420607)
[^696]: [创建型设计模式总结 - 青雲的博客](https://www.echovic.com/blog/design-pattern/summary-of-creative-design-patterns)
[^696]: [创建型设计模式总结 - 青雲的博客](https://www.echovic.com/blog/design-pattern/summary-of-creative-design-patterns)
[^742]: [摸爬滚打学设计模式【二】：建造者模式、原型模式、单例模式](https://zhuanlan.zhihu.com/p/27400170)
[^743]: [浅谈Spring中设计模式（单例、工厂、观察者、建造者）](https://juejin.cn/post/7201010542215626807)
[^567]: [原型模式及深浅拷贝](https://blog.uuanqin.top/p/96a98120/index.html)
[^567]: [原型模式及深浅拷贝](https://blog.uuanqin.top/p/96a98120/index.html)
[^568]: [从原型模式到浅拷贝和深拷贝](https://www.51cto.com/article/622758.html)
[^567]: [原型模式及深浅拷贝](https://blog.uuanqin.top/p/96a98120/index.html)
[^567]: [原型模式及深浅拷贝](https://blog.uuanqin.top/p/96a98120/index.html)
[^568]: [从原型模式到浅拷贝和深拷贝](https://www.51cto.com/article/622758.html)
[^567]: [原型模式及深浅拷贝](https://blog.uuanqin.top/p/96a98120/index.html)
[^568]: [从原型模式到浅拷贝和深拷贝](https://www.51cto.com/article/622758.html)
[^696]: [创建型设计模式总结 - 青雲的博客](https://www.echovic.com/blog/design-pattern/summary-of-creative-design-patterns)
[^696]: [创建型设计模式总结 - 青雲的博客](https://www.echovic.com/blog/design-pattern/summary-of-creative-design-patterns)
[^696]: [创建型设计模式总结 - 青雲的博客](https://www.echovic.com/blog/design-pattern/summary-of-creative-design-patterns)
[^695]: [探索设计模式的魅力：创建型设计模式的比较与决策原创](https://blog.csdn.net/danci_/article/details/136118538)
[^695]: [探索设计模式的魅力：创建型设计模式的比较与决策原创](https://blog.csdn.net/danci_/article/details/136118538)
[^695]: [探索设计模式的魅力：创建型设计模式的比较与决策原创](https://blog.csdn.net/danci_/article/details/136118538)
[^695]: [探索设计模式的魅力：创建型设计模式的比较与决策原创](https://blog.csdn.net/danci_/article/details/136118538)
[^695]: [探索设计模式的魅力：创建型设计模式的比较与决策原创](https://blog.csdn.net/danci_/article/details/136118538)
[^695]: [探索设计模式的魅力：创建型设计模式的比较与决策原创](https://blog.csdn.net/danci_/article/details/136118538)
[^705]: [Spring中常用设计模式简介单例模式是一种创建型设计模式](https://juejin.cn/post/7358688805156929573)
[^708]: [Spring 中的设计模式详解](https://javaguide.cn/system-design/framework/spring/spring-design-patterns-summary.html)
[^705]: [Spring中常用设计模式简介单例模式是一种创建型设计模式](https://juejin.cn/post/7358688805156929573)
[^696]: [创建型设计模式总结 - 青雲的博客](https://www.echovic.com/blog/design-pattern/summary-of-creative-design-patterns)
[^742]: [摸爬滚打学设计模式【二】：建造者模式、原型模式、单例模式](https://zhuanlan.zhihu.com/p/27400170)
[^743]: [浅谈Spring中设计模式（单例、工厂、观察者、建造者）](https://juejin.cn/post/7201010542215626807)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^175]: [JDK源码——利用模板方法看设计模式](https://cloud.tencent.com/developer/article/1418158)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^175]: [JDK源码——利用模板方法看设计模式](https://cloud.tencent.com/developer/article/1418158)
[^178]: [软件设计模式及其在Java类库中的典型实现](https://d.wanfangdata.com.cn/periodical/jsjgcyyy200204016)
[^172]: [JDK源码中使用的设计模式- 白露](https://www.cnblogs.com/shoshana-kong/p/10787401.html)
[^177]: [设计模式在JDK源码中的应用](https://zhuanlan.zhihu.com/p/48230750)
[^705]: [Spring中常用设计模式简介单例模式是一种创建型设计模式](https://juejin.cn/post/7358688805156929573)
[^736]: [Spring IOC容器启动流程源码解析(一)——容器概念详解及 ...](https://www.cnblogs.com/takumicx/p/9757492.html)
[^736]: [Spring IOC容器启动流程源码解析(一)——容器概念详解及 ...](https://www.cnblogs.com/takumicx/p/9757492.html)
[^737]: [Spring核心——设计模式与IoC - 随风溜达的向日葵](https://www.chkui.com/article/spring/spring_core_design_pattern_and_ioc)
[^736]: [Spring IOC容器启动流程源码解析(一)——容器概念详解及 ...](https://www.cnblogs.com/takumicx/p/9757492.html)
[^737]: [Spring核心——设计模式与IoC - 随风溜达的向日葵](https://www.chkui.com/article/spring/spring_core_design_pattern_and_ioc)
[^736]: [Spring IOC容器启动流程源码解析(一)——容器概念详解及 ...](https://www.cnblogs.com/takumicx/p/9757492.html)
[^718]: [03-Spring AOP中的设计模式原创](https://blog.csdn.net/Mr_Air_Boy/article/details/140547031)
[^716]: [Spring AOP实现方式 - 阿里云开发者社区](https://developer.aliyun.com/article/641404)
[^718]: [03-Spring AOP中的设计模式原创](https://blog.csdn.net/Mr_Air_Boy/article/details/140547031)
[^716]: [Spring AOP实现方式 - 阿里云开发者社区](https://developer.aliyun.com/article/641404)
[^718]: [03-Spring AOP中的设计模式原创](https://blog.csdn.net/Mr_Air_Boy/article/details/140547031)
[^718]: [03-Spring AOP中的设计模式原创](https://blog.csdn.net/Mr_Air_Boy/article/details/140547031)
[^725]: [MVC Design Pattern and Its Application in JSP Systems](https://www.semanticscholar.org/paper/3d933cca258e9f7ad8472873f686fca183656f49)
[^732]: [MVC设计模式的研究及其应用](https://d.wanfangdata.com.cn/periodical/xddzjs200520036)
[^727]: [使用Spring MVC - Java教程- 廖雪峰的官方网站](https://liaoxuefeng.com/books/java/spring/web/mvc/index.html)
[^730]: [javaweb、spring、springmvc和springboot有什么区别，都是 ...](https://www.zhihu.com/question/509707651)
[^724]: [Design and Implementation of MVC Framework Based on Spring](https://www.semanticscholar.org/paper/ca4a854b86bcd1e293671265c0cadd30e2083d40)
[^727]: [使用Spring MVC - Java教程- 廖雪峰的官方网站](https://liaoxuefeng.com/books/java/spring/web/mvc/index.html)
[^727]: [使用Spring MVC - Java教程- 廖雪峰的官方网站](https://liaoxuefeng.com/books/java/spring/web/mvc/index.html)
[^730]: [javaweb、spring、springmvc和springboot有什么区别，都是 ...](https://www.zhihu.com/question/509707651)
[^718]: [03-Spring AOP中的设计模式原创](https://blog.csdn.net/Mr_Air_Boy/article/details/140547031)
[^719]: [基于AOP的Web系统事务管理的应用研究](https://d.wanfangdata.com.cn/periodical/wjfz201004063)
[^715]: [The Realization of Permission Validation Based on Spring AOP](https://www.semanticscholar.org/paper/76095c422a83757230ed2e45407b807dbff1312d)
[^714]: [Annotation-based Spring AOP Design and Implementation of Log Processing](https://www.semanticscholar.org/paper/c2ff7c280f6ac107b9761fce9d3503429ea295e1)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^774]: [MyBatis 设计模式解析 - 阿里云开发者社区](https://developer.aliyun.com/article/1395629)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^774]: [MyBatis 设计模式解析 - 阿里云开发者社区](https://developer.aliyun.com/article/1395629)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^769]: [MyBatis 中用了哪些牛逼的设计模式？](https://juejin.cn/post/7210216031536627770)
[^785]: [架构师日记-深入理解软件设计模式](https://developer.jdcloud.com/article/2868)
[^786]: [Java-开发者的设计模式实践指南-全- - 绝不原创的飞龙](https://www.cnblogs.com/apachecn/p/19085143)
[^788]: [设计模式指南：23种经典模式的深度解析与应用](https://www.ktovoz.com/blog/%E6%95%99%E5%AD%A6/Design-patterns-Python)
[^788]: [设计模式指南：23种经典模式的深度解析与应用](https://www.ktovoz.com/blog/%E6%95%99%E5%AD%A6/Design-patterns-Python)
[^788]: [设计模式指南：23种经典模式的深度解析与应用](https://www.ktovoz.com/blog/%E6%95%99%E5%AD%A6/Design-patterns-Python)
[^785]: [架构师日记-深入理解软件设计模式](https://developer.jdcloud.com/article/2868)
[^788]: [设计模式指南：23种经典模式的深度解析与应用](https://www.ktovoz.com/blog/%E6%95%99%E5%AD%A6/Design-patterns-Python)
[^523]: [一篇文章带你了解设计模式——结构型模式](https://www.cnblogs.com/qiuluoyuweiliang/p/17087391.html)
[^785]: [架构师日记-深入理解软件设计模式](https://developer.jdcloud.com/article/2868)
[^788]: [设计模式指南：23种经典模式的深度解析与应用](https://www.ktovoz.com/blog/%E6%95%99%E5%AD%A6/Design-patterns-Python)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^760]: [使用策略模式重构if/elseif/elseif - waynaqua](https://www.cnblogs.com/waynaqua/p/17403512.html)
[^767]: [新的设计模式——数组工厂和数组原型模式](https://d.wanfangdata.com.cn/periodical/jsjyy2012z2033)
[^753]: [谈谈过度设计：因噎废食的陷阱](https://zhuanlan.zhihu.com/p/587362654)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^757]: [单一职责原则的常见误区](https://www.cnblogs.com/binbingg/p/19063824)
[^757]: [单一职责原则的常见误区](https://www.cnblogs.com/binbingg/p/19063824)
[^757]: [单一职责原则的常见误区](https://www.cnblogs.com/binbingg/p/19063824)
[^753]: [谈谈过度设计：因噎废食的陷阱](https://zhuanlan.zhihu.com/p/587362654)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^753]: [谈谈过度设计：因噎废食的陷阱](https://zhuanlan.zhihu.com/p/587362654)
[^753]: [谈谈过度设计：因噎废食的陷阱](https://zhuanlan.zhihu.com/p/587362654)
[^753]: [谈谈过度设计：因噎废食的陷阱](https://zhuanlan.zhihu.com/p/587362654)
[^753]: [谈谈过度设计：因噎废食的陷阱](https://zhuanlan.zhihu.com/p/587362654)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^753]: [谈谈过度设计：因噎废食的陷阱](https://zhuanlan.zhihu.com/p/587362654)
[^755]: [设计模式与范式-总结：2.实际开发中如何避免过度设计，如何 ...](https://blog.csdn.net/chenjian723122704/article/details/137739972)
[^237]: [实践GoF的23种设计模式：SOLID原则（上） - 华为云](https://bbs.huaweicloud.com/blogs/335098)
[^90]: [详解设计模式：责任链模式](https://cloud.tencent.com/developer/article/2185900)
[^569]: [DeepClone: Modeling Clones to Generate Code Predictions](https://arxiv.org/abs/2007.11671)
[^569]: [DeepClone: Modeling Clones to Generate Code Predictions](https://arxiv.org/abs/2007.11671)
[^569]: [DeepClone: Modeling Clones to Generate Code Predictions](https://arxiv.org/abs/2007.11671)
[^569]: [DeepClone: Modeling Clones to Generate Code Predictions](https://arxiv.org/abs/2007.11671)