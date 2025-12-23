package com.kevin.demo.creational.singleton.enumPattern;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 枚举单例模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("枚举单例模式测试")
class EnumSingletonTest extends BasePatternTest {

    @Test
    @DisplayName("测试单例实例唯一性")
    void testSingletonUniqueness() {
        EnumSingleton instance1 = EnumSingleton.instance;
        EnumSingleton instance2 = EnumSingleton.instance;
        
        assertSame(instance1, instance2, "枚举单例应该返回同一个实例");
    }

    @Test
    @DisplayName("测试实例不为null")
    void testSingletonNotNull() {
        EnumSingleton instance = EnumSingleton.instance;
        assertNotNull(instance, "单例实例不应该为null");
    }

    @Test
    @DisplayName("测试多次获取实例的一致性")
    void testMultipleInstancesConsistency() {
        EnumSingleton instance1 = EnumSingleton.instance;
        EnumSingleton instance2 = EnumSingleton.instance;
        EnumSingleton instance3 = EnumSingleton.instance;
        
        assertSame(instance1, instance2);
        assertSame(instance2, instance3);
        assertSame(instance1, instance3);
    }

    @Test
    @DisplayName("测试hashCode一致性")
    void testHashCodeConsistency() {
        EnumSingleton instance1 = EnumSingleton.instance;
        EnumSingleton instance2 = EnumSingleton.instance;
        
        assertEquals(instance1.hashCode(), instance2.hashCode(), 
                    "同一单例实例的hashCode应该相同");
    }

    @Test
    @DisplayName("测试equals方法")
    void testEqualsMethod() {
        EnumSingleton instance1 = EnumSingleton.instance;
        EnumSingleton instance2 = EnumSingleton.instance;
        
        assertTrue(instance1.equals(instance2), "同一单例实例应该equals");
        assertEquals(instance1, instance2, "同一单例实例应该相等");
    }

    @Nested
    @DisplayName("枚举特性测试")
    class EnumCharacteristicsTest {
        
        @Test
        @DisplayName("测试枚举的values()方法")
        void testValuesMethod() {
            EnumSingleton[] values = EnumSingleton.values();
            assertEquals(1, values.length, "枚举应该只有一个值");
            assertSame(EnumSingleton.instance, values[0], "values()[0]应该等于instance");
        }

        @Test
        @DisplayName("测试枚举的valueOf()方法")
        void testValueOfMethod() {
            EnumSingleton instance = EnumSingleton.valueOf("instance");
            assertSame(EnumSingleton.instance, instance, "valueOf应该返回同一个实例");
        }

        @Test
        @DisplayName("测试枚举的name()方法")
        void testNameMethod() {
            assertEquals("instance", EnumSingleton.instance.name(), 
                        "枚举的name应该是'instance'");
        }

        @Test
        @DisplayName("测试枚举的ordinal()方法")
        void testOrdinalMethod() {
            assertEquals(0, EnumSingleton.instance.ordinal(), 
                        "枚举的ordinal应该是0");
        }
    }

    @Nested
    @DisplayName("线程安全测试")
    class ThreadSafetyTest {
        
        @Test
        @DisplayName("测试多线程环境下的线程安全性")
        void testThreadSafety() throws InterruptedException {
            assertSingletonThreadSafety(() -> EnumSingleton.instance, 100);
        }

        @Test
        @DisplayName("测试高并发环境下的性能")
        void testHighConcurrencyPerformance() throws InterruptedException {
            // 枚举实现天然线程安全，性能应该最好
            assertExecutionTime(() -> {
                // 预热
                EnumSingleton.instance.ordinal();
                
                // 高并发测试
                assertSingletonThreadSafety(() -> EnumSingleton.instance, 1000);
            }, 200); // 期望在0.2秒内完成
        }
    }

    @Nested
    @DisplayName("反射攻击防护测试")
    class ReflectionAttackTest {
        
        @Test
        @DisplayName("测试反射攻击防护")
        void testReflectionAttackPrevention() {
            // 枚举天然防止反射攻击
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                Constructor<EnumSingleton> constructor = 
                    EnumSingleton.class.getDeclaredConstructor();
                constructor.setAccessible(true);
                constructor.newInstance();
            });
            
            assertTrue(exception.getMessage().contains("Cannot reflectively create enum objects"),
                      "应该抛出枚举反射防护异常");
        }

        @Test
        @DisplayName("测试反射修改枚举值")
        void testReflectionModifyEnumValue() {
            // 枚举的final字段也不能通过反射修改
            Exception exception = assertThrows(Exception.class, () -> {
                Field field = EnumSingleton.class.getDeclaredField("instance");
                field.setAccessible(true);
                field.set(null, null);
            });
            
            // 应该抛出异常，因为枚举字段是final的
            assertNotNull(exception, "应该无法通过反射修改枚举值");
        }
    }

    @Nested
    @DisplayName("序列化安全测试")
    class SerializationSafetyTest {
        
        @Test
        @DisplayName("测试序列化和反序列化")
        void testSerializationDeserialization() throws Exception {
            // 序列化
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(EnumSingleton.instance);
            oos.close();
            
            // 反序列化
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            EnumSingleton deserializedInstance = (EnumSingleton) ois.readObject();
            ois.close();
            
            // 验证反序列化后仍然是同一个实例
            assertSame(EnumSingleton.instance, deserializedInstance,
                      "枚举单例序列化反序列化后应该保持单例特性");
        }
    }

    @Test
    @DisplayName("测试枚举单例的内存效率")
    void testMemoryEfficiency() {
        // 枚举单例在类加载时就创建，内存效率高
        Runtime runtime = Runtime.getRuntime();
        
        // 记录内存使用
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        // 访问枚举实例
        EnumSingleton instance = EnumSingleton.instance;
        assertNotNull(instance);
        
        // 记录内存使用
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        
        // 验证内存使用合理
        long memoryUsed = memoryAfter - memoryBefore;
        assertTrue(memoryUsed < 1024 * 1024, // 1MB
                  "枚举单例的内存占用应该很小，实际: " + memoryUsed + " bytes");
    }

    @Test
    @DisplayName("测试枚举单例的扩展性")
    void testExtensibility() {
        // 枚举单例可以添加方法和字段
        // 这里测试基本的枚举操作
        
        EnumSingleton instance = EnumSingleton.instance;
        
        // 测试基本操作
        assertNotNull(instance);
        assertEquals("instance", instance.name());
        assertEquals(0, instance.ordinal());
        
        // 测试比较操作
        assertEquals(instance, EnumSingleton.instance);
        assertTrue(instance.compareTo(EnumSingleton.instance) == 0);
    }

    @Test
    @DisplayName("测试枚举单例的类型安全")
    void testTypeSafety() {
        // 枚举提供了编译时的类型安全
        EnumSingleton instance = EnumSingleton.instance;
        
        // 验证类型
        assertInstanceOf(EnumSingleton.class, instance);
        assertInstanceOf(Enum.class, instance);
        
        // 验证枚举类型
        assertEquals(EnumSingleton.class, instance.getClass());
    }
}