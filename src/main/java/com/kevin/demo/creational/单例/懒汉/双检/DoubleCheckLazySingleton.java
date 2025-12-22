package com.kevin.demo.creational.单.懒汉.双检;

public class DoubleCheckLazySingleton {
	private static volatile DoubleCheckLazySingleton singleton;

	private DoubleCheckLazySingleton() {
	}

	public static DoubleCheckLazySingleton getInstance() {
		if (null == singleton) {
			synchronized (DoubleCheckLazySingleton.class) {
				if (null == singleton) {
					singleton = new DoubleCheckLazySingleton();
				}
			}
		}
		return singleton;
	}

}
