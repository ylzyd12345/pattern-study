package com.kevin.demo.behavioral.责任链;

public abstract class Handler {
	private Handler nextHandler;

	public Handler getNextHandler() {
		return nextHandler;
	}

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public abstract void process(String req);

}
