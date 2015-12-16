package com.kevin.demo.creational.工and抽.工厂方法;

public class FileLogFactory  implements LogFactory{

	@Override
	public Log createLog() {
		return new FileLog();
	} 

}
