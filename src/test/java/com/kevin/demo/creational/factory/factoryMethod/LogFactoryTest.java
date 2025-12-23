package com.kevin.demo.creational.factory.factoryMethod;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 工厂方法模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("工厂方法模式测试")
class LogFactoryTest extends BasePatternTest {

    @Test
    @DisplayName("测试数据库日志工厂创建数据库日志")
    void testDatabaseLogFactoryCreatesDatabaseLog() {
        LogFactory factory = new DatabaseLogFactory();
        Log log = factory.createLog();
        
        assertNotNull(log, "创建的日志不应该为null");
        assertInstanceOf(DatabaseLog.class, log, "应该是数据库日志类型");
        assertEquals("数据库日志记录: 测试消息", log.record("测试消息"), 
                    "数据库日志记录功能应该正常");
    }

    @Test
    @DisplayName("测试文件日志工厂创建文件日志")
    void testFileLogFactoryCreatesFileLog() {
        LogFactory factory = new FileLogFactory();
        Log log = factory.createLog();
        
        assertNotNull(log, "创建的日志不应该为null");
        assertInstanceOf(FileLog.class, log, "应该是文件日志类型");
        assertEquals("文件日志记录: 测试消息", log.record("测试消息"), 
                    "文件日志记录功能应该正常");
    }

    @Test
    @DisplayName("测试不同工厂创建不同类型的日志")
    void testDifferentFactoriesCreateDifferentLogTypes() {
        LogFactory dbFactory = new DatabaseLogFactory();
        LogFactory fileFactory = new FileLogFactory();
        
        Log dbLog = dbFactory.createLog();
        Log fileLog = fileFactory.createLog();
        
        assertNotNull(dbLog, "数据库日志不应该为null");
        assertNotNull(fileLog, "文件日志不应该为null");
        
        assertInstanceOf(DatabaseLog.class, dbLog, "应该是数据库日志");
        assertInstanceOf(FileLog.class, fileLog, "应该是文件日志");
        
        assertNotSame(dbLog, fileLog, "不同工厂创建的日志应该是不同的实例");
    }

    @Test
    @DisplayName("测试同一工厂多次创建日志")
    void testSameFactoryCreatesMultipleLogs() {
        LogFactory factory = new DatabaseLogFactory();
        
        Log log1 = factory.createLog();
        Log log2 = factory.createLog();
        
        assertNotNull(log1, "第一个日志不应该为null");
        assertNotNull(log2, "第二个日志不应该为null");
        
        // 工厂方法通常每次都创建新实例
        assertNotSame(log1, log2, "工厂应该创建不同的实例");
        assertEquals(log1.getClass(), log2.getClass(), "两个实例应该是相同类型");
    }

    @Nested
    @DisplayName("日志功能测试")
    class LogFunctionalityTest {
        
        @Test
        @DisplayName("测试数据库日志功能")
        void testDatabaseLogFunctionality() {
            LogFactory factory = new DatabaseLogFactory();
            Log log = factory.createLog();
            
            // 测试记录不同类型的消息
            String message1 = "用户登录";
            String message2 = "数据更新";
            String message3 = "系统错误";
            
            assertEquals("数据库日志记录: " + message1, log.record(message1));
            assertEquals("数据库日志记录: " + message2, log.record(message2));
            assertEquals("数据库日志记录: " + message3, log.record(message3));
        }

        @Test
        @DisplayName("测试文件日志功能")
        void testFileLogFunctionality() {
            LogFactory factory = new FileLogFactory();
            Log log = factory.createLog();
            
            // 测试记录不同类型的消息
            String message1 = "请求处理";
            String message2 = "响应发送";
            String message3 = "异常捕获";
            
            assertEquals("文件日志记录: " + message1, log.record(message1));
            assertEquals("文件日志记录: " + message2, log.record(message2));
            assertEquals("文件日志记录: " + message3, log.record(message3));
        }
    }

    @Test
    @DisplayName("测试工厂方法的解耦特性")
    void testFactoryMethodDecoupling() {
        // 工厂方法模式的核心优势：客户端代码与具体产品类解耦
        // 客户端只需要知道工厂接口和产品接口
        
        LogFactory factory = createLogFactory("database");
        Log log = factory.createLog();
        
        assertNotNull(log, "通过工厂创建的日志不应该为null");
        assertTrue(log.record("测试消息").contains("日志记录"), 
                  "日志应该能正常记录消息");
    }

