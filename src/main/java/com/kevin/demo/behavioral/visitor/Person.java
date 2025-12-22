package com.kevin.demo.behavioral.访问者;

public interface Person {
	void visit(Door door);
	void visit(Casement casement);
	void visit(Chimney chimney);
}
