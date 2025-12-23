# 版本更新日志

## [未发布]

### 新增功能
- 添加了完整的贡献指南 CONTRIBUTING.md
- 创建了行为准则 CODE_OF_CONDUCT.md
- 优化了 README.md，添加了详细的设计模式列表和项目结构说明

### 改进
- 统一了包名和目录结构，将中文目录名改为英文
- 优化了代码组织方式，分离了好的实现和不好的实现

## [1.0.0] - 2025-12-22

### 新增功能
- 实现了所有23种经典设计模式
- 为每种设计模式添加了示例代码
- 创建了基本的项目结构和文档
- 配置了Maven构建系统
- 添加了基本的单元测试

### 设计模式实现

#### 创建型模式
- 单例模式 (Singleton)
- 工厂方法模式 (Factory Method)
- 抽象工厂模式 (Abstract Factory)
- 建造者模式 (Builder)
- 原型模式 (Prototype)

#### 结构型模式
- 适配器模式 (Adapter)
- 桥接模式 (Bridge)
- 组合模式 (Composite)
- 装饰器模式 (Decorator)
- 外观模式 (Facade)
- 享元模式 (Flyweight)
- 代理模式 (Proxy)

#### 行为型模式
- 责任链模式 (Chain of Responsibility)
- 命令模式 (Command)
- 解释器模式 (Interpreter)
- 迭代器模式 (Iterator)
- 中介者模式 (Mediator)
- 备忘录模式 (Memento)
- 观察者模式 (Observer)
- 状态模式 (State)
- 策略模式 (Strategy)
- 模板方法模式 (Template Method)
- 访问者模式 (Visitor)

---

## 版本号说明

本项目使用语义化版本控制：
- **主版本号 (Major)**：当进行不兼容的API更改时
- **次版本号 (Minor)**：当添加向后兼容的功能时
- **修订号 (Patch)**：当进行向后兼容的错误修复时

## 更新日志格式

本更新日志遵循 [Keep a Changelog](https://keepachangelog.com/zh-CN/1.0.0/) 格式，包括以下几个部分：

- `新增功能` - 添加的新功能
- `改进` - 对现有功能的改进
- `修复` - 修复的bug
- `移除` - 移除的功能
- `废弃` - 废弃的功能
- `安全` - 安全相关的修复