package com.kevin.demo.behavioral.visitor;

/**
 * Person接口
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public interface Person {
	void visit(Door door);
	void visit(Casement casement);
	void visit(Chimney chimney);
}
