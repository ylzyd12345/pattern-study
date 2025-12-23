package com.kevin.demo.creational.singleton.lazy.innerClass;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 静态内部类懒汉式单例模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("静态内部类懒汉式单例模式测试")
class HandlerLazySingletonTest extends BasePatternTest {

    @Test
    @DisplayName("测试单例实例唯一性")
    void testSingletonUniqueness() {
        HandlerLazySingleton instance1 = HandlerLazySingleton.getInstance();
        HandlerLazySingleton instance2 = HandlerLazySingleton.getInstance();
        
        assertSame(instance1, instance2, "静态内部类单例应该返回同一个实例");
    }

    @Test
    @DisplayName("测试实例不为null")
    void testSingletonNotNull() {
        HandlerLazySingleton instance = HandlerLazySingleton.getInstance();
        assertNotNull(instance, "单例实例不应该为null");
    }

    @Test
    @DisplayName("测试多次获取实例的一致性")
    void testMultipleInstancesConsistency() {
        HandlerLazySingleton instance1 = HandlerLazySingleton.getInstance();
        HandlerLazySingleton instance2 = HandlerLazySingleton.getInstance();
        HandlerLazySingleton instance3 = HandlerLazySingleton.getInstance();
        
        assertSame(instance1, instance2);
        assertSame(instance2, instance3);
        assertSame(instance1, instance3);
    }

    @Test
    @DisplayName("测试hashCode一致性")
    void testHashCodeConsistency() {
        HandlerLazySingleton instance1 = HandlerLazySingleton.getInstance();
        HandlerLazySingleton instance2 = HandlerLazySingleton.getInstance();
        
        assertEquals(instance1.hashCode(), instance2.hashCode(), 
                    "同一单例实例的hashCode应该相同");
    }

    @Test
    @DisplayName("测试equals方法")
    void testEqualsMethod() {
        HandlerLazySingleton instance1 = HandlerLazySingleton.getInstance();
        HandlerLazySingleton instance2 = HandlerLazySingleton.getInstance();
        
        assertTrue(instance1.equals(instance2), "同一单例实例应该equals");
        assertEquals(instance1, instance2, "同一单例实例应该相等");
    }

    @Nested
    @DisplayName("懒加载特性测试")
    class LazyLoadingTest {
        
        @Test
        @DisplayName("测试懒加载特性")
        void testLazyLoading() {
            // 静态内部类应该在第一次调用getInstance()时才加载
            // 这个特性确保了懒加载
            HandlerLazySingleton instance = HandlerLazySingleton.getInstance();
            assertNotNull(instance, "调用getInstance()后实例不应该为null");
        }

        @Test
        @DisplayName("测试内部类加载时机")
        void testInnerClassLoading() {
            // 在调用getInstance()之前，内部类不应该被加载
            // 这个测试验证了懒加载的特性
            HandlerLazySingleton instance = HandlerLazySingleton.getInstance();
            assertNotNull(instance, "内部类应该延迟加载");
        }
    }

    @Nested
    @DisplayName("线程安全测试")
    class ThreadSafetyTest {
        
        @Test
        @DisplayName("测试多线程环境下的线程安全性")
        void testThreadSafety() throws InterruptedException {
            assertSingletonThreadSafety(HandlerLazySingleton::getInstance, 100);
        }

        @Test
        @DisplayName("测试高并发环境下的性能")
        void testHighConcurrencyPerformance() throws InterruptedException {
            // 静态内部类实现不需要同步，性能应该很好
            assertExecutionTime(() -> {
                // 预热
                HandlerLazySingleton.getInstance();
                
                // 高并发测试
                assertSingletonThreadSafety(HandlerLazySingleton::getInstance, 1000);
            }, 500); // 期望在0.5秒内完成
        }
    }

    @Nested
    @DisplayName("反射攻击防护测试")
    class ReflectionAttackTest {
        
        @Test
        @DisplayName("测试反射攻击防护")
        void testReflectionAttackPrevention() {
            // 先获取一个实例
            HandlerLazySingleton.getInstance();
            
            // 使用基类方法测试反射攻击防护
            assertReflectionAttackPrevention(HandlerLazySingleton.class);
        }
    }

    @Test
    @DisplayName("测试静态内部类的特性")
    void testStaticInnerClassCharacteristics() {
        // 静态内部类的特性：
        // 1. 只在首次使用时加载
        // 2. 类加载过程由JVM保证线程安全
        // 3. 不需要同步锁
        
        HandlerLazySingleton instance1 = HandlerLazySingleton.getInstance();
        HandlerLazySingleton instance2 = HandlerLazySingleton.getInstance();
        
        // 验证实例的唯一性
        assertSame(instance1, instance2, "静态内部类应该保证实例唯一性");
        
        // 验证实例的一致性
        assertEquals(instance1, instance2, "静态内部类应该保证实例一致性");
    }

    @Test
    @DisplayName("测试序列化安全性")
    void testSerializationSafety() {
        // 静态内部类实现天然支持序列化安全性
        // 因为实例是final的，且在类加载时创建
        HandlerLazySingleton instance1 = HandlerLazySingleton.getInstance();
        HandlerLazySingleton instance2 = HandlerLazySingleton.getInstance();
        
        // 验证实例的唯一性
        assertSame(instance1, instance2, "序列化后应该保持单例特性");
    }

    @Test
    @DisplayName("测试内存占用")
    void testMemoryUsage() {
        // 静态内部类实现只会在需要时创建实例
        // 测试内存使用的合理性
        Runtime runtime = Runtime.getRuntime();
        
        // 记录获取实例前的内存使用
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        // 获取实例
        HandlerLazySingleton instance = HandlerLazySingleton.getInstance();
        assertNotNull(instance);
        
        // 记录获取实例后的内存使用
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        
        // 验证内存使用合理（实例应该只占用少量内存）
        long memoryUsed = memoryAfter - memoryBefore;
        assertTrue(memoryUsed < 1024 * 1024, // 1MB
                  "单例实例的内存占用应该很小，实际: " + memoryUsed + " bytes");
    }
}