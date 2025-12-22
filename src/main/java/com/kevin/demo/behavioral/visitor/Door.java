package com.kevin.demo.behavioral.visitor;

/**
 * Door接口
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public interface Door {
	void accept(Person person);
	void open();
}
