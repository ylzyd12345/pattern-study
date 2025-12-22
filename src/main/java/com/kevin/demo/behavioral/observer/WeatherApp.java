package com.kevin.demo.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 天气应用类
 * <p>
 * 观察者模式中的观察者(Observer)角色，实现了Java内置的Observer接口
 * <p>
 * 负责接收气象站发出的天气变化通知，并进行相应的处理
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class WeatherApp implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        // 确保通知来自WeatherStation对象
        if (o instanceof WeatherStation) {
            // 处理天气变化信息
            listenning((String)arg);
        }
    }
    
    private void listenning(String weather) {
        System.out.println("WeatherApp recieve weather changed msg!, weather is " + weather);
    }

}
