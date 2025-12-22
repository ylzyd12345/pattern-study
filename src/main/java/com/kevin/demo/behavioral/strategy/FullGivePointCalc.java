package com.kevin.demo.behavioral.strategy;

import java.math.BigDecimal;

/**
 * 满额赠送积分计算类 - 策略模式中的具体策略角色(Concrete Strategy)
 * 实现了PointCalc接口，提供满额赠送的积分计算算法
 * <p>
 * 业务规则：
 * - 当积分超过10000时，赠送10倍积分
 * - 否则，返回原始积分
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class FullGivePointCalc implements PointCalc {

	@Override
	public BigDecimal calc(BigDecimal point) {
		// 业务规则：积分超过10000时赠送10倍积分，否则返回原始积分
		if (point.compareTo(BigDecimal.valueOf(10000.0)) > 0) {
			return BigDecimal.TEN;
		}
		return BigDecimal.ONE;
	}
	

}
