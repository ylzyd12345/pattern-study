package com.kevin.demo.behavioral.state;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 状态模式测试类
 * 测试状态模式的实现，包括状态转换和状态相关的行为
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("状态模式测试")
class StatePatternTest extends BasePatternTest {

    private Account account;

    @BeforeEach
    void setUp() {
        super.setUp();
        account = new Account("张三", 1000.0);
    }

    @Test
    @DisplayName("测试正常状态")
    void testNormalState() {
        // 验证初始状态为正常状态
        String output = getConsoleOutput();
        assertTrue(output.contains("正常状态"));
        
        // 在正常状态下存款
        account.deposit(500.0);
        clearConsoleOutput();
        
        // 在正常状态下取款
        account.withdraw(200.0);
        output = getConsoleOutput();
        assertTrue(output.contains("正常状态"));
        assertTrue(output.contains("存款成功"));
        assertTrue(output.contains("取款成功"));
    }

    @Test
    @DisplayName("测试透支状态转换")
    void testOverdraftStateTransition() {
        // 取款超过余额，进入透支状态
        account.withdraw(1500.0);
        String output = getConsoleOutput();
        
        // 验证进入透支状态
        assertTrue(output.contains("透支状态"));
        assertTrue(output.contains("取款成功"));
        
        // 在透支状态下存款
        clearConsoleOutput();
        account.deposit(1000.0);
        output = getConsoleOutput();
        
        // 验证状态转换
        assertTrue(output.contains("正常状态"));
        assertTrue(output.contains("存款成功"));
    }

    @Test
    @DisplayName("测试受限状态转换")
    void testRestrictedStateTransition() {
        // 先进入透支状态
        account.withdraw(1500.0);
        
        // 继续取款进入受限状态
        account.withdraw(100.0);
        String output = getConsoleOutput();
        
        // 验证进入受限状态
        assertTrue(output.contains("受限状态"));
        
        // 在受限状态下尝试取款（应该失败）
        clearConsoleOutput();
        account.withdraw(50.0);
        output = getConsoleOutput();
        
        // 验证取款受限
        assertTrue(output.contains("受限状态"));
        assertTrue(output.contains("取款受限"));
        
        // 在受限状态下存款
        clearConsoleOutput();
        account.deposit(300.0);
        output = getConsoleOutput();
        
        // 验证状态转换
        assertTrue(output.contains("正常状态"));
    }

    @Test
    @DisplayName("测试状态对象类型")
    void testStateObjectTypes() {
        // 验证账户类型
        assertInstanceOf(Account.class, account);
        
        // 验证状态转换后的状态对象类型
        account.withdraw(2000.0);
        String output = getConsoleOutput();
        assertTrue(output.contains("受限状态"));
    }

