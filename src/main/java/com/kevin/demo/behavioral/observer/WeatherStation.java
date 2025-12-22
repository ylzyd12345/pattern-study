package com.kevin.demo.behavioral.observer;

import java.util.Observable;

/**
 * 气象站类
 * <p>
 * 观察者模式中的主题(Subject)角色，继承自Java内置的Observable类
 * <p>
 * 负责维护气象数据的状态，并在状态变化时通知所有注册的观察者
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class WeatherStation extends Observable {
    
    /**
     * 模拟天气变化
     * <p>
     * 当天气发生变化时，调用此方法通知所有观察者
     */
    public void changed() {
        // 标记状态已改变
        setChanged();
        
        // 通知所有观察者，传递天气信息
        notifyObservers("hot");
    }
}