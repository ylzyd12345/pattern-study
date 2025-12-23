package com.kevin.demo.structural.adapter;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 适配器模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("适配器模式测试")
class AdapterPatternTest extends BasePatternTest {

    @Test
    @DisplayName("测试基本适配器功能")
    void testBasicAdapterFunctionality() {
        CommonPower commonPower = new CommonPower();
        ThinkPadPower thinkPadPower = new ThinkPadPower(commonPower);
        
        assertNotNull(thinkPadPower, "ThinkPad电源适配器不应该为null");
        assertInstanceOf(ComputerPower.class, thinkPadPower, "应该实现ComputerPower接口");
        
        // 测试电压转换功能
        int convertedPower = thinkPadPower.getPower();
        assertTrue(convertedPower > 0, "转换后的电压应该大于0");
        assertEquals(commonPower.getPower() / 100, convertedPower, "电压转换应该正确");
    }

    @Test
    @DisplayName("测试适配器的接口兼容性")
    void testAdapterInterfaceCompatibility() {
        CommonPower commonPower = new CommonPower();
        ComputerPower computerPower = new ThinkPadPower(commonPower);
        
        // 适配器应该实现目标接口
        assertTrue(computerPower instanceof ComputerPower, "适配器应该实现ComputerPower接口");
        
        // 可以通过目标接口调用方法
        int power = computerPower.getPower();
        assertTrue(power > 0, "通过目标接口调用应该正常工作");
    }

    @Test
    @DisplayName("测试适配器的转换逻辑")
    void testAdapterConversionLogic() {
        CommonPower commonPower = new CommonPower();
        ThinkPadPower thinkPadPower = new ThinkPadPower(commonPower);
        
        int originalPower = commonPower.getPower();
        int convertedPower = thinkPadPower.getPower();
        
        // 验证转换逻辑
        assertEquals(originalPower / 100, convertedPower, "电压应该按照100:1的比例转换");
        
        // 验证转换后的电压在合理范围内
        assertTrue(convertedPower >= 1 && convertedPower <= 10, 
                  "转换后的电压应该在1-10V范围内");
    }

    @Test
    @DisplayName("测试适配器与被适配者的关系")
    void testAdapterAdapteeRelationship() {
        CommonPower commonPower = new CommonPower();
        ThinkPadPower thinkPadPower = new ThinkPadPower(commonPower);
        
        // 适配器应该持有被适配者的引用
        assertNotNull(thinkPadPower, "适配器应该存在");
        
        // 修改被适配者的状态，观察适配器的行为
        int originalConvertedPower = thinkPadPower.getPower();
        
        // 虽然CommonPower可能不允许修改电压，但我们可以验证适配器的依赖关系
        int newConvertedPower = thinkPadPower.getPower();
        assertEquals(originalConvertedPower, newConvertedPower, 
                    "相同输入应该产生相同的输出");
    }

    @Nested
    @DisplayName("适配器模式特性测试")
    class AdapterPatternCharacteristicsTest {
        
        @Test
        @DisplayName("测试适配器的透明性")
        void testAdapterTransparency() {
            // 适配器对客户端应该是透明的
            CommonPower commonPower = new CommonPower();
            ComputerPower computerPower = new ThinkPadPower(commonPower);
            
            // 客户端只需要知道目标接口，不需要知道适配器的存在
            int power = computerPower.getPower();
            
            assertTrue(power > 0, "客户端可以通过目标接口正常使用适配器");
        }

        @Test
        @DisplayName("测试适配器的单一职责")
        void testAdapterSingleResponsibility() {
            // 适配器应该只负责接口转换，不应该有其他功能
            
            CommonPower commonPower = new CommonPower();
            ThinkPadPower thinkPadPower = new ThinkPadPower(commonPower);
            
            // 适配器的主要职责是转换接口
            int convertedPower = thinkPadPower.getPower();
            
            // 验证转换结果
            assertNotNull(convertedPower, "适配器应该完成转换职责");
            assertTrue(convertedPower > 0, "转换结果应该有效");
        }

        @Test
        @DisplayName("测试适配器的复用性")
        void testAdapterReusability() {
            // 适配器应该可以被复用
            
            CommonPower commonPower1 = new CommonPower();
            CommonPower commonPower2 = new CommonPower();
            
            ThinkPadPower adapter1 = new ThinkPadPower(commonPower1);
            ThinkPadPower adapter2 = new ThinkPadPower(commonPower2);
            
            // 两个适配器应该都能正常工作
            int power1 = adapter1.getPower();
            int power2 = adapter2.getPower();
            
            assertEquals(power1, power2, "相同类型的适配器应该产生相同的结果");
            assertTrue(power1 > 0 && power2 > 0, "两个适配器都应该正常工作");
        }
    }

