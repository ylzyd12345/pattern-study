package com.kevin.demo.creational.工and抽.工厂方法;

public class DatabaseLog implements Log {

	@Override
	public void writeLog() {
		System.out.println("log into database!");
	}

}
