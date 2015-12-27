package com.kevin.demo.behavioral.解释;

public class Or extends Expression {

	private Expression left;
	private Expression right;

	public Or(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean interpret(Context ctx) {
		return left.interpret(ctx) || right.interpret(ctx);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Or [left=");
		builder.append(left);
		builder.append(", right=");
		builder.append(right);
		builder.append("]");
		return builder.toString();
	}
	
	

}
