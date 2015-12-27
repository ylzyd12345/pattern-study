package com.kevin.demo.behavioral.解释;

public class Constant extends Expression {

	private boolean value;

	public Constant(boolean value) {
		this.value = value;
	}

	@Override
	public boolean interpret(Context ctx) {
		return value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Constant [value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
	
	

}
