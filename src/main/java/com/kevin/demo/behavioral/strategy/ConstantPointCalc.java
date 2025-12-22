package com.kevin.demo.behavioral.strategy;

import java.math.BigDecimal;

/**
 * 常量积分计算类 - 策略模式中的具体策略角色(Concrete Strategy)
 * 实现了PointCalc接口，提供固定比例(1:1)的积分计算算法
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class ConstantPointCalc implements PointCalc {

	@Override
	public BigDecimal calc(BigDecimal point) {
		// 固定比例(1:1)计算，直接返回原始积分值
		return point.multiply(BigDecimal.ONE);
	}
	

}
