package com.kevin.demo.creational.singleton.enumPattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 枚举单例模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("枚举单例模式测试")
class EnumSingletonTest {

    @Test
    @DisplayName("测试枚举单例实例唯一性")
    void testEnumSingletonUniqueness() {
        EnumSingleton instance1 = EnumSingleton.instance;
        EnumSingleton instance2 = EnumSingleton.instance;
        
        assertSame(instance1, instance2, "枚举单例应该返回同一个实例");
    }

    @Test
    @DisplayName("测试枚举实例不为null")
    void testEnumSingletonNotNull() {
        EnumSingleton instance = EnumSingleton.instance;
        assertNotNull(instance, "枚举单例实例不应该为null");
    }

    @Test
    @DisplayName("测试枚举类型的特性")
    void testEnumTypeCharacteristics() {
        // 测试枚举的基本特性
        assertEquals("instance", EnumSingleton.instance.name(), "枚举常量名称应该是instance");
        assertEquals(0, EnumSingleton.instance.ordinal(), "枚举常量的序号应该是0");
        
        // 测试枚举值的数量
        EnumSingleton[] values = EnumSingleton.values();
        assertEquals(1, values.length, "枚举应该只有一个值");
        assertSame(EnumSingleton.instance, values[0], "枚举值应该是instance");
    }

    @Test
    @DisplayName("测试valueOf方法")
    void testValueOfMethod() {
        EnumSingleton instance = EnumSingleton.valueOf("instance");
        assertSame(EnumSingleton.instance, instance, "valueOf应该返回同一个实例");
        
        // 测试不存在的名称
        assertThrows(IllegalArgumentException.class, () -> {
            EnumSingleton.valueOf("nonexistent");
        }, "不存在的枚举名称应该抛出IllegalArgumentException");
    }

    @Test
    @DisplayName("测试hashCode和equals方法")
    void testHashCodeAndEquals() {
        EnumSingleton instance1 = EnumSingleton.instance;
        EnumSingleton instance2 = EnumSingleton.instance;
        
        assertEquals(instance1.hashCode(), instance2.hashCode(), 
                    "同一枚举实例的hashCode应该相同");
        assertTrue(instance1.equals(instance2), "同一枚举实例应该equals");
        assertEquals(instance1, instance2, "同一枚举实例应该相等");
    }

    @Nested
    @DisplayName("序列化安全性测试")
    class SerializationSafetyTest {
        
        @Test
        @DisplayName("测试序列化和反序列化保持单例")
        void testSerializationMaintainsSingleton() throws IOException, ClassNotFoundException {
            EnumSingleton originalInstance = EnumSingleton.instance;
            
            // 序列化
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(originalInstance);
            oos.close();
            
            // 反序列化
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            EnumSingleton deserializedInstance = (EnumSingleton) ois.readObject();
            ois.close();
            
            // 验证反序列化后仍然是同一个实例
            assertSame(originalInstance, deserializedInstance, 
                      "枚举单例在序列化和反序列化后应该保持单例");
        }
    }

    @Nested
    @DisplayName("反射攻击防护测试")
    class ReflectionAttackTest {
        
        @Test
        @DisplayName("测试枚举单例防止反射攻击")
        void testEnumPreventsReflectionAttack() {
            // 枚举类型天然防止反射攻击
            // 尝试通过反射创建枚举实例会抛出异常
            
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                Constructor<EnumSingleton> constructor = 
                    EnumSingleton.class.getDeclaredConstructor();
                constructor.setAccessible(true);
                constructor.newInstance();
            });
            
            assertTrue(exception.getMessage().contains("Cannot reflectively create enum objects"),
                      "枚举应该防止反射创建实例");
        }
    }

    @Test
    @DisplayName("测试线程安全性")
    void testThreadSafety() throws InterruptedException {
        final int threadCount = 100;
        final EnumSingleton[] instances = new EnumSingleton[threadCount];
        final Thread[] threads = new Thread[threadCount];
        
        // 创建多个线程同时获取单例实例
        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                instances[index] = EnumSingleton.instance;
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
        EnumSingleton firstInstance = instances[0];
        for (int i = 1; i < threadCount; i++) {
            assertSame(firstInstance, instances[i], 
                      "多线程环境下应该返回同一个枚举单例实例");
        }
    }

    @Test
    @DisplayName("测试枚举单例的性能")
    void testEnumSingletonPerformance() {
        // 枚举单例通常有很好的性能，因为它们在类加载时就初始化了
        
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            EnumSingleton instance = EnumSingleton.instance;
        }
        long endTime = System.nanoTime();
        
        long duration = endTime - startTime;
        long averageTime = duration / 1000000;
        
        // 验证性能（枚举访问应该非常快）
        assertTrue(averageTime < 100, // 100纳秒
                  "枚举单例的访问时间应该小于100纳秒，实际: " + averageTime + " 纳秒");
    }

    @Test
    @DisplayName("测试枚举的比较操作")
    void testEnumComparison() {
        EnumSingleton instance1 = EnumSingleton.instance;
        EnumSingleton instance2 = EnumSingleton.instance;
        
        // 测试==操作符
        assertTrue(instance1 == instance2, "枚举实例应该可以用==比较");
        
        // 测试compareTo方法
        assertEquals(0, instance1.compareTo(instance2), "同一枚举实例的compareTo应该返回0");
        
        // 测试equals方法
        assertTrue(instance1.equals(instance2), "同一枚举实例应该equals");
    }

    @Test
    @DisplayName("测试枚举的toString方法")
    void testEnumToString() {
        EnumSingleton instance = EnumSingleton.instance;
        assertEquals("instance", instance.toString(), "枚举的toString应该返回枚举名称");
    }

    @Test
    @DisplayName("测试枚举的Class对象")
    void testEnumClassObject() {
        EnumSingleton instance = EnumSingleton.instance;
        Class<?> enumClass = instance.getClass();
        
        assertTrue(enumClass.isEnum(), "枚举实例的Class应该表示枚举类型");
        assertEquals(EnumSingleton.class, enumClass, "枚举实例的Class应该是EnumSingleton.class");
    }
}