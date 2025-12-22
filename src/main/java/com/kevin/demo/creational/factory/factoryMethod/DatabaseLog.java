package com.kevin.demo.creational.factory.factoryMethod;

/**
 * 数据库日志记录类
 * <p>
 * 工厂方法模式中的具体产品(ConcreteProduct)，实现了Log接口，负责数据库日志的具体实现
 * 
 * @author Kevin
 */
public class DatabaseLog implements Log {

	/**
	 * 写入数据库日志
	 */
	@Override
	public void writeLog() {
		System.out.println("log into database!");
	}

}