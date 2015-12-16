package com.kevin.demo.structral.装饰;

public class PhoneCall extends Call {

	@Override
	protected void call(String number) {
		System.out.println("phone call number is  " + number);
	}

}
