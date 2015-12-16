package com.kevin.demo.behavioral.访问者;

public interface Door {
	void accept(Person person);
	void open();
}
