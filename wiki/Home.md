# 设计模式学习项目 Wiki

欢迎来到设计模式学习项目的Wiki页面！这里提供了项目的详细文档、学习指南和最佳实践。

## 📚 目录

### 快速开始
- [项目简介](#项目简介)
- [环境配置](#环境配置)
- [快速运行](#快速运行)

### 学习资源
- [设计模式概述](设计模式概述)
- [学习路径建议](学习路径建议)
- [常见问题解答](常见问题解答)

### 设计模式详解
- [创建型模式](创建型模式)
- [结构型模式](结构型模式)
- [行为型模式](行为型模式)

### 进阶内容
- [模式对比分析](模式对比分析)
- [性能测试报告](性能测试报告)
- [实际应用案例](实际应用案例)

## 项目简介

本项目是一个全面的Java设计模式学习资源，包含23种经典GoF设计模式的完整实现。每个模式都配有：
- 📖 详细的中文文档
- 💻 完整的Java代码实现
- 🧪 单元测试用例
- 🎯 实际应用场景
- 📊 UML类图

### 项目特色

- **完整性**: 涵盖所有23种经典设计模式
- **实用性**: 结合JDK、Spring等框架的实际应用
- **可读性**: 详细的中文注释和文档
- **可运行性**: 每个模式都有独立的演示程序

## 环境配置

### 系统要求
- JDK 8 或更高版本
- Maven 3.0 或更高版本
- IDE（推荐IntelliJ IDEA或Eclipse）

### 快速配置
```bash
# 克隆项目
git clone https://github.com/ylzyd12345/pattern-study.git
cd pattern-study

# 编译项目
mvn clean compile

# 运行测试
mvn test
```

## 快速运行

每个设计模式都有独立的演示程序：

```bash
# 运行单例模式示例
cd src/main/java/com/kevin/demo/creational/singleton/eager
java App

# 运行策略模式示例
cd src/main/java/com/kevin/demo/behavioral/strategy
java App
```

## 学习建议

### 初学者路径
1. **单例模式** - 理解对象创建控制
2. **工厂方法模式** - 学习对象创建封装
3. **策略模式** - 掌握算法族封装
4. **观察者模式** - 理解事件驱动机制
5. **装饰器模式** - 学习动态功能扩展

### 进阶学习者
- 深入理解每个模式的适用场景
- 对比相似模式的差异
- 学习模式在框架中的应用
- 实践反模式识别

## 贡献指南

欢迎为项目贡献力量！请查看：
- [贡献指南](https://github.com/ylzyd12345/pattern-study/blob/main/CONTRIBUTING.md)
- [行为准则](https://github.com/ylzyd12345/pattern-study/blob/main/CODE_OF_CONDUCT.md)

## 联系方式

- 📧 邮箱: 项目维护者
- 🐛 问题反馈: [GitHub Issues](https://github.com/ylzyd12345/pattern-study/issues)
- 💬 讨论: [GitHub Discussions](https://github.com/ylzyd12345/pattern-study/discussions)

---

**记住**: "I see and I forget, I hear and I remember, I do and I understand."

通过实践学习设计模式，才能真正掌握其精髓！