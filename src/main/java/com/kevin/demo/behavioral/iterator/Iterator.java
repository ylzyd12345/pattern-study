package com.kevin.demo.behavioral.iterator;

/**
 * 迭代器接口 - 迭代器模式中的迭代器角色(Iterator)
 * 定义了遍历容器元素的标准方法
 * 
 * 迭代器模式(Iterator Pattern)：提供一种方法来访问一个容器对象中各个元素，
 * 而又不需要暴露该对象的内部表示
 * 
 * @param <T> 迭代元素的类型
 * 
 * @author Kevin
 * @since 1.0.0
 */
public interface Iterator<T> {
	/**
	 * 检查是否还有下一个元素
	 * 
	 * @return 如果有下一个元素返回true，否则返回false
	 */
	boolean hasNext();
	
	/**
	 * 返回下一个元素
	 * 
	 * @return 下一个元素
	 */
	T next();
}