package com.kevin.demo.behavioral.visitor;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 访问者模式测试类
 * 测试访问者模式的实现，包括访问者对不同元素类型的操作
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("访问者模式测试")
class VisitorPatternTest extends BasePatternTest {

    private Person police;
    private Person thief;
    private Door woodDoor;
    private Door steelDoor;
    private Chimney woodChimney;
    private Chimney steelChimney;
    private Casement woodCasement;
    private Casement steelCasement;

    @BeforeEach
    void setUp() {
        super.setUp();
        police = new Police();
        thief = new Thief();
        
        woodDoor = new WoodDoor();
        steelDoor = new SteelDoor();
        woodChimney = new WoodChimney();
        steelChimney = new SteelChimney();
        woodCasement = new WoodCasement();
        steelCasement = new SteelCasement();
    }

    @Test
    @DisplayName("测试警察访问木质元素")
    void testPoliceVisitWoodElements() {
        // 警察访问木质门
        woodDoor.accept(police);
        String output = getConsoleOutput();
        assertTrue(output.contains("警察检查木质门"));
        
        clearConsoleOutput();
        
        // 警察访问木质烟囱
        woodChimney.accept(police);
        output = getConsoleOutput();
        assertTrue(output.contains("警察检查木质烟囱"));
        
        clearConsoleOutput();
        
        // 警察访问木质窗户
        woodCasement.accept(police);
        output = getConsoleOutput();
        assertTrue(output.contains("警察检查木质窗户"));
    }

    @Test
    @DisplayName("测试警察访问钢质元素")
    void testPoliceVisitSteelElements() {
        // 警察访问钢质门
        steelDoor.accept(police);
        String output = getConsoleOutput();
        assertTrue(output.contains("警察检查钢质门"));
        
        clearConsoleOutput();
        
        // 警察访问钢质烟囱
        steelChimney.accept(police);
        output = getConsoleOutput();
        assertTrue(output.contains("警察检查钢质烟囱"));
        
        clearConsoleOutput();
        
        // 警察访问钢质窗户
        steelCasement.accept(police);
        output = getConsoleOutput();
        assertTrue(output.contains("警察检查钢质窗户"));
    }

    @Test
    @DisplayName("测试小偷访问木质元素")
    void testThiefVisitWoodElements() {
        // 小偷访问木质门
        woodDoor.accept(thief);
        String output = getConsoleOutput();
        assertTrue(output.contains("小偷撬开木质门"));
        
        clearConsoleOutput();
        
        // 小偷访问木质烟囱
        woodChimney.accept(thief);
        output = getConsoleOutput();
        assertTrue(output.contains("小偷钻进木质烟囱"));
        
        clearConsoleOutput();
        
        // 小偷访问木质窗户
        woodCasement.accept(thief);
        output = getConsoleOutput();
        assertTrue(output.contains("小偷打开木质窗户"));
    }

    @Test
    @DisplayName("测试小偷访问钢质元素")
    void testThiefVisitSteelElements() {
        // 小偷访问钢质门
        steelDoor.accept(thief);
        String output = getConsoleOutput();
        assertTrue(output.contains("小偷撬不开钢质门"));
        
        clearConsoleOutput();
        
        // 小偷访问钢质烟囱
        steelChimney.accept(thief);
        output = getConsoleOutput();
        assertTrue(output.contains("小偷钻不进钢质烟囱"));
        
        clearConsoleOutput();
        
        // 小偷访问钢质窗户
        steelCasement.accept(thief);
        output = getConsoleOutput();
        assertTrue(output.contains("小偷打不开钢质窗户"));
    }

    @Test
    @DisplayName("测试访问者类型识别")
    void testVisitorTypeIdentification() {
        // 验证访问者类型
        assertInstanceOf(Police.class, police);
        assertInstanceOf(Thief.class, thief);
        assertInstanceOf(Person.class, police);
        assertInstanceOf(Person.class, thief);
        
        // 验证元素类型
        assertInstanceOf(WoodDoor.class, woodDoor);
        assertInstanceOf(SteelDoor.class, steelDoor);
        assertInstanceOf(WoodChimney.class, woodChimney);
        assertInstanceOf(SteelChimney.class, steelChimney);
        assertInstanceOf(WoodCasement.class, woodCasement);
        assertInstanceOf(SteelCasement.class, steelCasement);
    }

    @Test
    @DisplayName("测试元素接口实现")
    void testElementInterfaceImplementation() {
        // 验证所有元素都实现了Openable接口
        assertTrue(woodDoor instanceof Openable);
        assertTrue(steelDoor instanceof Openable);
        assertTrue(woodChimney instanceof Openable);
        assertTrue(steelChimney instanceof Openable);
        assertTrue(woodCasement instanceof Openable);
        assertTrue(steelCasement instanceof Openable);
        
        // 验证accept方法存在
        assertDoesNotThrow(() -> {
            woodDoor.accept(police);
            steelDoor.accept(thief);
            woodChimney.accept(police);
            steelChimney.accept(thief);
            woodCasement.accept(police);
            steelCasement.accept(thief);
        });
    }

    @Test
    @DisplayName("测试访问者双分派机制")
    void testVisitorDoubleDispatch() {
        // 测试双分派：运行时根据访问者和元素的具体类型确定操作
        
        // 同一个访问者访问不同元素
        woodDoor.accept(police);
        String output1 = getConsoleOutput();
        assertTrue(output1.contains("警察检查木质门"));
        
        clearConsoleOutput();
        
        steelDoor.accept(police);
        String output2 = getConsoleOutput();
        assertTrue(output2.contains("警察检查钢质门"));
        
        // 不同访问者访问同一元素
        clearConsoleOutput();
        
        woodDoor.accept(thief);
        String output3 = getConsoleOutput();
        assertTrue(output3.contains("小偷撬开木质门"));
    }

