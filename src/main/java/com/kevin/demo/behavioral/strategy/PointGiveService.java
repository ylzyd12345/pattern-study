package com.kevin.demo.behavioral.strategy;

import java.math.BigDecimal;

/**
 * PointGiveService接口
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public interface PointGiveService {
	
	void givePoint(BigDecimal point);
	
	void setPointCalc(PointCalc pointCalc);
}
