package com.kevin.demo.structral.装饰;

public class RecordDecorator extends CallDecorator {


	public RecordDecorator(Call call) {
		super(call);
	}

	@Override
	protected void call(String number) {
		long begintime = System.currentTimeMillis();
		super.call(number);
		long endtime = System.currentTimeMillis();
		record(begintime, endtime, number);
	}

	private void record(long begintime, long endtime, String number) {
		System.out.println("call " + number + ", costTime is " + (endtime - begintime));
	}

}
