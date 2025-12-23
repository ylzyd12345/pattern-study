package com.kevin.demo.structural.decorator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 装饰器模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("装饰器模式测试")
class DecoratorPatternTest {

    @Test
    @DisplayName("测试基本电话功能")
    void testBasicPhoneCall() {
        PhoneCall phoneCall = new PhoneCall();
        
        assertNotNull(phoneCall, "普通电话实例不应该为null");
        assertInstanceOf(Call.class, phoneCall, "应该是Call类型");
        
        // 测试基本通话功能
        assertDoesNotThrow(() -> phoneCall.call("123456789"), 
                          "基本通话功能应该正常工作");
    }

    @Test
    @DisplayName("测试录音装饰器")
    void testRecordingDecorator() {
        PhoneCall phoneCall = new PhoneCall();
        RecordDecorator recordDecorator = new RecordDecorator(phoneCall);
        
        assertNotNull(recordDecorator, "录音装饰器实例不应该为null");
        assertInstanceOf(Call.class, recordDecorator, "应该是Call类型");
        assertInstanceOf(RecordDecorator.class, recordDecorator, "应该是RecordDecorator类型");
        
        // 测试录音通话功能
        assertDoesNotThrow(() -> recordDecorator.call("123456789"), 
                          "录音通话功能应该正常工作");
    }

    @Test
    @DisplayName("测试翻译装饰器")
    void testTranslateDecorator() {
        PhoneCall phoneCall = new PhoneCall();
        TranslateDecorator translateDecorator = new TranslateDecorator(phoneCall);
        
        assertNotNull(translateDecorator, "翻译装饰器实例不应该为null");
        assertInstanceOf(Call.class, translateDecorator, "应该是Call类型");
        assertInstanceOf(TranslateDecorator.class, translateDecorator, "应该是TranslateDecorator类型");
        
        // 测试翻译通话功能
        assertDoesNotThrow(() -> translateDecorator.call("123456789"), 
                          "翻译通话功能应该正常工作");
    }

    @Test
    @DisplayName("测试多层装饰器组合")
    void testMultipleDecoratorCombination() {
        PhoneCall phoneCall = new PhoneCall();
        
        // 先添加录音功能，再添加翻译功能
        Call decoratedCall = new TranslateDecorator(new RecordDecorator(phoneCall));
        
        assertNotNull(decoratedCall, "多层装饰器组合实例不应该为null");
        assertInstanceOf(Call.class, decoratedCall, "应该是Call类型");
        assertInstanceOf(TranslateDecorator.class, decoratedCall, "外层应该是TranslateDecorator");
        
        // 测试多层装饰的通话功能
        assertDoesNotThrow(() -> decoratedCall.call("123456789"), 
                          "多层装饰器组合的通话功能应该正常工作");
    }

    @Test
    @DisplayName("测试装饰器链的不同组合")
    void testDifferentDecoratorCombinations() {
        PhoneCall phoneCall = new PhoneCall();
        
        // 组合1：只有录音
        Call recordOnly = new RecordDecorator(phoneCall);
        
        // 组合2：只有翻译
        Call translateOnly = new TranslateDecorator(phoneCall);
        
        // 组合3：录音+翻译
        Call recordThenTranslate = new TranslateDecorator(new RecordDecorator(phoneCall));
        
        // 组合4：翻译+录音
        Call translateThenRecord = new RecordDecorator(new TranslateDecorator(phoneCall));
        
        // 测试所有组合都能正常工作
        assertDoesNotThrow(() -> recordOnly.call("111111111"), "录音功能应该正常");
        assertDoesNotThrow(() -> translateOnly.call("222222222"), "翻译功能应该正常");
        assertDoesNotThrow(() -> recordThenTranslate.call("333333333"), "录音+翻译功能应该正常");
        assertDoesNotThrow(() -> translateThenRecord.call("444444444"), "翻译+录音功能应该正常");
    }

    @Nested
    @DisplayName("装饰器特性测试")
    class DecoratorCharacteristicsTest {
        
        @Test
        @DisplayName("测试装饰器的透明性")
        void testDecoratorTransparency() {
            // 装饰器应该对客户端透明，客户端可以像使用原始对象一样使用装饰后的对象
            
            Call originalCall = new PhoneCall();
            Call decoratedCall = new RecordDecorator(new TranslateDecorator(originalCall));
            
            // 客户端代码不需要知道对象是否被装饰
            String phoneNumber = "123456789";
            
            // 两种调用方式应该都能正常工作
            assertDoesNotThrow(() -> originalCall.call(phoneNumber));
            assertDoesNotThrow(() -> decoratedCall.call(phoneNumber));
        }

