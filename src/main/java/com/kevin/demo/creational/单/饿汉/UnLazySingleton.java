package com.kevin.demo.creational.单.饿汉;

public class UnLazySingleton {

	private static final UnLazySingleton INSTANCE = new UnLazySingleton();

	private UnLazySingleton() {
	}

	public static UnLazySingleton getInstance() {
		return INSTANCE;
	}

}
