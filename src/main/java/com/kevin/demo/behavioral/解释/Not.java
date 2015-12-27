package com.kevin.demo.behavioral.解释;

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
