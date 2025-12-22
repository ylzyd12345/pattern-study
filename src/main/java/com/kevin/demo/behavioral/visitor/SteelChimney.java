package com.kevin.demo.behavioral.visitor;

/**
 * SteelChimney类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class SteelChimney implements Chimney {

	@Override
	public void accept(Person person) {
		person.visit(this);
	}

	@Override
	public void open() {
		System.out.println(getClass().getName() + " is open!");
	}

}
