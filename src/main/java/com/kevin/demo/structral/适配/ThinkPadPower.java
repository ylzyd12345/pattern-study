package com.kevin.demo.structral.适配;

public class ThinkPadPower implements ComputerPower {

	private CommonPower commonPower;

	public ThinkPadPower(CommonPower commonPower) {
		this.commonPower = commonPower;
	}

	@Override
	public int getPower() {
		return (commonPower.getPower() / Integer.valueOf(100));
	}

}
