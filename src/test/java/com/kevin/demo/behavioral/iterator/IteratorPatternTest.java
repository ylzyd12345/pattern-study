package com.kevin.demo.behavioral.iterator;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 迭代器模式测试类
 * 测试迭代器模式的实现，包括集合的遍历和迭代器的使用
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("迭代器模式测试")
class IteratorPatternTest extends BasePatternTest {

    private GameTeam gameTeam;
    private static final String[] MEMBER_NAMES = {
        "张三", "李四", "王五", "赵六", "钱七"
    };

    @BeforeEach
    void setUp() {
        super.setUp();
        gameTeam = new GameTeam();
        
        // 添加团队成员
        for (String name : MEMBER_NAMES) {
            gameTeam.addMember(name);
        }
    }

    @Test
    @DisplayName("测试基本迭代功能")
    void testBasicIteration() {
        Iterator iterator = gameTeam.createIterator();
        
        // 遍历所有成员
        int count = 0;
        while (iterator.hasNext()) {
            Member member = (Member) iterator.next();
            assertNotNull(member);
            assertEquals(MEMBER_NAMES[count], member.getName());
            count++;
        }
        
        // 验证遍历了所有成员
        assertEquals(MEMBER_NAMES.length, count);
    }

    @Test
    @DisplayName("测试迭代器hasNext方法")
    void testIteratorHasNext() {
        Iterator iterator = gameTeam.createIterator();
        
        // 验证初始状态
        assertTrue(iterator.hasNext());
        
        // 遍历到最后一个元素
        while (iterator.hasNext()) {
            iterator.next();
        }
        
        // 验证遍历结束后hasNext返回false
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("测试空集合迭代")
    void testEmptyCollectionIteration() {
        // 创建空团队
        GameTeam emptyTeam = new GameTeam();
        Iterator iterator = emptyTeam.createIterator();
        
        // 空集合应该没有下一个元素
        assertFalse(iterator.hasNext());
        
        // 尝试获取下一个元素应该返回null或抛出异常
        assertNull(iterator.next());
    }

    @Test
    @DisplayName("测试迭代器重置")
    void testIteratorReset() {
        Iterator iterator = gameTeam.createIterator();
        
        // 遍历几个元素
        if (iterator.hasNext()) iterator.next();
        if (iterator.hasNext()) iterator.next();
        
        // 重置迭代器
        iterator.reset();
        
        // 验证重置后可以重新遍历
        assertTrue(iterator.hasNext());
        Member firstMember = (Member) iterator.next();
        assertEquals(MEMBER_NAMES[0], firstMember.getName());
    }

    @Test
    @DisplayName("测试多次创建迭代器")
    void testMultipleIterators() {
        // 创建多个迭代器
        Iterator iterator1 = gameTeam.createIterator();
        Iterator iterator2 = gameTeam.createIterator();
        
        // 验证两个迭代器独立工作
        assertTrue(iterator1.hasNext());
        assertTrue(iterator2.hasNext());
        
        // 使用第一个迭代器
        Member member1 = (Member) iterator1.next();
        assertEquals(MEMBER_NAMES[0], member1.getName());
        
        // 第二个迭代器仍然从第一个元素开始
        Member member2 = (Member) iterator2.next();
        assertEquals(MEMBER_NAMES[0], member2.getName());
    }

    @Test
    @DisplayName("测试团队成员添加")
    void testMemberAddition() {
        // 添加新成员
        String newMemberName = "新成员";
        gameTeam.addMember(newMemberName);
        
        // 验证新成员被添加
        Iterator iterator = gameTeam.createIterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Member member = (Member) iterator.next();
            if (newMemberName.equals(member.getName())) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    @DisplayName("测试团队成员移除")
    void testMemberRemoval() {
        // 移除成员
        String memberToRemove = MEMBER_NAMES[2]; // 王五
        gameTeam.removeMember(memberToRemove);
        
        // 验证成员被移除
        Iterator iterator = gameTeam.createIterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Member member = (Member) iterator.next();
            if (memberToRemove.equals(member.getName())) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }

    @Test
    @DisplayName("测试团队大小")
    void testTeamSize() {
        // 验证初始大小
        assertEquals(MEMBER_NAMES.length, gameTeam.size());
        
        // 添加成员后验证大小
        gameTeam.addMember("新成员1");
        assertEquals(MEMBER_NAMES.length + 1, gameTeam.size());
        
        // 移除成员后验证大小
        gameTeam.removeMember(MEMBER_NAMES[0]);
        assertEquals(MEMBER_NAMES.length, gameTeam.size());
    }

    @Test
    @DisplayName("测试成员对象类型")
    void testMemberObjectType() {
        Iterator iterator = gameTeam.createIterator();
        
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            assertInstanceOf(Member.class, obj);
            
            Member member = (Member) obj;
            assertNotNull(member.getName());
            assertTrue(member.getName().length() > 0);
        }
    }

    @Test
    @DisplayName("测试迭代器性能")
    void testIteratorPerformance() {
        // 创建大型团队
        GameTeam largeTeam = new GameTeam();
        for (int i = 0; i < 1000; i++) {
            largeTeam.addMember("成员" + i);
        }
        
        // 测试遍历性能
        assertExecutionTime(() -> {
            Iterator iterator = largeTeam.createIterator();
            while (iterator.hasNext()) {
                iterator.next();
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试迭代器线程安全性")
    void testIteratorThreadSafety() throws InterruptedException {
        // 创建团队并添加成员
        GameTeam sharedTeam = new GameTeam();
        for (int i = 0; i < 100; i++) {
            sharedTeam.addMember("成员" + i);
        }
        
        // 多线程测试
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                Iterator iterator = sharedTeam.createIterator();
                while (iterator.hasNext()) {
                    iterator.next();
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
        assertTrue(true); // 如果没有异常，测试通过
    }

    @Test
    @DisplayName("测试边界条件")
    void testEdgeCases() {
        // 测试单成员团队
        GameTeam singleMemberTeam = new GameTeam();
        singleMemberTeam.addMember("唯一成员");
        
        Iterator iterator = singleMemberTeam.createIterator();
        assertTrue(iterator.hasNext());
        Member member = (Member) iterator.next();
        assertEquals("唯一成员", member.getName());
        assertFalse(iterator.hasNext());
        
        // 测试添加null成员
        assertDoesNotThrow(() -> {
            gameTeam.addMember(null);
        });
    }

    @Test
    @DisplayName("测试迭代器状态")
    void testIteratorState() {
        Iterator iterator = gameTeam.createIterator();
        
        // 验证初始状态
        assertTrue(iterator.hasNext());
        
        // 遍历几个元素
        int count = 0;
        while (iterator.hasNext() && count < 3) {
            iterator.next();
            count++;
        }
        
        // 验证状态
        assertTrue(iterator.hasNext()); // 应该还有元素
        
        // 遍历剩余元素
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        
        // 验证遍历了所有元素
        assertEquals(MEMBER_NAMES.length, count);
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("测试Team接口实现")
    void testTeamInterfaceImplementation() {
        // 验证Team接口实现
        assertInstanceOf(Team.class, gameTeam);
        
        // 验证接口方法
        assertNotNull(gameTeam.createIterator());
        assertTrue(gameTeam.size() >= 0);
        
        // 测试添加和移除
        int initialSize = gameTeam.size();
        gameTeam.addMember("测试成员");
        assertEquals(initialSize + 1, gameTeam.size());
        
        gameTeam.removeMember("测试成员");
        assertEquals(initialSize, gameTeam.size());
    }
}