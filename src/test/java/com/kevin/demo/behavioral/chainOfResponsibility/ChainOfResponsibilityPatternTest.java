package com.kevin.demo.behavioral.chainOfResponsibility;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 责任链模式测试类
 * 测试责任链模式的实现，包括处理器链的构建、请求传递和处理
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("责任链模式测试")
class ChainOfResponsibilityPatternTest extends BasePatternTest {

    @Test
    @DisplayName("测试责任链基本功能")
    void testChainOfResponsibilityBasicFunctionality() {
        // 创建处理器
        Handler authHandler = new AuthHandler();
        Handler printHandler = new PrintHandler();
        Handler aliasHandler = new AliasHandler();
        
        // 构建责任链
        authHandler.setNext(printHandler);
        printHandler.setNext(aliasHandler);
        
        // 测试请求处理
        String request = "test request";
        authHandler.handle(request);
        
        // 验证输出
        String output = getConsoleOutput();
        assertTrue(output.contains("AuthHandler处理请求: " + request));
        assertTrue(output.contains("PrintHandler处理请求: " + request));
        assertTrue(output.contains("AliasHandler处理请求: " + request));
    }

    @Test
    @DisplayName("测试责任链中断")
    void testChainBreak() {
        // 创建处理器
        Handler authHandler = new AuthHandler();
        Handler printHandler = new PrintHandler();
        
        // 构建责任链
        authHandler.setNext(printHandler);
        
        // 测试认证失败的请求
        String failedRequest = "failed auth";
        authHandler.handle(failedRequest);
        
        // 验证只有认证处理器处理了请求
        String output = getConsoleOutput();
        assertTrue(output.contains("AuthHandler处理请求: " + failedRequest));
        assertFalse(output.contains("PrintHandler处理请求: " + failedRequest));
    }

    @Test
    @DisplayName("测试单个处理器")
    void testSingleHandler() {
        // 创建单个处理器
        Handler handler = new PrintHandler();
        
        // 测试处理请求
        String request = "single handler test";
        handler.handle(request);
        
        // 验证输出
        String output = getConsoleOutput();
        assertTrue(output.contains("PrintHandler处理请求: " + request));
    }

    @Test
    @DisplayName("测试责任链动态构建")
    void testDynamicChainBuilding() {
        // 创建处理器
        Handler handler1 = new AuthHandler();
        Handler handler2 = new PrintHandler();
        Handler handler3 = new AliasHandler();
        
        // 动态构建责任链
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        
        // 验证链式调用
        assertEquals(handler2, handler1.getNext());
        assertEquals(handler3, handler2.getNext());
        assertNull(handler3.getNext());
    }

    @Test
    @DisplayName("测试责任链空指针处理")
    void testChainNullHandling() {
        // 创建处理器
        Handler handler = new AuthHandler();
        
        // 测试没有下一个处理器的情况
        String request = "no next handler";
        handler.handle(request);
        
        // 验证处理器仍然正常工作
        String output = getConsoleOutput();
        assertTrue(output.contains("AuthHandler处理请求: " + request));
    }

    @Test
    @DisplayName("测试责任链循环引用检测")
    void testChainCircularReference() {
        // 创建处理器
        Handler handler1 = new AuthHandler();
        Handler handler2 = new PrintHandler();
        
        // 构建链
        handler1.setNext(handler2);
        
        // 尝试创建循环引用（在实际应用中应该避免）
        handler2.setNext(handler1);
        
        // 测试请求处理（可能会栈溢出，这里只测试基本功能）
        assertDoesNotThrow(() -> {
            String request = "circular test";
            handler1.handle(request);
        });
    }

    @Test
    @DisplayName("测试处理器类型识别")
    void testHandlerTypeIdentification() {
        Handler authHandler = new AuthHandler();
        Handler printHandler = new PrintHandler();
        Handler aliasHandler = new AliasHandler();
        
        // 验证处理器类型
        assertInstanceOf(AuthHandler.class, authHandler);
        assertInstanceOf(PrintHandler.class, printHandler);
        assertInstanceOf(AliasHandler.class, aliasHandler);
        
        // 验证继承关系
        assertTrue(authHandler instanceof Handler);
        assertTrue(printHandler instanceof Handler);
        assertTrue(aliasHandler instanceof Handler);
    }

    @Test
    @DisplayName("测试责任链性能")
    void testChainPerformance() {
        // 创建长责任链
        Handler[] handlers = new Handler[100];
        for (int i = 0; i < handlers.length; i++) {
            handlers[i] = new PrintHandler();
        }
        
        // 构建链
        for (int i = 0; i < handlers.length - 1; i++) {
            handlers[i].setNext(handlers[i + 1]);
        }
        
        // 测试性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 10; i++) {
                handlers[0].handle("performance test " + i);
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试责任链线程安全性")
    void testChainThreadSafety() throws InterruptedException {
        // 创建责任链
        Handler authHandler = new AuthHandler();
        Handler printHandler = new PrintHandler();
        authHandler.setNext(printHandler);
        
        // 多线程测试
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                authHandler.handle("thread " + threadId + " request");
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
        
        // 验证所有请求都被处理
        String output = getConsoleOutput();
        for (int i = 0; i < threads.length; i++) {
            assertTrue(output.contains("thread " + i + " request"));
        }
    }
}