package com.kevin.demo.structural.facade;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 外观模式测试类
 * 测试外观模式的实现，包括简化复杂子系统的接口
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("外观模式测试")
class FacadePatternTest extends BasePatternTest {

    private CmfFacade facade;

    @BeforeEach
    void setUp() {
        super.setUp();
        facade = new CmfFacade();
    }

    @Test
    @DisplayName("测试基本积分操作")
    void testBasicPointOperations() {
        // 测试积分操作
        facade.givePoint();
        
        String output = getConsoleOutput();
        
        // 验证外观模式简化了操作
        assertTrue(output.contains("积分发放完成"));
        
        // 验证子系统方法被调用
        assertTrue(output.contains("验证用户身份"));
        assertTrue(output.contains("计算用户积分"));
        assertTrue(output.contains("发放积分"));
        assertTrue(output.contains("记录积分流水"));
    }

    @Test
    @DisplayName("测试等级操作")
    void testLevelOperations() {
        // 测试等级操作
        facade.upgradeLevel();
        
        String output = getConsoleOutput();
        
        // 验证外观模式简化了操作
        assertTrue(output.contains("等级升级完成"));
        
        // 验证子系统方法被调用
        assertTrue(output.contains("检查用户等级"));
        assertTrue(output.contains("计算升级条件"));
        assertTrue(output.contains("执行等级升级"));
        assertTrue(output.contains("通知用户升级"));
    }

    @Test
    @DisplayName("测试通用操作")
    void testCommonOperations() {
        // 测试通用操作
        facade.doCommonOperation();
        
        String output = getConsoleOutput();
        
        // 验证外观模式简化了操作
        assertTrue(output.contains("通用操作完成"));
        
        // 验证子系统方法被调用
        assertTrue(output.contains("执行通用操作"));
        assertTrue(output.contains("记录操作日志"));
    }

