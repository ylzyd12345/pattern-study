package com.kevin.demo.behavioral.mediator;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 中介者模式测试类
 * 测试中介者模式的实现，包括同事对象之间的通信和中介者的协调功能
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("中介者模式测试")
class MediatorPatternTest extends BasePatternTest {

    private ChatRoomMediator chatRoom;
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp() {
        super.setUp();
        chatRoom = new ConcreteChatRoom();
        user1 = new User("张三", chatRoom);
        user2 = new User("李四", chatRoom);
        user3 = new User("王五", chatRoom);
    }

    @Test
    @DisplayName("测试基本消息发送")
    void testBasicMessageSending() {
        // 用户1发送消息
        String message = "大家好！";
        user1.send(message);
        
        // 验证消息被发送
        String output = getConsoleOutput();
        assertTrue(output.contains("[张三] 发送消息: " + message));
        
        // 验证其他用户收到消息
        assertTrue(output.contains("[李四] 收到消息: " + message));
        assertTrue(output.contains("[王五] 收到消息: " + message));
        
        // 发送者不应该收到自己的消息
        assertFalse(output.contains("[张三] 收到消息: " + message));
    }

    @Test
    @DisplayName("测试多个用户发送消息")
    void testMultipleUsersSendingMessages() {
        // 用户1发送消息
        user1.send("第一条消息");
        clearConsoleOutput();
        
        // 用户2发送消息
        user2.send("第二条消息");
        String output = getConsoleOutput();
        
        // 验证消息传递
        assertTrue(output.contains("[李四] 发送消息: 第二条消息"));
        assertTrue(output.contains("[张三] 收到消息: 第二条消息"));
        assertTrue(output.contains("[王五] 收到消息: 第二条消息"));
        assertFalse(output.contains("[李四] 收到消息: 第二条消息"));
    }

    @Test
    @DisplayName("测试用户注册和注销")
    void testUserRegistrationAndUnregistration() {
        // 创建新用户
        User newUser = new User("赵六", chatRoom);
        
        // 新用户发送消息
        newUser.send("我是新用户");
        String output = getConsoleOutput();
        
        // 验证所有用户都收到消息
        assertTrue(output.contains("[张三] 收到消息: 我是新用户"));
        assertTrue(output.contains("[李四] 收到消息: 我是新用户"));
        assertTrue(output.contains("[王五] 收到消息: 我是新用户"));
        assertFalse(output.contains("[赵六] 收到消息: 我是新用户"));
    }

    @Test
    @DisplayName("测试中介者类型识别")
    void testMediatorTypeIdentification() {
        // 验证中介者类型
        assertInstanceOf(ConcreteChatRoom.class, chatRoom);
        assertInstanceOf(ChatRoomMediator.class, chatRoom);
        
        // 验证用户类型
        assertInstanceOf(User.class, user1);
        assertInstanceOf(User.class, user2);
        assertInstanceOf(User.class, user3);
    }

    @Test
    @DisplayName("测试用户名称")
    void testUserNames() {
        // 验证用户名称
        assertEquals("张三", user1.getName());
        assertEquals("李四", user2.getName());
        assertEquals("王五", user3.getName());
        
        // 测试名称在消息中的使用
        user1.send("测试消息");
        String output = getConsoleOutput();
        assertTrue(output.contains("[张三]"));
    }

    @Test
    @DisplayName("测试空消息处理")
    void testEmptyMessageHandling() {
        // 发送空消息
        user1.send("");
        String output = getConsoleOutput();
        
        // 验证空消息被处理
        assertTrue(output.contains("[张三] 发送消息: "));
        assertTrue(output.contains("[李四] 收到消息: "));
        assertTrue(output.contains("[王五] 收到消息: "));
    }

