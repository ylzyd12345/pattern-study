package com.kevin.demo.creational.abstractFactory;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 抽象工厂模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("抽象工厂模式测试")
class AbstractFactoryTest extends BasePatternTest {

    @Test
    @DisplayName("测试海尔工厂创建海尔电视")
    void testHaierFactoryCreatesHaierTV() {
        HaierFactory factory = new HaierFactoryImpl();
        HaierTV tv = factory.createTV();
        
        assertNotNull(tv, "创建的海尔电视不应该为null");
        assertInstanceOf(HaierTV.class, tv, "应该是海尔电视类型");
        assertEquals("海尔电视播放", tv.play(), "海尔电视播放功能应该正常");
    }

    @Test
    @DisplayName("测试海尔工厂创建海尔洗衣机")
    void testHaierFactoryCreatesHaierWasher() {
        HaierFactory factory = new HaierFactoryImpl();
        HaierWasher washer = factory.createWasher();
        
        assertNotNull(washer, "创建的海尔洗衣机不应该为null");
        assertInstanceOf(HaierWasher.class, washer, "应该是海尔洗衣机类型");
        assertEquals("海尔洗衣机洗涤", washer.wash(), "海尔洗衣机洗涤功能应该正常");
    }

    @Test
    @DisplayName("测试抽象工厂创建产品族")
    void testAbstractFactoryCreatesProductFamily() {
        HaierFactory factory = new HaierFactoryImpl();
        
        // 创建同一产品族的产品
        HaierTV tv = factory.createTV();
        HaierWasher washer = factory.createWasher();
        
        assertNotNull(tv, "海尔电视不应该为null");
        assertNotNull(washer, "海尔洗衣机不应该为null");
        
        // 验证产品属于同一品牌（海尔）
        assertTrue(tv.play().contains("海尔"), "电视应该是海尔品牌");
        assertTrue(washer.wash().contains("海尔"), "洗衣机应该是海尔品牌");
    }

    @Test
    @DisplayName("测试抽象工厂保证产品兼容性")
    void testAbstractFactoryEnsuresProductCompatibility() {
        HaierFactory factory = new HaierFactoryImpl();
        
        // 创建兼容的产品组合
        HaierTV tv = factory.createTV();
        HaierWasher washer = factory.createWasher();
        
        // 验证产品之间的兼容性
        // 在实际应用中，这可能包括接口兼容、协议兼容等
        assertNotNull(tv, "电视应该存在");
        assertNotNull(washer, "洗衣机应该存在");
        
        // 测试产品协同工作（模拟场景）
        String tvStatus = tv.play();
        String washerStatus = washer.wash();
        
        assertNotNull(tvStatus, "电视状态不应该为null");
        assertNotNull(washerStatus, "洗衣机状态不应该为null");
    }

    @Nested
    @DisplayName("产品功能测试")
    class ProductFunctionalityTest {
        
        @Test
        @DisplayName("测试海尔电视功能")
        void testHaierTVFunctionality() {
            HaierFactory factory = new HaierFactoryImpl();
            HaierTV tv = factory.createTV();
            
            // 测试播放功能
            String playResult = tv.play();
            assertNotNull(playResult, "播放结果不应该为null");
            assertEquals("海尔电视播放", playResult, "海尔电视播放功能应该正确");
        }

        @Test
        @DisplayName("测试海尔洗衣机功能")
        void testHaierWasherFunctionality() {
            HaierFactory factory = new HaierFactoryImpl();
            HaierWasher washer = factory.createWasher();
            
            // 测试洗涤功能
            String washResult = washer.wash();
            assertNotNull(washResult, "洗涤结果不应该为null");
            assertEquals("海尔洗衣机洗涤", washResult, "海尔洗衣机洗涤功能应该正确");
        }
    }

    @Test
    @DisplayName("测试抽象工厂的解耦特性")
    void testAbstractFactoryDecoupling() {
        // 抽象工厂模式的核心优势：客户端代码与具体产品族解耦
        // 客户端只需要知道抽象工厂接口和抽象产品接口
        
        HaierFactory factory = createHaierFactory();
        HaierTV tv = factory.createTV();
        HaierWasher washer = factory.createWasher();
        
        assertNotNull(tv, "通过抽象工厂创建的电视不应该为null");
        assertNotNull(washer, "通过抽象工厂创建的洗衣机不应该为null");
        
        assertTrue(tv.play().contains("播放"), "电视应该能正常播放");
        assertTrue(washer.wash().contains("洗涤"), "洗衣机应该能正常洗涤");
    }

    /**
     * 创建海尔工厂（模拟工厂选择逻辑）
     */
    private HaierFactory createHaierFactory() {
        return new HaierFactoryImpl();
    }

    @Test
    @DisplayName("测试抽象工厂的一致性")
    void testAbstractFactoryConsistency() {
        // 测试同一工厂创建的产品风格一致性
        
        HaierFactory factory = new HaierFactoryImpl();
        
        HaierTV tv1 = factory.createTV();
        HaierTV tv2 = factory.createTV();
        HaierWasher washer1 = factory.createWasher();
        HaierWasher washer2 = factory.createWasher();
        
        // 验证同类型产品的一致性
        assertEquals(tv1.play(), tv2.play(), "同工厂创建的电视行为应该一致");
        assertEquals(washer1.wash(), washer2.wash(), "同工厂创建的洗衣机行为应该一致");
        
        // 验证产品族的一致性
        assertTrue(tv1.play().contains("海尔"), "电视应该属于海尔品牌");
        assertTrue(washer1.wash().contains("海尔"), "洗衣机应该属于海尔品牌");
    }

