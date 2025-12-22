# 外观模式（Facade Pattern）

## 1. 模式概述

外观模式是一种结构型设计模式，它为子系统中的一组接口提供一个统一的入口点。外观模式定义了一个高层接口，使得子系统更容易使用。

### 1.1 核心意图
- 简化复杂子系统的使用
- 降低客户端与子系统之间的耦合度
- 提供一个统一的接口来访问子系统中的一群接口

### 1.2 解决的问题
当一个系统包含多个子系统，且这些子系统之间交互复杂时，客户端需要了解各个子系统的细节才能正确使用它们。外观模式通过提供一个统一的入口点，将客户端与复杂的子系统内部结构隔离开来。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 外观（Facade） | 为子系统提供统一的入口点，封装子系统的复杂性 | CmfFacade |
| 子系统（SubSystem） | 实现子系统的具体功能，客户端可以通过外观访问这些子系统 | CmfCommon、CmfLevel、CmfPoint |
| 客户端（Client） | 通过外观访问子系统的功能 | App |

### 2.2 结构示意图

```
┌───────────┐     ┌────────────┐
│   Client  │────▶│   Facade   │
└───────────┘     └────────────┘
                      │
                      ▼
       ┌─────────────────────────────────┐
       │         Subsystems              │
       ├────────────┬────────────┬─────────────┤
       │ CmfCommon  │ CmfLevel   │  CmfPoint   │
       └────────────┴────────────┴─────────────┘
```

## 3. 实现示例

### 3.1 子系统类

```java
package com.kevin.demo.structral.外观;

/**
 * 公共服务类 - 外观模式中的子系统角色(SubSystem)
 * 提供用户注册和注销的基本功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CmfCommon {
    /**
     * 用户注册
     */
    public void register() {
        System.out.println("add user");
    }
    
    /**
     * 用户注销
     */
    public void unRegister() {
        System.out.println("del user");
    }
}
```

```java
package com.kevin.demo.structral.外观;

/**
 * 等级服务类 - 外观模式中的子系统角色(SubSystem)
 * 提供用户等级的添加和删除功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CmfLevel {
    /**
     * 添加用户等级
     */
    public void addLevel() {
        System.out.println("add level");
    }
    
    /**
     * 删除用户等级
     */
    public void delLevel() {
        System.out.println("del level");
    }
}
```

```java
package com.kevin.demo.structral.外观;

/**
 * 积分服务类 - 外观模式中的子系统角色(SubSystem)
 * 提供用户积分的添加和删除功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CmfPoint {
    /**
     * 添加用户积分
     */
    public void addPoint() {
        System.out.println("add point");
    }
    
    /**
     * 删除用户积分
     */
    public void delPoint() {
        System.out.println("del point");
    }
}
```

### 3.2 外观类

```java
package com.kevin.demo.structral.外观;

/**
 * CMF外观类 - 外观模式中的外观角色(Facade)
 * 为子系统中的一组接口提供一个统一的入口点
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CmfFacade {
    
    /**
     * 公共服务子系统
     */
    private CmfCommon common = new CmfCommon();
    
    /**
     * 等级服务子系统
     */
    private CmfLevel cmfLevel = new CmfLevel();
    
    /**
     * 积分服务子系统
     */
    private CmfPoint cmfPoint = new CmfPoint();
    
    /**
     * 用户注册（组合调用子系统的方法）
     */
    public void register() {
        common.register();
        cmfLevel.addLevel();
        cmfPoint.addPoint();
    }
    
    /**
     * 用户注销（组合调用子系统的方法）
     */
    public void unregiser() {
        common.unRegister();
        cmfLevel.delLevel();
        cmfPoint.delPoint();
    }
}
```

### 3.3 客户端类

```java
package com.kevin.demo.structral.外观;

/**
 * 外观模式演示类 - 外观模式中的客户端角色(Client)
 * 演示如何通过外观类简化子系统的使用
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class App {
    /**
     * 主方法，演示外观模式的使用
     * 
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建外观对象
        CmfFacade cmfFacade = new CmfFacade();
        
        // 通过外观对象调用注册功能（内部会调用多个子系统）
        cmfFacade.register();
        
        System.out.println("--------分割线--------");
        
        // 通过外观对象调用注销功能（内部会调用多个子系统）
        cmfFacade.unregiser();
    }
}
```

### 3.4 运行结果

```
add user
add level
add point
--------分割线--------
del user
del level
del point
```

## 4. 优缺点分析

### 4.1 优点
- **简化接口**：外观模式通过提供一个统一的接口，简化了客户端与子系统之间的交互
- **降低耦合**：客户端只需要与外观类交互，不需要了解子系统的内部结构
- **提高安全性**：可以通过外观类控制对子系统的访问，隐藏子系统的某些细节
- **符合迪米特法则**：客户端只需要知道外观类，不需要知道子系统的具体实现

### 4.2 缺点
- **灵活性降低**：外观模式可能会限制客户端对某些子系统功能的直接访问
- **过度依赖**：如果外观类变得过于复杂，可能会成为系统的瓶颈

## 5. 适用场景

### 5.1 应用场景
- 当一个系统包含多个子系统，且客户端需要与多个子系统交互时
- 当需要简化复杂子系统的使用，提高系统的易用性时
- 当需要降低客户端与子系统之间的耦合度，提高系统的可维护性时

### 5.2 实际应用
- 框架的API接口：如Spring框架提供的各种模板类
- 应用程序的主界面：如操作系统的桌面环境
- 企业应用的服务层：如SOA架构中的服务门面

## 6. 设计原则

外观模式遵循以下设计原则：
- **单一职责原则**：外观类只负责封装子系统的复杂性，不实现具体的业务逻辑
- **迪米特法则**：客户端只与外观类交互，不直接与子系统交互
- **开闭原则**：可以在不修改外观类的情况下扩展子系统的功能

## 7. 与其他模式的比较

### 7.1 外观模式 vs 适配器模式
- **外观模式**：提供一个统一的接口来简化子系统的使用，不改变子系统的接口
- **适配器模式**：将一个接口转换成客户端期望的另一个接口，改变了原有接口的形式

### 7.2 外观模式 vs 中介者模式
- **外观模式**：关注于简化子系统的访问，子系统之间可能仍然存在直接交互
- **中介者模式**：关注于协调多个对象之间的交互，对象之间通过中介者进行通信，避免直接交互

### 7.3 外观模式 vs 代理模式
- **外观模式**：提供一个统一的入口点，可能封装多个子系统
- **代理模式**：为单个对象提供一个代理，控制对该对象的访问

## 8. 扩展和优化

### 8.1 抽象外观类
可以定义一个抽象的外观类，然后提供不同的具体外观实现，这样客户端可以根据需要选择不同的外观实现。

### 8.2 子系统的延迟加载
可以在外观类中使用延迟加载技术，只有在需要时才创建子系统对象，提高系统的性能。

### 8.3 外观类的缓存
可以在外观类中添加缓存机制，缓存子系统的计算结果，避免重复计算。

## 9. 总结

外观模式是一种简单而实用的设计模式，它通过提供一个统一的入口点，简化了客户端与复杂子系统之间的交互。外观模式降低了客户端与子系统之间的耦合度，提高了系统的易用性和可维护性。

在实际开发中，外观模式常用于构建框架的API接口、应用程序的主界面、企业应用的服务层等场景。它是实现系统分层设计、降低系统复杂度的重要手段之一。