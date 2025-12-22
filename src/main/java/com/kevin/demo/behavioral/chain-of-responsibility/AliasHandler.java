package com.kevin.demo.behavioral.责任链;

public class AliasHandler extends Handler {

	@Override
	public void process(String req) {

		if (!"alias".equalsIgnoreCase(req)) {
			System.out.println(getClass().getSimpleName() + "process, alias fail");
		} else {
			if (null == getNextHandler()) {
				System.out.println(getClass().getSimpleName() + "process, alias success , trans to uppercase");
			} else {
				getNextHandler().process(req.toUpperCase());
			}
		}

	}

}
