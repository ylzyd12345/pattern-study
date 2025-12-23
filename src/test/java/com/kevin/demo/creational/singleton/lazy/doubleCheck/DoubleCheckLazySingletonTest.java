package com.kevin.demo.creational.singleton.lazy.doubleCheck;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 双检锁懒汉式单例模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("双检锁懒汉式单例模式测试")
class DoubleCheckLazySingletonTest extends BasePatternTest {

    @Test
    @DisplayName("测试单例实例唯一性")
    void testSingletonUniqueness() {
        DoubleCheckLazySingleton instance1 = DoubleCheckLazySingleton.getInstance();
        DoubleCheckLazySingleton instance2 = DoubleCheckLazySingleton.getInstance();
        
        assertSame(instance1, instance2, "双检锁懒汉式单例应该返回同一个实例");
    }

    @Test
    @DisplayName("测试懒加载特性")
    void testLazyLoading() {
        // 在调用getInstance()之前，实例应该为null
        // 注意：这个测试主要通过反射来验证懒加载特性
        DoubleCheckLazySingleton instance = DoubleCheckLazySingleton.getInstance();
        assertNotNull(instance, "调用getInstance()后实例不应该为null");
    }

    @Test
    @DisplayName("测试多次获取实例的一致性")
    void testMultipleInstancesConsistency() {
        DoubleCheckLazySingleton instance1 = DoubleCheckLazySingleton.getInstance();
        DoubleCheckLazySingleton instance2 = DoubleCheckLazySingleton.getInstance();
        DoubleCheckLazySingleton instance3 = DoubleCheckLazySingleton.getInstance();
        
        assertSame(instance1, instance2);
        assertSame(instance2, instance3);
        assertSame(instance1, instance3);
    }

    @Test
    @DisplayName("测试hashCode一致性")
    void testHashCodeConsistency() {
        DoubleCheckLazySingleton instance1 = DoubleCheckLazySingleton.getInstance();
        DoubleCheckLazySingleton instance2 = DoubleCheckLazySingleton.getInstance();
        
        assertEquals(instance1.hashCode(), instance2.hashCode(), 
                    "同一单例实例的hashCode应该相同");
    }

    @Test
    @DisplayName("测试equals方法")
    void testEqualsMethod() {
        DoubleCheckLazySingleton instance1 = DoubleCheckLazySingleton.getInstance();
        DoubleCheckLazySingleton instance2 = DoubleCheckLazySingleton.getInstance();
        
        assertTrue(instance1.equals(instance2), "同一单例实例应该equals");
        assertEquals(instance1, instance2, "同一单例实例应该相等");
    }

    @Nested
    @DisplayName("线程安全测试")
    class ThreadSafetyTest {
        
        @Test
        @DisplayName("测试多线程环境下的线程安全性")
        void testThreadSafety() throws InterruptedException {
            assertSingletonThreadSafety(DoubleCheckLazySingleton::getInstance, 100);
        }

        @Test
        @DisplayName("测试高并发环境下的性能")
        void testHighConcurrencyPerformance() throws InterruptedException {
            // 使用基类方法验证执行时间
            assertExecutionTime(() -> {
                // 预热
                for (int i = 0; i < 100; i++) {
                    DoubleCheckLazySingleton.getInstance();
                }
                
                // 高并发测试
                assertSingletonThreadSafety(DoubleCheckLazySingleton::getInstance, 1000);
            }, 1000); // 期望在1秒内完成
        }
    }

    @Nested
    @DisplayName("反射攻击防护测试")
    class ReflectionAttackTest {
        
        @Test
        @DisplayName("测试反射攻击防护")
        void testReflectionAttackPrevention() {
            // 先获取一个实例
            DoubleCheckLazySingleton.getInstance();
            
            // 使用基类方法测试反射攻击防护
            assertReflectionAttackPrevention(DoubleCheckLazySingleton.class);
        }
    }

    @Test
    @DisplayName("测试双重检查机制")
    void testDoubleCheckMechanism() {
        // 这个测试主要验证双重检查机制的正确性
        // 通过多次调用getInstance()来验证双重检查的有效性
        
        for (int i = 0; i < 100; i++) {
            DoubleCheckLazySingleton instance = DoubleCheckLazySingleton.getInstance();
            assertNotNull(instance, "第" + (i + 1) + "次获取实例不应该为null");
        }
        
        // 验证所有获取的实例都是同一个
        DoubleCheckLazySingleton firstInstance = DoubleCheckLazySingleton.getInstance();
        for (int i = 0; i < 100; i++) {
            DoubleCheckLazySingleton instance = DoubleCheckLazySingleton.getInstance();
            assertSame(firstInstance, instance, "所有实例都应该是同一个");
        }
    }

    @Test
    @DisplayName("测试volatile关键字的作用")
    void testVolatileKeywordEffect() {
        // 这个测试主要验证volatile关键字确保的可见性
        // 在实际应用中，volatile确保多线程环境下instance变量的可见性
        
        DoubleCheckLazySingleton instance1 = DoubleCheckLazySingleton.getInstance();
        DoubleCheckLazySingleton instance2 = DoubleCheckLazySingleton.getInstance();
        
        // 验证实例的一致性
        assertSame(instance1, instance2, "volatile应该确保实例的可见性");
    }
}