package com.kevin.demo.creational.工厂.工厂方法;

public class DatabaseLogFactory  implements LogFactory{

	@Override
	public Log createLog() {
		return new DatabaseLog();
	}

}
