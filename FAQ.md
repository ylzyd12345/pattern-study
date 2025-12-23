# 设计模式学习项目 FAQ

## 📚 学习相关

### Q: 我是初学者，应该从哪个设计模式开始学习？
**A**: 推荐按照以下学习路径开始：

1. **入门阶段** (1-2周):
   - 单例模式 - 理解全局唯一实例
   - 工厂方法模式 - 理解对象创建封装
   - 策略模式 - 理解算法封装
   - 观察者模式 - 理解事件驱动
   - 装饰器模式 - 理解动态扩展

2. **进阶阶段** (2-3周):
   - 抽象工厂模式 - 产品族创建
   - 建造者模式 - 复杂对象构建
   - 代理模式 - 访问控制
   - 模板方法模式 - 算法骨架
   - 状态模式 - 状态与行为

3. **高级阶段** (3-4周):
   - 原型模式 - 对象复制
   - 适配器模式 - 接口适配
   - 外观模式 - 系统简化
   - 责任链模式 - 请求处理
   - 命令模式 - 请求封装

### Q: 如何运行单个设计模式的示例？
**A**: 每个设计模式目录都有App.java作为演示入口：

```bash
# 例如运行策略模式
cd src/main/java/com/kevin/demo/behavioral/strategy
javac *.java
java App
```

或者使用Maven：
```bash
mvn exec:java -Dexec.mainClass="com.kevin.demo.behavioral.strategy.App"
```

### Q: 如何运行测试？
**A**: 使用以下命令运行所有测试：
```bash
mvn test
```

运行特定模式的测试：
```bash
mvn test -Dtest="*StrategyPatternTest"
```

生成测试覆盖率报告：
```bash
mvn jacoco:report
```

## 🔧 技术相关

### Q: 项目支持哪些Java版本？
**A**: 项目支持以下Java版本：
- **主要支持**: Java 11 LTS
- **兼容测试**: Java 8, 17, 21
- **推荐使用**: Java 11 或 17 LTS

### Q: 如何在IDE中导入项目？
**A**: 

**IntelliJ IDEA**:
1. File → Open → 选择项目根目录
2. 等待Maven依赖下载完成
3. 项目会自动识别为Maven项目

**Eclipse**:
1. File → Import → Existing Maven Projects
2. 选择项目根目录
3. 完成导入

**VS Code**:
1. 安装Java Extension Pack扩展
2. 打开项目根目录
3. 安装推荐的Java扩展

### Q: 如何解决编译错误？
**A**: 常见解决方案：

1. **检查Java版本**:
   ```bash
   java -version
   mvn -version
   ```

2. **清理并重新构建**:
   ```bash
   mvn clean compile
   ```

3. **更新Maven依赖**:
   ```bash
   mvn dependency:resolve
   ```

4. **检查网络连接**（某些依赖需要从远程仓库下载）

### Q: 如何配置代码格式化工具？
**A**: 项目已配置以下代码质量工具：

- **Checkstyle**: 代码风格检查
- **PMD**: 代码质量分析
- **SpotBugs**: 潜在bug检测

运行检查：
```bash
mvn checkstyle:check
mvn pmd:check
mvn spotbugs:check
```

## 📖 设计模式相关

### Q: 单例模式有哪些实现方式？
**A**: 项目中实现了以下单例模式：

1. **饿汉式**: 类加载时创建实例
2. **懒汉式**: 延迟加载，需要考虑线程安全
3. **双重检查锁**: 平衡性能和线程安全
4. **静态内部类**: 利用类加载机制保证线程安全
5. **枚举单例**: 最安全的实现方式

### Q: 工厂模式和抽象工厂模式有什么区别？
**A**: 主要区别：

| 特性 | 工厂模式 | 抽象工厂模式 |
|------|----------|--------------|
| 目的 | 创建一个产品 | 创建产品族 |
| 复杂度 | 简单 | 复杂 |
| 扩展性 | 易于添加新产品 | 易于添加新产品族 |
| 使用场景 | 单一产品创建 | 相关产品组合创建 |

### Q: 什么时候应该使用装饰器模式？
**A**: 适用场景：

- ✅ 需要动态添加对象功能
- ✅ 不希望通过继承扩展功能
- ✅ 需要组合多个功能
- ✅ 功能可以随意组合

**实际例子**:
- Java I/O流 (BufferedReader, InputStreamReader)
- GUI组件的装饰
- 数据处理的管道

### Q: 观察者模式和发布订阅模式有什么区别？
**A**: 主要区别：

