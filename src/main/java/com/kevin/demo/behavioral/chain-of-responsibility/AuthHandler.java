package com.kevin.demo.behavioral.责任链;

public class AuthHandler extends Handler{

	@Override
	public void process(String req) {
		if (null == req) {
			System.out.println(getClass().getSimpleName() + "process, req is null");
		}else
		{
			if (null != getNextHandler()) {
				getNextHandler().process(req);
			}else
			{
				System.out.println(getClass().getSimpleName() + "process, auth pass");
			}
		}
	}

}
