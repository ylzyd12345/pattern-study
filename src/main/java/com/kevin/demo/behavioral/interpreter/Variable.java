package com.kevin.demo.behavioral.解释;

public class Variable extends Expression {

	private String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public boolean interpret(Context ctx) {
		return ctx.lookup(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Variable [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
	

}
