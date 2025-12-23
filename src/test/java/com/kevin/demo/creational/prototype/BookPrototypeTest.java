package com.kevin.demo.creational.prototype;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 原型模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("原型模式测试")
class BookPrototypeTest extends BasePatternTest {

    @Test
    @DisplayName("测试原型模式创建基本Book对象")
    void testPrototypePatternBasicBookCreation() {
        Book originalBook = new Book("Java设计模式", "Kevin", 59.9);
        
        assertNotNull(originalBook, "原始Book对象不应该为null");
        assertEquals("Java设计模式", originalBook.getName(), "书名应该正确");
        assertEquals("Kevin", originalBook.getAuthor(), "作者应该正确");
        assertEquals(59.9, originalBook.getMoney(), 0.01, "价格应该正确");
    }

    @Test
    @DisplayName("测试浅拷贝功能")
    void testShallowCopy() {
        Book originalBook = new Book("Java设计模式", "Kevin", 59.9);
        Book clonedBook = originalBook.clone();
        
        assertNotNull(clonedBook, "克隆的Book对象不应该为null");
        assertNotSame(originalBook, clonedBook, "克隆对象应该是不同的实例");
        
        // 验证基本属性是否正确复制
        assertEquals(originalBook.getName(), clonedBook.getName(), "书名应该被正确复制");
        assertEquals(originalBook.getAuthor(), clonedBook.getAuthor(), "作者应该被正确复制");
        assertEquals(originalBook.getMoney(), clonedBook.getMoney(), 0.01, "价格应该被正确复制");
        
        // 验证toString方法
        assertEquals(originalBook.toString(), clonedBook.toString(), "toString结果应该相同");
    }

    @Test
    @DisplayName("测试深拷贝功能")
    void testDeepCopy() {
        Book originalBook = new Book("Java设计模式", "Kevin", 59.9);
        Book deepClonedBook = originalBook.deepClone();
        
        assertNotNull(deepClonedBook, "深拷贝的Book对象不应该为null");
        assertNotSame(originalBook, deepClonedBook, "深拷贝对象应该是不同的实例");
        
        // 验证基本属性是否正确复制
        assertEquals(originalBook.getName(), deepClonedBook.getName(), "书名应该被正确复制");
        assertEquals(originalBook.getAuthor(), deepClonedBook.getAuthor(), "作者应该被正确复制");
        assertEquals(originalBook.getMoney(), deepClonedBook.getMoney(), 0.01, "价格应该被正确复制");
        
        // 验证toString方法
        assertEquals(originalBook.toString(), deepClonedBook.toString(), "toString结果应该相同");
    }

    @Test
    @DisplayName("测试浅拷贝与深拷贝的区别")
    void testShallowVsDeepCopyDifference() {
        Book originalBook = new Book("Java设计模式", "Kevin", 59.9);
        
        Book shallowCopy = originalBook.clone();
        Book deepCopy = originalBook.deepClone();
        
        // 修改原始对象的属性
        originalBook.setName("修改后的书名");
        originalBook.setAuthor("修改后的作者");
        originalBook.setMoney(99.9);
        
        // 验证浅拷贝不受影响（因为String是不可变对象）
        assertNotEquals(originalBook.getName(), shallowCopy.getName(), "浅拷贝的书名应该不受影响");
        assertNotEquals(originalBook.getAuthor(), shallowCopy.getAuthor(), "浅拷贝的作者应该不受影响");
        assertNotEquals(originalBook.getMoney(), shallowCopy.getMoney(), 0.01, "浅拷贝的价格应该不受影响");
        
        // 验证深拷贝不受影响
        assertNotEquals(originalBook.getName(), deepCopy.getName(), "深拷贝的书名应该不受影响");
        assertNotEquals(originalBook.getAuthor(), deepCopy.getAuthor(), "深拷贝的作者应该不受影响");
        assertNotEquals(originalBook.getMoney(), deepCopy.getMoney(), 0.01, "深拷贝的价格应该不受影响");
    }

