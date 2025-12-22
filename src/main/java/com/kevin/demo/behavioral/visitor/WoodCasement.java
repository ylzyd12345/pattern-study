package com.kevin.demo.behavioral.visitor;

/**
 * WoodCasement类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class WoodCasement implements Casement {

	@Override
	public void accept(Person person) {
		person.visit(this);
	}

	@Override
	public void open() {
		System.out.println(getClass().getName() + " is open!");
	}

}
