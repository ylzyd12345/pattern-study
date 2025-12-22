package com.kevin.demo.creational.factory.factoryMethod;

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