    @Nested
    @DisplayName("工厂扩展性测试")
    class FactoryExtensibilityTest {
        
        @Test
        @DisplayName("测试抽象工厂的可扩展性")
        void testAbstractFactoryExtensibility() {
            // 抽象工厂模式的一个优势是易于扩展产品族
            // 如果需要添加新的产品类型，只需要：
            // 1. 在抽象工厂中添加新的创建方法
            // 2. 在具体工厂中实现新的创建方法
            // 3. 创建新的产品类
            
            HaierFactory factory = new HaierFactoryImpl();
            
            // 验证当前支持的产品类型
            HaierTV tv = factory.createTV();
            HaierWasher washer = factory.createWasher();
            
            assertNotNull(tv, "工厂应该能创建电视");
            assertNotNull(washer, "工厂应该能创建洗衣机");
            
            assertTrue(tv instanceof HaierTV, "电视应该实现HaierTV接口");
            assertTrue(washer instanceof HaierWasher, "洗衣机应该实现HaierWasher接口");
        }
    }

    @Test
    @DisplayName("测试抽象工厂的产品族约束")
    void testAbstractFactoryProductFamilyConstraint() {
        // 抽象工厂模式的一个重要特性：产品族约束
        // 一个工厂只能创建同一产品族的产品
        
        HaierFactory factory = new HaierFactoryImpl();
        
        // 创建的产品都应该属于海尔产品族
        HaierTV tv = factory.createTV();
        HaierWasher washer = factory.createWasher();
        
        // 验证产品族约束
        String tvBrand = tv.play();
        String washerBrand = washer.wash();
        
        assertTrue(tvBrand.contains("海尔"), "电视应该属于海尔产品族");
        assertTrue(washerBrand.contains("海尔"), "洗衣机应该属于海尔产品族");
        
        // 在实际应用中，这确保了产品之间的兼容性
        assertNotEquals(tvBrand, washerBrand, "不同类型产品应该有不同的功能描述");
    }

    @Test
    @DisplayName("测试抽象工厂的批量创建")
    void testAbstractFactoryBatchCreation() {
        // 测试抽象工厂批量创建产品的能力
        
        HaierFactory factory = new HaierFactoryImpl();
        
        // 批量创建产品
        HaierTV[] tvs = new HaierTV[3];
        HaierWasher[] washers = new HaierWasher[3];
        
        for (int i = 0; i < 3; i++) {
            tvs[i] = factory.createTV();
            washers[i] = factory.createWasher();
        }
        
        // 验证批量创建的结果
        for (HaierTV tv : tvs) {
            assertNotNull(tv, "每个电视都不应该为null");
            assertEquals("海尔电视播放", tv.play(), "每个电视的功能应该一致");
        }
        
        for (HaierWasher washer : washers) {
            assertNotNull(washer, "每个洗衣机都不应该为null");
            assertEquals("海尔洗衣机洗涤", washer.wash(), "每个洗衣机的功能应该一致");
        }
    }

    @Test
    @DisplayName("测试抽象工厂的延迟创建")
    void testAbstractFactoryLazyCreation() {
        // 抽象工厂模式支持延迟创建
        // 只有在调用创建方法时才创建具体的产品实例
        
        HaierFactory factory = new HaierFactoryImpl();
        
        // 此时还没有创建具体的产品实例
        // 只有调用createTV()和createWasher()时才会创建
        
        HaierTV tv = factory.createTV();
        HaierWasher washer = factory.createWasher();
        
        assertNotNull(tv, "调用createTV()后应该创建电视实例");
        assertNotNull(washer, "调用createWasher()后应该创建洗衣机实例");
        
        assertInstanceOf(HaierTV.class, tv, "应该是海尔电视实例");
        assertInstanceOf(HaierWasher.class, washer, "应该是海尔洗衣机实例");
    }

    @Test
    @DisplayName("测试抽象工厂控制台输出")
    void testAbstractFactoryConsoleOutput() {
        HaierFactory factory = new HaierFactoryImpl();
        
        // 清空控制台输出
        clearConsoleOutput();
        
        // 创建产品并调用功能
        HaierTV tv = factory.createTV();
        HaierWasher washer = factory.createWasher();
        
        tv.play();
        washer.wash();
        
        // 验证控制台输出
        assertConsoleOutputContains("海尔电视播放");
        assertConsoleOutputContains("海尔洗衣机洗涤");
    }
}

/**
 * 海尔工厂实现类（假设存在）
 */
class HaierFactoryImpl implements HaierFactory {
    @Override
    public HaierTV createTV() {
        return new HaierTVImpl();
    }

    @Override
    public HaierWasher createWasher() {
        return new HaierWasherImpl();
    }
}

/**
 * 海尔电视实现类（假设存在）
 */
class HaierTVImpl implements HaierTV {
    @Override
    public String play() {
        System.out.println("海尔电视播放");
        return "海尔电视播放";
    }
}

/**
 * 海尔洗衣机实现类（假设存在）
 */
class HaierWasherImpl implements HaierWasher {
    @Override
    public String wash() {
        System.out.println("海尔洗衣机洗涤");
        return "海尔洗衣机洗涤";
    }
}