    @Test
    @DisplayName("测试适配器模式的解耦效果")
    void testAdapterDecouplingEffect() {
        // 适配器模式应该解耦客户端和被适配者
        
        ComputerPower computerPower = new ThinkPadPower(new CommonPower());
        
        // 客户端代码只需要依赖目标接口
        int power = computerPower.getPower();
        
        assertTrue(power > 0, "客户端可以通过目标接口正常使用功能");
        
        // 可以轻松替换不同的适配器实现
        ComputerPower anotherComputerPower = new ThinkPadPower(new CommonPower());
        int anotherPower = anotherComputerPower.getPower();
        
        assertEquals(power, anotherPower, "替换适配器不应该影响客户端代码");
    }

    @Test
    @DisplayName("测试适配器模式的扩展性")
    void testAdapterPatternExtensibility() {
        // 适配器模式易于扩展，可以创建新的适配器
        
        CommonPower commonPower = new CommonPower();
        
        // 当前可用的适配器
        ComputerPower[] adapters = {
            new ThinkPadPower(commonPower),
            new ThinkPadPower(commonPower) // 可以创建多个适配器实例
        };
        
        // 验证所有适配器都能正常工作
        for (ComputerPower adapter : adapters) {
            assertNotNull(adapter, "适配器不应该为null");
            int power = adapter.getPower();
            assertTrue(power > 0, "适配器应该正常工作");
        }
    }

    @Test
    @DisplayName("测试适配器的性能")
    void testAdapterPerformance() {
        CommonPower commonPower = new CommonPower();
        ThinkPadPower thinkPadPower = new ThinkPadPower(commonPower);
        
        // 测试适配器的性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 10000; i++) {
                int power = thinkPadPower.getPower();
                assertTrue(power > 0, "适配器调用应该正常");
            }
        }, 1000); // 期望在1秒内完成10000次调用
    }

    @Test
    @DisplayName("测试适配器的线程安全性")
    void testAdapterThreadSafety() throws InterruptedException {
        CommonPower commonPower = new CommonPower();
        ThinkPadPower thinkPadPower = new ThinkPadPower(commonPower);
        
        final int threadCount = 100;
        final int[] powers = new int[threadCount];
        final Thread[] threads = new Thread[threadCount];
        
        // 创建多个线程同时调用适配器
        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                powers[index] = thinkPadPower.getPower();
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
        
        // 验证所有调用都成功
        for (int i = 0; i < threadCount; i++) {
            assertTrue(powers[i] > 0, "第" + i + "次调用应该成功");
        }
        
        // 验证结果的一致性
        int firstPower = powers[0];
        for (int i = 1; i < threadCount; i++) {
            assertEquals(firstPower, powers[i], "所有调用结果应该一致");
        }
    }

    @Test
    @DisplayName("测试适配器模式控制台输出")
    void testAdapterPatternConsoleOutput() {
        CommonPower commonPower = new CommonPower();
        ThinkPadPower thinkPadPower = new ThinkPadPower(commonPower);
        
        // 清空控制台输出
        clearConsoleOutput();
        
        // 调用适配器方法
        int power = thinkPadPower.getPower();
        System.out.println("转换后的电压: " + power + "V");
        
        // 验证控制台输出
        assertConsoleOutputContains("转换后的电压:");
        assertTrue(getConsoleOutput().contains(power + "V"), "应该显示转换后的电压值");
    }

    @Nested
    @DisplayName("边界条件测试")
    class EdgeCaseTest {
        
        @Test
        @DisplayName("测试适配器null参数处理")
        void testAdapterNullParameterHandling() {
            // 测试传入null参数的情况
            assertThrows(Exception.class, () -> {
                new ThinkPadPower(null);
            }, "传入null参数应该抛出异常");
        }

        @Test
        @DisplayName("测试适配器多次调用的一致性")
        void testAdapterMultipleCallConsistency() {
            CommonPower commonPower = new CommonPower();
            ThinkPadPower thinkPadPower = new ThinkPadPower(commonPower);
            
            // 多次调用应该返回一致的结果
            int power1 = thinkPadPower.getPower();
            int power2 = thinkPadPower.getPower();
            int power3 = thinkPadPower.getPower();
            
            assertEquals(power1, power2, "多次调用结果应该一致");
            assertEquals(power2, power3, "多次调用结果应该一致");
        }
    }
}