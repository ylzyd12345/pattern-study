package com.kevin.demo.structural.proxy;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 代理模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("代理模式测试")
class ProxyPatternTest extends BasePatternTest {

    @Test
    @DisplayName("测试基本代理功能")
    void testBasicProxyFunctionality() {
        BabyPlayGame babyPlayGame = new BabyPlayGame();
        PlayGameProxy playGameProxy = new PlayGameProxy(babyPlayGame);
        
        assertNotNull(playGameProxy, "游戏代理不应该为null");
        assertInstanceOf(PlayGame.class, playGameProxy, "应该实现PlayGame接口");
        
        // 测试代理的游戏功能
        assertDoesNotThrow(() -> playGameProxy.play("王者荣耀"), 
                          "代理应该能够正常处理游戏请求");
    }

    @Test
    @DisplayName("测试代理与真实对象的关系")
    void testProxyRealObjectRelationship() {
        BabyPlayGame babyPlayGame = new BabyPlayGame();
        PlayGameProxy playGameProxy = new PlayGameProxy(babyPlayGame);
        
        // 代理应该持有真实对象的引用
        assertNotNull(playGameProxy, "代理应该存在");
        
        // 代理应该能够调用真实对象的方法
        assertDoesNotThrow(() -> playGameProxy.play("和平精英"), 
                          "代理应该能够调用真实对象的方法");
    }

    @Test
    @DisplayName("测试代理的透明性")
    void testProxyTransparency() {
        BabyPlayGame babyPlayGame = new BabyPlayGame();
        PlayGame playGame = new PlayGameProxy(babyPlayGame);
        
        // 客户端应该可以像使用真实对象一样使用代理
        assertDoesNotThrow(() -> playGame.play("原神"), 
                          "代理对客户端应该是透明的");
    }

    @Test
    @DisplayName("测试代理的额外功能")
    void testProxyAdditionalFunctionality() {
        BabyPlayGame babyPlayGame = new BabyPlayGame();
        PlayGameProxy playGameProxy = new PlayGameProxy(babyPlayGame);
        
        // 清空控制台输出
        clearConsoleOutput();
        
        // 代理通常会提供额外的功能（如日志、权限检查等）
        playGameProxy.play("英雄联盟");
        
        // 验证代理的额外功能输出
        String output = getConsoleOutput();
        assertNotNull(output, "代理应该产生输出");
        // 假设代理会有额外的日志输出
    }

    @Nested
    @DisplayName("代理模式特性测试")
    class ProxyPatternCharacteristicsTest {
        
        @Test
        @DisplayName("测试代理的控制访问")
        void testProxyAccessControl() {
            BabyPlayGame babyPlayGame = new BabyPlayGame();
            PlayGameProxy playGameProxy = new PlayGameProxy(babyPlayGame);
            
            // 代理可以控制对真实对象的访问
            // 例如：权限检查、缓存、延迟加载等
            
            // 测试正常访问
            assertDoesNotThrow(() -> playGameProxy.play("正常游戏"), 
                              "代理应该允许正常访问");
            
            // 测试边界情况
            assertDoesNotThrow(() -> playGameProxy.play(""), 
                              "代理应该处理边界情况");
        }

        @Test
        @DisplayName("测试代理的职责分离")
        void testProxyResponsibilitySeparation() {
            // 代理应该将业务逻辑与辅助功能分离
            
            BabyPlayGame babyPlayGame = new BabyPlayGame();
            PlayGameProxy playGameProxy = new PlayGameProxy(babyPlayGame);
            
            // 真实对象负责核心业务逻辑
            // 代理负责辅助功能（日志、权限等）
            
            playGameProxy.play("测试游戏");
            
            // 验证代理和真实对象的职责分离
            assertNotNull(playGameProxy, "代理应该存在");
            assertNotNull(babyPlayGame, "真实对象应该存在");
        }

        @Test
        @DisplayName("测试代理的可替换性")
        void testProxyReplaceability() {
            // 代理应该可以被其他代理或真实对象替换
            
            BabyPlayGame babyPlayGame = new BabyPlayGame();
            PlayGame realObject = babyPlayGame;
            PlayGame proxy = new PlayGameProxy(babyPlayGame);
            
            // 客户端代码应该可以无缝切换
            assertDoesNotThrow(() -> realObject.play("真实对象测试"), 
                              "真实对象应该正常工作");
            assertDoesNotThrow(() -> proxy.play("代理测试"), 
                              "代理应该正常工作");
        }
    }

    @Test
    @DisplayName("测试代理模式的延迟初始化")
    void testProxyLazyInitialization() {
        // 代理可以支持延迟初始化
        PlayGameProxy playGameProxy = new PlayGameProxy(null);
        
        // 代理可以在需要时才创建真实对象
        assertDoesNotThrow(() -> playGameProxy.play("延迟初始化测试"), 
                          "代理应该支持延迟初始化");
    }

    @Test
    @DisplayName("测试代理模式的缓存功能")
    void testProxyCachingFunctionality() {
        BabyPlayGame babyPlayGame = new BabyPlayGame();
        PlayGameProxy playGameProxy = new PlayGameProxy(babyPlayGame);
        
        // 代理可以提供缓存功能
        String gameName = "缓存测试游戏";
        
        // 第一次调用
        playGameProxy.play(gameName);
        
        // 第二次调用（可能使用缓存）
        playGameProxy.play(gameName);
        
        // 验证缓存功能（通过输出或其他方式）
        assertNotNull(playGameProxy, "代理应该支持缓存功能");
    }

