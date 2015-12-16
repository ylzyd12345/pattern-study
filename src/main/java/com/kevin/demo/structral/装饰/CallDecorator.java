package com.kevin.demo.structral.装饰;

public class CallDecorator extends Call {

	private Call call;

	public CallDecorator(Call call) {
		this.call = call;
	}

	@Override
	protected void call(String number) {
		call.call(number);
	}


}
