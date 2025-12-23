package com.kevin.demo.structural.flyweight;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 享元模式测试类
 * 测试享元模式的实现，包括对象的共享和内外状态的分离
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("享元模式测试")
class FlyweightPatternTest extends BasePatternTest {

    private ShapeFactory shapeFactory;

    @BeforeEach
    void setUp() {
        super.setUp();
        shapeFactory = new ShapeFactory();
    }

    @Test
    @DisplayName("测试基本享元对象获取")
    void testBasicFlyweightRetrieval() {
        // 获取圆形对象
        Shape circle1 = shapeFactory.getShape("圆形");
        Shape circle2 = shapeFactory.getShape("圆形");
        
        // 验证是同一个对象（享元共享）
        assertSame(circle1, circle2);
        
        // 验证对象类型
        assertInstanceOf(CircleShape.class, circle1);
        assertInstanceOf(CircleShape.class, circle2);
    }

    @Test
    @DisplayName("测试不同类型享元对象")
    void testDifferentFlyweightTypes() {
        // 获取不同类型的形状
        Shape circle = shapeFactory.getShape("圆形");
        Shape square = shapeFactory.getShape("正方形");
        
        // 验证是不同的对象
        assertNotSame(circle, square);
        
        // 验证类型
        assertInstanceOf(CircleShape.class, circle);
        // 假设还有正方形的实现
        assertNotNull(square);
    }

    @Test
    @DisplayName("测试享元对象操作")
    void testFlyweightOperations() {
        // 获取圆形对象
        Shape circle = shapeFactory.getShape("圆形");
        
        // 执行操作（传入外部状态）
        circle.draw("红色", 10, 20);
        
        String output = getConsoleOutput();
        assertTrue(output.contains("绘制圆形"));
        assertTrue(output.contains("颜色：红色"));
        assertTrue(output.contains("X：10"));
        assertTrue(output.contains("Y：20"));
    }

    @Test
    @DisplayName("测试享元对象共享")
    void testFlyweightSharing() {
        // 获取多个相同类型的享元对象
        Shape circle1 = shapeFactory.getShape("圆形");
        Shape circle2 = shapeFactory.getShape("圆形");
        Shape circle3 = shapeFactory.getShape("圆形");
        
        // 验证所有对象都是同一个实例
        assertSame(circle1, circle2);
        assertSame(circle2, circle3);
        assertSame(circle1, circle3);
        
        // 使用不同的外部状态
        circle1.draw("红色", 10, 20);
        circle2.draw("蓝色", 30, 40);
        circle3.draw("绿色", 50, 60);
        
        String output = getConsoleOutput();
        
        // 验证所有操作都被执行
        assertTrue(output.contains("颜色：红色"));
        assertTrue(output.contains("颜色：蓝色"));
        assertTrue(output.contains("颜色：绿色"));
    }

    @Test
    @DisplayName("测试享元工厂缓存")
    void testFlyweightFactoryCache() {
        // 获取享元对象
        Shape circle1 = shapeFactory.getShape("圆形");
        Shape circle2 = shapeFactory.getShape("圆形");
        
        // 验证缓存机制
        assertSame(circle1, circle2);
        
        // 获取新对象
        Shape newCircle = shapeFactory.getShape("新圆形");
        
        // 验证新对象与原有对象不同
        assertNotSame(circle1, newCircle);
        
        // 再次获取新对象应该返回缓存的对象
        Shape newCircle2 = shapeFactory.getShape("新圆形");
        assertSame(newCircle, newCircle2);
    }

    @Test
    @DisplayName("测试内外状态分离")
    void testInternalExternalStateSeparation() {
        // 获取享元对象
        Shape circle = shapeFactory.getShape("圆形");
        
        // 使用不同的外部状态
        circle.draw("红色", 10, 20);
        clearConsoleOutput();
        
        circle.draw("蓝色", 30, 40);
        clearConsoleOutput();
        
        circle.draw("绿色", 50, 60);
        
        String output = getConsoleOutput();
        
        // 验证内部状态（形状类型）保持不变
        assertTrue(output.contains("绘制圆形"));
        
        // 验证外部状态可以变化
        assertTrue(output.contains("颜色：绿色"));
        assertTrue(output.contains("X：50"));
        assertTrue(output.contains("Y：60"));
    }

    @Test
    @DisplayName("测试享元对象数量限制")
    void testFlyweightObjectLimit() {
        // 获取大量享元对象
        Shape[] shapes = new Shape[100];
        
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = shapeFactory.getShape("圆形");
        }
        
