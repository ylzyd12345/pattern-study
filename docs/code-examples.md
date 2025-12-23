# 代码示例导航

## 🚀 快速开始

本文档提供了所有设计模式代码示例的快速导航，帮助您快速找到和学习感兴趣的设计模式。

---

## 📋 目录结构

```
src/main/java/com/kevin/demo/
├── creational/          # 创建型模式
│   ├── singleton/       # 单例模式
│   ├── factory/         # 工厂模式
│   ├── abstractFactory/ # 抽象工厂模式
│   ├── builder/         # 建造者模式
│   └── prototype/       # 原型模式
├── structural/          # 结构型模式
│   ├── adapter/         # 适配器模式
│   ├── bridge/          # 桥接模式
│   ├── composite/       # 组合模式
│   ├── decorator/       # 装饰器模式
│   ├── facade/          # 外观模式
│   ├── flyweight/       # 享元模式
│   └── proxy/           # 代理模式
└── behavioral/          # 行为型模式
    ├── chainOfResponsibility/ # 责任链模式
    ├── command/         # 命令模式
    ├── interpreter/     # 解释器模式
    ├── iterator/        # 迭代器模式
    ├── mediator/        # 中介者模式
    ├── memento/         # 备忘录模式
    ├── observer/        # 观察者模式
    ├── state/           # 状态模式
    ├── strategy/        # 策略模式
    ├── template/        # 模板方法模式
    └── visitor/         # 访问者模式
```

---

## 🏗️ 创建型模式

### 🔹 单例模式 (Singleton)

**路径**: `src/main/java/com/kevin/demo/creational/singleton/`

| 实现方式 | 类文件 | 特点 | 运行方式 |
|----------|--------|------|----------|
| 饿汉式 | `eager/EagerSingleton.java` | 类加载时创建，线程安全 | `cd eager && java App` |
| 懒汉式(双重检查) | `lazy/doubleCheck/DoubleCheckLazySingleton.java` | 延迟加载，线程安全 | `cd lazy/doubleCheck && java App` |
| 懒汉式(内部类) | `lazy/innerClass/HandlerLazySingleton.java` | 利用类加载机制，线程安全 | `cd lazy/innerClass && java App` |
| 枚举单例 | `enumPattern/EnumSingleton.java` | 最安全的方式，防止反射攻击 | `cd enumPattern && java App` |

**核心代码示例**:
```java
// 饿汉式单例
public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();
    
    private EagerSingleton() {}
    
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
```

### 🔹 工厂模式 (Factory)

**路径**: `src/main/java/com/kevin/demo/creational/factory/`

| 模式类型 | 类文件 | 特点 | 运行方式 |
|----------|--------|------|----------|
| 简单工厂 | `simpleFactory/CarFactory.java` | 一个工厂创建多种产品 | `cd simpleFactory && java App` |
| 工厂方法 | `factoryMethod/LogFactory.java` | 每个产品有专门工厂 | `cd factoryMethod && java App` |

**核心代码示例**:
```java
// 简单工厂
public class CarFactory {
    public static Car createCar(CarTypeEnum type) {
        switch (type) {
            case BMW: return new BMWCar();
            case BENZ: return new BENZCar();
            default: throw new IllegalArgumentException("Unknown car type");
        }
    }
}
```

### 🔹 抽象工厂模式 (Abstract Factory)

**路径**: `src/main/java/com/kevin/demo/creational/abstractFactory/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `HaierFactory.java` | 海尔产品族工厂 | `java App` |
| `HaierTV.java` | 海尔电视产品 | - |
| `HaierWasher.java` | 海尔洗衣机产品 | - |

**核心代码示例**:
```java
// 抽象工厂接口
public interface Factory {
    TV createTV();
    Washer createWasher();
}

// 具体工厂
public class HaierFactory implements Factory {
    public TV createTV() { return new HaierTV(); }
    public Washer createWasher() { return new HaierWasher(); }
}
```

### 🔹 建造者模式 (Builder)

**路径**: `src/main/java/com/kevin/demo/creational/builder/`

| 实现方式 | 类文件 | 特点 | 运行方式 |
|----------|--------|------|----------|
| 不好的例子 | `badExample/KFCDirector.java` | 传统建造者模式 | `cd badExample && java App` |
| 好的例子 | `goodExample/Person.java` | 流式API建造者 | `cd goodExample && java App` |

**核心代码示例**:
```java
// 流式API建造者
public class Person {
    private String name;
    private int age;
    private String gender;
    
