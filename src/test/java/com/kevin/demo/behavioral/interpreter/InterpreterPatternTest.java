package com.kevin.demo.behavioral.interpreter;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 解释器模式测试类
 * 测试解释器模式的实现，包括表达式的解析和执行
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("解释器模式测试")
class InterpreterPatternTest extends BasePatternTest {

    private Context context;

    @BeforeEach
    void setUp() {
        super.setUp();
        context = new Context();
    }

    @Test
    @DisplayName("测试常量表达式")
    void testConstantExpression() {
        // 测试true常量
        Expression trueConstant = new Constant(true);
        assertTrue(trueConstant.interpret(context));
        
        // 测试false常量
        Expression falseConstant = new Constant(false);
        assertFalse(falseConstant.interpret(context));
    }

    @Test
    @DisplayName("测试变量表达式")
    void testVariableExpression() {
        // 创建变量
        Expression variable = new Variable("x");
        
        // 设置变量值
        context.assign("x", true);
        assertTrue(variable.interpret(context));
        
        // 更改变量值
        context.assign("x", false);
        assertFalse(variable.interpret(context));
    }

    @Test
    @DisplayName("测试AND表达式")
    void testAndExpression() {
        // 创建AND表达式: true AND true
        Expression andExpr1 = new And(new Constant(true), new Constant(true));
        assertTrue(andExpr1.interpret(context));
        
        // 创建AND表达式: true AND false
        Expression andExpr2 = new And(new Constant(true), new Constant(false));
        assertFalse(andExpr2.interpret(context));
        
        // 创建AND表达式: false AND true
        Expression andExpr3 = new And(new Constant(false), new Constant(true));
        assertFalse(andExpr3.interpret(context));
        
        // 创建AND表达式: false AND false
        Expression andExpr4 = new And(new Constant(false), new Constant(false));
        assertFalse(andExpr4.interpret(context));
    }

    @Test
    @DisplayName("测试OR表达式")
    void testOrExpression() {
        // 创建OR表达式: true OR true
        Expression orExpr1 = new Or(new Constant(true), new Constant(true));
        assertTrue(orExpr1.interpret(context));
        
        // 创建OR表达式: true OR false
        Expression orExpr2 = new Or(new Constant(true), new Constant(false));
        assertTrue(orExpr2.interpret(context));
        
        // 创建OR表达式: false OR true
        Expression orExpr3 = new Or(new Constant(false), new Constant(true));
        assertTrue(orExpr3.interpret(context));
        
        // 创建OR表达式: false OR false
        Expression orExpr4 = new Or(new Constant(false), new Constant(false));
        assertFalse(orExpr4.interpret(context));
    }

    @Test
    @DisplayName("测试NOT表达式")
    void testNotExpression() {
        // 创建NOT表达式: NOT true
        Expression notExpr1 = new Not(new Constant(true));
        assertFalse(notExpr1.interpret(context));
        
        // 创建NOT表达式: NOT false
        Expression notExpr2 = new Not(new Constant(false));
        assertTrue(notExpr2.interpret(context));
    }

    @Test
    @DisplayName("测试复杂表达式")
    void testComplexExpression() {
        // 设置变量值
        context.assign("x", true);
        context.assign("y", false);
        context.assign("z", true);
        
        // 创建复杂表达式: (x AND y) OR (NOT z)
        Expression complexExpr = new Or(
            new And(new Variable("x"), new Variable("y")),
            new Not(new Variable("z"))
        );
        
        // (true AND false) OR (NOT true) = false OR false = false
        assertFalse(complexExpr.interpret(context));
        
        // 更改变量值
        context.assign("y", true);
        
        // (true AND true) OR (NOT true) = true OR false = true
        assertTrue(complexExpr.interpret(context));
    }

