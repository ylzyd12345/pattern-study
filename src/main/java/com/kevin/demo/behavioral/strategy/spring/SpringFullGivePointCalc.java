package com.kevin.demo.behavioral.strategy.spring;

import com.kevin.demo.behavioral.strategy.PointCalc;

import java.math.BigDecimal;

/**
 * 满减积分计算策略
 * <p>
 * 策略模式(Strategy Pattern)示例实现
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class SpringFullGivePointCalc implements PointCalc {
    
    @Override
    public BigDecimal calc(BigDecimal point) {
        System.out.println("使用Spring满减积分计算策略");
        if (point.compareTo(new BigDecimal("100")) >= 0) {
            return point.add(new BigDecimal("50"));
        }
        return point;
    }
}
