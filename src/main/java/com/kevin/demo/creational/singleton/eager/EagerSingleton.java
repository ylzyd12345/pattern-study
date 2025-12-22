package com.kevin.demo.creational.singleton.eager;

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

	private static final EagerSingleton INSTANCE = new EagerSingleton();

	private EagerSingleton() {
		// 防止通过反射创建实例
		if (INSTANCE != null) {
			throw new RuntimeException("单例模式禁止通过反射创建多个实例");
		}
	}

	public static EagerSingleton getInstance() {
		return INSTANCE;
	}

	private Object readResolve() {
		return INSTANCE;
	}
}