    public static class Builder {
        private String name;
        private int age;
        private String gender;
        
        public Builder name(String name) { this.name = name; return this; }
        public Builder age(int age) { this.age = age; return this; }
        public Builder gender(String gender) { this.gender = gender; return this; }
        
        public Person build() { return new Person(this); }
    }
    
    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
    }
}
```

### 🔹 原型模式 (Prototype)

**路径**: `src/main/java/com/kevin/demo/creational/prototype/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `Book.java` | 可复制的书籍对象 | `java App` |

**核心代码示例**:
```java
// 实现Cloneable接口
public class Book implements Cloneable {
    private String title;
    private List<String> chapters;
    
    @Override
    public Book clone() {
        try {
            Book clone = (Book) super.clone();
            // 深拷贝
            clone.chapters = new ArrayList<>(this.chapters);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
```

---

## 🔧 结构型模式

### 🔹 适配器模式 (Adapter)

**路径**: `src/main/java/com/kevin/demo/structural/adapter/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `ThinkPadPower.java` | 适配器类 | `java App` |
| `ComputerPower.java` | 目标接口 | - |
| `CommonPower.java` | 被适配者 | - |

**核心代码示例**:
```java
// 适配器类
public class ThinkPadPower implements ComputerPower {
    private CommonPower commonPower;
    
    public ThinkPadPower(CommonPower commonPower) {
        this.commonPower = commonPower;
    }
    
    @Override
    public void supplyPower() {
        commonPower.supply20V();
    }
}
```

### 🔹 桥接模式 (Bridge)

**路径**: `src/main/java/com/kevin/demo/structural/bridge/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `WindowsOperationSystem.java` | Windows操作系统实现 | `java App` |
| `AVIVidioFile.java` | AVI视频文件实现 | - |
| `RMVBVidioFile.java` | RMVB视频文件实现 | - |

**核心代码示例**:
```java
// 抽象部分
public abstract class VidioFile {
    protected OperationSystem os;
    
    public VidioFile(OperationSystem os) {
        this.os = os;
    }
    
    public abstract void play();
}

// 实现部分
public interface OperationSystem {
    void play(String fileName);
}
```

### 🔹 组合模式 (Composite)

**路径**: `src/main/java/com/kevin/demo/structural/composite/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `Folder.java` | 文件夹节点 | `java App` |
| `File.java` | 文件节点 | - |
| `ImgFile.java` | 图片文件 | - |
| `VidioFile.java` | 视频文件 | - |

**核心代码示例**:
```java
// 组合节点
public class Folder extends FileComponent {
    private List<FileComponent> children = new ArrayList<>();
    
    public void add(FileComponent component) {
        children.add(component);
    }
    
    @Override
    public void display() {
        System.out.println("文件夹: " + name);
        for (FileComponent child : children) {
            child.display();
        }
    }
}
```

### 🔹 装饰器模式 (Decorator)

**路径**: `src/main/java/com/kevin/demo/structural/decorator/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `PhoneCall.java` | 电话基础功能 | `java App` |
| `RecordDecorator.java` | 录音装饰器 | - |
| `TranslateDecorator.java` | 翻译装饰器 | - |

**核心代码示例**:
```java
// 装饰器基类
public abstract class CallDecorator implements Call {
    protected Call call;
    
    public CallDecorator(Call call) {
        this.call = call;
    }
    
    @Override
    public void call() {
        call.call();
    }
}

// 具体装饰器
public class RecordDecorator extends CallDecorator {
    public RecordDecorator(Call call) {
        super(call);
    }
    
    @Override
    public void call() {
        System.out.println("开始录音...");
        super.call();
        System.out.println("录音结束");
    }
}
```

### 🔹 外观模式 (Facade)

**路径**: `src/main/java/com/kevin/demo/structural/facade/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `CmfFacade.java` | 积分系统外观 | `java App` |
| `CmfPoint.java` | 积分子系统 | - |
| `CmfLevel.java` | 等级子系统 | - |
| `CmfCommon.java` | 公共子系统 | - |

**核心代码示例**:
```java
// 外观类
public class CmfFacade {
    private CmfPoint pointSystem;
    private CmfLevel levelSystem;
    private CmfCommon commonSystem;
    