    /**
     * 根据类型创建对应的日志工厂（模拟工厂选择逻辑）
     */
    private LogFactory createLogFactory(String type) {
        if ("database".equalsIgnoreCase(type)) {
            return new DatabaseLogFactory();
        } else if ("file".equalsIgnoreCase(type)) {
            return new FileLogFactory();
        }
        throw new IllegalArgumentException("不支持的日志类型: " + type);
    }

    @Test
    @DisplayName("测试工厂方法的多态性")
    void testFactoryMethodPolymorphism() {
        // 测试工厂方法的多态特性
        LogFactory[] factories = {
            new DatabaseLogFactory(),
            new FileLogFactory()
        };
        
        for (LogFactory factory : factories) {
            Log log = factory.createLog();
            assertNotNull(log, "工厂创建的日志不应该为null");
            
            String message = "多态测试消息";
            String result = log.record(message);
            assertNotNull(result, "日志记录结果不应该为null");
            assertTrue(result.contains(message), "日志结果应该包含原始消息");
        }
    }

    @Nested
    @DisplayName("工厂扩展性测试")
    class FactoryExtensibilityTest {
        
        @Test
        @DisplayName("测试工厂的可扩展性")
        void testFactoryExtensibility() {
            // 工厂方法模式的一个优势是易于扩展
            // 如果需要添加新的日志类型，只需要：
            // 1. 创建新的日志类实现Log接口
            // 2. 创建新的工厂类实现LogFactory接口
            // 3. 客户端代码无需修改
            
            // 当前支持的工厂类型
            LogFactory[] availableFactories = {
                new DatabaseLogFactory(),
                new FileLogFactory()
            };
            
            // 验证每种工厂都能正常创建日志
            for (LogFactory factory : availableFactories) {
                Log log = factory.createLog();
                assertNotNull(log, "工厂应该能创建日志实例");
                assertTrue(log instanceof Log, "创建的对象应该实现Log接口");
                
                String testMessage = "扩展性测试";
                String result = log.record(testMessage);
                assertNotNull(result, "日志记录应该返回结果");
                assertTrue(result.contains(testMessage), "结果应该包含测试消息");
            }
        }
    }

    @Test
    @DisplayName("测试工厂方法的延迟实例化")
    void testFactoryMethodLazyInstantiation() {
        // 工厂方法模式支持延迟实例化
        // 只有在调用createLog()方法时才创建具体的日志实例
        
        LogFactory factory = new DatabaseLogFactory();
        
        // 此时还没有创建具体的日志实例
        // 只有调用createLog()时才会创建
        Log log = factory.createLog();
        
        assertNotNull(log, "调用createLog()后应该创建日志实例");
        assertInstanceOf(DatabaseLog.class, log, "应该是数据库日志实例");
    }

    @Test
    @DisplayName("测试工厂方法的参数化创建")
    void testFactoryMethodParameterizedCreation() {
        // 虽然当前的工厂方法没有参数，但在实际应用中
        // 工厂方法可以接受参数来控制创建过程
        
        LogFactory factory = new DatabaseLogFactory();
        Log log = factory.createLog();
        
        // 测试不同消息的处理
        String[] messages = {
            "INFO: 系统启动",
            "WARN: 内存使用率高",
            "ERROR: 数据库连接失败"
        };
        
        for (String message : messages) {
            String result = log.record(message);
            assertNotNull(result, "日志记录不应该返回null");
            assertTrue(result.contains(message), "结果应该包含原始消息");
        }
    }

    @Test
    @DisplayName("测试工厂方法的一致性")
    void testFactoryMethodConsistency() {
        // 测试同一工厂创建的对象行为一致性
        
        LogFactory factory = new FileLogFactory();
        Log log1 = factory.createLog();
        Log log2 = factory.createLog();
        
        String testMessage = "一致性测试";
        
        String result1 = log1.record(testMessage);
        String result2 = log2.record(testMessage);
        
        assertEquals(result1, result2, "同一工厂创建的对象行为应该一致");
        assertTrue(result1.contains("文件日志记录"), "结果应该包含正确的标识");
    }

    @Test
    @DisplayName("测试日志控制台输出")
    void testLogConsoleOutput() {
        LogFactory factory = new DatabaseLogFactory();
        Log log = factory.createLog();
        
        // 清空控制台输出
        clearConsoleOutput();
        
        // 记录日志
        log.record("测试消息");
        
        // 验证控制台输出
        assertConsoleOutputContains("数据库日志记录: 测试消息");
    }
}