    @Test
    @DisplayName("测试完整业务流程")
    void testCompleteBusinessProcess() {
        // 执行完整的业务流程
        facade.givePoint();
        clearConsoleOutput();
        
        facade.upgradeLevel();
        clearConsoleOutput();
        
        facade.doCommonOperation();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("通用操作完成"));
    }

    @Test
    @DisplayName("测试外观模式简化效果")
    void testFacadeSimplification() {
        // 通过外观模式执行复杂操作
        facade.givePoint();
        
        String facadeOutput = getConsoleOutput();
        
        clearConsoleOutput();
        
        // 直接使用子系统执行相同操作（如果可能的话）
        // 这里模拟直接调用子系统方法的复杂性
        CmfPoint point = new CmfPoint();
        CmfLevel level = new CmfLevel();
        CmfCommon common = new CmfCommon();
        
        point.validateUser();
        point.calculatePoint();
        point.givePoint();
        point.recordTransaction();
        
        String directOutput = getConsoleOutput();
        
        // 验证外观模式简化了客户端代码
        assertTrue(facadeOutput.contains("积分发放完成"));
        assertTrue(directOutput.contains("验证用户身份"));
        
        // 外观模式应该提供更高级别的抽象
        assertNotEquals(facadeOutput, directOutput);
    }

    @Test
    @DisplayName("测试类型识别")
    void testTypeIdentification() {
        // 验证外观类型
        assertInstanceOf(CmfFacade.class, facade);
        
        // 验证子系统类型
        CmfPoint point = new CmfPoint();
        CmfLevel level = new CmfLevel();
        CmfCommon common = new CmfCommon();
        
        assertInstanceOf(CmfPoint.class, point);
        assertInstanceOf(CmfLevel.class, level);
        assertInstanceOf(CmfCommon.class, common);
    }

    @Test
    @DisplayName("测试外观模式封装性")
    void testFacadeEncapsulation() {
        // 验证外观模式封装了子系统的复杂性
        
        // 客户端只需要知道外观接口
        facade.givePoint();
        
        String output = getConsoleOutput();
        
        // 验证子系统细节被隐藏
        assertTrue(output.contains("积分发放完成"));
        // 客户端不需要直接调用子系统的多个方法
    }

    @Test
    @DisplayName("测试多次操作")
    void testMultipleOperations() {
        // 多次执行相同操作
        for (int i = 0; i < 3; i++) {
            facade.givePoint();
        }
        
        String output = getConsoleOutput();
        
        // 验证操作被执行了3次
        int count = 0;
        int index = 0;
        while ((index = output.indexOf("积分发放完成", index)) != -1) {
            count++;
            index += "积分发放完成".length();
        }
        assertEquals(3, count);
    }

    @Test
    @DisplayName("测试外观模式扩展性")
    void testFacadeExtensibility() {
        // 创建扩展的外观
        CmfFacade extendedFacade = new CmfFacade() {
            public void extendedOperation() {
                System.out.println("执行扩展操作");
                givePoint(); // 复用现有功能
                System.out.println("扩展操作完成");
            }
        };
        
        // 使用扩展外观
        extendedFacade.extendedOperation();
        
        String output = getConsoleOutput();
        
        // 验证扩展功能
        assertTrue(output.contains("执行扩展操作"));
        assertTrue(output.contains("积分发放完成"));
        assertTrue(output.contains("扩展操作完成"));
    }

    @Test
    @DisplayName("测试外观模式性能")
    void testFacadePerformance() {
        // 测试外观模式的性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                if (i % 3 == 0) {
                    facade.givePoint();
                } else if (i % 3 == 1) {
                    facade.upgradeLevel();
                } else {
                    facade.doCommonOperation();
                }
                clearConsoleOutput();
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试并发操作")
    void testConcurrentOperations() throws InterruptedException {
        // 多线程测试外观模式
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                CmfFacade localFacade = new CmfFacade();
                if (threadId % 3 == 0) {
                    localFacade.givePoint();
                } else if (threadId % 3 == 1) {
                    localFacade.upgradeLevel();
                } else {
                    localFacade.doCommonOperation();
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
    @DisplayName("测试子系统独立性")
    void testSubsystemIndependence() {
        // 验证子系统可以独立使用
        
        // 直接使用积分子系统
        CmfPoint point = new CmfPoint();
        point.validateUser();
        point.calculatePoint();
        
        String pointOutput = getConsoleOutput();
        assertTrue(pointOutput.contains("验证用户身份"));
        assertTrue(pointOutput.contains("计算用户积分"));
        
        clearConsoleOutput();
        
        // 直接使用等级子系统
        CmfLevel level = new CmfLevel();
        level.checkLevel();
        level.calculateUpgrade();
        
        String levelOutput = getConsoleOutput();
        assertTrue(levelOutput.contains("检查用户等级"));
        assertTrue(levelOutput.contains("计算升级条件"));
    }

    @Test
    @DisplayName("测试外观模式层次结构")
    void testFacadeHierarchy() {
        // 测试多层外观模式
        
        // 创建子外观
        class PointFacade {
            private CmfPoint point = new CmfPoint();
            
            public void quickPoint() {
                point.validateUser();
                point.calculatePoint();
                point.givePoint();
                System.out.println("快速积分发放完成");
            }
        }
        
        // 创建主外观
        class MainFacade {
            private PointFacade pointFacade = new PointFacade();
            private CmfLevel level = new CmfLevel();
            
            public void quickProcess() {
                pointFacade.quickPoint();
                level.checkLevel();
                System.out.println("快速处理完成");
            }
        }
        
        // 使用主外观
        MainFacade mainFacade = new MainFacade();
        mainFacade.quickProcess();
        
        String output = getConsoleOutput();
        
        // 验证多层外观
        assertTrue(output.contains("快速积分发放完成"));
        assertTrue(output.contains("检查用户等级"));
        assertTrue(output.contains("快速处理完成"));
    }

    @Test
    @DisplayName("测试外观模式设计原则")
    void testFacadeDesignPrinciples() {
        // 验证外观模式的设计原则
        
        // 1. 简化接口：为复杂的子系统提供简单的接口
        facade.givePoint();
        String output = getConsoleOutput();
        assertTrue(output.contains("积分发放完成"));
        
        // 2. 解耦：客户端与子系统解耦
        // 客户端只需要知道外观，不需要知道子系统细节
        
        // 3. 层次化：可以为子系统提供多个层次的外观
        // 这里通过基本外观验证
        
        clearConsoleOutput();
        
        // 4. 不封闭子系统：客户端仍然可以直接使用子系统
        CmfPoint directPoint = new CmfPoint();
        directPoint.validateUser();
        String directOutput = getConsoleOutput();
        assertTrue(directOutput.contains("验证用户身份"));
    }
}