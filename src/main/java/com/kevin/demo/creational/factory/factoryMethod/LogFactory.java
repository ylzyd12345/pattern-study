package com.kevin.demo.creational.factory.factoryMethod;

/**
 * 日志工厂接口
 * <p>
 * 工厂方法模式中的工厂接口(Creator)，声明了工厂方法，用于创建产品对象
 * 
 * @author Kevin
 */
public interface LogFactory {
	Log createLog();
}
