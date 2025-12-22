package com.kevin.demo.creational.工厂.工厂方法;

/**
 * 文件日志记录类
 * <p>
 * 工厂方法模式中的具体产品(ConcreteProduct)，实现了Log接口，负责文件日志的具体实现
 * 
 * @author Kevin
 */
public class FileLog implements Log {

	/**
	 * 写入文件日志
	 */
	@Override
	public void writeLog() {
		System.out.println("log into file!");
	}

}