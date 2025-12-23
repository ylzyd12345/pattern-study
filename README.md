# 设计模式学习项目 (pattern-study)

[![Java](https://img.shields.io/badge/Java-11-blue.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.0%2B-green.svg)](https://maven.apache.org/)
[![JUnit](https://img.shields.io/badge/JUnit-5.10.2-orange.svg)](https://junit.org/junit5/)
[![Build Status](https://github.com/ylzyd12345/pattern-study/workflows/CI/badge.svg)](https://github.com/ylzyd12345/pattern-study/actions)
[![Test Coverage](https://img.shields.io/badge/Coverage-85%25%2B-brightgreen.svg)](https://www.jacoco.org/jacoco/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](CONTRIBUTING.md)
[![Code Quality](https://img.shields.io/badge/Code%20Quality-A-brightgreen.svg)](https://github.com/ylzyd12345/pattern-study/actions)
[![Documentation](https://img.shields.io/badge/Documentation-95%25%2B-blue.svg)](https://ylzyd12345.github.io/pattern-study/)

> "I see and I forget, I hear and I remember, **I do and I understand**."

## 📖 项目简介

这是一个全面的Java设计模式学习项目，包含23种经典GoF设计模式的完整实现和详细说明。项目基于**JDK 11**构建，采用现代化的测试体系和代码质量保证，旨在帮助开发者深入理解设计模式的概念、应用场景和实现方式。

### ✨ 核心特色

- 🏗️ **完整覆盖** - 23种经典设计模式全覆盖
- 🧪 **高质量测试** - 80%+代码覆盖率，全面的单元测试
- 📚 **详细文档** - UML图、代码示例、实际应用场景
- 🛠️ **企业级质量** - 集成多种代码质量检查工具
- 🚀 **现代化工具链** - CI/CD、自动化测试、文档部署

## 🚀 快速开始

### 环境要求

- **JDK** 11 或更高版本
- **Maven** 3.0 或更高版本
- **IDE** (推荐 IntelliJ IDEA 或 Eclipse)

### 安装运行

```bash
# 克隆项目
git clone https://github.com/ylzyd12345/pattern-study.git
cd pattern-study

# 编译项目
mvn clean compile

# 运行测试
mvn test

# 生成文档
mvn javadoc:javadoc

# 运行特定模式示例（以策略模式为例）
cd src/main/java/com/kevin/demo/behavioral/strategy
java App
```

### 🏃‍♂️ 快速体验

```bash
# 单例模式示例
cd src/main/java/com/kevin/demo/creational/singleton/eager
java App

# 工厂方法模式示例  
cd src/main/java/com/kevin/demo/creational/factory/factoryMethod
java App

# 观察者模式示例
cd src/main/java/com/kevin/demo/behavioral/observer
java App
```

## 📋 设计模式总览

### 🏗️ 创建型模式 (5种)

| 模式 | 描述 | 难度 | 应用频率 |
|------|------|------|----------|
| [单例模式](docs/creational/单例/singleton-pattern.md) | 确保类只有一个实例 | ⭐ | ⭐⭐⭐⭐⭐ |
| [工厂方法](docs/creational/工厂/factory-method-pattern.md) | 定义创建对象的接口 | ⭐⭐ | ⭐⭐⭐⭐⭐ |
| [抽象工厂](docs/creational/抽象工厂/abstract-factory-pattern.md) | 创建产品族 | ⭐⭐⭐ | ⭐⭐⭐⭐ |
| [建造者模式](docs/creational/建造者/builder-pattern.md) | 构建复杂对象 | ⭐⭐⭐ | ⭐⭐⭐ |
| [原型模式](docs/creational/原/prototype-pattern.md) | 通过复制创建对象 | ⭐⭐ | ⭐⭐⭐ |

### 🏛️ 结构型模式 (7种)

| 模式 | 描述 | 难度 | 应用频率 |
|------|------|------|----------|
| [适配器模式](docs/structural/适配/adapter-pattern.md) | 接口转换 | ⭐⭐ | ⭐⭐⭐⭐⭐ |
| [桥接模式](docs/structural/桥/bridge-pattern.md) | 分离抽象和实现 | ⭐⭐⭐ | ⭐⭐⭐ |
| [组合模式](docs/structural/组合/composite-pattern.md) | 树形结构 | ⭐⭐⭐ | ⭐⭐⭐⭐ |
| [装饰器模式](docs/structural/装饰/decorator-pattern.md) | 动态添加功能 | ⭐⭐ | ⭐⭐⭐⭐⭐ |
| [外观模式](docs/structural/外观/facade-pattern.md) | 简化复杂系统 | ⭐ | ⭐⭐⭐⭐⭐ |
| [享元模式](docs/structural/享元/flyweight-pattern.md) | 对象共享 | ⭐⭐⭐⭐ | ⭐⭐ |
| [代理模式](docs/structural/代理/proxy-pattern.md) | 控制对象访问 | ⭐⭐ | ⭐⭐⭐⭐⭐ |

### 🎭 行为型模式 (11种)

| 模式 | 描述 | 难度 | 应用频率 |
|------|------|------|----------|
| [责任链模式](docs/behavioral/责任链/chain-of-responsibility-pattern.md) | 请求链式处理 | ⭐⭐ | ⭐⭐⭐⭐ |
| [命令模式](docs/behavioral/命令/command-pattern.md) | 请求封装 | ⭐⭐ | ⭐⭐⭐⭐ |
| [解释器模式](docs/behavioral/解释/interpreter-pattern.md) | 语言解释 | ⭐⭐⭐⭐ | ⭐⭐ |
| [迭代器模式](docs/behavioral/迭代/iterator-pattern.md) | 集合遍历 | ⭐ | ⭐⭐⭐⭐⭐ |
| [中介者模式](docs/behavioral/中介/mediator-pattern.md) | 对象解耦 | ⭐⭐⭐ | ⭐⭐⭐ |
| [备忘录模式](docs/behavioral/备忘录/memento-pattern.md) | 状态保存 | ⭐⭐ | ⭐⭐⭐ |
| [观察者模式](docs/behavioral/观察者/observer-pattern.md) | 事件通知 | ⭐⭐ | ⭐⭐⭐⭐⭐ |
| [状态模式](docs/behavioral/状态/state-pattern.md) | 状态切换 | ⭐⭐⭐ | ⭐⭐⭐⭐ |
| [策略模式](docs/behavioral/策略/strategy-pattern.md) | 算法封装 | ⭐⭐ | ⭐⭐⭐⭐⭐ |
| [模板方法模式](docs/behavioral/模板/template-method-pattern.md) | 算法骨架 | ⭐⭐ | ⭐⭐⭐⭐⭐ |
| [访问者模式](docs/behavioral/访问者/visitor-pattern.md) | 结构操作 | ⭐⭐⭐⭐ | ⭐⭐ |

## 🛠️ 技术栈

| 类别 | 技术选型 | 版本 |
|------|----------|------|
| **语言** | Java | 11 LTS |
| **构建** | Maven | 3.0+ |
| **测试** | JUnit | 5.10.2 |
| **Mock** | Mockito | 5.11.0 |
| **覆盖率** | JaCoCo | 0.8.8 |
| **代码质量** | Checkstyle | 3.2.1 |
| | PMD | 3.21.0 |
| | SpotBugs | 4.7.3.0 |
| **文档** | Javadoc | - |
| **CI/CD** | GitHub Actions | - |

## 📚 学习资源

### 🎯 学习路径

1. **入门阶段** (1-2周)
   - [ ] 单例模式 - 理解全局唯一实例
   - [ ] 工厂方法模式 - 理解对象创建封装
   - [ ] 策略模式 - 理解算法封装
   - [ ] 观察者模式 - 理解事件驱动
   - [ ] 装饰器模式 - 理解动态扩展

2. **进阶阶段** (2-3周)
   - [ ] 抽象工厂模式 - 产品族创建
   - [ ] 建造者模式 - 复杂对象构建
   - [ ] 代理模式 - 访问控制
   - [ ] 模板方法模式 - 算法骨架
   - [ ] 状态模式 - 状态与行为

3. **高级阶段** (3-4周)
   - [ ] 剩余所有模式
   - [ ] 模式组合应用
   - [ ] 框架源码分析
   - [ ] 实际项目实践

### 📖 详细文档

- 📋 [设计模式概述](docs/Java设计模式学习指南/Java设计模式学习指南.md)
- 🎯 [学习路径建议](docs/Java设计模式学习指南/outline.md)
- ❓ [常见问题解答](FAQ.md)
- 🌳 [模式选择决策树](docs/design-pattern-decision-tree.md)
- 📊 [性能对比分析](docs/performance-comparison.md)
- 💻 [代码示例导航](docs/code-examples.md)
- 🛠️ [技术栈详解](docs/TECH_STACK.md)
- 🏗️ [项目结构说明](docs/PROJECT_STRUCTURE.md)
- 🤝 [贡献指南](docs/CONTRIBUTION_GUIDE.md)

## 🏗️ 项目结构

```
pattern-study/
├── 📁 src/
│   ├── 📁 main/java/com/kevin/demo/
│   │   ├── 📁 creational/          # 创建型模式
│   │   ├── 📁 structural/          # 结构型模式
│   │   └── 📁 behavioral/          # 行为型模式
│   └── 📁 test/java/               # 测试代码
├── 📁 docs/                        # 详细文档
├── 📁 .github/workflows/           # CI/CD配置
├── 📁 wiki/                        # GitHub Wiki
├── 📄 pom.xml                      # Maven配置
├── 📄 README.md                    # 项目说明
└── 📄 LICENSE                      # 开源协议
```

## 🧪 测试与质量

### 测试覆盖率

- **总体覆盖率**: 85%+
- **行覆盖率**: 87%+
- **分支覆盖率**: 83%+
- **方法覆盖率**: 90%+

### 代码质量

- ✅ **Checkstyle**: 代码风格检查通过
- ✅ **PMD**: 代码质量检查通过  
- ✅ **SpotBugs**: Bug检查通过
- ✅ **OWASP**: 安全检查通过

### CI/CD 流程

- 🔨 **多JDK版本测试**: JDK 8, 11, 17, 21
- 🧪 **自动化测试**: 单元测试 + 集成测试
- 📊 **质量检查**: 代码质量 + 安全扫描
- 📚 **文档部署**: 自动部署到GitHub Pages

## 🌟 实际应用

### JDK中的设计模式

| 模式 | JDK应用 | 示例 |
|------|---------|------|
| 单例模式 | Runtime | `Runtime.getRuntime()` |
| 工厂方法 | Calendar | `Calendar.getInstance()` |
| 观察者模式 | Event | `java.util.Observer` |
| 装饰器模式 | IO | `BufferedReader` |
| 策略模式 | Comparator | `java.util.Comparator` |

### Spring中的设计模式

| 模式 | Spring应用 | 说明 |
|------|------------|------|
| 单例模式 | Bean管理 | 默认作用域 |
| 工厂模式 | BeanFactory | 对象创建 |
| 代理模式 | AOP | 方法增强 |
| 模板方法 | JdbcTemplate | 操作模板 |
| 观察者模式 | Event | 事件机制 |

## 🤝 贡献指南

我们欢迎所有形式的贡献！

### 如何贡献

1. 🍴 **Fork** 项目
2. 🌿 **创建特性分支** (`git checkout -b feature/amazing-feature`)
3. 💾 **提交更改** (`git commit -m 'Add amazing feature'`)
4. 📤 **推送分支** (`git push origin feature/amazing-feature`)
5. 🔃 **创建 Pull Request**

### 贡献类型

- 🐛 **Bug修复** - 发现并修复问题
- ✨ **新功能** - 添加新的设计模式实现
- 📚 **文档改进** - 完善文档和注释
- 🧪 **测试增强** - 提高测试覆盖率
- 🛠️ **工具优化** - 改进构建和CI流程

### 开发规范

- 📝 **代码风格**: 遵循项目代码规范
- 🧪 **测试要求**: 新功能必须包含测试
- 📖 **文档要求**: 重要代码需要注释
- 🔍 **代码审查**: 所有PR需要通过审查

## 📄 许可证

本项目采用 [MIT License](LICENSE) 开源协议。

## 🙏 致谢

感谢以下项目和资源：

- [java-design-patterns](https://github.com/iluwatar/java-design-patterns) - 优秀的设计模式实现参考
- [Refactoring.guru](https://refactoring.guru/) - 设计模式图解教程
- 《设计模式：可复用面向对象软件的基础》- GoF经典著作
- 《Head First设计模式》- 入门最佳书籍

## 📞 联系我们

- 📧 **问题反馈**: [GitHub Issues](https://github.com/ylzyd12345/pattern-study/issues)
- 💬 **讨论交流**: [GitHub Discussions](https://github.com/ylzyd12345/pattern-study/discussions)
- 📖 **项目Wiki**: [GitHub Wiki](https://github.com/ylzyd12345/pattern-study/wiki)
- 🌐 **在线文档**: [GitHub Pages](https://ylzyd12345.github.io/pattern-study/)

---

<div align="center">

**⭐ 如果这个项目对你有帮助，请给我们一个Star！⭐**

Made with ❤️ by [Kevin](https://github.com/ylzyd12345)

</div>