    public CmfFacade() {
        this.pointSystem = new CmfPoint();
        this.levelSystem = new CmfLevel();
        this.commonSystem = new CmfCommon();
    }
    
    public void userLogin(String userId) {
        commonSystem.login(userId);
        levelSystem.updateLevel(userId);
        pointSystem.addPoint(userId, 10);
    }
}
```

### 🔹 享元模式 (Flyweight)

**路径**: `src/main/java/com/kevin/demo/structural/flyweight/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `ShapeFactory.java` | 形状工厂 | `java App` |
| `CircleShape.java` | 圆形享元对象 | - |
| `Shape.java` | 享元接口 | - |

**核心代码示例**:
```java
// 享元工厂
public class ShapeFactory {
    private static final Map<String, Shape> circleMap = new HashMap<>();
    
    public static Shape getCircle(String color) {
        CircleShape circle = (CircleShape) circleMap.get(color);
        
        if (circle == null) {
            circle = new CircleShape(color);
            circleMap.put(color, circle);
            System.out.println("创建圆形，颜色: " + color);
        }
        return circle;
    }
}
```

### 🔹 代理模式 (Proxy)

**路径**: `src/main/java/com/kevin/demo/structural/proxy/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `PlayGameProxy.java` | 游戏代理 | `java App` |
| `BabyPlayGame.java` | 真实游戏对象 | - |
| `PlayGame.java` | 游戏接口 | - |

**核心代码示例**:
```java
// 代理类
public class PlayGameProxy implements PlayGame {
    private BabyPlayGame babyPlayGame;
    
    @Override
    public void play() {
        if (babyPlayGame == null) {
            babyPlayGame = new BabyPlayGame();
        }
        
        System.out.println("代理开始：检查时间...");
        if (System.currentTimeMillis() % 2 == 0) {
            babyPlayGame.play();
        } else {
            System.out.println("代理结束：时间不对，不能玩游戏");
        }
    }
}
```

---

## 🎭 行为型模式

### 🔹 责任链模式 (Chain of Responsibility)

**路径**: `src/main/java/com/kevin/demo/behavioral/chainOfResponsibility/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `Handler.java` | 处理器抽象类 | `java App` |
| `AuthHandler.java` | 认证处理器 | - |
| `PrintHandler.java` | 打印处理器 | - |
| `AliasHandler.java` | 别名处理器 | - |

**核心代码示例**:
```java
// 处理器抽象类
public abstract class Handler {
    protected Handler nextHandler;
    
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    public abstract void handleRequest(String request);
}

// 具体处理器
public class AuthHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.contains("auth")) {
            System.out.println("AuthHandler处理认证请求");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
```

### 🔹 命令模式 (Command)

**路径**: `src/main/java/com/kevin/demo/behavioral/command/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `Command.java` | 命令接口 | `java App` |
| `TVOpenCommand.java` | 开电视命令 | - |
| `TVCloseCommand.java` | 关电视命令 | - |
| `TVControl.java` | 命令调用者 | - |

**核心代码示例**:
```java
// 命令接口
public interface Command {
    void execute();
}

// 具体命令
public class TVOpenCommand implements Command {
    private Televation televation;
    
    public TVOpenCommand(Televation televation) {
        this.televation = televation;
    }
    
    @Override
    public void execute() {
        televation.open();
    }
}

// 调用者
public class TVControl {
    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void execute() {
        command.execute();
    }
}
```

### 🔹 解释器模式 (Interpreter)

**路径**: `src/main/java/com/kevin/demo/behavioral/interpreter/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `Expression.java` | 表达式接口 | `java App` |
| `And.java` | 与表达式 | - |
| `Or.java` | 或表达式 | - |
| `Not.java` | 非表达式 | - |
| `Variable.java` | 变量表达式 | - |

**核心代码示例**:
```java
// 表达式接口
public interface Expression {
    boolean interpret(Context context);
}

// 与表达式
public class And implements Expression {
    private Expression left;
    private Expression right;
    
    public And(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public boolean interpret(Context context) {
        return left.interpret(context) && right.interpret(context);
    }
}
```

### 🔹 迭代器模式 (Iterator)

