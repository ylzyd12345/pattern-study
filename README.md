# 设计模式学习项目 (pattern-study)

[![Java](https://img.shields.io/badge/Java-11-blue.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.0%2B-green.svg)](https://maven.apache.org/)
[![JUnit](https://img.shields.io/badge/JUnit-5.10.2-orange.svg)](https://junit.org/junit5/)
[![Test Coverage](https://img.shields.io/badge/Coverage-80%25%2B-brightgreen.svg)](https://www.jacoco.org/jacoco/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

[java-design-patterns](https://github.com/iluwatar/java-design-patterns)

> I see and I forget, I hear and I remember, I do and I understand.

## 项目概述

这是一个全面的Java设计模式学习项目，包含了23种经典设计模式的实现和详细说明。项目基于**JDK 11**构建，采用现代化的测试体系，旨在帮助开发者理解设计模式的概念、应用场景和实现方式，提高代码设计能力。

### 🎯 项目特色

- **完整的23种设计模式实现**：涵盖创建型、结构型和行为型三大类设计模式
- **现代化技术栈**：基于JDK 25 LTS版本，支持最新Java特性
- **高质量测试体系**：80%+代码覆盖率，全面的单元测试和集成测试
- **企业级代码质量**：集成JaCoCo、Checkstyle、PMD、SpotBugs等质量工具
- **详细的文档说明**：每个模式都有完整的中文文档，包含UML图、实现示例和框架应用
- **实际应用场景**：结合JDK、Spring和Spring Boot框架中的实际应用案例

### 学习目标

- 掌握23种经典设计模式的核心概念和实现方式
- 理解每种设计模式的适用场景和优缺点
- 学习如何在实际项目中应用设计模式
- 提高代码的可维护性、可扩展性和可复用性
- 培养良好的软件设计思维和测试习惯

## 技术栈

- **语言**: Java 11 (LTS)
- **构建工具**: Maven 3.0+
- **测试框架**: JUnit 5.10.2
- **Mock框架**: Mockito 5.11.0
- **代码覆盖率**: JaCoCo 0.8.8
- **代码质量**: Checkstyle 3.2.1, PMD 3.21.0, SpotBugs 4.7.3.0
- **编译器插件**: Maven Compiler Plugin 3.12.1

## 快速开始

### 环境要求

- **JDK 11** (LTS) 或更高版本
- Maven 3.0 或更高版本

### 克隆项目

```bash
git clone https://github.com/ylzyd12345/pattern-study.git
cd pattern-study
```

### 构建项目

```bash
mvn clean compile
```

### 运行测试

```bash
mvn test
```

### 生成代码覆盖率报告

```bash
mvn jacoco:report
```

### 代码质量检查

```bash
mvn checkstyle:check
mvn pmd:check
mvn spotbugs:check
```

### 运行示例

每个设计模式都有一个App.java类用于演示，例如单例模式：

```bash
cd src/main/java/com/kevin/demo/creational/单例/饿汉
javac *.java
java App
```

## 项目结构

项目采用标准的Maven目录结构，所有设计模式按照创建型、结构型和行为型三大类进行组织：
```java
static {
        // 行为型模式
        DIRECTORY_MAPPINGS.put("中介", "mediator");
        DIRECTORY_MAPPINGS.put("命令", "command");
        DIRECTORY_MAPPINGS.put("备忘录", "memento");
        DIRECTORY_MAPPINGS.put("模板", "template");
        DIRECTORY_MAPPINGS.put("状态", "state");
        DIRECTORY_MAPPINGS.put("策略", "strategy");
        DIRECTORY_MAPPINGS.put("观察者", "observer");
        DIRECTORY_MAPPINGS.put("解释", "interpreter");
        DIRECTORY_MAPPINGS.put("访问者", "visitor");
        DIRECTORY_MAPPINGS.put("责任链", "chainOfResponsibility");
        DIRECTORY_MAPPINGS.put("迭代", "iterator");
        
        // 创建型模式
        DIRECTORY_MAPPINGS.put("单例", "singleton");
        DIRECTORY_MAPPINGS.put("原", "prototype");
        DIRECTORY_MAPPINGS.put("工厂", "factory");
        DIRECTORY_MAPPINGS.put("建造者", "builder");
        DIRECTORY_MAPPINGS.put("抽象工厂", "abstractFactory");
        
        // 结构型模式
        DIRECTORY_MAPPINGS.put("享元", "flyweight");
        DIRECTORY_MAPPINGS.put("代理", "proxy");
        DIRECTORY_MAPPINGS.put("外观", "facade");
        DIRECTORY_MAPPINGS.put("桥", "bridge");
        DIRECTORY_MAPPINGS.put("组合", "composite");
        DIRECTORY_MAPPINGS.put("装饰", "decorator");
        DIRECTORY_MAPPINGS.put("适配", "adapter");
        
        // 其他子目录
        DIRECTORY_MAPPINGS.put("不好的例子", "badExample");
        DIRECTORY_MAPPINGS.put("好的例子", "goodExample");
        DIRECTORY_MAPPINGS.put("懒汉", "lazy");
        DIRECTORY_MAPPINGS.put("内部类", "innerClass");
        DIRECTORY_MAPPINGS.put("双检", "doubleCheck");
        DIRECTORY_MAPPINGS.put("枚举", "enum");
        DIRECTORY_MAPPINGS.put("饿汉", "eager");
        DIRECTORY_MAPPINGS.put("工厂方法", "factoryMethod");
        DIRECTORY_MAPPINGS.put("简单工厂", "simpleFactory");
    }
```

```
pattern-study/
├── src/
│   ├── main/
│   │   ├── java/com/kevin/demo/     # 主要代码
│   │   │   ├── creational/          # 创建型模式
│   │   │   │   ├── singleton/       # 单例模式
│   │   │   │   ├── factory/         # 工厂方法模式
│   │   │   │   ├── abstractFactory/ # 抽象工厂模式
│   │   │   │   ├── builder/         # 建造者模式
│   │   │   │   └── prototype/       # 原型模式
│   │   │   ├── structural/          # 结构型模式
│   │   │   │   ├── adapter/         # 适配器模式
│   │   │   │   ├── bridge/          # 桥接模式
│   │   │   │   ├── composite/       # 组合模式
│   │   │   │   ├── decorator/       # 装饰器模式
│   │   │   │   ├── facade/          # 外观模式
│   │   │   │   ├── flyweight/       # 享元模式
│   │   │   │   └── proxy/           # 代理模式
│   │   │   └── behavioral/          # 行为型模式
│   │   │       ├── chainOfResponsibility/ # 责任链模式
│   │   │       ├── command/         # 命令模式
│   │   │       ├── interpreter/     # 解释器模式
│   │   │       ├── iterator/        # 迭代器模式
│   │   │       ├── mediator/        # 中介者模式
│   │   │       ├── memento/         # 备忘录模式
│   │   │       ├── observer/        # 观察者模式
│   │   │       ├── state/           # 状态模式
│   │   │       ├── strategy/        # 策略模式
│   │   │       ├── template/        # 模板方法模式
│   │   │       └── visitor/         # 访问者模式
│   │   └── resources/               # 资源文件
│   └── test/
│       └── java/com/kevin/demo/     # 测试代码 (80%+覆盖率)
│           ├── behavioral/          # 行为型模式测试
│           ├── creational/          # 创建型模式测试
│           └── structural/          # 结构型模式测试
├── docs/                            # 设计模式文档
│   ├── creational/                  # 创建型模式文档
│   ├── structural/                  # 结构型模式文档
│   └── behavioral/                  # 行为型模式文档
├── pom.xml                          # Maven配置文件
├── README.md                        # 项目说明文档
├── LICENSE                          # 许可证文件
├── TODO.md                          # 待优化任务列表
├── CHANGELOG.md                     # 版本更新日志
├── TESTING_SUMMARY.md               # 测试体系重构总结
└── target/site/jacoco/              # JaCoCo代码覆盖率报告

## 🧪 测试体系

### 测试覆盖范围
- **单例模式**: 饿汉式、双检锁懒汉式、枚举单例的完整测试
- **工厂模式**: 简单工厂和工厂方法模式的全面测试
- **结构型模式**: 装饰器、代理等模式的功能和特性测试
- **行为型模式**: 策略、观察者等模式的核心机制测试

### 测试特性
- ✅ **线程安全测试**: 验证多线程环境下的正确性
- ✅ **边界条件测试**: 测试null值、空值、极值等边界情况
- ✅ **异常处理测试**: 验证异常情况的正确处理
- ✅ **性能测试**: 部分关键模式的性能验证
- ✅ **反射攻击防护测试**: 单例模式的安全性验证
- ✅ **序列化测试**: 单例模式序列化安全性

### 代码质量工具
- **JaCoCo**: 代码覆盖率分析 (目标80%+)
- **Checkstyle**: 代码风格检查
- **PMD**: 代码质量分析
- **SpotBugs**: 潜在bug检测
```

### 设计模式组织方式

每个设计模式目录通常包含以下内容：
- `goodExample/` - 推荐的实现方式
- `badExample/` - 不推荐的实现方式（用于对比学习）
- `App.java` - 示例应用程序
- `AppTest.java` - 单元测试

## 设计模式列表

### 创建型模式
- **单例模式 (Singleton)** - 确保一个类只有一个实例，并提供全局访问点
- **工厂方法模式 (Factory Method)** - 定义创建对象的接口，让子类决定实例化哪个类
- **抽象工厂模式 (Abstract Factory)** - 提供一个创建一系列相关或相互依赖对象的接口
- **建造者模式 (Builder)** - 将一个复杂对象的构建与它的表示分离
- **原型模式 (Prototype)** - 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象

### 结构型模式
- **适配器模式 (Adapter)** - 将一个类的接口转换成客户希望的另一个接口
- **桥接模式 (Bridge)** - 将抽象部分与它的实现部分分离，使它们都可以独立地变化
- **组合模式 (Composite)** - 将对象组合成树形结构以表示"部分-整体"的层次结构
- **装饰器模式 (Decorator)** - 动态地给一个对象添加一些额外的职责
- **外观模式 (Facade)** - 为子系统中的一组接口提供一个一致的界面
- **享元模式 (Flyweight)** - 运用共享技术有效地支持大量细粒度的对象
- **代理模式 (Proxy)** - 为其他对象提供一种代理以控制对这个对象的访问

### 行为型模式
- **责任链模式 (Chain of Responsibility)** - 使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系
- **命令模式 (Command)** - 将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化
- **解释器模式 (Interpreter)** - 给定一个语言，定义它的文法的一种表示，并定义一个解释器
- **迭代器模式 (Iterator)** - 提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露该对象的内部表示
- **中介者模式 (Mediator)** - 用一个中介对象来封装一系列的对象交互
- **备忘录模式 (Memento)** - 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态
- **观察者模式 (Observer)** - 定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新
- **状态模式 (State)** - 允许一个对象在其内部状态改变时改变它的行为
- **策略模式 (Strategy)** - 定义一系列的算法，把它们一个个封装起来，并且使它们可相互替换
- **模板方法模式 (Template Method)** - 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中
- **访问者模式 (Visitor)** - 表示一个作用于某对象结构中的各元素的操作

## 贡献指南

欢迎贡献代码或提出改进建议！请遵循以下步骤：

1. Fork 本项目
2. 创建一个新的分支 (`git checkout -b feature/improvement`)
3. 提交你的修改 (`git commit -am 'Add some improvement'`)
4. 推送到分支 (`git push origin feature/improvement`)
5. 创建一个 Pull Request

### 贡献要求

- 代码风格保持一致 (通过Checkstyle检查)
- 添加必要的Javadoc注释
- 为新功能添加单元测试 (覆盖率80%+)
- 确保所有测试通过 (`mvn test`)
- 通过代码质量检查 (`mvn pmd:check spotbugs:check`)
- 更新相关文档
- 遵循现有的测试模式和最佳实践


## 设计模式一句话归纳
设计模式是软件开发中针对常见问题的可复用解决方案，是经过反复验证的最佳实践，用于提高代码的可维护性、可扩展性和可复用性。

![设计模式示意图](./src/main/resources/one.jpg)

## 设计模式速记
- 单抽工建原
- 桥代理组装适配，享元回家装饰外观
- 访问者写好策略备忘录，观察模板迭代的状态，命令中介解释责任链

## 设计模式一文
- [项目大纲](docs/Java设计模式学习指南/outline.md) (项目大纲)
- [Java设计模式学习指南](docs/Java设计模式学习指南/Java设计模式学习指南.md) (Java设计模式学习指南)


## 设计模式导航

### 创建型模式（Creational Patterns）
- [单例模式](docs/creational/单例/singleton-pattern.md) (Singleton Pattern)
- [抽象工厂模式](docs/creational/抽象工厂/abstract-factory-pattern.md) (Abstract Factory Pattern)
- [工厂方法模式](docs/creational/工厂/factory-method-pattern.md) (Factory Method Pattern)
- [建造者模式](docs/creational/建造者/builder-pattern.md) (Builder Pattern)
- [原型模式](docs/creational/原/prototype-pattern.md) (Prototype Pattern)

### 结构型模式（Structural Patterns）
- [代理模式](docs/structural/代理/proxy-pattern.md) (Proxy Pattern)
- [桥接模式](docs/structural/桥/bridge-pattern.md) (Bridge Pattern)
- [适配器模式](docs/structural/适配/adapter-pattern.md) (Adapter Pattern)
- [外观模式](docs/structural/外观/facade-pattern.md) (Facade Pattern)
- [享元模式](docs/structural/享元/flyweight-pattern.md) (Flyweight Pattern)
- [装饰器模式](docs/structural/装饰/decorator-pattern.md) (Decorator Pattern)
- [组合模式](docs/structural/组合/composite-pattern.md) (Composite Pattern)

### 行为型模式（Behavioral Patterns）
- [访问者模式](docs/behavioral/访问者/visitor-pattern.md) (Visitor Pattern)
- [策略模式](docs/behavioral/策略/strategy-pattern.md) (Strategy Pattern)
- [备忘录模式](docs/behavioral/备忘录/memento-pattern.md) (Memento Pattern)
- [观察者模式](docs/behavioral/观察者/observer-pattern.md) (Observer Pattern)
- [模板方法模式](docs/behavioral/模板/template-method-pattern.md) (Template Method Pattern)
- [迭代器模式](docs/behavioral/迭代/iterator-pattern.md) (Iterator Pattern)
- [状态模式](docs/behavioral/状态/state-pattern.md) (State Pattern)
- [命令模式](docs/behavioral/命令/command-pattern.md) (Command Pattern)
- [中介者模式](docs/behavioral/中介/mediator-pattern.md) (Mediator Pattern)
- [解释器模式](docs/behavioral/解释/interpreter-pattern.md) (Interpreter Pattern)
- [责任链模式](docs/behavioral/责任链/chain-of-responsibility-pattern.md) (Chain of Responsibility Pattern)

## 设计模式学习路径

为了帮助您更有效地学习设计模式，我们推荐以下学习路径：

### 入门阶段（基础模式）
1. **单例模式** - 最基础的设计模式，理解全局唯一实例的概念
2. **工厂方法模式** - 理解对象创建的封装和多态
3. **策略模式** - 理解算法的封装和替换
4. **观察者模式** - 理解对象间的通信机制
5. **装饰器模式** - 理解动态扩展对象功能的方式

### 进阶阶段（常用模式）
6. **抽象工厂模式** - 学习产品族的创建
7. **建造者模式** - 学习复杂对象的构建
8. **原型模式** - 学习对象的复制
9. **代理模式** - 学习对象访问的控制
10. **外观模式** - 学习简化复杂系统的使用

### 高级阶段（复杂模式）
11. **命令模式** - 学习请求的封装和处理
12. **状态模式** - 学习对象状态与行为的关系
13. **责任链模式** - 学习请求的链式处理
14. **迭代器模式** - 学习集合的遍历
15. **模板方法模式** - 学习算法骨架的定义

### 专家阶段（特殊场景模式）
16. **桥接模式** - 学习多维度扩展的处理
17. **适配器模式** - 学习接口不兼容的处理
18. **享元模式** - 学习对象的共享
19. **组合模式** - 学习树形结构的处理
20. **备忘录模式** - 学习状态的保存和恢复

### 大师阶段（高级应用模式）
21. **中介者模式** - 学习对象间交互的协调
22. **解释器模式** - 学习特定语言的解释
23. **访问者模式** - 学习对象结构的操作

### 学习建议
- 每个模式学习时间建议：1-2天
- 先理解概念，再看代码实现
- 尝试自己实现每个模式
- 思考每个模式的适用场景
- 对比相似模式的区别和联系

通过以上路径学习，您将逐步掌握23种经典设计模式，提高您的软件设计能力。

## 23种设计模式概述

### 创建型模式

#### 1. 单例模式（Singleton Pattern）
- **定义**：确保一个类只有一个实例，并提供全局访问点
- **使用场景**：需要全局唯一实例，如配置管理、日志记录等
- **框架应用**：
  - JDK：Runtime、Desktop
  - Spring：ApplicationContext、BeanFactory
  - Spring Boot：SpringApplication、DataSource
- **解决问题**：避免重复创建对象，节约资源
- **自身问题**：线程安全问题、难以测试、违反单一职责原则

#### 2. 抽象工厂模式（Abstract Factory Pattern）
- **定义**：提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类
- **使用场景**：需要创建多个相关产品族时
- **框架应用**：
  - JDK：java.sql.DriverManager
  - Spring：org.springframework.beans.factory.BeanFactory
  - Spring Boot：自动配置类
- **解决问题**：隔离具体类的生成，支持产品族的切换
- **自身问题**：产品族扩展困难

#### 3. 工厂方法模式（Factory Method Pattern）
- **定义**：定义一个创建对象的接口，但让子类决定实例化哪个类
- **使用场景**：需要灵活创建对象，不希望客户端依赖具体类
- **框架应用**：
  - JDK：java.util.Calendar.getInstance()
  - Spring：org.springframework.beans.factory.FactoryBean
  - Spring Boot：@Bean注解
- **解决问题**：解耦产品创建和使用，支持扩展
- **自身问题**：增加类的数量

#### 4. 建造者模式（Builder Pattern）
- **定义**：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
- **使用场景**：创建复杂对象，参数多且可选
- **框架应用**：
  - JDK：java.lang.StringBuilder
  - Spring：org.springframework.web.client.RestTemplate
  - Spring Boot：SpringApplicationBuilder
- **解决问题**：解决复杂对象构造参数过多的问题，提高代码可读性
- **自身问题**：增加类的数量，构建过程复杂

#### 5. 原型模式（Prototype Pattern）
- **定义**：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
- **使用场景**：创建对象成本高，或需要动态生成对象
- **框架应用**：
  - JDK：java.lang.Object.clone()
  - Spring：org.springframework.beans.factory.config.BeanDefinition
  - Spring Boot：@ConfigurationProperties
- **解决问题**：减少对象创建开销，支持动态配置
- **自身问题**：深拷贝实现复杂

### 结构型模式

#### 6. 代理模式（Proxy Pattern）
- **定义**：为其他对象提供一种代理以控制对这个对象的访问
- **使用场景**：需要控制对象访问、增强功能、远程访问等
- **框架应用**：
  - JDK：java.lang.reflect.Proxy
  - Spring：AOP切面、@Transactional
  - Spring Boot：Spring Boot Actuator
- **解决问题**：解耦客户端和目标对象，增强功能
- **自身问题**：增加调用层级，可能影响性能

#### 7. 桥接模式（Bridge Pattern）
- **定义**：将抽象部分与实现部分分离，使它们都可以独立地变化
- **使用场景**：需要避免抽象和实现之间的永久绑定
- **框架应用**：
  - JDK：java.sql.Driver
  - Spring：org.springframework.jdbc.core.JdbcTemplate
  - Spring Boot：多数据源配置
- **解决问题**：解决类爆炸问题，支持多维度扩展
- **自身问题**：增加系统复杂度

#### 8. 适配器模式（Adapter Pattern）
- **定义**：将一个类的接口转换成客户希望的另一个接口
- **使用场景**：需要复用现有类，但接口不匹配
- **框架应用**：
  - JDK：java.io.InputStreamReader
  - Spring：org.springframework.web.servlet.HandlerAdapter
  - Spring Boot：Spring Boot Starter
- **解决问题**：复用现有代码，解决接口不兼容问题
- **自身问题**：增加系统复杂度，降低代码可读性

#### 9. 外观模式（Facade Pattern）
- **定义**：为子系统中的一组接口提供一个一致的界面
- **使用场景**：需要简化复杂子系统的使用
- **框架应用**：
  - JDK：java.net.URL
  - Spring：org.springframework.context.ApplicationContext
  - Spring Boot：Spring Boot AutoConfiguration
- **解决问题**：简化客户端与子系统的交互，降低耦合度
- **自身问题**：可能成为系统的单一入口点

#### 10. 享元模式（Flyweight Pattern）
- **定义**：运用共享技术有效地支持大量细粒度的对象
- **使用场景**：需要创建大量相似对象，且内存资源有限
- **框架应用**：
  - JDK：java.lang.Integer.valueOf()
  - Spring：org.springframework.beans.factory.support.DefaultListableBeanFactory
  - Spring Boot：单例Bean管理
- **解决问题**：减少对象创建，节约内存资源
- **自身问题**：增加系统复杂度，需要维护对象池

#### 11. 装饰器模式（Decorator Pattern）
- **定义**：动态地给一个对象添加一些额外的职责
- **使用场景**：需要动态扩展对象功能，且不希望通过继承实现
- **框架应用**：
  - JDK：java.io.BufferedReader
  - Spring：org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
  - Spring Boot：Filter链
- **解决问题**：动态扩展功能，符合开闭原则
- **自身问题**：增加类的数量，可能导致设计复杂

#### 12. 组合模式（Composite Pattern）
- **定义**：将对象组合成树形结构以表示部分-整体的层次结构
- **使用场景**：需要处理部分-整体层次结构，且希望统一对待叶子节点和组合节点
- **框架应用**：
  - JDK：java.awt.Container
  - Spring：org.springframework.context.ApplicationContext
  - Spring Boot：配置文件加载
- **解决问题**：统一处理树状结构中的对象
- **自身问题**：设计复杂，限制类型

### 行为型模式

#### 13. 访问者模式（Visitor Pattern）
- **定义**：表示一个作用于某对象结构中的各元素的操作
- **使用场景**：需要对复杂对象结构进行操作，且操作不改变对象结构
- **框架应用**：
  - JDK：java.nio.file.FileVisitor
  - Spring：org.springframework.beans.factory.config.BeanDefinitionVisitor
  - Spring Boot：ConditionEvaluator
- **解决问题**：分离对象结构和操作，方便添加新操作
- **自身问题**：增加类的数量，违反封装原则

#### 14. 策略模式（Strategy Pattern）
- **定义**：定义一系列算法，把它们一个个封装起来，并使它们可相互替换
- **使用场景**：需要在运行时切换算法
- **框架应用**：
  - JDK：java.util.Comparator
  - Spring：org.springframework.messaging.converter.MessageConverter
  - Spring Boot：多种数据源配置
- **解决问题**：避免大量if-else语句，符合开闭原则
- **自身问题**：增加类的数量，客户端需要了解策略

#### 15. 备忘录模式（Memento Pattern）
- **定义**：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态
- **使用场景**：需要保存和恢复对象状态
- **框架应用**：
  - JDK：java.io.Serializable
  - Spring：org.springframework.batch.item.ExecutionContext
  - Spring Boot：事务管理
- **解决问题**：实现状态保存和恢复，符合封装原则
- **自身问题**：可能消耗大量内存，状态管理复杂

#### 16. 观察者模式（Observer Pattern）
- **定义**：定义对象间的一对多依赖关系，当一个对象状态改变时，所有依赖它的对象都会自动收到通知并更新
- **使用场景**：需要实现事件驱动模型，状态变化通知
- **框架应用**：
  - JDK：java.util.Observer/Observable
  - Spring：ApplicationEvent/ApplicationListener
  - Spring Boot：ApplicationStartedEvent
- **解决问题**：实现松耦合的事件通知机制
- **自身问题**：可能导致循环依赖，通知顺序不确定

#### 17. 模板方法模式（Template Method Pattern）
- **定义**：定义一个算法的骨架，而将一些步骤延迟到子类中
- **使用场景**：需要定义算法骨架，允许子类定制具体步骤
- **框架应用**：
  - JDK：java.io.InputStream.read()
  - Spring：org.springframework.jdbc.core.JdbcTemplate.query()
  - Spring Boot：Spring Boot Starter
- **解决问题**：代码复用，定义算法骨架
- **自身问题**：模板方法可能变得复杂，子类数量增加

#### 18. 迭代器模式（Iterator Pattern）
- **定义**：提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示
- **使用场景**：需要遍历集合对象，且不希望暴露内部结构
- **框架应用**：
  - JDK：java.util.Iterator
  - Spring：org.springframework.core.io.support.ResourcePatternResolver
  - Spring Boot：Environment.getPropertySources()
- **解决问题**：统一集合遍历接口，隐藏内部实现
- **自身问题**：增加类的数量，遍历效率可能受影响

#### 19. 状态模式（State Pattern）
- **定义**：允许对象在内部状态改变时改变它的行为
- **使用场景**：对象行为取决于其状态，且状态变化频繁
- **框架应用**：
  - JDK：java.util.concurrent.locks.ReentrantLock
  - Spring：org.springframework.batch.core.job.flow.FlowExecutionStatus
  - Spring Boot：应用生命周期管理
- **解决问题**：避免大量if-else语句，状态转换清晰
- **自身问题**：增加类的数量，状态管理复杂

#### 20. 命令模式（Command Pattern）
- **定义**：将请求封装成一个对象，从而使你可以用不同的请求对客户进行参数化
- **使用场景**：需要支持请求的排队、记录、撤销等操作
- **框架应用**：
  - JDK：java.lang.Runnable
  - Spring：JmsTemplate、TransactionTemplate
  - Spring Boot：CommandLineRunner
- **解决问题**：解耦请求发送者和接收者，支持请求的排队和撤销
- **自身问题**：增加类的数量，可能导致系统复杂度增加

#### 21. 中介者模式（Mediator Pattern）
- **定义**：用一个中介对象来封装一系列的对象交互
- **使用场景**：对象间存在复杂的交互关系，需要解耦
- **框架应用**：
  - JDK：java.util.Timer
  - Spring：org.springframework.context.ApplicationContext
  - Spring Boot：Spring Boot Event
- **解决问题**：减少对象间的直接依赖，降低耦合度
- **自身问题**：中介者可能变得复杂，成为系统瓶颈

#### 22. 解释器模式（Interpreter Pattern）
- **定义**：给定一个语言，定义它的文法的一种表示，并定义一个解释器
- **使用场景**：需要解释特定领域的语言或表达式
- **框架应用**：
  - JDK：java.util.regex.Pattern
  - Spring：SpEL表达式
  - Spring Boot：@ConditionalOnProperty
- **解决问题**：实现特定领域语言的解释
- **自身问题**：复杂语法实现困难，性能可能不高

#### 23. 责任链模式（Chain of Responsibility Pattern）
- **定义**：使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系
- **使用场景**：需要多个对象处理同一个请求，且处理顺序不固定
- **框架应用**：
  - JDK：java.util.logging.Logger
  - Spring：HandlerInterceptor、@Transactional
  - Spring Boot：Filter链、HandlerExceptionResolver
- **解决问题**：解耦请求发送者和接收者，支持动态组合处理者
- **自身问题**：请求可能不被处理，调试困难

## 设计模式关系与总结

### 模式分类与关系

#### 创建型模式
- **共性**：解决对象创建问题
- **关系**：单例是特殊的原型，工厂方法是抽象工厂的简化，建造者关注对象的构造过程

#### 结构型模式
- **共性**：解决类或对象的组合问题
- **关系**：装饰器和代理都是包装模式，适配器和桥接都处理接口问题，组合和享元都处理对象复用

#### 行为型模式
- **共性**：解决对象间的通信问题
- **关系**：观察者和中介者都处理对象间的交互，策略和状态都处理算法变化，命令和备忘录都支持撤销操作

### 设计模式解决的核心问题

1. **创建型**：如何创建对象，控制对象的创建过程
2. **结构型**：如何组合类和对象，优化结构
3. **行为型**：如何协调对象间的交互，优化通信

### 设计模式的局限性

1. **过度设计**：简单问题使用复杂模式会增加系统复杂度
2. **性能影响**：部分模式（如代理、装饰器）会增加调用层级
3. **学习成本**：掌握23种设计模式需要大量实践
4. **维护困难**：错误使用模式会导致代码难以理解和维护

## 设计模式原则

1. **单一职责原则**：一个类只负责一个功能领域
2. **开闭原则**：对扩展开放，对修改关闭
3. **里氏替换原则**：子类可以替换父类
4. **依赖倒置原则**：依赖于抽象，不依赖于具体实现
5. **接口隔离原则**：使用多个专门的接口，而不是单一的总接口
6. **迪米特法则**：一个对象应该对其他对象有最少的了解
7. **合成复用原则**：优先使用对象组合，而不是继承

这些原则是设计模式的基础，合理运用这些原则可以提高代码的可维护性、可扩展性和可复用性。

---

## 📊 项目状态

### 版本信息
- **当前版本**: 1.0.0
- **Java版本**: 11 (LTS)
- **最后更新**: 2025年12月23日

### 项目成熟度
- ✅ **代码质量**: 企业级标准 (80%+测试覆盖率)
- ✅ **文档完整性**: 100% (23种模式完整文档)
- ✅ **技术栈现代化**: 最新LTS版本
- ✅ **测试体系**: 全面的单元测试和集成测试
- 🔄 **CI/CD**: 计划中
- 🔄 **国际化**: 计划中

### 性能指标
- **编译时间**: < 10秒
- **测试执行时间**: < 30秒
- **代码覆盖率**: 80%+
- **代码质量评分**: A级

### 路线图
- [ ] GitHub Actions CI/CD配置
- [ ] 更多设计模式变体实现
- [ ] 性能基准测试
- [ ] 在线交互式示例
- [ ] 英文文档版本
- [ ] 视频教程制作

---

**⭐ 如果这个项目对您有帮助，请给我们一个Star！**

**📧 有问题或建议？欢迎提交Issue或Pull Request！**