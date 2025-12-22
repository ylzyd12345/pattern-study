package com.kevin.demo.creational.单例.饿汉;

/**
 * 饿汉式单例模式实现
 * <p>
 * 单例模式(Singleton Pattern)：确保一个类只有一个实例，并提供全局访问点
 * <p>
 * 饿汉式特点：
 * 1. 类加载时就创建实例，线程安全
 * 2. 实现简单，性能高
 * 3. 可能造成资源浪费（如果实例一直不被使用）
 * <p>
 * 适用场景：
 * - 实例占用资源较少
 * - 对启动速度要求较高
 * - 不需要延迟加载
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class EagerSingleton {

	/**
	 * 单例实例，类加载时即初始化
	 */
	private static final EagerSingleton INSTANCE = new EagerSingleton();

	/**
	 * 私有构造方法，防止外部实例化
	 */
	private EagerSingleton() {
		// 防止通过反射创建实例
		if (INSTANCE != null) {
			throw new RuntimeException("单例模式禁止通过反射创建多个实例");
		}
	}

	/**
	 * 获取单例实例的全局访问点
	 * 
	 * @return 饿汉式单例实例
	 */
	public static EagerSingleton getInstance() {
		return INSTANCE;
	}

	/**
	 * 重写readResolve方法，防止序列化/反序列化破坏单例
	 * 
	 * @return 单例实例
	 */
	private Object readResolve() {
		return INSTANCE;
	}
}