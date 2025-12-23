package com.kevin.demo.creational.factory.simpleFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 简单工厂模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("简单工厂模式测试")
class CarFactoryTest {

    @Test
    @DisplayName("测试创建BMW汽车")
    void testCreateBMWCar() {
        Car bmwCar = CarFactory.createCar(CarTypeEnum.BMW);
        
        assertNotNull(bmwCar, "创建的BMW汽车不应该为null");
        assertInstanceOf(BMWCar.class, bmwCar, "应该是BMW汽车类型");
        assertEquals("BMW汽车启动", bmwCar.start(), "BMW汽车启动信息应该正确");
        assertEquals("BMW汽车停止", bmwCar.stop(), "BMW汽车停止信息应该正确");
    }

    @Test
    @DisplayName("测试创建BENZ汽车")
    void testCreateBENZCar() {
        Car benzCar = CarFactory.createCar(CarTypeEnum.BENZ);
        
        assertNotNull(benzCar, "创建的BENZ汽车不应该为null");
        assertInstanceOf(BENZCar.class, benzCar, "应该是BENZ汽车类型");
        assertEquals("BENZ汽车启动", benzCar.start(), "BENZ汽车启动信息应该正确");
        assertEquals("BENZ汽车停止", benzCar.stop(), "BENZ汽车停止信息应该正确");
    }

    @Test
    @DisplayName("测试创建不支持的汽车类型")
    void testCreateUnsupportedCarType() {
        Car unsupportedCar = CarFactory.createCar(null);
        assertNull(unsupportedCar, "不支持的汽车类型应该返回null");
    }

    @Test
    @DisplayName("测试多次创建同类型汽车")
    void testCreateMultipleSameTypeCars() {
        Car bmwCar1 = CarFactory.createCar(CarTypeEnum.BMW);
        Car bmwCar2 = CarFactory.createCar(CarTypeEnum.BMW);
        
        assertNotNull(bmwCar1, "第一个BMW汽车不应该为null");
        assertNotNull(bmwCar2, "第二个BMW汽车不应该为null");
        assertNotSame(bmwCar1, bmwCar2, "工厂应该创建不同的实例");
        assertEquals(bmwCar1.getClass(), bmwCar2.getClass(), "两个实例应该是相同类型");
    }

    @Test
    @DisplayName("测试创建不同类型汽车")
    void testCreateDifferentTypeCars() {
        Car bmwCar = CarFactory.createCar(CarTypeEnum.BMW);
        Car benzCar = CarFactory.createCar(CarTypeEnum.BENZ);
        
        assertNotNull(bmwCar, "BMW汽车不应该为null");
        assertNotNull(benzCar, "BENZ汽车不应该为null");
        assertNotSame(bmwCar, benzCar, "不同类型的汽车应该是不同的实例");
        assertInstanceOf(BMWCar.class, bmwCar, "应该是BMW汽车");
        assertInstanceOf(BENZCar.class, benzCar, "应该是BENZ汽车");
    }

    @Nested
    @DisplayName("汽车功能测试")
    class CarFunctionalityTest {
        
        @Test
        @DisplayName("测试BMW汽车功能")
        void testBMWCarFunctionality() {
            Car bmwCar = CarFactory.createCar(CarTypeEnum.BMW);
            
            // 测试启动功能
            String startMessage = bmwCar.start();
            assertNotNull(startMessage, "启动信息不应该为null");
            assertEquals("BMW汽车启动", startMessage, "BMW启动信息应该正确");
            
            // 测试停止功能
            String stopMessage = bmwCar.stop();
            assertNotNull(stopMessage, "停止信息不应该为null");
            assertEquals("BMW汽车停止", stopMessage, "BMW停止信息应该正确");
        }

