package com.kevin.demo.behavioral.visitor;

public interface Door {
	void accept(Person person);
	void open();
}