| 特性 | 观察者模式 | 发布订阅模式 |
|------|------------|--------------|
| 耦合度 | 紧耦合 | 松耦合 |
| 通信方式 | 直接调用 | 通过消息队列 |
| 同步性 | 通常同步 | 通常异步 |
| 复杂度 | 简单 | 复杂 |

## 🧪 测试相关

### Q: 如何理解测试覆盖率报告？
**A**: 覆盖率报告位于 `target/site/jacoco/index.html`：

- **指令覆盖率**: 执行的字节码指令比例
- **分支覆盖率**: 条件分支的执行比例
- **行覆盖率**: 执行的代码行比例
- **方法覆盖率**: 调用的方法比例

目标：整体覆盖率80%+，关键方法90%+

### Q: 如何编写好的单元测试？
**A**: 遵循FIRST原则：

- **F**ast (快速): 测试应该快速执行
- **I**solated (隔离): 测试之间应该独立
- **R**epeatable (可重复): 测试结果应该一致
- **S**elf-validating (自验证): 测试应该有明确的通过/失败结果
- **T**imely (及时): 应该及时编写测试

### Q: 如何测试单例模式的线程安全性？
**A**: 项目中使用了以下方法：

```java
@Test
void testSingletonThreadSafety() throws InterruptedException {
    int threadCount = 100;
    CountDownLatch latch = new CountDownLatch(threadCount);
    Set<Singleton> instances = ConcurrentHashMap.newKeySet();
    
    // 多线程同时获取单例
    for (int i = 0; i < threadCount; i++) {
        new Thread(() -> {
            instances.add(Singleton.getInstance());
            latch.countDown();
        }).start();
    }
    
    latch.await();
    
    // 验证所有线程获取的是同一个实例
    assertEquals(1, instances.size());
}
```

## 🐳 Docker相关

### Q: 如何使用Docker运行项目？
**A**: 使用以下命令：

```bash
# 构建Docker镜像
docker build -t pattern-study:1.0.0 .

# 运行容器
docker run -p 8080:8080 pattern-study:1.0.0

# 使用docker-compose
docker-compose up -d
```

### Q: Docker Compose包含哪些服务？
**A**: 当前配置包含：

- **pattern-study**: 主应用
- **postgres**: 数据库（可选）
- **redis**: 缓存（可选）
- **prometheus**: 监控
- **grafana**: 可视化

## 🔒 安全相关

### Q: 如何报告安全漏洞？
**A**: 请不要在公开Issue中报告安全漏洞：

1. **邮箱**: security@pattern-study.com
2. **GitHub Security**: 使用私有报告功能
3. **PGP加密**: 使用项目PGP密钥加密

详细流程请参考 [SECURITY.md](.github/SECURITY.md)

### Q: 项目如何处理依赖安全？
**A**: 项目集成了OWASP依赖检查：

```bash
mvn dependency-check:check
```

会自动扫描依赖中的已知漏洞，CVSS 7.0以上的漏洞会阻止构建。

## 🤝 贡献相关

### Q: 如何为项目贡献代码？
**A**: 请遵循以下步骤：

1. Fork项目
2. 创建功能分支
3. 编写代码和测试
4. 确保所有检查通过
5. 提交Pull Request

详细指南请参考 [CONTRIBUTING.md](CONTRIBUTING.md)

### Q: 代码风格有什么要求？
**A**: 项目使用以下工具保证代码质量：

- **Checkstyle**: 代码风格检查
- **PMD**: 代码质量分析
- **SpotBugs**: Bug检测

运行检查：
```bash
mvn clean verify
```

## 📞 获取帮助

### Q: 还有其他问题怎么办？
**A**: 可以通过以下方式获取帮助：

1. **查看文档**: [README.md](README.md)
2. **搜索Issue**: [GitHub Issues](https://github.com/ylzyd12345/pattern-study/issues)
3. **创建新Issue**: 描述你的问题
4. **参与讨论**: [GitHub Discussions](https://github.com/ylzyd12345/pattern-study/discussions)

### Q: 如何联系维护者？
**A**: 

- **GitHub**: @ylzyd12345
- **邮箱**: 通过GitHub Issues联系
- **安全问题**: security@pattern-study.com

---

## 🔗 相关资源

- [设计模式学习路径](README.md#设计模式学习路径)
- [23种设计模式概述](README.md#23种设计模式概述)
- [测试最佳实践](src/test/java/com/kevin/demo/BasePatternTest.java)
- [代码质量配置](checkstyle.xml, pmd.xml)

---

*最后更新: 2025年12月23日*