    @Test
    @DisplayName("测试嵌套表达式")
    void testNestedExpression() {
        // 设置变量值
        context.assign("a", true);
        context.assign("b", true);
        context.assign("c", false);
        
        // 创建嵌套表达式: NOT (a AND (b OR c))
        Expression nestedExpr = new Not(
            new And(
                new Variable("a"),
                new Or(new Variable("b"), new Variable("c"))
            )
        );
        
        // NOT (true AND (true OR false)) = NOT (true AND true) = NOT true = false
        assertFalse(nestedExpr.interpret(context));
        
        // 更改变量值
        context.assign("a", false);
        
        // NOT (false AND (true OR false)) = NOT (false AND true) = NOT false = true
        assertTrue(nestedExpr.interpret(context));
    }

    @Test
    @DisplayName("测试上下文变量管理")
    void testContextVariableManagement() {
        // 测试变量赋值和获取
        context.assign("var1", true);
        context.assign("var2", false);
        
        assertTrue(context.lookup("var1"));
        assertFalse(context.lookup("var2"));
        
        // 测试变量覆盖
        context.assign("var1", false);
        assertFalse(context.lookup("var1"));
    }

    @Test
    @DisplayName("测试未定义变量")
    void testUndefinedVariable() {
        // 创建未定义的变量
        Expression undefinedVar = new Variable("undefined");
        
        // 解释未定义变量应该抛出异常或返回默认值
        assertThrows(RuntimeException.class, () -> {
            undefinedVar.interpret(context);
        });
    }

    @Test
    @DisplayName("测试表达式类型识别")
    void testExpressionTypeIdentification() {
        Expression constant = new Constant(true);
        Expression variable = new Variable("x");
        Expression and = new And(constant, variable);
        Expression or = new Or(constant, variable);
        Expression not = new Not(variable);
        
        // 验证表达式类型
        assertInstanceOf(Constant.class, constant);
        assertInstanceOf(Variable.class, variable);
        assertInstanceOf(And.class, and);
        assertInstanceOf(Or.class, or);
        assertInstanceOf(Not.class, not);
        
        // 验证继承关系
        assertTrue(constant instanceof Expression);
        assertTrue(variable instanceof Expression);
        assertTrue(and instanceof Expression);
        assertTrue(or instanceof Expression);
        assertTrue(not instanceof Expression);
    }

    @Test
    @DisplayName("测试表达式性能")
    void testExpressionPerformance() {
        // 创建复杂表达式
        Expression expr = new And(
            new Or(new Constant(true), new Variable("x")),
            new Not(new And(new Variable("y"), new Variable("z")))
        );
        
        // 设置变量值
        context.assign("x", false);
        context.assign("y", true);
        context.assign("z", false);
        
        // 测试性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                expr.interpret(context);
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试德摩根定律")
    void testDeMorgansLaws() {
        // 设置变量值
        context.assign("a", true);
        context.assign("b", false);
        
        // 德摩根定律1: NOT (a AND b) = (NOT a) OR (NOT b)
        Expression leftSide1 = new Not(new And(new Variable("a"), new Variable("b")));
        Expression rightSide1 = new Or(new Not(new Variable("a")), new Not(new Variable("b")));
        
        assertEquals(leftSide1.interpret(context), rightSide1.interpret(context));
        
        // 德摩根定律2: NOT (a OR b) = (NOT a) AND (NOT b)
        Expression leftSide2 = new Not(new Or(new Variable("a"), new Variable("b")));
        Expression rightSide2 = new And(new Not(new Variable("a")), new Not(new Variable("b")));
        
        assertEquals(leftSide2.interpret(context), rightSide2.interpret(context));
    }

    @Test
    @DisplayName("测试表达式等价性")
    void testExpressionEquivalence() {
        // 设置变量值
        context.assign("x", true);
        context.assign("y", false);
        
        // 创建等价的表达式: (x AND y) OR (x AND NOT y) = x
        Expression expr1 = new Or(
            new And(new Variable("x"), new Variable("y")),
            new And(new Variable("x"), new Not(new Variable("y")))
        );
        Expression expr2 = new Variable("x");
        
        assertEquals(expr1.interpret(context), expr2.interpret(context));
        
        // 测试不同的变量值
        context.assign("x", false);
        context.assign("y", true);
        
        assertEquals(expr1.interpret(context), expr2.interpret(context));
    }
}