package com.kevin.demo.creational.factory.factoryMethod;

/**
 * 日志记录接口
 * <p>
 * 工厂方法模式中的产品接口(Product)，定义了产品的共同接口
 * 
 * @author Kevin
 */
public interface Log {
	/**
	 * 写入日志记录
	 */
	void writeLog();
}