**路径**: `src/main/java/com/kevin/demo/behavioral/iterator/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `Iterator.java` | 迭代器接口 | `java App` |
| `GameIterator.java` | 游戏迭代器 | - |
| `GameTeam.java` | 游戏团队 | - |
| `Member.java` | 团队成员 | - |

**核心代码示例**:
```java
// 迭代器接口
public interface Iterator<T> {
    boolean hasNext();
    T next();
}

// 具体迭代器
public class GameIterator implements Iterator<Member> {
    private Member[] members;
    private int position = 0;
    
    public GameIterator(Member[] members) {
        this.members = members;
    }
    
    @Override
    public boolean hasNext() {
        return position < members.length && members[position] != null;
    }
    
    @Override
    public Member next() {
        return members[position++];
    }
}
```

### 🔹 中介者模式 (Mediator)

**路径**: `src/main/java/com/kevin/demo/behavioral/mediator/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `ChatRoomMediator.java` | 聊天室中介者接口 | `java App` |
| `ConcreteChatRoom.java` | 具体聊天室 | - |
| `User.java` | 用户类 | - |

**核心代码示例**:
```java
// 中介者接口
public interface ChatRoomMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

// 具体中介者
public class ConcreteChatRoom implements ChatRoomMediator {
    private List<User> users = new ArrayList<>();
    
    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receive(message);
            }
        }
    }
    
    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
```

### 🔹 备忘录模式 (Memento)

**路径**: `src/main/java/com/kevin/demo/behavioral/memento/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `Memento.java` | 备忘录接口 | `java App` |
| `Role.java` | 发起人角色 | - |
| `Caretaker.java` | 管理者 | - |

**核心代码示例**:
```java
// 备忘录接口
public interface Memento {
    String getState();
    void setState(String state);
}

// 发起人
public class Role {
    private String state;
    
    public Memento createMemento() {
        return new RoleMemento(state);
    }
    
    public void restoreFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}
```

### 🔹 观察者模式 (Observer)

**路径**: `src/main/java/com/kevin/demo/behavioral/observer/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `WeatherStation.java` | 天气站(主题) | `java App` |
| `WeatherSite.java` | 天气网站(观察者) | - |
| `WeatherApp.java` | 天气应用(观察者) | - |

**核心代码示例**:
```java
// 主题接口
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// 具体主题
public class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
```

### 🔹 状态模式 (State)

**路径**: `src/main/java/com/kevin/demo/behavioral/state/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `Account.java` | 账户上下文 | `java App` |
| `NormalState.java` | 正常状态 | - |
| `OverdraftState.java` | 透支状态 | - |
| `RestrictedState.java` | 受限状态 | - |

**核心代码示例**:
```java
// 状态接口
public interface AccountState {
    void deposit(Account account, double amount);
    void withdraw(Account account, double amount);
}

// 具体状态
public class NormalState implements AccountState {
    @Override
    public void withdraw(Account account, double amount) {
        account.setBalance(account.getBalance() - amount);
        if (account.getBalance() < 0) {
            account.setState(new OverdraftState());
        }
    }
}
```

### 🔹 策略模式 (Strategy)

**路径**: `src/main/java/com/kevin/demo/behavioral/strategy/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `PointCalc.java` | 积分计算策略接口 | `java App` |
| `FullGivePointCalc.java` | 满赠策略 | - |
| `ConstantPointCalc.java` | 固定策略 | - |
| `PointGiveService.java` | 积分服务 | - |

**核心代码示例**:
```java
// 策略接口
public interface PointCalc {
    int calcPoint(int amount);
}

// 具体策略
public class FullGivePointCalc implements PointCalc {
    @Override
    public int calcPoint(int amount) {
        if (amount >= 100) {
            return amount / 100 * 10;
        }
        return 0;
    }
}

// 上下文
public class PointGiveService {
    private PointCalc pointCalc;
    
    public void setPointCalc(PointCalc pointCalc) {
        this.pointCalc = pointCalc;
    }
    
    public int givePoint(int amount) {
        return pointCalc.calcPoint(amount);
    }
}
```

### 🔹 模板方法模式 (Template Method)

**路径**: `src/main/java/com/kevin/demo/behavioral/template/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `BasePointGiveAction.java` | 积分赠送模板 | `java App` |
| `HKPointGiveAction.java` | 香港积分赠送 | - |
| `AbstractPointGiveAction.java` | 抽象积分赠送 | - |

**核心代码示例**:
```java
// 模板类
public abstract class AbstractPointGiveAction {
    
