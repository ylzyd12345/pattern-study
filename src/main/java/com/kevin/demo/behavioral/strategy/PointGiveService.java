package com.kevin.demo.behavioral.strategy;

import java.math.BigDecimal;

public interface PointGiveService {
	
	void givePoint(BigDecimal point);
	
	void setPointCalc(PointCalc pointCalc);
}
