package com.kevin.demo.behavioral.策略;

import java.math.BigDecimal;

/**
 * 积分计算策略接口 - 策略模式中的抽象策略角色(Strategy)
 * 定义了积分计算的算法接口，具体的计算逻辑由实现类提供
 * 
 * 策略模式(Strategy Pattern)：定义一系列算法，将每个算法封装起来，并使它们可以相互替换
 * 策略模式让算法独立于使用它的客户而变化
 * 
 * @author Kevin
 * @since 1.0.0
 */
public interface PointCalc {

	/**
	 * 计算积分
	 * 
	 * @param point 原始积分值
	 * @return 计算后的积分值
	 */
	public BigDecimal calc(BigDecimal point);
	
}