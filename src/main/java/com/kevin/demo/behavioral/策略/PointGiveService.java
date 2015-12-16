package com.kevin.demo.behavioral.策略;

import java.math.BigDecimal;

public interface PointGiveService {
	
	void givePoint(BigDecimal point);
	
	void setPointCalc(PointCalc pointCalc);
}
