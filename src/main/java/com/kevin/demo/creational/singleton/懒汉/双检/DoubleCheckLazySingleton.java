package com.kevin.demo.creational.单例.懒汉.双检;

/**
 * 双检锁懒汉式单例模式实现
 * <p>
 * 这种实现方式结合了懒加载和线程安全的优点，通过双重检查锁定机制提高了性能
 * <p>
 * 特点：
 * 1. 懒加载：只有在第一次调用getInstance()方法时才创建实例
 * 2. 线程安全：使用synchronized关键字保证多线程环境下的安全性
 * 3. 高性能：通过双重检查机制减少了同步开销
 * 4. 防止指令重排序：使用volatile关键字确保instance变量的可见性和有序性
 * 
 * @author Kevin
 */
public class DoubleCheckLazySingleton {
	/**
	 * 单例实例，使用volatile关键字确保线程可见性和禁止指令重排序
	 */
	private static volatile DoubleCheckLazySingleton singleton;

	/**
	 * 私有构造方法，防止外部实例化
	 * <p>
	 * 添加了反射防护机制，防止通过反射创建多个实例
	 */
	private DoubleCheckLazySingleton() {
		// 反射防护机制
		if (singleton != null) {
			throw new IllegalStateException("单例实例已经存在，不能通过反射创建新实例");
		}
	}

	/**
	 * 获取单例实例
	 * <p>
	 * 使用双重检查锁定机制确保线程安全和高性能
	 * 
	 * @return DoubleCheckLazySingleton 单例实例
	 */
	public static DoubleCheckLazySingleton getInstance() {
		// 第一次检查，避免不必要的同步
		if (null == singleton) {
			// 同步代码块，确保线程安全
			synchronized (DoubleCheckLazySingleton.class) {
				// 第二次检查，确保只创建一个实例
				if (null == singleton) {
					singleton = new DoubleCheckLazySingleton();
				}
			}
		}
		return singleton;
	}

}