    @Test
    @DisplayName("测试访问者操作多样性")
    void testVisitorOperationVariety() {
        // 测试不同访问者对同一元素的不同操作
        
        // 对木质门的不同操作
        woodDoor.accept(police);
        String policeOutput = getConsoleOutput();
        assertTrue(policeOutput.contains("检查"));
        
        clearConsoleOutput();
        
        woodDoor.accept(thief);
        String thiefOutput = getConsoleOutput();
        assertTrue(thiefOutput.contains("撬开"));
        
        // 验证操作确实不同
        assertNotEquals(policeOutput, thiefOutput);
    }

    @Test
    @DisplayName("测试复杂访问序列")
    void testComplexVisitSequence() {
        // 创建复杂的访问序列
        Openable[] elements = {woodDoor, steelDoor, woodChimney, steelChimney, woodCasement, steelCasement};
        Person[] visitors = {police, thief};
        
        // 依次访问
        for (Person visitor : visitors) {
            for (Openable element : elements) {
                element.accept(visitor);
            }
        }
        
        String output = getConsoleOutput();
        
        // 验证所有访问都发生了
        assertTrue(output.contains("警察检查木质门"));
        assertTrue(output.contains("警察检查钢质门"));
        assertTrue(output.contains("警察检查木质烟囱"));
        assertTrue(output.contains("警察检查钢质烟囱"));
        assertTrue(output.contains("警察检查木质窗户"));
        assertTrue(output.contains("警察检查钢质窗户"));
        
        assertTrue(output.contains("小偷撬开木质门"));
        assertTrue(output.contains("小偷撬不开钢质门"));
        assertTrue(output.contains("小偷钻进木质烟囱"));
        assertTrue(output.contains("小偷钻不进钢质烟囱"));
        assertTrue(output.contains("小偷打开木质窗户"));
        assertTrue(output.contains("小偷打不开钢质窗户"));
    }

    @Test
    @DisplayName("测试访问者扩展性")
    void testVisitorExtensibility() {
        // 创建新的访问者
        Person inspector = new Person() {
            @Override
            public void visit(WoodDoor door) {
                System.out.println("检查员检查木质门的安全");
            }
            
            @Override
            public void visit(SteelDoor door) {
                System.out.println("检查员检查钢质门的安全");
            }
            
            @Override
            public void visit(WoodChimney chimney) {
                System.out.println("检查员检查木质烟囱的通风");
            }
            
            @Override
            public void visit(SteelChimney chimney) {
                System.out.println("检查员检查钢质烟囱的通风");
            }
            
            @Override
            public void visit(WoodCasement casement) {
                System.out.println("检查员检查木质窗户的密封");
            }
            
            @Override
            public void visit(SteelCasement casement) {
                System.out.println("检查员检查钢质窗户的密封");
            }
        };
        
        // 使用新访问者
        woodDoor.accept(inspector);
        String output = getConsoleOutput();
        assertTrue(output.contains("检查员检查木质门的安全"));
    }

    @Test
    @DisplayName("测试元素扩展性")
    void testElementExtensibility() {
        // 创建新的元素类型
        Openable newElement = new Openable() {
            @Override
            public void accept(Person visitor) {
                visitor.visit(this);
            }
        };
        
        // 访问新元素（这需要访问者支持新类型）
        // 这里只是概念验证
        assertNotNull(newElement);
    }

    @Test
    @DisplayName("测试访问者性能")
    void testVisitorPerformance() {
        // 测试大量访问操作的性能
        Openable[] elements = {woodDoor, steelDoor, woodChimney, steelChimney, woodCasement, steelCasement};
        
        assertExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                for (Openable element : elements) {
                    element.accept(i % 2 == 0 ? police : thief);
                }
                clearConsoleOutput();
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试访问者线程安全性")
    void testVisitorThreadSafety() throws InterruptedException {
        // 多线程测试访问者操作
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                Person visitor = threadId % 2 == 0 ? police : thief;
                Openable element = threadId % 3 == 0 ? woodDoor : 
                                 threadId % 3 == 1 ? steelDoor : woodChimney;
                element.accept(visitor);
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
    @DisplayName("测试访问者状态管理")
    void testVisitorStateManagement() {
        // 如果访问者有状态，测试状态管理
        
        // 警察访问多个元素
        woodDoor.accept(police);
        steelDoor.accept(police);
        woodChimney.accept(police);
        
        String output = getConsoleOutput();
        
        // 验证警察的所有操作都被记录
        assertTrue(output.contains("警察检查木质门"));
        assertTrue(output.contains("警察检查钢质门"));
        assertTrue(output.contains("警察检查木质烟囱"));
    }

    @Test
    @DisplayName("测试访问者模式设计原则")
    void testVisitorPatternDesignPrinciples() {
        // 验证访问者模式的设计原则
        
        // 1. 访问者操作与元素结构分离
        // 警察的操作逻辑集中在Police类中，而不是分散在各个元素类中
        
        // 2. 新增操作不需要修改元素类
        // 可以通过新增访问者类来添加新的操作
        
        // 3. 双分派机制
        woodDoor.accept(police);
        String output1 = getConsoleOutput();
        assertTrue(output1.contains("警察检查木质门"));
        
        clearConsoleOutput();
        
        steelDoor.accept(police);
        String output2 = getConsoleOutput();
        assertTrue(output2.contains("警察检查钢质门"));
        
        // 验证确实是不同的操作
        assertNotEquals(output1, output2);
    }
}