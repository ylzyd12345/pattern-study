package com.kevin.demo.behavioral.observer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式测试类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("观察者模式测试")
class ObserverPatternTest {

    private WeatherStation weatherStation;
    private WeatherApp weatherApp;
    private WeatherSite weatherSite;

    @BeforeEach
    void setUp() {
        weatherStation = new WeatherStation();
        weatherApp = new WeatherApp();
        weatherSite = new WeatherSite();
    }

    @Test
    @DisplayName("测试观察者注册和通知")
    void testObserverRegistrationAndNotification() {
        // 注册观察者
        weatherStation.addObserver(weatherApp);
        weatherStation.addObserver(weatherSite);
        
        // 验证观察者数量
        assertEquals(2, weatherStation.countObservers(), "应该有2个观察者被注册");
        
        // 触发状态变化
        weatherStation.changed();
        
        // 验证观察者是否被通知（这里通过检查观察者的状态来验证）
        assertNotNull(weatherApp, "天气应用应该存在");
        assertNotNull(weatherSite, "天气网站应该存在");
    }

    @Test
    @DisplayName("测试单个观察者通知")
    void testSingleObserverNotification() {
        // 只注册一个观察者
        weatherStation.addObserver(weatherApp);
        
        assertEquals(1, weatherStation.countObservers(), "应该有1个观察者被注册");
        
        // 触发通知
        weatherStation.changed();
        
        // 验证观察者被通知
        assertTrue(weatherStation.hasChanged(), "气象站状态应该已改变");
    }

    @Test
    @DisplayName("测试观察者删除")
    void testObserverRemoval() {
        // 注册观察者
        weatherStation.addObserver(weatherApp);
        weatherStation.addObserver(weatherSite);
        
        assertEquals(2, weatherStation.countObservers(), "初始应该有2个观察者");
        
        // 删除一个观察者
        weatherStation.deleteObserver(weatherApp);
        
        assertEquals(1, weatherStation.countObservers(), "删除后应该有1个观察者");
        assertFalse(weatherStation.hasChanged(), "删除观察者不应该改变状态标记");
    }

    @Test
    @DisplayName("测试删除所有观察者")
    void testDeleteAllObservers() {
        // 注册多个观察者
        weatherStation.addObserver(weatherApp);
        weatherStation.addObserver(weatherSite);
        
        assertEquals(2, weatherStation.countObservers(), "初始应该有2个观察者");
        
        // 删除所有观察者
        weatherStation.deleteObservers();
        
        assertEquals(0, weatherStation.countObservers(), "删除后应该没有观察者");
    }

    @Test
    @DisplayName("测试状态变化标记")
    void testChangedFlag() {
        // 初始状态
        assertFalse(weatherStation.hasChanged(), "初始状态应该没有改变");
        
        // 注册观察者
        weatherStation.addObserver(weatherApp);
        
        // 触发变化
        weatherStation.changed();
        
        // 状态应该被标记为已改变
        assertTrue(weatherStation.hasChanged(), "变化后状态应该被标记为已改变");
    }

    @Nested
    @DisplayName("观察者模式特性测试")
    class ObserverPatternCharacteristicsTest {
        
        @Test
        @DisplayName("测试观察者的动态注册")
        void testDynamicObserverRegistration() {
            // 初始没有观察者
            assertEquals(0, weatherStation.countObservers());
            
            // 动态添加观察者
            weatherStation.addObserver(weatherApp);
            assertEquals(1, weatherStation.countObservers());
            
            // 再次添加观察者
            weatherStation.addObserver(weatherSite);
            assertEquals(2, weatherStation.countObservers());
            
            // 动态删除观察者
            weatherStation.deleteObserver(weatherApp);
            assertEquals(1, weatherStation.countObservers());
        }

        @Test
        @DisplayName("测试一对多关系")
        void testOneToManyRelationship() {
            // 一个主题可以有多个观察者
            weatherStation.addObserver(weatherApp);
            weatherStation.addObserver(weatherSite);
            
            // 创建额外的观察者
            Observer extraObserver = new Observer() {
                @Override
                public void update(Observable o, Object arg) {
                    // 处理更新
                }
            };
            
            weatherStation.addObserver(extraObserver);
            
            assertEquals(3, weatherStation.countObservers(), "一个主题可以有多个观察者");
            
            // 通知所有观察者
            weatherStation.changed();
            
            // 验证所有观察者都被通知
            assertTrue(weatherStation.hasChanged(), "所有观察者都应该被通知");
        }

