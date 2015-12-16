package com.kevin.demo.behavioral.访问者;

public class Police implements Person{

	@Override
	public void visit(Door door) {
		System.out.println("i am "+ getClass().getName()+ ", i gona open the " + door);
		door.open();
	}

	@Override
	public void visit(Casement casement) {
		System.out.println("i am "+ getClass().getName()+ ", i gona open the " + casement);
		casement.open();
	}

	@Override
	public void visit(Chimney chimney) {
		System.out.println("i am "+ getClass().getName()+ ", i gona open the " + chimney);
		chimney.open();
	}

}
