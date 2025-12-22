package com.kevin.demo.behavioral.策略.spring;

import com.kevin.demo.behavioral.策略.PointCalc;

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
    
    /**
     * 计算积分
     * <p>
     * 满减积分策略：满100积分送50积分
     * 
     * @param point 原始积分值
     * @return 计算后的积分值
     */
    @Override
    public BigDecimal calc(BigDecimal point) {
        System.out.println("使用Spring满减积分计算策略");
        if (point.compareTo(new BigDecimal("100")) >= 0) {
            return point.add(new BigDecimal("50"));
        }
        return point;
    }
}