    @Test
    @DisplayName("测试特殊字符消息")
    void testSpecialCharacterMessages() {
        // 发送包含特殊字符的消息
        String specialMessage = "消息包含特殊字符：!@#$%^&*()";
        user1.send(specialMessage);
        
        String output = getConsoleOutput();
        assertTrue(output.contains("[张三] 发送消息: " + specialMessage));
        assertTrue(output.contains("[李四] 收到消息: " + specialMessage));
        assertTrue(output.contains("[王五] 收到消息: " + specialMessage));
    }

    @Test
    @DisplayName("测试长消息处理")
    void testLongMessageHandling() {
        // 创建长消息
        StringBuilder longMessage = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            longMessage.append("这是一个很长的消息");
        }
        
        user1.send(longMessage.toString());
        String output = getConsoleOutput();
        
        // 验证长消息被处理
        assertTrue(output.contains("[张三] 发送消息: " + longMessage.toString()));
        assertTrue(output.contains("[李四] 收到消息: " + longMessage.toString()));
        assertTrue(output.contains("[王五] 收到消息: " + longMessage.toString()));
    }

    @Test
    @DisplayName("测试用户独立性")
    void testUserIndependence() {
        // 创建不同的聊天室
        ChatRoomMediator chatRoom1 = new ConcreteChatRoom();
        ChatRoomMediator chatRoom2 = new ConcreteChatRoom();
        
        // 创建用户并分配到不同聊天室
        User userA = new User("用户A", chatRoom1);
        User userB = new User("用户B", chatRoom1);
        User userC = new User("用户C", chatRoom2);
        
        // 在第一个聊天室发送消息
        userA.send("聊天室1的消息");
        String output = getConsoleOutput();
        
        // 验证只有同一聊天室的用户收到消息
        assertTrue(output.contains("[用户B] 收到消息: 聊天室1的消息"));
        assertFalse(output.contains("[用户C] 收到消息: 聊天室1的消息"));
    }

    @Test
    @DisplayName("测试消息发送性能")
    void testMessageSendingPerformance() {
        // 测试大量消息发送的性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 100; i++) {
                user1.send("消息 " + i);
                clearConsoleOutput();
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试并发消息发送")
    void testConcurrentMessageSending() throws InterruptedException {
        // 多线程测试消息发送
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                User sender = threadId % 3 == 0 ? user1 : 
                             threadId % 3 == 1 ? user2 : user3;
                sender.send("线程 " + threadId + " 的消息");
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
        
        // 验证所有消息都被发送
        String output = getConsoleOutput();
        for (int i = 0; i < threads.length; i++) {
            assertTrue(output.contains("线程 " + i + " 的消息"));
        }
    }

    @Test
    @DisplayName("测试中介者状态管理")
    void testMediatorStateManagement() {
        // 验证初始状态
        assertNotNull(chatRoom);
        
        // 发送多条消息
        user1.send("消息1");
        user2.send("消息2");
        user3.send("消息3");
        
        // 验证中介器仍然正常工作
        user1.send("最后的消息");
        String output = getConsoleOutput();
        assertTrue(output.contains("[张三] 发送消息: 最后的消息"));
    }

    @Test
    @DisplayName("测试用户与中介者关系")
    void testUserMediatorRelationship() {
        // 验证用户与中介者的关系
        assertSame(chatRoom, user1.getMediator());
        assertSame(chatRoom, user2.getMediator());
        assertSame(chatRoom, user3.getMediator());
        
        // 创建新用户并分配中介者
        User newUser = new User("新用户", chatRoom);
        assertSame(chatRoom, newUser.getMediator());
    }

    @Test
    @DisplayName("测试消息传递完整性")
    void testMessageIntegrity() {
        // 发送各种类型的消息
        String[] messages = {
            "简单消息",
            "包含数字123的消息",
            "包含英文English的消息",
            "混合中English文123的消息"
        };
        
        for (String message : messages) {
            clearConsoleOutput();
            user1.send(message);
            
            String output = getConsoleOutput();
            assertTrue(output.contains("[张三] 发送消息: " + message));
            assertTrue(output.contains("[李四] 收到消息: " + message));
            assertTrue(output.contains("[王五] 收到消息: " + message));
        }
    }
}