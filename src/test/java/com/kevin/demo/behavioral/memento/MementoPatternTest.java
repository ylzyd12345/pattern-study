package com.kevin.demo.behavioral.memento;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 备忘录模式测试类
 * 测试备忘录模式的实现，包括状态的保存和恢复功能
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("备忘录模式测试")
class MementoPatternTest extends BasePatternTest {

    private Role role;
    private Caretaker caretaker;

    @BeforeEach
    void setUp() {
        super.setUp();
        role = new Role();
        caretaker = new Caretaker();
        
        // 初始化角色状态
        role.init();
    }

    @Test
    @DisplayName("测试基本状态保存和恢复")
    void testBasicStateSaveAndRestore() {
        // 保存初始状态
        Memento initialMemento = role.saveState();
        caretaker.addMemento(initialMemento);
        
        // 修改状态
        role.fight();
        role.fight();
        
        // 验证状态已改变
        String output = getConsoleOutput();
        assertTrue(output.contains("角色战斗"));
        
        // 恢复状态
        Memento savedMemento = caretaker.getMemento(0);
        role.restoreState(savedMemento);
        
        // 验证状态已恢复
        assertTrue(output.contains("角色恢复状态"));
    }

    @Test
    @DisplayName("测试多个状态保存")
    void testMultipleStateSaves() {
        // 保存多个状态
        role.fight();
        caretaker.addMemento(role.saveState());
        
        role.fight();
        role.fight();
        caretaker.addMemento(role.saveState());
        
        role.fight();
        caretaker.addMemento(role.saveState());
        
        // 恢复到第一个保存的状态
        role.restoreState(caretaker.getMemento(0));
        String output = getConsoleOutput();
        assertTrue(output.contains("角色恢复状态"));
        
        // 恢复到第二个保存的状态
        clearConsoleOutput();
        role.restoreState(caretaker.getMemento(1));
        output = getConsoleOutput();
        assertTrue(output.contains("角色恢复状态"));
    }

    @Test
    @DisplayName("测试备忘录不可变性")
    void testMementoImmutability() {
        // 保存状态
        Memento memento = role.saveState();
        
        // 尝试修改备忘录（应该不允许或没有效果）
        // 这里假设Memento类没有提供修改方法
        assertNotNull(memento);
        
        // 恢复状态
        role.restoreState(memento);
        String output = getConsoleOutput();
        assertTrue(output.contains("角色恢复状态"));
    }

    @Test
    @DisplayName("测试备忘录类型识别")
    void testMementoTypeIdentification() {
        // 创建备忘录
        Memento memento = role.saveState();
        
        // 验证类型
        assertInstanceOf(Memento.class, memento);
        
        // 验证其他类型
        assertInstanceOf(Role.class, role);
        assertInstanceOf(Caretaker.class, caretaker);
    }

    @Test
    @DisplayName("测试管理员功能")
    void testCaretakerFunctionality() {
        // 保存多个备忘录
        for (int i = 0; i < 5; i++) {
            role.fight();
            caretaker.addMemento(role.saveState());
        }
        
        // 验证管理员保存了备忘录
        assertTrue(caretaker.getMementoCount() > 0);
        
        // 获取所有备忘录
        for (int i = 0; i < caretaker.getMementoCount(); i++) {
            Memento memento = caretaker.getMemento(i);
            assertNotNull(memento);
        }
    }

    @Test
    @DisplayName("�试状态回滚序列")
    void testStateRollbackSequence() {
        // 保存初始状态
        caretaker.addMemento(role.saveState());
        
        // 执行一系列操作
        role.fight();
        caretaker.addMemento(role.saveState());
        
        role.fight();
        role.fight();
        caretaker.addMemento(role.saveState());
        
        role.fight();
        
        // 逐步回滚
        role.restoreState(caretaker.getMemento(2)); // 回滚到第3个状态
        clearConsoleOutput();
        role.restoreState(caretaker.getMemento(1)); // 回滚到第2个状态
        String output = getConsoleOutput();
        assertTrue(output.contains("角色恢复状态"));
        
        clearConsoleOutput();
        role.restoreState(caretaker.getMemento(0)); // 回滚到初始状态
        output = getConsoleOutput();
        assertTrue(output.contains("角色恢复状态"));
    }

