package com.kevin.demo.creational.builder.goodExample;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 建造者模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("建造者模式测试")
class PersonBuilderTest extends BasePatternTest {

    @Test
    @DisplayName("测试建造者模式创建基本Person对象")
    void testBuilderPatternBasicPersonCreation() {
        Person person = new Person.PersonBuilder("张三")
                .withHear(HearTypeEnum.LONG_HAIR)
                .withColor(ColorTypeEnum.WHITE)
                .withClothes(ClothesTypeEnum.T_SHIRT)
                .build();
        
        assertNotNull(person, "创建的Person对象不应该为null");
        assertEquals("张三", getPersonName(person), "姓名应该正确");
        assertEquals(HearTypeEnum.LONG_HAIR, getPersonHearType(person), "发型应该正确");
        assertEquals(ColorTypeEnum.WHITE, getPersonColorType(person), "肤色应该正确");
        assertEquals(ClothesTypeEnum.T_SHIRT, getPersonClothesType(person), "服装应该正确");
    }

    @Test
    @DisplayName("测试建造者模式的链式调用")
    void testBuilderPatternChaining() {
        // 测试建造者模式的链式调用特性
        Person person = new Person.PersonBuilder("李四")
                .withHear(HearTypeEnum.SHORT_HAIR)
                .withColor(ColorTypeEnum.YELLOW)
                .withClothes(ClothesTypeEnum.SUIT)
                .build();
        
        assertNotNull(person, "链式调用创建的Person对象不应该为null");
        assertEquals("李四", getPersonName(person), "姓名应该正确");
        assertEquals(HearTypeEnum.SHORT_HAIR, getPersonHearType(person), "发型应该正确");
        assertEquals(ColorTypeEnum.YELLOW, getPersonColorType(person), "肤色应该正确");
        assertEquals(ClothesTypeEnum.SUIT, getPersonClothesType(person), "服装应该正确");
    }

    @Test
    @DisplayName("测试建造者模式创建最小配置对象")
    void testBuilderPatternMinimalConfiguration() {
        // 测试只提供必需参数的情况
        Person person = new Person.PersonBuilder("王五").build();
        
        assertNotNull(person, "最小配置创建的Person对象不应该为null");
        assertEquals("王五", getPersonName(person), "姓名应该正确");
        // 其他属性可能是null或默认值
    }

    @Test
    @DisplayName("测试建造者模式的不可变性")
    void testBuilderPatternImmutability() {
        // 建造者模式通常创建不可变对象
        Person person = new Person.PersonBuilder("赵六")
                .withHear(HearTypeEnum.LONG_HAIR)
                .withColor(ColorTypeEnum.BLACK)
                .withClothes(ClothesTypeEnum.DRESS)
                .build();
        
        // 验证对象的不可变性（通过toString验证对象状态）
        String originalToString = person.toString();
        
        // 尝试多次获取相同的属性值
        String name1 = getPersonName(person);
        String name2 = getPersonName(person);
        assertEquals(name1, name2, "对象属性应该是不可变的");
        
        // 验证toString的一致性
        assertEquals(originalToString, person.toString(), "对象状态应该保持一致");
    }

    @Nested
    @DisplayName("建造者模式灵活性测试")
    class BuilderPatternFlexibilityTest {
        
        @Test
        @DisplayName("测试不同参数组合")
        void testDifferentParameterCombinations() {
            // 测试不同的参数组合
            
            // 只有姓名
            Person person1 = new Person.PersonBuilder("用户1").build();
            assertEquals("用户1", getPersonName(person1));
            
            // 姓名和发型
            Person person2 = new Person.PersonBuilder("用户2")
                    .withHear(HearTypeEnum.SHORT_HAIR)
                    .build();
            assertEquals("用户2", getPersonName(person2));
            assertEquals(HearTypeEnum.SHORT_HAIR, getPersonHearType(person2));
            
            // 所有参数
            Person person3 = new Person.PersonBuilder("用户3")
                    .withHear(HearTypeEnum.LONG_HAIR)
                    .withColor(ColorTypeEnum.WHITE)
                    .withClothes(ClothesTypeEnum.T_SHIRT)
                    .build();
            assertEquals("用户3", getPersonName(person3));
            assertEquals(HearTypeEnum.LONG_HAIR, getPersonHearType(person3));
            assertEquals(ColorTypeEnum.WHITE, getPersonColorType(person3));
            assertEquals(ClothesTypeEnum.T_SHIRT, getPersonClothesType(person3));
        }

