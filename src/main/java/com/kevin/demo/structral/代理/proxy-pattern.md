# 代理模式（Proxy Pattern）

## 1. 模式概述
代理模式是一种结构型设计模式，它为其他对象提供一种代理以控制对这个对象的访问。代理对象在客户端和目标对象之间起到中介作用。

### 1.1 核心意图
- 控制对原始对象的访问
- 为原始对象提供一个替身或占位符
- 增强原始对象的功能
- 实现客户端和目标对象之间的解耦

### 1.2 典型应用场景
- 远程代理：为远程对象提供本地代表
- 虚拟代理：根据需要创建开销很大的对象
- 保护代理：控制对原始对象的访问权限
- 智能引用：在访问对象时执行一些附加操作

## 2. 模式结构

### 2.1 角色定义

| 角色 | 职责 | 实现类 |
|------|------|--------|
| **抽象主题(Subject)** | 定义真实主题和代理主题的共同接口 | PlayGame |
| **真实主题(RealSubject)** | 实现抽象主题接口，定义真实的业务逻辑 | BabyPlayGame |
| **代理(Proxy)** | 实现抽象主题接口，持有真实主题的引用，并控制对真实主题的访问 | PlayGameProxy |
| **客户端(Client)** | 使用代理对象访问真实主题 | App |

### 2.2 结构示意图

```
┌──────────────────┐        ┌──────────────────┐
│  Subject         │        │  Proxy           │
├──────────────────┤        ├──────────────────┤
│ +request()       │        │ +request()       │
└─────────────┬────┘        └─────────────┬────┘
              │                           │
┌─────────────┴────┐            ┌─────────┴─────────┐
│ Client           │            │ RealSubject       │
├──────────────────┤            ├──────────────────┤
│ +useProxy()      │            │ +request()       │
└──────────────────┘            └──────────────────┘
```

## 3. 实现示例

### 3.1 抽象主题
```java
public interface PlayGame {
    void play(String gameName);
}
```

### 3.2 真实主题
```java
public class BabyPlayGame implements PlayGame {
    @Override
    public void play(String gameName) {
        System.out.println("ok, u can play game:" + gameName);
    }
}
```

### 3.3 代理
```java
public class PlayGameProxy implements PlayGame {
    private PlayGame playGame;
    
    public PlayGameProxy(PlayGame playGame) {
        this.playGame = playGame;
    }
    
    @Override
    public void play(String gameName) {
        // 代理逻辑：过滤不适合婴儿玩的游戏
        if (playGame instanceof BabyPlayGame) {
            if ("yellowGame".equalsIgnoreCase(gameName)) {
                System.err.println("no no no, u can't play this game!");
                return;
            }
        }
        
        // 调用真实主题的方法
        playGame.play(gameName);
    }
}
```

### 3.4 客户端代码
```java
public class App {
    public static void main(String[] args) {
        PlayGame babyGame = new BabyPlayGame();
        PlayGame proxy = new PlayGameProxy(babyGame);
        
        proxy.play("小蝌蚪找妈妈"); // 允许
        proxy.play("yellowGame"); // 被拦截
    }
}
```

## 4. 优缺点分析

### 4.1 优点
- **控制访问**：可以控制对真实对象的访问权限
- **增强功能**：可以在不修改真实对象的情况下增强其功能
- **解耦客户端和真实对象**：客户端只与代理交互，不直接访问真实对象
- **灵活性**：可以灵活地添加或移除代理功能

### 4.2 缺点
- **增加系统复杂度**：需要额外的代理类
- **可能降低性能**：代理层的存在可能会增加请求的处理时间
- **实现复杂**：某些代理模式的实现可能比较复杂

## 5. 标准化规范

### 5.1 命名规范
- 抽象主题：通常以接口功能命名
- 真实主题：以具体实现的业务名称命名
- 代理：通常以"Proxy"结尾，或包含真实主题的名称

### 5.2 代码规范
- 代理应实现与真实主题相同的接口
- 代理应持有真实主题的引用
- 代理可以在调用真实主题方法前后添加额外的逻辑
- 客户端应通过代理访问真实主题

### 5.3 最佳实践
- 当需要控制对真实对象的访问时使用代理模式
- 根据需求选择合适的代理类型（远程代理、虚拟代理、保护代理等）
- 保持代理的功能简单，专注于控制访问或增强功能

## 6. 与其他模式的比较

### 6.1 代理模式 vs 装饰器模式
- 代理模式：关注控制对对象的访问
- 装饰器模式：关注动态地为对象添加额外的功能

### 6.2 代理模式 vs 适配器模式
- 代理模式：保留原始接口，控制访问
- 适配器模式：改变接口的形式

### 6.3 代理模式 vs 外观模式
- 代理模式：代理一个单一对象
- 外观模式：为子系统提供一个统一的接口

## 7. 权威开源框架中的使用场景

### 7.1 JDK中的代理模式

1. **动态代理（java.lang.reflect.Proxy）**：
   - 提供了动态创建代理类的能力
   - 允许在运行时生成代理对象，而无需预先定义代理类
   - 示例：通过`Proxy.newProxyInstance()`方法创建实现指定接口的代理对象

2. **RMI远程代理**：
   - 为远程对象提供本地代表
   - 允许客户端透明地访问远程对象
   - 示例：`java.rmi.Remote`接口和`java.rmi.server.UnicastRemoteObject`类

3. **网络代理**：
   - 控制网络连接的访问
   - 示例：`java.net.Proxy`类和`java.net.ProxySelector`接口

### 7.2 Spring中的代理模式

1. **AOP（面向切面编程）**：
   - 使用代理模式实现横切关注点（如日志、事务、安全等）
   - 支持JDK动态代理和CGLIB代理
   - 示例：`@Aspect`注解和相关的AOP切面配置

2. **Spring Security**：
   - 使用代理模式实现方法级别的安全控制
   - 示例：`@PreAuthorize`和`@Secured`注解的实现

3. **Spring Data JPA**：
   - 使用代理模式实现Repository接口
   - 在运行时生成Repository的实现类
   - 示例：通过继承`JpaRepository`接口创建数据访问层

### 7.3 Spring Boot中的代理模式

1. **Spring Boot Actuator**：
   - 使用代理模式实现端点监控
   - 示例：健康检查、指标收集等功能的实现

2. **Spring Cloud Circuit Breaker**：
   - 使用代理模式实现熔断机制
   - 示例：Resilience4j和Hystrix的集成

3. **Spring Boot Cache**：
   - 使用代理模式实现方法级缓存
   - 示例：`@Cacheable`和`@CacheEvict`注解的实现

## 8. 总结

代理模式是一种常用的结构型设计模式，它通过为原始对象提供一个代理来控制对原始对象的访问。代理模式可以增强原始对象的功能，实现客户端和原始对象之间的解耦。

使用代理模式时，需要明确抽象主题、真实主题和代理之间的关系，并根据实际需求选择合适的代理类型。遵循标准化的命名和代码规范，可以使代理模式的实现更加清晰和易于理解。

在权威开源框架如JDK、Spring和Spring Boot中，代理模式得到了广泛应用，体现了其在实际开发中的重要价值和实用性。