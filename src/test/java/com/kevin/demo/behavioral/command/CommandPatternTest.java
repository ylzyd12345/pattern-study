package com.kevin.demo.behavioral.command;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 命令模式测试类
 * 测试命令模式的实现，包括命令的封装、执行和撤销功能
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("命令模式测试")
class CommandPatternTest extends BasePatternTest {

    private TVControl tvControl;
    private Command openCommand;
    private Command closeCommand;

    @BeforeEach
    void setUp() {
        super.setUp();
        tvControl = new TVControl();
        openCommand = new TVOpenCommand(new Televation());
        closeCommand = new TVCloseCommand(new Televation());
    }

    @Test
    @DisplayName("测试命令基本执行")
    void testBasicCommandExecution() {
        // 测试打开命令
        tvControl.setCommand(openCommand);
        tvControl.executeCommand();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("电视机打开了"));
        
        clearConsoleOutput();
        
        // 测试关闭命令
        tvControl.setCommand(closeCommand);
        tvControl.executeCommand();
        
        output = getConsoleOutput();
        assertTrue(output.contains("电视机关闭了"));
    }

    @Test
    @DisplayName("测试命令切换")
    void testCommandSwitching() {
        // 设置打开命令并执行
        tvControl.setCommand(openCommand);
        tvControl.executeCommand();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("电视机打开了"));
        
        clearConsoleOutput();
        
        // 切换到关闭命令并执行
        tvControl.setCommand(closeCommand);
        tvControl.executeCommand();
        
        output = getConsoleOutput();
        assertTrue(output.contains("电视机关闭了"));
        assertFalse(output.contains("电视机打开了"));
    }

    @Test
    @DisplayName("测试命令对象类型")
    void testCommandObjectTypes() {
        // 验证命令对象类型
        assertInstanceOf(TVOpenCommand.class, openCommand);
        assertInstanceOf(TVCloseCommand.class, closeCommand);
        assertInstanceOf(Command.class, openCommand);
        assertInstanceOf(Command.class, closeCommand);
    }

    @Test
    @DisplayName("测试接收者对象")
    void testReceiverObject() {
        // 创建电视对象
        Televation tv = new Televation();
        
        // 验证接收者对象
        assertInstanceOf(Televation.class, tv);
        
        // 直接调用接收者方法
        tv.open();
        String output = getConsoleOutput();
        assertTrue(output.contains("电视机打开了"));
        
        clearConsoleOutput();
        
        tv.close();
        output = getConsoleOutput();
        assertTrue(output.contains("电视机关闭了"));
    }

    @Test
    @DisplayName("测试命令封装")
    void testCommandEncapsulation() {
        // 创建命令
        TVOpenCommand openCmd = new TVOpenCommand(new Televation());
        
        // 验证命令封装了接收者和操作
        assertNotNull(openCmd);
        
        // 执行命令
        openCmd.execute();
        String output = getConsoleOutput();
        assertTrue(output.contains("电视机打开了"));
    }

    @Test
    @DisplayName("测试命令重用")
    void testCommandReuse() {
        // 重用同一个命令对象
        tvControl.setCommand(openCommand);
        
        // 多次执行同一个命令
        tvControl.executeCommand();
        tvControl.executeCommand();
        tvControl.executeCommand();
        
        String output = getConsoleOutput();
        // 验证命令被执行了3次
        int count = 0;
        int index = 0;
        while ((index = output.indexOf("电视机打开了", index)) != -1) {
            count++;
            index += "电视机打开了".length();
        }
        assertEquals(3, count);
    }

    @Test
    @DisplayName("测试命令组合")
    void testCommandComposition() {
        // 创建多个命令
        Command[] commands = {
            new TVOpenCommand(new Televation()),
            new TVCloseCommand(new Televation()),
            new TVOpenCommand(new Televation())
        };
        
        // 依次执行命令
        for (Command command : commands) {
            tvControl.setCommand(command);
            tvControl.executeCommand();
        }
        
        String output = getConsoleOutput();
        assertTrue(output.contains("电视机打开了"));
        assertTrue(output.contains("电视机关闭了"));
        
        // 验证顺序
        int openIndex = output.indexOf("电视机打开了");
        int closeIndex = output.indexOf("电视机关闭了");
        int secondOpenIndex = output.lastIndexOf("电视机打开了");
        
        assertTrue(openIndex < closeIndex);
        assertTrue(closeIndex < secondOpenIndex);
    }

    @Test
    @DisplayName("测试命令空指针处理")
    void testCommandNullHandling() {
        // 测试空命令
        tvControl.setCommand(null);
        
        // 执行空命令应该不会抛出异常
        assertDoesNotThrow(() -> tvControl.executeCommand());
    }

    @Test
    @DisplayName("测试命令性能")
    void testCommandPerformance() {
        // 测试大量命令执行的性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                tvControl.setCommand(i % 2 == 0 ? openCommand : closeCommand);
                tvControl.executeCommand();
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试命令线程安全性")
    void testCommandThreadSafety() throws InterruptedException {
        // 多线程测试命令执行
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                TVControl localControl = new TVControl();
                Command cmd = threadId % 2 == 0 ? 
                    new TVOpenCommand(new Televation()) : 
                    new TVCloseCommand(new Televation());
                localControl.setCommand(cmd);
                localControl.executeCommand();
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
    @DisplayName("测试命令模式扩展性")
    void testCommandPatternExtensibility() {
        // 创建自定义命令
        Command customCommand = new Command() {
            private final Televation tv = new Televation();
            
            @Override
            public void execute() {
                tv.open();
                tv.close();
            }
        };
        
        // 执行自定义命令
        tvControl.setCommand(customCommand);
        tvControl.executeCommand();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("电视机打开了"));
        assertTrue(output.contains("电视机关闭了"));
    }
}