package com.kevin.demo.creational.singleton.lazy.doubleCheck;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		DoubleCheckLazySingleton doubleCheckLazySingleton = DoubleCheckLazySingleton.getInstance();
		DoubleCheckLazySingleton doubleCheckLazySingleton2 = DoubleCheckLazySingleton.getInstance();
		System.out.println(doubleCheckLazySingleton+"\n"+doubleCheckLazySingleton2);
	}
}
