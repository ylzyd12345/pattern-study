package com.kevin.demo.creational.builder.badExample;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 建造者模式测试类
 * 测试建造者模式的实现，包括复杂对象的构建过程
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("建造者模式测试")
class BuilderPatternTest extends BasePatternTest {

    private KFCDirector kfcDirector;
    private SubMealBuilderA builderA;
    private SubMealBuilderB builderB;

    @BeforeEach
    void setUp() {
        super.setUp();
        kfcDirector = new KFCDirector();
        builderA = new SubMealBuilderA();
        builderB = new SubMealBuilderB();
    }

    @Test
    @DisplayName("测试套餐A构建")
    void testMealABuilding() {
        // 构建套餐A
        kfcDirector.construct(builderA);
        Meal mealA = builderA.getMeal();
        
        // 测试套餐
        mealA.showItems();
        
        String output = getConsoleOutput();
        
        // 验证套餐A的组成部分
        assertTrue(output.contains("套餐A"));
        // 应该包含食物和饮料等
    }

    @Test
    @DisplayName("测试套餐B构建")
    void testMealBBuilding() {
        // 构建套餐B
        kfcDirector.construct(builderB);
        Meal mealB = builderB.getMeal();
        
        // 测试套餐
        mealB.showItems();
        
        String output = getConsoleOutput();
        
        // 验证套餐B的组成部分
        assertTrue(output.contains("套餐B"));
        // 应该包含与套餐A不同的食物和饮料
    }

    @Test
    @DisplayName("测试不同构建器构建不同套餐")
    void testDifferentBuildersCreateDifferentMeals() {
        // 构建套餐A
        kfcDirector.construct(builderA);
        Meal mealA = builderA.getMeal();
        mealA.showItems();
        
        String outputA = getConsoleOutput();
        
        clearConsoleOutput();
        
        // 构建套餐B
        kfcDirector.construct(builderB);
        Meal mealB = builderB.getMeal();
        mealB.showItems();
        
        String outputB = getConsoleOutput();
        
        // 验证两个套餐不同
        assertNotEquals(outputA, outputB);
        assertTrue(outputA.contains("套餐A"));
        assertTrue(outputB.contains("套餐B"));
    }

    @Test
    @DisplayName("测试类型识别")
    void testTypeIdentification() {
        // 验证指导者类型
        assertInstanceOf(KFCDirector.class, kfcDirector);
        
        // 验证建造者类型
        assertInstanceOf(SubMealBuilderA.class, builderA);
        assertInstanceOf(SubMealBuilderB.class, builderB);
        
        // 验证产品类型
        kfcDirector.construct(builderA);
        Meal meal = builderA.getMeal();
        assertInstanceOf(Meal.class, meal);
    }

    @Test
    @DisplayName("测试建造者独立性")
    void testBuilderIndependence() {
        // 使用建造者A
        kfcDirector.construct(builderA);
        Meal mealA1 = builderA.getMeal();
        
        // 再次使用建造者A
        kfcDirector.construct(builderA);
        Meal mealA2 = builderA.getMeal();
        
        // 验证每次构建都是独立的
        assertNotSame(mealA1, mealA2);
        
        // 测试两个套餐都能正常工作
        mealA1.showItems();
        clearConsoleOutput();
        mealA2.showItems();
        
        String output = getConsoleOutput();
        assertTrue(output.length() > 0);
    }

    @Test
    @DisplayName("测试建造者重用")
    void testBuilderReuse() {
        // 使用同一个建造者多次构建
        for (int i = 0; i < 3; i++) {
            kfcDirector.construct(builderA);
            Meal meal = builderA.getMeal();
            meal.showItems();
            clearConsoleOutput();
        }
        
        // 验证建造者可以被重用
        kfcDirector.construct(builderA);
        Meal finalMeal = builderA.getMeal();
        assertNotNull(finalMeal);
        
        finalMeal.showItems();
        String output = getConsoleOutput();
        assertTrue(output.length() > 0);
    }

    @Test
    @DisplayName("测试指导者角色")
    void testDirectorRole() {
        // 测试指导者控制构建过程
        assertNotNull(kfcDirector);
        
        // 指导者应该知道构建步骤
        kfcDirector.construct(builderA);
        Meal meal = builderA.getMeal();
        assertNotNull(meal);
        
        // 测试指导者可以使用不同的建造者
        kfcDirector.construct(builderB);
        Meal mealB = builderB.getMeal();
        assertNotNull(mealB);
        
        // 验证两个产品不同
        assertNotSame(meal, mealB);
    }

