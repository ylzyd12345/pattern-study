package com.kevin.demo.creational.singleton.lazy.innerClass;

/**
 * 懒汉式单例模式 - 内部类实现
 * <p>
 * 这种实现方式利用了Java类加载的特性来保证线程安全和懒加载：
 * 1. 内部类SingletonHander只有在getInstance()方法被调用时才会被加载
 * 2. JVM保证类加载过程是线程安全的
 * 3. 实例在类加载时创建，保证了唯一性
 * 4. 相比其他懒汉式实现，不需要使用同步锁，性能更好
 * </p>
 * @author kevin
 */
public class HandlerLazySingleton {

	private HandlerLazySingleton() {
		// 防止通过反射创建多个实例
		if (SingletonHander.SINGLETON != null) {
			throw new IllegalStateException("Singleton instance already exists!");
		}
	}
	/**
	 * 静态内部类 - 延迟加载实例
	 */
	private static class SingletonHander {
		private static final HandlerLazySingleton SINGLETON = new HandlerLazySingleton();
	}

	public static HandlerLazySingleton getInstance() {
		return SingletonHander.SINGLETON;
	}

}