        @Test
        @DisplayName("测试装饰器的动态性")
        void testDecoratorDynamism() {
            // 装饰器可以在运行时动态添加功能
            
            PhoneCall phoneCall = new PhoneCall();
            
            // 基本功能
            Call basicCall = phoneCall;
            assertDoesNotThrow(() -> basicCall.call("111111111"));
            
            // 动态添加录音功能
            Call callWithRecording = new RecordDecorator(phoneCall);
            assertDoesNotThrow(() -> callWithRecording.call("222222222"));
            
            // 动态添加翻译功能
            Call callWithTranslation = new TranslateDecorator(phoneCall);
            assertDoesNotThrow(() -> callWithTranslation.call("333333333"));
        }

        @Test
        @DisplayName("测试装饰器的嵌套性")
        void testDecoratorNesting() {
            // 装饰器可以嵌套使用
            
            PhoneCall phoneCall = new PhoneCall();
            
            // 创建多层嵌套装饰
            Call deeplyNested = new RecordDecorator(
                                    new TranslateDecorator(
                                        new RecordDecorator(
                                            new TranslateDecorator(phoneCall)
                                        )
                                    )
                                );
            
            assertNotNull(deeplyNested, "深层嵌套装饰器不应该为null");
            assertDoesNotThrow(() -> deeplyNested.call("123456789"), 
                              "深层嵌套装饰器应该正常工作");
        }
    }

    @Test
    @DisplayName("测试装饰器与继承的区别")
    void testDecoratorVsInheritance() {
        // 装饰器模式比继承更灵活，可以动态组合功能
        
        PhoneCall phoneCall = new PhoneCall();
        
        // 使用装饰器动态组合功能
        Call flexibleCombination = new RecordDecorator(phoneCall);
        flexibleCombination = new TranslateDecorator(flexibleCombination);
        
        // 这种组合在运行时决定，而不是在编译时
        assertNotNull(flexibleCombination, "动态组合的装饰器不应该为null");
        assertDoesNotThrow(() -> flexibleCombination.call("123456789"));
    }

    @Test
    @DisplayName("测试装饰器的类型安全")
    void testDecoratorTypeSafety() {
        // 装饰器应该保持类型安全
        
        PhoneCall phoneCall = new PhoneCall();
        Call decoratedCall = new RecordDecorator(phoneCall);
        
        // 装饰后的对象仍然实现原始接口
        assertTrue(decoratedCall instanceof Call, "装饰后的对象应该仍然实现Call接口");
        
        // 可以安全地转换为接口类型
        Call asCall = decoratedCall;
        assertNotNull(asCall, "转换为接口类型应该成功");
        assertDoesNotThrow(() -> asCall.call("123456789"));
    }

    @Test
    @DisplayName("测试装饰器的可扩展性")
    void testDecoratorExtensibility() {
        // 装饰器模式易于扩展，可以添加新的装饰器而不修改现有代码
        
        PhoneCall phoneCall = new PhoneCall();
        
        // 当前可用的装饰器
        Call[] availableDecorators = {
            new RecordDecorator(phoneCall),
            new TranslateDecorator(phoneCall),
            new TranslateDecorator(new RecordDecorator(phoneCall)),
            new RecordDecorator(new TranslateDecorator(phoneCall))
        };
        
        // 验证所有装饰器组合都能正常工作
        for (Call decorator : availableDecorators) {
            assertNotNull(decorator, "装饰器不应该为null");
            assertDoesNotThrow(() -> decorator.call("123456789"), 
                              "装饰器应该正常工作");
        }
    }

    @Nested
    @DisplayName("边界条件测试")
    class EdgeCaseTest {
        
        @Test
        @DisplayName("测试空电话号码")
        void testEmptyPhoneNumber() {
            PhoneCall phoneCall = new PhoneCall();
            RecordDecorator recordDecorator = new RecordDecorator(phoneCall);
            
            // 测试空电话号码的处理
            assertDoesNotThrow(() -> recordDecorator.call(""), 
                              "空电话号码应该被处理");
            assertDoesNotThrow(() -> recordDecorator.call(null), 
                              "null电话号码应该被处理");
        }

        @Test
        @DisplayName("测试特殊字符电话号码")
        void testSpecialCharacterPhoneNumber() {
            PhoneCall phoneCall = new PhoneCall();
            TranslateDecorator translateDecorator = new TranslateDecorator(phoneCall);
            
            // 测试包含特殊字符的电话号码
            String[] specialNumbers = {
                "+86-123-456-7890",
                "(123) 456-7890",
                "123.456.7890",
                "123 456 7890"
            };
            
            for (String number : specialNumbers) {
                assertDoesNotThrow(() -> translateDecorator.call(number), 
                                  "特殊字符电话号码应该被处理: " + number);
            }
        }
    }
}