    @Test
    @DisplayName("测试账户信息")
    void testAccountInformation() {
        // 验证账户基本信息
        assertEquals("张三", account.getOwner());
        assertEquals(1000.0, account.getBalance(), 0.001);
        
        // 修改余额后验证
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), 0.001);
        
        account.withdraw(200.0);
        assertEquals(1300.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("测试状态相关行为差异")
    void testStateSpecificBehaviors() {
        // 正常状态下的行为
        account.deposit(100.0);
        String output1 = getConsoleOutput();
        assertTrue(output1.contains("正常状态"));
        
        // 透支状态下的行为
        account.withdraw(2000.0);
        account.deposit(100.0);
        String output2 = getConsoleOutput();
        assertTrue(output2.contains("透支状态"));
        
        // 受限状态下的行为
        account.withdraw(100.0);
        account.withdraw(50.0);
        String output3 = getConsoleOutput();
        assertTrue(output3.contains("受限状态"));
        assertTrue(output3.contains("取款受限"));
    }

    @Test
    @DisplayName("测试状态转换边界")
    void testStateTransitionBoundaries() {
        // 精确测试状态转换边界
        
        // 从正常到透支：余额 < 0
        account.withdraw(1000.0); // 余额 = 0
        String output1 = getConsoleOutput();
        assertTrue(output1.contains("正常状态")); // 余额=0仍为正常状态
        
        account.withdraw(0.01); // 余额 = -0.01
        String output2 = getConsoleOutput();
        assertTrue(output2.contains("透支状态")); // 余额<0进入透支状态
        
        // 从透支到受限：余额 < -1000
        account.withdraw(999.99); // 余额 = -1000.0
        String output3 = getConsoleOutput();
        assertTrue(output3.contains("透支状态")); // 余额=-1000仍为透支状态
        
        account.withdraw(0.01); // 余额 = -1000.01
        String output4 = getConsoleOutput();
        assertTrue(output4.contains("受限状态")); // 余额<-1000进入受限状态
    }

    @Test
    @DisplayName("测试大额交易")
    void testLargeTransactions() {
        // 测试大额存款
        account.deposit(1000000.0);
        String output1 = getConsoleOutput();
        assertTrue(output1.contains("正常状态"));
        assertTrue(output1.contains("存款成功"));
        
        // 测试大额取款
        account.withdraw(500000.0);
        String output2 = getConsoleOutput();
        assertTrue(output2.contains("正常状态"));
        assertTrue(output2.contains("取款成功"));
    }

    @Test
    @DisplayName("测试零金额交易")
    void testZeroAmountTransactions() {
        // 测试零金额存款
        account.deposit(0.0);
        String output1 = getConsoleOutput();
        assertTrue(output1.contains("正常状态"));
        
        // 测试零金额取款
        account.withdraw(0.0);
        String output2 = getConsoleOutput();
        assertTrue(output2.contains("正常状态"));
    }

    @Test
    @DisplayName("测试负金额交易")
    void testNegativeAmountTransactions() {
        // 测试负金额存款（应该被拒绝或特殊处理）
        account.deposit(-100.0);
        String output1 = getConsoleOutput();
        
        // 测试负金额取款（应该被拒绝或特殊处理）
        account.withdraw(-100.0);
        String output2 = getConsoleOutput();
        
        // 验证账户状态没有异常变化
        assertEquals(1000.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("测试状态转换性能")
    void testStateTransitionPerformance() {
        // 测试大量状态转换的性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                if (i % 3 == 0) {
                    account.deposit(100.0);
                } else {
                    account.withdraw(50.0);
                }
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试并发状态操作")
    void testConcurrentStateOperations() throws InterruptedException {
        // 多线程测试状态操作
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                if (threadId % 2 == 0) {
                    account.deposit(100.0);
                } else {
                    account.withdraw(50.0);
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
        
        // 验证最终余额（5次存款+5次取款）
        assertEquals(1000.0 + 5 * 100.0 - 5 * 50.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("测试状态持久化概念")
    void testStatePersistenceConcept() {
        // 模拟状态保存和恢复的概念
        double originalBalance = account.getBalance();
        
        // 执行一些操作改变状态
        account.withdraw(1500.0); // 进入透支状态
        
        // 验证状态已改变
        assertTrue(account.getBalance() < 0);
        
        // 模拟恢复（这里只是概念验证）
        Account restoredAccount = new Account("张三", originalBalance);
        assertEquals(originalBalance, restoredAccount.getBalance(), 0.001);
    }

    @Test
    @DisplayName("测试状态模式扩展性")
    void testStatePatternExtensibility() {
        // 创建具有不同初始条件的账户
        Account richAccount = new Account("富人", 10000.0);
        Account poorAccount = new Account("穷人", 100.0);
        
        // 验证不同账户的行为
        richAccount.withdraw(5000.0);
        String output1 = getConsoleOutput();
        assertTrue(output1.contains("正常状态"));
        
        poorAccount.withdraw(200.0);
        String output2 = getConsoleOutput();
        assertTrue(output2.contains("透支状态"));
    }

    @Test
    @DisplayName("测试状态机完整性")
    void testStateMachineCompleteness() {
        // 测试完整的状态转换循环
        
        // 正常 -> 透支 -> 受限 -> 正常
        account.withdraw(1500.0); // 正常 -> 透支
        assertTrue(getConsoleOutput().contains("透支状态"));
        
        account.withdraw(100.0);  // 透支 -> 受限
        assertTrue(getConsoleOutput().contains("受限状态"));
        
        account.deposit(2000.0);  // 受限 -> 正常
        assertTrue(getConsoleOutput().contains("正常状态"));
        
        // 验证最终状态
        assertTrue(account.getBalance() >= 0);
    }
}