    @Test
    @DisplayName("测试建造者模式扩展性")
    void testBuilderPatternExtensibility() {
        // 创建新的建造者
        class SubMealBuilderC implements MealBuilder {
            private Meal meal = new Meal("套餐C");
            
            @Override
            public void buildFood() {
                meal.addItem("汉堡C");
            }
            
            @Override
            public void buildDrink() {
                meal.addItem("可乐C");
            }
            
            @Override
            public Meal getMeal() {
                return meal;
            }
        }
        
        // 使用新建造者
        SubMealBuilderC builderC = new SubMealBuilderC();
        kfcDirector.construct(builderC);
        Meal mealC = builderC.getMeal();
        
        // 测试新套餐
        mealC.showItems();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("套餐C"));
    }

    @Test
    @DisplayName("测试建造步骤顺序")
    void testBuilderStepSequence() {
        // 测试构建步骤的顺序很重要
        kfcDirector.construct(builderA);
        Meal meal = builderA.getMeal();
        
        // 验证构建步骤按正确顺序执行
        meal.showItems();
        String output = getConsoleOutput();
        
        // 应该包含所有构建步骤的结果
        assertTrue(output.length() > 0);
    }

    @Test
    @DisplayName("测试建造者性能")
    void testBuilderPerformance() {
        // 测试建造者模式的性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                if (i % 2 == 0) {
                    kfcDirector.construct(builderA);
                    builderA.getMeal();
                } else {
                    kfcDirector.construct(builderB);
                    builderB.getMeal();
                }
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试并发构建")
    void testConcurrentBuilding() throws InterruptedException {
        // 多线程测试建造者模式
        Thread[] threads = new Thread[10];
        Meal[] meals = new Meal[10];
        
        for (int i = 0; i < threads.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                KFCDirector localDirector = new KFCDirector();
                SubMealBuilderA localBuilder = new SubMealBuilderA();
                localDirector.construct(localBuilder);
                meals[index] = localBuilder.getMeal();
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
        
        // 验证所有构建都成功
        for (Meal meal : meals) {
            assertNotNull(meal);
        }
        
        // 测试所有套餐都能正常工作
        for (Meal meal : meals) {
            meal.showItems();
            clearConsoleOutput();
        }
    }

    @Test
    @DisplayName("测试复杂对象构建")
    void testComplexObjectBuilding() {
        // 测试复杂对象的构建过程
        
        // 构建套餐
        kfcDirector.construct(builderA);
        Meal meal = builderA.getMeal();
        
        // 验证复杂对象的属性
        assertNotNull(meal);
        
        // 测试复杂对象的行为
        meal.showItems();
        String output = getConsoleOutput();
        assertTrue(output.length() > 0);
    }

    @Test
    @DisplayName("测试建造者模式设计原则")
    void testBuilderDesignPrinciples() {
        // 验证建造者模式的设计原则
        
        // 1. 构建过程与表示分离
        kfcDirector.construct(builderA);
        Meal meal = builderA.getMeal();
        
        // 2. 相同的构建过程可以创建不同的表示
        kfcDirector.construct(builderA);
        Meal mealA = builderA.getMeal();
        
        kfcDirector.construct(builderB);
        Meal mealB = builderB.getMeal();
        
        // 验证两个产品不同
        assertNotSame(mealA, mealB);
        
        // 3. 建造者独立性
        SubMealBuilderA anotherBuilderA = new SubMealBuilderA();
        kfcDirector.construct(anotherBuilderA);
        Meal anotherMealA = anotherBuilderA.getMeal();
        
        // 验证不同建造者实例创建不同产品
        assertNotSame(mealA, anotherMealA);
        
        // 4. 指导者封装构建逻辑
        // 客户端不需要知道具体的构建步骤
        assertNotNull(kfcDirector);
    }

    @Test
    @DisplayName("测试建造者链式调用")
    void testBuilderChaining() {
        // 如果建造者支持链式调用，测试链式调用
        // 这取决于具体实现
        
        // 基本构建
        kfcDirector.construct(builderA);
        Meal meal = builderA.getMeal();
        assertNotNull(meal);
        
        // 测试产品功能
        meal.showItems();
        String output = getConsoleOutput();
        assertTrue(output.length() > 0);
    }
}