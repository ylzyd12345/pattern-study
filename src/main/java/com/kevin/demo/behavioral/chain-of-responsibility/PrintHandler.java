package com.kevin.demo.behavioral.责任链;

public class PrintHandler extends Handler {

	@Override
	public void process(String req) {
		System.out.println(getClass().getSimpleName() + "process, " + req);
	}

}