    public void givePoint(User user, int amount) {
        // 算法骨架
        checkUser(user);
        int actualAmount = calculateAmount(amount);
        addPoint(user, actualAmount);
        sendMessage(user, actualAmount);
    }
    
    // 基本方法
    private void checkUser(User user) {
        // 检查用户
    }
    
    // 钩子方法
    protected abstract int calculateAmount(int amount);
    
    // 基本方法
    private void addPoint(User user, int amount) {
        // 添加积分
    }
    
    // 钩子方法
    protected abstract void sendMessage(User user, int amount);
}
```

### 🔹 访问者模式 (Visitor)

**路径**: `src/main/java/com/kevin/demo/behavioral/visitor/`

| 类文件 | 功能 | 运行方式 |
|--------|------|----------|
| `Person.java` | 访问者接口 | `java App` |
| `Police.java` | 警察访问者 | - |
| `Thief.java` | 小偷访问者 | - |
| `Door.java` | 门元素 | - |
| `Chimney.java` | 烟囱元素 | - |

**核心代码示例**:
```java
// 访问者接口
public interface Person {
    void visit(Door door);
    void visit(Chimney chimney);
}

// 具体访问者
public class Police implements Person {
    @Override
    public void visit(Door door) {
        System.out.println("警察检查门");
    }
    
    @Override
    public void visit(Chimney chimney) {
        System.out.println("警察检查烟囱");
    }
}

// 元素接口
public interface Openable {
    void accept(Person person);
}

// 具体元素
public class Door implements Openable {
    @Override
    public void accept(Person person) {
        person.visit(this);
    }
}
```

---

## 🧪 测试代码导航

### 测试代码结构

```
src/test/java/com/kevin/demo/
├── BasePatternTest.java          # 测试基类
├── creational/                   # 创建型模式测试
├── structural/                   # 结构型模式测试
└── behavioral/                   # 行为型模式测试
```

### 运行单个测试

```bash
# 运行所有测试
mvn test

# 运行特定模式测试
mvn test -Dtest="*SingletonTest"
mvn test -Dtest="*StrategyPatternTest"

# 运行特定包的测试
mvn test -Dtest="com.kevin.demo.creational.singleton.*"

# 生成测试报告
mvn surefire-report:report

# 查看覆盖率
mvn jacoco:report
```

---

## 🔧 开发工具

### IDE配置

**IntelliJ IDEA**:
1. 启用注解处理器 (Lombok)
2. 配置代码格式化规则
3. 导入Checkstyle和PMD配置

**Eclipse**:
1. 安装Lombok插件
2. 导入Maven项目
3. 配置代码格式化

### 调试技巧

```java
// 在App.java中添加断点调试
public class App {
    public static void main(String[] args) {
        // 在这里设置断点
        Singleton instance = Singleton.getInstance();
        instance.doSomething();
    }
}
```

---

## 📚 学习建议

### 🎯 学习路径

1. **初学者**: 单例 → 工厂 → 策略 → 观察者 → 装饰器
2. **进阶者**: 抽象工厂 → 建造者 → 代理 → 模板方法 → 状态
3. **高级者**: 原型 → 适配器 → 桥接 → 命令 → 访问者
4. **专家者**: 组合 → 外观 → 享元 → 责任链 → 中介者 → 备忘录 → 解释器 → 迭代器

### 🛠️ 实践方法

1. **阅读代码**: 理解每个模式的实现方式
2. **运行示例**: 观察程序的执行过程
3. **修改代码**: 尝试改变实现细节
4. **编写测试**: 验证对模式的理解
5. **实际应用**: 在项目中使用模式

### 📖 扩展阅读

- [设计模式决策树](design-pattern-decision-tree.md)
- [性能对比分析](performance-comparison.md)
- [常见问题解答](../FAQ.md)
- [更新日志](../CHANGELOG.md)

---

## 🔗 相关链接

- [GitHub仓库](https://github.com/ylzyd12345/pattern-study)
- [在线文档](https://ylzyd12345.github.io/pattern-study/)
- [问题反馈](https://github.com/ylzyd12345/pattern-study/issues)
- [讨论区](https://github.com/ylzyd12345/pattern-study/discussions)

---

*最后更新: 2025年12月23日*