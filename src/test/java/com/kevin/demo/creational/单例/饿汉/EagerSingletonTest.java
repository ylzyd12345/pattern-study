package com.kevin.demo.creational.单例.饿汉;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 饿汉式单例模式测试类
 * 使用JUnit 5框架进行测试
 * @author kevin
 */
class EagerSingletonTest {

    /**
     * 测试单例模式是否返回唯一实例
     */
    @Test
    void testGetInstance_ReturnsSameInstance() {
        // 获取两个实例
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        
        // 验证两个实例是同一个对象引用
        assertSame(instance1, instance2, "单例模式应该返回相同的实例");
        
        // 验证实例不为null
        assertNotNull(instance1, "单例实例不应该为null");
        assertNotNull(instance2, "单例实例不应该为null");
    }

    /**
     * 测试单例实例的功能
     */
    @Test
    void testGetInstance_ReturnsValidInstance() {
        EagerSingleton instance = EagerSingleton.getInstance();
        assertNotNull(instance, "单例实例不应该为null");
        
        // 这里可以添加更多针对单例实例功能的测试
        // 由于EagerSingleton类目前只有getInstance方法，所以只测试实例获取
    }
}