package com.kevin.demo.structral.装饰;

public class TranslateDecorator extends CallDecorator {

	public TranslateDecorator(Call call) {
		super(call);
	}

	@Override
	protected void call(String number) {
		super.call(number);
		System.out.println("translate the call, number is  " + number);
	}

}
