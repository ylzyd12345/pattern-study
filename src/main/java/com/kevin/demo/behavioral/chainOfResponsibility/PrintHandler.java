package com.kevin.demo.behavioral.chainOfResponsibility;

public class PrintHandler extends Handler {

	@Override
	public void process(String req) {
		System.out.println(getClass().getSimpleName() + "process, " + req);
	}

}
