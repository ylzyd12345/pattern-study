package com.kevin.demo.behavioral.strategy;

import java.math.BigDecimal;

/**
 * PointGiveServiceImpl类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
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
