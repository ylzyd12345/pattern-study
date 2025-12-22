# 装饰模式（Decorator Pattern）

## 1. 模式概述

装饰模式是一种结构型设计模式，它允许动态地为对象添加额外的责任或功能，而不影响其他对象。装饰模式提供了一种比继承更灵活的扩展功能的方式。

### 1.1 核心意图
- 动态地为对象添加额外的责任或功能
- 不影响其他对象的功能
- 提供比继承更灵活的扩展方式

### 1.2 解决的问题
当需要为对象动态地添加功能，或者避免使用继承导致的类爆炸问题时，装饰模式提供了一种灵活的解决方案。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 抽象构件（Component） | 定义了对象的接口，是装饰者和被装饰者的共同父类 | Call |
| 具体构件（ConcreteComponent） | 实现了抽象构件接口的具体对象 | PhoneCall |
| 抽象装饰（Decorator） | 实现了抽象构件接口，并持有一个抽象构件对象的引用 | CallDecorator |
| 具体装饰（ConcreteDecorator） | 继承自抽象装饰类，为对象添加额外的功能 | RecordDecorator、TranslateDecorator |
| 客户端（Client） | 使用装饰模式的对象 | App |

### 2.2 结构示意图

```
┌─────────────────┐
│    Component    │
└─────────┬───────┘
          │
┌─────────▼───────┐     ┌─────────────────┐
│ ConcreteComponent │◄─────┤     Decorator     │
└─────────────────┘     └─────────┬───────┘
                                   │
                           ┌───────▼─────────┐
                           │                   │
                   ┌───────▼─────┐     ┌───────▼─────┐
                   │ConcreteDecorator1│     │ConcreteDecorator2│
                   └─────────────────┘     └─────────────────┘
```

## 3. 实现示例

### 3.1 抽象构件类

```java
package com.kevin.demo.structral.装饰;

/**
 * 电话抽象类 - 装饰模式中的抽象构件角色(Component)
 * 定义了电话通话的基本接口
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public abstract class Call {

    /**
     * 拨打电话
     * 
     * @param number 电话号码
     */
    protected abstract void call(String number);

}
```

### 3.2 具体构件类

```java
package com.kevin.demo.structral.装饰;

/**
 * 电话类 - 装饰模式中的具体构件角色(ConcreteComponent)
 * 实现了电话通话的基本功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class PhoneCall extends Call {

    /**
     * 拨打电话
     * 
     * @param number 电话号码
     */
    @Override
    protected void call(String number) {
        System.out.println("拨打电话，号码是: " + number);
    }

}
```

### 3.3 抽象装饰类

```java
package com.kevin.demo.structral.装饰;

/**
 * 电话装饰器抽象类 - 装饰模式中的抽象装饰角色(Decorator)
 * 实现了电话接口，并持有一个电话对象的引用
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CallDecorator extends Call {

    /**
     * 被装饰的电话对象
     */
    private Call call;

    /**
     * 构造方法
     * 
     * @param call 要装饰的电话对象
     */
    public CallDecorator(Call call) {
        this.call = call;
    }

    /**
     * 拨打电话
     * 
     * @param number 电话号码
     */
    @Override
    protected void call(String number) {
        call.call(number);
    }

}
```

### 3.4 具体装饰类

```java
package com.kevin.demo.structral.装饰;

/**
 * 记录装饰器类 - 装饰模式中的具体装饰角色(ConcreteDecorator)
 * 为电话添加通话记录功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class RecordDecorator extends CallDecorator {

    /**
     * 构造方法
     * 
     * @param call 要装饰的电话对象
     */
    public RecordDecorator(Call call) {
        super(call);
    }

    /**
     * 拨打电话并记录通话时间
     * 
     * @param number 电话号码
     */
    @Override
    protected void call(String number) {
        long begintime = System.currentTimeMillis();
        super.call(number);
        long endtime = System.currentTimeMillis();
        record(begintime, endtime, number);
    }

    /**
     * 记录通话时间
     * 
     * @param begintime 开始时间
     * @param endtime 结束时间
     * @param number 电话号码
     */
    private void record(long begintime, long endtime, String number) {
        System.out.println("通话记录: 拨打" + number + ", 通话时长: " + (endtime - begintime) + "毫秒");
    }

}
```

```java
package com.kevin.demo.structral.装饰;

/**
 * 翻译装饰器类 - 装饰模式中的具体装饰角色(ConcreteDecorator)
 * 为电话添加翻译功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class TranslateDecorator extends CallDecorator {

    /**
     * 构造方法
     * 
     * @param call 要装饰的电话对象
     */
    public TranslateDecorator(Call call) {
        super(call);
    }

    /**
     * 拨打电话并提供翻译服务
     * 
     * @param number 电话号码
     */
    @Override
    protected void call(String number) {
        super.call(number);
        translate(number);
    }

    /**
     * 提供翻译服务
     * 
     * @param number 电话号码
     */
    private void translate(String number) {
        System.out.println("翻译服务: 为拨打" + number + "的通话提供实时翻译");
    }

}
```