    @Nested
    @DisplayName("原型模式性能测试")
    class PrototypePatternPerformanceTest {
        
        @Test
        @DisplayName("测试浅拷贝性能")
        void testShallowCopyPerformance() {
            Book originalBook = new Book("性能测试", "Kevin", 59.9);
            
            assertExecutionTime(() -> {
                for (int i = 0; i < 10000; i++) {
                    Book clonedBook = originalBook.clone();
                    assertNotNull(clonedBook, "克隆对象不应该为null");
                }
            }, 1000); // 期望在1秒内完成10000次浅拷贝
        }

        @Test
        @DisplayName("测试深拷贝性能")
        void testDeepCopyPerformance() {
            Book originalBook = new Book("性能测试", "Kevin", 59.9);
            
            assertExecutionTime(() -> {
                for (int i = 0; i < 1000; i++) {
                    Book deepClonedBook = originalBook.deepClone();
                    assertNotNull(deepClonedBook, "深拷贝对象不应该为null");
                }
            }, 2000); // 期望在2秒内完成1000次深拷贝（深拷贝较慢）
        }

        @Test
        @DisplayName("比较浅拷贝和深拷贝的性能差异")
        void testShallowVsDeepCopyPerformanceDifference() {
            Book originalBook = new Book("性能比较", "Kevin", 59.9);
            
            // 测试浅拷贝时间
            long shallowStartTime = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                originalBook.clone();
            }
            long shallowEndTime = System.nanoTime();
            long shallowTime = shallowEndTime - shallowStartTime;
            
            // 测试深拷贝时间
            long deepStartTime = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                originalBook.deepClone();
            }
            long deepEndTime = System.nanoTime();
            long deepTime = deepEndTime - deepStartTime;
            
