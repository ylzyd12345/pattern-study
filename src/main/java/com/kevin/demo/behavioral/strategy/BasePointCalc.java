package com.kevin.demo.behavioral.strategy;

import java.math.BigDecimal;

/**
 * BasePointCalc类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class BasePointCalc implements PointCalc {

	@Override
	public BigDecimal calc(BigDecimal point) {
		return point;
	}
	

}
