package com.kevin.demo.creational.单.饿汉;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		UnLazySingleton unLazySingleton = UnLazySingleton.getInstance();
		UnLazySingleton unLazySingleton2 = UnLazySingleton.getInstance();
		System.out.println(unLazySingleton+"====="+unLazySingleton2);
	}
}
