package com.kevin.demo.behavioral.iterator;

/**
 * 团队接口 - 迭代器模式中的聚合角色(Aggregate)
 * 定义了创建迭代器对象的接口
 * 
 * 迭代器模式(Iterator Pattern)：提供一种方法来访问一个容器对象中各个元素，
 * 而又不需要暴露该对象的内部表示
 * 
 * @author Kevin
 * @since 1.0.0
 */
public interface Team {
	void add(Member member);
	
	Iterator<Member> iterator();
}
