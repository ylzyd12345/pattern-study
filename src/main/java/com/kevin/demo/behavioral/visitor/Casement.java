package com.kevin.demo.behavioral.visitor;

/**
 * Casement接口
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public interface Casement {
	void accept(Person person);
	void open();
}
