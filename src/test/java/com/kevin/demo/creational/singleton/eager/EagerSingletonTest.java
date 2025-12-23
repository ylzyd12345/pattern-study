package com.kevin.demo.creational.singleton.eager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 饿汉式单例模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("饿汉式单例模式测试")
class EagerSingletonTest {

    @Test
    @DisplayName("测试单例实例唯一性")
    void testSingletonUniqueness() {
        // 获取两个单例实例
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        
        // 验证两个实例是同一个对象
        assertSame(instance1, instance2, "饿汉式单例应该返回同一个实例");
    }

    @Test
    @DisplayName("测试单例实例不为null")
    void testSingletonNotNull() {
        EagerSingleton instance = EagerSingleton.getInstance();
        assertNotNull(instance, "单例实例不应该为null");
    }

    @Test
    @DisplayName("测试多次获取实例的一致性")
    void testMultipleInstancesConsistency() {
        // 获取多个实例
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        EagerSingleton instance3 = EagerSingleton.getInstance();
        
        // 验证所有实例都是同一个对象
        assertSame(instance1, instance2);
        assertSame(instance2, instance3);
        assertSame(instance1, instance3);
    }

    @Test
    @DisplayName("测试单例实例的hashCode一致性")
    void testHashCodeConsistency() {
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        
        // 验证hashCode相同
        assertEquals(instance1.hashCode(), instance2.hashCode(), 
                    "同一单例实例的hashCode应该相同");
    }

    @Test
    @DisplayName("测试单例实例的equals方法")
    void testEqualsMethod() {
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        
        // 测试equals方法
        assertTrue(instance1.equals(instance2), "同一单例实例应该equals");
        assertEquals(instance1, instance2, "同一单例实例应该相等");
    }

    @Nested
    @DisplayName("反射攻击防护测试")
    class ReflectionAttackTest {
        
        @Test
        @DisplayName("测试反射攻击防护")
        void testReflectionAttackPrevention() {
            EagerSingleton instance = EagerSingleton.getInstance();
            
            // 尝试通过反射创建新实例
            Exception exception = assertThrows(RuntimeException.class, () -> {
                java.lang.reflect.Constructor<EagerSingleton> constructor = 
                    EagerSingleton.class.getDeclaredConstructor();
                constructor.setAccessible(true);
                constructor.newInstance();
            });
            
            assertTrue(exception.getMessage().contains("单例模式禁止通过反射创建多个实例"),
                      "应该抛出反射攻击防护异常");
        }
    }

    @Test
    @DisplayName("测试类加载时机")
    void testClassLoading() {
        // 验证类加载时实例就已经创建
        // 这个测试主要验证饿汉式的特性：类加载时就创建实例
        EagerSingleton instance = EagerSingleton.getInstance();
        assertNotNull(instance, "饿汉式单例在类加载时就应该创建实例");
    }

    @Test
    @DisplayName("测试线程安全性")
    void testThreadSafety() throws InterruptedException {
        final int threadCount = 10;
        final EagerSingleton[] instances = new EagerSingleton[threadCount];
        final Thread[] threads = new Thread[threadCount];
        
        // 创建多个线程同时获取单例实例
        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                instances[index] = EagerSingleton.getInstance();
            });
        }
        
        // 启动所有线程
        for (Thread thread : threads) {
            thread.start();
        }
        
        // 等待所有线程完成
        for (Thread thread : threads) {
            thread.join();
        }
        
        // 验证所有线程获取的都是同一个实例
        EagerSingleton firstInstance = instances[0];
        for (int i = 1; i < threadCount; i++) {
            assertSame(firstInstance, instances[i], 
                      "多线程环境下应该返回同一个单例实例");
        }
    }
}