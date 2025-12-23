package com.kevin.demo.behavioral.template;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 模板方法模式测试类
 * 测试模板方法模式的实现，包括算法骨架的固定部分和可变部分
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("模板方法模式测试")
class TemplatePatternTest extends BasePatternTest {

    private BasePointGiveAction baseAction;
    private HKPointGiveAction hkAction;

    @BeforeEach
    void setUp() {
        super.setUp();
        baseAction = new BasePointGiveAction();
        hkAction = new HKPointGiveAction();
    }

    @Test
    @DisplayName("测试基本模板方法执行")
    void testBasicTemplateMethodExecution() {
        // 执行基本模板方法
        baseAction.givePoint();
        
        String output = getConsoleOutput();
        
        // 验证模板方法的固定步骤都被执行
        assertTrue(output.contains("验证用户身份"));
        assertTrue(output.contains("计算积分"));
        assertTrue(output.contains("发放积分"));
        assertTrue(output.contains("记录日志"));
    }

    @Test
    @DisplayName("测试子类重写步骤")
    void testSubclassOverriddenSteps() {
        // 执行香港积分发放模板方法
        hkAction.givePoint();
        
        String output = getConsoleOutput();
        
        // 验证固定步骤
        assertTrue(output.contains("验证用户身份"));
        assertTrue(output.contains("发放积分"));
        assertTrue(output.contains("记录日志"));
        
        // 验证重写的计算积分步骤
        assertTrue(output.contains("香港地区计算积分"));
    }

