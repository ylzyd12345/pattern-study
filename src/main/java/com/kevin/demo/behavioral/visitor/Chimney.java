package com.kevin.demo.behavioral.visitor;

/**
 * Chimney接口
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public interface Chimney {
	void accept(Person person);
	void open();
}
