package com.kevin.demo.creational.factory.factoryMethod;

/**
 * 文件日志工厂类
 * <p>
 * 工厂方法模式中的具体工厂(ConcreteCreator)，实现了LogFactory接口，负责创建文件日志记录对象
 * 
 * @author Kevin
 */
public class FileLogFactory  implements LogFactory{

	@Override
	public Log createLog() {
		return new FileLog();
	} 

}
