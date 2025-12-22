package com.kevin.demo.creational.工厂.工厂方法;

/**
 * 数据库日志工厂类
 * <p>
 * 工厂方法模式中的具体工厂(ConcreteCreator)，实现了LogFactory接口，负责创建数据库日志记录对象
 * 
 * @author Kevin
 */
public class DatabaseLogFactory  implements LogFactory{

	/**
	 * 创建数据库日志记录对象
	 * 
	 * @return Log 数据库日志记录对象
	 */
	@Override
	public Log createLog() {
		return new DatabaseLog();
	}

}