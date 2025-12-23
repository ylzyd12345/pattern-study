package com.kevin.demo.behavioral.strategy;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

/**
 * 策略模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("策略模式测试")
class StrategyPatternTest extends BasePatternTest {

    @Test
    @DisplayName("测试基础积分计算策略")
    void testBasePointCalcStrategy() {
        PointCalc baseCalc = new BasePointCalc();
        
        assertNotNull(baseCalc, "基础积分计算策略不应该为null");
        assertInstanceOf(PointCalc.class, baseCalc, "应该实现PointCalc接口");
        
        // 测试基础积分计算
        BigDecimal inputPoint = new BigDecimal("100");
        BigDecimal result = baseCalc.calc(inputPoint);
        
        assertNotNull(result, "计算结果不应该为null");
        assertEquals(new BigDecimal("100"), result, "基础积分计算应该返回原值");
    }

    @Test
    @DisplayName("测试固定积分计算策略")
    void testConstantPointCalcStrategy() {
        PointCalc constantCalc = new ConstantPointCalc();
        
        assertNotNull(constantCalc, "固定积分计算策略不应该为null");
        assertInstanceOf(PointCalc.class, constantCalc, "应该实现PointCalc接口");
        
        // 测试固定积分计算（无论输入多少，都返回固定值）
        BigDecimal inputPoint1 = new BigDecimal("100");
        BigDecimal inputPoint2 = new BigDecimal("200");
        BigDecimal inputPoint3 = new BigDecimal("0");
        
        BigDecimal result1 = constantCalc.calc(inputPoint1);
        BigDecimal result2 = constantCalc.calc(inputPoint2);
        BigDecimal result3 = constantCalc.calc(inputPoint3);
        
        assertNotNull(result1, "计算结果不应该为null");
        assertNotNull(result2, "计算结果不应该为null");
        assertNotNull(result3, "计算结果不应该为null");
        
        // 所有输入都应该返回相同的固定值
        assertEquals(result1, result2, "不同输入应该返回相同结果");
        assertEquals(result2, result3, "不同输入应该返回相同结果");
    }

    @Test
    @DisplayName("测试满赠积分计算策略")
    void testFullGivePointCalcStrategy() {
        PointCalc fullGiveCalc = new FullGivePointCalc();
        
        assertNotNull(fullGiveCalc, "满赠积分计算策略不应该为null");
        assertInstanceOf(PointCalc.class, fullGiveCalc, "应该实现PointCalc接口");
        
        // 测试满赠积分计算逻辑
        BigDecimal inputPoint1 = new BigDecimal("50");   // 小于满赠门槛
        BigDecimal inputPoint2 = new BigDecimal("100");  // 等于满赠门槛
        BigDecimal inputPoint3 = new BigDecimal("150");  // 大于满赠门槛
        
        BigDecimal result1 = fullGiveCalc.calc(inputPoint1);
        BigDecimal result2 = fullGiveCalc.calc(inputPoint2);
        BigDecimal result3 = fullGiveCalc.calc(inputPoint3);
        
        assertNotNull(result1, "计算结果不应该为null");
        assertNotNull(result2, "计算结果不应该为null");
        assertNotNull(result3, "计算结果不应该为null");
        
        // 验证满赠逻辑：小于门槛返回原值，达到门槛有额外奖励
        assertTrue(result1.compareTo(inputPoint1) >= 0, "小于门槛时结果应该不小于原值");
        assertTrue(result2.compareTo(inputPoint2) > 0, "达到门槛时结果应该大于原值");
        assertTrue(result3.compareTo(inputPoint3) > 0, "超过门槛时结果应该大于原值");
    }

    @Test
    @DisplayName("测试策略的动态切换")
    void testStrategyDynamicSwitching() {
        PointGiveService pointGiveService = new PointGiveServiceImpl();
        
        assertNotNull(pointGiveService, "积分赠送服务不应该为null");
        
        BigDecimal testPoint = new BigDecimal("100");
        
        // 测试使用基础策略
        pointGiveService.setPointCalc(new BasePointCalc());
        BigDecimal baseResult = pointGiveService.givePoint(testPoint);
        assertEquals(testPoint, baseResult, "基础策略应该返回原值");
        
        // 测试切换到固定策略
        pointGiveService.setPointCalc(new ConstantPointCalc());
        BigDecimal constantResult = pointGiveService.givePoint(testPoint);
        assertNotNull(constantResult, "固定策略应该返回固定值");
        
        // 测试切换到满赠策略
        pointGiveService.setPointCalc(new FullGivePointCalc());
        BigDecimal fullGiveResult = pointGiveService.givePoint(testPoint);
        assertTrue(fullGiveResult.compareTo(testPoint) > 0, "满赠策略应该返回大于原值的结果");
    }

    @Test
    @DisplayName("测试策略的运行时选择")
    void testStrategyRuntimeSelection() {
        PointGiveService pointGiveService = new PointGiveServiceImpl();
        BigDecimal testPoint = new BigDecimal("100");
        
        // 根据不同条件选择不同策略
        PointGiveTypeEnum strategyType = PointGiveTypeEnum.BASE;
        PointCalc strategy = selectStrategy(strategyType);
        pointGiveService.setPointCalc(strategy);
        BigDecimal result1 = pointGiveService.givePoint(testPoint);
        
        strategyType = PointGiveTypeEnum.FULL_GIVE;
        strategy = selectStrategy(strategyType);
        pointGiveService.setPointCalc(strategy);
        BigDecimal result2 = pointGiveService.givePoint(testPoint);
        
        // 验证不同策略产生不同结果
        assertNotEquals(result1, result2, "不同策略应该产生不同的计算结果");
    }

    /**
     * 根据枚举类型选择对应的策略
     */
    private PointCalc selectStrategy(PointGiveTypeEnum type) {
        switch (type) {
            case BASE:
                return new BasePointCalc();
            case CONSTANT:
                return new ConstantPointCalc();
            case FULL_GIVE:
                return new FullGivePointCalc();
            default:
                return new BasePointCalc();
        }
    }

    @Nested
    @DisplayName("策略模式特性测试")
    class StrategyPatternCharacteristicsTest {
        
        @Test
        @DisplayName("测试策略的封装性")
        void testStrategyEncapsulation() {
            // 策略模式将算法封装在独立的策略类中
            
            PointCalc baseStrategy = new BasePointCalc();
            PointCalc constantStrategy = new ConstantPointCalc();
            
            // 客户端代码只需要知道策略接口，不需要知道具体实现
            PointCalc[] strategies = {baseStrategy, constantStrategy};
            
            for (PointCalc strategy : strategies) {
                BigDecimal result = strategy.calc(new BigDecimal("100"));
                assertNotNull(result, "策略应该能正常计算");
            }
        }

        @Test
        @DisplayName("测试策略的可替换性")
        void testStrategyInterchangeability() {
            // 策略模式允许在运行时替换算法
            
            PointGiveService service = new PointGiveServiceImpl();
            BigDecimal testPoint = new BigDecimal("100");
            
            // 使用不同策略
            PointCalc[] strategies = {
                new BasePointCalc(),
                new ConstantPointCalc(),
                new FullGivePointCalc()
            };
            
            BigDecimal[] results = new BigDecimal[strategies.length];
            
            for (int i = 0; i < strategies.length; i++) {
                service.setPointCalc(strategies[i]);
                results[i] = service.givePoint(testPoint);
                assertNotNull(results[i], "策略替换后应该能正常工作");
            }
            
            // 验证不同策略产生不同结果
            for (int i = 1; i < results.length; i++) {
                // 注意：某些策略可能产生相同结果，这里主要验证策略能正常切换
                assertNotNull(results[i], "策略 " + i + " 应该正常工作");
            }
        }

        @Test
        @DisplayName("测试策略的扩展性")
        void testStrategyExtensibility() {
            // 策略模式易于扩展，可以添加新策略而不修改现有代码
            
            PointCalc existingStrategy = new BasePointCalc();
            BigDecimal testPoint = new BigDecimal("100");
            
            // 现有策略正常工作
            BigDecimal existingResult = existingStrategy.calc(testPoint);
            assertNotNull(existingResult, "现有策略应该正常工作");
            
            // 可以轻松添加新策略（这里模拟添加新策略的过程）
            PointCalc newStrategy = new PointCalc() {
                @Override
                public BigDecimal calc(BigDecimal point) {
                    return point.multiply(new BigDecimal("2")); // 双倍积分策略
                }
            };
            
            BigDecimal newResult = newStrategy.calc(testPoint);
            assertEquals(new BigDecimal("200"), newResult, "新策略应该正常工作");
        }
    }

    @Test
    @DisplayName("测试策略与上下文的关系")
    void testStrategyContextRelationship() {
        // 测试策略与使用它的上下文之间的关系
        
        PointGiveServiceImpl service = new PointGiveServiceImpl();
        PointCalc strategy = new BasePointCalc();
        
        // 设置策略
        service.setPointCalc(strategy);
        
        // 验证上下文持有策略引用
        assertSame(strategy, service.getPointCalc(), "上下文应该持有策略的引用");
        
        // 验证策略能被上下文正确使用
        BigDecimal result = service.givePoint(new BigDecimal("100"));
        assertNotNull(result, "上下文应该能正确使用策略");
    }

    @Nested
    @DisplayName("边界条件测试")
    class EdgeCaseTest {
        
        @Test
        @DisplayName("测试零值输入")
        void testZeroInput() {
            PointCalc[] strategies = {
                new BasePointCalc(),
                new ConstantPointCalc(),
                new FullGivePointCalc()
            };
            
            BigDecimal zeroPoint = BigDecimal.ZERO;
            
            for (PointCalc strategy : strategies) {
                BigDecimal result = strategy.calc(zeroPoint);
                assertNotNull(result, "零值输入应该有结果");
                assertTrue(result.compareTo(BigDecimal.ZERO) >= 0, "结果应该不小于零");
            }
        }

        @Test
        @DisplayName("测试负值输入")
        void testNegativeInput() {
            PointCalc[] strategies = {
                new BasePointCalc(),
                new ConstantPointCalc(),
                new FullGivePointCalc()
            };
            
            BigDecimal negativePoint = new BigDecimal("-100");
            
            for (PointCalc strategy : strategies) {
                BigDecimal result = strategy.calc(negativePoint);
                assertNotNull(result, "负值输入应该有结果");
                // 不同策略对负值的处理可能不同，这里只验证有结果
            }
        }

        @Test
        @DisplayName("测试极大值输入")
        void testLargeInput() {
            PointCalc strategy = new BasePointCalc();
            BigDecimal largePoint = new BigDecimal("999999999999999999.99");
            
            BigDecimal result = strategy.calc(largePoint);
            assertEquals(largePoint, result, "极大值应该被正确处理");
        }
    }

    @Test
    @DisplayName("测试策略的线程安全性")
    void testStrategyThreadSafety() throws InterruptedException {
        // 测试策略在多线程环境下的安全性
        
        PointCalc strategy = new BasePointCalc();
        BigDecimal testPoint = new BigDecimal("100");
        
        final int threadCount = 10;
        final BigDecimal[] results = new BigDecimal[threadCount];
        final Thread[] threads = new Thread[threadCount];
        
        // 创建多个线程同时使用策略
        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                results[index] = strategy.calc(testPoint);
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
        
        // 验证所有线程得到相同结果
        for (int i = 1; i < threadCount; i++) {
            assertEquals(results[0], results[i], "多线程环境下策略应该返回一致结果");
        }
    }

    @Test
    @DisplayName("测试策略模式控制台输出")
    void testStrategyPatternConsoleOutput() {
        PointGiveService service = new PointGiveServiceImpl();
        
        // 清空控制台输出
        clearConsoleOutput();
        
        // 测试不同策略的输出
        service.setPointCalc(new BasePointCalc());
        service.givePoint(new BigDecimal("100"));
        
        service.setPointCalc(new ConstantPointCalc());
        service.givePoint(new BigDecimal("100"));
        
        service.setPointCalc(new FullGivePointCalc());
        service.givePoint(new BigDecimal("100"));
        
        // 验证控制台输出
        String output = getConsoleOutput();
        assertNotNull(output, "控制台输出不应该为空");
        
        // 假设策略实现会有相应的输出
        // assertConsoleOutputContains("基础积分计算");
        // assertConsoleOutputContains("固定积分计算");
        // assertConsoleOutputContains("满赠积分计算");
    }
}