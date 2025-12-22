package com.kevin.demo.creational.单.懒汉.内部类;

public class HandlerLazySingleton {

	private HandlerLazySingleton() {
	}

	private static class SingletonHander {
		private static final HandlerLazySingleton SINGLETON = new HandlerLazySingleton();
	}

	public static HandlerLazySingleton getInstance() {
		return SingletonHander.SINGLETON;
	}

}
