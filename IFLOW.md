# 设计模式学习项目 (pattern-study)

## 项目概述

这是一个全面的Java设计模式学习项目，包含了23种经典设计模式的实现和详细说明。项目基于Maven构建，使用Java 8+开发，旨在帮助开发者理解设计模式的概念、应用场景和实现方式，提高代码设计能力。

### 项目特色

- **完整的23种设计模式实现**：涵盖创建型、结构型和行为型三大类设计模式
- **详细的文档说明**：每个模式都有完整的中文文档，包含UML图、实现示例和框架应用
- **代码质量保证**：配置了Checkstyle、PMD和SpotBugs等代码质量检查工具
- **单元测试覆盖**：使用JUnit 5进行测试，部分模式包含测试用例
- **实际应用场景**：结合JDK、Spring和Spring Boot框架中的实际应用案例

## 技术栈

- **语言**: Java 8+
- **构建工具**: Maven 3.0+
- **测试框架**: JUnit 5.7.0
- **Mock框架**: Mockito 3.7.7
- **代码质量**: Checkstyle, PMD, SpotBugs

## 项目结构

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
│       └── java/com/kevin/demo/     # 测试代码
├── docs/                            # 设计模式文档
│   ├── creational/                  # 创建型模式文档
│   ├── structural/                  # 结构型模式文档
│   └── behavioral/                  # 行为型模式文档
├── pom.xml                          # Maven配置文件
├── README.md                        # 项目说明文档
├── LICENSE                          # 许可证文件
├── TODO.md                          # 待优化任务列表
└── CHANGELOG.md                     # 版本更新日志
```

## 构建和运行

### 环境要求

- JDK 8 或更高版本
- Maven 3.0 或更高版本

### 基本命令

```bash
# 编译项目
mvn clean compile

# 运行测试
mvn test

# 生成Javadoc文档
mvn javadoc:javadoc

# 代码质量检查
mvn checkstyle:check
mvn pmd:check
mvn spotbugs:check

# 打包项目
mvn clean package

# 运行特定设计模式示例（以策略模式为例）
cd src/main/java/com/kevin/demo/behavioral/strategy
javac *.java
java App
```

### 运行单个设计模式

每个设计模式目录都包含一个`App.java`类作为演示入口：

```bash
# 策略模式示例
cd src/main/java/com/kevin/demo/behavioral/strategy
java App

# 单例模式示例
cd src/main/java/com/kevin/demo/creational/singleton/eager
java App

# 工厂模式示例
cd src/main/java/com/kevin/demo/creational/factory/factoryMethod
java App
```

## 开发约定

### 代码风格

- 使用UTF-8编码
- 遵循Java标准命名规范
- 类名使用大驼峰命名法
- 方法和变量使用小驼峰命名法
- 常量使用全大写加下划线

### 文档规范

- 所有公共类和方法必须包含Javadoc注释
- 每个设计模式都有对应的详细文档
- 文档包含模式概述、结构图、实现示例和框架应用

### 测试规范

- 使用JUnit 5进行单元测试
- 测试类命名以`Test`结尾
- 测试方法使用`@Test`注解
- 重要的业务逻辑必须包含测试用例

## 设计模式速记

### 创建型模式（5种）
- **单抽工建原**：单例、抽象工厂、工厂方法、建造者、原型

### 结构型模式（7种）
- **桥代理组装适配，享元回家装饰外观**：桥接、代理、组合、适配器、享元、装饰器、外观

### 行为型模式（11种）
- **访问者写好策略备忘录，观察模板迭代的状态，命令中介解释责任链**：
  访问者、策略、备忘录、观察者、模板、迭代器、状态、命令、中介者、解释器、责任链

## 学习路径建议

### 入门阶段
1. 单例模式 - 理解全局唯一实例
2. 工厂方法模式 - 理解对象创建封装
3. 策略模式 - 理解算法封装
4. 观察者模式 - 理解事件驱动
5. 装饰器模式 - 理解动态扩展

### 进阶阶段
6. 抽象工厂模式 - 产品族创建
7. 建造者模式 - 复杂对象构建
8. 代理模式 - 访问控制
9. 模板方法模式 - 算法骨架
10. 状态模式 - 状态与行为

### 高级阶段
11. 原型模式 - 对象复制
12. 适配器模式 - 接口适配
13. 外观模式 - 系统简化
14. 责任链模式 - 请求处理
15. 命令模式 - 请求封装

### 专家阶段
16. 桥接模式 - 多维度扩展
17. 组合模式 - 树形结构
18. 迭代器模式 - 集合遍历
19. 中介者模式 - 对象协调
20. 备忘录模式 - 状态保存

### 大师阶段
21. 享元模式 - 对象共享
22. 解释器模式 - 语言解释
23. 访问者模式 - 结构操作

## 框架应用示例

### JDK中的设计模式
- **单例模式**: Runtime.getRuntime()
- **工厂方法**: Calendar.getInstance()
- **观察者模式**: java.util.Observer/Observable
- **装饰器模式**: java.io.BufferedReader
- **策略模式**: java.util.Comparator

### Spring中的设计模式
- **单例模式**: Spring Bean默认作用域
- **工厂模式**: BeanFactory
- **代理模式**: Spring AOP
- **模板方法**: JdbcTemplate
- **观察者模式**: ApplicationEvent

### Spring Boot中的设计模式
- **工厂模式**: @Bean注解
- **策略模式**: 多数据源配置
- **装饰器模式**: Filter链
- **外观模式**: Spring Boot AutoConfiguration

## 项目优化计划

根据TODO.md文件，项目有以下优化计划：

### 已完成
- ✅ 统一包名和目录结构
- ✅ 优化README.md
- ✅ 为每个设计模式添加文档
- ✅ 添加贡献指南和行为准则

### 进行中
- 🔄 完善所有类和方法的Javadoc注释
- 🔄 为所有设计模式实现添加单元测试
- 🔄 统一代码风格和命名规范

### 待完成
- ⏳ 配置代码覆盖率报告
- ⏳ 添加GitHub Actions CI/CD
- ⏳ 为每个设计模式添加多种实现变体
- ⏳ 添加UML类图和序列图
- ⏳ 创建常见问题解答(FAQ)

## 贡献指南

欢迎贡献代码或提出改进建议！请遵循以下步骤：

1. Fork 本项目
2. 创建一个新的分支 (`git checkout -b feature/improvement`)
3. 提交你的修改 (`git commit -am 'Add some improvement'`)
4. 推送到分支 (`git push origin feature/improvement`)
5. 创建一个 Pull Request

### 贡献要求

- 代码风格保持一致
- 添加必要的Javadoc注释
- 为新功能添加单元测试
- 确保所有测试通过
- 更新相关文档

## 许可证

本项目采用MIT许可证，详见[LICENSE](LICENSE)文件。

## 联系方式

如有问题或建议，请通过以下方式联系：

- 创建GitHub Issue
- 发送邮件至项目维护者
- 参与GitHub Discussions

---

**记住**: "I see and I forget, I hear and I remember, I do and I understand."

通过实践学习设计模式，才能真正掌握其精髓！