            // 验证浅拷贝比深拷贝快
            assertTrue(shallowTime < deepTime, 
                      "浅拷贝应该比深拷贝快。浅拷贝: " + shallowTime + "ns, 深拷贝: " + deepTime + "ns");
        }
    }

    @Test
    @DisplayName("测试原型模式的批量复制")
    void testPrototypePatternBatchCopying() {
        Book originalBook = new Book("批量复制测试", "Kevin", 59.9);
        
        // 批量浅拷贝
        Book[] shallowCopies = new Book[100];
        for (int i = 0; i < 100; i++) {
            shallowCopies[i] = originalBook.clone();
            assertNotNull(shallowCopies[i], "第" + i + "个浅拷贝对象不应该为null");
            assertEquals(originalBook.getName(), shallowCopies[i].getName(), "浅拷贝书名应该正确");
            assertEquals(originalBook.getAuthor(), shallowCopies[i].getAuthor(), "浅拷贝作者应该正确");
        }
        
        // 批量深拷贝
        Book[] deepCopies = new Book[100];
        for (int i = 0; i < 100; i++) {
            deepCopies[i] = originalBook.deepClone();
            assertNotNull(deepCopies[i], "第" + i + "个深拷贝对象不应该为null");
            assertEquals(originalBook.getName(), deepCopies[i].getName(), "深拷贝书名应该正确");
            assertEquals(originalBook.getAuthor(), deepCopies[i].getAuthor(), "深拷贝作者应该正确");
        }
    }

    @Test
    @DisplayName("测试原型模式的线程安全性")
    void testPrototypePatternThreadSafety() throws InterruptedException {
        Book originalBook = new Book("线程安全测试", "Kevin", 59.9);
        
        final int threadCount = 100;
        final Book[] shallowCopies = new Book[threadCount];
        final Book[] deepCopies = new Book[threadCount];
        final Thread[] threads = new Thread[threadCount];
        
        // 创建多个线程同时进行浅拷贝和深拷贝
        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                shallowCopies[index] = originalBook.clone();
                deepCopies[index] = originalBook.deepClone();
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
        
        // 验证所有拷贝都成功
        for (int i = 0; i < threadCount; i++) {
            assertNotNull(shallowCopies[i], "第" + i + "个浅拷贝对象不应该为null");
            assertNotNull(deepCopies[i], "第" + i + "个深拷贝对象不应该为null");
            
            assertEquals(originalBook.getName(), shallowCopies[i].getName(), "浅拷贝书名应该正确");
            assertEquals(originalBook.getName(), deepCopies[i].getName(), "深拷贝书名应该正确");
        }
    }

    @Test
    @DisplayName("测试原型模式的边界条件")
    void testPrototypePatternBoundaryConditions() {
        // 测试空字符串
        Book bookWithEmptyName = new Book("");
        assertNotNull(bookWithEmptyName.clone(), "空书名的对象应该能被克隆");
        assertNotNull(bookWithEmptyName.deepClone(), "空书名的对象应该能被深拷贝");
        
        // 测试特殊字符
        Book bookWithSpecialChars = new Book("特殊字符测试!@#$%^&*()", "特殊作者!@#$%^&*()", 0.0);
        Book clonedSpecialChars = bookWithSpecialChars.clone();
        assertEquals(bookWithSpecialChars.getName(), clonedSpecialChars.getName(), "特殊字符应该被正确复制");
        
        // 测试极大值
        Book bookWithLargeValue = new Book("极大值测试", "极大值作者", Double.MAX_VALUE);
        Book clonedLargeValue = bookWithLargeValue.clone();
        assertEquals(bookWithLargeValue.getMoney(), clonedLargeValue.getMoney(), 0.01, "极大值应该被正确复制");
    }

    @Test
    @DisplayName("测试原型模式的内存效率")
    void testPrototypePatternMemoryEfficiency() {
        Runtime runtime = Runtime.getRuntime();
        
        // 记录创建前的内存使用
        runtime.gc(); // 建议垃圾回收
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        // 使用原型模式创建多个对象
        Book originalBook = new Book("内存效率测试", "Kevin", 59.9);
        Book[] books = new Book[1000];
        
        for (int i = 0; i < 1000; i++) {
            books[i] = originalBook.clone();
        }
        
        // 记录创建后的内存使用
        runtime.gc(); // 建议垃圾回收
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        
        // 验证内存使用合理
        long memoryUsed = memoryAfter - memoryBefore;
        assertTrue(memoryUsed < 50 * 1024 * 1024, // 50MB
                  "1000个对象的内存占用应该小于50MB，实际: " + memoryUsed / 1024 / 1024 + "MB");
    }

    @Test
    @DisplayName("测试原型模式控制台输出")
    void testPrototypePatternConsoleOutput() {
        Book originalBook = new Book("控制台测试", "Kevin", 59.9);
        
        // 清空控制台输出
        clearConsoleOutput();
        
        // 创建拷贝并输出
        Book clonedBook = originalBook.clone();
        System.out.println("原始对象: " + originalBook);
        System.out.println("克隆对象: " + clonedBook);
        
        // 验证控制台输出
        assertConsoleOutputContains("原始对象:");
        assertConsoleOutputContains("克隆对象:");
        assertConsoleOutputContains("控制台测试");
    }

    @Test
    @DisplayName("测试原型模式的equals和hashCode")
    void testPrototypePatternEqualsAndHashCode() {
        Book originalBook = new Book("equals测试", "Kevin", 59.9);
        Book clonedBook = originalBook.clone();
        Book deepClonedBook = originalBook.deepClone();
        
        // 测试equals方法（如果没有重写，使用Object的equals）
        assertEquals(originalBook.equals(clonedBook), clonedBook.equals(originalBook), 
                    "equals方法应该是对称的");
        
        // 测试hashCode一致性
        assertEquals(originalBook.hashCode(), clonedBook.hashCode(), 
                    "相同内容的对象hashCode应该相同");
        assertEquals(originalBook.hashCode(), deepClonedBook.hashCode(), 
                    "相同内容的对象hashCode应该相同");
        
        // 测试toString一致性
        assertEquals(originalBook.toString(), clonedBook.toString(), 
                    "相同内容的对象toString应该相同");
        assertEquals(originalBook.toString(), deepClonedBook.toString(), 
                    "相同内容的对象toString应该相同");
    }
}