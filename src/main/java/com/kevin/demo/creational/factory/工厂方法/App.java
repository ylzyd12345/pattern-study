package com.kevin.demo.creational.工厂.工厂方法;

public class App {
	public static void main(String[] args) {
		LogFactory logFactory;
		Log log;

		logFactory = new FileLogFactory();
		log = logFactory.createLog();
		log.writeLog();

		logFactory = new DatabaseLogFactory();
		log = logFactory.createLog();

		log.writeLog();
	}
}