    @Test
    @DisplayName("测试边界条件")
    void testEdgeCases() {
        // 测试空管理员的恢复
        Caretaker emptyCaretaker = new Caretaker();
        assertNull(emptyCaretaker.getMemento(0));
        
        // 测试索引越界
        caretaker.addMemento(role.saveState());
        assertNull(caretaker.getMemento(10));
        assertNull(caretaker.getMemento(-1));
    }

    @Test
    @DisplayName("测试角色状态变化")
    void testRoleStateChanges() {
        // 初始化角色
        role.init();
        clearConsoleOutput();
        
        // 执行各种操作
        role.fight();
        role.fight();
        role.fight();
        
        String output = getConsoleOutput();
        int fightCount = 0;
        int index = 0;
        while ((index = output.indexOf("角色战斗", index)) != -1) {
            fightCount++;
            index += "角色战斗".length();
        }
        assertEquals(3, fightCount);
    }

    @Test
    @DisplayName("测试备忘录性能")
    void testMementoPerformance() {
        // 测试大量状态保存和恢复的性能
        assertExecutionTime(() -> {
            // 保存大量状态
            for (int i = 0; i < 100; i++) {
                role.fight();
                caretaker.addMemento(role.saveState());
            }
            
            // 恢复状态
            for (int i = 0; i < 100; i++) {
                role.restoreState(caretaker.getMemento(i));
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试备忘录内存管理")
    void testMementoMemoryManagement() {
        // 保存大量备忘录
        for (int i = 0; i < 1000; i++) {
            role.fight();
            caretaker.addMemento(role.saveState());
        }
        
        // 验证备忘录数量
        assertTrue(caretaker.getMementoCount() >= 1000);
        
        // 清理一些备忘录（如果支持的话）
        // 这里只是验证能够访问所有备忘录
        for (int i = 0; i < Math.min(10, caretaker.getMementoCount()); i++) {
            Memento memento = caretaker.getMemento(i);
            assertNotNull(memento);
        }
    }

    @Test
    @DisplayName("测试状态一致性")
    void testStateConsistency() {
        // 保存状态
        caretaker.addMemento(role.saveState());
        
        // 执行操作
        role.fight();
        role.fight();
        
        // 多次恢复到同一个状态
        Memento savedState = caretaker.getMemento(0);
        for (int i = 0; i < 5; i++) {
            clearConsoleOutput();
            role.restoreState(savedState);
            String output = getConsoleOutput();
            assertTrue(output.contains("角色恢复状态"));
        }
    }

    @Test
    @DisplayName("测试备忘录封装性")
    void testMementoEncapsulation() {
        // 保存状态
        Memento memento = role.saveState();
        
        // 验证备忘录不直接暴露内部状态
        // 这取决于具体的实现，这里只是基本验证
        assertNotNull(memento);
        
        // 备忘录应该只能由原角色使用
        role.restoreState(memento);
        String output = getConsoleOutput();
        assertTrue(output.contains("角色恢复状态"));
    }

    @Test
    @DisplayName("测试复杂状态序列")
    void testComplexStateSequence() {
        // 创建复杂的状态序列
        caretaker.addMemento(role.saveState()); // 状态0
        
        // 序列1
        for (int i = 0; i < 3; i++) {
            role.fight();
        }
        caretaker.addMemento(role.saveState()); // 状态1
        
        // 序列2
        for (int i = 0; i < 5; i++) {
            role.fight();
        }
        caretaker.addMemento(role.saveState()); // 状态2
        
        // 序列3
        for (int i = 0; i < 2; i++) {
            role.fight();
        }
        caretaker.addMemento(role.saveState()); // 状态3
        
        // 验证可以跳转到任意状态
        role.restoreState(caretaker.getMemento(1));
        clearConsoleOutput();
        role.restoreState(caretaker.getMemento(3));
        String output = getConsoleOutput();
        assertTrue(output.contains("角色恢复状态"));
    }

    @Test
    @DisplayName("测试角色生命周期")
    void testRoleLifecycle() {
        // 测试角色初始化
        Role newRole = new Role();
        newRole.init();
        
        // 测试角色操作
        newRole.fight();
        newRole.fight();
        
        // 测试状态保存
        Memento memento = newRole.saveState();
        assertNotNull(memento);
        
        // 测试状态恢复
        newRole.restoreState(memento);
        
        // 验证角色仍然正常工作
        newRole.fight();
        String output = getConsoleOutput();
        assertTrue(output.contains("角色战斗"));
    }
}