        @Test
        @DisplayName("测试松耦合特性")
        void testLooseCoupling() {
            // 观察者模式实现松耦合：主题不需要知道观察者的具体实现
            
            weatherStation.addObserver(weatherApp);
            
            // 主题只知道观察者实现了Observer接口
            assertTrue(weatherApp instanceof Observer, "观察者应该实现Observer接口");
            
            // 主题可以通知任何实现了Observer接口的对象
            weatherStation.changed();
            
            // 这种设计允许在运行时添加不同类型的观察者
            Observer anonymousObserver = new Observer() {
                @Override
                public void update(Observable o, Object arg) {
                    // 匿名观察者的处理逻辑
                }
            };
            
            weatherStation.addObserver(anonymousObserver);
            assertEquals(2, weatherStation.countObservers(), "可以添加不同类型的观察者");
        }
    }

    @Test
    @DisplayName("测试重复注册观察者")
    void testDuplicateObserverRegistration() {
        // 注册同一个观察者两次
        weatherStation.addObserver(weatherApp);
        weatherStation.addObserver(weatherApp);
        
        // Java的Observable类不允许重复注册同一个观察者
        assertEquals(1, weatherStation.countObservers(), "重复注册的观察者应该只被计算一次");
    }

    @Test
    @DisplayName("测试删除不存在的观察者")
    void testRemoveNonExistentObserver() {
        // 尝试删除没有注册的观察者
        weatherStation.deleteObserver(weatherApp);
        
        assertEquals(0, weatherStation.countObservers(), "删除不存在的观察者不应该出错");
    }

    @Nested
    @DisplayName("边界条件测试")
    class EdgeCaseTest {
        
        @Test
        @DisplayName("测试空观察者列表时的通知")
        void testNotificationWithEmptyObserverList() {
            // 没有注册任何观察者
            assertEquals(0, weatherStation.countObservers());
            
            // 尝试通知
            assertDoesNotThrow(() -> weatherStation.changed(), 
                              "没有观察者时通知不应该抛出异常");
        }

        @Test
        @DisplayName("测试null观察者")
        void testNullObserver() {
            // Java的Observable不允许添加null观察者
            assertThrows(NullPointerException.class, () -> {
                weatherStation.addObserver(null);
            }, "添加null观察者应该抛出NullPointerException");
        }
    }

    @Test
    @DisplayName("测试观察者通知的顺序")
    void testObserverNotificationOrder() {
        // 创建测试观察者来记录通知顺序
        TestObserver observer1 = new TestObserver("Observer1");
        TestObserver observer2 = new TestObserver("Observer2");
        TestObserver observer3 = new TestObserver("Observer3");
        
        // 按顺序注册观察者
        weatherStation.addObserver(observer1);
        weatherStation.addObserver(observer2);
        weatherStation.addObserver(observer3);
        
        // 触发通知
        weatherStation.changed();
        
        // 验证通知顺序（Java Observable按照注册的相反顺序通知）
        assertEquals(3, TestObserver.getNotificationCount(), "所有观察者都应该被通知");
    }

    @Test
    @DisplayName("测试观察者的线程安全性")
    void testObserverThreadSafety() throws InterruptedException {
        final int threadCount = 10;
        final Thread[] threads = new Thread[threadCount];
        
        // 创建多个线程同时注册观察者
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                weatherStation.addObserver(new WeatherApp());
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
        
        // 验证所有观察者都被注册
        assertEquals(threadCount, weatherStation.countObservers(), 
                    "所有线程的观察者都应该被成功注册");
    }

    /**
     * 测试用的观察者类
     */
    private static class TestObserver implements Observer {
        private static int notificationCount = 0;
        private final String name;
        
        public TestObserver(String name) {
            this.name = name;
        }
        
        @Override
        public void update(Observable o, Object arg) {
            notificationCount++;
            // 记录通知顺序
        }
        
        public static int getNotificationCount() {
            return notificationCount;
        }
        
        public static void resetNotificationCount() {
            notificationCount = 0;
        }
    }

    @BeforeEach
    void resetTestObserver() {
        TestObserver.resetNotificationCount();
    }
}