package com.kevin.demo.behavioral.visitor;

/**
 * WoodChimney类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class WoodChimney implements  Chimney {

	@Override
	public void accept(Person person) {
		person.visit(this);
	}

	@Override
	public void open() {
		System.out.println(getClass().getName() + " is open!");
	}

}
