package com.kevin.demo.creational.单例.懒汉.双检;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 双检锁懒汉式单例模式测试类
 * <p>
 * 测试双检锁单例模式的核心功能，包括：
 * 1. 单例唯一性 - 确保多次调用getInstance()返回同一个实例
 * 2. 实例有效性 - 确保返回的实例不为null
 * 
 * @author Kevin
 */
public class DoubleCheckLazySingletonTest {

    /**
     * 测试多次调用getInstance()方法返回同一个实例
     */
    @Test
    public void testGetInstance_ReturnsSameInstance() {
        // 获取两个实例
        DoubleCheckLazySingleton instance1 = DoubleCheckLazySingleton.getInstance();
        DoubleCheckLazySingleton instance2 = DoubleCheckLazySingleton.getInstance();
        
        // 验证它们是同一个实例
        assertSame(instance1, instance2, "双检锁单例模式应该返回同一个实例");
    }
    
    /**
     * 测试getInstance()方法返回有效的非null实例
     */
    @Test
    public void testGetInstance_ReturnsValidInstance() {
        // 获取实例
        DoubleCheckLazySingleton instance = DoubleCheckLazySingleton.getInstance();
        
        // 验证实例不为null
        assertNotNull(instance, "双检锁单例模式应该返回非null实例");
    }
}