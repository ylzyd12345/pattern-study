package com.kevin.demo.behavioral.visitor;

public interface Person {
	void visit(Door door);
	void visit(Casement casement);
	void visit(Chimney chimney);
}
