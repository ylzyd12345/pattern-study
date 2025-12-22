package com.kevin.demo.behavioral.visitor;

public interface Chimney {
	void accept(Person person);
	void open();
}
