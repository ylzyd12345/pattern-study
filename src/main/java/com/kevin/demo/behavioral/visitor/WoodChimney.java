package com.kevin.demo.behavioral.visitor;

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
