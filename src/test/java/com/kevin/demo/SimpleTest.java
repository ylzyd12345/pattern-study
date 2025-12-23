package com.kevin.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 简单测试类用于验证测试环境
 */
class SimpleTest {

    @Test
    void testBasicAssertion() {
        assertEquals(2, 1 + 1, "基本数学运算应该正确");
    }

    @Test
    void testStringOperation() {
        String text = "Hello";
        assertNotNull(text, "字符串不应该为null");
        assertEquals("Hello", text, "字符串应该匹配");
    }

    @Test
    void testBooleanLogic() {
        assertTrue(5 > 3, "5应该大于3");
        assertFalse(3 > 5, "3不应该大于5");
    }
}