        // 验证所有对象都是同一个实例
        for (int i = 1; i < shapes.length; i++) {
            assertSame(shapes[0], shapes[i]);
        }
    }

    @Test
    @DisplayName("测试享元模式性能")
    void testFlyweightPerformance() {
        // 测试享元模式的性能优势
        assertExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                Shape shape = shapeFactory.getShape("圆形");
                shape.draw("颜色" + i, i, i);
                clearConsoleOutput();
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试并发享元获取")
    void testConcurrentFlyweightRetrieval() throws InterruptedException {
        // 多线程测试享元对象获取
        Thread[] threads = new Thread[10];
        Shape[] shapes = new Shape[10];
        
        for (int i = 0; i < threads.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                shapes[index] = shapeFactory.getShape("圆形");
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
        
        // 验证所有线程获取的是同一个对象
        for (int i = 1; i < shapes.length; i++) {
            assertSame(shapes[0], shapes[i]);
        }
    }

    @Test
    @DisplayName("测试享元对象池管理")
    void testFlyweightPoolManagement() {
        // 创建多个享元对象
        Shape circle = shapeFactory.getShape("圆形");
        Shape square = shapeFactory.getShape("正方形");
        Shape triangle = shapeFactory.getShape("三角形");
        
        // 验证不同类型的对象是不同的
        assertNotSame(circle, square);
        assertNotSame(square, triangle);
        assertNotSame(circle, triangle);
        
        // 再次获取相同类型的对象
        Shape circle2 = shapeFactory.getShape("圆形");
        Shape square2 = shapeFactory.getShape("正方形");
        Shape triangle2 = shapeFactory.getShape("三角形");
        
        // 验证获取的是缓存的对象
        assertSame(circle, circle2);
        assertSame(square, square2);
        assertSame(triangle, triangle2);
    }

    @Test
    @DisplayName("测试享元模式内存效率")
    void testFlyweightMemoryEfficiency() {
        // 模拟大量对象创建的场景
        
        // 不使用享元模式（假设）
        // Shape[] manyShapes = new Shape[10000];
        // for (int i = 0; i < manyShapes.length; i++) {
        //     manyShapes[i] = new CircleShape();
        // }
        
        // 使用享元模式
        Shape[] sharedShapes = new Shape[10000];
        for (int i = 0; i < sharedShapes.length; i++) {
            sharedShapes[i] = shapeFactory.getShape("圆形");
        }
        
        // 验证所有对象都是同一个实例
        for (int i = 1; i < sharedShapes.length; i++) {
            assertSame(sharedShapes[0], sharedShapes[i]);
        }
        
        // 这大大减少了内存使用
    }

    @Test
    @DisplayName("测试享元模式扩展性")
    void testFlyweightExtensibility() {
        // 创建新的享元对象类型
        class StarShape implements Shape {
            @Override
            public void draw(String color, int x, int y) {
                System.out.println("绘制星形 - 颜色：" + color + "，X：" + x + "，Y：" + y);
            }
        }
        
        // 扩展工厂以支持新类型
        ShapeFactory extendedFactory = new ShapeFactory() {
            @Override
            public Shape getShape(String shapeType) {
                if ("星形".equals(shapeType)) {
                    return new StarShape();
                }
                return super.getShape(shapeType);
            }
        };
        
        // 使用新的享元类型
        Shape star = extendedFactory.getShape("星形");
        star.draw("黄色", 100, 200);
        
        String output = getConsoleOutput();
        assertTrue(output.contains("绘制星形"));
        assertTrue(output.contains("颜色：黄色"));
        assertTrue(output.contains("X：100"));
        assertTrue(output.contains("Y：200"));
    }

    @Test
    @DisplayName("测试享元模式边界条件")
    void testFlyweightEdgeCases() {
        // 测试null参数
        assertDoesNotThrow(() -> {
            Shape shape = shapeFactory.getShape(null);
            // 应该返回null或默认值
        });
        
        // 测试空字符串
        assertDoesNotThrow(() -> {
            Shape shape = shapeFactory.getShape("");
            // 应该返回null或默认值
        });
        
        // 测试不存在的类型
        assertDoesNotThrow(() -> {
            Shape shape = shapeFactory.getShape("不存在的形状");
            // 应该返回null或创建默认对象
        });
    }

    @Test
    @DisplayName("测试享元模式设计原则")
    void testFlyweightDesignPrinciples() {
        // 验证享元模式的设计原则
        
        // 1. 享元对象可共享
        Shape circle1 = shapeFactory.getShape("圆形");
        Shape circle2 = shapeFactory.getShape("圆形");
        assertSame(circle1, circle2);
        
        // 2. 内外状态分离
        circle1.draw("红色", 10, 20);
        String output = getConsoleOutput();
        assertTrue(output.contains("绘制圆形")); // 内部状态
        assertTrue(output.contains("颜色：红色")); // 外部状态
        
        // 3. 享元工厂管理共享对象
        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShape("圆形");
        Shape shape2 = factory.getShape("圆形");
        assertSame(shape1, shape2);
        
        // 4. 减少对象数量
        Shape[] shapes = new Shape[100];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = shapeFactory.getShape("圆形");
        }
        
        // 验证实际上只有一个对象
        for (int i = 1; i < shapes.length; i++) {
            assertSame(shapes[0], shapes[i]);
        }
    }
}