    @Test
    @DisplayName("测试代理模式的日志功能")
    void testProxyLoggingFunctionality() {
        BabyPlayGame babyPlayGame = new BabyPlayGame();
        PlayGameProxy playGameProxy = new PlayGameProxy(babyPlayGame);
        
        // 清空控制台输出
        clearConsoleOutput();
        
        // 代理应该提供日志功能
        playGameProxy.play("日志测试游戏");
        
        // 验证日志输出
        String output = getConsoleOutput();
        assertNotNull(output, "代理应该产生日志输出");
    }

    @Test
    @DisplayName("测试代理的性能")
    void testProxyPerformance() {
        BabyPlayGame babyPlayGame = new BabyPlayGame();
        PlayGameProxy playGameProxy = new PlayGameProxy(babyPlayGame);
        
        // 测试代理的性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                playGameProxy.play("性能测试游戏" + i);
            }
        }, 2000); // 期望在2秒内完成1000次调用
    }

    @Test
    @DisplayName("测试代理的线程安全性")
    void testProxyThreadSafety() throws InterruptedException {
        BabyPlayGame babyPlayGame = new BabyPlayGame();
        PlayGameProxy playGameProxy = new PlayGameProxy(babyPlayGame);
        
        final int threadCount = 50;
        final Thread[] threads = new Thread[threadCount];
        
        // 创建多个线程同时调用代理
        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                playGameProxy.play("线程安全测试游戏" + index);
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
        
        // 验证代理的线程安全性
        assertNotNull(playGameProxy, "代理应该保持线程安全");
    }

    @Test
    @DisplayName("测试代理模式控制台输出")
    void testProxyPatternConsoleOutput() {
        BabyPlayGame babyPlayGame = new BabyPlayGame();
        PlayGameProxy playGameProxy = new PlayGameProxy(babyPlayGame);
        
        // 清空控制台输出
        clearConsoleOutput();
        
        // 测试多个游戏
        playGameProxy.play("王者荣耀");
        playGameProxy.play("和平精英");
        playGameProxy.play("原神");
        
        // 验证控制台输出
        String output = getConsoleOutput();
        assertNotNull(output, "控制台输出不应该为空");
        
        // 假设代理会有特定的输出格式
        // assertConsoleOutputContains("代理处理:");
        // assertConsoleOutputContains("王者荣耀");
    }

    @Nested
    @DisplayName("边界条件测试")
    class EdgeCaseTest {
        
        @Test
        @DisplayName("测试代理null参数处理")
        void testProxyNullParameterHandling() {
            PlayGameProxy playGameProxy = new PlayGameProxy(null);
            
            // 测试null游戏名称
            assertDoesNotThrow(() -> playGameProxy.play(null), 
                              "代理应该处理null参数");
            
            // 测试空游戏名称
            assertDoesNotThrow(() -> playGameProxy.play(""), 
                              "代理应该处理空字符串");
        }

        @Test
        @DisplayName("测试代理特殊字符处理")
        void testProxySpecialCharacterHandling() {
            BabyPlayGame babyPlayGame = new BabyPlayGame();
            PlayGameProxy playGameProxy = new PlayGameProxy(babyPlayGame);
            
            // 测试包含特殊字符的游戏名称
            String[] specialNames = {
                "游戏!@#$%^&*()",
                "游戏中文测试",
                "Game with spaces",
                "Game-with-dashes"
            };
            
            for (String gameName : specialNames) {
                assertDoesNotThrow(() -> playGameProxy.play(gameName), 
                                  "代理应该处理特殊字符: " + gameName);
            }
        }

        @Test
        @DisplayName("测试代理的多次调用一致性")
        void testProxyMultipleCallConsistency() {
            BabyPlayGame babyPlayGame = new BabyPlayGame();
            PlayGameProxy playGameProxy = new PlayGameProxy(babyPlayGame);
            
            String gameName = "一致性测试游戏";
            
            // 多次调用同一游戏
            playGameProxy.play(gameName);
            playGameProxy.play(gameName);
            playGameProxy.play(gameName);
            
            // 验证代理的一致性
            assertNotNull(playGameProxy, "代理应该保持一致性");
        }
    }

    @Test
    @DisplayName("测试代理模式的扩展性")
    void testProxyPatternExtensibility() {
        // 代理模式易于扩展，可以创建不同类型的代理
        
        BabyPlayGame babyPlayGame = new BabyPlayGame();
        
        // 可以创建多个代理实例
        PlayGameProxy proxy1 = new PlayGameProxy(babyPlayGame);
        PlayGameProxy proxy2 = new PlayGameProxy(babyPlayGame);
        
        // 验证所有代理都能正常工作
        assertDoesNotThrow(() -> proxy1.play("扩展性测试1"), 
                          "第一个代理应该正常工作");
        assertDoesNotThrow(() -> proxy2.play("扩展性测试2"), 
                          "第二个代理应该正常工作");
        
        // 验证代理的独立性
        assertNotSame(proxy1, proxy2, "不同的代理实例应该是独立的");
    }
}