### 3.5 客户端类

```java
package com.kevin.demo.structral.装饰;

/**
 * 装饰模式演示类 - 装饰模式中的客户端角色(Client)
 * 演示如何使用装饰模式为对象动态添加功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class App {
    
    /**
     * 主方法，演示装饰模式的使用
     * 
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建基本电话对象
        Call call = new PhoneCall();
        
        // 为电话添加通话记录功能
        Call recordCall = new RecordDecorator(call);
        System.out.println("-------- 基本电话 + 通话记录 --------");
        recordCall.call("00000");
        
        // 为已添加通话记录的电话再添加翻译功能
        Call translateCall = new TranslateDecorator(recordCall);
        System.out.println("\n-------- 基本电话 + 通话记录 + 翻译 --------");
        translateCall.call("111111");
        
        // 直接使用基本电话
        System.out.println("\n-------- 基本电话 --------");
        call.call("222222");
    }
}
```

### 3.6 运行结果

```
-------- 基本电话 + 通话记录 --------
拨打电话，号码是: 00000
通话记录: 拨打00000, 通话时长: 1毫秒

-------- 基本电话 + 通话记录 + 翻译 --------
拨打电话，号码是: 111111
通话记录: 拨打111111, 通话时长: 0毫秒
翻译服务: 为拨打111111的通话提供实时翻译

-------- 基本电话 --------
拨打电话，号码是: 222222
```

## 4. 优缺点分析

### 4.1 优点
- **灵活性**：可以动态地为对象添加功能，而不需要修改原有代码
- **可扩展性**：可以方便地添加新的装饰类，符合开闭原则
- **组合性**：可以通过组合不同的装饰类，为对象添加多种功能
- **避免类爆炸**：比继承更灵活，可以避免使用继承导致的类数量急剧增加

### 4.2 缺点
- **复杂度增加**：装饰模式可能会增加系统的复杂度，特别是当装饰类较多时
- **维护难度**：装饰类之间的依赖关系可能会变得复杂，增加维护难度
- **性能影响**：由于装饰模式需要多层包装，可能会对性能产生一定的影响

## 5. 适用场景

### 5.1 应用场景
- 当需要动态地为对象添加功能时
- 当需要避免使用继承导致的类爆炸问题时
- 当需要为对象添加多种功能，并且这些功能可以组合使用时

### 5.2 实际应用
- Java IO流：如BufferedReader、InputStreamReader等
- Swing GUI组件：如JScrollPane、JPanel等
- Spring框架：如AOP（面向切面编程）
- 日志框架：如Log4j、Slf4j等

## 6. 设计原则

装饰模式遵循以下设计原则：
- **单一职责原则**：每个装饰类只负责添加一种功能
- **开闭原则**：可以在不修改现有代码的情况下添加新的装饰类
- **依赖倒置原则**：装饰类和被装饰类都依赖于抽象构件

## 7. 与其他模式的比较

### 7.1 装饰模式 vs 继承
- **装饰模式**：动态地为对象添加功能，不需要修改原有代码
- **继承**：静态地为类添加功能，需要修改原有代码

### 7.2 装饰模式 vs 适配器模式
- **装饰模式**：保持原有接口，为对象添加额外的功能
- **适配器模式**：改变原有接口，使其与客户端期望的接口一致

### 7.3 装饰模式 vs 代理模式
- **装饰模式**：关注于为对象添加额外的功能
- **代理模式**：关注于控制对对象的访问

### 7.4 装饰模式 vs 策略模式
- **装饰模式**：动态地为对象添加功能
- **策略模式**：动态地改变对象的算法或行为

## 8. 变体和扩展

### 8.1 透明装饰模式
在透明装饰模式中，客户端不需要知道对象是被装饰过的，装饰类和被装饰类具有相同的接口。

### 8.2 半透明装饰模式
在半透明装饰模式中，客户端需要知道对象是被装饰过的，装饰类可能会添加新的方法。

### 8.3 装饰模式的扩展
- 可以使用抽象工厂模式来创建装饰类
- 可以使用迭代器模式来遍历装饰类
- 可以使用观察者模式来通知装饰类状态的变化

## 9. 总结

装饰模式是一种灵活的扩展对象功能的方式，它允许动态地为对象添加额外的责任或功能，而不影响其他对象。装饰模式提供了一种比继承更灵活的扩展方式，可以避免使用继承导致的类爆炸问题。

装饰模式广泛应用于Java IO流、Swing GUI组件、Spring框架等领域，它是一种非常实用的设计模式。在实际开发中，我们应该根据具体的需求选择合适的设计模式，以提高代码的可维护性和可扩展性。