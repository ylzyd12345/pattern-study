package com.kevin.demo.behavioral.chainOfResponsibility;

/**
 * PrintHandler类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class PrintHandler extends Handler {

	@Override
	public void process(String req) {
		System.out.println(getClass().getSimpleName() + "process, " + req);
	}

}
