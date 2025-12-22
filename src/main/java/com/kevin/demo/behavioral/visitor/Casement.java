package com.kevin.demo.behavioral.visitor;

public interface Casement {
	void accept(Person person);
	void open();
}
