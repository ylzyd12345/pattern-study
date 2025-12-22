package com.kevin.demo.behavioral.strategy;

import java.math.BigDecimal;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		PointCalc pointCalc = new BasePointCalc();
		PointGiveService pointGiveService = new PointGiveServiceImpl(pointCalc);
		pointGiveService.givePoint(BigDecimal.valueOf(102.0));
		pointGiveService.setPointCalc(new FullGivePointCalc());
		pointGiveService.givePoint(BigDecimal.valueOf(102.0));
		
	}
}
