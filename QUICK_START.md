# 🚀 快速开始指南

欢迎使用设计模式学习项目！本指南将帮助您快速上手。

## ⚡ 5分钟快速体验

### 1. 克隆项目
```bash
git clone https://github.com/ylzyd12345/pattern-study.git
cd pattern-study
```

### 2. 运行测试
```bash
mvn test
```

### 3. 运行示例
```bash
# 运行单例模式示例
cd src/main/java/com/kevin/demo/creational/singleton/eager
java App

# 运行策略模式示例
cd src/main/java/com/kevin/demo/behavioral/strategy
java App
```

### 4. 查看覆盖率报告
```bash
mvn jacoco:report
# 打开 target/site/jacoco/index.html
```

## 🎯 推荐学习路径

### 🌱 初学者 (第1周)
1. **单例模式** - 理解全局唯一实例
2. **工厂方法模式** - 理解对象创建封装
3. **策略模式** - 理解算法封装
4. **观察者模式** - 理解事件驱动
5. **装饰器模式** - 理解动态扩展

### 🌿 进阶者 (第2-3周)
6. **抽象工厂模式** - 产品族创建
7. **建造者模式** - 复杂对象构建
8. **代理模式** - 访问控制
9. **模板方法模式** - 算法骨架
10. **状态模式** - 状态与行为

### 🌳 高级者 (第4-6周)
11. **原型模式** - 对象复制
12. **适配器模式** - 接口适配
13. **外观模式** - 系统简化
14. **责任链模式** - 请求处理
15. **命令模式** - 请求封装

### 🌲 专家者 (第7-8周)
16. **桥接模式** - 多维度扩展
17. **组合模式** - 树形结构
18. **迭代器模式** - 集合遍历
19. **中介者模式** - 对象协调
20. **备忘录模式** - 状态保存

### 🌳 大师者 (第9-10周)
21. **享元模式** - 对象共享
22. **解释器模式** - 语言解释
23. **访问者模式** - 结构操作

## 🛠️ 开发环境设置

### IDE推荐
- **IntelliJ IDEA** - 最佳Java开发体验
- **VS Code** - 轻量级，插件丰富
- **Eclipse** - 传统Java IDE

### 必需插件
- **Lombok** - 简化Java代码
- **Checkstyle** - 代码风格检查
- **JUnit** - 单元测试
- **Maven** - 项目构建

### 快速配置
```bash
# 安装依赖
mvn clean install

# 导入IDE
# IntelliJ: File → Open → 选择项目根目录
# VS Code: 安装Java Extension Pack，打开项目根目录
```

## 📚 核心文档

| 文档 | 用途 | 链接 |
|------|------|------|
| README | 项目总览 | [README.md](README.md) |
| FAQ | 常见问题 | [FAQ.md](FAQ.md) |
| 决策树 | 选择模式 | [决策树](docs/design-pattern-decision-tree.md) |
| 性能对比 | 性能分析 | [性能对比](docs/performance-comparison.md) |
| 代码示例 | 代码导航 | [代码示例](docs/code-examples.md) |

## 🧪 测试指南

### 运行所有测试
```bash
mvn test
```

### 运行特定模式测试
```bash
mvn test -Dtest="*SingletonTest"
mvn test -Dtest="*StrategyPatternTest"
```

### 生成测试报告
```bash
mvn surefire-report:report
```

### 查看覆盖率
```bash
mvn jacoco:report
open target/site/jacoco/index.html
```

## 🐳 Docker使用

### 构建镜像
```bash
docker build -t pattern-study:1.0.0 .
```

### 运行容器
```bash
docker run -p 8080:8080 pattern-study:1.0.0
```

### 使用Docker Compose
```bash
docker-compose up -d
```

## 🔍 代码质量检查

### 运行所有检查
```bash
mvn clean verify
```

### 单独检查
```bash
mvn checkstyle:check    # 代码风格
mvn pmd:check          # 代码质量
mvn spotbugs:check     # Bug检测
```

## 🤝 贡献指南

### 1. Fork项目
```bash
# 在GitHub上点击Fork按钮
git clone https://github.com/your-username/pattern-study.git
```

### 2. 创建分支
```bash
git checkout -b feature/your-feature
```

### 3. 提交更改
```bash
git add .
git commit -m "Add your feature"
```

### 4. 推送分支
```bash
git push origin feature/your-feature
```

### 5. 创建PR
在GitHub上创建Pull Request

## 📞 获取帮助

### 📖 查看文档
- [完整文档](https://ylzyd12345.github.io/pattern-study/)
- [项目索引](INDEX.md)
- [更新日志](CHANGELOG.md)

### 💬 社区支持
- [GitHub Issues](https://github.com/ylzyd12345/pattern-study/issues)
- [GitHub Discussions](https://github.com/ylzyd12345/pattern-study/discussions)

### 📧 联系我们
- 邮箱: kevin@pattern-study.com
- 安全问题: security@pattern-study.com

## 🎉 开始您的学习之旅

现在您已经准备好开始学习设计模式了！建议从单例模式开始，按照推荐的学习路径逐步深入。

记住：**"I see and I forget, I hear and I remember, I do and I understand."**

祝您学习愉快！🚀

---

*最后更新: 2025年12月23日*