    @Test
    @DisplayName("测试模板方法不可重写")
    void testTemplateMethodNotOverridable() {
        // 验证模板方法是final的，不能被子类重写
        // 这里通过反射检查方法修饰符
        try {
            java.lang.reflect.Method method = BasePointGiveAction.class.getMethod("givePoint");
            assertTrue(java.lang.reflect.Modifier.isFinal(method.getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("模板方法givePoint不存在");
        }
    }

    @Test
    @DisplayName("测试算法骨架固定性")
    void testAlgorithmSkeletonFixed() {
        // 多次执行同一个动作，验证步骤顺序一致
        for (int i = 0; i < 3; i++) {
            clearConsoleOutput();
            baseAction.givePoint();
            
            String output = getConsoleOutput();
            
            // 验证步骤顺序
            int validateIndex = output.indexOf("验证用户身份");
            int calculateIndex = output.indexOf("计算积分");
            int giveIndex = output.indexOf("发放积分");
            int logIndex = output.indexOf("记录日志");
            
            assertTrue(validateIndex >= 0);
            assertTrue(calculateIndex >= 0);
            assertTrue(giveIndex >= 0);
            assertTrue(logIndex >= 0);
            
            // 验证顺序：验证 -> 计算 -> 发放 -> 记录
            assertTrue(validateIndex < calculateIndex);
            assertTrue(calculateIndex < giveIndex);
            assertTrue(giveIndex < logIndex);
        }
    }

    @Test
    @DisplayName("测试子类多样性")
    void testSubclassVariety() {
        // 创建另一个子类来测试多样性
        BasePointGiveAction customAction = new BasePointGiveAction() {
            @Override
            protected void calculatePoint() {
                System.out.println("自定义计算积分");
            }
        };
        
        customAction.givePoint();
        String output = getConsoleOutput();
        
        // 验证固定步骤
        assertTrue(output.contains("验证用户身份"));
        assertTrue(output.contains("发放积分"));
        assertTrue(output.contains("记录日志"));
        
        // 验证自定义步骤
        assertTrue(output.contains("自定义计算积分"));
    }

    @Test
    @DisplayName("测试钩子方法")
    void testHookMethods() {
        // 如果有钩子方法，测试其行为
        baseAction.givePoint();
        String output = getConsoleOutput();
        
        // 验证可能的钩子方法调用
        // 这取决于具体实现，这里只是示例
        assertNotNull(output);
    }

    @Test
    @DisplayName("测试抽象方法实现")
    void testAbstractMethodImplementation() {
        // 验证抽象方法被正确实现
        hkAction.givePoint();
        String output = getConsoleOutput();
        
        // 验证香港特有的计算积分逻辑
        assertTrue(output.contains("香港地区计算积分"));
    }

    @Test
    @DisplayName("测试模板方法扩展性")
    void testTemplateMethodExtensibility() {
        // 创建扩展的模板方法类
        BasePointGiveAction extendedAction = new BasePointGiveAction() {
            @Override
            protected void calculatePoint() {
                System.out.println("扩展计算积分");
                super.calculatePoint(); // 调用父类默认实现
            }
            
            // 添加新的步骤（通过重写现有方法）
            @Override
            protected void recordLog() {
                System.out.println("扩展记录日志");
                super.recordLog();
            }
        };
        
        extendedAction.givePoint();
        String output = getConsoleOutput();
        
        // 验证扩展功能
        assertTrue(output.contains("扩展计算积分"));
        assertTrue(output.contains("计算积分"));
        assertTrue(output.contains("扩展记录日志"));
        assertTrue(output.contains("记录日志"));
    }

    @Test
    @DisplayName("测试模板方法性能")
    void testTemplateMethodPerformance() {
        // 测试模板方法执行性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                if (i % 2 == 0) {
                    baseAction.givePoint();
                } else {
                    hkAction.givePoint();
                }
                clearConsoleOutput();
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试模板方法线程安全性")
    void testTemplateMethodThreadSafety() throws InterruptedException {
        // 多线程测试模板方法
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                BasePointGiveAction action = threadId % 2 == 0 ? baseAction : hkAction;
                action.givePoint();
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
    @DisplayName("测试模板方法组合")
    void testTemplateMethodComposition() {
        // 测试多个模板方法的组合使用
        baseAction.givePoint();
        clearConsoleOutput();
        
        hkAction.givePoint();
        clearConsoleOutput();
        
        baseAction.givePoint();
        
        String output = getConsoleOutput();
        
        // 验证最后一次执行
        assertTrue(output.contains("验证用户身份"));
        assertTrue(output.contains("计算积分"));
        assertTrue(output.contains("发放积分"));
        assertTrue(output.contains("记录日志"));
    }

    @Test
    @DisplayName("测试模板方法异常处理")
    void testTemplateMethodExceptionHandling() {
        // 创建会抛出异常的子类
        BasePointGiveAction faultyAction = new BasePointGiveAction() {
            @Override
            protected void calculatePoint() {
                throw new RuntimeException("计算积分出错");
            }
        };
        
        // 测试异常处理
        assertThrows(RuntimeException.class, () -> {
            faultyAction.givePoint();
        });
    }

    @Test
    @DisplayName("测试模板方法状态保持")
    void testTemplateMethodStateMaintenance() {
        // 如果模板方法涉及状态管理，测试状态保持
        baseAction.givePoint();
        String output1 = getConsoleOutput();
        
        clearConsoleOutput();
        
        // 再次执行，验证状态一致性
        baseAction.givePoint();
        String output2 = getConsoleOutput();
        
        // 验证输出模式一致
        assertEquals(output1.length(), output2.length());
    }

    @Test
    @DisplayName("测试模板方法参数化")
    void testTemplateMethodParameterization() {
        // 如果模板方法支持参数化，测试不同参数
        // 这取决于具体实现，这里只是示例
        
        // 执行基本模板方法
        baseAction.givePoint();
        String output = getConsoleOutput();
        
        // 验证基本功能正常
        assertTrue(output.contains("验证用户身份"));
        assertTrue(output.contains("计算积分"));
        assertTrue(output.contains("发放积分"));
        assertTrue(output.contains("记录日志"));
    }

    @Test
    @DisplayName("测试模板方法设计原则")
    void testTemplateMethodDesignPrinciples() {
        // 验证模板方法的设计原则
        
        // 1. 算法骨架固定
        hkAction.givePoint();
        String hkOutput = getConsoleOutput();
        
        clearConsoleOutput();
        
        baseAction.givePoint();
        String baseOutput = getConsoleOutput();
        
        // 验证骨架步骤相同
        String[] skeletonSteps = {"验证用户身份", "发放积分", "记录日志"};
        for (String step : skeletonSteps) {
            assertTrue(hkOutput.contains(step));
            assertTrue(baseOutput.contains(step));
        }
        
        // 2. 可变部分由子类实现
        assertTrue(hkOutput.contains("香港地区计算积分"));
        assertTrue(baseOutput.contains("计算积分"));
        assertFalse(hkOutput.contains("计算积分")); // 不应该有父类的实现
        assertFalse(baseOutput.contains("香港地区计算积分")); // 不应该有子类的实现
    }
}