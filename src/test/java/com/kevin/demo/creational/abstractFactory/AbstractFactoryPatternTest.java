package com.kevin.demo.creational.abstractFactory;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 抽象工厂模式测试类
 * 测试抽象工厂模式的实现，包括产品族的创建
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("抽象工厂模式测试")
class AbstractFactoryPatternTest extends BasePatternTest {

    private HaierFactory haierFactory;

    @BeforeEach
    void setUp() {
        super.setUp();
        haierFactory = new HaierFactory();
    }

    @Test
    @DisplayName("测试海尔电视创建")
    void testHaierTVCreation() {
        // 创建海尔电视
        HaierTVFactory tvFactory = haierFactory.createTVFactory();
        HaierTV tv = tvFactory.createTV();
        
        // 测试电视功能
        tv.play();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("海尔电视播放"));
    }

    @Test
    @DisplayName("测试海尔洗衣机创建")
    void testHaierWasherCreation() {
        // 创建海尔洗衣机
        HaierWasherFactory washerFactory = haierFactory.createWasherFactory();
        HaierWasher washer = washerFactory.createWasher();
        
        // 测试洗衣机功能
        washer.wash();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("海尔洗衣机洗衣"));
    }

    @Test
    @DisplayName("测试完整产品族创建")
    void testCompleteProductFamilyCreation() {
        // 创建海尔电视
        HaierTVFactory tvFactory = haierFactory.createTVFactory();
        HaierTV tv = tvFactory.createTV();
        tv.play();
        
        clearConsoleOutput();
        
        // 创建海尔洗衣机
        HaierWasherFactory washerFactory = haierFactory.createWasherFactory();
        HaierWasher washer = washerFactory.createWasher();
        washer.wash();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("海尔洗衣机洗衣"));
    }

    @Test
    @DisplayName("测试类型识别")
    void testTypeIdentification() {
        // 验证工厂类型
        assertInstanceOf(HaierFactory.class, haierFactory);
        
        // 验证产品工厂类型
        HaierTVFactory tvFactory = haierFactory.createTVFactory();
        HaierWasherFactory washerFactory = haierFactory.createWasherFactory();
        
        assertInstanceOf(HaierTVFactory.class, tvFactory);
        assertInstanceOf(HaierWasherFactory.class, washerFactory);
        
        // 验证产品类型
        HaierTV tv = tvFactory.createTV();
        HaierWasher washer = washerFactory.createWasher();
        
        assertInstanceOf(HaierTV.class, tv);
        assertInstanceOf(HaierWasher.class, washer);
    }

    @Test
    @DisplayName("测试产品族一致性")
    void testProductFamilyConsistency() {
        // 创建海尔产品族
        HaierTVFactory tvFactory = haierFactory.createTVFactory();
        HaierWasherFactory washerFactory = haierFactory.createWasherFactory();
        
        HaierTV tv = tvFactory.createTV();
        HaierWasher washer = washerFactory.createWasher();
        
        // 测试产品功能
        tv.play();
        washer.wash();
        
        String output = getConsoleOutput();
        
        // 验证产品属于同一品牌
        assertTrue(output.contains("海尔电视"));
        assertTrue(output.contains("海尔洗衣机"));
    }

    @Test
    @DisplayName("测试工厂方法多次调用")
    void testFactoryMethodMultipleCalls() {
        // 多次创建电视
        HaierTVFactory tvFactory = haierFactory.createTVFactory();
        HaierTV tv1 = tvFactory.createTV();
        HaierTV tv2 = tvFactory.createTV();
        HaierTV tv3 = tvFactory.createTV();
        
        // 验证每个电视都是独立对象
        assertNotSame(tv1, tv2);
        assertNotSame(tv2, tv3);
        assertNotSame(tv1, tv3);
        
        // 测试每个电视都能正常工作
        tv1.play();
        clearConsoleOutput();
        tv2.play();
        clearConsoleOutput();
        tv3.play();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("海尔电视播放"));
    }

    @Test
    @DisplayName("测试抽象工厂扩展性")
    void testAbstractFactoryExtensibility() {
        // 创建新的抽象工厂实现
        class NewBrandFactory {
            public NewBrandTVFactory createTVFactory() {
                return new NewBrandTVFactory();
            }
            
            public NewBrandWasherFactory createWasherFactory() {
                return new NewBrandWasherFactory();
            }
        }
        
        class NewBrandTVFactory {
            public NewBrandTV createTV() {
                return new NewBrandTV();
            }
        }
        
        class NewBrandWasherFactory {
            public NewBrandWasher createWasher() {
                return new NewBrandWasher();
            }
        }
        
        class NewBrandTV {
            public void play() {
                System.out.println("新品牌电视播放");
            }
        }
        
        class NewBrandWasher {
            public void wash() {
                System.out.println("新品牌洗衣机洗衣");
            }
        }
        
        // 使用新工厂
        NewBrandFactory newFactory = new NewBrandFactory();
        NewBrandTVFactory newTVFactory = newFactory.createTVFactory();
        NewBrandTV newTV = newTVFactory.createTV();
        newTV.play();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("新品牌电视播放"));
    }

    @Test
    @DisplayName("测试产品族独立创建")
    void testProductFamilyIndependentCreation() {
        // 独立创建电视工厂
        HaierTVFactory tvFactory = haierFactory.createTVFactory();
        HaierTV tv = tvFactory.createTV();
        tv.play();
        
        String tvOutput = getConsoleOutput();
        assertTrue(tvOutput.contains("海尔电视播放"));
        
        clearConsoleOutput();
        
        // 独立创建洗衣机工厂
        HaierWasherFactory washerFactory = haierFactory.createWasherFactory();
        HaierWasher washer = washerFactory.createWasher();
        washer.wash();
        
        String washerOutput = getConsoleOutput();
        assertTrue(washerOutput.contains("海尔洗衣机洗衣"));
        
        // 验证两个产品可以独立创建和使用
        assertNotEquals(tvOutput, washerOutput);
    }

    @Test
    @DisplayName("测试抽象工厂层次结构")
    void testAbstractFactoryHierarchy() {
        // 测试工厂层次结构
        HaierTVFactory tvFactory = haierFactory.createTVFactory();
        HaierWasherFactory washerFactory = haierFactory.createWasherFactory();
        
        // 验证工厂可以创建产品
        assertNotNull(tvFactory);
        assertNotNull(washerFactory);
        
        HaierTV tv = tvFactory.createTV();
        HaierWasher washer = washerFactory.createWasher();
        
        // 验证产品功能
        assertNotNull(tv);
        assertNotNull(washer);
        
        tv.play();
        washer.wash();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("海尔电视播放"));
        assertTrue(output.contains("海尔洗衣机洗衣"));
    }

    @Test
    @DisplayName("测试抽象工厂性能")
    void testAbstractFactoryPerformance() {
        // 测试抽象工厂的性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                HaierFactory factory = new HaierFactory();
                HaierTVFactory tvFactory = factory.createTVFactory();
                HaierTV tv = tvFactory.createTV();
                tv.play();
                clearConsoleOutput();
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试并发产品创建")
    void testConcurrentProductCreation() throws InterruptedException {
        // 多线程测试产品创建
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                HaierFactory localFactory = new HaierFactory();
                if (threadId % 2 == 0) {
                    HaierTVFactory localTVFactory = localFactory.createTVFactory();
                    HaierTV localTV = localTVFactory.createTV();
                    localTV.play();
                } else {
                    HaierWasherFactory localWasherFactory = localFactory.createWasherFactory();
                    HaierWasher localWasher = localWasherFactory.createWasher();
                    localWasher.wash();
                }
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
        
        // 验证没有异常抛出
        String output = getConsoleOutput();
        assertTrue(output.length() > 0);
    }

    @Test
    @DisplayName("测试产品族协作")
    void testProductFamilyCollaboration() {
        // 创建产品族
        HaierTVFactory tvFactory = haierFactory.createTVFactory();
        HaierWasherFactory washerFactory = haierFactory.createWasherFactory();
        
        HaierTV tv = tvFactory.createTV();
        HaierWasher washer = washerFactory.createWasher();
        
        // 模拟产品协作场景
        tv.play();
        System.out.println("和");
        washer.wash();
        System.out.println("同时运行");
        
        String output = getConsoleOutput();
        assertTrue(output.contains("海尔电视播放"));
        assertTrue(output.contains("和"));
        assertTrue(output.contains("海尔洗衣机洗衣"));
        assertTrue(output.contains("同时运行"));
    }

    @Test
    @DisplayName("测试抽象工厂设计原则")
    void testAbstractFactoryDesignPrinciples() {
        // 验证抽象工厂模式的设计原则
        
        // 1. 产品族一致性
        HaierTVFactory tvFactory = haierFactory.createTVFactory();
        HaierWasherFactory washerFactory = haierFactory.createWasherFactory();
        
        HaierTV tv = tvFactory.createTV();
        HaierWasher washer = washerFactory.createWasher();
        
        tv.play();
        washer.wash();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("海尔电视"));
        assertTrue(output.contains("海尔洗衣机"));
        
        // 2. 工厂与产品分离
        // 客户端只需要知道抽象工厂接口
        
        // 3. 产品族扩展性
        // 可以通过添加新的工厂实现来支持新的产品族
        
        // 4. 单一职责原则
        // 每个工厂只负责创建一种产品
        assertInstanceOf(HaierTVFactory.class, tvFactory);
        assertInstanceOf(HaierWasherFactory.class, washerFactory);
    }

    @Test
    @DisplayName("测试复杂产品族创建")
    void testComplexProductFamilyCreation() {
        // 创建多个产品族实例
        HaierFactory[] factories = new HaierFactory[5];
        HaierTV[] tvs = new HaierTV[5];
        HaierWasher[] washers = new HaierWasher[5];
        
        // 创建多个产品族
        for (int i = 0; i < 5; i++) {
            factories[i] = new HaierFactory();
            HaierTVFactory tvFactory = factories[i].createTVFactory();
            HaierWasherFactory washerFactory = factories[i].createWasherFactory();
            
            tvs[i] = tvFactory.createTV();
            washers[i] = washerFactory.createWasher();
        }
        
        // 测试所有产品
        for (int i = 0; i < 5; i++) {
            tvs[i].play();
            washers[i].wash();
            clearConsoleOutput();
        }
        
        // 验证所有产品都是独立对象
        for (int i = 1; i < 5; i++) {
            assertNotSame(tvs[0], tvs[i]);
            assertNotSame(washers[0], washers[i]);
        }
        
        // 验证所有产品都能正常工作
        tvs[0].play();
        washers[0].wash();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("海尔电视播放"));
        assertTrue(output.contains("海尔洗衣机洗衣"));
    }
}