package com.kevin.demo.behavioral.interpreter;

/**
 * Not类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class Not extends Expression {

	private Expression expression;

	public Not(Expression expression) {
		this.expression = expression;
	}

	@Override
	public boolean interpret(Context ctx) {
		return !expression.interpret(ctx);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Not [expression=");
		builder.append(expression);
		builder.append("]");
		return builder.toString();
	}

	
}