        @Test
        @DisplayName("测试BENZ汽车功能")
        void testBENZCarFunctionality() {
            Car benzCar = CarFactory.createCar(CarTypeEnum.BENZ);
            
            // 测试启动功能
            String startMessage = benzCar.start();
            assertNotNull(startMessage, "启动信息不应该为null");
            assertEquals("BENZ汽车启动", startMessage, "BENZ启动信息应该正确");
            
            // 测试停止功能
            String stopMessage = benzCar.stop();
            assertNotNull(stopMessage, "停止信息不应该为null");
            assertEquals("BENZ汽车停止", stopMessage, "BENZ停止信息应该正确");
        }
    }

    @Test
    @DisplayName("测试工厂方法的静态特性")
    void testFactoryMethodStaticNature() {
        // 简单工厂的工厂方法应该是静态的
        // 这个测试验证我们可以直接通过类名调用工厂方法
        
        Car bmwCar = CarFactory.createCar(CarTypeEnum.BMW);
        Car benzCar = CarFactory.createCar(CarTypeEnum.BENZ);
        
        assertNotNull(bmwCar, "通过静态方法创建BMW汽车应该成功");
        assertNotNull(benzCar, "通过静态方法创建BENZ汽车应该成功");
    }

    @Test
    @DisplayName("测试工厂方法的一致性")
    void testFactoryMethodConsistency() {
        // 测试工厂方法在相同输入下的一致性
        
        CarTypeEnum carType = CarTypeEnum.BMW;
        Car car1 = CarFactory.createCar(carType);
        Car car2 = CarFactory.createCar(carType);
        
        assertEquals(car1.getClass(), car2.getClass(), 
                    "相同输入应该产生相同类型的对象");
        assertEquals(car1.start(), car2.start(), 
                    "相同类型对象的行为应该一致");
        assertEquals(car1.stop(), car2.stop(), 
                    "相同类型对象的行为应该一致");
    }

    @Nested
    @DisplayName("枚举类型测试")
    class CarTypeEnumTest {
        
        @Test
        @DisplayName("测试汽车类型枚举值")
        void testCarTypeEnumValues() {
            CarTypeEnum[] values = CarTypeEnum.values();
            assertEquals(2, values.length, "汽车类型枚举应该有两个值");
            
            boolean hasBMW = false;
            boolean hasBENZ = false;
            
            for (CarTypeEnum type : values) {
                if (type == CarTypeEnum.BMW) hasBMW = true;
                if (type == CarTypeEnum.BENZ) hasBENZ = true;
            }
            
            assertTrue(hasBMW, "应该包含BMW类型");
            assertTrue(hasBENZ, "应该包含BENZ类型");
        }

        @Test
        @DisplayName("测试valueOf方法")
        void testValueOfMethod() {
            CarTypeEnum bmw = CarTypeEnum.valueOf("BMW");
            CarTypeEnum benz = CarTypeEnum.valueOf("BENZ");
            
            assertEquals(CarTypeEnum.BMW, bmw, "valueOf应该返回正确的BMW枚举");
            assertEquals(CarTypeEnum.BENZ, benz, "valueOf应该返回正确的BENZ枚举");
        }
    }

    @Test
    @DisplayName("测试工厂的可扩展性")
    void testFactoryExtensibility() {
        // 这个测试主要验证当前工厂设计的扩展性
        // 在实际应用中，如果需要添加新的汽车类型，只需要：
        // 1. 创建新的汽车类实现Car接口
        // 2. 在CarTypeEnum中添加新的枚举值
        // 3. 在CarFactory中添加新的创建逻辑
        
        // 当前支持的类型
        CarTypeEnum[] supportedTypes = CarTypeEnum.values();
        
        // 验证每种类型都能正确创建
        for (CarTypeEnum type : supportedTypes) {
            Car car = CarFactory.createCar(type);
            assertNotNull(car, "类型 " + type + " 应该能创建对应的汽车");
            assertTrue(car instanceof Car, "创建的对象应该实现Car接口");
        }
    }
}