        @Test
        @DisplayName("测试建造者参数验证")
        void testBuilderParameterValidation() {
            // 测试建造者对参数的验证
            
            // 测试null姓名（如果建造者有验证逻辑）
            assertThrows(Exception.class, () -> {
                new Person.PersonBuilder(null).build();
            }, "null姓名应该抛出异常");
            
            // 测试空姓名（如果建造者有验证逻辑）
            assertThrows(Exception.class, () -> {
                new Person.PersonBuilder("").build();
            }, "空姓名应该抛出异常");
        }
    }

    @Test
    @DisplayName("测试建造者模式的重用性")
    void testBuilderPatternReusability() {
        // 测试建造者对象的重用性
        
        Person.PersonBuilder builder = new Person.PersonBuilder("基础用户")
                .withHear(HearTypeEnum.SHORT_HAIR)
                .withColor(ColorTypeEnum.YELLOW);
        
        // 使用相同的建造者创建多个对象
        Person person1 = builder.withClothes(ClothesTypeEnum.T_SHIRT).build();
        Person person2 = builder.withClothes(ClothesTypeEnum.SUIT).build();
        
        assertNotNull(person1, "第一个Person对象不应该为null");
        assertNotNull(person2, "第二个Person对象不应该为null");
        
        assertEquals("基础用户", getPersonName(person1));
        assertEquals("基础用户", getPersonName(person2));
        
        assertEquals(HearTypeEnum.SHORT_HAIR, getPersonHearType(person1));
        assertEquals(HearTypeEnum.SHORT_HAIR, getPersonHearType(person2));
        
        assertEquals(ClothesTypeEnum.T_SHIRT, getPersonClothesType(person1));
        assertEquals(ClothesTypeEnum.SUIT, getPersonClothesType(person2));
    }

    @Test
    @DisplayName("测试建造者模式的扩展性")
    void testBuilderPatternExtensibility() {
        // 建造者模式的一个优势是易于扩展
        // 如果需要添加新的属性，只需要：
        // 1. 在Person类中添加新属性
        // 2. 在PersonBuilder中添加对应的with方法
        // 3. 在build方法中设置新属性
        
        Person person = new Person.PersonBuilder("扩展测试用户")
                .withHear(HearTypeEnum.LONG_HAIR)
                .withColor(ColorTypeEnum.BLACK)
                .withClothes(ClothesTypeEnum.DRESS)
                .build();
        
        assertNotNull(person, "扩展测试创建的Person对象不应该为null");
        assertEquals("扩展测试用户", getPersonName(person));
        
        // 验证所有现有属性仍然正常工作
        assertEquals(HearTypeEnum.LONG_HAIR, getPersonHearType(person));
        assertEquals(ColorTypeEnum.BLACK, getPersonColorType(person));
        assertEquals(ClothesTypeEnum.DRESS, getPersonClothesType(person));
    }

