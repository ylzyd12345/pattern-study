package com.kevin.demo.creational.singleton.lazy.innerClass;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		HandlerLazySingleton handlerLazySingleton = HandlerLazySingleton.getInstance();
		HandlerLazySingleton handlerLazySingleton2 = HandlerLazySingleton.getInstance();
		System.out.println(handlerLazySingleton+"\n"+handlerLazySingleton2);
	}
}
