package com.kevin.demo.creational.singleton.eager;

/**
 * 饿汉式单例模式测试类
 * @author kevin
 */
public class App {
	/**
	 * 主方法，测试饿汉式单例模式
	 * @param args 命令行参数
	 */
	public static void main(String[] args) {
		EagerSingleton eagerSingleton = EagerSingleton.getInstance();
		EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
		System.out.println("单例实例1: " + eagerSingleton);
		System.out.println("单例实例2: " + eagerSingleton2);
		System.out.println("两个实例是否相同: " + (eagerSingleton == eagerSingleton2));
	}
}