package com.kevin.demo.behavioral.访问者;

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
