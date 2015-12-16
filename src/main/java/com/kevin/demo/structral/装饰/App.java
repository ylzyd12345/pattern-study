package com.kevin.demo.structral.装饰;

public class App {
	public static void main(String[] args) {
		Call call = new PhoneCall();
		Call recordCall = new RecordDecorator(call);
		recordCall.call("00000");
		Call translateCall = new TranslateDecorator(recordCall);
		translateCall.call("111111");
		call.call("222222");
	}
}