    @Test
    @DisplayName("测试建造者模式的性能")
    void testBuilderPatternPerformance() {
        // 测试建造者模式的性能
        
        assertExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                Person person = new Person.PersonBuilder("性能测试用户" + i)
                        .withHear(HearTypeEnum.SHORT_HAIR)
                        .withColor(ColorTypeEnum.YELLOW)
                        .withClothes(ClothesTypeEnum.T_SHIRT)
                        .build();
                
                assertNotNull(person, "创建的Person对象不应该为null");
            }
        }, 1000); // 期望在1秒内完成1000个对象的创建
    }

    @Test
    @DisplayName("测试建造者模式的线程安全性")
    void testBuilderPatternThreadSafety() throws InterruptedException {
        // 测试建造者模式的线程安全性
        
        final int threadCount = 100;
        final Person[] persons = new Person[threadCount];
        final Thread[] threads = new Thread[threadCount];
        
        // 创建多个线程同时使用建造者创建对象
        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                persons[index] = new Person.PersonBuilder("线程安全测试用户" + index)
                        .withHear(HearTypeEnum.LONG_HAIR)
                        .withColor(ColorTypeEnum.WHITE)
                        .withClothes(ClothesTypeEnum.SUIT)
                        .build();
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
        
        // 验证所有对象都创建成功
        for (int i = 0; i < threadCount; i++) {
            assertNotNull(persons[i], "第" + i + "个Person对象不应该为null");
            assertEquals("线程安全测试用户" + i, getPersonName(persons[i]));
            assertEquals(HearTypeEnum.LONG_HAIR, getPersonHearType(persons[i]));
            assertEquals(ColorTypeEnum.WHITE, getPersonColorType(persons[i]));
            assertEquals(ClothesTypeEnum.SUIT, getPersonClothesType(persons[i]));
        }
    }

    @Test
    @DisplayName("测试建造者模式的toString方法")
    void testBuilderPatternToString() {
        Person person = new Person.PersonBuilder("toString测试用户")
                .withHear(HearTypeEnum.SHORT_HAIR)
                .withColor(ColorTypeEnum.BLACK)
                .withClothes(ClothesTypeEnum.DRESS)
                .build();
        
        String toStringResult = person.toString();
        
        assertNotNull(toStringResult, "toString结果不应该为null");
        assertTrue(toStringResult.contains("toString测试用户"), "toString应该包含姓名");
        assertTrue(toStringResult.contains("SHORT_HAIR"), "toString应该包含发型");
        assertTrue(toStringResult.contains("BLACK"), "toString应该包含肤色");
        assertTrue(toStringResult.contains("DRESS"), "toString应该包含服装");
    }

    @Test
    @DisplayName("测试建造者模式控制台输出")
    void testBuilderPatternConsoleOutput() {
        // 清空控制台输出
        clearConsoleOutput();
        
        // 创建Person对象（如果构造函数有输出）
        Person person = new Person.PersonBuilder("控制台测试用户")
                .withHear(HearTypeEnum.LONG_HAIR)
                .withColor(ColorTypeEnum.WHITE)
                .withClothes(ClothesTypeEnum.T_SHIRT)
                .build();
        
        // 调用toString（可能有输出）
        String toStringResult = person.toString();
        System.out.println(toStringResult);
        
        // 验证控制台输出
        assertConsoleOutputContains("控制台测试用户");
    }

    // 辅助方法：通过反射获取Person对象的私有属性（用于测试）
    private String getPersonName(Person person) {
        try {
            java.lang.reflect.Field nameField = Person.class.getDeclaredField("name");
            nameField.setAccessible(true);
            return (String) nameField.get(person);
        } catch (Exception e) {
            return person.toString().split("name=")[1].split(",")[0];
        }
    }

    private HearTypeEnum getPersonHearType(Person person) {
        try {
            java.lang.reflect.Field hearTypeField = Person.class.getDeclaredField("hearType");
            hearTypeField.setAccessible(true);
            return (HearTypeEnum) hearTypeField.get(person);
        } catch (Exception e) {
            String toString = person.toString();
            if (toString.contains("hearType=")) {
                String hearTypeStr = toString.split("hearType=")[1].split(",")[0];
                return HearTypeEnum.valueOf(hearTypeStr);
            }
            return null;
        }
    }

    private ColorTypeEnum getPersonColorType(Person person) {
        try {
            java.lang.reflect.Field colorTypeField = Person.class.getDeclaredField("colorType");
            colorTypeField.setAccessible(true);
            return (ColorTypeEnum) colorTypeField.get(person);
        } catch (Exception e) {
            String toString = person.toString();
            if (toString.contains("colorType=")) {
                String colorTypeStr = toString.split("colorType=")[1].split(",")[0];
                return ColorTypeEnum.valueOf(colorTypeStr);
            }
            return null;
        }
    }

    private ClothesTypeEnum getPersonClothesType(Person person) {
        try {
            java.lang.reflect.Field clothesTypeField = Person.class.getDeclaredField("clothesType");
            clothesTypeField.setAccessible(true);
            return (ClothesTypeEnum) clothesTypeField.get(person);
        } catch (Exception e) {
            String toString = person.toString();
            if (toString.contains("clothesType=")) {
                String clothesTypeStr = toString.split("clothesType=")[1].split("]")[0];
                return ClothesTypeEnum.valueOf(clothesTypeStr);
            }
            return null;
        }
    }
}