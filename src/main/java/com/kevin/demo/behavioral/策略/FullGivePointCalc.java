package com.kevin.demo.behavioral.策略;

import java.math.BigDecimal;

public class FullGivePointCalc implements PointCalc {

	@Override
	public BigDecimal calc(BigDecimal point) {
		if (point.compareTo(BigDecimal.valueOf(10000.0)) > 0) {
			return  BigDecimal.TEN;
		}
		return BigDecimal.ONE;
	}
	

}
