package com.kevin.demo.behavioral.策略;

import java.math.BigDecimal;

public class PointGiveServiceImpl implements PointGiveService {

	private PointCalc pointCalc;

	public PointGiveServiceImpl(PointCalc pointCalc) {
		this.pointCalc = pointCalc;
	}

	@Override
	public void givePoint(BigDecimal point) {
		System.out.println(pointCalc.calc(point));
	}


	@Override
	public void setPointCalc(PointCalc pointCalc) {
		this.pointCalc = pointCalc;
	}
	
	
	
}
