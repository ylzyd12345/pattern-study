package com.kevin.demo.behavioral.策略;

import java.math.BigDecimal;

public class BasePointCalc implements PointCalc {

	@Override
	public BigDecimal calc(BigDecimal point) {
		return point;
	}
	

}
