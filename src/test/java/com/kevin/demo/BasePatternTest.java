package com.kevin.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Set;

/**
 * 设计模式测试基类
 * 提供通用的测试工具方法和设置
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public abstract class BasePatternTest {

    protected ByteArrayOutputStream outputStream;
    protected PrintStream originalOut;
    
    @Mock
    protected Object logger; // 简化为Object类型，避免依赖问题
    
    @BeforeEach
    void setUp() {
        // 设置控制台输出捕获
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }
    
    @AfterEach
    void tearDown() {
        // 恢复控制台输出
        System.setOut(originalOut);
    }
    
    /**
     * 验证控制台输出包含指定文本
     * 
     * @param expected 期望的文本
     */
    protected void assertConsoleOutputContains(String expected) {
        String output = outputStream.toString();
        if (!output.contains(expected)) {
            throw new AssertionError("控制台输出不包含期望的文本: " + expected + 
                                   "\n实际输出: " + output);
        }
    }
    
    /**
     * 验证控制台输出不包含指定文本
     * 
     * @param unexpected 不期望的文本
     */
    protected void assertConsoleOutputNotContains(String unexpected) {
        String output = outputStream.toString();
        if (output.contains(unexpected)) {
            throw new AssertionError("控制台输出包含不期望的文本: " + unexpected + 
                                   "\n实际输出: " + output);
        }
    }
    
    /**
     * 验证对象是指定类的实例
     * 
     * @param expectedClass 期望的类
     * @param actual 实际对象
     */
    protected void assertInstanceOf(Class<?> expectedClass, Object actual) {
        if (actual == null) {
            throw new AssertionError("对象为null，无法验证类型");
        }
        if (!expectedClass.isInstance(actual)) {
            throw new AssertionError("对象类型不匹配。期望: " + expectedClass.getName() + 
                                   ", 实际: " + actual.getClass().getName());
        }
    }
    
    /**
     * 验证单例模式的线程安全性
     * 
     * @param singletonSupplier 单例获取函数
     * @param threadCount 线程数量
     * @param <T> 单例类型
     * @throws InterruptedException 线程中断异常
     */
    protected <T> void assertSingletonThreadSafety(SingletonSupplier<T> singletonSupplier, 
                                                  int threadCount) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(threadCount);
        Set<T> instances = ConcurrentHashMap.newKeySet();
        
        // 创建多个线程同时获取单例实例
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    instances.add(singletonSupplier.get());
                } finally {
                    latch.countDown();
                }
            }).start();
        }
        
        latch.await();
        
        // 验证所有线程获取的都是同一个实例
        if (instances.size() != 1) {
            throw new AssertionError("线程安全性测试失败。期望1个实例，实际获得" + 
                                   instances.size() + "个不同的实例");
        }
    }
    
    /**
     * 验证反射攻击防护
     * 
     * @param singletonClass 单例类
     * @param <T> 单例类型
     */
    protected <T> void assertReflectionAttackPrevention(Class<T> singletonClass) {
        try {
            var constructor = singletonClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
            throw new AssertionError("反射攻击防护测试失败：应该抛出异常");
        } catch (Exception e) {
            // 期望抛出异常，验证异常信息
            if (!e.getMessage().contains("单例") && 
                !e.getMessage().contains("singleton") &&
                !e.getMessage().contains("Singleton")) {
                throw new AssertionError("反射攻击防护异常信息不正确: " + e.getMessage());
            }
        }
    }
    
    /**
     * 获取控制台输出内容
     * 
     * @return 控制台输出字符串
     */
    protected String getConsoleOutput() {
        return outputStream.toString();
    }
    
    /**
     * 清空控制台输出
     */
    protected void clearConsoleOutput() {
        outputStream.reset();
    }
    
    /**
     * 单例获取函数式接口
     * 
     * @param <T> 单例类型
     */
    @FunctionalInterface
    protected interface SingletonSupplier<T> {
        T get();
    }
    
    /**
     * 等待指定时间（毫秒）
     * 
     * @param milliseconds 等待时间
     */
    protected void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("等待被中断", e);
        }
    }
    
    /**
     * 验证执行时间在指定范围内
     * 
     * @param runnable 要执行的任务
     * @param maxTimeMs 最大执行时间（毫秒）
     */
    protected void assertExecutionTime(Runnable runnable, long maxTimeMs) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        
        if (executionTime > maxTimeMs) {
            throw new AssertionError("执行时间超出限制。期望最多" + maxTimeMs + 
                                   "ms，实际" + executionTime + "ms");
        }
    }
}