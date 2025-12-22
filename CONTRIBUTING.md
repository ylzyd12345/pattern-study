# 贡献指南

感谢您考虑为这个设计模式学习项目做出贡献！我们欢迎各种形式的贡献，包括但不限于代码提交、文档改进、bug报告和功能建议。

## 如何贡献

### 1. 报告问题或提出建议

如果您发现了bug或者有改进建议，请按照以下步骤操作：

1. 检查[Issues](https://github.com/your-username/pattern-study/issues)页面，确认您的问题或建议还没有被提出
2. 如果没有找到相关内容，创建一个新的Issue，包含以下信息：
   - 清晰的标题
   - 详细的描述
   - 如果是bug，请提供复现步骤和环境信息
   - 如果是功能建议，请说明您的需求和预期效果

### 2. 提交代码贡献

如果您想直接贡献代码，请按照以下步骤操作：

#### 环境准备

1. 确保您的开发环境满足以下要求：
   - JDK 8或更高版本
   - Maven 3.0或更高版本
   - Git

2. Fork项目到您自己的GitHub账号

3. 克隆您的Fork到本地：
   ```bash
   git clone https://github.com/your-username/pattern-study.git
   cd pattern-study
   ```

4. 创建一个新的分支用于您的贡献：
   ```bash
   git checkout -b feature/your-feature-name
   ```

#### 代码贡献指南

1. **遵循代码风格**：
   - 使用统一的代码风格（参照项目中已有的代码风格）
   - 使用有意义的类名、方法名和变量名
   - 为所有类和方法添加Javadoc注释

2. **实现功能**：
   - 确保您的代码实现了预期的功能
   - 为新功能添加单元测试
   - 确保所有测试通过（执行`mvn test`）

3. **提交代码**：
   - 编写清晰的提交信息，使用英文或中文
   - 提交格式建议：`[功能模块] 简短描述`
   - 例如：`[Singleton] 添加枚举单例实现`

   ```bash
   git add .
   git commit -m "[功能模块] 简短描述"
   git push origin feature/your-feature-name
   ```

4. **创建Pull Request**：
   - 回到GitHub，在您的Fork页面点击"New Pull Request"
   - 选择目标分支（通常是`main`）
   - 填写详细的Pull Request描述，说明您的贡献内容
   - 等待项目维护者审核您的Pull Request

### 3. 改进文档

文档改进包括：
- 更新README.md
- 完善设计模式文档
- 添加代码注释
- 翻译文档

### 4. 其他贡献

- 帮助回答Issues中的问题
- 分享项目给其他开发者
- 撰写关于项目的博客文章或教程

## 代码规范

### 命名规范

1. **包名**：使用小写字母，例如`com.kevin.demo.creational.singleton`
2. **类名**：使用驼峰命名法，首字母大写，例如`SingletonPattern`
3. **方法名**：使用驼峰命名法，首字母小写，例如`getInstance()`
4. **变量名**：使用驼峰命名法，首字母小写，例如`instance`
5. **常量名**：使用大写字母，单词间用下划线分隔，例如`MAX_COUNT`

### 代码结构

1. 每个设计模式应该有自己独立的目录
2. 分离示例代码和核心实现
3. 为每个设计模式提供至少一个`App.java`示例应用
4. 为每个设计模式提供单元测试

### Javadoc注释

为所有类、接口、方法和重要的字段添加Javadoc注释，包括：
- 功能描述
- 参数说明
- 返回值说明
- 异常说明（如果有）

例如：

```java
/**
 * 单例模式的枚举实现
 * <p>
 * 枚举单例是Java中实现单例模式的最佳方式，它天然保证了线程安全和防止反射攻击
 */
public enum EnumSingleton {
    /**
     * 枚举单例实例
     */
    INSTANCE;
    
    /**
     * 执行单例方法
     * @return 执行结果
     */
    public String execute() {
        return "Enum Singleton executed!";
    }
}
```

## 审核流程

1. 提交Pull Request后，项目维护者会进行代码审查
2. 如果需要修改，维护者会在评论中提出建议
3. 您需要根据建议进行修改并再次提交
4. 审核通过后，您的贡献将被合并到主分支

## 行为准则

请遵守项目的[Code of Conduct](CODE_OF_CONDUCT.md)，尊重其他贡献者，保持友好和专业的沟通。

## 致谢

再次感谢您的贡献！您的参与将帮助这个项目变得更好，让更多的开发者受益。

---

如果您有任何问题，可以通过Issues页面联系项目维护者。