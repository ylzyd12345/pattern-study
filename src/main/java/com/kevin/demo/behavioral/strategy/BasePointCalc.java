package com.kevin.demo.behavioral.strategy;

import java.math.BigDecimal;

public class BasePointCalc implements PointCalc {

	@Override
	public BigDecimal calc(BigDecimal point) {
		return point;
	}
	

}
