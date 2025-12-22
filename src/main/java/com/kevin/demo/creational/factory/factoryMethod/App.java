package com.kevin.demo.creational.factory.factoryMethod;

/**
 * App类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
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
