package com.kevin.demo.behavioral.interpreter;
/**
 * @author Administrator
 *
 */
public abstract class Expression {
	/**
	 * 解释表达式
	 * @param ctx 上下文
	 * @return 是否解释成功
	 */
	public abstract boolean interpret(Context ctx); 
	
}
